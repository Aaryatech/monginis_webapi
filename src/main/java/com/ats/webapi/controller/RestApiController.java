package com.ats.webapi.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.AllFranchiseeAndMenu;
import com.ats.webapi.model.AllMenuJsonResponse;
import com.ats.webapi.model.AllMenus;
import com.ats.webapi.model.CategoryList;
import com.ats.webapi.model.ConfigureFrBean;
import com.ats.webapi.model.ConfigureFrBeanList;
import com.ats.webapi.model.ConfigureFranchisee;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Event;
import com.ats.webapi.model.EventList;
import com.ats.webapi.model.Flavour;
import com.ats.webapi.model.FlavourList;
import com.ats.webapi.model.FrMenus;
import com.ats.webapi.model.FrMenusList;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.FranchiseeList;
import com.ats.webapi.model.GetFrItems;
import com.ats.webapi.model.GetOrder;
import com.ats.webapi.model.GetOrderList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.ItemOrderList;
import com.ats.webapi.model.ItemWithSubCat;
import com.ats.webapi.model.LoginResponse;
import com.ats.webapi.model.MCategory;
import com.ats.webapi.model.MainModuleWithSubModule;
import com.ats.webapi.model.Message;
import com.ats.webapi.model.MessageList;
import com.ats.webapi.model.Order;
import com.ats.webapi.model.OrderSpecialCake;
import com.ats.webapi.model.Orders;
import com.ats.webapi.model.Rates;
import com.ats.webapi.model.Route;
import com.ats.webapi.model.RouteList;
import com.ats.webapi.model.Scheduler;
import com.ats.webapi.model.SchedulerList;
import com.ats.webapi.model.SpCakeOrderRes;
import com.ats.webapi.model.SpCakeOrders;
import com.ats.webapi.model.SpCakeOrdersBean;
import com.ats.webapi.model.SpCakeOrdersBeanList;
import com.ats.webapi.model.SpCakeOrdersList;
import com.ats.webapi.model.SpCkOrderHisList;
import com.ats.webapi.model.SpMessage;
import com.ats.webapi.model.SpecialCake;
import com.ats.webapi.model.SpecialCakeList;
import com.ats.webapi.model.SubCategory;
import com.ats.webapi.model.User;

