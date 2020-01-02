package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.AlbumEnquiry;
import com.ats.webapi.model.EnquiryScheduleEmpToken;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.album.Album;
import com.ats.webapi.repository.AlbumEnquiryRepo;
import com.ats.webapi.repository.EnquiryScheduleEmpTokenRepo;
import com.ats.webapi.repository.FranchiseeRepository;

@RestController
public class EnquiryController {

	@Autowired
	AlbumEnquiryRepo albmEnq;
	
	@Autowired
	EnquiryScheduleEmpTokenRepo enquiryScheduleEmpTokenRepo;
	
	

	// --Get all AlbumEnquiry--
	@GetMapping("/getAllEnquiry")
	public List<AlbumEnquiry> getAllPurposesWithName() {
		return albmEnq.findByDelStatus(0);
	}

	// --Save new AlbumEnquiry--
	@PostMapping("/saveAlbumEnquiry")
	public AlbumEnquiry saveAlbumEnquiry(@RequestBody AlbumEnquiry enq) {

		AlbumEnquiry res = albmEnq.save(enq);

		if (res != null) {

			List<EnquiryScheduleEmpToken> enqEmpToken = enquiryScheduleEmpTokenRepo.getUserTokens("album-emp");
			if (enqEmpToken != null) {

				List<String> tokenList = new ArrayList<>();
				for (int j = 0; j < enqEmpToken.size(); j++) {
					tokenList.add(enqEmpToken.get(j).getToken1());
				}

				new Firebase().send_FCM_NotificationList(tokenList, "Cake enquiry from franchisee",
						"PLease check the enquiry and revert back soon.", "album_enq");

			}
		}

		return res;
	}

	// --Get AlbumEnquiry By Id--
	@PostMapping("/getEnquiryById")
	public AlbumEnquiry getEnquiryById(@RequestParam int enqNo) {
		return albmEnq.findByEnquiryNoAndDelStatus(enqNo, 0);
	}

	// --deleteAlbumEnquiry--
	@PostMapping("/deleteAlbumEnquiry")
	public Info deleteAlbumEnquiry(@RequestParam int enqNo) {
		Info info = null;

		AlbumEnquiry albm = albmEnq.findByEnquiryNo(enqNo);

		if (albm != null) {
			albm.setDelStatus(1);
			AlbumEnquiry updatedAlbmEnq = albmEnq.save(albm);
			info = new Info();
			info.setError(false);
			info.setMessage("AlbumEnquiry Deleted Successfully");
		} else {
			info = new Info();
			info.setError(true);
			info.setMessage("AlbumEnquiry Deletion Failed");
		}
		return info;
	}

	// --Update AlbumId--
	@PostMapping("/updateAlbumId")
	public Info saveAlbumEnquiry(@RequestParam int enqId, @RequestParam(value = "albmId") int albmId) {
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

	@RequestMapping(value = { "/getFrnchseEnqAlbmInfo" }, method = RequestMethod.GET)
	public @ResponseBody List<AlbumEnquiry> getFrnchseEnqAlbmInfo() {

		List<AlbumEnquiry> albumList = new ArrayList<>();

		try {

			albumList = albmEnq.getAlbmFrDetail();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return albumList;

	}

	// Anmol-->27-11-2019---
	@RequestMapping(value = { "/getFrnchseEnqAlbmInfoByDate" }, method = RequestMethod.GET)
	public @ResponseBody List<AlbumEnquiry> getFrnchseEnqAlbmInfoByDate(
			@RequestParam(value = "fromDate") String fromDate, @RequestParam(value = "toDate") String toDate) {

		List<AlbumEnquiry> albumList = new ArrayList<>();

		try {

			albumList = albmEnq.getAlbmFrDetailByDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return albumList;

	}
	
	
	// --Update AlbumId--
		@PostMapping("/updateAlbumEnquiry")
		public Info updateAlbumEnquiry(@RequestParam(value = "enqId") int enqId, @RequestParam(value = "status") int status) {
			Info info = new Info();
			int updatedEnq = albmEnq.updateEnquiryStatusByEnqId(enqId, status);

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
									"Cake enquiry for "+enq.getCustName()+" has Approved.", "album_enq");
						}
					}
					
				}else if(status==2) {
					
					if(enq!=null) {
						if(!enq.getExVar1().isEmpty()) {
							
							List<String> tokenList = new ArrayList<>();
							tokenList.add(enq.getExVar1());
							
							new Firebase().send_FCM_NotificationList(tokenList, enq.getCustName()+" enquiry has Rejected",
									"Cake enquiry for "+enq.getCustName()+" has Rejected.", "album_enq");
						}
					}
					
				}
				
			} else {
				info = new Info();
				info.setError(true);
				info.setMessage("Update Failed");
			}

			return info;
		}

}
