package com.ats.webapi.component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.AlbumEnquiry;
import com.ats.webapi.model.EnquiryScheduleEmpToken;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.ShopAnivData;
import com.ats.webapi.repository.AlbumEnquiryRepo;
import com.ats.webapi.repository.EnquiryScheduleEmpTokenRepo;
import com.ats.webapi.repository.FrAniversaryRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.FranchiseeRepository;

@Component
public class ScheduleTask {

	@Autowired
	FranchiseSupRepository franchiseSupRepository;

	@Autowired
	FrAniversaryRepository frAniversaryRepository;

	@Autowired
	AlbumEnquiryRepo albumEnquiryRepo;

	@Autowired
	EnquiryScheduleEmpTokenRepo enquiryScheduleEmpTokenRepo;
	
	  @Autowired
	    FranchiseeRepository franchiseeRepository;

	private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Scheduled(cron = "0 0 7 * * *")
	public void scheduleTaskWithCronExpression() {
		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		List<String> frTokens = franchiseSupRepository.findTokensByBirthdate(new Date());
		logger.info("frTokens" + frTokens);
		List<ShopAnivData> frOPTokens = frAniversaryRepository.findTokensByFrOpeningDate(new Date());
		logger.info("frOPTokens" + frOPTokens);
		// -----------------------For Notification-----------------

		if (!frTokens.isEmpty()) {

			try {
				for (String token : frTokens) {
					Firebase.sendPushNotifForCommunication(token, "HAPPY BIRTHDAY",
							"Team Monginis wishes you a very happy birthday and many many happy returns of the day.",
							"inbox");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		if (!frOPTokens.isEmpty()) {

			try {
				for (ShopAnivData token : frOPTokens) {
					Firebase.sendPushNotifForCommunication(token.getToken(), "Shop Anniversary",
							"Congratulations on successful completion of " + token.getNoOfYears()
									+ "years with Monginis. Thank you for being part of our family. Team Monginis",
							"inbox");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		// -----------------------------------------------------
	}

	@Scheduled(cron = "0 0 6 1 * ?")
	public void scheduleTaskWithCronExpressionOnMonthStart() {
		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		List<String> frTokens = franchiseSupRepository.findTokens();

		if (!frTokens.isEmpty()) {

			try {
				for (String token : frTokens) {
					Firebase.sendPushNotifForCommunication(token, "Close Your Month",
							"Since today is first day of the month, please close the last month in your software.",
							"inbox");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	// second, minute, hour, day of month, month, day(s) of week

	// Anmol-->29-11-2019----->Album_Enquiry_Notification
	@Scheduled(cron = "1 * * * * *")
	public void scheduleTaskAlbumEnquiryNotify() {

		try {

			List<AlbumEnquiry> enqList = albumEnquiryRepo.findByDelStatusAndStatus(0, 0);

			if (enqList != null) {

				//System.err.println("ENQ_LIST ------------- > " + enqList);

				for (int i = 0; i < enqList.size(); i++) {

					AlbumEnquiry enq = enqList.get(i);
					
					Franchisee franchisee=franchiseeRepository.findOne(enq.getFrId());
					String frName="";
					if(enq!=null) {
						frName=franchisee.getFrName();
					}

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");

					Date d1 = sdf.parse(enq.getEnquiryDateTime());
					Date d2 = Calendar.getInstance().getTime();

					//System.err.println("TIME_1 ------ > " + d1.getTime());
					//System.err.println("TIME_2 ------ > " + d2.getTime());

					long difference = d2.getTime() - d1.getTime();
					//System.err.println("TIME_DIFF ------ > " + difference / 60000);

					if ((difference / 60000) <= 2) {

						//System.err.println("------------ <=2 ------  " + difference / 60000);

						List<EnquiryScheduleEmpToken> enqEmpToken = enquiryScheduleEmpTokenRepo
								.getUserTokens("album-emp");
						if (enqEmpToken != null) {

							List<String> tokenList = new ArrayList<>();
							for (int j = 0; j < enqEmpToken.size(); j++) {
								tokenList.add(enqEmpToken.get(j).getToken1());
							}

							new Firebase().send_FCM_NotificationList(tokenList, "Cake enquiry from "+frName+" franchisee",
									"PLease check the enquiry and revert back soon.", "album_enq");
							
							int res=albumEnquiryRepo.updateNotifyStatusByEnqId(enq.getEnquiryNo(),0);
							
						}

					} else if ((difference / 60000) <= 5) {

						//System.err.println("------------ <=5 ------  " + difference / 60000);

						List<String> tokenList = new ArrayList<>();

						List<EnquiryScheduleEmpToken> enqEmpToken = enquiryScheduleEmpTokenRepo
								.getUserTokens("album-emp");
						if (enqEmpToken != null) {

							for (int j = 0; j < enqEmpToken.size(); j++) {
								if (enqEmpToken.get(j).getToken1() != null) {
									tokenList.add(enqEmpToken.get(j).getToken1());
								}
							}
						}

						List<EnquiryScheduleEmpToken> enqSupToken = enquiryScheduleEmpTokenRepo
								.getUserTokens("album-sup");
						if (enqSupToken != null) {

							for (int j = 0; j < enqSupToken.size(); j++) {
								if (enqSupToken.get(j).getToken1() != null) {
									tokenList.add(enqSupToken.get(j).getToken1());
								}
							}
						}

						new Firebase().send_FCM_NotificationList(tokenList, "Cake enquiry from "+frName+" franchisee",
								"PLease check the enquiry and revert back soon.", "album_enq");
						
						int res=albumEnquiryRepo.updateNotifyStatusByEnqId(enq.getEnquiryNo(),1);


					} else {
						//System.err.println("------------ >5 ------  " + difference / 60000);

						List<String> tokenList = new ArrayList<>();

						List<EnquiryScheduleEmpToken> enqEmpToken = enquiryScheduleEmpTokenRepo
								.getUserTokens("album-emp");
						if (enqEmpToken != null) {

							for (int j = 0; j < enqEmpToken.size(); j++) {
								if (enqEmpToken.get(j).getToken1() != null) {
									tokenList.add(enqEmpToken.get(j).getToken1());
								}
							}
						}

						List<EnquiryScheduleEmpToken> enqSupToken = enquiryScheduleEmpTokenRepo
								.getUserTokens("album-sup");
						if (enqSupToken != null) {

							for (int j = 0; j < enqSupToken.size(); j++) {
								if (enqSupToken.get(j).getToken1() != null) {
									tokenList.add(enqSupToken.get(j).getToken1());
								}
							}
						}
						
						List<EnquiryScheduleEmpToken> enqAdminToken = enquiryScheduleEmpTokenRepo
								.getUserTokens("album-admin");
						if (enqAdminToken != null) {

							for (int j = 0; j < enqAdminToken.size(); j++) {
								if (enqAdminToken.get(j).getToken1() != null) {
									tokenList.add(enqAdminToken.get(j).getToken1());
								}
							}
						}

						new Firebase().send_FCM_NotificationList(tokenList, "Cake enquiry from "+frName+" franchisee",
								"PLease check the enquiry and revert back soon.", "album_enq");
						
						int res=albumEnquiryRepo.updateNotifyStatusByEnqId(enq.getEnquiryNo(),2);

						
					}

				}

			}

		} catch (Exception e) {
			System.err.println("ERROR -------------------- > " + e.getMessage());
		}

	}

}