import com.ats.webapi.service.CategoryService;
import com.ats.webapi.service.ConfigureFrBeanService;
import com.ats.webapi.service.ConfigureFranchiseeService;
import com.ats.webapi.service.EventService;
import com.ats.webapi.service.FlavourService;
import com.ats.webapi.service.FranchiseeService;
import com.ats.webapi.service.GetFrItemsService;
import com.ats.webapi.service.GetOrderService;
import com.ats.webapi.service.ItemService;
import com.ats.webapi.service.ItemsList;
import com.ats.webapi.service.MenuService;
import com.ats.webapi.service.MessageService;
import com.ats.webapi.service.ModuleService;
import com.ats.webapi.service.ModulesList;
import com.ats.webapi.service.OrderService;
import com.ats.webapi.service.PrevItemOrderService;
import com.ats.webapi.service.RateList;
import com.ats.webapi.service.RateService;
import com.ats.webapi.service.RouteService;
import com.ats.webapi.service.SchedulerService;
import com.ats.webapi.service.SpCakeOrdersService;
import com.ats.webapi.service.SpCkOrdersService;
import com.ats.webapi.service.SpMessageService;
import com.ats.webapi.service.SpecialCakeService;
import com.ats.webapi.service.SubCategoryService;
import com.ats.webapi.service.SubCatergoryList;
import com.ats.webapi.service.TestFrService;
import com.ats.webapi.service.UserService;
import com.ats.webapi.service.spMessageList;
import com.ats.webapi.util.JsonUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class RestApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private RouteService routeService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private FlavourService flavourService;
	
	@Autowired
	private SchedulerService schedulerService;

	@Autowired
	private EventService eventService;
	
	@Autowired
	private SpecialCakeService specialcakeService;
	
	@Autowired
	private FranchiseeService franchiseeService;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private SpecialCakeService specialCakeService;
	
	@Autowired
	private RateService rateService;
	
	@Autowired
	private SpMessageService spMsgService;
	
	@Autowired
	private ConfigureFranchiseeService connfigureService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private TestFrService frService;
	
	@Autowired
	SpCakeOrdersService spCakeOrdersService;
	@Autowired
	ConfigureFrBeanService configureFrBeanService;
	@Autowired
	SpCkOrdersService spCkOrdersService;
	@Autowired
	GetOrderService getOrderService;

	@Autowired
	private GetFrItemsService getFrItemsService;

	@Autowired
	private PrevItemOrderService prevItemOrderService;

	

	
	
	// Login FrontEnd Franchisee
	@RequestMapping(value = { "/loginFr" }, method = RequestMethod.POST)
	@ResponseBody
	public String loginFr(@RequestParam("frCode") String frCode, @RequestParam("frPasswordKey") String frPasswordKey) {

		String jsonFr = franchiseeService.findFranchiseeByFrCode(frCode, frPasswordKey);
		System.out.println("JsonString" + jsonFr);
		
		return jsonFr;
 
	}

	// Place Item Order
	@RequestMapping(value = { "/placeOrder" }, method = RequestMethod.POST)

	public @ResponseBody List<Orders> placeItemOrder(@RequestBody List<Orders> orderJson)
			throws ParseException, JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Orders> participantJsonList;
		List<Orders> jsonResult;
		
		System.out.println("Inside Place Order " + orderJson.toString());
		
		jsonResult = orderService.placeOrder(orderJson);

		return jsonResult;

	}

	// Place SpCake Order
	@RequestMapping(value = { "/placeSpCakeOrder" }, method = RequestMethod.POST)

	public @ResponseBody SpCakeOrderRes placeSpCakeOrder(@RequestBody SpCakeOrders orderJson)
			throws ParseException, JsonParseException, JsonMappingException, IOException {
		
		System.out.println("Inside Place Order " + orderJson.toString());
		
		SpCakeOrderRes spCakeOrderRes = spCakeOrdersService.placeSpCakeOrder(orderJson);

		return spCakeOrderRes;

	}

	// Search Special Cake By SpecialCake Code
	@RequestMapping("/searchSpecialCake")
	public @ResponseBody OrderSpecialCake searchSpecialCake(@RequestParam String spCode) {

		OrderSpecialCake specialCake = specialcakeService.searchSpecialCake(spCode);
		
		return specialCake;

	}

	// Search Special Cake Order History
	@RequestMapping("/SpCakeOrderHistory")
	public @ResponseBody SpCkOrderHisList searchSpCakeOrderHistory(@RequestParam int menuId,
			@RequestParam String spDeliveryDt, String frCode) {

		SpCkOrderHisList spCakeOrderList = spCakeOrdersService.searchOrderHistory(menuId, spDeliveryDt, frCode);
		return spCakeOrderList;

	}

	// Search Special Cake Order History
	@RequestMapping("/orderHistory")
	public @ResponseBody ItemOrderList searchOrderHistory(@RequestParam int menuId, @RequestParam String deliveryDt,
			@RequestParam int frId) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(deliveryDt);
		java.sql.Date deliveryDate = new java.sql.Date(date.getTime());
		
		ItemOrderList orderList = orderService.searchOrderHistory(menuId, deliveryDate, frId);
		
		return orderList;

	}

	// UserLogin of AdminPanel
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	@ResponseBody
	public LoginResponse loginUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		LoginResponse loginResponse = userService.findUserByUsername(username, password);

		return loginResponse;

	}

	// Save User
	@RequestMapping(value = { "/insertUser" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(@RequestParam("username") String username, @RequestParam("userpassword") String userpwd,
			@RequestParam("usertype") int usertype) {

		System.out.println("input user" + username.toString());
	
		User user = new User();
		user.setUsername(username);
		user.setPassword(userpwd);
		user.setUsertype(usertype);
		user.setDelStatus(0);
		
		String jsonResult = userService.save(user);
		
		return jsonResult;
	}

	// Save Rate
	@RequestMapping(value = { "/insertRate" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveRate(@RequestParam("sprName") String sprName, @RequestParam("sprRate") float sprRate,
			@RequestParam("sprAddOnRate") float sprAddOnRate) {

		Rates rate = new Rates();
		rate.setSprName(sprName);
		rate.setSprRate(sprRate);
		rate.setSprAddOnRate(sprAddOnRate);
		rate.setDelStatus(0);
		
		String jsonResult = rateService.save(rate);

		return jsonResult;
	}

	// Save spMessage
	@RequestMapping(value = { "/insertspMessage" }, method = RequestMethod.POST)
	@ResponseBody
	public String insertSpMessage(@RequestParam("spMsgText") String spMsgText) {

		SpMessage spmsg = new SpMessage();
		spmsg.setSpMsgText(spMsgText);
		spmsg.setDelStatus(0);
		
		String jsonResult = spMsgService.save(spmsg);

		return jsonResult;
	}

	// Save SubCategory
	@RequestMapping(value = { "/insertSubCategory" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveSubCategory(@RequestParam("subCatName") String subCatName, @RequestParam("catId") int catId) {

		SubCategory subCategory = new SubCategory();
		subCategory.setSubCatName(subCatName);
		// subCategory.setCatId(catId);
	
		String jsonResult = subCategoryService.saveSubCategory(subCategory);

		return jsonResult;
	}

	// Save Menu
	@RequestMapping(value = { "/insertMenu" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveMainConfigurationPage(@RequestParam("menuTitle") String menuTitle,
			@RequestParam("menuDescription") String menuDescription, @RequestParam("mainCatId") int mainCatId) {

		AllMenus menuConfigurationPage = new AllMenus();
		menuConfigurationPage.setMenuTitle(menuTitle);
		menuConfigurationPage.setMenuDesc(menuDescription);
		menuConfigurationPage.setMainCatId(mainCatId);

		String jsonResult = menuService.saveMenuConfigurationPage(menuConfigurationPage);

		return jsonResult;
	}

	// Save Item
		@RequestMapping(value = { "/insertItem" }, method = RequestMethod.POST)
		@ResponseBody
		public String saveItem(@RequestParam("itemId") String itemId, @RequestParam("itemName") String itemName,
				@RequestParam("itemGrp1") String itemGrp1, @RequestParam("itemGrp2") String itemGrp2,
				@RequestParam("itemGrp3") String itemGrp3, @RequestParam("itemRate1") double itemRate1,
				@RequestParam("itemRate2") double itemRate2,@RequestParam("itemRate3") double itemRate3, 
				@RequestParam("itemMrp1") double itemMrp1,@RequestParam("itemMrp2") double itemMrp2, 
				@RequestParam("itemImage") String itemImage,@RequestParam("itemTax1") double itemTax1, 
				@RequestParam("itemTax2") double itemTax2,@RequestParam("itemTax3") double itemTax3, 
				@RequestParam("itemIsUsed") int itemIsUsed,@RequestParam("itemSortId") double itemSortId, 
				@RequestParam("grnTwo") int grnTwo) {

			Item item = new Item();
			item.setItemImage(itemImage);
			item.setItemGrp1(itemGrp1);
			item.setDelStatus(0);
			item.setItemGrp2(itemGrp2);
			item.setItemGrp3(itemGrp3);
			item.setItemIsUsed(itemIsUsed);
			item.setItemMrp1(itemMrp1);
			item.setItemMrp2(itemMrp2);
			item.setItemRate1(itemRate1);
			item.setItemRate2(itemRate2);
			item.setItemRate3(itemRate3);
			item.setItemName(itemName);
			item.setItemSortId(itemSortId);
			item.setItemTax1(itemTax1);
			item.setItemTax2(itemTax2);
			item.setItemTax3(itemTax3);
			item.setGrnTwo(grnTwo);
			item.setItemId(itemId);
			item.setMinQty(0);
			
			ErrorMessage jsonResult = itemService.saveItem(item);

			return JsonUtil.javaToJson(jsonResult);
		}



	// Configure Franchisee
	@RequestMapping(value = { "/configureFranchisee" }, method = RequestMethod.POST)
	@ResponseBody
	public String configureFranchisee(@RequestParam("frId") int frId, @RequestParam("menuId") int menuId,
			@RequestParam("catId") int catId, @RequestParam("settingType") int settingType,
			@RequestParam("fromTime") String fromTime, @RequestParam("toTime") String toTime,
			@RequestParam("day") int day, @RequestParam("date") String date, @RequestParam("itemShow") String itemShow)
			throws ParseException {

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate;
		Date fDate = formatter.parse(date);

		java.sql.Date sqlDate = new java.sql.Date(fDate.getTime());
		ConfigureFranchisee configureFr = new ConfigureFranchisee();
		configureFr.setFrId(frId);
		configureFr.setMenuId(menuId);
		configureFr.setDelStatus(0);
		configureFr.setSettingType(settingType);
		configureFr.setFromTime(fromTime);
		configureFr.setToTime(toTime);
		configureFr.setDay(day);
		configureFr.setDate(sqlDate);
		configureFr.setItemShow(itemShow);
		configureFr.setCatId(catId);
		configureFr.setSubCatId(11);
		
		String jsonResult = connfigureService.configureFranchisee(configureFr);

		return jsonResult;
	}

	// Save Route
	@RequestMapping(value = { "/insertRoute" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveRoute(@RequestParam("routeName") String routeName) {
		String jsonResult = "";

		System.out.println("input route " + routeName.toString());
		
		Route route = new Route();
		route.setRouteName(routeName);
		route.setDelStatus(0);
		
		jsonResult = JsonUtil.javaToJson(route);
		jsonResult = routeService.save(route);

		return jsonResult;
	}

	//Save Franchisee
	@RequestMapping(value = { "/saveFranchisee" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveFranchisee(@RequestParam("frName") String frName, @RequestParam("frCode") String frCode,
			@RequestParam("frOpeningDate") String frOpeningDate, @RequestParam("frRate") int frRate,
			@RequestParam("frImage") String frImage, @RequestParam("frRouteId") int frRouteId,
			@RequestParam("frCity") String frCity, @RequestParam("frKg1") int frKg1, @RequestParam("frKg2") int frKg2,
			@RequestParam("frKg3") int frKg3, @RequestParam("frKg4") int frKg4, @RequestParam("frEmail") String frEmail,
			@RequestParam("frPassword") String frPassword, @RequestParam("frMob") String frMob,
			@RequestParam("frOwner") String frOwner, @RequestParam("frRateCat") int frRateCat,
			@RequestParam("grnTwo") int grnTwo) throws ParseException {

		//DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//java.util.Date date = sdf.parse(frOpeningDate);
		//java.sql.Date sqlOpeningDate = new java.sql.Date(date.getTime());
		java.sql.Date sqlOpeningDate=Common.convertToSqlDate(frOpeningDate);

		Franchisee franchisee = new Franchisee();
		// franchisee.setFrId(frId);
		franchisee.setFrName(frName);
		franchisee.setFrCode(frCode);
		franchisee.setFrOpeningDate(sqlOpeningDate);
		franchisee.setFrRate(frRate);
		franchisee.setFrImage(frImage);
		franchisee.setFrRouteId(frRouteId);
		franchisee.setFrCity(frCity);
		franchisee.setFrKg1(frKg1);
		franchisee.setFrKg2(frKg2);
		franchisee.setFrKg3(frKg3);
		franchisee.setFrKg4(frKg4);
		franchisee.setFrEmail(frEmail);
		franchisee.setFrPassword(frPassword);
		franchisee.setFrMob(frMob);
		franchisee.setFrOwner(frOwner);
		franchisee.setFrRateCat(frRateCat);
		franchisee.setGrnTwo(grnTwo);
		franchisee.setFrRmn1("");
		franchisee.setFrOpening(0);
		franchisee.setShowItems("");
		franchisee.setNotShowItems("");
		franchisee.setFrPasswordKey("");
		System.out.println("" + franchisee.toString());
		String jsonResult = franchiseeService.saveFranchisee(franchisee);

		return jsonResult;
	}

	// Special Cake Insert
	@RequestMapping(value = { "/insertSpecialCake" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveSpecialCake(@RequestParam("spCode") String spcode, @RequestParam("spName") String spname,
			@RequestParam("spType") int sptype, @RequestParam("spMinwt") String spminwt,
			@RequestParam("spMaxwt") String spmaxwt, @RequestParam("spBookb4") String spbookb4,
			@RequestParam("sprId") int sprid, @RequestParam("spImage") String spimage,
			@RequestParam("spTax1") double sptax1, @RequestParam("spTax2") double sptax2,
			@RequestParam("spTax3") double sptax3, @RequestParam("speIdlist") String speidlist,
			@RequestParam("erpLinkcode") String erplinkcode, @RequestParam("spPhoupload") int spphoupload,
			@RequestParam("timeTwoappli") int timetwoappli, @RequestParam("isUsed") int isused) {

		String jsonResult = "";
		try {
			SpecialCake specialcake = new SpecialCake();
			specialcake.setSpCode(spcode);
			specialcake.setSpName(spname);
			specialcake.setSpType(sptype);
			specialcake.setSpMinwt(spminwt);
			specialcake.setSpMaxwt(spmaxwt);
			specialcake.setSpBookb4(spbookb4);
			specialcake.setSprId(sprid);
			specialcake.setSpImage(spimage);
			specialcake.setSpTax1(sptax1);
			specialcake.setSpTax2(sptax2);
			specialcake.setSpTax3(sptax3);
			specialcake.setSpeIdlist(speidlist);
			specialcake.setErpLinkcode(erplinkcode);
			specialcake.setIsUsed(isused);
			specialcake.setSpPhoupload(spphoupload);
			specialcake.setTimeTwoappli(timetwoappli);
			specialcake.setBaseCode("0");
			specialcake.setDelStatus(0);

			jsonResult = specialcakeService.save(specialcake);
			System.out.println("\n " + jsonResult);
		} catch (Exception e) {
			System.out.println("inser cake error " + e.getMessage());

			e.printStackTrace();
		}
		return jsonResult;

	}

	// Save Message
	@RequestMapping(value = { "/insertMessage" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveMessage(@RequestParam("msgFrdt") String msgFrdt, @RequestParam("msgTodt") String msgTodt,
			@RequestParam("msgImage") String msgImage, @RequestParam("msgHeader") String msgHeader,
			@RequestParam("msgDetails") String msgDetails) {

		String jsonResult = "";
		try {
			
		

			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			//DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date fromDate;
			Date toDate = formatter.parse(msgTodt);
			fromDate = formatter.parse(msgFrdt);

			Message message = new Message();
			message.setMsgFrdt(fromDate);
			message.setMsgTodt(toDate);
			message.setMsgImage(msgImage);
			message.setMsgHeader(msgHeader);
			message.setMsgDetails(msgDetails);
			message.setIsActive(1);
			message.setDelStatus(0);

			System.out.println("input message " + message.toString());
			try {
				jsonResult = messageService.save(message);
			} catch (Exception e) {
				System.out.println("RestAPIController Save() Excep: " + e.getMessage());
			}

		} catch (Exception e) {

			System.out.println("RestAPIController Excep: " + e.getMessage());
			e.printStackTrace();
		}
		return jsonResult;

	}

	// Save Flavor
	@RequestMapping(value = { "/insertFlavour" }, method = RequestMethod.POST)

	public @ResponseBody ErrorMessage saveFlavour(@RequestParam("spType") int spType,
			@RequestParam("spfName") String spfName, @RequestParam("spfAdonRate") Double spfAdonRate) {
		
		ErrorMessage errorMessage = new ErrorMessage();
		
		try {
			Flavour flavour = new Flavour();
			flavour.setSpType(spType);
			flavour.setSpfName(spfName);
			flavour.setSpfAdonRate(spfAdonRate);
			flavour.setDelStatus(0);
			
			errorMessage = flavourService.save(flavour);
			
		} catch (Exception e) {
			System.out.println("Insert Flavour Error" + e.getMessage());
			e.printStackTrace();
		}

		return errorMessage;
	}

	// Save Scheduler
	@RequestMapping(value = { "/insertScheduler" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveSchedular(@RequestParam("schDate") String schDate, @RequestParam("schTodate") String schTodate,
			@RequestParam("schOccasionname") String schOccasionname, @RequestParam("schMessage") String schMessage,
			@RequestParam("schFrdttime") Double schFrdttime, @RequestParam("schTodttime") Double schTodttime) {
			String jsonScheduler = "";
			try {
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date fromDate, toDate;
			toDate = formatter.parse(schTodate);
			fromDate = formatter.parse(schDate);

			
			Scheduler scheduler = new Scheduler();
			scheduler.setSchDate(fromDate);
			scheduler.setSchTodate(toDate);
			scheduler.setSchOccasionname(schOccasionname);
			scheduler.setSchMessage(schMessage);
			scheduler.setSchFrdttime(schFrdttime);
			scheduler.setSchTodttime(schTodttime);
			scheduler.setIsActive(1);
			scheduler.setDelStatus(0);
			

			jsonScheduler = schedulerService.save(scheduler);

			System.out.println("Json intesrted " + jsonScheduler);

		} catch (Exception e) {
			System.out.println("Insert Scheduler Eror in controller " + e.getMessage());
		}
		return jsonScheduler;

	}

	// Save Event
	@RequestMapping(value = { "/insertEvent" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveEvent(@RequestParam("speName") String speName) {
		
		String jsonEvent = "";
		
		try {
			Event event = new Event();
			event.setSpeName(speName);
			event.setDelStatus(0);
			jsonEvent = eventService.save(event);

		} catch (Exception e) {
			System.out.println("Exce in Insert Event @ Controller" + e.getMessage());
			e.printStackTrace();
		}
		return jsonEvent;

	}

   //Show Route List
	@RequestMapping(value = { "/showRouteList" }, method = RequestMethod.GET)
	@ResponseBody
	public RouteList showRouteList() {

		List<Route> jsonRouteList = routeService.showAllRoute();

		RouteList routeList = new RouteList();
		routeList.setRoute(jsonRouteList);
		Info info = new Info();
		info.setError(false);
		info.setMessage("Route displayed Successfully ");
		routeList.setInfo(info);

		return routeList;
	}

	// show Special Cake
	@RequestMapping(value = { "/showSpecialCakeList" }, method = RequestMethod.GET)
	@ResponseBody
	public SpecialCakeList showSpecialCakeList() {
		List<SpecialCake> jsonSpecialCakeList = specialcakeService.showAllSpecialCake();
		SpecialCakeList specialCakeList = new SpecialCakeList();
		specialCakeList.setSpecialCake(jsonSpecialCakeList);
		Info info = new Info();
		info.setError(false);
		info.setMessage("SpecialCake list displayed Successfully");
		specialCakeList.setInfo(info);
		return specialCakeList;

	}

	// Show Message List
	@RequestMapping(value = { "/showMessageList" }, method = RequestMethod.GET)
	@ResponseBody
	public MessageList showMessageList() {

		List<Message> jsonMessageList = messageService.findAllMessage();
		
		
		
		
		MessageList messageList = new MessageList();
		messageList.setMessage(jsonMessageList);
		Info info = new Info();
		info.setError(false);
		info.setMessage("Message list displayed Successfully");
		messageList.setInfo(info);

		return messageList;
	}

	// Show All Main and sub Category
	@RequestMapping(value = { "/showAllCategory" }, method = RequestMethod.GET)

	public @ResponseBody CategoryList showAllCategory() {

		List<MCategory> jsonCategoryResponse = categoryService.findAllCategory();
		CategoryList categoryList = new CategoryList();
		ErrorMessage errorMessage = new ErrorMessage();

		errorMessage.setError(false);
		errorMessage.setMessage("Success");
		categoryList.setErrorMessage(errorMessage);
		categoryList.setmCategoryList(jsonCategoryResponse);

		return categoryList;
	}

	// Show Event List
	@RequestMapping(value = { "/showEventList" }, method = RequestMethod.GET)
	@ResponseBody
	public EventList showEvent() {

		List<Event> jsonEventList = eventService.findAllEvent();
		EventList eventList = new EventList();
		eventList.setEvent(jsonEventList);
		Info info = new Info();
		info.setError(false);
		info.setMessage("Event List displayed Successfully");
		eventList.setInfo(info);

		return eventList;
	}

	// Show Flavor List
	@RequestMapping(value = { "/showFlavourList" }, method = RequestMethod.GET)
	@ResponseBody
	public FlavourList showFlavourList() {

		List<Flavour> jsonFlavourtList = flavourService.findAllFlavour();
		FlavourList flavourList = new FlavourList();
		flavourList.setFlavour(jsonFlavourtList);
		Info info = new Info();
		info.setError(false);
		info.setMessage("Flavour list displayed Successfully");
		flavourList.setInfo(info);

		return flavourList;
	}

	// Show Scheduler List
	@RequestMapping(value = { "/showSchedulerList" }, method = RequestMethod.GET)
	@ResponseBody
	public SchedulerList showSchedulerList() {

		List<Scheduler> jsonSchedulertList = schedulerService.showAllScheduler();
		System.out.println("Scheduler list" + jsonSchedulertList.toString());

		SchedulerList schedulerList = new SchedulerList();
		schedulerList.setSchedulerList(jsonSchedulertList);
		Info info = new Info();
		info.setError(false);
		info.setMessage("scheduler displayed successfully");
		schedulerList.setInfo(info);

		return schedulerList;
	}

	// Update Item
		@RequestMapping("/updateItem")
		public ErrorMessage updateItem(@RequestParam("id") int id, @RequestParam("itemId") String itemId,
				@RequestParam("itemName") String itemName, @RequestParam("itemGrp1") String itemGrp1,
				@RequestParam("itemGrp2") String itemGrp2, @RequestParam("itemGrp3") String itemGrp3,
				@RequestParam("itemRate1") double itemRate1, @RequestParam("itemRate2") double itemRate2,@RequestParam("itemRate3") double itemRate3,
				@RequestParam("itemMrp1") double itemMrp1, @RequestParam("itemMrp2") double itemMrp2,
				@RequestParam("itemImage") String itemImage, @RequestParam("itemTax1") double itemTax1,
				@RequestParam("itemTax2") double itemTax2, @RequestParam("itemTax3") double itemTax3,
				@RequestParam("itemIsUsed") int itemIsUsed, @RequestParam("itemSortId") double itemSortId,
				@RequestParam("grnTwo") int grnTwo) {

			Item item = itemService.findItems(id);
			item.setItemImage(itemImage);
			item.setItemGrp1(itemGrp1);
			item.setItemGrp2(itemGrp2);
			item.setItemGrp3(itemGrp3);

			item.setItemIsUsed(itemIsUsed);
			item.setItemMrp1(itemMrp1);
			item.setItemMrp2(itemMrp2);
			item.setItemRate1(itemRate1);
			item.setItemRate2(itemRate2);
			item.setItemRate3(itemRate3);
			item.setItemName(itemName);
			item.setItemSortId(itemSortId);
			item.setItemTax1(itemTax1);
			item.setItemTax2(itemTax2);
			item.setItemTax3(itemTax3);
			item.setGrnTwo(grnTwo);
			item.setItemId(itemId);
	        
			ErrorMessage jsonResult = itemService.saveItem(item);
			return jsonResult;
		}

	// Update Sub Categories
	@RequestMapping("/updateSubCategories")
	public String updateSubCategory(@RequestParam("subCatId") int subCatId,
			@RequestParam("subCatName") String subCatName, @RequestParam("catId") int catId) {

		SubCategory subCategory = subCategoryService.findSubCategory(subCatId);
		subCategory.setSubCatName(subCatName);
		// subCategory.setCatId(catId);

		String jsonResult = subCategoryService.saveSubCategory(subCategory);

		return JsonUtil.javaToJson(jsonResult);
	}

	// Delete Route
	@RequestMapping("/deleteRoute")
	public @ResponseBody String deleteRoute(@RequestParam int routeId) {

		Info info = new Info();
		Route route = routeService.findRoute(routeId);
		route.setDelStatus(1);
		String jsonResult = routeService.save(route);
		try {
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("Route deletion failure");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("Route deleted with id " + routeId);
			}
		} catch (Exception e) {
			System.out.println("error in delete route" + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());
		}
		return JsonUtil.javaToJson(info);

	}

	// Delete Message
	@RequestMapping("/deleteMessage")
	public @ResponseBody String deleteMessage(@RequestParam int id) {

		Info info = new Info();
		try {
			Message message = messageService.findMessage(id);
			message.setDelStatus(1);
			String jsonResult = messageService.save(message);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("Message deletion failed");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("Message deletion Successful");
			}
		} catch (Exception e) {
			System.out.println("Exce in message deletion" + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());
		}
		return JsonUtil.javaToJson(info);

	}

	// Delete Item
	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public @ResponseBody String deleteItem(@RequestParam int id) {

		Item item = itemService.findItems(id);
		item.setDelStatus(1);

		ErrorMessage errorMessage = itemService.saveItem(item);

		return JsonUtil.javaToJson(errorMessage);
	}

	// Delete Flavor
	@RequestMapping(value = "/deleteFlavour", method = RequestMethod.POST)
	public @ResponseBody String deleteFlavour(@RequestParam int spfId) {

		Flavour flavour = flavourService.findFlavour(spfId);
		flavour.setDelStatus(1);

		ErrorMessage errorMessage = flavourService.save(flavour);

		return JsonUtil.javaToJson(errorMessage);
	}

	// Delete Rates
	@RequestMapping(value = "/deleteRates", method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRates(@RequestParam int sprId) {

		Rates rate = rateService.findRate(sprId);
		rate.setDelStatus(1);

		String rates = rateService.save(rate);
		ErrorMessage errorMessage = new ErrorMessage();
		if (rates != "") {
			errorMessage.setError(false);
			errorMessage.setMessage("Rates deleted Successfully");
		} else {
			errorMessage.setError(true);
			errorMessage.setMessage("Rates deletion failed");

		}
		return errorMessage;
	}

	// Delete Rates
	@RequestMapping(value = "/deleteSpMessage", method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSpMessage(@RequestParam int spMsgId) {

		SpMessage spMessage = spMsgService.findSpMessage(spMsgId);
		spMessage.setDelStatus(1);

		String spMessages = spMsgService.save(spMessage);
		ErrorMessage errorMessage = new ErrorMessage();
		if (spMessages != "") {
			errorMessage.setError(false);
			errorMessage.setMessage("SpMessage deleted Successfully");
		} else {
			errorMessage.setError(true);
			errorMessage.setMessage("SpMessage deletion failed");

		}
		return errorMessage;
	}

	// Delete Menu
	@RequestMapping("/deleteMenu")
	public @ResponseBody String deleteMenu(@RequestParam int menuId) {

		AllMenus allMenus = menuService.findMenu(menuId);
		allMenus.setDelStatus(1);

		String allMenu = menuService.saveMenuConfigurationPage(allMenus);

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setError(false);
		errorMessage.setMessage("MenuItem #" + menuId + " deleted successfully");

		return JsonUtil.javaToJson(errorMessage);
	}

	// Delete SubCategory
	@RequestMapping("/deleteSubCategory")
	public @ResponseBody String deleteSubCategory(@RequestParam int subCatId) {

		SubCategory subCategory = subCategoryService.findSubCategory(subCatId);
		subCategory.setDelStatus(1);

		String allMenu = subCategoryService.saveSubCategory(subCategory);
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setError(true);
		errorMessage.setMessage("SubCategory #" + subCatId + " deleted successfully");

		return JsonUtil.javaToJson(errorMessage);
	}

	// Delete Event
	@RequestMapping("/deleteEvent")
	public @ResponseBody String deleteEvent(@RequestParam int id) {

		Info info = new Info();
		try {
			Event event = eventService.findEvent(id);
			event.setDelStatus(1);
			String jsonResult = eventService.save(event);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("Event deletion failed");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("Event deletion Successful");
			}
		} catch (Exception e) {
			System.out.println("error in delete event" + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());
		}
		return JsonUtil.javaToJson(info);
	}

	//Delete Scheduler
	@RequestMapping("/deleteScheduler")
	public @ResponseBody String deleteScheduler(@RequestParam int schId) {

		Info info = new Info();
		try {
			Scheduler scheduler = schedulerService.findScheduler(schId);
			scheduler.setDelStatus(1);

			String jsonResult = schedulerService.save(scheduler);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("delete Failure");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("deleted Successfully");

			}

		} catch (Exception e) {
			System.out.println("error in scheduler delete" + e.getMessage());
			e.printStackTrace();
			e.getMessage();
			info.setError(true);
			info.setMessage("" + e.getMessage());

		}
		return "" + JsonUtil.javaToJson(info);

	}

	//Delete Franchisee
	@RequestMapping("/deleteFranchisee")
	public @ResponseBody String deleteFranchisee(@RequestParam int frId) {
		Info info = new Info();
		try {
			Franchisee franchisee = franchiseeService.findFranchisee(frId);
			franchisee.setDelStatus(1);
			String jsonResult = franchiseeService.saveFranchisee(franchisee);
			if (jsonResult == "") {
				info.setError(true);
				info.setMessage("Franchisee deletion failed");
			} else if (jsonResult != "") {
				info.setError(false);
				info.setMessage("Franchisee deletion Successful");
			}
		} catch (Exception e) {
			System.out.println("error in Franchisee delete" + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());

		}

		return "" + JsonUtil.javaToJson(info);
	}

	//Update Event
	@RequestMapping("/updateEvent")
	public @ResponseBody String updateEvent(@RequestParam int id, @RequestParam String speName) {

		Event event = eventService.findEvent(id);
		Info info = new Info();
		try {
			event.setSpeName(speName);
			String jsonResult = eventService.save(event);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("Event Update Failure");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("Event updated successfully");
			}
		} catch (Exception e) {
			System.out.println("error in event updated" + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());
		}
		return "" + JsonUtil.javaToJson(info);

	}
	
    //Get Event
	@RequestMapping(value = "/getEvent")
	public @ResponseBody Event getEvent(@RequestParam int speId) {

		Event event = eventService.findEventById(speId);
		return event;

	}
	
    //Get Rate
	@RequestMapping(value = "/getRate")
	public @ResponseBody Rates getRate(@RequestParam int sprId) {

		Rates rates = rateService.findRate(sprId);
		return rates;

	}
    //Get SubCategories
	@RequestMapping(value = "/getSubCategories")
	public @ResponseBody List<SubCategory> getAllSubCategories(@RequestParam int catId) {

		List<SubCategory> subCategoryList = new ArrayList<SubCategory>();
		subCategoryList = subCategoryService.findSubCategoryByCatId(catId);
		return subCategoryList;

	}
    //Get Flavour
	@RequestMapping(value = "/getFlavour", method = RequestMethod.GET)
	public @ResponseBody Flavour getFlavour(@RequestParam int spfId) {

		Flavour flavour = flavourService.findFlavour(spfId);
		return flavour;

	}
    //Get Items
	@RequestMapping(value = "/getItems", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItems(@RequestParam String itemGrp1, @RequestParam String itemGrp2) {

		List<Item> items = itemService.findFrItems(itemGrp1, itemGrp2);
		return items;

	}
    //
	@RequestMapping(value = "/getFrMenus11", method = RequestMethod.POST)
	public @ResponseBody FrMenusList getFrMenus(@RequestParam int frId) {

		List<FrMenus> frMenus = connfigureService.findFrMenus(frId);
		FrMenusList frMenusList = new FrMenusList();
		ErrorMessage errorMessage = new ErrorMessage();
		if (frMenus != null) {
			errorMessage.setError(false);
			errorMessage.setMessage("All Configured menu list displayed successfully");
			frMenusList.setErrorMessage(errorMessage);
			frMenusList.setFrMenus(frMenus);
		} else {
			errorMessage.setError(true);
			errorMessage.setMessage("Configured menu list not found");
			frMenusList.setErrorMessage(errorMessage);
			frMenusList.setFrMenus(frMenus);

		}
		return frMenusList;

	}

	@RequestMapping(value = "/getFrConfigMenus", method = RequestMethod.POST)
	public @ResponseBody FrMenusList getFrConfigMenus(@RequestParam int frId) {

		List<FrMenus> frMenus = connfigureService.findFrMenus(frId);
		FrMenusList frMenusList = new FrMenusList();
		ErrorMessage errorMessage = new ErrorMessage();
		if (frMenus != null) {
			errorMessage.setError(false);
			errorMessage.setMessage("All Configured menu list displayed successfully");
			frMenusList.setErrorMessage(errorMessage);
			frMenusList.setFrMenus(frMenus);
		} else {
			errorMessage.setError(true);
			errorMessage.setMessage("Configured menu list not found");
			frMenusList.setErrorMessage(errorMessage);
			frMenusList.setFrMenus(frMenus);

		}
		return frMenusList;

	}

	@RequestMapping(value = "/getFrMenus", method = RequestMethod.POST)
	public @ResponseBody List<ConfigureFranchisee> getFr(@RequestParam int frId) {

		List<ConfigureFranchisee> ConfigureFranchisees = new ArrayList<>();
		System.out.println("input param frid= " + frId);
		try {
			ConfigureFranchisees = frService.findFrMenus();
			System.out.println("All Record" + ConfigureFranchisees.toString());

		} catch (Exception e) {
			System.out.println("Exception fr Menu " + e.getMessage());
		}

		return ConfigureFranchisees;

	}


	//3

	@RequestMapping(value = "/getFrItems", method = RequestMethod.POST)
		public @ResponseBody List<GetFrItems> getFrItems(@RequestParam List<Integer> items, @RequestParam String frId,
				@RequestParam String date, @RequestParam String menuId) {

			List<ItemWithSubCat> itemList = new ArrayList<>();
			List<GetFrItems> frItemList = new ArrayList<>();

			List<Orders> orderList = new ArrayList<>();

			System.out.println("input param items= " + items.toString());
			try {
				itemList = getFrItemsService.findFrItems(items);
				try {
					orderList = prevItemOrderService.findFrItemOrders(items, frId, date, menuId);

					for (int i = 0; i < itemList.size(); i++) {

						ItemWithSubCat item = itemList.get(i);

						GetFrItems getFrItems = new GetFrItems();
						
						

						getFrItems.setDelStatus(item.getDelStatus());
						getFrItems.setGrnTwo(item.getGrnTwo());
						getFrItems.setId(item.getId());
						getFrItems.setItemGrp1(item.getItemGrp1());
						getFrItems.setItemGrp2(item.getItemGrp2());
						getFrItems.setItemGrp3(item.getItemGrp3());
						getFrItems.setItemId(item.getItemId());
						getFrItems.setItemImage(item.getItemImage());
						getFrItems.setItemIsUsed(item.getItemIsUsed());
						getFrItems.setItemMrp1(item.getItemMrp1());
						getFrItems.setItemMrp2(item.getItemMrp2());
						getFrItems.setItemName(item.getItemName());
						getFrItems.setItemRate1(item.getItemRate1());
						getFrItems.setItemRate2(item.getItemRate2());
						getFrItems.setItemSortId(item.getItemSortId());
						getFrItems.setItemTax1(item.getItemTax1());
						getFrItems.setItemTax2(item.getItemTax2());
						getFrItems.setItemTax3(item.getItemTax3());
						getFrItems.setSubCatName(item.getSubCatName());
	                    getFrItems.setMinQty(item.getMinQty());
	                    getFrItems.setItemRate3(item.getItemRate3());
						
						for (int j = 0; j < orderList.size(); j++) {

							if (item.getItemId().equalsIgnoreCase(orderList.get(j).getItemId())) {

								getFrItems.setItemQty(orderList.get(j).getOrderQty());
								getFrItems.setMenuId(orderList.get(j).getMenuId());

							}

						}

						frItemList.add(getFrItems);

					}

				} catch (Exception e) {
					System.out.println("Exception fr Prev Item order " + e.getMessage());
				}
				System.out.println("All Prev Order Record" + orderList.toString());

			} catch (Exception e) {
				System.out.println("Exception fr Items " + e.getClass());
			}

			return frItemList;

		}

	@RequestMapping("/getMessage")
	public @ResponseBody Message getMessage(@RequestParam int msgId) {

		Message message = messageService.findMessage(msgId);
		return message;

	}

	@RequestMapping("/getSpMessage")
	public @ResponseBody SpMessage getSpMessage(@RequestParam int msgId) {

		SpMessage spMessage = spMsgService.findSpMessage(msgId);
		return spMessage;

	}

	// Get All Items
	@RequestMapping(value = { "/getAllItems" }, method = RequestMethod.GET)
	public @ResponseBody ItemsList findAllItems() {
		ItemsList itemsList = itemService.findAllItems();
		return itemsList;
	}

	// Get All Menus
	@RequestMapping(value = { "/getAllMenu" }, method = RequestMethod.GET)
	public @ResponseBody AllMenuJsonResponse findAllMenu() {
		AllMenuJsonResponse menus = menuService.findAllMenu();
		return menus;
	}

	// Get All Franchisee and Menu
	@RequestMapping(value = { "/getAllFranchiseeAndMenu" }, method = RequestMethod.GET)
	public @ResponseBody AllFranchiseeAndMenu findAllFranchiseeAndMenu() {
		List<AllMenus> allMenu = menuService.findAllMenus();
		List<Franchisee> allFranchisee = franchiseeService.findAllFranchisee();
		List<Item> items = itemService.getAllItems();
		List<SubCategory> subCategories = subCategoryService.getAllSubCategory();
		AllFranchiseeAndMenu allFranchiseeAndMenu = new AllFranchiseeAndMenu();
		allFranchiseeAndMenu.setAllFranchisee(allFranchisee);
		allFranchiseeAndMenu.setAllMenu(allMenu);
		allFranchiseeAndMenu.setItems(items);
		allFranchiseeAndMenu.setSubCategories(subCategories);
		return allFranchiseeAndMenu;
	}

	// Get Item
	@RequestMapping(value = { "/getItem" }, method = RequestMethod.GET)
	public @ResponseBody Item findItem(@RequestParam("id") int id) {
		Item item = itemService.findItem(id);
		return item;
	}

	// Get Franchisee
	@RequestMapping(value = { "/getFranchisee" }, method = RequestMethod.GET)
	public @ResponseBody Franchisee findFranchisee(@RequestParam("frId") int frId) {
		Franchisee franchisee = franchiseeService.findFranchisee(frId);
		return franchisee;
	}

	// Get Route
	@RequestMapping(value = { "/getRoute" }, method = RequestMethod.GET)
	public @ResponseBody Route findRoute(@RequestParam("routeId") int routeId) {
		Route route = routeService.findRoute(routeId);
		return route;
	}

	// Get Message
	@RequestMapping(value = { "/getMessage" }, method = RequestMethod.GET)
	public @ResponseBody Message findMessage(@RequestParam("msgId") int msgId) {
		Message message = messageService.findMessage(msgId);
		return message;
	}

	// Get All SubCategories
	@RequestMapping(value = { "/getAllSubCategories" }, method = RequestMethod.GET)
	public @ResponseBody SubCatergoryList getAllSubCategories() {
		SubCatergoryList subCategoryList = subCategoryService.findAllSubCategories();

		return subCategoryList;
	}

	// Get All Modules
	@RequestMapping(value = { "/getAllModules" }, method = RequestMethod.GET)
	public @ResponseBody ModulesList getAllModules() {
		List<MainModuleWithSubModule> modules = moduleService.findAll();
		ModulesList modulesList = new ModulesList();

		if (modules != null) {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setError(false);
			errorMessage.setMessage("All Modules displayed successfully");
			modulesList.setErrorMessage(errorMessage);
			modulesList.setMainModuleWithSubModule(modules);
		} else {
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("Modules not found");
			modulesList.setErrorMessage(errorMessage);

		}
		return modulesList;
	}

	// Get All Franchisees
	@RequestMapping(value = { "/getAllFranchisee" }, method = RequestMethod.GET)
	public @ResponseBody FranchiseeList getAllFranchinsees() {
		List<Franchisee> franchisee = franchiseeService.findAllFranchisee();
		FranchiseeList franchiseeList = new FranchiseeList();
		franchiseeList.setFranchiseeList(franchisee);
		ErrorMessage errorMessage = new ErrorMessage();
		if (franchisee != null) {
			errorMessage.setError(false);
			errorMessage.setMessage("Franchisee displayed Successfully");
			franchiseeList.setErrorMessage(errorMessage);

		} else {
			errorMessage.setError(true);
			errorMessage.setMessage("Franchisee Not displayed");
			franchiseeList.setErrorMessage(errorMessage);
		}

		return franchiseeList;
	}

	// Get All Rates
	@RequestMapping(value = { "/getAllRates" }, method = RequestMethod.GET)
	public @ResponseBody RateList findAllRate() {
		RateList itemsList = rateService.findAllRates();
		return itemsList;
	}

	// Get All SpMessage
	@RequestMapping(value = { "/getAllSpMessage" }, method = RequestMethod.GET)
	public @ResponseBody spMessageList findAllspMessage() {
		spMessageList itemsList = spMsgService.findAllspMessage();
		return itemsList;
	}

	// Update Flavour
	@RequestMapping("/updateFlavour")
	public @ResponseBody String updateFlavour(@RequestParam int id, @RequestParam int spType,
			@RequestParam String spfName, @RequestParam double spfAdOnRate) {

		Flavour flavour = flavourService.findFlavour(id);
		ErrorMessage errorMessage = null;
		try {
			flavour.setSpType(spType);
			flavour.setSpfName(spfName);
			flavour.setSpfAdonRate(spfAdOnRate);
			errorMessage = flavourService.save(flavour);
			if (errorMessage == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Flavour update failure");
			} else if (errorMessage != null) {
				errorMessage.setError(false);
				errorMessage.setMessage("Flavour updated Successfully");
			}
		} catch (Exception e) {
			System.out.println("error in flavour update " + e.getMessage());
			errorMessage.setError(true);
			errorMessage.setMessage("" + e.getMessage());
		}
		return JsonUtil.javaToJson(errorMessage);
	}

	// update Message
	@RequestMapping(value = { "/updateMessage" }, method = RequestMethod.POST)
	public @ResponseBody String updateMessage(@RequestParam int id, @RequestParam String msgFrdt,
			@RequestParam String msgTodt, @RequestParam String msgImage, @RequestParam String msgHeader,
			@RequestParam String msgDetails) {

		Message message = messageService.findMessage(id);
		Info info = new Info();
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate, toDate;
			toDate = formatter.parse(msgTodt);
			fromDate = formatter.parse(msgFrdt);
			message.setMsgFrdt(fromDate);
			message.setMsgTodt(toDate);
			message.setMsgImage(msgImage);
			message.setMsgHeader(msgHeader);
			message.setMsgDetails(msgDetails);

			String jsonResult = messageService.save(message);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("Message update Failure");
			} else {
				info.setError(false);
				info.setMessage("Message updated successfully");

			}
		} catch (Exception e) {
			System.out.println("error in message update " + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());

		}
		return "" + JsonUtil.javaToJson(info);

	}

	// Update Schedular
	@RequestMapping("/updateScheduler")
	public @ResponseBody String updateScheduler(@RequestParam int id, @RequestParam String schdate,
			@RequestParam String schtodate, @RequestParam String schccasionname, @RequestParam String schmessage,
			@RequestParam double schfrdttime, @RequestParam double schtodttime) {

		Scheduler scheduler = schedulerService.findScheduler(id);
		Info info = new Info();
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date fromDate, toDate;
			toDate = formatter.parse(schtodate);
			fromDate = formatter.parse(schdate);
			scheduler.setSchDate(fromDate);
			scheduler.setSchTodate(toDate);
			scheduler.setSchOccasionname(schccasionname);
			scheduler.setSchMessage(schmessage);
			scheduler.setSchFrdttime(schfrdttime);
			scheduler.setSchTodttime(schtodttime);
			String jsonResult = schedulerService.save(scheduler);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("scheduler Update failure");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("scheduler Update successfully");
			}

		} catch (Exception e) {
			System.out.println("error in updating schedule " + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());

		}

		return JsonUtil.javaToJson(info);
	}

	// Update Route
	@RequestMapping("/updateRoute")
	public @ResponseBody String updateRoute(@RequestParam int id, @RequestParam String routeName) {

		Route route = routeService.findRoute(id);
		Info info = new Info();
		try {
			route.setRouteName(routeName);

			String jsonResult = routeService.save(route);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("Route update failure");

			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("Route Update Successful");
			}

		} catch (Exception e) {
			System.out.println("error in route update" + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());
		}
		return JsonUtil.javaToJson(info);
	}

	// Update Special Cake
	@RequestMapping("/updateSpecialCake")
	public @ResponseBody String updateSpecialCake(@RequestParam int id, @RequestParam String spname,
			@RequestParam int sptype, @RequestParam String spminwt, @RequestParam String spmaxwt,
			@RequestParam String spbookb4, @RequestParam int sprid, @RequestParam String spimage,
			@RequestParam double sptax1, @RequestParam double sptax2, @RequestParam double sptax3,
			@RequestParam String spidlist, @RequestParam String erplinkcode, @RequestParam int spphoupload,
			@RequestParam int timetwoappli) {

		SpecialCake specialCake = specialcakeService.findSpecialCake(id);
		Info info = new Info();
		try {
			specialCake.setSpName(spname);
			specialCake.setSpType(sptype);
			specialCake.setSpMinwt(spminwt);
			specialCake.setSpMaxwt(spmaxwt);
			specialCake.setSpBookb4(spbookb4);
			specialCake.setSprId(sprid);
			specialCake.setSpImage(spimage);
			specialCake.setSpTax1(sptax1);
			specialCake.setSpTax2(sptax2);
			specialCake.setSpTax3(sptax3);
			specialCake.setSpeIdlist(spidlist);
			specialCake.setErpLinkcode(erplinkcode);
			specialCake.setSpPhoupload(spphoupload);
			specialCake.setTimeTwoappli(timetwoappli);
			specialCake.setBaseCode("0");
			specialCake.setIsUsed(1);

			String jsonResult = specialcakeService.save(specialCake);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("Special cake update failed");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("Special cake successfully updated");
			}
		} catch (Exception e) {
			info.setError(true);
			info.setMessage("" + e.getMessage());
		}

		return "" + JsonUtil.javaToJson(info);

	}

	// Delete Special Cake
	@RequestMapping(value = "/deleteSpecialCake")
	public @ResponseBody String deleteSpecialCake(@RequestParam int spId) {

		Info info = new Info();
		try {
			SpecialCake specialCake = specialcakeService.findSpecialCake(spId);
			specialCake.setDelStatus(1);
			String jsonResult = specialcakeService.save(specialCake);

			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("deletion of Special Cake failed");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("deletion of Special Cake Successful");

			}
		} catch (Exception e) {
			System.out.println("error in deleting special cake" + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());

		}
		return "" + JsonUtil.javaToJson(info);
	}

	/*
	 * @RequestMapping(value = { "/getOrderList" }, method = RequestMethod.POST)
	 * 
	 * @ResponseBody public GetOrderList getOrderList(@RequestParam String itemId) {
	 * GetOrderList orderList = new GetOrderList(); try { DateFormat formatter = new
	 * SimpleDateFormat("MM/dd/yyyy"); Date date1; //date1= formatter.parse(date);
	 * System.out.println("Input- ItemId: "+itemId);
	 * 
	 * List<GetOrder> jsonOrderList = orderService.findOrder(itemId);
	 * 
	 * orderList.setGetOrder(jsonOrderList); Info info = new Info();
	 * info.setError(false); info.setMessage("Order list displayed Successfully");
	 * orderList.setInfo(info);
	 * 
	 * }catch (Exception e) {
	 * 
	 * System.out.println("exception in order list rest controller"+e.getMessage());
	 * } return orderList;
	 * 
	 * }
	 */
	// spCakeOrderService 3 sept sachin spCakeOrdersService

	@RequestMapping(value = { "/getSpCakeOrderList" }, method = RequestMethod.POST)
	@ResponseBody
	public SpCakeOrdersList getSpCakeOrderList(@RequestParam List<Integer> frId, @RequestParam String prodDate) {
		SpCakeOrdersList spCakeOrderList = new SpCakeOrdersList();
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date pDate;
			pDate = formatter.parse(prodDate);

			List<SpCakeOrders> jsonSpCakeOrderList = spCakeOrdersService.findSpCakeOrder(frId, pDate);

			spCakeOrderList.setSpCakeOrders(jsonSpCakeOrderList);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Sp Cake Order list displayed Successfully");
			spCakeOrderList.setInfo(info);

		} catch (Exception e) {

			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return spCakeOrderList;

	}

	// 29 aug updateFranchisee web service
	@RequestMapping(value = { "/updateFranchisee" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateFranchisee(@RequestParam("frId") int frId, @RequestParam("frName") String frName,
			@RequestParam("frCode") String frCode, @RequestParam("frOpeningDate") String frOpeningDate,
			@RequestParam("frRate") int frRate, @RequestParam("frImage") String frImage,
			@RequestParam("frRouteId") int frRouteId, @RequestParam("frCity") String frCity,
			@RequestParam("frKg1") int frKg1, @RequestParam("frKg2") int frKg2, @RequestParam("frKg3") int frKg3,
			@RequestParam("frKg4") int frKg4, @RequestParam("frEmail") String frEmail,
			@RequestParam("frPassword") String frPassword, @RequestParam("frMob") String frMob,
			@RequestParam("frOwner") String frOwner, @RequestParam("frRateCat") int frRateCat,
			@RequestParam("grnTwo") int grnTwo, @RequestParam("delStatus") int delStatus) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf.parse(frOpeningDate);
		java.sql.Date sqlOpeningDate = new java.sql.Date(date.getTime());

		Franchisee franchisee = franchiseeService.findFranchisee(frId);
		// franchisee.setFrId(frId);
		franchisee.setFrName(frName);
		franchisee.setFrCode(frCode);
		franchisee.setFrOpeningDate(sqlOpeningDate);
		franchisee.setFrRate(frRate);
		franchisee.setFrImage(frImage);
		franchisee.setFrRouteId(frRouteId);
		franchisee.setFrCity(frCity);
		franchisee.setFrKg1(frKg1);
		franchisee.setFrKg2(frKg2);
		franchisee.setFrKg3(frKg3);
		franchisee.setFrKg4(frKg4);
		franchisee.setFrEmail(frEmail);
		franchisee.setFrPassword(frPassword);
		franchisee.setFrMob(frMob);
		franchisee.setFrOwner(frOwner);
		franchisee.setFrRateCat(frRateCat);
		franchisee.setGrnTwo(grnTwo);
		franchisee.setFrRmn1("");
		franchisee.setFrOpening(0);
		franchisee.setShowItems("");
		franchisee.setNotShowItems("");
		franchisee.setFrPasswordKey("");
		franchisee.setDelStatus(delStatus);
		System.out.println("" + franchisee.toString());
		String jsonResult = franchiseeService.saveFranchisee(franchisee);

		return jsonResult;
	}

	// 27 aug
	// update rate
	@RequestMapping("/updateRate")
	public String updateRate(@RequestParam("sprId") int sprId, @RequestParam("sprName") String sprName,
			@RequestParam("sprRate") float sprRate, @RequestParam("sprAddOnRate") float sprAddOnRate) {

		Rates rate = rateService.findRate(sprId);

		// subCategory.setSubCatName(subCatName);
		// subCategory.setCatId(catId);

		rate.setSprName(sprName);
		rate.setSprAddOnRate(sprAddOnRate);
		rate.setSprRate(sprRate);

		String jsonResult = rateService.save(rate);

		return JsonUtil.javaToJson(jsonResult);
	}

	// update SpMessage
	@RequestMapping(value = { "/updateSpMessage" }, method = RequestMethod.POST)
	@ResponseBody
	public String updateSpMessage(@RequestParam("spMsgId") int spMsgId, @RequestParam("spMsgText") String spMsgText) {

		SpMessage spMessage = spMsgService.findSpMessage(spMsgId);
		spMessage.setSpMsgText(spMsgText);
		String jsonResult = spMsgService.save(spMessage);

		return "jsonResult";
	}

	// get Special Cake

	@RequestMapping("/getSpecialCake")
	public @ResponseBody SpecialCake getSpecialCake(@RequestParam int spId) {

		SpecialCake specialCake = specialcakeService.findSpecialCake(spId);
		return specialCake;

	}

	// get Scheduler or news
	@RequestMapping(value = "/getScheduler")
	public @ResponseBody Scheduler getScheduler(@RequestParam int schId) {

		Scheduler scheduler = schedulerService.findScheduler(schId);
		return scheduler;

	}

	// order Service 1 sept Sachin
	@RequestMapping(value = { "/getOrderList" }, method = RequestMethod.POST)
	@ResponseBody
	public GetOrderList getOrderList2(@RequestParam List<Integer> frId, @RequestParam List<Integer> menuId,
			@RequestParam String date) {
		GetOrderList orderList = new GetOrderList();
		try {
	/*		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

			Date date1;
			date1 = formatter.parse(date);*/
			System.out.println("date str :" + date);

			String strDate= Common.convertToYMD(date);
			System.out.println("Converted date "+strDate);
			
			System.out.println("fr id in rest " + frId.toString());
			List<GetOrder> jsonOrderList = getOrderService.findOrder2(frId, menuId, strDate);

			orderList.setGetOrder(jsonOrderList);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Order list displayed Successfully");
			orderList.setInfo(info);

		} catch (Exception e) {

			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return orderList;

	}

	// 7 sep orderlist for all franchisee
	@RequestMapping(value = { "/getOrderListForAllFr" }, method = RequestMethod.POST)
	@ResponseBody
	public GetOrderList getOrderListForAllFr(@RequestParam List<Integer> menuId, @RequestParam String date) {
		GetOrderList orderList = new GetOrderList();
		try {
			
			String strDate= Common.convertToYMD(date);
			System.out.println("Converted date "+strDate);
			
			
			List<GetOrder> jsonOrderList = getOrderService.findOrderAllFr(menuId, strDate);

			orderList.setGetOrder(jsonOrderList);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Order list displayed Successfully");
			orderList.setInfo(info);

		} catch (Exception e) {

			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return orderList;

	}

	// spCakeOrderService 3 sept sachin spCakeOrdersService

	@RequestMapping(value = { "/getSpCakeOrderLists" }, method = RequestMethod.POST)
	@ResponseBody
	public SpCakeOrdersBeanList SpCakeOrderLists(@RequestParam List<Integer> frId, @RequestParam String prodDate) {
		SpCakeOrdersBeanList spCakeOrderList = new SpCakeOrdersBeanList();
		try {

			String strDate= Common.convertToYMD(prodDate);
			System.out.println("Converted date "+strDate);

			List<SpCakeOrdersBean> jsonSpCakeOrderList = spCkOrdersService.findSpCakeOrder(frId, strDate);

			spCakeOrderList.setSpCakeOrdersBean(jsonSpCakeOrderList);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Sp Cake Order list displayed Successfully");
			spCakeOrderList.setInfo(info);

		} catch (Exception e) {

			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return spCakeOrderList;

	}

	// for all fr sp cake search 7sep
	@RequestMapping(value = { "/getAllFrSpCakeOrderList" }, method = RequestMethod.POST)
	@ResponseBody
	public SpCakeOrdersBeanList getAllFrSpCakeOrderList(@RequestParam String prodDate) {
		SpCakeOrdersBeanList spCakeOrderList = new SpCakeOrdersBeanList();
		try {
			String strDate= Common.convertToYMD(prodDate);
			System.out.println("Converted date "+strDate);

			List<SpCakeOrdersBean> jsonSpCakeOrderList = spCkOrdersService.findSpCakeOrderAllFr(strDate);

			spCakeOrderList.setSpCakeOrdersBean(jsonSpCakeOrderList);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Sp Cake Order list for all fr displayed Successfully");
			spCakeOrderList.setInfo(info);

		} catch (Exception e) {

			System.out.println("exception in sp cake order list for all fr rest controller" + e.getMessage());
		}
		return spCakeOrderList;

	}

	// latest news 9 sept front end

	@RequestMapping(value = { "/showLatestNews" }, method = RequestMethod.GET)
	@ResponseBody
	public SchedulerList showLatestNews() {

		
		
		java.sql.Date date1 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		System.out.println("date " + date1);

		List<Scheduler> jsonSchedulertList = schedulerService.showAllLatestNews(date1);
		System.out.println("Scheduler list" + jsonSchedulertList.toString());

		SchedulerList schedulerList = new SchedulerList();
		schedulerList.setSchedulerList(jsonSchedulertList);
		Info info = new Info();
		info.setError(false);
		info.setMessage("latest news  displayed successfully");
		schedulerList.setInfo(info);

		return schedulerList;
	}

	// Message news 9 sept front end

	@RequestMapping(value = { "/showFrontEndMessage" }, method = RequestMethod.GET)
	@ResponseBody
	public MessageList showFrontEndMessage() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		/*
		 * Calendar cal = Calendar.getInstance(); Date
		 * date=dateFormat.format(cal.getTime());
		 * 
		 * Date date=new Date(); System.out.println("date "+date);
		 */

		java.sql.Date date1 = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		System.out.println("date " + date1);

		List<Message> jsonMsgList = messageService.showAllMessage(date1);
		System.out.println("jsonMsgList list" + jsonMsgList.toString());

		MessageList msgList = new MessageList();
		msgList.setMessage(jsonMsgList);
		Info info = new Info();
		info.setError(false);
		info.setMessage("latest news  displayed successfully");
		msgList.setInfo(info);

		return msgList;
	}

	// 9 sept fr list conf configureFrBeanService

	@RequestMapping(value = { "/getAllConfFr" }, method = RequestMethod.GET)
	public @ResponseBody ConfigureFrBeanList getAllConfFr() {
		ConfigureFrBeanList beanList = new ConfigureFrBeanList();
		List<ConfigureFrBean> configBean = configureFrBeanService.findAllConfFr();

		beanList.setConfigureFrBean(configBean);
		Info info = new Info();
		info.setError(false);
		info.setMessage("configure Fr List displayed successfully");
		beanList.setInfo(info);

		return beanList;
	}

	// get one conf fr for update

	@RequestMapping(value = { "/getFrConfUpdate" }, method = RequestMethod.GET)
	public @ResponseBody ConfigureFranchisee getFrConfUpdate(@RequestParam("settingId") int settingId) {
		ConfigureFranchisee configureFranchisee = connfigureService.findFranchiseeById(settingId);
		return configureFranchisee;
	}

	// update config franchisee 11 sept
	@RequestMapping("/updateConfFr")
	public @ResponseBody String updateFrConfig(@RequestParam int settingId, @RequestParam int settingType,
			@RequestParam String fromTime, @RequestParam String toTime, @RequestParam int day,
			@RequestParam String date, @RequestParam String itemShow) {

		ConfigureFranchisee configureFranchisee = connfigureService.findFranchiseeById(settingId);
		Info info = new Info();
		try {
			SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yyyy");

			SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");

			System.out.println("DATE" + date);
			java.sql.Date bDate, dDate;
			String pDate = "";

			// bDate= inSDF.parse(date);
			// pDate = outSDF.format(bDate);
			// dDate=outSDF.parse(pDate);
			//
			java.util.Date tempDate = inSDF.parse(date);

			dDate = new java.sql.Date(tempDate.getTime());

			System.out.println("DATE after conversion" + dDate);
			configureFranchisee.setDate(dDate);
			configureFranchisee.setDay(day);

			configureFranchisee.setFromTime(fromTime);
			configureFranchisee.setItemShow(itemShow);
			configureFranchisee.setSettingType(settingType);

			configureFranchisee.setToTime(toTime);

			String jsonResult = connfigureService.configureFranchisee(configureFranchisee);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("fr confi update failure");

			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("fr config Update Successful");
			}

		} catch (Exception e) {
			System.out.println("error in config fr update" + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());
		}
		return JsonUtil.javaToJson(info);
	}

}
