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
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.FranchiseeAndMenuList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Message;
import com.ats.webapi.model.OrderSpecialCake;
import com.ats.webapi.model.SearchSpCakeResponse;
import com.ats.webapi.model.album.Album;
import com.ats.webapi.model.album.AlbumCodeAndName;
import com.ats.webapi.model.album.AlbumRepo;
import com.ats.webapi.model.album.SearchAlbumCakeResponse;
import com.ats.webapi.repository.AlbumCodeAndNameRepo;
import com.ats.webapi.repository.FrItemStockConfigureRepository;
import com.ats.webapi.repository.MenuForAlbumRepo;
import com.ats.webapi.repository.OrderSpCakeRepository;
import com.ats.webapi.repository.UpdateSeetingForPBRepo;
import com.ats.webapi.service.MenuService;
import com.ats.webapi.util.JsonUtil;

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

	// Check Unique code in Item,Sp,Album Sp Master -Sachin 08-02-2020
	@RequestMapping(value = { "/getAlbumCode1" }, method = RequestMethod.POST)
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
		
		
		System.err.println("codeCount"+codeCount);
		return "Sachin";
	}

	@RequestMapping(value = { "/getAlbumCode" }, method = RequestMethod.POST)
	public @ResponseBody String getAlbumCode() {

		int settingValue = frItemStockConfRepo.findBySettingKey("ALBUM_CODE_SR");

		return "" + settingValue;

	}

	@RequestMapping(value = { "/saveAlbum" }, method = RequestMethod.POST)
	public @ResponseBody Album saveAlbum(@RequestBody Album album) {

		System.out.println("albumalbumalbum" + album.toString());

		Album res = new Album();

		try {

			res = albumRepo.save(album);

		} catch (Exception e) {

			e.printStackTrace();

		}
		if (res != null && album.getAlbumId() == 0) {

			int settingValue = frItemStockConfRepo.findBySettingKey("ALBUM_CODE_SR");

			settingValue = settingValue + 1;

			int result = updateSeetingForPBRepo.updateSeetingForPurBill(settingValue, "ALBUM_CODE_SR");
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
	public @ResponseBody List<AllMenus> getMenuForAlbum(@RequestParam("catId") int catId,
			@RequestParam("isSameDay") int isSameDay, @RequestParam("delStatus") int delStatus) {

		List<AllMenus> allMenu = new ArrayList();
		allMenu = menuService.findByCatIdAndIsSameDayAppAndDelStatus(catId, isSameDay, delStatus);

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

}
