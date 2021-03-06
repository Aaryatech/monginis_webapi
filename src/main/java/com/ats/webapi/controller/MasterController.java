package com.ats.webapi.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.CategoryList;
import com.ats.webapi.model.ConfigureFranchisee;
import com.ats.webapi.model.FrListForSupp;
import com.ats.webapi.model.FrTarget;
import com.ats.webapi.model.FrTargetList;
import com.ats.webapi.model.FrTotalSale;
import com.ats.webapi.model.FranchiseSup;
import com.ats.webapi.model.FranchiseSupList;
import com.ats.webapi.model.GetItemSup;
import com.ats.webapi.model.GetRegSpCakeOrders;
import com.ats.webapi.model.GetSpCkSupplement;
import com.ats.webapi.model.GetSpCkSupplementCat;
import com.ats.webapi.model.GetSubCategory;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.ItemIdOnly;
import com.ats.webapi.model.ItemSup;
import com.ats.webapi.model.ItemSupList;
import com.ats.webapi.model.MenuOrderLimit;
import com.ats.webapi.model.MenuWiseLimitDisplay;
import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.RegularSpCkOrders;
import com.ats.webapi.model.Setting;
import com.ats.webapi.model.SettingNew;
import com.ats.webapi.model.SpCake;
import com.ats.webapi.model.SpCakeSupplement;
import com.ats.webapi.model.SpCakeSupplementCat;
import com.ats.webapi.model.SubCatWiseLimit;
import com.ats.webapi.model.SubCategory;
import com.ats.webapi.model.SubCategory2;
import com.ats.webapi.model.tally.FranchiseeList;
import com.ats.webapi.model.tray.TrayType;
import com.ats.webapi.repository.ConfigureFrRepository;
import com.ats.webapi.repository.FrListForSuppRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.FranchiseeRepository;
import com.ats.webapi.repository.GetItemSupRepository;
import com.ats.webapi.repository.GetSubCategoryRepository;
import com.ats.webapi.repository.ItemIdOnlyRepository;
import com.ats.webapi.repository.ItemRepository;
import com.ats.webapi.repository.MenuOrderLimitRepo;
import com.ats.webapi.repository.OrderRepository;
import com.ats.webapi.repository.PostFrOpStockDetailRepository;
import com.ats.webapi.repository.PostFrOpStockHeaderRepository;
import com.ats.webapi.repository.SettingNewRepository;
import com.ats.webapi.repository.SettingRepository;
import com.ats.webapi.repository.SpCakeListRepository;
import com.ats.webapi.repository.SpCkDeleteOrderRepository;
import com.ats.webapi.repository.SubCategory2Repository;
import com.ats.webapi.repository.SubCategoryRepository;
import com.ats.webapi.repository.TRegSpCakeSupDeleteRepository;
import com.ats.webapi.repository.TSpCakeSupDeleteRepository;
import com.ats.webapi.service.FranchiseeService;
import com.ats.webapi.service.ItemService;
import com.ats.webapi.service.OrderService;
import com.ats.webapi.service.RegularSpCkOrderService;
import com.ats.webapi.service.SpecialCakeCatService;
import com.ats.webapi.service.SpecialCakeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RestController
public class MasterController {

	@Autowired
	ItemService itemService;
	@Autowired
	FranchiseeService franchiseeService;

	@Autowired
	RegularSpCkOrderService regularSpCkOrderService;

	@Autowired
	FranchiseeRepository franchiseeRepository;

	@Autowired
	SpCkDeleteOrderRepository spCkDeleteOrderRepository;

	@Autowired
	SpecialCakeService spCakeService;

	@Autowired
	SpecialCakeCatService spCakeCatService;

	@Autowired
	FrListForSuppRepository frListForSuppRepository;

	@Autowired
	SpCakeListRepository spCakeListRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	FranchiseSupRepository franchiseSupRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	GetSubCategoryRepository getSubCategoryRepository;

	@Autowired
	ConfigureFrRepository configureFrRepository;

	@Autowired
	PostFrOpStockHeaderRepository postFrOpStockHeaderRepository;

	@Autowired
	PostFrOpStockDetailRepository postFrOpStockDetailRepository;

	@Autowired
	TSpCakeSupDeleteRepository tSpCakeSupDeleteRepository;

	@Autowired
	TRegSpCakeSupDeleteRepository tRegSpCakeSupDeleteRepository;

	@Autowired
	SubCategory2Repository subCategory2Repository;

	@Autowired
	SettingNewRepository settingNewRepository;

	@Autowired
	GetItemSupRepository getItemSupRepository;

	@Autowired
	SettingRepository settingRepository;

	@Autowired
	MenuOrderLimitRepo menuOrderLimitRepo;

	// ----------------------------GET FrToken--------------------------------
	@RequestMapping(value = { "/getFrToken" }, method = RequestMethod.POST)
	public @ResponseBody String getFrToken(@RequestParam("frId") int frId) {

		String frToken = franchiseSupRepository.findTokenByFrId(frId);

		return frToken;
	}

