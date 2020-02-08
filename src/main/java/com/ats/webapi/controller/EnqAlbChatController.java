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

import com.ats.webapi.model.album.Album;
import com.ats.webapi.model.alenqchat.AlbumEnqChat;
import com.ats.webapi.repository.alenqchatrepo.AlbumEnqChatRepo;

/*@Author -Sachin
Date 08-02-2020*/

@RestController
public class EnqAlbChatController {
//This work for App: Gfpl Enq App
	@Autowired AlbumEnqChatRepo albumEnqChatRepo;
	
	// Save Album Enq Chat

	//// Get Album Enq Chat
	
	@RequestMapping(value = { "/getAlbEnqChatList" }, method = RequestMethod.POST)
	public @ResponseBody List<AlbumEnqChat> getAlbumList(@RequestParam int enqNo,@RequestParam int albEnqChatId) {

		List<AlbumEnqChat> albumList = new ArrayList<>();

		try {

			albumList = albumEnqChatRepo.findByalbEnqChatIdAndEnqNo(albEnqChatId, enqNo);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return albumList;

	}
	
	@RequestMapping(value = { "/saveAlbEnqChat" }, method = RequestMethod.POST)
	public @ResponseBody AlbumEnqChat saveAlbEnqChat(@RequestBody AlbumEnqChat albumEnqChat) {


		AlbumEnqChat res = new AlbumEnqChat();

		try {

			res =albumEnqChatRepo.save(albumEnqChat);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;
	}

}
