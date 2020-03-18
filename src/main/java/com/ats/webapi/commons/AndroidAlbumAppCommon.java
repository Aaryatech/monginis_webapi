package com.ats.webapi.commons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.AlbumEnquiry;
import com.ats.webapi.model.ConfigureFranchisee;
import com.ats.webapi.model.EnquiryScheduleEmpToken;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.AlbumEnquiryRepo;
import com.ats.webapi.repository.EnquiryScheduleEmpTokenRepo;
import com.ats.webapi.service.ConfigureFranchiseeService;

@RestController
public class AndroidAlbumAppCommon {
	@Autowired
	AlbumEnquiryRepo albmEnq;
	@Autowired
	EnquiryScheduleEmpTokenRepo enquiryScheduleEmpTokenRepo;
	
	
	public  Info updateAlbumEnquiry(int enqId, int status,String approvedDateTime) {
		
		System.err.println("enqId "+enqId +"status " +status  +"approvedDateTime " +approvedDateTime) ;
		Info info = new Info();
		try {
		int updatedEnq = albmEnq.updateEnquiryStatusByEnqId(enqId, status,approvedDateTime);

		if (updatedEnq != 0) {
			info.setError(false);
			info.setMessage("Updated Successfully");
			
			AlbumEnquiry enq=albmEnq.findByEnquiryNoAndDelStatus(enqId, 0);
			
			if(status==1) {
				
				
				if(enq!=null) {
					if(!enq.getExVar1().isEmpty()) {
						
						List<String> tokenList = new ArrayList<>();
						tokenList.add(enq.getExVar1());
						
						new Firebase().send_FCM_NotificationList(tokenList, enq.getCustName()+" enquiry has Approved",
								"Cake enquiry for "+enq.getCustName()+" has Approved.", "approved");
					}
					
					//start //Sachin 04-03-2020
					
					List<String> strKey = new ArrayList<String>();
					strKey.add("album-emp");
					strKey.add("album-sup");
					strKey.add("album-admin");

					System.err.println("Notif to Factory EMPS");
					for (int a = 0; a < strKey.size(); a++) {
						List<EnquiryScheduleEmpToken> enqEmpToken = enquiryScheduleEmpTokenRepo
								.getUserTokens(strKey.get(a));
						if (enqEmpToken != null) {

							List<String> tokenList = new ArrayList<>();
							for (int j = 0; j < enqEmpToken.size(); j++) {
								tokenList.add(enqEmpToken.get(j).getToken1());
							}
							
							//new Firebase().send_FCM_NotificationList(tokenList, chatRes.getChatBy(), chatStrObj, "chat");
							new Firebase().send_FCM_NotificationList(tokenList, enq.getCustName()+" enquiry has Approved",
									"Cake enquiry for "+enq.getCustName()+" has Approved.", "approved");
						}

					} // end of for Loop
					
					//end //Sachin 04-03-2020
				}
				
			}else if(status==2) {
				
				if(enq!=null) {
					if(!enq.getExVar1().isEmpty()) {
						
						List<String> tokenList = new ArrayList<>();
						tokenList.add(enq.getExVar1());
						
						new Firebase().send_FCM_NotificationList(tokenList, enq.getCustName()+" enquiry has Rejected",
								"Cake enquiry for "+enq.getCustName()+" has Rejected.", "rejected");
					}
				}
				
				//start //Sachin 04-03-2020
				
				List<String> strKey = new ArrayList<String>();
				strKey.add("album-emp");
				strKey.add("album-sup");
				strKey.add("album-admin");

				System.err.println("Notif to Factory EMPS");
				for (int a = 0; a < strKey.size(); a++) {
					List<EnquiryScheduleEmpToken> enqEmpToken = enquiryScheduleEmpTokenRepo
							.getUserTokens(strKey.get(a));
					if (enqEmpToken != null) {

						List<String> tokenList = new ArrayList<>();
						for (int j = 0; j < enqEmpToken.size(); j++) {
							tokenList.add(enqEmpToken.get(j).getToken1());
						}
						
						//new Firebase().send_FCM_NotificationList(tokenList, chatRes.getChatBy(), chatStrObj, "chat");
						new Firebase().send_FCM_NotificationList(tokenList, enq.getCustName()+" enquiry has Rejected",
								"Cake enquiry for "+enq.getCustName()+" has Rejected.", "rejected");
					}

				} // end of for Loop
				
				//end //Sachin 04-03-2020
			}
			
		} else {
			info = new Info();
			info.setError(true);
			info.setMessage("Update Failed");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	//B
	public Info updateAlbumId( int enqId,  int albmId) {
		Info info = new Info();
		int updatedAlbmId = albmEnq.updtAlbmIdByEnqId(enqId, albmId);

		if (updatedAlbmId != 0) {
			info.setError(false);
			info.setMessage("AlbumEnquiry Updated Successfully");
		} else {
			info = new Info();
			info.setError(true);
			info.setMessage("AlbumEnquiry Update Failed");
		}

		return info;
	}
	
	@Autowired
	private ConfigureFranchiseeService connfigureService;

	
	//C
	//@RequestMapping(value = "/getConfigListByFrAndMenu", method = RequestMethod.POST)
	public  List<ConfigureFranchisee> getConfigListByFrAndMenu(  List<Integer> frIds,
			  List<Integer> menuIds) {
		System.err.println("in ws---------- FR " + frIds);
		System.err.println("in ws---------- MENU " + menuIds);

		List<ConfigureFranchisee> resultList = new ArrayList();
		resultList = connfigureService.getDataByFrAndMenu(frIds, menuIds);
		System.err.println("LIST -------------- " + resultList);
		return resultList;

	}

}
