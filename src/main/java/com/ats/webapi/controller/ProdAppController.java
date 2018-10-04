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
import com.ats.webapi.model.Item;
import com.ats.webapi.model.prodapp.ProdAppUser;
import com.ats.webapi.model.prodapp.GetRegSpCakeOrderForProdApp;
import com.ats.webapi.model.prodapp.GetSpCakeOrderForProdApp;
import com.ats.webapi.model.prodapp.TRegSpCakeSup;
import com.ats.webapi.model.prodapp.TSpCakeSup;
import com.ats.webapi.model.spprod.GetEmployeeList;
import com.ats.webapi.repository.prodapp.GetRegSpCakeOrderForProdAppRepo;
import com.ats.webapi.repository.prodapp.MenusRepo;
import com.ats.webapi.repository.prodapp.ProdAppUserRepo;
import com.ats.webapi.repository.prodapp.SpCakeForProdAppRepo;
import com.ats.webapi.repository.prodapp.TRegSpCakeSupRepo;
import com.ats.webapi.repository.prodapp.TSpCakeSupRepo;
import com.ats.webapi.service.ItemService;
import com.ats.webapi.service.MenuService;
import com.ats.webapi.service.spprod.SpProdService;

@RestController
public class ProdAppController {

	@Autowired
	ProdAppUserRepo prodAppUserRepo;
	
	@Autowired
	MenusRepo menusRepo;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	TSpCakeSupRepo tSpCakeSupRepo;
	
	@Autowired
	TRegSpCakeSupRepo tRegSpCakeSupRepo;


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

	@RequestMapping(value = { "/addTSpCakeSup" }, method = RequestMethod.POST)
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
	