	// -------------------------------------------------------------------------
	// ----------------------------SAVE Sub Category 2---------------------------
	@RequestMapping(value = { "/saveSubCategory2" }, method = RequestMethod.POST)
	public @ResponseBody SubCategory2 SubCategory2(@RequestBody SubCategory2 subCategory2) {

		SubCategory2 subCategory2Res = null;
		try {

			subCategory2Res = subCategory2Repository.save(subCategory2);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return subCategory2Res;

	}

	// ------------------------Getting One Sub Category 2-----------------------
	@RequestMapping(value = { "/getSubCategory2ById" }, method = RequestMethod.POST)
	public @ResponseBody SubCategory2 getSubCategory2ById(@RequestParam("miniCatId") int miniCatId) {

		SubCategory2 subCategory2Res = null;
		try {
			subCategory2Res = subCategory2Repository.findByMiniCatIdAndDelStatus(miniCatId, 0);

		} catch (Exception e) {

			System.out.println("Exception In SubCategory2:" + e.getMessage());
		}

		return subCategory2Res;

	}

	@RequestMapping(value = { "/deleteSubCategory2ById" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSubCategory2ById(@RequestParam int miniCatId) {

		int isDeleted = subCategory2Repository.deleteSubCategory2ById(miniCatId);
		Info info = new Info();
		if (isDeleted == 1) {

			info.setError(false);
			info.setMessage("SubCategory2 Deleted");

		} else {
			info.setError(true);
			info.setMessage("SubCategory2 Deletion Failed");
		}
		return info;
	}

	// ----------------------------SAVE Item Sup---------------------------
	@RequestMapping(value = { "/saveItemSup" }, method = RequestMethod.POST)
	public @ResponseBody Info saveItemSup(@RequestBody ItemSup itemSup) {

		ItemSup itemSupRes = null;
		Info info = new Info();
		try {

			itemSupRes = itemService.saveItemSup(itemSup);

			if (itemSupRes != null) {
				info.setError(false);
				info.setMessage("ItemSup Saved Successfully.");
			} else {
				info.setError(true);
				info.setMessage("ItemSup Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("ItemSup Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In MasterController /saveItemSup" + e.getMessage());

		}
		return info;

	}

	// ---------------------------------------------------------------------------
	// ----------------------------SAVE SpCake Sup---------------------------
	@RequestMapping(value = { "/saveSpCakeSup" }, method = RequestMethod.POST)
	public @ResponseBody Info saveSpCakeSup(@RequestBody SpCakeSupplement spCakeSupplement) {

		SpCakeSupplement spCakeSupplementRes = null;
		Info info = new Info();
		try {

			spCakeSupplementRes = spCakeService.saveSpCakeSup(spCakeSupplement);

			if (spCakeSupplementRes != null) {
				info.setError(false);
				info.setMessage("SpCakeSupplement Saved Successfully.");

				try {
					List<String> frTokens = franchiseSupRepository.findTokens();

					for (String token : frTokens) {
						Firebase.sendPushNotifForCommunication(token, "Special Cake Details Updated",
								"Changes have been made in OPS at item level, SP level, in the rates. Kindly refer the OPS for exact changes made.",
								"updateList");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else {
				info.setError(true);
				info.setMessage("SpCakeSupplement Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("SpCakeSupplement Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In MasterController /saveSpCakeSup" + e.getMessage());

		}
		return info;

	}

//Sachin 14-02-2020
	@RequestMapping(value = { "/dynamicPushNotif" }, method = RequestMethod.POST)
	public @ResponseBody String dynamicPyshNotif(@RequestParam String token, String title, String body, String tag) {
		String notfRes = new String();
		try {
			Firebase.sendPushNotifForCommunication(token, title, body, tag);
			notfRes = "Notification Sent";
		} catch (Exception e) {
			notfRes = e.getMessage();
			e.printStackTrace();
		}
		return notfRes;
	}

	@RequestMapping(value = { "/saveSpCakeSupCat" }, method = RequestMethod.POST)
	public @ResponseBody Info saveSpCakeSupCat(@RequestBody SpCakeSupplementCat spCakeSupplementCat) {

		System.out
				.println("spCakeSupplementCatspCakeSupplementCatspCakeSupplementCat" + spCakeSupplementCat.toString());

		SpCakeSupplementCat spCakeSupplementRes = null;
		Info info = new Info();
		try {

			spCakeSupplementRes = spCakeService.saveSpCakeSupCat(spCakeSupplementCat);

			if (spCakeSupplementRes != null) {
				info.setError(false);
				info.setMessage("SpCakeSupplement Saved Successfully.");

			} else {
				info.setError(true);
				info.setMessage("SpCakeSupplement Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("SpCakeSupplement Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In MasterController /saveSpCakeSupCat" + e.getMessage());

		}
		return info;

	}

	// ---------------------------------------------------------------------------
	// ------------------------Delete SpCake Sup------------------------------------
	@RequestMapping(value = { "/deleteSpCakeSup" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSpCakeSup(@RequestParam("id") int id) {

		Info info = spCakeService.deleteSpCakeSup(id);
		return info;
	}

	@RequestMapping(value = { "/deleteSpCakeCatSup" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSpCakeCatSup(@RequestParam("id") int id) {

		Info info = spCakeCatService.deleteSpCakeSup(id);
		return info;
	}

	// ------------------------------------------------------------------------
	// ------------------------Delete ItemSup------------------------------------
	@RequestMapping(value = { "/deleteItemSup" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteItemSup(@RequestParam("id") int itemId) {

		Info info = itemService.deleteItemSup(itemId);
		return info;
	}

	// ------------------------------------------------------------------------
	// ---------------------------Getting ItemSup List-----------------------
	@RequestMapping(value = { "/getItemSupList" }, method = RequestMethod.GET)
	public @ResponseBody ItemSupList getItemSupList() {

		ItemSupList itemSupList = itemService.getItemSupList();

		return itemSupList;

	}

	// ------------------------------------------------------------------------
	// ---------------------------Getting SpCakeSup List-----------------------
	@RequestMapping(value = { "/getSpCakeSuppList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetSpCkSupplement> getSpCakeSupList() {

		List<GetSpCkSupplement> spCakeSupplementList = spCakeService.getSpCakeSupList();

		return spCakeSupplementList;

	}

	// --------ANMOL 10-7-19
	// ------------------------------------------------------------------------
	// ---------------------------Getting SpCakeCatSup List-----------------------
	@RequestMapping(value = { "/getSpCakeCatSuppList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetSpCkSupplement> getSpCakeCatSupList() {

		List<GetSpCkSupplement> spCakeSupplementList = spCakeCatService.getSpCakeCatSupList();

		return spCakeSupplementList;

	}

	@RequestMapping(value = { "/getSpCakeSuppCatList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetSpCkSupplementCat> getSpCakeSuppCatList() {

		List<GetSpCkSupplementCat> spCakeSupplementList = spCakeService.getSpCakeSupCatList();

		return spCakeSupplementList;

	}

	// ------------------------------------------------------------------------
	// ---------------------------Getting SpCakeList List-----------------------
	@RequestMapping(value = { "/getSpCakeList" }, method = RequestMethod.GET)
	public @ResponseBody List<SpCake> getSpCakeList() {

		List<SpCake> spCakeList;
		try {
			spCakeList = spCakeListRepository.getSpCakeList();
		} catch (Exception e) {
			spCakeList = new ArrayList<>();
			e.printStackTrace();
		}
		return spCakeList;

	}

	// ---------------------------Getting SpCakeCatList List-----------------------
	@RequestMapping(value = { "/getSpCakeCatList" }, method = RequestMethod.GET)
	public @ResponseBody List<SpCake> getSpCakeCatList() {

		List<SpCake> spCakeList;
		try {
			spCakeList = spCakeListRepository.getSpCakeCatList();
		} catch (Exception e) {
			spCakeList = new ArrayList<>();
			e.printStackTrace();
		}
		return spCakeList;

	}

	// ------------------------------------------------------------------------
	// ------------------------Getting One ItemSup by Id-----------------------
	@RequestMapping(value = { "/getItemSup" }, method = RequestMethod.POST)
	public @ResponseBody GetItemSup getItemSup(@RequestParam("id") int id) {

		GetItemSup getItemSupRes = null;
		try {
			getItemSupRes = itemService.getItemSup(id);

			if (getItemSupRes != null) {
				getItemSupRes.setError(false);
				getItemSupRes.setMessage("ItemSup Found Successfully");
			} else {
				getItemSupRes = new GetItemSup();
				getItemSupRes.setError(true);
				getItemSupRes.setMessage("ItemSup Not Found");
			}
		} catch (Exception e) {
			getItemSupRes = new GetItemSup();
			getItemSupRes.setError(true);
			getItemSupRes.setMessage("ItemSup Not Found");
			System.out.println("Exception In getItemSup:" + e.getMessage());
		}

		return getItemSupRes;

	}

	// ------------------------Getting One SpCakeSup by Id-----------------------
	@RequestMapping(value = { "/getSpCakeSupp" }, method = RequestMethod.POST)
	public @ResponseBody GetSpCkSupplement getSpCakeSupp(@RequestParam("id") int id) {

		GetSpCkSupplement getSpCkSupRes = null;
		try {
			getSpCkSupRes = spCakeService.getSpCakeSupp(id);

			if (getSpCkSupRes != null) {
				getSpCkSupRes.setError(false);
				getSpCkSupRes.setMessage("GetSpCkSupplement Found Successfully");
			} else {
				getSpCkSupRes = new GetSpCkSupplement();
				getSpCkSupRes.setError(true);
				getSpCkSupRes.setMessage("GetSpCkSupplement Not Found");
			}
		} catch (Exception e) {
			getSpCkSupRes = new GetSpCkSupplement();
			getSpCkSupRes.setError(true);
			getSpCkSupRes.setMessage("GetSpCkSupplement Not Found");
			System.out.println("Exception In getSpCakeSupp:" + e.getMessage());
		}

		return getSpCkSupRes;

	}

	@RequestMapping(value = { "/getSpCakeSuppCat" }, method = RequestMethod.POST)
	public @ResponseBody GetSpCkSupplement getSpCakeSuppCat(@RequestParam("id") int id) {

		GetSpCkSupplement getSpCkSupRes = null;
		try {
			getSpCkSupRes = spCakeService.getSpCakeSuppCat(id);

			if (getSpCkSupRes != null) {
				getSpCkSupRes.setError(false);
				getSpCkSupRes.setMessage("GetSpCkSupplement Found Successfully");
			} else {
				getSpCkSupRes = new GetSpCkSupplement();
				getSpCkSupRes.setError(true);
				getSpCkSupRes.setMessage("GetSpCkSupplement Not Found");
			}
		} catch (Exception e) {
			getSpCkSupRes = new GetSpCkSupplement();
			getSpCkSupRes.setError(true);
			getSpCkSupRes.setMessage("GetSpCkSupplement Not Found");
			System.out.println("Exception In getSpCakeSupp:" + e.getMessage());
		}

		return getSpCkSupRes;

	}

	// ----------------------------SAVE FranchiseSup---------------------------
	@RequestMapping(value = { "/saveFranchiseSup" }, method = RequestMethod.POST)
	public @ResponseBody Info saveFranchiseSup(@RequestBody FranchiseSup franchiseSup) {

		FranchiseSup franchiseSupRes = null;
		Info info = new Info();
		try {

			franchiseSupRes = franchiseeService.saveFranchiseSup(franchiseSup);

			if (franchiseSupRes != null) {
				int a = franchiseeRepository.updateAdminPwd(franchiseSup.getFrId(), franchiseSup.getPass1());
				if (a > 0) {
					System.err.println("Password Update successfully");
				}
				info.setError(false);
				info.setMessage("FranchiseSup Saved Successfully.");
			} else {
				info.setError(true);
				info.setMessage("FranchiseSup Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("FranchiseSup Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In MasterController /saveFranchiseSup" + e.getMessage());

		}
		return info;

	}

	// ---------------------------------------------------------------------------
	// ------------------------Delete
	// FranchiseSup------------------------------------
	@RequestMapping(value = { "/deleteFranchiseSup" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteFranchiseSup(@RequestParam int frId) {

		Info info = franchiseeService.deleteFranchiseSup(frId);
		return info;
	}
	// ------------------------------------------------------------------------

	// ---------------------------Getting FranchiseSup List-----------------------
	@RequestMapping(value = { "/getFranchiseSupList" }, method = RequestMethod.GET)
	public @ResponseBody FranchiseSupList getFranchiseSupList() {

		FranchiseSupList franchiseSupList = franchiseeService.getFranchiseSupList();

		return franchiseSupList;

	}

	// ------------------------------------------------------------------------
	// ------------------------Getting One FranchiseSup by Id-----------------------
	@RequestMapping(value = { "/getFranchiseSup" }, method = RequestMethod.POST)
	public @ResponseBody FranchiseSup getFranchiseSup(@RequestParam("id") int id) {

		FranchiseSup getFranchiseSupRes = null;
		try {
			getFranchiseSupRes = franchiseeService.getFranchiseSup(id);

			if (getFranchiseSupRes != null) {
				getFranchiseSupRes.setError(false);
				getFranchiseSupRes.setMessage("FranchiseSup Found Successfully");
			} else {
				getFranchiseSupRes = new FranchiseSup();
				getFranchiseSupRes.setError(true);
				getFranchiseSupRes.setMessage("FranchiseSup Not Found");
			}
		} catch (Exception e) {
			getFranchiseSupRes = new FranchiseSup();
			getFranchiseSupRes.setError(true);
			getFranchiseSupRes.setMessage("FranchiseSup Not Found");
			System.out.println("Exception In getFranchiseSup:" + e.getMessage());
		}

		return getFranchiseSupRes;

	}

	// ----------------------------SAVE FranchiseSup---------------------------
	@RequestMapping(value = { "/saveFrTarget" }, method = RequestMethod.POST)
	public @ResponseBody Info saveFrTarget(@RequestBody List<FrTarget> frTargetList) {

		Info info = franchiseeService.saveFrTarget(frTargetList);

		return info;

	}

	// ---------------------------------------------------------------------------
	// ---------------------------Getting FrTarget List-----------------------
	@RequestMapping(value = { "/getFrTargetList" }, method = RequestMethod.POST)
	public @ResponseBody FrTargetList getFrTargetList(@RequestParam("frId") int frId, @RequestParam("year") int year) {

		FrTargetList frTargetList = franchiseeService.getFrTargetList(frId, year);

		return frTargetList;

	}

	// ------------------------------------------------------------------------
	// Get Items
	@RequestMapping(value = "/getItemsByIsAllowBday", method = RequestMethod.GET)
	public @ResponseBody List<Item> getItemsByIsAllowBday() {

		List<Item> items = itemService.getItemsByIsAllowBday();
		return items;

	}

	// ---------------------------Getting TotalFrSale List-----------------------
	@RequestMapping(value = { "/getFrTotalSale" }, method = RequestMethod.POST)
	public @ResponseBody FrTotalSale getFrTotalSale(@RequestParam("frId") int frId, @RequestParam("month") int month,
			@RequestParam("year") int year) {

		System.out.println("frId" + frId);
		FrTotalSale frTotalSale = franchiseeService.getFrTargetList(frId, month, year);

		return frTotalSale;

	}

	// ------------------------------------------------------------------------
	// --------------------------------Update Fr Admin password------------------
	@RequestMapping(value = { "/updateAdminPwd" }, method = RequestMethod.POST)
	public @ResponseBody Info updateAdminPwd(@RequestParam("frId") int frId,
			@RequestParam("adminPwd") String adminPwd) {

		Info info = franchiseeService.updateAdminPwd(frId, adminPwd);

		return info;

	}

	// ------------------------------------------------------------------------
	// ------------------------Update FranchiseSup
	// Passwords------------------------------------
	@RequestMapping(value = { "/updateFranchiseSupUsrPwd" }, method = RequestMethod.POST)
	public @ResponseBody Info updateFranchiseUsrPwd(@RequestParam int frId, @RequestParam String pass2,
			@RequestParam String pass3) {

		Info info = franchiseeService.updateFranchiseSupUsrPwd(frId, pass2, pass3);
		return info;
	}

	// ------------------------------------------------------------------------
	// ------------------------Getting One FranchiseSup by Id-----------------------
	@RequestMapping(value = { "/getFrSupByFrId" }, method = RequestMethod.POST)
	public @ResponseBody FranchiseSup getFrSupByFrId(@RequestParam("frId") int frId) {

		FranchiseSup getFranchiseSupRes = null;
		try {
			getFranchiseSupRes = franchiseeService.getFrSupByFrId(frId);

			if (getFranchiseSupRes != null) {
				getFranchiseSupRes.setError(false);
				getFranchiseSupRes.setMessage("FranchiseSup Found Successfully");
			} else {
				getFranchiseSupRes = new FranchiseSup();
				getFranchiseSupRes.setError(true);
				getFranchiseSupRes.setMessage("FranchiseSup Not Found");
			}
		} catch (Exception e) {
			getFranchiseSupRes = new FranchiseSup();
			getFranchiseSupRes.setError(true);
			getFranchiseSupRes.setMessage("FranchiseSup Not Found");
			System.out.println("Exception In getFranchiseSup:" + e.getMessage());
		}

		return getFranchiseSupRes;

	}

	// ---------------------------Getting Franchise List For
	// Supplement-----------------------
	@RequestMapping(value = { "/getFrListForSupp" }, method = RequestMethod.GET)
	public @ResponseBody List<FrListForSupp> getFrListForSupp() {

		List<FrListForSupp> franchiseSupList = frListForSuppRepository.getFrListForSupp();

		return franchiseSupList;

	}

	// ------------------------------------------------------------------------
	// ------------------------Delete
	// RegularSpOrder------------------------------------
	@RequestMapping(value = { "/deleteRegularSpOrder" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRegularSpOrder(@RequestParam int rspId) {

		Info info = regularSpCkOrderService.deleteRegularSpOrder(rspId);
		info = regularSpCkOrderService.deleteRegularSpCkOrderSupplement(rspId);
		return info;
	}

	// ------------------------------------------------------------------------
	// ------------------------DeleteSpCkOrder------------------------------------
	@RequestMapping(value = { "/deleteSpCkOrder" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSpCkOrder(@RequestParam int spOrderNo) {

		int isDeleted = spCkDeleteOrderRepository.deleteSpCkOrder(spOrderNo);
		Info info = new Info();
		if (isDeleted == 1) {

			info.setError(false);
			info.setMessage("SpCkOrder Deleted");

			int isDeleted1 = tSpCakeSupDeleteRepository.deleteSpCkOrderSupplement(spOrderNo);

		} else {
			info.setError(true);
			info.setMessage("SpCkOrder Deletion Failed");
		}
		return info;
	}

	// ------------------------------------------------------------------------
	// ------------------------Get Unique Franchise
	// Code------------------------------------
	@RequestMapping(value = { "/getUnigueFrCode" }, method = RequestMethod.GET)
	public @ResponseBody Integer getUnigueFrCode() {

		int maxId = franchiseeRepository.getUnigueFrCode();

		return maxId;
	}

	// ------------------------------------------------------------------------
	// ------------------------Get Unique Item
	// Code------------------------------------
	@RequestMapping(value = { "/getUniqueItemCode" }, method = RequestMethod.GET)
	public @ResponseBody Integer getUniqueItemCode() {

		int maxId = itemService.getUniqueItemCode();

		return maxId;
	}

	// ------------------------------------------------------------------------
	// ------------------------Get TrayTypes------------------------------------
	@RequestMapping(value = { "/getTrayTypes" }, method = RequestMethod.GET)
	public @ResponseBody List<TrayType> getTrayTypes() {

		List<TrayType> trayTypes = itemService.getTrayTypes();

		return trayTypes;
	}

	// ------------------------------------------------------------------------
	// Get Items
	@RequestMapping(value = "/getItemsByCatIdForSup", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemsByCatIdForSup(@RequestParam String itemGrp1) {

		List<Item> items = itemService.getItemsByCatIdForSup(itemGrp1);
		return items;

	}

	@RequestMapping(value = "/findItemsByGrpIdForRmIssue", method = RequestMethod.POST)
	public @ResponseBody List<Item> findItemsByGrpIdForRmIssue(@RequestParam String itemGrp3,
			@RequestParam int prodHeaderId, @RequestParam int fromDept, @RequestParam int toDept) {

		List<Item> itemList = itemRepository.findByItemGrp3(itemGrp3, prodHeaderId, fromDept, toDept);
		return itemList;

	}

	// Get Items By Category order by sub cat and sort id
	@RequestMapping(value = "/getItemsByCatIdForDisp", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemsByCatIdForDisp(@RequestParam List<String> catIdList) {

		List<Item> items = null;
		try {
			items = itemRepository.findByItemGrp1InAndDelStatusOrderByItemGrp2AscItemSortIdAsc(catIdList, 0);
		} catch (Exception e) {
			items = new ArrayList<>();
			e.printStackTrace();

		}
		return items;

	}

	@RequestMapping(value = "/getItemsByItemIdForDisp", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemsByItemIdForDisp(@RequestParam List<Integer> itemIdList) {

		List<Item> items = null;
		try {
			items = itemRepository.findByIdInAndDelStatusOrderByItemGrp2AscItemSortIdAsc(itemIdList, 0);
		} catch (Exception e) {
			items = new ArrayList<>();
			e.printStackTrace();

		}
		return items;

	}

	// neha
	@RequestMapping(value = "/getItemsByItemIdForDispNew", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemsByItemIdForDispNew(@RequestParam List<Integer> itemIdList) {

		List<Item> items = null;
		try {
			items = itemRepository.findByIdInAndDelStatusOrderByItemGrp2AscItemSortIdAscNew(itemIdList, 0);
		} catch (Exception e) {
			items = new ArrayList<>();
			e.printStackTrace();

		}
		return items;

	}

	// Get SubCategories
	@RequestMapping(value = "/getSubCatList")
	public @ResponseBody List<SubCategory> getAllSubCategories(@RequestParam List<String> catId) {

		List<SubCategory> subCategoryList;
		try {
			subCategoryList = subCategoryRepository.findByCatIdInAndDelStatus(catId);
		} catch (Exception e) {
			subCategoryList = new ArrayList<>();
			e.printStackTrace();

		}
		return subCategoryList;

	}

	// Get SubCategories
	@RequestMapping(value = "/getAllSubCatList", method = RequestMethod.GET)
	public @ResponseBody List<SubCategory> getAllSubCatList() {

		List<SubCategory> subCategoryList;
		try {
			subCategoryList = subCategoryRepository.findAllSubCategories();
		} catch (Exception e) {
			subCategoryList = new ArrayList<>();
			e.printStackTrace();

		}
		return subCategoryList;

	}

	@RequestMapping(value = "/getItemsByProductionIdCatId", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemsByProductionIdCatId(@RequestParam int prodHeaderId) {

		List<Item> itemList;
		try {
			itemList = itemRepository.getItemsByProductionIdCatId(prodHeaderId);
		} catch (Exception e) {
			itemList = new ArrayList<>();
			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/getRegSpCakeOrderHistory" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetRegSpCakeOrders> getRegSpCakeOrderHistory(@RequestParam String spDeliveryDt, int frId) {
		List<GetRegSpCakeOrders> regSpCakeOrder = regularSpCkOrderService.getRegSpCakeOrderHistory(spDeliveryDt, frId);
		return regSpCakeOrder;
	}

	@RequestMapping(value = { "/getSubCatListByCatId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetSubCategory> getSubCatListByCatId(@RequestParam("catId") int catId) {

		List<GetSubCategory> subCategoryList;
		try {
			subCategoryList = getSubCategoryRepository.findByCatIdAndDelStatus(catId, 0);
		} catch (Exception e) {
			subCategoryList = new ArrayList<>();
			e.printStackTrace();

		}
		return subCategoryList;

	}

	public static boolean contains(int[] arr, int item) {
		for (int n : arr) {
			if (item == n) {
				return true;
			}
		}
		return false;
	}

	@RequestMapping(value = "/updateConfiguredItems", method = RequestMethod.POST)
	public @ResponseBody Info updateConfiguredItems(@RequestParam List<String> frIdList, @RequestParam int menuId,
			@RequestParam List<String> itemIdList, @RequestParam int catId) {
		Info info = new Info();
		try {
			for (String frId : frIdList) {

				ConfigureFranchisee configureFr = configureFrRepository
						.findByFrIdAndMenuIdAndDelStatus(Integer.parseInt(frId), menuId, 0);

				if (configureFr != null) {
					String itemShow = configureFr.getItemShow();
					int[] intArray = null;
					try {
						intArray = Arrays.stream(itemShow.split(",")).mapToInt(Integer::parseInt).toArray();
					} catch (Exception e) {
						e.printStackTrace();
					}
					for (String itemId : itemIdList) {
						if (intArray.length != 0) {
							if (!contains(intArray, Integer.parseInt(itemId))) {
								itemShow = itemShow + "," + itemId;

							}
						}
					}
					configureFr.setItemShow(itemShow);

					ConfigureFranchisee configureFranchiseeReport = configureFrRepository.save(configureFr);

					try {

						PostFrItemStockHeader stockHeader = postFrOpStockHeaderRepository
								.findByFrIdAndCatIdAndIsMonthClosed(Integer.parseInt(frId), catId, 0);

						if (stockHeader != null) {

							for (String itemId : itemIdList) {

								PostFrItemStockDetail stockDetailRes = postFrOpStockDetailRepository
										.findByOpeningStockHeaderIdAndItemId(stockHeader.getOpeningStockHeaderId(),
												Integer.parseInt(itemId));

								if (stockDetailRes == null) {
									PostFrItemStockDetail stockDetail = new PostFrItemStockDetail();
									stockDetail.setOpeningStockHeaderId(stockHeader.getOpeningStockHeaderId());
									stockDetail.setItemId(Integer.parseInt(itemId));
									postFrOpStockDetailRepository.save(stockDetail);
								}
							}
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
			info.setError(false);
			info.setMessage("CF Updated");
		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("CF Updation Failed");
		}

		return info;
	}

	// Sachin 3-2-2020
	@RequestMapping(value = "/updateConfiguredItemsRemove", method = RequestMethod.POST)
	public @ResponseBody Info updateConfiguredItemsTemp(@RequestParam List<String> frIdList, @RequestParam int menuId,
			@RequestParam String itemIdList, @RequestParam int catId) {
		Info info = new Info();
		List<Integer> inputArray = Stream.of(itemIdList.split(",")).map(Integer::parseInt).collect(Collectors.toList());

		System.err.println("inputArray Ids  " + inputArray.toString());

		try {
			for (String frId : frIdList) {

				ConfigureFranchisee configureFr = configureFrRepository
						.findByFrIdAndMenuIdAndDelStatus(Integer.parseInt(frId), menuId, 0);

				if (configureFr != null) {
					String itemShow = configureFr.getItemShow();
					List<Integer> intArray = null;
					try {
						intArray = Stream.of(itemShow.split(",")).map(Integer::parseInt).collect(Collectors.toList());
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.err.println("intArray before  " + intArray.toString());

					for (int i = 0; i < inputArray.size(); i++) {
						int find = 0;
						int index = 0;

						for (int j = 0; j < intArray.size(); j++) {
							if (intArray.get(j).equals(inputArray.get(i))) {
								System.err.println("Match found " + j);
								intArray.remove(j);
								break;
							}

						}

					}
					System.err.println("intArray after " + intArray.toString());
					System.err.println("commas seperated  itemShow ="
							+ intArray.stream().map(String::valueOf).collect(Collectors.joining(",")));
					itemShow = intArray.stream().map(String::valueOf).collect(Collectors.joining(","));
					configureFr.setItemShow(itemShow);

					ConfigureFranchisee configureFranchiseeReport = configureFrRepository.save(configureFr);
					info.setError(false);
				}
			} // fr Id for Loop;

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Info info = new Info(); try { for (String frId : frIdList) {
		 * 
		 * ConfigureFranchisee configureFr = configureFrRepository
		 * .findByFrIdAndMenuIdAndDelStatus(Integer.parseInt(frId), menuId, 0);
		 * 
		 * if (configureFr != null) { String itemShow = configureFr.getItemShow(); int[]
		 * intArray = null; try { intArray =
		 * Arrays.stream(itemShow.split(",")).mapToInt(Integer::parseInt).toArray(); }
		 * catch (Exception e) { e.printStackTrace(); } for (String itemId : itemIdList)
		 * { if (intArray.length != 0) { if (!contains(intArray,
		 * Integer.parseInt(itemId))) { itemShow = itemShow + "," + itemId;
		 * 
		 * } } } configureFr.setItemShow(itemShow);
		 * System.err.println("itemShow "+itemShow);
		 * 
		 * //ConfigureFranchisee configureFranchiseeReport =
		 * configureFrRepository.save(configureFr);
		 * 
		 * 
		 * }
		 * 
		 * } info.setError(false); info.setMessage("CF Updated"); } catch (Exception e)
		 * { e.printStackTrace(); info.setError(true);
		 * info.setMessage("CF Updation Failed"); }
		 */

		return info;
	}

	@Autowired
	ItemIdOnlyRepository itemIdOnlyRepository;

	@RequestMapping(value = { "/getItemsByMenuIdMultiple" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemIdOnly> getItemsByMenuIdMultiple(@RequestParam("menuId") List<Integer> menuId) {
		System.out.println("menuId" + menuId);

		List<ItemIdOnly> itemList;
		itemList = itemIdOnlyRepository.finditmsMenuIdInMultiple(0, menuId);

		System.out.println("itemList" + itemList.toString());
		return itemList;
	}

	@Autowired
	OrderRepository orderRepository;

	@RequestMapping(value = "/updateOrderDetails", method = RequestMethod.POST)
	public @ResponseBody Info updateOrderDetails(@RequestParam List<Integer> orderIds, @RequestParam String delDate,
			@RequestParam String prodDate) {
		Info info = new Info();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.err.println(orderIds.toString());
		Date dateDel = new Date();
		Date dateProd = new Date();
		try {
			dateDel = df.parse(delDate);
			dateProd = df.parse(prodDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int isUpdated = orderRepository.updateOrderDelivery(orderIds, dateDel, dateProd);
		if (isUpdated > 0) {
			info.setError(false);
			info.setMessage("Order Updated Successfully");
		} else {
			info.setError(true);
			info.setMessage("Orders Not Updated");
		}

		return info;
	}

	@RequestMapping(value = "/updateShiftOrder", method = RequestMethod.POST)
	public @ResponseBody Info updateShiftOrder(@RequestParam List<Integer> frIds, @RequestParam List<Integer> menuIds,
			@RequestParam String delDate, @RequestParam String prodDate, @RequestParam String pDate) {

		Info info = new Info();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDel = new Date();
		Date dateProd = new Date();
		Date dateP = new Date();
		try {
			dateDel = df.parse(delDate);
			dateProd = df.parse(prodDate);
			dateP = df.parse(pDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int isUpdated = orderRepository.updateShiftOrder(frIds, menuIds, dateDel, dateProd, dateP);
		if (isUpdated > 0) {
			info.setError(false);
			info.setMessage("Order Updated Successfully");
		} else {
			info.setError(true);
			info.setMessage("Orders Not Updated");
		}

		return info;
	}

	// Anmol-->27-11-2019--->Update_Setting_new_value
	@RequestMapping(value = { "/updateSettingValueById" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSettingValueById(@RequestParam("settingId") int settingId,
			@RequestParam("value") String value) {

		Info info = new Info();

		int res = settingNewRepository.udateValueById(settingId, value);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	// Anmol-->27-11-2019--->Update_Setting_new_value
	@RequestMapping(value = { "/updateSettingValueByKey" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSettingValueByKey(@RequestParam("settingKey") String settingKey,
			@RequestParam("value") String value) {

		Info info = new Info();

		int res = settingNewRepository.udateValueByKey(settingKey, value);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}

	// Anmol-->27-11-2019--->Get_Setting_new_value
	@RequestMapping(value = { "/getSettingValueByKey" }, method = RequestMethod.POST)
	public @ResponseBody SettingNew getSettingValueByKey(@RequestParam("settingKey") String settingKey) {

		SettingNew setting;

		setting = settingNewRepository.findBySettingKey(settingKey);
		if (setting == null) {
			setting = new SettingNew();
		}

		return setting;
	}

	// Anmol-->27-11-2019--->Get_Setting_new_value
	@RequestMapping(value = { "/getSettingValueById" }, method = RequestMethod.POST)
	public @ResponseBody SettingNew getSettingValueById(@RequestParam("settingId") int settingId) {

		SettingNew setting;

		setting = settingNewRepository.findBySettingId(settingId);
		if (setting == null) {
			setting = new SettingNew();
		}

		return setting;
	}

	// Anmol---->17-12-2019-------------
	@RequestMapping(value = { "/getItemSupDataByItemId" }, method = RequestMethod.POST)
	public @ResponseBody GetItemSup getItemSupDataByItemId(@RequestParam("itemId") int itemId) {

		GetItemSup res;

		res = getItemSupRepository.findByItemId(itemId);
		if (res == null) {
			res = new GetItemSup();
		}
		System.err.println("RES---------------------------------- " + res);
		return res;
	}

	// Anmol---->18-12-2019-------------
	@RequestMapping(value = { "/getSettingDataById" }, method = RequestMethod.POST)
	public @ResponseBody Setting getSettingDataById(@RequestParam("settingId") int settingId) {

		Setting res;

		res = settingRepository.findBySettingId(settingId);
		if (res == null) {
			res = new Setting();
		}
		System.err.println("RES---------------------------------- " + res);
		return res;
	}

	@RequestMapping(value = { "/getAllItemSupData" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemSup> getAllItemSupData(@RequestParam("del") int del) {

		List<GetItemSup> res = null;

		res = getItemSupRepository.findAllByDelStatus(del);
		if (res == null) {
			res = new ArrayList<>();
		}
		return res;
	}

	// MENU WISE SUB CAT LIST FOR ORDER LIMIT
	@RequestMapping(value = { "/getMenuWiseSubCatForLimit" }, method = RequestMethod.GET)
	public @ResponseBody List<MenuOrderLimit> getMenuWiseSubCatForLimit() {

		List<MenuOrderLimit> menuList = new ArrayList<>();

		try {

			menuList = menuOrderLimitRepo.getMenuWiseSubCatForLimit();

			ObjectMapper Obj = new ObjectMapper();
			String jsonStr = "";
			try {
				jsonStr = Obj.writeValueAsString(menuList);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//System.err.println("json - " + jsonStr);

			SettingNew setting = settingNewRepository.findBySettingKey("MENULIMIT");
			if (setting != null) {

				if (!setting.getSettingValue1().isEmpty()) {

					// ObjectMapper mapper = new ObjectMapper();
					// List<MenuOrderLimit> jsonList = mapper.readValue(setting.getSettingValue1(),
					// List.class);

					Gson gson = new Gson();

					Type userListType = new TypeToken<ArrayList<MenuOrderLimit>>() {
					}.getType();

					ArrayList<MenuOrderLimit> jsonList = gson.fromJson(setting.getSettingValue1(), userListType);

					System.err.println("SETTINGS JSON ----> " + jsonList);

					if (jsonList != null) {

						for (MenuOrderLimit a : menuList) {

							for (MenuOrderLimit b : jsonList) {

								if (a.getMenuId() == b.getMenuId() && a.getSubCatId() == b.getSubCatId()) {

									a.setQtyLimit(b.getQtyLimit());
									break;
								}

							}

						}

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuList;
	}
	
	
	
	@RequestMapping(value = { "/updateMenuOrderLimitValue"}, method = RequestMethod.POST)
	public @ResponseBody Info updateSettingValueByKey(@RequestBody List<MenuOrderLimit> menuList) {

		Info info = new Info();
		
		
		System.err.println("PARAM ----> "+menuList);
		

		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = "";
		try {
			jsonStr = Obj.writeValueAsString(menuList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.err.println("JSON STR -----> "+jsonStr);

		int res = settingNewRepository.udateValueByKey("MENULIMIT",jsonStr);
		if (res > 0) {
			info.setError(false);
			info.setMessage("Success");
		} else {
			info.setError(true);
			info.setMessage("Failed");
		}

		return info;
	}
	
	

}
