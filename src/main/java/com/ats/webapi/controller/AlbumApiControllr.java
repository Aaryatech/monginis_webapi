package com.ats.webapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.AndroidAlbumAppCommon;
import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.AlbumEnquiry;
import com.ats.webapi.model.AllMenus;
import com.ats.webapi.model.ConfigureFranchisee;
import com.ats.webapi.model.EnquiryScheduleEmpToken;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.FranchiseeAndMenuList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Message;
import com.ats.webapi.model.OrderSpecialCake;
import com.ats.webapi.model.SearchSpCakeResponse;
import com.ats.webapi.model.Setting;
import com.ats.webapi.model.User;
import com.ats.webapi.model.album.Album;
import com.ats.webapi.model.album.AlbumCodeAndName;
import com.ats.webapi.model.album.AlbumRepo;
import com.ats.webapi.model.album.SearchAlbumCakeResponse;
import com.ats.webapi.model.communication.Notification;
import com.ats.webapi.repository.AlbumCodeAndNameRepo;
import com.ats.webapi.repository.AlbumEnquiryRepo;
import com.ats.webapi.repository.EnquiryScheduleEmpTokenRepo;
import com.ats.webapi.repository.FrItemStockConfigureRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.MainMenuConfigurationRepository;
import com.ats.webapi.repository.MenuForAlbumRepo;
import com.ats.webapi.repository.OrderSpCakeRepository;
import com.ats.webapi.repository.SettingRepository;
import com.ats.webapi.repository.UpdateSeetingForPBRepo;
import com.ats.webapi.repository.UserRepository;
import com.ats.webapi.repository.communication.NotificationRepository;
import com.ats.webapi.service.ConfigureFranchiseeService;
import com.ats.webapi.service.MenuService;
import com.ats.webapi.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AlbumApiControllr {

	@Autowired
	AlbumRepo albumRepo;

	@Autowired
	private MenuService menuService;

	@Autowired
	OrderSpCakeRepository orderSpCakeRepository;

	@Autowired
	AlbumCodeAndNameRepo albumCodeAndNameRepo;

	@Autowired // added here 3 march Sac here 04-02-2020
	FrItemStockConfigureRepository frItemStockConfRepo;

	@Autowired // added here on 3 march Sac here 04-02-2020
	UpdateSeetingForPBRepo updateSeetingForPBRepo;

	@Autowired
	UserRepository userRepository;

	@Autowired
	FranchiseSupRepository franchiseSupRepository;

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	SettingRepository settingRepository;

	// Check Unique code in Item,Sp,Album Sp Master -Sachin 08-02-2020
	@RequestMapping(value = { "/checkUniqueCode" }, method = RequestMethod.POST)
	public @ResponseBody String checkUniqueCode(@RequestParam String code, @RequestParam int tableId) {
		System.err.println("hiii***");
		int codeCount = 0;
		try {
			if (tableId == 1) {
				codeCount = albumRepo.getCountOfMItemCode(code);
			} else if (tableId == 2) {
				codeCount = albumRepo.getCountOfMSpcakeCode(code);
			} else if (tableId == 3) {
				codeCount = albumRepo.getCountOfTSPCakeAlbCode(code);
			}

			if (codeCount > 0) {
				return "No";
			} else {
				return "Yes";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.err.println("codeCount" + codeCount);
		return "Sachin";
	}

	@RequestMapping(value = { "/getAlbumCode" }, method = RequestMethod.POST)
	public @ResponseBody String getAlbumCode() {

		int settingValue = frItemStockConfRepo.findBySettingKey("ALBUM_CODE_SR");

		return "" + settingValue;

	}

//A
	@Autowired
	private ConfigureFranchiseeService connfigureService;

	@RequestMapping(value = { "/saveAlbum" }, method = RequestMethod.POST)
	public @ResponseBody Album saveAlbum(@RequestBody Album album) {

		Album res = new Album();

		try {
			res = albumRepo.save(album);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (res != null) {

			try {
				int settingValue = frItemStockConfRepo.findBySettingKey("ALBUM_CODE_SR");

				settingValue = settingValue + 1;

				int result = updateSeetingForPBRepo.updateSeetingForPurBill(settingValue, "ALBUM_CODE_SR");

				if (result > 0) {
					List<String> tokenList = new ArrayList<String>();
					tokenList.add(album.getToken());

					new Firebase().send_FCM_NotificationList(tokenList, "  ", " ", "raw");
				}
			} catch (Exception e) {
			}

			try {
				// SEND NOTIFICATION TO ALL

				List<String> usrTokens = userRepository.findTokensNotIn(0);

				List<String> frTokens = franchiseSupRepository.findTokens();

				if (frTokens != null) {
					if (usrTokens != null) {
						if (usrTokens.size() > 0) {
							for (String token : usrTokens) {
								frTokens.add(token);
							}
						}
					}
				}

				SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

				int userId = 1;
				String userName = "GFPL";

				try {
					Setting set = settingRepository.findBySettingId(39);
					userId = set.getSettingValue();

					User user = userRepository.findByIdAndDelStatus(userId, 0);
					userName = user.getUsername();

				} catch (Exception e) {
				}

				Notification notify = new Notification(0, "New cake added to album", userId,
						"New cake added to album with code " + album.getAlbumCode() + " and cake name as "
								+ album.getAlbumName() + ".",
						album.getPhoto1(), new Date(), sdfTime.format(new Date().getTime()), 0);

				Notification notificationRes = notificationRepository.saveAndFlush(notify);

				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(notificationRes);

				for (String token : frTokens) {
					if (token != null) {
						Firebase.sendPushNotifForCommunication(token, notificationRes.getSubject() + "#" + userName,
								jsonStr, "nf");
					}
				}

			} catch (Exception e) {
			}

		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String curDttime = dateFormat.format(cal.getTime());

		try {
			updateAlbumEnquiry(album.getEnqNo(), album.getStatus(), curDttime);// Approve Service

			updateAlbumId(album.getEnqNo(), res.getAlbumId());// update t_album_enquiry
		} catch (Exception e) {
			System.err.println("ex " + e.getMessage());
			e.printStackTrace();
		}

		List<ConfigureFranchisee> confFrList = getConfigListByFrAndMenu(album.getFrIds(), album.getMenuList());

		for (int i = 0; i < confFrList.size(); i++) {

			if (!confFrList.get(i).getItemShow().contains(String.valueOf(res.getAlbumId()))) {

				String menuItem = confFrList.get(i).getItemShow() + "," + res.getAlbumId();

				int result = connfigureService.updateFrConfItems(menuItem, confFrList.get(i).getSettingId());

			}

		}

		return res;

	}

	@RequestMapping(value = { "/getAlbumList" }, method = RequestMethod.GET)
	public @ResponseBody List<Album> getAlbumList() {

		List<Album> albumList = new ArrayList<>();

		try {

			albumList = albumRepo.getAlbumCakeForOPS();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return albumList;

	}

	@RequestMapping(value = { "/getAlbumByAlbumId" }, method = RequestMethod.GET)
	public @ResponseBody Album getAlbumByAlbumId(@RequestParam("albumId") int albumId) {

		Album info = new Album();

		try {

			info = albumRepo.findByAlbumIdAndDelStatus(albumId, 0);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return info;

	}

	@RequestMapping(value = { "/getAlbumsBySpId" }, method = RequestMethod.POST)
	public @ResponseBody List<Album> getAlbumsBySpId(@RequestParam("spId") int spId) {

		System.out.println("spIdspIiiiiiiiiiiiii" + spId);

		List<Album> albumList = new ArrayList<>();

		try {

			albumList = albumRepo.findBySpIdAndDelStatus(spId, 0);

			System.out.println("albumListalbumListalbumList" + albumList.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}
		return albumList;

	}

	@RequestMapping(value = { "/deleteAlbum" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAlbum(@RequestParam("albumId") int albumId) {

		Info info = new Info();

		try {
			int delete = albumRepo.deleteAlbum(albumId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	@Autowired
	MainMenuConfigurationRepository mainMenuConfRepo;

	@RequestMapping(value = { "/getMenuForAlbum" }, method = RequestMethod.POST)
	public @ResponseBody List<AllMenus> getMenuForAlbum(@RequestParam("catId") int catId,
			@RequestParam("isSameDay") int isSameDay, @RequestParam("delStatus") int delStatus) {

		List<AllMenus> allMenu = new ArrayList();
		allMenu = menuService.findByCatIdAndIsSameDayAppAndDelStatus(catId, isSameDay, delStatus);

		return allMenu;
	}

	// Sachin 19-02-2020
	@RequestMapping(value = { "/getMenuForAlbumForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<AllMenus> getMenuForAlbumForApp(@RequestParam("catId") int catId,
			@RequestParam("isSameDay") int isSameDay, @RequestParam("delStatus") int delStatus,
			@RequestParam("frId") int frId) {

		List<AllMenus> allMenu = new ArrayList();
		allMenu = mainMenuConfRepo.findByCatIdAndIsSameDayAppAndDelStatusForApp(catId, isSameDay, delStatus, frId);

		return allMenu;
	}

	// Search Special Cake By album Code
	@RequestMapping(value = { "/searchAlbumByCode" }, method = RequestMethod.POST)
	public @ResponseBody SearchAlbumCakeResponse searchAlbumByCode(@RequestParam("albumCode") String albumCode) {

		OrderSpecialCake specialCake = null;
		Album album = null;
		ErrorMessage errorMessage = new ErrorMessage();
		SearchAlbumCakeResponse searchAlbumCakeResponse = new SearchAlbumCakeResponse();

		System.err.println("ALBUM CODE --------- searchAlbumByCode--------------------------------- " + albumCode);
		System.err.println(
				"ALBUM CODE --------- searchAlbumByCode---------------2------------------ " + albumCode.indexOf('-'));

		String abCode = "";
		if (albumCode.indexOf('-') == -1) {
			abCode = albumCode;
		} else {
			abCode = albumCode.substring(0, albumCode.indexOf('-'));
		}

		System.err.println("ALBUM CODE --------- searchAlbumByCode-------------------NEW-------------- " + abCode);

		try {
			album = albumRepo.findByAlbumCodeAndDelStatus(abCode, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		searchAlbumCakeResponse.setAlbum(album);

		System.err.println("ALBUM --------- searchAlbumByCode--------------------------------- " + album);

		specialCake = orderSpCakeRepository.findBySpId(album.getSpId());
		if (specialCake == null) {
			errorMessage.setError(true);
			errorMessage.setMessage("Special Cake Not Found");
			searchAlbumCakeResponse.setErrorMessage(errorMessage);
		} else {
			errorMessage.setError(false);
			errorMessage.setMessage("Special Cake Found Successfully");
			searchAlbumCakeResponse.setErrorMessage(errorMessage);
			searchAlbumCakeResponse.setSpecialCake(specialCake);
		}

		return searchAlbumCakeResponse;

	}

	@RequestMapping(value = { "/getAlbumCodeAndNameList" }, method = RequestMethod.POST)
	public @ResponseBody List<AlbumCodeAndName> getAlbumCodeAndNameList(@RequestParam("items") List<Integer> items,
			@RequestParam("frId") int frId, @RequestParam("menuId") int menuId) {

		List<AlbumCodeAndName> albumCodeList = new ArrayList();
		albumCodeList = albumCodeAndNameRepo.findAlbumCodeAndName(items, frId, menuId);

		return albumCodeList;
	}

	// Sac new 18-03-2020
	@Autowired
	EnquiryScheduleEmpTokenRepo enquiryScheduleEmpTokenRepo;

	public Info updateAlbumEnquiry(int enqId, int status, String approvedDateTime) {

		System.err.println("enqId " + enqId + "status " + status + "approvedDateTime " + approvedDateTime);
		Info info = new Info();
		try {
			int updatedEnq = albmEnq.updateEnquiryStatusByEnqId(enqId, status, approvedDateTime);

			if (updatedEnq != 0) {
				info.setError(false);
				info.setMessage("Updated Successfully");

				AlbumEnquiry enq = albmEnq.findByEnquiryNoAndDelStatus(enqId, 0);

				if (status == 1) {

					if (enq != null) {
						if (!enq.getExVar1().isEmpty()) {

							List<String> tokenList = new ArrayList<>();
							tokenList.add(enq.getExVar1());

							new Firebase().send_FCM_NotificationList(tokenList,
									enq.getCustName() + " enquiry has Approved",
									"Cake enquiry for " + enq.getCustName() + " has Approved.", "approved");
						}

						// start //Sachin 04-03-2020

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

								// new Firebase().send_FCM_NotificationList(tokenList, chatRes.getChatBy(),
								// chatStrObj, "chat");
								new Firebase().send_FCM_NotificationList(tokenList,
										enq.getCustName() + " enquiry has Approved",
										"Cake enquiry for " + enq.getCustName() + " has Approved.", "approved");
							}

						} // end of for Loop

						// end //Sachin 04-03-2020
					}

				} else if (status == 2) {

					if (enq != null) {
						if (!enq.getExVar1().isEmpty()) {

							List<String> tokenList = new ArrayList<>();
							tokenList.add(enq.getExVar1());

							new Firebase().send_FCM_NotificationList(tokenList,
									enq.getCustName() + " enquiry has Rejected",
									"Cake enquiry for " + enq.getCustName() + " has Rejected.", "rejected");
						}
					}

					// start //Sachin 04-03-2020

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

							// new Firebase().send_FCM_NotificationList(tokenList, chatRes.getChatBy(),
							// chatStrObj, "chat");
							new Firebase().send_FCM_NotificationList(tokenList,
									enq.getCustName() + " enquiry has Rejected",
									"Cake enquiry for " + enq.getCustName() + " has Rejected.", "rejected");
						}

					} // end of for Loop

					// end //Sachin 04-03-2020
				}

			} else {
				info = new Info();
				info.setError(true);
				info.setMessage("Update Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@Autowired
	AlbumEnquiryRepo albmEnq;

	// B
	public Info updateAlbumId(int enqId, int albmId) {
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

	// C
	// @RequestMapping(value = "/getConfigListByFrAndMenu", method =
	// RequestMethod.POST)
	public List<ConfigureFranchisee> getConfigListByFrAndMenu(List<Integer> frIds, List<Integer> menuIds) {
		System.err.println("in ws---------- FR " + frIds);
		System.err.println("in ws---------- MENU " + menuIds);

		List<ConfigureFranchisee> resultList = new ArrayList();
		resultList = connfigureService.getDataByFrAndMenu(frIds, menuIds);
		System.err.println("LIST -------------- " + resultList);
		return resultList;

	}

	// 21-10-2020
	@RequestMapping(value = { "/getAllAlbumName" }, method = RequestMethod.GET)
	public @ResponseBody List<Album> getAllAlbumName() {

		List<Album> albumList = new ArrayList<>();

		try {

			albumList = albumRepo.getAllAlbumName();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return albumList;

	}

}