package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.AllMenus;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.FranchiseeAndMenuList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Message;
import com.ats.webapi.model.album.Album;
import com.ats.webapi.model.album.AlbumRepo;
import com.ats.webapi.service.MenuService;
import com.ats.webapi.util.JsonUtil;

@RestController
public class AlbumApiControllr {

	@Autowired
	AlbumRepo albumRepo;
	
	@Autowired
	private MenuService menuService;

	@RequestMapping(value = { "/saveAlbum" }, method = RequestMethod.POST)
	public @ResponseBody Album saveAlbum(@RequestBody Album album) {

		System.out.println("albumalbumalbum" + album.toString());

		Album res = new Album();

		try {

			res = albumRepo.save(album);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAlbumList" }, method = RequestMethod.GET)
	public @ResponseBody List<Album> getAlbumList() {

		List<Album> albumList = new ArrayList<>();

		try {

			albumList = albumRepo.findByDelStatus(0);

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
	
	
	
	@RequestMapping(value = { "/getMenuForAlbum" }, method = RequestMethod.POST)
	public @ResponseBody List<AllMenus> getMenuForAlbum(@RequestParam("catId") int catId,@RequestParam("isSameDay") int isSameDay,@RequestParam("delStatus") int delStatus) {

		List<AllMenus> allMenu =new ArrayList(); 
		allMenu=menuService.findByCatIdAndIsSameDayAppAndDelStatus(catId,isSameDay,delStatus);

		return allMenu;
	}
	
	

}
