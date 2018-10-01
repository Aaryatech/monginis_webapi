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
import com.ats.webapi.model.Info;
import com.ats.webapi.model.prodapp.ProdAppUser;
import com.ats.webapi.model.prodapp.TSpCakeSup;
import com.ats.webapi.repository.prodapp.MenusRepo;
import com.ats.webapi.repository.prodapp.ProdAppUserRepo;
import com.ats.webapi.repository.prodapp.TSpCakeSupRepo;
import com.ats.webapi.service.MenuService;

@RestController
public class ProdAppController {

	@Autowired
	ProdAppUserRepo prodAppUserRepo;
	
	@Autowired
	MenusRepo menusRepo;
	
	@Autowired
	private MenuService menuService;


	@RequestMapping(value = { "/addProdAppUser" }, method = RequestMethod.POST)
	public @ResponseBody ProdAppUser addProdAppUser(@RequestBody ProdAppUser appUser) {

		ProdAppUser response = new ProdAppUser();
		try {

			List<ProdAppUser> existingUserList = prodAppUserRepo.findByuMobNoAndDelStatus(appUser.getuMobNo(), 0);

			if (existingUserList.size() == 0)
				response = prodAppUserRepo.save(appUser);
			if (response.getUserId() == 0) {

				System.err.println("mob no already exist");
			}

		} catch (Exception e) {

			System.out.println("Exce in addProdAppUser Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/loginProdAppUser" }, method = RequestMethod.POST)
	public @ResponseBody ProdAppUser loginProdApp(@RequestParam("uMobNo") String uMobNo,
			@RequestParam("uPass") String uPass) {

		ProdAppUser response = new ProdAppUser();
		try {

			response = prodAppUserRepo.findByUMobNoAndUPass(uMobNo, uPass);

		} catch (Exception e) {

			System.out.println("Exce in loginProdAppUser Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/getAllProdAppUser" }, method = RequestMethod.GET)
	public @ResponseBody List<ProdAppUser> getAllProdAppUser() {

		List<ProdAppUser> prodAppUsrList = new ArrayList<ProdAppUser>();
		try {

			prodAppUsrList = prodAppUserRepo.findBydelStatus(0);

		} catch (Exception e) {

			System.out.println("Exce in getAllProdAppUser Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return prodAppUsrList;

	}

	@RequestMapping(value = { "/getProdAppUserByUId" }, method = RequestMethod.POST)
	public @ResponseBody ProdAppUser getProdAppUserByUId(@RequestParam("userId") int userId) {

		ProdAppUser response = new ProdAppUser();
		try {

			response = prodAppUserRepo.findByUserId(userId);

		} catch (Exception e) {

			System.out.println("Exce in getProdAppUserByUId Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/updateDeviceToken" }, method = RequestMethod.POST)
	public @ResponseBody Info updateDeviceToken(@RequestParam("userId") int userId,
			@RequestParam("uDeviceToken") int uDeviceToken) {

		Info info = new Info();
		try {

			int output = prodAppUserRepo.updateDeviceToken(uDeviceToken, userId);

			if (output > 0) {
				info.setError(true);
				info.setMessage("Device token update failed");
			} else {
				info.setError(false);
				info.setMessage("Device token update success");
			}

		} catch (Exception e) {

			System.out.println("Exce in updateDeviceToken Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/deleteProdAppUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProdAppUser(@RequestParam("userId") int userId) {

		Info info = new Info();
		try {

			int output = prodAppUserRepo.deleteUser(userId);

			if (output > 0) {
				info.setError(true);
				info.setMessage("deleteProdAppUser failed");
			} else {
				info.setError(false);
				info.setMessage("deleteProdAppUser success");
			}

		} catch (Exception e) {

			System.out.println("Exce in deleteProdAppUser Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/changePass" }, method = RequestMethod.POST)
	public @ResponseBody Info changePass(@RequestParam("userId") int userId, @RequestParam("oldPass") String oldPass,
			@RequestParam("uPass") String uPass) {

		Info info = new Info();
		try {

			ProdAppUser user = prodAppUserRepo.findByUserId(userId);

			if (user.getuPass().equals(oldPass));
			
			int output = prodAppUserRepo.changePass(uPass, userId);

			if (output > 0) {
				info.setError(true);
				info.setMessage("password update failed");
			} else {
				info.setError(false);
				info.setMessage("password update success");
			}

		} catch (Exception e) {

			System.out.println("Exce in changePass Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return info;

	}
	
	
	
	
	@RequestMapping(value = { "/getMenusByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<AllMenus> getMenusByCatId(@RequestParam("catId") int catId, @RequestParam("isSameDayApp") int isSameDayApp) {

		List<AllMenus> menuList = new ArrayList<AllMenus>();
		try {

			menuList = menuService.findByCatIdAndIsSameDayApp(catId, isSameDayApp);

		} catch (Exception e) {

			System.out.println("Exce in getMenusByCatId Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return menuList;

	}
	
	

	@Autowired
	TSpCakeSupRepo tSpCakeSupRepo;

	@RequestMapping(value = { "/addTSpCake" }, method = RequestMethod.POST)
	public @ResponseBody TSpCakeSup addTSpCakeSup(@RequestBody TSpCakeSup tSpCakeSup) {

		TSpCakeSup response = new TSpCakeSup();
		try {

			response = tSpCakeSupRepo.save(tSpCakeSup);

		} catch (Exception e) {

			System.out.println("Exce in addTSpCake Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}
		return response;

	}
}