	@RequestMapping(value = { "/addTRegSpCakeSup" }, method = RequestMethod.POST)
	public @ResponseBody TRegSpCakeSup addTSpCakeSup(@RequestBody TRegSpCakeSup regSpCakeSup) {

		TRegSpCakeSup response = new TRegSpCakeSup();
		try {

			response = tRegSpCakeSupRepo.save(regSpCakeSup);

		} catch (Exception e) {

			System.out.println("Exce in addTRegSpCakeSup Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}
		return response;

	}
	
	@RequestMapping(value = { "/startSpCakeProd" }, method = RequestMethod.POST)
	public @ResponseBody Info startSpCakeProd(@RequestParam("startTimeStamp") Long startTimeStamp,@RequestParam("tSpCakeSupNo") int tSpCakeSupNo,
			@RequestParam("status") int status) {

		Info info=new Info();
		
		int response=0;
		
		try {

			 response = tSpCakeSupRepo.startProdByApp(startTimeStamp, tSpCakeSupNo, status);
			 
			 if(response>0) {
				 
				 info.setError(false);
				 info.setMessage("sp cake prod started successfully");
			 }
			 else {
				 
				 info.setError(true);
				 info.setMessage("failed to start sp cake prod");
				 
			 }

		} catch (Exception e) {

			System.out.println("Exce in startSpCakeProd Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}
	
		return info;

	}
	
	
	@RequestMapping(value = { "/endSpCakeProd" }, method = RequestMethod.POST)
	public @ResponseBody Info endSpCakeProd(@RequestParam("endTimeStamp") Long endTimeStamp,
			@RequestParam("inputKgProd") float inputKgProd,
					@RequestParam("photo1") String photo1,
							@RequestParam("photo2") String photo2,
			@RequestParam("tSpCakeSupNo") int tSpCakeSupNo,
			
			@RequestParam("mistryId") int mistryId,
			@RequestParam("mistryName") String mistryName,
			@RequestParam("isCharUsed") String isCharUsed,
			
			@RequestParam("status") int status) {

		Info info=new Info();
		
		int response=0;
		
		try {

			 response = tSpCakeSupRepo.endProdByApp(endTimeStamp, inputKgProd, status, photo1, photo2, mistryId, mistryName,isCharUsed, tSpCakeSupNo);
			 
			 if(response>0) {
				 
				 info.setError(false);
				 info.setMessage("sp cake endSpCakeProd  successfull");
			 }
			 else {
				 
				 info.setError(true);
				 info.setMessage("failed to endSpCakeProd");
				 
			 }

		} catch (Exception e) {

			System.out.println("Exce in endSpCakeProd Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}
	
		return info;

	}
	
	
	
	@RequestMapping(value = { "/startRegSpCakeProd" }, method = RequestMethod.POST)
	public @ResponseBody Info startRegSpCakeProd(@RequestParam("startTimeStamp") Long startTimeStamp,@RequestParam("supId") int supId,
			@RequestParam("status") int status) {

		Info info=new Info();
		
		int response=0;
		
		try {

			 response = tRegSpCakeSupRepo.startRegSpCakeProdByApp(startTimeStamp, supId, status);
			 
			 if(response>0) {
				 
				 info.setError(false);
				 info.setMessage(" reg sp cake prod started successfully");
			 }
			 else {
				 
				 info.setError(true);
				 info.setMessage("failed to start reg sp cake prod");
				 
			 }

		} catch (Exception e) {

			System.out.println("Exce in startSpCakeProd Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}
	
		return info;

	}
	
	
	@RequestMapping(value = { "/endRegSpCakeProd" }, method = RequestMethod.POST)
	public @ResponseBody Info endRegSpCakeProd(@RequestParam("enTime") Long endTime,
			@RequestParam("inputKgProd") float inputKgProd,
					@RequestParam("photo1") String photo1,
							@RequestParam("photo2") String photo2,
			@RequestParam("supId") int supId,
			
			@RequestParam("mistryId") int mistryId,
			@RequestParam("mistryName") String mistryName,
			@RequestParam("isCharUsed") String isCharUsed,
			
			@RequestParam("status") int status) {

		Info info=new Info();
		
		int response=0;
		
		try {

			 response = tRegSpCakeSupRepo.endRegSpCakeProdByApp(endTime, inputKgProd, status, photo1, photo2, mistryId, mistryName, isCharUsed, supId);
			 
			 if(response>0) {
				 
				 info.setError(false);
				 info.setMessage("sp cake endRegSpCakeProd  successfull");
			 }
			 else {
				 
				 info.setError(true);
				 info.setMessage("failed to endRegSpCakeProd");
				 
			 }

		} catch (Exception e) {

			System.out.println("Exce in endRegSpCakeProd Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}
	
		return info;

	}
	
	@Autowired
	SpCakeForProdAppRepo getSpCakeForProdAppRepo;
	
	@RequestMapping(value = { "/getSpCakeOrdersForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSpCakeOrderForProdApp> getSpCakeOrdersForApp(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("menuIdList") List<Integer> menuIdList,
			@RequestParam("isSlotUsed") List<Integer> isSlotUsed,@RequestParam("isOrderBy") int isOrderBy){

		List<GetSpCakeOrderForProdApp> spCakeOrdList = new ArrayList<GetSpCakeOrderForProdApp>();
		try {
			System.err.println( "For  getSpCakeOrdersForApp // menuId List " +menuIdList.toString() + "order By " +isOrderBy);
			
			if(menuIdList.contains(-1) && isOrderBy==0) {
				System.err.println( "A] menuId -1 and order by 0 ");
				
				
				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderForProdGenAllMenu(fromDate, toDate,  isSlotUsed);

				
			}
			else if(menuIdList.contains(-1) && isOrderBy==1) {
				
				System.err.println(" B] menuId -1 and order by 1 ");
				
				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderForProdOrderByAndAllMenu(fromDate, toDate,  isSlotUsed);
				
			}
			
			else if(isOrderBy==0) {
				System.err.println(" C] specific menu and order by 0 ");
				
				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderForProdGen(fromDate, toDate, menuIdList, isSlotUsed);

				
			}else {
				
				System.err.println(" D] specific menu and order by 1 ");
				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderForProdOrderBy(fromDate, toDate, menuIdList, isSlotUsed);

			}
			


		} catch (Exception e) {

			System.out.println("Exce in getSpCakeOrdersForApp Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return spCakeOrdList;

	}

	@Autowired
	GetRegSpCakeOrderForProdAppRepo getRegSpCakeOrderForProdAppRepo;
	
	@RequestMapping(value = { "/geRegSpCakeOrdersForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRegSpCakeOrderForProdApp> geRegtSpCakeOrdersForApp(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("menuIdList") List<Integer> menuIdList,
			@RequestParam("isOrderBy") int isOrderBy){

		List<GetRegSpCakeOrderForProdApp> regSpCakeOrderList = new ArrayList<GetRegSpCakeOrderForProdApp>();
		try {
			System.err.println( "For  getSpCakeOrdersForApp // menuId List " +menuIdList.toString() + "order By " +isOrderBy);
			
			if(menuIdList.contains(-1) && isOrderBy==0) {
				System.err.println( "A] menuId -1 and order by 0 ");
				
				
				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderForProdGenAllMenu(fromDate,toDate);

				
			}
			else if(menuIdList.contains(-1) && isOrderBy==1) {
				
				System.err.println(" B] menuId -1 and order by 1 ");
				
				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderForProdOrderByAndAllMenu(fromDate, toDate);
				
			}
			
			else if(isOrderBy==0) {
				System.err.println(" C] specific menu and order by 0 ");
				
				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderForProdGen(fromDate, toDate, menuIdList);

				
			}else {
				
				System.err.println(" D] specific menu and order by 1 ");
				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderForProdOrderBy(fromDate, toDate, menuIdList);

			}
			


		} catch (Exception e) {

			System.out.println("Exce in geRegSpCakeOrdersForApp Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return regSpCakeOrderList;

	}

	@Autowired
	 SpProdService spProdService;
	
	// ---------------------------Getting Employee List-------------------------
		@RequestMapping(value = { "/getAllMistryByType" }, method = RequestMethod.POST)
		public @ResponseBody GetEmployeeList getEmployeesByType(@RequestParam("empType") int empType) {

			GetEmployeeList employeeList = spProdService.getEmployeesByType(empType);

			return employeeList;

		}

		
		@Autowired
		private ItemService itemService;

		// Get Items existing in web service just renamed from rest api
		@RequestMapping(value = "/getItemsByCatIdForProdApp", method = RequestMethod.POST)
		public @ResponseBody List<Item> getItems(@RequestParam String itemGrp1) {

			List<Item> items = itemService.findFrItems(itemGrp1);
			return items;

		}
}
