package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.ats.webapi.model.alenqchat.AlbumEnqChat;
import com.ats.webapi.repository.AlbumEnquiryRepo;
import com.ats.webapi.repository.EnquiryScheduleEmpTokenRepo;
import com.ats.webapi.repository.alenqchatrepo.AlbumEnqChatRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

/*@Author -Sachin
Date 08-02-2020*/

@RestController
public class EnqAlbChatController {
//This work for App: Gfpl Enq App
	@Autowired
	AlbumEnqChatRepo albumEnqChatRepo;

	// Save Album Enq Chat

	//// Get Album Enq Chat

	@RequestMapping(value = { "/getAlbEnqChatList" }, method = RequestMethod.POST)
	public @ResponseBody List<AlbumEnqChat> getAlbumList(@RequestParam int frId, @RequestParam int albEnqChatId) {

		List<AlbumEnqChat> albumList = new ArrayList<>();

		try {

			if (frId > 0) {
				albumList = albumEnqChatRepo.getChatListSpecFr(albEnqChatId, frId);
			} else {
				albumList = albumEnqChatRepo.getChatListAllFr(albEnqChatId);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return albumList;

	}

	@Autowired
	EnquiryScheduleEmpTokenRepo enquiryScheduleEmpTokenRepo;
	@Autowired
	AlbumEnquiryRepo albmEnq;

	@RequestMapping(value = { "/saveAlbEnqChat" }, method = RequestMethod.POST)
	public @ResponseBody AlbumEnqChat saveAlbEnqChat(@RequestBody AlbumEnqChat albumEnqChat) {

		AlbumEnqChat chatRes = new AlbumEnqChat();
		System.err.println("Req Body albumEnqChat " + albumEnqChat.toString());
		try {

			chatRes = albumEnqChatRepo.save(albumEnqChat);
			
			ObjectMapper objMapper=new ObjectMapper();
			String chatStrObj=objMapper.writeValueAsString(chatRes);
			
			
			// chat type: 1 fr, 0 Admin
			if (chatRes.getChatType() == 1) {

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
						
						new Firebase().send_FCM_NotificationList(tokenList, chatRes.getChatBy(), chatStrObj, "chat");

					}

				} // end of for Loop

			} else {
				System.err.println("Notif to Franchise ");

				AlbumEnquiry enq = albmEnq.findByEnquiryNoAndDelStatus(chatRes.getEnqNo(), 0);

				if (enq != null) {
					if (!enq.getExVar1().isEmpty()) {

						List<String> tokenList = new ArrayList<>();
						tokenList.add(enq.getExVar1());

						new Firebase().send_FCM_NotificationList(tokenList, chatRes.getChatBy(), chatStrObj, "chat");
					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return chatRes;
	}

	@RequestMapping(value = { "/updateAlbmTokenForFr" }, method = RequestMethod.POST)
	public @ResponseBody Info updtAlbmTokenForFr(@RequestParam String token, @RequestParam int frId) {
		Info info = new Info();
		int response = 0;
		try {

			response = albmEnq.updtAlbmTokenForFrLogin(token, frId);
			if (response > 0) {
				info.setError(false);
				info.setMessage("success");
			} else {
				info.setError(true);
				info.setMessage("failure");
			}
		} catch (Exception e) {
			info.setError(true);
			info.setMessage("exception");
			System.err.println("exce at updateAlbmTokenForFr");
		}
		return info;

	}

	@RequestMapping(value = { "/sendNotif" }, method = RequestMethod.POST)
	public @ResponseBody String updtAlbmTokenForFr(@RequestParam List<String> token) {

		new Firebase().send_FCM_NotificationList(token, "JAVA" + " enquiry has Rejected",
				"Cake enquiry for   has Rejected.", "album_enq");
		return "OK";
	}
}
