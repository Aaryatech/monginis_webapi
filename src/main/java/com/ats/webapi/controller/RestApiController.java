package com.ats.webapi.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.commons.EmailUtility;
import com.ats.webapi.model.*;
import com.ats.webapi.model.album.MenuForAlbum;
import com.ats.webapi.model.album.SpCakeEnqAlbmFrnchse;
import com.ats.webapi.model.grngvn.GetGrnGvnForCreditNoteList;
import com.ats.webapi.model.grngvn.GrnGvnHeader;
import com.ats.webapi.model.grngvn.PostCreditNoteHeader;
import com.ats.webapi.model.grngvn.PostCreditNoteHeaderList;
import com.ats.webapi.model.grngvn.TempGrnGvnBeanUp;
import com.ats.webapi.model.phpwebservice.Admin;
import com.ats.webapi.model.phpwebservice.Flavor;
import com.ats.webapi.model.phpwebservice.GetLogin;
import com.ats.webapi.model.phpwebservice.SpecialCakeBean;
import com.ats.webapi.model.phpwebservice.SpecialCakeBeanList;
import com.ats.webapi.model.prodapp.TRegSpCakeSup;
import com.ats.webapi.model.prodapp.TSpCakeSup;
import com.ats.webapi.model.rawmaterial.ItemDetail;
import com.ats.webapi.model.remarks.GetAllRemarksList;
import com.ats.webapi.model.salesreport.SalesReport;
import com.ats.webapi.model.salesvaluereport.SalesReturnValueDao;
import com.ats.webapi.model.salesvaluereport.SalesReturnValueDaoList;
import com.ats.webapi.repository.ChangeOrderRecordRepo;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.FranchiseeRepository;
/*import com.ats.webapi.repository.BillLogRepo;
*/import com.ats.webapi.repository.GetBillDetailsRepository;
import com.ats.webapi.repository.GetReorderByStockTypeRepository;
import com.ats.webapi.repository.ItemCreamTypeRepo;
import com.ats.webapi.repository.ItemRepository;
import com.ats.webapi.repository.ItemResponseRepository;
import com.ats.webapi.repository.ItemStockRepository;
import com.ats.webapi.repository.MenuForAlbumRepo;
import com.ats.webapi.repository.MiniSubCategoryRepository;
import com.ats.webapi.repository.OrderItemSubCatTotalRepository;
import com.ats.webapi.repository.OrderLogRespository;
import com.ats.webapi.repository.OrderRepository;
import com.ats.webapi.repository.PostFrOpStockDetailRepository;
import com.ats.webapi.repository.PostFrOpStockHeaderRepository;
import com.ats.webapi.repository.ProdItemStockRepo;
import com.ats.webapi.repository.ProdItemStockTotalRepo;
import com.ats.webapi.repository.SalesReportRepo;
import com.ats.webapi.repository.SpCakeEnqAlbmFrnchseRepo;
import com.ats.webapi.repository.SpecialCakeCatRepository;
import com.ats.webapi.repository.SpecialCakeRepository;
import com.ats.webapi.repository.UpdatePBTimeRepo;
import com.ats.webapi.repository.UpdateSeetingForPBRepo;
import com.ats.webapi.repository.UserRepository;
import com.ats.webapi.repository.prodapp.TRegSpCakeSupRepo;
import com.ats.webapi.repository.prodapp.TSpCakeSupRepo;
import com.ats.webapi.repository.salesreturnrepo.SalesReturnValueDaoRepository;
import com.ats.webapi.service.AllFrIdNameService;
import com.ats.webapi.service.BillDetailUpdateService;
import com.ats.webapi.service.CategoryService;
import com.ats.webapi.service.ConfigureFrBeanService;
import com.ats.webapi.service.ConfigureFranchiseeService;
import com.ats.webapi.service.ConfigureSpDayCakeService;
import com.ats.webapi.service.DeleteBillService;
import com.ats.webapi.service.EventService;
import com.ats.webapi.service.FlavourService;
import com.ats.webapi.service.FrItemStockConfigurePostService;
import com.ats.webapi.service.FrItemStockConfigureService;
import com.ats.webapi.service.FrNameIdByRouteIdService;
import com.ats.webapi.service.FranchiseeService;
import com.ats.webapi.service.GenerateBillService;
import com.ats.webapi.service.GetAllRemarkService;
import com.ats.webapi.service.GetBillDetailOnlyService;
import com.ats.webapi.service.GetBillDetailsService;
import com.ats.webapi.service.GetBillHeaderService;
import com.ats.webapi.service.GetBillsForFrService;
import com.ats.webapi.service.GetDumpOrderService;
import com.ats.webapi.service.GetFrItemStockConfigurationService;
import com.ats.webapi.service.GetFrItemsService;
import com.ats.webapi.service.GetGrnGvnDetailService;
import com.ats.webapi.service.GetGrnGvnForCreditNoteService;
import com.ats.webapi.service.GetGrnItemConfigService;
import com.ats.webapi.service.GetItemByCatIdService;
import com.ats.webapi.service.GetItemStockService;
import com.ats.webapi.service.GetMCategoryService;
import com.ats.webapi.service.GetOrderDataForPushOrderService;
import com.ats.webapi.service.GetOrderService;
import com.ats.webapi.service.GetSellBillDetailService;
import com.ats.webapi.service.GetSellBillHeaderService;
import com.ats.webapi.service.ItemService;
import com.ats.webapi.service.ItemsList;
import com.ats.webapi.service.MenuService;
import com.ats.webapi.service.MessageService;
import com.ats.webapi.service.ModuleService;
import com.ats.webapi.service.ModulesList;
import com.ats.webapi.service.OrderCountsService;
import com.ats.webapi.service.OrderService;
import com.ats.webapi.service.PostBillDataService;
import com.ats.webapi.service.PostBillUpdateService;
import com.ats.webapi.service.PostCreditNoteService;
import com.ats.webapi.service.PostFrOpStockService;
import com.ats.webapi.service.PostGrnGvnService;
import com.ats.webapi.service.PrevItemOrderService;
import com.ats.webapi.service.RateList;
import com.ats.webapi.service.RateService;
import com.ats.webapi.service.RegularSpCkItemsService;
import com.ats.webapi.service.RegularSpCkOrderService;
import com.ats.webapi.service.RouteService;
import com.ats.webapi.service.SchedulerService;
import com.ats.webapi.service.SellBillDataService;
import com.ats.webapi.service.SpCakeOrdersService;
import com.ats.webapi.service.SpCkOrdersService;
import com.ats.webapi.service.SpMessageService;
import com.ats.webapi.service.SpecialCakeCatService;
import com.ats.webapi.service.SpecialCakeService;
import com.ats.webapi.service.SubCategoryService;
import com.ats.webapi.service.SubCatergoryList;
import com.ats.webapi.service.TestFrService;
import com.ats.webapi.service.UpdateGrnGvnService;
import com.ats.webapi.service.UpdateOrderService;
import com.ats.webapi.service.UserService;
import com.ats.webapi.service.spMessageList;
import com.ats.webapi.service.MaterialRcNote.SettingService;
import com.ats.webapi.util.JsonUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestApiController {

	public String incrementDate(String date, int day) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(date));

		} catch (ParseException e) {
			System.out.println("Exception while incrementing date " + e.getMessage());
			e.printStackTrace();
		}
		c.add(Calendar.DATE, day); // number of days to add
		date = sdf.format(c.getTime());

		return date;

	}

	@Autowired
	OrderItemSubCatTotalRepository orderItemSubCatTotalRepository;

	@Autowired
	ItemStockRepository itemStockRepository;
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
	private SpecialCakeCatService specialcakeCatService;

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

	@Autowired
	private OrderCountsService orderCountService;

	@Autowired
	private FrItemStockConfigureService frItemConfService;

	@Autowired
	FrItemStockConfigurePostService frItemStockConfigurePostService;

	@Autowired
	GetFrItemStockConfigurationService getFrItemStockConfigurationService;

	@Autowired
	AllFrIdNameService allFrIdNameService;

	@Autowired
	GetDumpOrderService getDumpOrderService;

	@Autowired
	GenerateBillService generateBillService;

	@Autowired
	RegularSpCkItemsService regularSpCkItemsService;

	@Autowired
	RegularSpCkOrderService regularSpCkOrderService;

	@Autowired
	GetBillHeaderService getBillHeaderService;

	@Autowired
	PostBillDataService postBillDataService;

	@Autowired
	GetBillDetailsService getBillDetailsService;
	@Autowired
	GetBillDetailsRepository getBillDetailsRepository;
	@Autowired
	FrNameIdByRouteIdService frNameIdByRouteIdService;

	@Autowired
	PostBillUpdateService postBillUpdateService;

	@Autowired
	GetBillDetailOnlyService billDetailOnlyService;

	@Autowired
	ConfigureSpDayCakeService configureSpDayCakeService;

	@Autowired
	DeleteBillService deleteBillService;

	@Autowired
	SellBillDataService sellBillDataService;

	@Autowired
	GetGrnItemConfigService getGrnItemConfigService;

	@Autowired
	PostGrnGvnService postGrnGvnService;

	@Autowired
	UpdateOrderService updateorderService;

	@Autowired
	GetMCategoryService getMCategoryService;

	@Autowired
	GetItemByCatIdService getItemByCatIdService;

	@Autowired
	GetBillsForFrService getBillsForFrService;

	@Autowired
	GetGrnGvnDetailService getGrnGvnDetailService;

	@Autowired
	GetSellBillHeaderService getSellBillHeaderService;

	@Autowired
	GetSellBillDetailService getSellBillDetailService;

	@Autowired
	UpdateGrnGvnService updateGrnGvnService;

	@Autowired
	PostFrOpStockService postFrOpStockService;

	@Autowired
	GetItemStockService getItemStockService;

	@Autowired
	PostCreditNoteService postCreditNoteService;

	@Autowired
	GetOrderDataForPushOrderService getOrderDataForPushOrderService;

	@Autowired
	GetAllRemarkService getAllRemarkService;

	@Autowired
	UpdateSeetingForPBRepo updateSeetingForPBRepo;

	@Autowired
	UpdatePBTimeRepo updatePBTimeRepo;

	@Autowired
	SettingService settingService;

	@Autowired
	GetReorderByStockTypeRepository getReorderByStockTypeRepository;

	@Autowired
	ItemRepository itemRepository;
	@Autowired
	UserRepository userRepo;// 20 March

	@Autowired
	OrderLogRespository logRespository;

	@Autowired
	ItemResponseRepository itemResRepository;

	@Autowired
	MiniSubCategoryRepository miniSubCategoryRepository;

	@Autowired
	SpecialCakeRepository specialCakeRepository;

	@Autowired
	SpecialCakeCatRepository specialCakeCatRepository;

	@Autowired
	MenuForAlbumRepo menuForAlbumRepo;
	
	@Autowired
	ProdItemStockRepo prodItemStockRepo;
	
	@Autowired
	ProdItemStockTotalRepo prodItemStockTotalRepo;

	@Autowired
	PostFrOpStockDetailRepository postFrOpStockDetailRepository;
	
	@Autowired
	PostFrOpStockHeaderRepository postFrOpStockHeaderRepository;
	
	@Autowired
	FranchiseeRepository franchiseeRepository;

	@Autowired
	FranchiseSupRepository franchiseSupRepository;
	
	@RequestMapping(value = "/getItemsResBySubCatId", method = RequestMethod.POST)
	public @ResponseBody List<ItemRes> getItemsResBySubCatId(@RequestParam("subCatId") String subCatId) {

		List<ItemRes> items = new ArrayList<ItemRes>();
		try {

			items = itemResRepository.findByItemGrp2AndDelStatusOrderByItemGrp2AscItemNameAsc(subCatId, 0);

		} catch (Exception e) {
			items = new ArrayList<>();
			e.printStackTrace();

		}
		return items;

	}

	@RequestMapping(value = { "/changeAdminUserPass" }, method = RequestMethod.POST)
	public @ResponseBody Info changeAdminUserPass(@RequestBody User user) {

		Info info = new Info();

		User result = userRepo.save(user);

		if (result != null) {

			info.setError(false);
			info.setMessage("Password changed successfully");
		}

		else {

			info.setError(true);
			info.setMessage("password not changed Error Occured ");
		}

		return info;

	}

	// This web api Not used Anywhere
	@RequestMapping(value = { "/updatePBTime" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePBTime(@RequestParam("billNo") int billNo, @RequestParam("time") String time) {

		Info info = new Info();

		int result = updatePBTimeRepo.updateTimeForPurBill(time, billNo);

		if (result > 0) {

			info.setError(false);
			info.setMessage("time for Pur Bill updated successfully");
		}

		else {

			info.setError(true);
			info.setMessage("Error: updating time table failed for pur Bill");
		}

		return info;

	}

	@RequestMapping(value = { "/updateSeetingForPB" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSeetingForPB(@RequestParam("settingValue") int settingValue,
			@RequestParam("settingKey") String settingKey) {

		Info info = new Info();

		int result = updateSeetingForPBRepo.updateSeetingForPurBill(settingValue, settingKey);

		if (result > 0) {

			info.setError(false);
			info.setMessage("Setting for Pur Bill updated successfully");
		}

		else {

			info.setError(true);
			info.setMessage("Error: updating setting table failed for pur Bill");
		}

		return info;

	}

	@RequestMapping(value = "/getAllRemarks", method = RequestMethod.POST)
	public @ResponseBody GetAllRemarksList getAllRemarks(@RequestParam("isFrUsed") int isFrUsed,
			@RequestParam("subModuleId") int subModuleId, @RequestParam("moduleId") int moduleId) {

		GetAllRemarksList allRemarksList = getAllRemarkService.getAllRemarkFor(isFrUsed, moduleId, subModuleId);

		return allRemarksList;

	}

	@RequestMapping(value = "/getOrderDataForPushOrder", method = RequestMethod.POST)
	public @ResponseBody GetOrderDataForPushOrderList getOrderDataForPushOrder(
			@RequestParam("frIdList") List<String> frIdList) {
		System.out.println("inside rest");

		java.sql.Date cDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		int grnType = 4;

		System.out.println(" current date " + cDate);

		System.out.println(" frIdList  " + frIdList.toString());

		GetOrderDataForPushOrderList getOrderDataForPushOrderList = getOrderDataForPushOrderService
				.getOrderDataForPushOrder(cDate, grnType, frIdList);

		return getOrderDataForPushOrderList;

	}

	@RequestMapping(value = { "/postCreditNote" }, method = RequestMethod.POST)
	public @ResponseBody Info postCreditNote(@RequestBody PostCreditNoteHeaderList postCreditNoteHeader) {

		Info info = new Info();

		List<PostCreditNoteHeader> creditNoteHeaderList = postCreditNoteService
				.savePostCreditNote(postCreditNoteHeader.getPostCreditNoteHeader());

		if (!creditNoteHeaderList.isEmpty()) {

			info.setError(false);
			info.setMessage("Credit Note inserted successfully");
		}

		else {

			info.setError(true);
			info.setMessage("Error: credit note insertion failed");
		}

		return info;

	}

	@Autowired // credit note sachin 07/11/2017
	GetGrnGvnForCreditNoteService getGrnGvnForCreditNoteService;

	@RequestMapping(value = "/grnGvnDetailForCreditNote", method = RequestMethod.POST)
	public @ResponseBody GetGrnGvnForCreditNoteList grnGvnDetailForCreditNote(@RequestParam("isGrn") int isGrn) {
		System.out.println("inside rest");

		System.out.println("Rest : is Grn Received /grnGvnDetailForCreditNote " + isGrn);

		GetGrnGvnForCreditNoteList getGrnGvnForCreditNoteList = getGrnGvnForCreditNoteService
				.getGrnGvnForCreditNote(isGrn);

		return getGrnGvnForCreditNoteList;

	}

	// comment 24 FEb
	@RequestMapping(value = "/updateStoreGvn", method = RequestMethod.POST)
	public @ResponseBody Info updateStoreGvn(@RequestBody List<TempGrnGvnBeanUp> dataList) {

		System.out.println("inside rest /updateStoreGvn : input para = dataList " + dataList.toString());

		Info info = new Info();
		System.out.println("inside rest");

		TempGrnGvnBeanUp data;

		int x = 0;

		for (int i = 0; i < dataList.size(); i++) {
			data = new TempGrnGvnBeanUp();
			data = dataList.get(i);

			x = updateGrnGvnService.updateGrnGvnForStore(data.getApprovedLoginStore(), data.getAprQtyStore(),
					data.getApprovedDateTimeStore(), data.getApprovedRemarkStore(), data.getGrnGvnStatus(),
					data.getGrnGvnId());

		}

		if (x > 0) {

			info.setError(false);
			info.setMessage("Success");
		} else {

			info.setError(true);
			info.setMessage("Failed");

		}
		return info;

	}

	@RequestMapping(value = "/updateGateGrn", method = RequestMethod.POST)
	public @ResponseBody Info updateGateGrn(@RequestBody List<TempGrnGvnBeanUp> dataList) {

		Info info = new Info();
		try {
			System.out.println("inside rest /updateGateGrn : input para = dataList " + dataList.toString());

			int x = 0;
			TempGrnGvnBeanUp data;

			for (int i = 0; i < dataList.size(); i++) {
				data = new TempGrnGvnBeanUp();
				data = dataList.get(i);

				x = updateGrnGvnService.updateGrnForGate(data.getApprovedLoginGate(), data.getAprQtyGate(),
						data.getApproveimedDateTimeGate(), data.getApprovedRemarkGate(), data.getGrnGvnStatus(),
						data.getGrnGvnId());

			}

			if (x > 0) {

				info.setError(false);
				info.setMessage("Success");
			} else {

				info.setError(true);
				info.setMessage("Failed");

			}
		} catch (Exception e) {

			System.out.println("/Rest Api Exce in Updating Gate Grn Gvn Record /updateGateGrn" + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}

	// comment 24 FEb
	@RequestMapping(value = "/updateAccGrn", method = RequestMethod.POST)
	public @ResponseBody Info updateAccGrn(@RequestBody List<TempGrnGvnBeanUp> dataList) {

		Info info = new Info();
		try {
			System.out.println("inside rest /updateAccGrn : Param " + dataList.toString());

			int x = 0;
			TempGrnGvnBeanUp data;
			for (int i = 0; i < dataList.size(); i++) {
				data = new TempGrnGvnBeanUp();
				data = dataList.get(i);

				x = updateGrnGvnService.updateGrnForAcc(data.getApprovedLoginAcc(), data.getAprQtyAcc(),
						data.getApprovedDateTimeAcc(), data.getApprovedRemarkAcc(), data.getGrnGvnStatus(),
						data.getAprTaxableAmt(), data.getAprTotalTax(), data.getAprSgstRs(), data.getAprCgstRs(),
						data.getAprIgstRs(), data.getAprGrandTotal(), data.getAprROff(), data.getGrnGvnId());

			}

			if (x > 0) {

				info.setError(false);
				info.setMessage("Success");

			} else {

				info.setError(true);
				info.setMessage("Failed");

			}

		} catch (Exception e) {

			System.out.println("/Rest Api Exce in Updating Gate Grn Gvn Record /updateAccGrn" + e.getMessage());
			e.printStackTrace();

		}

		return info;

	}

	@RequestMapping(value = "/getGvnDetails", method = RequestMethod.POST)
	public @ResponseBody GetGrnGvnDetailsList getGvnDetails(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.out.println("inside rest");

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);

		GetGrnGvnDetailsList gvnDetailList = getGrnGvnDetailService.getGvnDetails(fromDate, toDate);

		return gvnDetailList;

	}

	@RequestMapping(value = "/getGrnDetail", method = RequestMethod.POST)
	public @ResponseBody GetGrnGvnDetailsList getGrnGvnDetailService(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		GetGrnGvnDetailsList grnDetailList = null;
		try {
			System.out.println("inside rest");

			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			grnDetailList = getGrnGvnDetailService.getGrnDetails(fromDate, toDate);

			System.out.println("list is " + grnDetailList.toString());

		} catch (Exception e) {

			System.out.println("get grn detail rest  error " + e.getMessage());

			e.printStackTrace();
		}

		return grnDetailList;

	}

	@RequestMapping(value = "/getGvnItemConfig", method = RequestMethod.POST)
	public @ResponseBody GetGrnItemConfigList getGvnItemConfig(@RequestParam("billNo") int billNo) {
		GetGrnItemConfigList gvnItemConfigList = null;
		try {

			gvnItemConfigList = getGrnItemConfigService.getGvnItemConfig(billNo);

			System.out.println("List getGvnItemConfig " + gvnItemConfigList.toString());
		} catch (Exception e) {
			System.out.println("inside rest: getGvnItemConfig  Error " + e.getMessage());

			e.printStackTrace();

		}

		return gvnItemConfigList;

	}

	@RequestMapping(value = "/getBillsForFr", method = RequestMethod.POST)
	public @ResponseBody GetBillsForFrList getBillsForFrService(@RequestParam("frId") int frId,
			@RequestParam("curDate") String curDate) {
		// fff;

		// java.util.Date cDate = new java.util.Date();

		String back15Days = incrementDate(curDate, -5);
		java.sql.Date cDate = Common.convertToSqlDate(curDate);
		java.sql.Date back15Date = Common.convertToSqlDate(back15Days);

		System.out.println("curDate for Sql  ::: " + cDate);

		System.out.println("15 Days Back Date  For SQl ::: " + back15Date);

		System.out.println("Fr Id ::: " + frId);

		GetBillsForFrList billsForFrLisr = getBillsForFrService.getBillForFr(frId, back15Date, cDate);
		System.out.println("GEt BillS for Fr " + billsForFrLisr.toString());
		return billsForFrLisr;

	}

	@RequestMapping(value = "/getBillsForManGrnBackEndFr", method = RequestMethod.POST)
	public @ResponseBody GetBillsForFrList getBillsForManGrnBackEndFr(@RequestParam("frId") int frId) {

		GetBillsForFrList billsForFrLisr = getBillsForFrService.getAllBillForManGrnBackEnd(frId);
		System.out.println("GEt BillS for Fr " + billsForFrLisr.toString());
		return billsForFrLisr;

	}

	// 20 FEB SAch
	@RequestMapping(value = "/getBillsForFrByBillDate", method = RequestMethod.POST)
	public @ResponseBody GetBillsForFrList getBillsForFrByBillDate(@RequestParam("frId") int frId,
			@RequestParam("billDate") String billDate) {

		java.sql.Date bilDate = Common.convertToSqlDate(billDate);

		System.out.println("Fr Id ::: " + frId);

		GetBillsForFrList billsForFrLisr = getBillsForFrService.getBillForFrByDate(frId, bilDate);

		System.out.println("GEt BillS for Fr by Bill Date " + billsForFrLisr.toString());

		return billsForFrLisr;

	}

	@RequestMapping(value = "/getItemByCategoryId", method = RequestMethod.POST)
	public @ResponseBody GetItemByCatIdList getItemByCatId(@RequestParam("catId") int catId) {

		GetItemByCatIdList getItemByCatIdList = getItemByCatIdService.getItemByCatId(catId);

		return getItemByCatIdList;

	}

	@RequestMapping(value = "/getMCategory", method = RequestMethod.GET)
	public @ResponseBody GetMCategoryList getMCategory() {

		GetMCategoryList getMCategoryList = getMCategoryService.getMainCategory(0);

		return getMCategoryList;

	}

	// changed on 15 FEB
	@RequestMapping(value = { "/insertGrnGvn" }, method = RequestMethod.POST)

	public @ResponseBody Info postGrnGvn(@RequestBody PostGrnGvnList postGrnGvnList)
			throws ParseException, JsonParseException, JsonMappingException, IOException {
		Info info = new Info();
		try {

			System.out.println("inside rest Insert Grn Gvn ");
			System.out.println("list== " + postGrnGvnList.toString());

			// GrnGvn jsonGrnGvn = null;

			// jsonGrnGvn = postGrnGvnService.saveGrnGvn(postGrnGvnList.getGrnGvn());

			GrnGvnHeader header = null;

			header = postGrnGvnService.saveGrnGvnHeader(postGrnGvnList.getGrnGvnHeader());

			if (header != null) {
				System.err.println("Header is not null");

				info.setError(false);
				info.setMessage("Grn Gvn inserted  Successfully");

			}

			else {
				System.err.println("Header is  null");
				info.setError(true);
				info.setMessage("Error in Grn Gvn insertion : RestApi");

			}
		} catch (Exception e) {
			System.out.println("Error in gvn insert rest api " + e.getMessage());
			e.printStackTrace();
		}
		return info;

	}

	@RequestMapping(value = "/updateBillDetailforGrnGvnInsert", method = RequestMethod.POST)
	public @ResponseBody Info updateBillDetailforGrnGvnInsertint(@RequestParam("billDetailNo") int billDetailNo) {

		Info info = new Info();

		int updateResult = 0;

		try {

			updateResult = postGrnGvnService.updateBill(billDetailNo);

			if (updateResult > 0) {

				info.setError(false);
				info.setMessage("success update bill status for Grn Gvn ");
			} else {
				info.setError(true);
				info.setMessage("Failure : update bill status for Grn Gvn");
			}
		} catch (Exception e) {

			System.out.println("Exce in update bill Detail For GRN GVN Rest Api /updateBillDetailforGrnGvnInsert "
					+ e.getMessage());
			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = "/getGrnItemConfig", method = RequestMethod.POST)
	public @ResponseBody GetGrnItemConfigList getGrnItemConfig(@RequestParam("frId") int frId) {
		System.out.println("inside rest");
		GetGrnItemConfigList grnItemConfigList = null;

		try {
			// java.util.Date cDate = new
			// java.util.Date(Calendar.getInstance().getTime().getTime());

			java.util.Date cDate = new java.util.Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(cDate);

			int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
			System.out.println("current Hour " + currentHour);

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			java.util.Date currentDate = null;

			if (currentHour >= 22) {

				Calendar cal = Calendar.getInstance();
				cal.setTime(cDate);
				cal.add(Calendar.DATE, 1);
				java.util.Date cDateAdded = cal.getTime();

				java.util.Date grnDate = cDateAdded;

				String dateNow = dateFormat.format(grnDate);
				;

				try {
					currentDate = dateFormat.parse(dateNow);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("currentDate " + currentDate);

			}

			else {

				currentDate = new java.util.Date();

				// String s=dateFormat2.format(currentDate);

				System.out.println("current Date in else " + currentDate);
			}
			DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
			grnItemConfigList = getGrnItemConfigService.getAllGrnItemConfiguration(dateFormat2.format(currentDate),
					frId);

			System.out.println("grn Item config  with Rest: " + grnItemConfigList.toString());

		} catch (Exception e) {

			System.out.println("rest Exce for Getting grn Item Conf " + e.getMessage());
			e.printStackTrace();
		}

		return grnItemConfigList;

	}

	// 21 march Front End Manual GRN
	@RequestMapping(value = "/getItemsForManGrn", method = RequestMethod.POST)
	public @ResponseBody GetGrnItemConfigList getItemsForManGrn(@RequestParam("frId") int frId,
			@RequestParam("billNo") int billNo) {
		System.out.println("inside rest /getItemsForManGrn");
		GetGrnItemConfigList grnItemConfigList = null;

		try {

			grnItemConfigList = getGrnItemConfigService.getItemForManualGrn(billNo, frId);

			System.out.println("grn Item getItemForManualGrn  Rest: " + grnItemConfigList.toString());

		} catch (Exception e) {

			System.out.println("restApi Exce for Getting Man GRN Item Conf /getItemsForManGrn" + e.getMessage());
			e.printStackTrace();
		}

		return grnItemConfigList;

	}

	@RequestMapping(value = "/deleteBill", method = RequestMethod.POST)
	public @ResponseBody Info deleteBill(@RequestParam("delStatus") int delStatus, @RequestParam("billNo") int billNo) {
		System.out.println("inside rest");

		deleteBillService.deleteBill(delStatus, billNo);

		Info info = new Info();
		info.setMessage("success");

		return info;

	}

	@RequestMapping(value = "/updateOrderStatus", method = RequestMethod.POST)
	public @ResponseBody String updateOrderStatus(@RequestParam("orderId") int orderId,
			@RequestParam("status") int status) {
		System.out.println("inside rest");

		orderService.updateBillStatus(orderId, status);

		return "success ";

	}

	@RequestMapping(value = "/getCountByProduDate", method = RequestMethod.POST)
	public @ResponseBody int getCountOfSlotUsedByProduDate(@RequestParam("spProduDate") String spProduDate) {

		String sqlSpProduDate = Common.convertToYMD(spProduDate);
		System.out.println("Converted date " + sqlSpProduDate);

		int isSlotUsedCount = spCakeOrdersService.findCountOfSlotUsedByProduDate(sqlSpProduDate);

		return isSlotUsedCount;

	}

	@RequestMapping(value = "/getTotalAvailableSlot", method = RequestMethod.POST)
	public @ResponseBody int getTotalAvailableSlot() {

		int totalAvailableSlot = frItemConfService.findTotalAvailableSlot();

		return totalAvailableSlot;

	}

	@RequestMapping(value = "/findvaluebykey", method = RequestMethod.POST)
	public @ResponseBody int findvaluebykey(@RequestParam("key") String key) {

		int value = frItemConfService.findbykey(key);

		return value;

	}

	@RequestMapping(value = "/updateValuekey", method = RequestMethod.GET)
	public @ResponseBody int updateValuekey() {

		int value = frItemConfService.findbykey("mrn_no");
		value = value + 1;
		int Updatevalue = settingService.updateValue(value);

		return Updatevalue;

	}

	@RequestMapping(value = "/getProductionTimeSlot", method = RequestMethod.GET)
	public @ResponseBody int getProductionTimeSlot() {

		int productionTimeSlot = frItemConfService.findProductionTimeSlot();

		return productionTimeSlot;

	}

	@RequestMapping(value = "/getBillDetailOnly", method = RequestMethod.POST)
	public @ResponseBody String getBillDetailOnly(@RequestParam("billDetailNo") int billDetailNo) {
		System.out.println("inside rest");

		PostBillDetail billDetailsList = billDetailOnlyService.getByBillDetailNo(billDetailNo);

		return JsonUtil.javaToJson(billDetailsList);

	}

	@RequestMapping(value = { "/updateBillDetails" }, method = RequestMethod.POST)
	public @ResponseBody String updateBillDetails(@RequestParam List<PostBillDetail> postBillDetailsList) {

		int billDeNo = 0;

		System.out.println("post bill Detail with get bill Details= " + postBillDetailsList.toString());

		for (int i = 0; i < postBillDetailsList.size(); i++) {

			// PostBillDetail
			// billDetailsList=billDetailOnlyService.getByBillDetailNo(billDNo);

			PostBillDetail postBillUpdate = new PostBillDetail();

			postBillUpdate.setBillDetailNo(postBillDetailsList.get(i).getBillDetailNo());
			postBillUpdate.setBillNo(postBillDetailsList.get(i).getBillNo());
			postBillUpdate.setBillQty(postBillDetailsList.get(i).getBillQty());
			postBillUpdate.setGrandTotal(postBillDetailsList.get(i).getGrandTotal());
			postBillUpdate.setTaxableAmt(postBillDetailsList.get(i).getTaxableAmt());
			postBillUpdate.setCatId(postBillDetailsList.get(i).getCatId());
			postBillUpdate.setCgstPer(postBillDetailsList.get(i).getCgstPer());
			postBillUpdate.setCgstRs(postBillDetailsList.get(i).getCgstRs());
			postBillUpdate.setDelStatus(postBillDetailsList.get(i).getDelStatus());
			postBillUpdate.setIgstPer(postBillDetailsList.get(i).getIgstPer());
			postBillUpdate.setIgstRs(postBillDetailsList.get(i).getIgstRs());
			postBillUpdate.setItemId(postBillDetailsList.get(i).getItemId());
			postBillUpdate.setMenuId(postBillDetailsList.get(i).getMenuId());
			postBillUpdate.setMrp(postBillDetailsList.get(i).getMrp());
			postBillUpdate.setOrderId(postBillDetailsList.get(i).getOrderId());
			postBillUpdate.setOrderQty(postBillDetailsList.get(i).getOrderQty());
			postBillUpdate.setRate(postBillDetailsList.get(i).getRate());
			postBillUpdate.setRateType(postBillDetailsList.get(i).getRateType());
			postBillUpdate.setRemark(postBillDetailsList.get(i).getRemark());
			postBillUpdate.setSgstPer(postBillDetailsList.get(i).getSgstPer());
			postBillUpdate.setSgstRs(postBillDetailsList.get(i).getSgstRs());

			PostBillDetail postBillUpdated = postBillUpdateService.save(postBillUpdate);

		}

		// PostBillDetail
		// billDetailsList=billDetailOnlyService.getByBillDetailNo(billDeNo);

		// List<GetBillDetails> getBillDetailList=billDetails.getGetBillDetails();

		Info info = new Info();

		/*
		 * PostBillDetail postBillUpdate=new PostBillDetail();
		 * 
		 * postBillUpdate.setBillDetailNo(billDeNo); postBillUpdate.setBillNo(billNo);
		 * postBillUpdate.setBillQty(billQty); postBillUpdate.setGrandTotal(grandTotal);
		 * postBillUpdate.setTaxableAmt(taxableAmt);
		 * postBillUpdate.setCatId(billDetailsList.getCatId());
		 * postBillUpdate.setCgstPer(billDetailsList.getCgstPer());
		 * postBillUpdate.setCgstRs(billDetailsList.getCgstRs());
		 * postBillUpdate.setDelStaus(billDetailsList.getDelStaus());
		 * postBillUpdate.setIgstPer(billDetailsList.getIgstPer());
		 * postBillUpdate.setIgstRs(billDetailsList.getIgstRs());
		 * postBillUpdate.setItemId(billDetailsList.getItemId());
		 * postBillUpdate.setMenuId(billDetailsList.getMenuId());
		 * postBillUpdate.setMrp(billDetailsList.getMrp());
		 * postBillUpdate.setOrderId(billDetailsList.getOrderId());
		 * postBillUpdate.setOrderQty(billDetailsList.getOrderQty());
		 * postBillUpdate.setRate(billDetailsList.getRate());
		 * postBillUpdate.setRateType(billDetailsList.getRateType());
		 * postBillUpdate.setRemark(billDetailsList.getRemark());
		 * postBillUpdate.setSgstPer(billDetailsList.getSgstPer());
		 * postBillUpdate.setSgstRs(billDetailsList.getSgstRs());
		 * 
		 * 
		 * PostBillDetail postBillUpdated=postBillUpdateService.save(postBillUpdate);
		 */
		return "bill Details Updated Successfully";

	}

	@RequestMapping(value = "/getFrNameIdByRouteId", method = RequestMethod.POST)
	public @ResponseBody FrNameIdByRouteIdList getFrNameIdByRouteId(@RequestParam("routeId") int routeId) {

		FrNameIdByRouteIdList frNameIdByRouteIdList = frNameIdByRouteIdService.getFrNameIdByRouteId(routeId);

		return frNameIdByRouteIdList;

	}

	@RequestMapping(value = "/getBillDetails", method = RequestMethod.POST)
	public @ResponseBody GetBillDetailsList getBillDetails(@RequestParam("billNo") int billNo) {
		System.out.println("inside rest");

		GetBillDetailsList billDetailsList = getBillDetailsService.getBillDetailList(billNo);

		return billDetailsList;

	}

	/*
	 * @RequestMapping(value = "/getBillDetailsForPrint", method =
	 * RequestMethod.POST) public @ResponseBody List<GetBillDetails>
	 * getBillDetailsForPrint(@RequestParam("billNoList") List<String> billNoList) {
	 * System.out.println("inside rest for getting bill detail for print fr bill ");
	 * System.out.println("input received as billNoList "+billNoList.toString());
	 * 
	 * List<GetBillDetails> billDetailsForPrint =
	 * getBillDetailsRepository.getBillDetailsForPrint(billNoList); return
	 * billDetailsForPrint;
	 * 
	 * }
	 */

	// @Autowired
	// BillLogRepo saveBillLogRepo;

	@RequestMapping(value = { "/insertBillData" }, method = RequestMethod.POST)

	public @ResponseBody Info postBillData(@RequestBody PostBillDataCommon postBillDataCommon)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Data Common " + postBillDataCommon.toString());

		List<PostBillHeader> jsonBillHeader = null;
		List<PostBillDetail> jsonBillDetail;

		/*
		 * BillLog log=new BillLog();
		 * 
		 * log.setBillData(postBillDataCommon.toString()); log.setUserId(0);
		 * 
		 * BillLog billLogResponse=saveBillLogRepo.save(log);
		 */

		Info info = new Info();
		try {
			jsonBillHeader = postBillDataService.saveBillHeader(postBillDataCommon.getPostBillHeadersList());

			if (jsonBillHeader != null && !jsonBillHeader.isEmpty()) {

				info.setError(false);
				info.setMessage("post bill header inserted  Successfully");

			}

			else {

				info.setError(true);
				info.setMessage("Error in post bill header insertion : RestApi");

			}

		} catch (Exception e) {

			System.out.println("Exc in insertBillData rest Api " + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/updateBillData" }, method = RequestMethod.POST)

	public @ResponseBody Info updateBillData(@RequestBody PostBillDataCommon postBillDataCommon)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Data Common " + postBillDataCommon.toString());

		List<PostBillHeader> jsonBillHeader;
		List<PostBillDetail> jsonBillDetail;

		jsonBillHeader = postBillDataService.updateBillHeader(postBillDataCommon.getPostBillHeadersList());

		Info info = new Info();

		if (jsonBillHeader.size() > 0) {

			info.setError(false);
			info.setMessage("post bill header inserted  Successfully");

		}

		else {

			info.setError(true);
			info.setMessage("Error in post bill header insertion : RestApi");

		}

		return info;

	}

	@RequestMapping(value = { "/insertSellBillData" }, method = RequestMethod.POST)

	public @ResponseBody SellBillHeader sellBillData(@RequestBody SellBillHeader sellBillHeader)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Data for insert  " + sellBillHeader.toString());

		SellBillHeader jsonSellBillHeader;
		// List<SellBillDetail> jsonBillDetail;

		jsonSellBillHeader = sellBillDataService.saveSellBillHeader(sellBillHeader);

		System.out.println("SellBillHeader data: " + sellBillHeader.toString());

		Info info = new Info();

		if (jsonSellBillHeader != null) {

			info.setError(false);
			info.setMessage("Sell bill header inserted  Successfully");
			System.out.println("Response : " + info.toString());
		}

		else {

			info.setError(true);
			info.setMessage("Error in Sell bill header insertion : RestApi");
			System.out.println("Response : " + info.toString());
		}

		return jsonSellBillHeader;

	}

	@RequestMapping(value = "/getBillHeader", method = RequestMethod.POST)
	public @ResponseBody GetBillHeaderList getBillHeader(@RequestParam("frId") List<String> frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		GetBillHeaderList billHeaderList = null;
		try {

			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			billHeaderList = getBillHeaderService.getBillHeader(frId, fromDate, toDate);
		} catch (Exception e) {
			System.out.println("Exc in getBillHeader Rest Api " + e.getMessage());
			e.printStackTrace();
		}

		return billHeaderList;

	}

	@RequestMapping(value = "/getBillHeaderForAllFr", method = RequestMethod.POST)
	public @ResponseBody GetBillHeaderList getBillHeaderForAllFr(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		GetBillHeaderList billHeaderList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			billHeaderList = getBillHeaderService.getBillHeaderForAllFr(fromDate, toDate);
		} catch (Exception e) {
			System.out.println("Exc in getBillHeader Rest Api " + e.getMessage());
			e.printStackTrace();
		}

		return billHeaderList;

	}

	@RequestMapping(value = "/generateBillForAllMenu", method = RequestMethod.POST)
	public @ResponseBody GenerateBillList generateBillForAllMenu(@RequestParam("frId") List<String> frId,
			@RequestParam("delDate") String delDate) {

		delDate = Common.convertToYMD(delDate);

		System.out.println("delivery Date after convert " + delDate);

		GenerateBillList billList = generateBillService.generateBillForAllMenu(frId, delDate);

		return billList;

	}

	@RequestMapping(value = "/generateBillForAllFrAllMenu", method = RequestMethod.POST)
	public @ResponseBody GenerateBillList generateBillForAllFrAllMenu(@RequestParam("delDate") String delDate) {

		delDate = Common.convertToYMD(delDate);

		System.out.println("delivery Date after convert " + delDate);

		GenerateBillList billList = generateBillService.generateBillForAllFrAllMenu(delDate);

		return billList;

	}

	@RequestMapping(value = "/generateBillForAllFr", method = RequestMethod.POST)
	public @ResponseBody GenerateBillList generateBillForAllFr(@RequestParam("menuId") List<String> menuId,
			@RequestParam("delDate") String delDate) {

		delDate = Common.convertToYMD(delDate);

		System.out.println("delivery Date after convert " + delDate);

		GenerateBillList billList = generateBillService.generateBillServiceForAllFr(menuId, delDate);

		return billList;

	}

	@RequestMapping(value = "/generateBill", method = RequestMethod.POST)
	public @ResponseBody GenerateBillList generateBill(@RequestParam("frId") List<String> frId,
			@RequestParam("menuId") List<String> menuId, @RequestParam("delDate") String delDate) {

		delDate = Common.convertToYMD(delDate);

		System.out.println("delivery Date after convert " + delDate);

		GenerateBillList billList = generateBillService.generateBillService(frId, menuId, delDate);

		return billList;

	}

	@RequestMapping(value = "/getAllFrIdName", method = RequestMethod.GET)
	public @ResponseBody AllFrIdNameList getAllFrIdName() {

		//AllFrIdNameList allFrIdNamesList = allFrIdNameService.getFrIdAndName();	//mahendra //31-01-2020
		AllFrIdNameList allFrIdNamesList = allFrIdNameService.getFrIdAndNameByDelstatus(0);

		return allFrIdNamesList;

	}

	@RequestMapping(value = "/getRegularSpCkItems", method = RequestMethod.POST)
	public @ResponseBody AllRegularSpCkItems getRegularSpCkItems(@RequestParam List<Integer> items,
			@RequestParam int itemGrp2) {

		AllRegularSpCkItems allRegularSpCkItems = regularSpCkItemsService.findRegularSpCkItems(items, itemGrp2);

		return allRegularSpCkItems;

	}

	@RequestMapping(value = "/getAllFrItemConfPost", method = RequestMethod.POST)
	public @ResponseBody List<FrStockResponse> getAllFrItemConfPost(@RequestParam List<String> itemId) {

		FrItemStockConfigurePostList configurePostList = new FrItemStockConfigurePostList();

		List<GetFrItemStockConfiguration> frItemStockConfigurePosts = getFrItemStockConfigurationService
				.getAllFrItemConfPost(itemId);

		configurePostList.setFrItemStockConfigurePosts(frItemStockConfigurePosts);

		List<FrStockResponse> frStockResponseList = new ArrayList<FrStockResponse>();

		for (int i = 0; i < frItemStockConfigurePosts.size(); i++) {

			GetFrItemStockConfiguration frItemStockConfigurePostParent = frItemStockConfigurePosts.get(i);

			boolean isUnique = true;
			for (int m = 0; m < frStockResponseList.size(); m++) {
				
				FrStockResponse resp=frStockResponseList.get(m);

				if (resp.getItemId() == frItemStockConfigurePostParent.getItemId()) {
					
					List<StockDetails> stockDetailsList =resp.getStockDetails();
					
					for (int j = 0; j < frItemStockConfigurePosts.size(); j++) {

						GetFrItemStockConfiguration frItemStockConfigurePostChild = frItemStockConfigurePosts.get(j);

						if (frItemStockConfigurePostChild.getItemId() == frItemStockConfigurePostParent.getItemId()) {

							StockDetails stockDetails = new StockDetails();
							System.out.println("child object " + frItemStockConfigurePostChild.toString());

							stockDetails.setFrStockId(frItemStockConfigurePostChild.getFrStockId());
							stockDetails.setType(frItemStockConfigurePostChild.getType());
							stockDetails.setMinQty(frItemStockConfigurePostChild.getMinQty());
							stockDetails.setMaxQty(frItemStockConfigurePostChild.getMaxQty());
							stockDetails.setReorderQty(frItemStockConfigurePostChild.getReorderQty());
							stockDetailsList.add(stockDetails);

						}
					}
					resp.setStockDetails(stockDetailsList);
					
					isUnique = false;
				}

			}

			if (isUnique) {

				FrStockResponse frStockResponse = new FrStockResponse();
				frStockResponse.setItemId(frItemStockConfigurePostParent.getItemId());
				frStockResponse.setItemName(frItemStockConfigurePostParent.getItemName());

				List<StockDetails> stockDetailsList = new ArrayList<StockDetails>();

				for (int j = 0; j < frItemStockConfigurePosts.size(); j++) {

					GetFrItemStockConfiguration frItemStockConfigurePostChild = frItemStockConfigurePosts.get(j);

					if (frItemStockConfigurePostChild.getItemId() == frItemStockConfigurePostParent.getItemId()) {

						StockDetails stockDetails = new StockDetails();
						System.out.println("child object " + frItemStockConfigurePostChild.toString());

						stockDetails.setFrStockId(frItemStockConfigurePostChild.getFrStockId());
						stockDetails.setType(frItemStockConfigurePostChild.getType());
						stockDetails.setMinQty(frItemStockConfigurePostChild.getMinQty());
						stockDetails.setMaxQty(frItemStockConfigurePostChild.getMaxQty());
						stockDetails.setReorderQty(frItemStockConfigurePostChild.getReorderQty());
						stockDetailsList.add(stockDetails);

					}
				}
				frStockResponse.setStockDetails(stockDetailsList);
				frStockResponseList.add(frStockResponse);

			} // end of unique if
		}
		System.out.println("frStockResponseList" + frStockResponseList.toString());
		Info info = new Info();

		info.setError(false);
		info.setMessage("All Fr Item Stock Config displayed. Total Items: " + frItemStockConfigurePosts.size());

		configurePostList.setInfo(info);

		return frStockResponseList;

	}

	@RequestMapping(value = "/getfrItemConfSetting", method = RequestMethod.GET)
	public @ResponseBody FrItemStockConfigureList getfrItemConfSetting() {

		FrItemStockConfigureList frItemStockConfigureList = new FrItemStockConfigureList();

		List<FrItemStockConfigure> frItemStockConf = frItemConfService.getFrItemConfigure();

		frItemStockConfigureList.setFrItemStockConfigure(frItemStockConf);

		Info info = new Info();

		info.setError(false);
		info.setMessage("Item Setting Configure displayed successfully");

		frItemStockConfigureList.setInfo(info);

		return frItemStockConfigureList;

	}

	// static data for aws testing
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	@ResponseBody
	public String showDummyDate() {

		String dummyData = "{\"schedulerList\":[{\"schId\":11,\"schDate\":\"09-09-2017\",\"schTodate\":\"21-09-2017\",\"schOccasionname\":\" Sept\",\"schMessage\":\"Sept\",\"schFrdttime\":0.0,\"schTodttime\":0.0,\"isActive\":1,\"delStatus\":0},{\"schId\":17,\"schDate\":\"19-09-2017\",\"schTodate\":\"21-09-2017\",\"schOccasionname\":\"19 to 21 sept\",\"schMessage\":\"hjdsfhjf\",\"schFrdttime\":0.0,\"schTodttime\":0.0,\"isActive\":1,\"delStatus\":0},{\"schId\":20,\"schDate\":\"13-09-2017\",\"schTodate\":\"20-09-2017\",\"schOccasionname\":\"13 to 20 sept\",\"schMessage\":\"rrrrrrr\",\"schFrdttime\":0.0,\"schTodttime\":0.0,\"isActive\":1,\"delStatus\":0},{\"schId\":21,\"schDate\":\"19-09-2017\",\"schTodate\":\"20-09-2017\",\"schOccasionname\":\"19 to 20 sept\",\"schMessage\":\"sep\",\"schFrdttime\":0.0,\"schTodttime\":0.0,\"isActive\":1,\"delStatus\":0}],\"info\":{\"message\":\"latest news  displayed successfully\",\"error\":false}}";

		return dummyData;
	}

	// Login FrontEnd Franchisee
	@RequestMapping(value = { "/loginFr" }, method = RequestMethod.POST)
	@ResponseBody
	public String loginFr(@RequestParam("frCode") String frCode, @RequestParam("frPasswordKey") String frPasswordKey) {

		String jsonFr = franchiseeService.findFranchiseeByFrCode(frCode, frPasswordKey);
		System.out.println("JsonString" + jsonFr);

		return jsonFr;

	}
	// php web service anmol android

	@RequestMapping(value = { "/getLogin" }, method = RequestMethod.POST)
	@ResponseBody
	public GetLogin getLogin(@RequestParam("fr_code") String fr_code, @RequestParam("fr_password") String fr_password) {

		FrLoginResponse frLogRes = franchiseeService.getLogin(fr_code, fr_password);

		List<Event> eventsList = eventService.findAllEvent();

		GetLogin loginRes = new GetLogin();

		if (frLogRes.getLoginInfo().isError() == false) {

			System.err.println("LOgin Success");

			loginRes.setStatus("success");

			Admin admin = new Admin();

			admin.setError(false);
			admin.setFr_id("" + frLogRes.getFranchisee().getFrId());
			admin.setFr_name(frLogRes.getFranchisee().getFrName());
			admin.setFr_email(frLogRes.getFranchisee().getFrMob());
			admin.setFr_image(frLogRes.getFranchisee().getFrImage());
			admin.setType("" + frLogRes.getFranchisee().getFrRateCat());

			loginRes.setAdmin(admin);

		} else {

			loginRes.setStatus("failed");
		}
		List<Flavor> flavor = new ArrayList<Flavor>();

		for (Event event : eventsList) {

			Flavor flvr = new Flavor();

			flvr.setDel_status("" + event.getDelStatus());
			flvr.setSpe_id("" + event.getSpeId());
			flvr.setSpe_name(event.getSpeName());

			flavor.add(flvr);
		}
		loginRes.setFlavor(flavor);

		System.out.println("frLogRes" + frLogRes);

		return loginRes;

	}

	// Configure Sp Day Cake
	@RequestMapping(value = { "/configureSpDayCk" }, method = RequestMethod.POST)

	public @ResponseBody ErrorMessage configureSpDayCk(@RequestBody SpDayConfigure spDayConfigure)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		System.out.println("Inside Place Order " + spDayConfigure.toString());

		ErrorMessage errorMessage = configureSpDayCakeService.configureSpDayCake(spDayConfigure);

		return errorMessage;

	}

	// For Getting List Of Configured Special day Cake List
	@RequestMapping(value = "/getConfiguredSpDayCkList", method = RequestMethod.GET)
	public @ResponseBody ConfiguredSpDayCkResponse getConfiguredSpDayCkList() {

		ConfiguredSpDayCkResponse configuredSpDayCkResponse = configureSpDayCakeService.getConfiguredSpDayCkList();

		return configuredSpDayCkResponse;

	}

	// For Getting List Of Special day Cake List by Current Date Between
	// DeliveryFromDate to DeliveryToDate

	@RequestMapping(value = "/getSpDayCkList", method = RequestMethod.POST)
	public @ResponseBody ConfiguredSpDayCkResponse getSpDayCkList(@RequestParam int frId) {

		ConfiguredSpDayCkResponse configuredSpDayCkResponse = configureSpDayCakeService.getSpDayCkList(frId);

		return configuredSpDayCkResponse;

	}

	// getConfSpDayCake
	@RequestMapping(value = "/getConfSpDayCake", method = RequestMethod.POST)
	public @ResponseBody GetConfiguredSpDayCk getConfSpDayCake(@RequestParam int spdayId) {

		GetConfiguredSpDayCk getConfiguredSpDayCk = configureSpDayCakeService.findConfSpDayCake(spdayId);
		return getConfiguredSpDayCk;

	}

	// Delete Configure SpDayCk
	@RequestMapping(value = "/deleteConfSpDayCk", method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteConfSpDayCk(@RequestParam int spdayId) {

		ErrorMessage errorMessage = configureSpDayCakeService.findConfiguredSpDayCk(spdayId);

		return errorMessage;
	}

	// Place Item Order
	@RequestMapping(value = { "/placeOrder" }, method = RequestMethod.POST)

	public @ResponseBody List<Orders> placeItemOrder(@RequestBody List<Orders> orderJson)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		List<Orders> participantJsonList;
		List<Orders> jsonResult;

		OrderLog log = new OrderLog();
		log.setFrId(orderJson.get(0).getFrId());
		log.setJson(orderJson.toString());

		logRespository.save(log);

		System.out.println("Inside Place Order " + orderJson.toString());

		jsonResult = orderService.placeOrder(orderJson);

		return jsonResult;

	}

	@Autowired
	TSpCakeSupRepo tSpCakeSupRepo;

	// Place SpCake Order
	@RequestMapping(value = { "/placeSpCakeOrder" }, method = RequestMethod.POST)

	public @ResponseBody SpCakeOrderRes placeSpCakeOrder(@RequestBody SpCakeOrders orderJson)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Inside Place Order " + orderJson.toString());

		SpCakeOrderRes spCakeOrderRes = spCakeOrdersService.placeSpCakeOrder(orderJson);

		System.err.println("Prod Date : " + spCakeOrderRes.getSpCakeOrder().getSpProdDate());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Date date = new Date();
		String sqlSpProduDate = dateFormat.format(spCakeOrderRes.getSpCakeOrder().getSpProdDate());

		System.out.println("sqlSpProduDate " + sqlSpProduDate);

		int orderCount = spCakeOrdersService.findSpCkeOrdCountByProduDate(sqlSpProduDate);

		SpCakeOrders order = spCakeOrderRes.getSpCakeOrder();
		TSpCakeSup spCakeSup = new TSpCakeSup();

		spCakeSup.setDate(order.getSpProdDate());
		spCakeSup.setDelStatus(0);
		spCakeSup.setFrId(order.getFrId());
		spCakeSup.setInputKgFr(order.getSpSelectedWeight());
		spCakeSup.setMenuId(order.getMenuId());
		spCakeSup.setSpCakeId(order.getSpId());
		spCakeSup.setSrNo(orderCount);
		spCakeSup.setStatus(0);
		spCakeSup.settSpCakeOrderNo(order.getSpOrderNo());

		spCakeSup.setExVar("0.0");// for report to get required time to complete cake

		spCakeSup.setExInt(0); // to report for geting if cake rate/cost changed default zero
		System.err.println("spCakeSup bean " + spCakeSup.toString());
		try {

			TSpCakeSup response = tSpCakeSupRepo.save(spCakeSup);

		} catch (Exception e) {

			System.out.println("Exce in addTSpCake Rest RestApi " + e.getMessage());

			e.printStackTrace();
		}

		return spCakeOrderRes;

	}

	// Search Special Cake By SpecialCake Code
	@RequestMapping("/searchSpecialCake")
	public @ResponseBody SearchSpCakeResponse searchSpecialCake(@RequestParam String spCode) {

		SearchSpCakeResponse searchSpCakeResponse = specialcakeService.searchSpecialCake(spCode);

		return searchSpCakeResponse;

	}

	// Anmol 9/7/2019-----------------------------------------
	// Search Special Cake By SpecialCake Category Code
	@RequestMapping("/searchSpecialCakeCat")
	public @ResponseBody SearchSpCakeResponse searchSpecialCakeCat(@RequestParam String spCode) {

		SearchSpCakeResponse searchSpCakeResponse = specialcakeCatService.searchSpecialCake(spCode);

		return searchSpCakeResponse;

	}

	// Search Special Cake Configured spCode of Franchisee
	@RequestMapping("/searchSpCodes")
	public @ResponseBody List<String> searchSpCodes(@RequestParam List<Integer> items, @RequestParam int frId,
			@RequestParam int menuId) {

		List<String> spCakeCodesResponse = specialcakeService.searchSpecialCakeSpCodes(items, frId, menuId);

		return spCakeCodesResponse;

	}

	// Anmol 9/7/2019------------------------------------------
	// Search Special Cake Cat Configured spCode of Franchisee
	@RequestMapping("/searchSpCatCodes")
	public @ResponseBody List<String> searchSpCatCodes(@RequestParam List<Integer> items, @RequestParam int frId,
			@RequestParam int menuId) {

		List<String> spCakeCodesResponse = specialcakeCatService.searchSpecialCakeSpCodes(items, frId, menuId);

		return spCakeCodesResponse;

	}

	// Search Special Cake Order History
	@RequestMapping("/SpCakeOrderHistory")
	public @ResponseBody SpCkOrderHisList searchSpCakeOrderHistory(@RequestParam int menuId,
			@RequestParam String spDeliveryDt, String frCode) {

		SpCkOrderHisList spCakeOrderList = spCakeOrdersService.searchOrderHistory(menuId, spDeliveryDt, frCode);
		return spCakeOrderList;

	}

	// Search Special Cake Order History
	@RequestMapping("/albumOrderHistory")
	public @ResponseBody SpCkOrderHisList searchAlbumOrderHistory(@RequestParam int menuId,
			@RequestParam String spDeliveryDt, String frCode) {

		SpCkOrderHisList spCakeOrderList = spCakeOrdersService.searchOrderHistoryAlbum(menuId, spDeliveryDt, frCode);

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
			@RequestParam("usertype") int usertype, @RequestParam("deptId") int deptId) {

		System.out.println("input user" + username.toString());

		User user = new User();
		user.setUsername(username);
		user.setPassword(userpwd);
		user.setUsertype(usertype);

		user.setDeptId(deptId);
		user.setDelStatus(0);

		String jsonResult = userService.save(user);

		return jsonResult;
	}

	// 23 March updateUser
	@Autowired
	UserRepository updateUserRepo;

	@RequestMapping(value = { "/updateUser" }, method = RequestMethod.POST)
	@ResponseBody
	public Info updateUser(@RequestBody User user) {

		Info info = new Info();
		int result;

		try {

			if (user.getDelStatus() == 0) {
				result = updateUserRepo.updateUser(user.getId(), user.getPassword(), user.getUsertype(),
						user.getDeptId());
			} else {
				result = updateUserRepo.delteUser(user.getId(), user.getDelStatus());
			}
			if (result > 0) {
				info.setError(false);
				info.setMessage("success Update/delete User");
			} else {
				info.setError(true);
				info.setMessage("Failed Updating/deleting User");
			}
		} catch (Exception e) {
			System.out.println("Exc in updating user/deleting user" + e.getMessage());
			e.printStackTrace();
		}
		return info;
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

	@Autowired
	TRegSpCakeSupRepo tRegSpCakeSupRepo;

	// Place SpCake Order
	@RequestMapping(value = { "/insertRegularSpCake" }, method = RequestMethod.POST)

	public @ResponseBody RegularSpCake saveRegularSpCake(@RequestBody RegularSpCake regularSpCake)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Inside Place Order " + regularSpCake.toString());

		RegularSpCake ordRes = regularSpCkOrderService.placeRegularSpCakeOrder(regularSpCake);

		System.out.println("Inside Place Order ordRes.getRspProduDate() " + ordRes.getRspProduDate());

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String sqlSpProduDate = dateFormat.format(ordRes.getRspProduDate());
		System.out.println("sqlSpProduDate" + sqlSpProduDate);
		int orderCount = regularSpCkOrderService.getRegSpCakeOrdCountByProdDate(sqlSpProduDate);

		TRegSpCakeSup regSpCakeSup = new TRegSpCakeSup();

		regSpCakeSup.setCatId(0);
		regSpCakeSup.setFrId(ordRes.getFrId());
		regSpCakeSup.setItemId(Integer.parseInt(ordRes.getItemId()));
		regSpCakeSup.setProdDate(ordRes.getRspProduDate());
		regSpCakeSup.setSrNo(orderCount);
		regSpCakeSup.setStatus(0);
		regSpCakeSup.setSubCatId(Integer.parseInt(ordRes.getRspSubCat()));
		regSpCakeSup.settRegSupOrderId(ordRes.getRspId());

		regSpCakeSup.setMenuId(Integer.parseInt(ordRes.getMenuId()));

		regSpCakeSup.setExChar("0.0");

		System.err.println("regSpCakeSup " + regSpCakeSup.toString());

		try {

			TRegSpCakeSup response = tRegSpCakeSupRepo.save(regSpCakeSup);

			System.err.println("Res T refg sp cake sup " + response.toString());

		} catch (Exception e) {

			System.out.println("Exce in addTRegSpCakeSup Rest Rest api " + e.getMessage());

			e.printStackTrace();
		}

		return ordRes;

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
			@RequestParam("itemRate2") double itemRate2, @RequestParam("itemRate3") double itemRate3,
			@RequestParam("itemMrp1") double itemMrp1, @RequestParam("itemMrp2") double itemMrp2,
			@RequestParam("itemMrp3") double itemMrp3, @RequestParam("minQty") int minQty,
			@RequestParam("itemImage") String itemImage, @RequestParam("itemTax1") double itemTax1,
			@RequestParam("itemTax2") double itemTax2, @RequestParam("itemTax3") double itemTax3,
			@RequestParam("itemIsUsed") int itemIsUsed, @RequestParam("itemSortId") double itemSortId,
			@RequestParam("grnTwo") int grnTwo, @RequestParam("itemShelfLife") int itemShelfLife) {

		Item item = new Item();
		item.setItemImage(itemImage);
		item.setItemGrp1(itemGrp1);
		item.setDelStatus(0);
		item.setItemGrp2(itemGrp2);
		item.setItemGrp3(itemGrp3);
		item.setItemIsUsed(itemIsUsed);
		item.setMinQty(minQty);
		item.setItemMrp1(itemMrp1);
		item.setItemMrp2(itemMrp2);
		item.setItemMrp3(itemMrp3);
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
		item.setShelfLife(itemShelfLife);

		ErrorMessage jsonResult = itemService.saveItem(item);

		return JsonUtil.javaToJson(jsonResult);
	}

	// Configure Franchisee
	@RequestMapping(value = { "/configureFranchisee" }, method = RequestMethod.POST)
	@ResponseBody
	public String configureFranchisee(@RequestParam("frId") int frId, @RequestParam("menuId") int menuId,
			@RequestParam("catId") int catId, @RequestParam("settingType") int settingType,
			@RequestParam("fromTime") String fromTime, @RequestParam("toTime") String toTime,
			@RequestParam("day") String day, @RequestParam("date") String date,
			@RequestParam("itemShow") String itemShow) throws ParseException {

		/*
		 * DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); Date fromDate;
		 * Date fDate = formatter.parse(date);
		 * 
		 * java.sql.Date sqlDate = new java.sql.Date(fDate.getTime());
		 */

		// DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		/// Date fromDate, toDate;
		// toDate = formatter.parse(date);
		// java.sql.Date sqlDate = new java.sql.Date(toDate.getTime());

		ConfigureFranchisee configureFr = new ConfigureFranchisee();
		configureFr.setFrId(frId);
		configureFr.setMenuId(menuId);
		configureFr.setDelStatus(0);
		configureFr.setSettingType(settingType);
		configureFr.setFromTime(fromTime);
		configureFr.setToTime(toTime);
		configureFr.setDay(day);
		configureFr.setDate(date);
		configureFr.setItemShow(itemShow);
		configureFr.setCatId(catId);
		configureFr.setSubCatId(11);

		String jsonResult = connfigureService.configureFranchisee(configureFr);
		try {
			/*// -------------------------------------------------------------------------------------
			AllFrIdNameList allFrIdNamesList = allFrIdNameService.getFrIdAndName();

			for (int i = 0; i < allFrIdNamesList.getFrIdNamesList().size(); i++) {*/

				List<PostFrItemStockHeader> prevStockHeader = postFrOpStockHeaderRepository
						.findByFrIdAndIsMonthClosedAndCatId(frId, 0,
								configureFr.getCatId());
				// --------------------------------------------------------------------------------------------
				List<PostFrItemStockDetail> postFrItemStockDetailList = new ArrayList<PostFrItemStockDetail>();
				List<Integer> ids = Stream.of(configureFr.getItemShow().split(",")).map(Integer::parseInt)
						.collect(Collectors.toList());
				System.err.println("16 ids --" + ids.toString());
				List<Item> itemsList = itemService.findAllItemsByItemId(ids);
				System.err.println("17 itemsList --" + itemsList.toString());
				for (int k = 0; k < itemsList.size(); k++) {

					PostFrItemStockDetail prevFrItemStockDetail = postFrOpStockDetailRepository
							.findByItemIdAndOpeningStockHeaderId(itemsList.get(k).getId(),
									prevStockHeader.get(0).getOpeningStockHeaderId());
					System.err.println("18 prevFrItemStockDetail --" + prevFrItemStockDetail);
					if (prevFrItemStockDetail == null) {
						PostFrItemStockDetail postFrItemStockDetail = new PostFrItemStockDetail();
						postFrItemStockDetail
								.setOpeningStockHeaderId(prevStockHeader.get(0).getOpeningStockHeaderId());// first
																											// stock
																											// header
																											// (month
																											// closed
																											// 0
																											// status))
						postFrItemStockDetail.setOpeningStockDetailId(0);
						postFrItemStockDetail.setRegOpeningStock(0);
						postFrItemStockDetail.setItemId(itemsList.get(k).getId());
						postFrItemStockDetail.setRemark("");
						postFrItemStockDetailList.add(postFrItemStockDetail);
						System.err.println("19 postFrItemStockDetail --" + postFrItemStockDetail.toString());
					}
				}
				postFrOpStockDetailRepository.save(postFrItemStockDetailList);
				System.err.println("20 postFrItemStockDetailList --" + postFrItemStockDetailList.toString());
				// ---------------------------------------------------------------------------------------
			//}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonResult;
	}

	@RequestMapping(value = "/updateFrConfMenuTime")
	public @ResponseBody Info updateFrConf(@RequestParam("frIdList") List<Integer> frIdList,
			@RequestParam("menuId") int menuId, @RequestParam("fromTime") String fromTime,
			@RequestParam("toTime") String toTime, 
			@RequestParam("settingType") int settingType,@RequestParam("date") String date,
			@RequestParam("day") String day
			) {
		Info info = new Info();
		int result = 0;
		System.err.println("from time received " + fromTime + "to time  " + toTime);
		System.err.println("Fr id List " + frIdList.toString());
		try {
			if (frIdList.contains(0)) {
				System.err.println("fr id is zero");
				result = connfigureService.updateFrConfForAllFr(menuId, fromTime, toTime,settingType,date,day);
			} else {
				System.err.println("fr Id is not zero");
				result = connfigureService.updateFrConfForSelectedFr(frIdList, menuId, fromTime, toTime,settingType,date,day);
			}

			if (result > 0) {
				info.setError(false);
				info.setMessage("update Conf fr Successs");
			} else {
				info.setError(true);
				info.setMessage("update Conf fr Failed");
			}
		} catch (Exception e) {
			System.err.println("Exc in rest /updateFrConfMenuTime" + e.getMessage());
			e.printStackTrace();
		}
		return info;

	}

	// Get Configured MenuId
	@RequestMapping(value = "/getConfiguredMenuId")
	public @ResponseBody List<Integer> getConfiguredMenuId(@RequestParam int frId) {

		List<Integer> configuredMenuIdList = connfigureService.findConfiguredMenuId(frId);
		return configuredMenuIdList;

	}

	// Save Route
	@RequestMapping(value = { "/insertRoute" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveRoute(@RequestParam("routeName") String routeName, @RequestParam int routeSeqNo) {
		String jsonResult = "";

		System.out.println("input route " + routeName.toString());

		Route route = new Route();
		route.setRouteName(routeName);
		route.setRouteSeqNo(routeSeqNo);

		route.setDelStatus(0);

		jsonResult = JsonUtil.javaToJson(route);
		jsonResult = routeService.save(route);

		return jsonResult;
	}

	// Save Franchisee
	@RequestMapping(value = { "/saveFranchisee" }, method = RequestMethod.POST)
	@ResponseBody
	public ErrorMessage saveFranchisee(@RequestParam("frName") String frName, @RequestParam("frCode") String frCode,
			@RequestParam("frOpeningDate") String frOpeningDate, @RequestParam("frRate") int frRate,
			@RequestParam("frImage") String frImage, @RequestParam("frRouteId") int frRouteId,
			@RequestParam("frCity") String frCity, @RequestParam("frKg1") int frKg1, @RequestParam("frKg2") int frKg2,
			@RequestParam("frKg3") int frKg3, @RequestParam("frKg4") int frKg4, @RequestParam("frEmail") String frEmail,
			@RequestParam("frPassword") String frPassword, @RequestParam("frMob") String frMob,
			@RequestParam("frOwner") String frOwner, @RequestParam("frRateCat") int frRateCat,
			@RequestParam("grnTwo") int grnTwo, @RequestParam("ownerBirthDate") String ownerBirthDate,
			@RequestParam("fbaLicenseDate") String fbaLicenseDate,	@RequestParam("delStatus") int delStatus,
			@RequestParam("frAgreementDate") String frAgreementDate, @RequestParam("frGstType") int frGstType,
			@RequestParam("frGstNo") String frGstNo, @RequestParam("stockType") int stockType,
			@RequestParam("frAddress") String frAddress, @RequestParam("frTarget") int frTarget,
			@RequestParam("isSameState") int isSameState) throws ParseException {
		// DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// java.util.Date date = sdf.parse(frOpeningDate);
		// java.sql.Date sqlOpeningDate = new java.sql.Date(date.getTime());
		java.sql.Date sqlOpeningDate = Common.convertToSqlDate(frOpeningDate);
		java.sql.Date sqlFrAgreementDate = Common.convertToSqlDate(frAgreementDate);
		java.sql.Date sqlOwnerBirthDate = Common.convertToSqlDate(ownerBirthDate);
		java.sql.Date SQLfbaLicenseDate = Common.convertToSqlDate(fbaLicenseDate);

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

		franchisee.setFrAddress(frAddress);
		franchisee.setFrAgreementDate(sqlFrAgreementDate);
		franchisee.setFrGstNo(frGstNo);
		franchisee.setFrGstType(frGstType);
		franchisee.setOwnerBirthDate(sqlOwnerBirthDate);
		franchisee.setFbaLicenseDate(SQLfbaLicenseDate);
		franchisee.setStockType(stockType);
		franchisee.setFrTarget(frTarget);
		franchisee.setIsSameState(isSameState);
		franchisee.setDelStatus(delStatus);

		System.out.println("" + franchisee.toString());
		ErrorMessage jsonResult = franchiseeService.saveFranchisee(franchisee);

		return jsonResult;
	}

	// Special Cake Insert
	@RequestMapping(value = { "/insertSpecialCake" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveSpecialCake(@RequestParam("spCode") String spcode, @RequestParam("spName") String spname,
			@RequestParam("spType") int sptype, @RequestParam("spMinwt") String spminwt,
			@RequestParam("spMaxwt") String spmaxwt, @RequestParam("spBookb4") String spbookb4,
			@RequestParam("spImage") String spimage, @RequestParam("spTax1") double sptax1,
			@RequestParam("spTax2") double sptax2, @RequestParam("spTax3") double sptax3,
			@RequestParam("speIdlist") String speidlist, @RequestParam("erpLinkcode") String erplinkcode,
			@RequestParam("spPhoupload") int spphoupload, @RequestParam("timeTwoappli") int timetwoappli,
			@RequestParam("isUsed") int isused, @RequestParam("spDesc") String spDesc,
			@RequestParam("orderQty") int orderQty, @RequestParam("orderDiscount") float orderDiscount,
			@RequestParam("isCustChoiceCk") int isCustChoiceCk, @RequestParam("isAddonRateAppli") int isAddonRateAppli,
			@RequestParam("mrpRate1") int mrpRate1, @RequestParam("mrpRate2") int mrpRate2,
			@RequestParam("mrpRate3") int mrpRate3, @RequestParam("spRate1") int spRate1,
			@RequestParam("spRate2") int spRate2, @RequestParam("spRate3") int spRate3,
			@RequestParam("isSlotUsed") int isSlotUsed) {

		String jsonResult = "";
		try {
			System.out.println("isSlotUsed");

			SpecialCake specialcake = new SpecialCake();

			specialcake.setSpCode(spcode);
			specialcake.setSpName(spname);
			specialcake.setSpType(sptype);
			specialcake.setSpMinwt(spminwt);
			specialcake.setSpMaxwt(spmaxwt);
			specialcake.setSpBookb4(spbookb4);
			specialcake.setSprId(1);
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

			specialcake.setSpDesc(spDesc);
			specialcake.setOrderQty(orderQty);
			specialcake.setOrderDiscount(orderDiscount);
			specialcake.setIsCustChoiceCk(isCustChoiceCk);
			specialcake.setIsAddonRateAppli(isAddonRateAppli);
			specialcake.setMrpRate1(mrpRate1);
			specialcake.setMrpRate2(mrpRate2);
			specialcake.setMrpRate3(mrpRate3);
			specialcake.setSpRate1(spRate1);
			specialcake.setSpRate2(spRate2);
			specialcake.setSpRate3(spRate3);
			specialcake.setIsSlotUsed(isSlotUsed);

			System.out.println("*********Special Cake:***************" + specialcake.toString());

			jsonResult = specialcakeService.save(specialcake);
			System.out.println("\n " + jsonResult);
		} catch (Exception e) {
			System.out.println("inser cake error " + e.getMessage());

			e.printStackTrace();
		}
		return jsonResult;

	}

	// Anmol- 9/7/2019---------------------

	// Special Cake Category Insert
	@RequestMapping(value = { "/insertSpecialCakeCat" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveSpecialCakeCat(@RequestParam("spCode") String spcode, @RequestParam("spName") String spname,
			@RequestParam("spType") int sptype, @RequestParam("spMinwt") String spminwt,
			@RequestParam("spMaxwt") String spmaxwt, @RequestParam("spBookb4") String spbookb4,
			@RequestParam("spImage") String spimage, @RequestParam("spTax1") double sptax1,
			@RequestParam("spTax2") double sptax2, @RequestParam("spTax3") double sptax3,
			@RequestParam("speIdlist") String speidlist, @RequestParam("erpLinkcode") String erplinkcode,
			@RequestParam("spPhoupload") int spphoupload, @RequestParam("timeTwoappli") int timetwoappli,
			@RequestParam("isUsed") int isused, @RequestParam("spDesc") String spDesc,
			@RequestParam("orderQty") int orderQty, @RequestParam("orderDiscount") float orderDiscount,
			@RequestParam("isCustChoiceCk") int isCustChoiceCk, @RequestParam("isAddonRateAppli") int isAddonRateAppli,
			@RequestParam("mrpRate1") int mrpRate1, @RequestParam("mrpRate2") int mrpRate2,
			@RequestParam("mrpRate3") int mrpRate3, @RequestParam("spRate1") int spRate1,
			@RequestParam("spRate2") int spRate2, @RequestParam("spRate3") int spRate3,
			@RequestParam("isSlotUsed") int isSlotUsed) {

		String jsonResult = "";
		try {
			System.out.println("isSlotUsed");

			SpecialCakeCat specialcake = new SpecialCakeCat();

			specialcake.setSpCode(spcode);
			specialcake.setSpName(spname);
			specialcake.setSpType(sptype);
			specialcake.setSpMinwt(spminwt);
			specialcake.setSpMaxwt(spmaxwt);
			specialcake.setSpBookb4(spbookb4);
			specialcake.setSprId(1);
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

			specialcake.setSpDesc(spDesc);
			specialcake.setOrderQty(orderQty);
			specialcake.setOrderDiscount(orderDiscount);
			specialcake.setIsCustChoiceCk(isCustChoiceCk);
			specialcake.setIsAddonRateAppli(isAddonRateAppli);
			specialcake.setMrpRate1(mrpRate1);
			specialcake.setMrpRate2(mrpRate2);
			specialcake.setMrpRate3(mrpRate3);
			specialcake.setSpRate1(spRate1);
			specialcake.setSpRate2(spRate2);
			specialcake.setSpRate3(spRate3);
			specialcake.setIsSlotUsed(isSlotUsed);

			System.out.println("*********Special Cake:***************" + specialcake.toString());

			jsonResult = specialcakeCatService.save(specialcake);
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
			@RequestParam("msgDetails") String msgDetails, @RequestParam("isActive") int isActive) {

		String jsonResult = "";
		try {

			System.out.println("rest from date : " + msgFrdt);
			System.out.println("rest to date : " + msgTodt);

			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			/*
			 * Date fromDate =sdf.parse(msgFrdt); Date toDate =sdf.parse(msgTodt);
			 */

			java.sql.Date sqlFromDate = Common.convertToSqlDate(msgFrdt);
			java.sql.Date sqlToDate = Common.convertToSqlDate(msgTodt);

			System.out.println("sql from date ** : " + sqlFromDate);
			System.out.println("sql  to date ** : " + sqlToDate);

			Message message = new Message();
			message.setMsgFrdt(sqlFromDate);
			message.setMsgTodt(sqlToDate);
			message.setMsgImage(msgImage);
			message.setMsgHeader(msgHeader);
			message.setMsgDetails(msgDetails);
			message.setIsActive(isActive);
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
			@RequestParam("schFrdttime") double schFrdttime, @RequestParam("schTodttime") double schTodttime) {
		String jsonScheduler = "";
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
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

	// Show Route List
	@RequestMapping(value = { "/showRouteList" }, method = RequestMethod.GET)
	@ResponseBody
	public RouteList showRouteList() {

		List<Route> jsonRouteList = routeService.showAllRoute();
		System.out.println("jsonRouteList" + jsonRouteList.toString());
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

	// Anmol 9/7/2019-----------------------------------
	// show Special Cake Cat List
	@RequestMapping(value = { "/showSpecialCakeCatList" }, method = RequestMethod.GET)
	@ResponseBody
	public SpecialCakeCatList showSpecialCakeCatList() {
		List<SpecialCakeCat> jsonSpecialCakeList = specialcakeCatService.showAllSpecialCake();
		SpecialCakeCatList specialCakeList = new SpecialCakeCatList();
		specialCakeList.setSpecialCakeCat(jsonSpecialCakeList);
		Info info = new Info();
		info.setError(false);
		info.setMessage("SpecialCake Cat list displayed Successfully");
		specialCakeList.setInfo(info);
		return specialCakeList;

	}

	// php web service anmol 25-26-05-2018
	@RequestMapping(value = { "/getAllSpCakes" }, method = RequestMethod.GET)
	@ResponseBody
	public SpecialCakeBeanList getAllSpCakes() {
		SpecialCakeBeanList spBeanList = new SpecialCakeBeanList();

		try {

			List<SpecialCake> jsonSpecialCakeList = specialcakeService.showAllSpecialCake();
			System.err.println("Sp cake Size " + jsonSpecialCakeList.size());

			List<Event> eventsList = eventService.findAllEvent();
			List<SpecialCakeBean> spList = new ArrayList<SpecialCakeBean>();

			if (jsonSpecialCakeList.isEmpty() == false) {

				spBeanList.setStatus("success");

			}

			List<Integer> eIds;
			for (SpecialCake spCake : jsonSpecialCakeList) {

				SpecialCakeBean bean = new SpecialCakeBean();

				bean.setDel_status("" + spCake.getDelStatus());
				bean.setErp_link_code("" + spCake.getErpLinkcode());
				bean.setIs_used("" + spCake.getIsUsed());
				bean.setSp_book_b4("" + spCake.getSpBookb4());
				bean.setSp_code("" + spCake.getSpCode());
				bean.setSp_id("" + spCake.getSpId());
				bean.setSp_image("" + spCake.getSpImage());
				bean.setSp_max_wt("" + spCake.getSpMaxwt());
				bean.setSp_min_wt("" + spCake.getSpMinwt());
				bean.setSp_name("" + spCake.getSpName());
				bean.setSp_pho_upload("" + spCake.getSpPhoupload());
				bean.setSp_tax1("" + spCake.getSpTax1());
				bean.setSp_tax2("" + spCake.getSpTax2());
				bean.setSp_tax3("" + spCake.getSpTax3());
				bean.setSp_type("" + spCake.getSpType());
				bean.setSpr_add_on_rate("" + spCake.getMrpRate3());
				bean.setSpr_id("" + spCake.getSprId());
				bean.setSpr_name("" + spCake.getMrpRate1());
				bean.setSpr_rate("" + spCake.getMrpRate2());

				eIds = new ArrayList<Integer>();

				String events = spCake.getSpeIdlist();

				// Remove whitespace and split by comma
				List<String> result = Arrays.asList(events.split("\\s*,\\s*"));
				// System.err.println("Sp Name " + spCake.getSpName());
				// System.err.println("EVENT ARRAYList " + result.toString());

				String eventNameList = "";
				for (int j = 0; j < result.size(); j++) {

					String strEventId = result.get(j);
					int eventId = Integer.parseInt(strEventId);

					for (Event event : eventsList) {

						if (event.getSpeId() == eventId) {

							eventNameList = eventNameList + event.getSpeName() + ",";
						}
					}

				}
				bean.setSpe_id_list(eventNameList);
				spList.add(bean);

				// List<Event> eventsList = eventService.getAllEventsBySpeIdIn(intEvId);
				// System.err.println("eList " + eventsList.toString());

			}
			spBeanList.setSp_cake(spList);

			/*
			 * if (jsonSpecialCakeList.isEmpty() == false) {
			 * 
			 * spBeanList.setStatus("success");
			 * 
			 * }
			 * 
			 * List<SpecialCakeBean> spList = new ArrayList<SpecialCakeBean>(); for
			 * (SpecialCake spCake : jsonSpecialCakeList) {
			 * 
			 * SpecialCakeBean bean = new SpecialCakeBean();
			 * 
			 * bean.setDel_status("" + spCake.getDelStatus()); bean.setErp_link_code("" +
			 * spCake.getErpLinkcode()); bean.setIs_used("" + spCake.getIsUsed());
			 * bean.setSp_book_b4("" + spCake.getSpBookb4()); bean.setSp_code("" +
			 * spCake.getSpCode()); bean.setSp_id("" + spCake.getSpId());
			 * bean.setSp_image("" + spCake.getSpImage()); bean.setSp_max_wt("" +
			 * spCake.getSpMaxwt()); bean.setSp_min_wt("" + spCake.getSpMinwt());
			 * bean.setSp_name("" + spCake.getSpName()); bean.setSp_pho_upload("" +
			 * spCake.getSpPhoupload()); bean.setSp_tax1("" + spCake.getSpTax1());
			 * bean.setSp_tax2("" + spCake.getSpTax2()); bean.setSp_tax3("" +
			 * spCake.getSpTax3()); bean.setSp_type("" + spCake.getSpType());
			 * bean.setSpe_id_list("" + spCake.getSpeIdlist()); bean.setSpr_add_on_rate("" +
			 * spCake.getSpRate3()); bean.setSpr_id("" + spCake.getSprId());
			 * bean.setSpr_name("" + spCake.getSpRate1()); bean.setSpr_rate("" +
			 * spCake.getSpRate2()); spList.add(bean); } spBeanList.setSp_cake(spList);
			 */
		} catch (Exception e) {

			System.err.println(
					"Exception in getting sp cake List for Php web service @Rest /getAllSpCakes" + e.getMessage());
			e.printStackTrace();

		}
		return spBeanList;

	}

	// Anmol 9/7/2019----------------------------------------
	// php web service anmol 25-26-05-2018
	@RequestMapping(value = { "/getAllSpCakesCat" }, method = RequestMethod.GET)
	@ResponseBody
	public SpecialCakeBeanList getAllSpCakesCat() {
		SpecialCakeBeanList spBeanList = new SpecialCakeBeanList();

		try {

			List<SpecialCakeCat> jsonSpecialCakeList = specialcakeCatService.showAllSpecialCake();
			System.err.println("Sp cake Size " + jsonSpecialCakeList.size());

			List<Event> eventsList = eventService.findAllEvent();
			List<SpecialCakeBean> spList = new ArrayList<SpecialCakeBean>();

			if (jsonSpecialCakeList.isEmpty() == false) {

				spBeanList.setStatus("success");

			}

			List<Integer> eIds;
			for (SpecialCakeCat spCake : jsonSpecialCakeList) {

				SpecialCakeBean bean = new SpecialCakeBean();

				bean.setDel_status("" + spCake.getDelStatus());
				bean.setErp_link_code("" + spCake.getErpLinkcode());
				bean.setIs_used("" + spCake.getIsUsed());
				bean.setSp_book_b4("" + spCake.getSpBookb4());
				bean.setSp_code("" + spCake.getSpCode());
				bean.setSp_id("" + spCake.getSpId());
				bean.setSp_image("" + spCake.getSpImage());
				bean.setSp_max_wt("" + spCake.getSpMaxwt());
				bean.setSp_min_wt("" + spCake.getSpMinwt());
				bean.setSp_name("" + spCake.getSpName());
				bean.setSp_pho_upload("" + spCake.getSpPhoupload());
				bean.setSp_tax1("" + spCake.getSpTax1());
				bean.setSp_tax2("" + spCake.getSpTax2());
				bean.setSp_tax3("" + spCake.getSpTax3());
				bean.setSp_type("" + spCake.getSpType());
				bean.setSpr_add_on_rate("" + spCake.getMrpRate3());
				bean.setSpr_id("" + spCake.getSprId());
				bean.setSpr_name("" + spCake.getMrpRate1());
				bean.setSpr_rate("" + spCake.getMrpRate2());

				eIds = new ArrayList<Integer>();

				String events = spCake.getSpeIdlist();

				// Remove whitespace and split by comma
				List<String> result = Arrays.asList(events.split("\\s*,\\s*"));
				// System.err.println("Sp Name " + spCake.getSpName());
				// System.err.println("EVENT ARRAYList " + result.toString());

				String eventNameList = "";
				for (int j = 0; j < result.size(); j++) {

					String strEventId = result.get(j);
					int eventId = Integer.parseInt(strEventId);

					for (Event event : eventsList) {

						if (event.getSpeId() == eventId) {

							eventNameList = eventNameList + event.getSpeName() + ",";
						}
					}

				}
				bean.setSpe_id_list(eventNameList);
				spList.add(bean);

				// List<Event> eventsList = eventService.getAllEventsBySpeIdIn(intEvId);
				// System.err.println("eList " + eventsList.toString());

			}
			spBeanList.setSp_cake(spList);

			/*
			 * if (jsonSpecialCakeList.isEmpty() == false) {
			 * 
			 * spBeanList.setStatus("success");
			 * 
			 * }
			 * 
			 * List<SpecialCakeBean> spList = new ArrayList<SpecialCakeBean>(); for
			 * (SpecialCake spCake : jsonSpecialCakeList) {
			 * 
			 * SpecialCakeBean bean = new SpecialCakeBean();
			 * 
			 * bean.setDel_status("" + spCake.getDelStatus()); bean.setErp_link_code("" +
			 * spCake.getErpLinkcode()); bean.setIs_used("" + spCake.getIsUsed());
			 * bean.setSp_book_b4("" + spCake.getSpBookb4()); bean.setSp_code("" +
			 * spCake.getSpCode()); bean.setSp_id("" + spCake.getSpId());
			 * bean.setSp_image("" + spCake.getSpImage()); bean.setSp_max_wt("" +
			 * spCake.getSpMaxwt()); bean.setSp_min_wt("" + spCake.getSpMinwt());
			 * bean.setSp_name("" + spCake.getSpName()); bean.setSp_pho_upload("" +
			 * spCake.getSpPhoupload()); bean.setSp_tax1("" + spCake.getSpTax1());
			 * bean.setSp_tax2("" + spCake.getSpTax2()); bean.setSp_tax3("" +
			 * spCake.getSpTax3()); bean.setSp_type("" + spCake.getSpType());
			 * bean.setSpe_id_list("" + spCake.getSpeIdlist()); bean.setSpr_add_on_rate("" +
			 * spCake.getSpRate3()); bean.setSpr_id("" + spCake.getSprId());
			 * bean.setSpr_name("" + spCake.getSpRate1()); bean.setSpr_rate("" +
			 * spCake.getSpRate2()); spList.add(bean); } spBeanList.setSp_cake(spList);
			 */
		} catch (Exception e) {

			System.err.println(
					"Exception in getting sp cake List for Php web service @Rest /getAllSpCakesCat" + e.getMessage());
			e.printStackTrace();

		}
		return spBeanList;

	}

	// php web service neha 25-26-05-2018
	@RequestMapping(value = { "/getAllSpCakesByAlbum" }, method = RequestMethod.GET)
	@ResponseBody
	public SpecialCakeBeanList getAllSpCakesByAlbum() {
		SpecialCakeBeanList spBeanList = new SpecialCakeBeanList();

		try {

			List<SpecialCake> jsonSpecialCakeList = specialCakeRepository.getData();
			System.err.println("Sp cake Size " + jsonSpecialCakeList.size());

			List<Event> eventsList = eventService.findAllEvent();
			List<SpecialCakeBean> spList = new ArrayList<SpecialCakeBean>();

			if (jsonSpecialCakeList.isEmpty() == false) {

				spBeanList.setStatus("success");

			}

			List<Integer> eIds;
			for (SpecialCake spCake : jsonSpecialCakeList) {

				SpecialCakeBean bean = new SpecialCakeBean();

				bean.setDel_status("" + spCake.getDelStatus());
				bean.setErp_link_code("" + spCake.getErpLinkcode());
				bean.setIs_used("" + spCake.getIsUsed());
				bean.setSp_book_b4("" + spCake.getSpBookb4());
				bean.setSp_code("" + spCake.getSpCode());
				bean.setSp_id("" + spCake.getSpId());
				bean.setSp_image("" + spCake.getSpImage());
				bean.setSp_max_wt("" + spCake.getSpMaxwt());
				bean.setSp_min_wt("" + spCake.getSpMinwt());
				bean.setSp_name("" + spCake.getSpName());
				bean.setSp_pho_upload("" + spCake.getSpPhoupload());
				bean.setSp_tax1("" + spCake.getSpTax1());
				bean.setSp_tax2("" + spCake.getSpTax2());
				bean.setSp_tax3("" + spCake.getSpTax3());
				bean.setSp_type("" + spCake.getSpType());
				bean.setSpr_add_on_rate("" + spCake.getMrpRate3());
				bean.setSpr_id("" + spCake.getSprId());
				bean.setSpr_name("" + spCake.getMrpRate1());
				bean.setSpr_rate("" + spCake.getMrpRate2());

				eIds = new ArrayList<Integer>();

				String events = spCake.getSpeIdlist();

				// Remove whitespace and split by comma
				List<String> result = Arrays.asList(events.split("\\s*,\\s*"));
				// System.err.println("Sp Name " + spCake.getSpName());
				// System.err.println("EVENT ARRAYList " + result.toString());

				String eventNameList = "";
				for (int j = 0; j < result.size(); j++) {

					String strEventId = result.get(j);
					int eventId = Integer.parseInt(strEventId);

					for (Event event : eventsList) {

						if (event.getSpeId() == eventId) {

							eventNameList = eventNameList + event.getSpeName() + ",";
						}
					}

				}
				bean.setSpe_id_list(eventNameList);
				spList.add(bean);

			}
			spBeanList.setSp_cake(spList);

		} catch (Exception e) {

			System.err.println(
					"Exception in getting sp cake List for Php web service @Rest /getAllSpCakes" + e.getMessage());
			e.printStackTrace();

		}
		return spBeanList;

	}

	// Anmol 24-6-2019
	@RequestMapping(value = { "/getAllSpCakesByFrForAlbum" }, method = RequestMethod.POST)
	@ResponseBody
	public SpecialCakeBeanList getAllSpCakesByFrForAlbum(@RequestParam("frId") int frId) {
		SpecialCakeBeanList spBeanList = new SpecialCakeBeanList();

		try {

			List<MenuForAlbum> menuAlbumList = menuForAlbumRepo.getData(frId);

			String itemIdList = "";
			if (menuAlbumList != null) {
				if (menuAlbumList.size() > 0) {
					for (int i = 0; i < menuAlbumList.size(); i++) {
						itemIdList = itemIdList + menuAlbumList.get(i).getItemShow() + ",";
					}
				}
			}

			String itemIds = itemIdList.substring(0, itemIdList.length() - 1);
			System.err.println("MENU ITEM LIST-------------------------------------- " + itemIds);

			List<Integer> newList = Stream.of(itemIds.split(",")).map(Integer::parseInt)
					.collect(Collectors.toList());

			List<SpecialCake> jsonSpecialCakeList = specialCakeRepository.getDataByFr(newList);
			System.err.println("Sp cake Size " + jsonSpecialCakeList.size());

			List<Event> eventsList = eventService.findAllEvent();
			List<SpecialCakeBean> spList = new ArrayList<SpecialCakeBean>();

			if (jsonSpecialCakeList.isEmpty() == false) {

				spBeanList.setStatus("success");

			}

			List<Integer> eIds;
			for (SpecialCake spCake : jsonSpecialCakeList) {

				SpecialCakeBean bean = new SpecialCakeBean();

				bean.setDel_status("" + spCake.getDelStatus());
				bean.setErp_link_code("" + spCake.getErpLinkcode());
				bean.setIs_used("" + spCake.getIsUsed());
				bean.setSp_book_b4("" + spCake.getSpBookb4());
				bean.setSp_code("" + spCake.getSpCode());
				bean.setSp_id("" + spCake.getSpId());
				bean.setSp_image("" + spCake.getSpImage());
				bean.setSp_max_wt("" + spCake.getSpMaxwt());
				bean.setSp_min_wt("" + spCake.getSpMinwt());
				bean.setSp_name("" + spCake.getSpName());
				bean.setSp_pho_upload("" + spCake.getSpPhoupload());
				bean.setSp_tax1("" + spCake.getSpTax1());
				bean.setSp_tax2("" + spCake.getSpTax2());
				bean.setSp_tax3("" + spCake.getSpTax3());
				bean.setSp_type("" + spCake.getSpType());
				bean.setSpr_add_on_rate("" + spCake.getMrpRate3());
				bean.setSpr_id("" + spCake.getSprId());
				bean.setSpr_name("" + spCake.getMrpRate1());
				bean.setSpr_rate("" + spCake.getMrpRate2());

				eIds = new ArrayList<Integer>();

				String events = spCake.getSpeIdlist();

				// Remove whitespace and split by comma
				List<String> result = Arrays.asList(events.split("\\s*,\\s*"));
				// System.err.println("Sp Name " + spCake.getSpName());
				// System.err.println("EVENT ARRAYList " + result.toString());

				String eventNameList = "";
				for (int j = 0; j < result.size(); j++) {

					String strEventId = result.get(j);
					int eventId = Integer.parseInt(strEventId);

					for (Event event : eventsList) {

						if (event.getSpeId() == eventId) {

							eventNameList = eventNameList + event.getSpeName() + ",";
						}
					}

				}
				bean.setSpe_id_list(eventNameList);
				spList.add(bean);

			}
			spBeanList.setSp_cake(spList);

		} catch (Exception e) {

			System.err.println("Exception in getting sp cake List for Php web service @Rest /getAllSpCakesByFrForAlbum"
					+ e.getMessage());
			e.printStackTrace();

		}
		return spBeanList;

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

	@RequestMapping(value = { "/showMiniSubCatList" }, method = RequestMethod.GET)
	@ResponseBody
	public List<MiniSubCategory> showMiniSubCatList() {

		List<MiniSubCategory> miniSubCategorylist = miniSubCategoryRepository.showMiniSubCatList();

		return miniSubCategorylist;
	}

	@RequestMapping(value = { "/showMiniSubCatListBySubCatId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<MiniSubCategory> showMiniSubCatListBySubCatId(@RequestParam("subCatId") int subCatId) {

		List<MiniSubCategory> miniSubCategorylist = miniSubCategoryRepository.showMiniSubCatListBySubCatId(subCatId);

		return miniSubCategorylist;
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
			@RequestParam("itemRate1") double itemRate1, @RequestParam("itemRate2") double itemRate2,
			@RequestParam("itemRate3") double itemRate3, @RequestParam("itemMrp1") double itemMrp1,
			@RequestParam("itemMrp2") double itemMrp2, @RequestParam("itemMrp3") double itemMrp3,
			@RequestParam("minQty") int minQty, @RequestParam("itemImage") String itemImage,
			@RequestParam("itemTax1") double itemTax1, @RequestParam("itemTax2") double itemTax2,
			@RequestParam("itemTax3") double itemTax3, @RequestParam("itemIsUsed") int itemIsUsed,
			@RequestParam("itemSortId") double itemSortId, @RequestParam("grnTwo") int grnTwo,
			@RequestParam("itemShelfLife") int itemShelfLife) {

		Item item = itemService.findItems(id);
		item.setItemImage(itemImage);
		item.setItemGrp1(itemGrp1);
		item.setItemGrp2(itemGrp2);
		item.setItemGrp3(itemGrp3);
		item.setMinQty(minQty);
		item.setItemIsUsed(itemIsUsed);
		item.setItemMrp1(itemMrp1);
		item.setItemMrp2(itemMrp2);
		item.setItemMrp3(itemMrp3);
		item.setItemRate1(itemRate1);
		item.setItemRate2(itemRate2);
		item.setItemRate3(itemRate3);
		item.setItemName(itemName);
		item.setItemSortId(itemSortId);
		item.setItemTax1(itemTax1);
		item.setItemTax2(itemTax2);
		item.setItemTax3(itemTax3);
		item.setGrnTwo(grnTwo);
		item.setShelfLife(itemShelfLife);
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

	// Delete Scheduler
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

	// Delete Franchisee
	@RequestMapping("/deleteFranchisee")
	public @ResponseBody String deleteFranchisee(@RequestParam int frId) {
		Info info = new Info();
		try {
			Franchisee franchisee = franchiseeService.findFranchisee(frId);
			franchisee.setDelStatus(1);
			ErrorMessage jsonResult = franchiseeService.saveFranchisee(franchisee);
			if (jsonResult.isError()) {
				info.setError(true);
				info.setMessage("Franchisee deletion failed");
			} else if (!jsonResult.isError()) {
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

	// Update Event
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

	// Get Event
	@RequestMapping(value = "/getEvent")
	public @ResponseBody Event getEvent(@RequestParam int speId) {

		Event event = eventService.findEventById(speId);
		return event;

	}

	// Get Rate
	@RequestMapping(value = "/getRate")
	public @ResponseBody Rates getRate(@RequestParam int sprId) {

		Rates rates = rateService.findRate(sprId);
		return rates;

	}

	// Get SubCategories
	@RequestMapping(value = "/getSubCategories")
	public @ResponseBody CategoryList getAllSubCategories(@RequestParam int catId) {

		CategoryList subCategoryList = subCategoryService.findSubCategoryByCatId(catId);
		return subCategoryList;

	}

	// Get Flavour
	@RequestMapping(value = "/getFlavour", method = RequestMethod.GET)
	public @ResponseBody Flavour getFlavour(@RequestParam int spfId) {

		Flavour flavour = flavourService.findFlavour(spfId);
		return flavour;

	}
	
	// Get Flavour  Mahendra
		@RequestMapping(value = "/getFlavourById", method = RequestMethod.POST)
		public @ResponseBody Flavour getFlavourById(@RequestParam int id) {
			int spfId=id;
			Flavour flavour = flavourService.findFlavour(spfId);
			return flavour;

		}

	// Get Items
	@RequestMapping(value = "/getItemsByCatId", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItems(@RequestParam String itemGrp1) {

		List<Item> items = itemService.findFrItems(itemGrp1);
		return items;

	}

	@RequestMapping(value = "/getItemsByCatIdForGateSale", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemsByCatIdForGateSale(@RequestParam String itemGrp1) {

		List<Item> items = itemService.getItemsByCatIdForGateSale(itemGrp1);
		return items;

	}

	// Get Items By Category order by sub cat and sort id
	@RequestMapping(value = "/getItemsByCatIdAndSortId", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemsByCatIdAndSortId(@RequestParam String itemGrp1) {

		List<Item> items = null;
		try {
			items = itemRepository.findByItemGrp1AndDelStatusOrderByItemGrp2AscItemSortIdAsc(itemGrp1, 0);
		} catch (Exception e) {
			items = new ArrayList<>();
			e.printStackTrace();

		}
		return items;

	}

	// 12 April Sachin
	// Get Items By Category order by sub cat and sort id
	@RequestMapping(value = "/getItemsBySubCatId", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemsBySubCatId(@RequestParam("subCatId") String subCatId) {

		List<Item> items = null;
		try {
			items = itemRepository.findByItemGrp2OrderByItemGrp2(subCatId);
		} catch (Exception e) {
			items = new ArrayList<>();
			e.printStackTrace();

		}
		return items;

	}

	// Get Items By Item Id and Delete Status 0
	@RequestMapping(value = "/getItemsByItemId", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItems(@RequestParam List<Integer> itemList) {

		List<Item> items = itemService.findItemsByItemId(itemList);
		return items;

	}

	// Get Items By Item->FR Id and Delete Status 0
	@RequestMapping(value = "/getItemsById", method = RequestMethod.POST)
	public @ResponseBody ItemResponse getItemList(@RequestParam List<Integer> itemList) {

		ItemResponse itemResponse = new ItemResponse();
		ErrorMessage errorMessage = new ErrorMessage();
		List<Item> items = itemService.findItemsByItemId(itemList);
		if (items != null) {
			itemResponse.setItemList(items);
			errorMessage.setError(false);
			errorMessage.setMessage("Success");
		} else {
			errorMessage.setError(true);
			errorMessage.setMessage("No Items Found");
		}
		return itemResponse;

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

	// 3
	@RequestMapping(value = "/getStockItemsBySubCatId", method = RequestMethod.POST)
	public @ResponseBody List<StockItem> getStockItemsBySubCatId(@RequestParam("subCatId") int subCatId,
			@RequestParam("type") int type) {

		List<StockItem> items = new ArrayList<StockItem>();
		try {

			items = itemStockRepository.findBySubCatIdAndType(subCatId, type);

		} catch (Exception e) {
			items = new ArrayList<>();
			e.printStackTrace();

		}
		return items;

	}

	@RequestMapping(value = "/getStockItemsBySubCatIdAndSupp", method = RequestMethod.POST)
	public @ResponseBody List<StockItem> getStockItemsBySubCatIdAndSupp(@RequestParam("subCatId") int subCatId,
			@RequestParam("type") int type, @RequestParam("suppId") int suppId, @RequestParam("grpId") int grpId) {

		List<StockItem> items = new ArrayList<StockItem>();
		try {

			items = itemStockRepository.getStockItemsBySubCatIdAndSupp(subCatId, type, suppId, grpId);

		} catch (Exception e) {
			items = new ArrayList<>();
			e.printStackTrace();

		}
		return items;

	}

	@RequestMapping(value = "/getFrItems", method = RequestMethod.POST)
	public @ResponseBody List<GetFrItems> getFrItems(@RequestParam List<Integer> items, @RequestParam String frId,
			@RequestParam String date, @RequestParam String menuId) {

		List<ItemWithSubCat> itemList = new ArrayList<>();
		List<GetFrItems> frItemList = new ArrayList<>();

		List<Orders> orderList = new ArrayList<>();

		System.out.println("input param items= " + items.toString());

		System.out.println("date param = " + date.toString());

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
					getFrItems.setItemMrp3(item.getItemMrp3());
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
					getFrItems.setItemShelfLife(item.getItemShelfLife());

					for (int j = 0; j < orderList.size(); j++) {

						if (String.valueOf(item.getId()).equalsIgnoreCase(orderList.get(j).getItemId())) {

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
	
	
	
	//Anmol----->6/12/2019---------------------->OPS---Regular Cakes & Pastries Time 2---Items----with ----limit 
	@RequestMapping(value = "/getFrItemsWithLimit", method = RequestMethod.POST)
	public @ResponseBody List<GetFrItemsWithLimit> getFrItemsWithLimit(@RequestParam List<Integer> items, @RequestParam String frId,
			@RequestParam String date, @RequestParam String menuId,@RequestParam int type) {

		List<ItemWithSubCat> itemList = new ArrayList<>();
		List<GetFrItemsWithLimit> frItemList = new ArrayList<>();

		List<Orders> orderList = new ArrayList<>();

		System.out.println("input param items= " + items.toString());

		System.out.println("date param = " + date.toString());

		try {
			itemList = getFrItemsService.findFrItemsWithLimit(items,type);
			
			System.err.println("ITEMS ----------------- "+itemList);
			
			
			try {
				orderList = prevItemOrderService.findFrItemOrders(items, frId, date, menuId);

				for (int i = 0; i < itemList.size(); i++) {

					ItemWithSubCat item = itemList.get(i);

					GetFrItemsWithLimit getFrItems = new GetFrItemsWithLimit();

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
					getFrItems.setItemMrp3(item.getItemMrp3());
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
					getFrItems.setQtyLimit(item.getQtyLimit());
					getFrItems.setItemShelfLife(item.getItemShelfLife());

					for (int j = 0; j < orderList.size(); j++) {

						if (String.valueOf(item.getId()).equalsIgnoreCase(orderList.get(j).getItemId())) {

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

	// Get All Items ForItemDetail"
	@RequestMapping(value = { "/getAllItemsForForItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody ItemsList findAllItems(@RequestParam int rmId, @RequestParam int rmType) {
		ItemsList itemsList = itemService.getItemsForItemDetail(rmId, rmType);
		return itemsList;
	}

	// Get All Items order By Sub category, Sort Id
	@RequestMapping(value = { "/getAllItemsBySorting" }, method = RequestMethod.GET)
	public @ResponseBody ItemsList getAllItemsBySorting() {
		ItemsList itemsList = itemService.getAllItemsBySorting();
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

	@RequestMapping(value = { "/getFranchiseeAndMenu" }, method = RequestMethod.GET)
	public @ResponseBody FranchiseeAndMenuList findFranchiseeAndMenu() {

		FranchiseeAndMenuList franchiseeAndMenu = new FranchiseeAndMenuList();
		List<Franchisee> allFranchisee = franchiseeService.findAllFranchisee();

		List<AllMenus> allMenu = menuService.findAllMenus();

		franchiseeAndMenu.setAllMenu(allMenu);
		franchiseeAndMenu.setAllFranchisee(allFranchisee);
		return franchiseeAndMenu;
	}

	// Get Item
	@RequestMapping(value = { "/getItem" }, method = RequestMethod.POST)
	public @ResponseBody Item findItem(@RequestParam("id") int id) {
		Item item = itemService.findItem(id);
		return item;
	}

	// Get Franchisee
	@RequestMapping(value = { "/getFranchisee" }, method = RequestMethod.GET)
	public @ResponseBody Franchisee findFranchisee(@RequestParam("frId") int frId) {
		Franchisee franchisee = franchiseeService.findFranchisee(frId);

		String openDate = franchisee.getFrOpeningDate().toString();
		// String strDate=Common.convertToDMY(openDate);
		// java.sql.Date sqlDate=Common.convertToSqlDate(strDate);
		// franchisee.setFrOpeningDate(sqlDate);
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
		//List<Franchisee> franchisee = franchiseeService.findAllFranchisee();
		
		List<Franchisee> franchisee = franchiseeService.getAllFranchisee();	//mahendra //31-01-2020
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
			@RequestParam String msgDetails, @RequestParam("isActive") int isActive) {

		Message message = messageService.findMessage(id);
		Info info = new Info();
		try {
			/*
			 * DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); Date fromDate,
			 * toDate;
			 */

			java.sql.Date sqlFromDate = Common.convertToSqlDate(msgFrdt);
			java.sql.Date sqlToDate = Common.convertToSqlDate(msgTodt);

			System.out.println("sql from date ** : " + sqlFromDate);
			System.out.println("sql  to date ** : " + sqlToDate);
			/*
			 * toDate = formatter.parse(msgTodt); fromDate = formatter.parse(msgFrdt);
			 */

			message.setMsgFrdt(sqlFromDate);
			message.setMsgTodt(sqlToDate);
			message.setMsgImage(msgImage);
			message.setMsgHeader(msgHeader);
			message.setMsgDetails(msgDetails);
			message.setIsActive(isActive);

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
	public @ResponseBody String updateScheduler(@RequestParam("id") int id, @RequestParam("schDate") String schDate,
			@RequestParam("schToDate") String schToDate, @RequestParam("schOccasionName") String schOccasionName,
			@RequestParam("schMessage") String schMessage, @RequestParam("schFrdtTime") double schFrdtTime,
			@RequestParam("schTodtTime") double schTodtTime, @RequestParam("isActive") int isActive) {

		Scheduler scheduler = schedulerService.findScheduler(id);
		Info info = new Info();
		try {
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date fromDate, toDate;

			toDate = formatter.parse(schToDate);
			fromDate = formatter.parse(schDate);

			/*
			 * java.sql.Date sqlFromDate=Common.convertToSqlDate(schDate); java.sql.Date
			 * sqlToDate=Common.convertToSqlDate(schToDate);
			 */

			scheduler.setSchDate(fromDate);
			scheduler.setSchTodate(toDate);
			scheduler.setSchOccasionname(schOccasionName);
			scheduler.setSchMessage(schMessage);
			scheduler.setSchFrdttime(schFrdtTime);
			scheduler.setSchTodttime(schTodtTime);
			scheduler.setIsActive(isActive);

			String jsonResult = schedulerService.save(scheduler);
			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("scheduler Update failure");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("scheduler Update successfully");
			}

		} catch (Exception e) {
			System.out.println("error in updating schedule  Rest Api" + e.getMessage());
			info.setError(true);
			info.setMessage("" + e.getMessage());

		}

		return JsonUtil.javaToJson(info);
	}

	// Update Route
	@RequestMapping("/updateRoute")
	public @ResponseBody String updateRoute(@RequestParam int id, @RequestParam String routeName,
			@RequestParam int routeSeqNo) {

		Route route = routeService.findRoute(id);
		Info info = new Info();
		try {
			route.setRouteName(routeName);
			route.setRouteSeqNo(routeSeqNo);

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
			@RequestParam String spCode, @RequestParam String spbookb4, @RequestParam String spimage,
			@RequestParam double sptax1, @RequestParam double sptax2, @RequestParam double sptax3,
			@RequestParam String spidlist, @RequestParam String erplinkcode, @RequestParam int spphoupload,
			@RequestParam int timetwoappli, @RequestParam("spDesc") String spDesc,
			@RequestParam("orderQty") int orderQty, @RequestParam("orderDiscount") float orderDiscount,
			@RequestParam("isCustChoiceCk") int isCustChoiceCk, @RequestParam("isAddonRateAppli") int isAddonRateAppli,
			@RequestParam("mrpRate1") int mrpRate1, @RequestParam("mrpRate2") int mrpRate2,
			@RequestParam("mrpRate3") int mrpRate3, @RequestParam("spRate1") int spRate1,
			@RequestParam("spRate2") int spRate2, @RequestParam("spRate3") int spRate3,
			@RequestParam("isUsed") int isUsed, @RequestParam("isSlotUsed") int isSlotUsed) {

		SpecialCake specialCake = specialcakeService.findSpecialCake(id);
		Info info = new Info();
		try {

			specialCake.setSpName(spname);
			specialCake.setSpCode(spCode);
			specialCake.setSpType(sptype);
			specialCake.setSpMinwt(spminwt);
			specialCake.setSpMaxwt(spmaxwt);
			specialCake.setSpBookb4(spbookb4);
			specialCake.setSpImage(spimage);
			specialCake.setSpTax1(sptax1);
			specialCake.setSprId(1);
			specialCake.setSpTax2(sptax2);
			specialCake.setSpTax3(sptax3);
			specialCake.setSpeIdlist(spidlist);
			specialCake.setErpLinkcode(erplinkcode);
			specialCake.setSpPhoupload(spphoupload);
			specialCake.setTimeTwoappli(timetwoappli);
			specialCake.setBaseCode("0");
			specialCake.setIsUsed(isUsed);

			specialCake.setSpDesc(spDesc);
			specialCake.setOrderQty(orderQty);
			specialCake.setOrderDiscount(orderDiscount);
			specialCake.setIsCustChoiceCk(isCustChoiceCk);
			specialCake.setIsAddonRateAppli(isAddonRateAppli);
			specialCake.setMrpRate1(mrpRate1);
			specialCake.setMrpRate2(mrpRate2);
			specialCake.setMrpRate3(mrpRate3);
			specialCake.setSpRate1(spRate1);
			specialCake.setSpRate2(spRate2);
			specialCake.setSpRate3(spRate3);
			specialCake.setIsSlotUsed(isSlotUsed);

			System.out.println("*********Special Cake:***************" + specialCake.getIsSlotUsed());

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

	// Anmol 9/7/2019-------------------------------------
	// Update Special Cake
	@RequestMapping("/updateSpecialCakeCat")
	public @ResponseBody String updateSpecialCakeCat(@RequestParam int id, @RequestParam String spname,
			@RequestParam int sptype, @RequestParam String spminwt, @RequestParam String spmaxwt,
			@RequestParam String spCode, @RequestParam String spbookb4, @RequestParam String spimage,
			@RequestParam double sptax1, @RequestParam double sptax2, @RequestParam double sptax3,
			@RequestParam String spidlist, @RequestParam String erplinkcode, @RequestParam int spphoupload,
			@RequestParam int timetwoappli, @RequestParam("spDesc") String spDesc,
			@RequestParam("orderQty") int orderQty, @RequestParam("orderDiscount") float orderDiscount,
			@RequestParam("isCustChoiceCk") int isCustChoiceCk, @RequestParam("isAddonRateAppli") int isAddonRateAppli,
			@RequestParam("mrpRate1") int mrpRate1, @RequestParam("mrpRate2") int mrpRate2,
			@RequestParam("mrpRate3") int mrpRate3, @RequestParam("spRate1") int spRate1,
			@RequestParam("spRate2") int spRate2, @RequestParam("spRate3") int spRate3,
			@RequestParam("isUsed") int isUsed, @RequestParam("isSlotUsed") int isSlotUsed) {

		SpecialCakeCat specialCake = specialcakeCatService.findSpecialCake(id);
		Info info = new Info();
		try {

			specialCake.setSpName(spname);
			specialCake.setSpCode(spCode);
			specialCake.setSpType(sptype);
			specialCake.setSpMinwt(spminwt);
			specialCake.setSpMaxwt(spmaxwt);
			specialCake.setSpBookb4(spbookb4);
			specialCake.setSpImage(spimage);
			specialCake.setSpTax1(sptax1);
			specialCake.setSprId(1);
			specialCake.setSpTax2(sptax2);
			specialCake.setSpTax3(sptax3);
			specialCake.setSpeIdlist(spidlist);
			specialCake.setErpLinkcode(erplinkcode);
			specialCake.setSpPhoupload(spphoupload);
			specialCake.setTimeTwoappli(timetwoappli);
			specialCake.setBaseCode("0");
			specialCake.setIsUsed(isUsed);

			specialCake.setSpDesc(spDesc);
			specialCake.setOrderQty(orderQty);
			specialCake.setOrderDiscount(orderDiscount);
			specialCake.setIsCustChoiceCk(isCustChoiceCk);
			specialCake.setIsAddonRateAppli(isAddonRateAppli);
			specialCake.setMrpRate1(mrpRate1);
			specialCake.setMrpRate2(mrpRate2);
			specialCake.setMrpRate3(mrpRate3);
			specialCake.setSpRate1(spRate1);
			specialCake.setSpRate2(spRate2);
			specialCake.setSpRate3(spRate3);
			specialCake.setIsSlotUsed(isSlotUsed);

			System.out.println("*********Special Cake:***************" + specialCake.getIsSlotUsed());

			String jsonResult = specialcakeCatService.save(specialCake);

			if (jsonResult == null) {

				info.setError(true);
				info.setMessage("Special cake cat update failed");

			} else if (jsonResult != null) {

				info.setError(false);
				info.setMessage("Special cake cat successfully updated");
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

	// Delete Special Cake Cat
	@RequestMapping(value = "/deleteSpecialCakeCat")
	public @ResponseBody String deleteSpecialCakeCat(@RequestParam int spId) {

		Info info = new Info();
		try {
			SpecialCakeCat specialCake = specialcakeCatService.findSpecialCake(spId);
			specialCake.setDelStatus(1);
			String jsonResult = specialcakeCatService.save(specialCake);

			if (jsonResult == null) {
				info.setError(true);
				info.setMessage("deletion of Special Cake cat failed");
			} else if (jsonResult != null) {
				info.setError(false);
				info.setMessage("deletion of Special Cake cat Successful");

			}
		} catch (Exception e) {
			System.out.println("error in deleting special cake cat" + e.getMessage());
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
	public ErrorMessage updateFranchisee(@RequestParam("frId") int frId, @RequestParam("frName") String frName,
			@RequestParam("frCode") String frCode, @RequestParam("frOpeningDate") String frOpeningDate,
			@RequestParam("frRate") int frRate, @RequestParam("frImage") String frImage,
			@RequestParam("frRouteId") int frRouteId, @RequestParam("frCity") String frCity,
			@RequestParam("frKg1") int frKg1, @RequestParam("frKg2") int frKg2, @RequestParam("frKg3") int frKg3,
			@RequestParam("frKg4") int frKg4, @RequestParam("frEmail") String frEmail,
			@RequestParam("frPassword") String frPassword, @RequestParam("frMob") String frMob,
			@RequestParam("frOwner") String frOwner, @RequestParam("frRateCat") int frRateCat,
			@RequestParam("grnTwo") int grnTwo, @RequestParam("delStatus") int delStatus,
			@RequestParam("ownerBirthDate") String ownerBirthDate,
			@RequestParam("fbaLicenseDate") String fbaLicenseDate,
			@RequestParam("frAgreementDate") String frAgreementDate, @RequestParam("frGstType") int frGstType,
			@RequestParam("frGstNo") String frGstNo, @RequestParam("stockType") int stockType,
			@RequestParam("frAddress") String frAddress, @RequestParam("frTarget") int frTarget,
			@RequestParam("isSameState") int isSameState) {
		ErrorMessage jsonResult = new ErrorMessage();
		try {

			System.out.println("inside update fr rest controller:1721 line");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date = sdf.parse(frOpeningDate);
			System.out.println("parsed Date line no 1728 : " + date);
			java.sql.Date sqlOpeningDate = new java.sql.Date(date.getTime());
			Date utilFrAgreementDate = sdf.parse(frAgreementDate);
			Date utilOwnerBirthDate = sdf.parse(ownerBirthDate);
			Date utilFbaLicenseDate = sdf.parse(fbaLicenseDate);
			/*
			 * java.sql.Date sqlFrAgreementDate=Common.convertToSqlDate(frAgreementDate);
			 * java.sql.Date sqlOwnerBirthDate=Common.convertToSqlDate(ownerBirthDate);
			 * java.sql.Date SQLfrLicenseDate=Common.convertToSqlDate(frLicenseDate);
			 */
			/*
			 * System.out.println("fr opening as of form "+frOpeningDate); java.sql.Date
			 * sqlDate=Common.convertToSqlDate(frOpeningDate);
			 * 
			 * 
			 * System.out.println("sql date for update fr ****** "+sqlDate);
			 */

			Franchisee franchisee = franchiseeService.findFranchisee(frId);

			// franchisee.setFrId(frId);
			franchisee.setFrName(frName);
			franchisee.setFrCode(frCode);
			franchisee.setFrOpeningDate(date);
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

			franchisee.setFrAddress(frAddress);
			franchisee.setFrAgreementDate(utilFrAgreementDate);
			franchisee.setFrGstNo(frGstNo);
			franchisee.setFrGstType(frGstType);
			franchisee.setOwnerBirthDate(utilOwnerBirthDate);
			franchisee.setFbaLicenseDate(utilFbaLicenseDate);
			franchisee.setStockType(stockType);
			franchisee.setFrTarget(frTarget);
			franchisee.setIsSameState(isSameState);

			System.out.println("" + franchisee.toString());
			jsonResult = franchiseeService.saveFranchisee(franchisee);
		} catch (Exception e) {
			System.out.println("update scheduler rest exce " + e.getMessage());
		}

		return jsonResult;
		// return "abc";
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

	// get Special Cake Cat

	@RequestMapping("/getSpecialCakeCat")
	public @ResponseBody SpecialCakeCat getSpecialCakeCat(@RequestParam int spId) {

		SpecialCakeCat specialCake = specialcakeCatService.findSpecialCake(spId);
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
	public GetOrderList getOrderList(@RequestParam List<String> frId, @RequestParam List<String> menuId,
			@RequestParam String date) {
		GetOrderList orderList = new GetOrderList();
		try {
			/*
			 * DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			 * 
			 * Date date1; date1 = formatter.parse(date);
			 */
			System.out.println("date str :" + date);

			String strDate = Common.convertToYMD(date);
			System.out.println("Converted date " + strDate);

			System.out.println("fr id in rest " + frId.toString());
			List<GetOrder> jsonOrderList = getOrderService.findOrder(frId, menuId, strDate);

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

	@RequestMapping(value = { "/getSubCatOrderTotal" }, method = RequestMethod.POST)
	@ResponseBody
	public List<OrderItemSubCatTotal> getSubCatOrderTotal(@RequestParam List<String> frId,
			@RequestParam List<String> menuId, @RequestParam String date) {
		List<OrderItemSubCatTotal> orderItemList = null;
		try {
			String strDate = Common.convertToYMD(date);
			orderItemList = orderItemSubCatTotalRepository.findQtyTotalSubCatWise(frId, menuId, strDate);

		} catch (Exception e) {

			System.out.println("exception in getSubCatOrderTotal  rest controller" + e.getMessage());
		}
		return orderItemList;

	}
	
	//Sachin 12-02-2020
	@RequestMapping(value = { "/getSubCatOrderTotalSpecItemId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<OrderItemSubCatTotal> getSubCatOrderTotalSpecItem(@RequestParam List<String> frId,
			@RequestParam List<String> menuId, @RequestParam String date,@RequestParam List<String> itemId) {
		List<OrderItemSubCatTotal> orderItemList = null;
		try {
			String strDate = Common.convertToYMD(date);
			orderItemList = orderItemSubCatTotalRepository.findQtyTotalSubCatWiseSpecItem(frId, menuId, strDate,itemId);

		} catch (Exception e) {

			System.out.println("exception in getSubCatOrderTotal  rest controller" + e.getMessage());
		}
		return orderItemList;

	}

	@RequestMapping(value = { "/getSubCatOrderTotalAllFr" }, method = RequestMethod.POST)
	@ResponseBody
	public List<OrderItemSubCatTotal> getSubCatOrderTotalAllFr(@RequestParam List<String> menuId,
			@RequestParam String date) {
		List<OrderItemSubCatTotal> orderItemList = null;
		try {
			String strDate = Common.convertToYMD(date);
			orderItemList = orderItemSubCatTotalRepository.findQtyTotalSubCatWiseAllFr(menuId, strDate);

		} catch (Exception e) {

			System.out.println("exception in getSubCatOrderTotal  rest controller" + e.getMessage());
		}
		return orderItemList;

	}
	
	//Sachin 12-02-2020
	@RequestMapping(value = { "/getSubCatOrderTotalAllFrSpecItemId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<OrderItemSubCatTotal> getSubCatOrderTotalAllFrSpecItem(@RequestParam List<String> menuId,
			@RequestParam String date,@RequestParam List<String> itemId) {
		List<OrderItemSubCatTotal> orderItemList = null;
		try {
			String strDate = Common.convertToYMD(date);
			orderItemList = orderItemSubCatTotalRepository.findQtyTotalSubCatWiseAllFrSpecItem(menuId, strDate,itemId);

		} catch (Exception e) {

			System.out.println("exception in getSubCatOrderTotal  rest controller" + e.getMessage());
		}
		return orderItemList;

	}


	@RequestMapping(value = { "/getOrderListByOrder" }, method = RequestMethod.POST)
	@ResponseBody
	public GetOrderList getOrderListByOrder(@RequestParam List<String> frId, @RequestParam List<String> menuId,
			@RequestParam String date) {
		GetOrderList orderList = new GetOrderList();
		try {
			System.out.println("date str :" + date);

			String strDate = Common.convertToYMD(date);
			System.out.println("Converted date " + strDate);

			System.out.println("fr id in rest " + frId.toString());
			List<GetOrder> jsonOrderList = getOrderService.findOrderByOrder(frId, menuId, strDate);

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
	public GetOrderList getOrderListForAllFr(@RequestParam List<String> menuId, @RequestParam String date) {
		GetOrderList orderList = new GetOrderList();
		try {

			String strDate = Common.convertToYMD(date);
			System.out.println("Converted date " + strDate);

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

	@RequestMapping(value = { "/getOrderListForAllFrByOrder" }, method = RequestMethod.POST)
	@ResponseBody
	public GetOrderList getOrderListForAllFrByOrder(@RequestParam List<String> menuId, @RequestParam String date) {
		GetOrderList orderList = new GetOrderList();
		try {

			String strDate = Common.convertToYMD(date);
			System.out.println("Converted date " + strDate);

			List<GetOrder> jsonOrderList = getOrderService.findOrderAllFrByOrder(menuId, strDate);

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

			String strDate = Common.convertToYMD(prodDate);
			System.out.println("Converted date " + strDate);

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

	// Anmol 13-7-2019
	// ----------SP CAKE ALBUM
	// ORDER--------------------------------------------------
	//Sachin 31-01-2020 MenuId Added
	@RequestMapping(value = { "/getSpCakeAlbumOrderLists" }, method = RequestMethod.POST)
	@ResponseBody
	public SpCakeOrdersBeanList SpCakeAlbumOrderLists(@RequestParam List<Integer> frId, @RequestParam String prodDate,
			@RequestParam int spMenuId) {
		SpCakeOrdersBeanList spCakeOrderList = new SpCakeOrdersBeanList();
		try {

			String strDate = Common.convertToYMD(prodDate);
			System.out.println("Converted date " + strDate);

			List<SpCakeOrdersBean> jsonSpCakeOrderList = spCkOrdersService.findSpCakeAlbumOrder(frId, strDate,spMenuId);

			spCakeOrderList.setSpCakeOrdersBean(jsonSpCakeOrderList);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Sp Cake Album Order list displayed Successfully");
			spCakeOrderList.setInfo(info);

		} catch (Exception e) {

			System.out.println("exception in Album order list rest controller" + e.getMessage());
		}
		return spCakeOrderList;

	}

	// getAllFrSpCakeOrderList

	@RequestMapping(value = { "/getAllFrSpCakeOrderList" }, method = RequestMethod.POST)
	@ResponseBody
	public SpCakeOrdersBeanList getAllFrSpCakeOrderList(@RequestParam String prodDate) {
		SpCakeOrdersBeanList spCakeOrderList = new SpCakeOrdersBeanList();
		try {

			String strDate = Common.convertToYMD(prodDate);
			System.out.println("Converted date " + strDate);

			List<SpCakeOrdersBean> jsonSpCakeOrderList = spCkOrdersService.findSpCakeOrderAllFr(strDate);

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

	// Anmol 13/7/2019
	//Sachin 31-01-2020 MenuId Added
	@RequestMapping(value = { "/getAllFrSpCakeAlbumOrderList" }, method = RequestMethod.POST)
	@ResponseBody
	public SpCakeOrdersBeanList getAllFrSpCakeAlbumOrderList(@RequestParam String prodDate,@RequestParam int spMenuId) {
		SpCakeOrdersBeanList spCakeOrderList = new SpCakeOrdersBeanList();
		try {

			String strDate = Common.convertToYMD(prodDate);
			System.out.println("Converted date " + strDate);

			List<SpCakeOrdersBean> jsonSpCakeOrderList = spCkOrdersService.findSpCakeAlbumOrderAllFr(strDate,spMenuId);

			spCakeOrderList.setSpCakeOrdersBean(jsonSpCakeOrderList);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Sp Cake Order Album list displayed Successfully");
			spCakeOrderList.setInfo(info);

		} catch (Exception e) {

			System.out.println("exception in order list rest controller" + e.getMessage());
		}
		return spCakeOrderList;

	}

	@RequestMapping(value = { "/showEventList" }, method = RequestMethod.GET)
	@ResponseBody
	public EventList showEventList() {

		EventList eventList = new EventList();
		Info info = new Info();

		List<Event> event = eventService.findAllEvent();
		if (event != null) {
			info.setError(false);
			info.setMessage("latest news  displayed successfully");
			eventList.setInfo(info);
			eventList.setEvent(event);
		} else {
			info.setError(false);
			info.setMessage("latest news  displayed successfully");
			eventList.setInfo(info);
		}
		return eventList;
	}

	@RequestMapping(value = { "/getRegSpCkOrderList" }, method = RequestMethod.POST)
	@ResponseBody
	public RegSpCkOrderResponse getRegSpCkOrderList(@RequestParam List<Integer> frId, @RequestParam String prodDate) {

		RegSpCkOrderResponse regSpCakeOrderRes = new RegSpCkOrderResponse();

		try {

			String strDate = Common.convertToYMD(prodDate);
			System.out.println("Converted date " + strDate);

			regSpCakeOrderRes = regularSpCkOrderService.findRegularSpCkOrder(frId, strDate);

		} catch (Exception e) {
			System.out.println("controller ");

			System.out.println("exception in sp cake order list for all fr rest controller" + e.getMessage());
		}

		return regSpCakeOrderRes;

	}

	@RequestMapping(value = { "/getOrderListByItem" }, method = RequestMethod.POST)
	@ResponseBody
	public GetOrderList getOrderListByItem(@RequestParam List<String> frId, @RequestParam List<String> menuId,
			@RequestParam String date, @RequestParam List<Integer> itemId) {
		GetOrderList orderList = new GetOrderList();
		try {
			String strDate = Common.convertToYMD(date);
			List<GetOrder> jsonOrderList = getOrderService.findOrderByItemId(frId, menuId, strDate, itemId);

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

	@RequestMapping(value = { "/getOrderListForAllFrAndItem" }, method = RequestMethod.POST)
	@ResponseBody
	public GetOrderList getOrderListForAllFrAndItem(@RequestParam List<String> menuId, @RequestParam String date,
			@RequestParam List<Integer> itemId) {
		GetOrderList orderList = new GetOrderList();
		try {

			String strDate = Common.convertToYMD(date);
			System.out.println("Converted date " + strDate);

			List<GetOrder> jsonOrderList = getOrderService.findOrderAllFrAndItem(menuId, strDate, itemId);

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

	@RequestMapping(value = { "/getAllFrRegSpCakeOrders" }, method = RequestMethod.POST)
	@ResponseBody
	public RegSpCkOrderResponse getAllFrRegSpCakeOrders(@RequestParam String prodDate) {

		RegSpCkOrderResponse regSpCakeOrderRes = new RegSpCkOrderResponse();

		try {
			String strDate = Common.convertToYMD(prodDate);
			System.out.println("Converted date " + strDate);

			regSpCakeOrderRes = regularSpCkOrderService.findRegSpCakeOrderAllFr(strDate);

		} catch (Exception e) {

			System.out.println("exception in sp cake order list for all fr rest controller" + e.getMessage());
		}
		return regSpCakeOrderRes;

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

	// 18 sept sachin
	@RequestMapping(value = { "/showOrderCounts" }, method = RequestMethod.POST)
	@ResponseBody
	public OrderCountsList showOrderCounts(@RequestParam String cDate) {
		/*
		 * java.sql.Date cDate = new
		 * java.sql.Date(Calendar.getInstance().getTime().getTime());
		 * System.out.println("date " + cDate);
		 */

		List<OrderCounts> orderCountList = orderCountService.findOrderCount(cDate);

		System.out.println("order count  list" + orderCountList.toString());

		OrderCountsList ordercountList = new OrderCountsList();
		ordercountList.setOrderCount(orderCountList);

		Info info = new Info();

		info.setError(false);
		info.setMessage("order count displayed successfully");

		ordercountList.setInfo(info);

		return ordercountList;
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
	@RequestMapping(value = { "/updateConfFr" }, method = RequestMethod.POST)
	public @ResponseBody String updateFrConfig(@RequestParam int settingId, @RequestParam int settingType,
			@RequestParam String fromTime, @RequestParam String toTime, @RequestParam String day,
			@RequestParam String date, @RequestParam String itemShow) {

		ConfigureFranchisee configureFranchisee = connfigureService.findFranchiseeById(settingId);
		Info info = new Info();
		try {
			// SimpleDateFormat inSDF = new SimpleDateFormat("dd-MM-yyyy");
			// SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");

			// System.out.println("DATE" + date);
			// java.sql.Date bDate, dDate;
			// String pDate = "";

			// java.util.Date tempDate = inSDF.parse(date);

			// dDate = new java.sql.Date(tempDate.getTime());

			// System.out.println("DATE after conversion" + dDate);
			configureFranchisee.setDate(date);
			configureFranchisee.setDay(day);

			configureFranchisee.setFromTime(fromTime);
			configureFranchisee.setItemShow(itemShow);
			configureFranchisee.setSettingType(settingType);

			configureFranchisee.setToTime(toTime);

			String jsonResult = connfigureService.configureFranchisee(configureFranchisee);

			try {
				/*// -------------------------------------------------------------------------------------
				AllFrIdNameList allFrIdNamesList = allFrIdNameService.getFrIdAndName();

				for (int i = 0; i < allFrIdNamesList.getFrIdNamesList().size(); i++) {*/

					List<PostFrItemStockHeader> prevStockHeader = postFrOpStockHeaderRepository
							.findByFrIdAndIsMonthClosedAndCatId(configureFranchisee.getFrId(), 0,
									configureFranchisee.getCatId());
					// --------------------------------------------------------------------------------------------
					List<PostFrItemStockDetail> postFrItemStockDetailList = new ArrayList<PostFrItemStockDetail>();
					List<Integer> ids = Stream.of(configureFranchisee.getItemShow().split(",")).map(Integer::parseInt)
							.collect(Collectors.toList());
					System.err.println("16 ids --" + ids.toString());
					List<Item> itemsList = itemService.findAllItemsByItemId(ids);
					System.err.println("17 itemsList --" + itemsList.toString());
					for (int k = 0; k < itemsList.size(); k++) {

						PostFrItemStockDetail prevFrItemStockDetail = postFrOpStockDetailRepository
								.findByItemIdAndOpeningStockHeaderId(itemsList.get(k).getId(),
										prevStockHeader.get(0).getOpeningStockHeaderId());
						System.err.println("18 prevFrItemStockDetail --" + prevFrItemStockDetail);
						if (prevFrItemStockDetail == null) {
							PostFrItemStockDetail postFrItemStockDetail = new PostFrItemStockDetail();
							postFrItemStockDetail
									.setOpeningStockHeaderId(prevStockHeader.get(0).getOpeningStockHeaderId());// first
																												// stock
																												// header
																												// (month
																												// closed
																												// 0
																												// status))
							postFrItemStockDetail.setOpeningStockDetailId(0);
							postFrItemStockDetail.setRegOpeningStock(0);
							postFrItemStockDetail.setItemId(itemsList.get(k).getId());
							postFrItemStockDetail.setRemark("");
							postFrItemStockDetailList.add(postFrItemStockDetail);
							System.err.println("19 postFrItemStockDetail --" + postFrItemStockDetail.toString());
						}
					}
					postFrOpStockDetailRepository.save(postFrItemStockDetailList);
					System.err.println("20 postFrItemStockDetailList --" + postFrItemStockDetailList.toString());
					// ---------------------------------------------------------------------------------------
				//}
			} catch (Exception e) {
				// TODO: handle exception
			}
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

	// Ganesh 16/10
	// Change 3012-2017
	// List of Franchisee - not place order
	@RequestMapping(value = "/getNonOrderFr", method = RequestMethod.POST)
	public @ResponseBody AllFrIdNameList getNonOrderFr(@RequestParam("orderDate") String orderDate,
			@RequestParam("menuId") int menuId) {

		AllFrIdNameList allFrIdNamesList = allFrIdNameService.findNonOrderFranchisee(orderDate, menuId);

		return allFrIdNamesList;

	}

	// Ganesh 16/10

	@RequestMapping(value = { "/getOrderListForDumpOrder" }, method = RequestMethod.POST)
	public @ResponseBody GetDumpOrderList getOrderListForDumpOrder(@RequestParam List<String> frId,
			@RequestParam String menuId, @RequestParam String date) {
		String date1 = Common.convertToYMD(date);

		GetDumpOrderList orderDumpList = new GetDumpOrderList();
		List<GetDumpOrder> getDumpmOrder = getDumpOrderService.findFrOrder(frId, menuId, date1);
		System.out.println("List  " + getDumpmOrder.toString());
		// System.out.println("Count "+getDumpmOrder.size());
		orderDumpList.setGetDumpOrder(getDumpmOrder);
		Info info = new Info();
		info.setError(false);
		info.setMessage("configure Fr List displayed successfully");
		orderDumpList.setInfo(info);

		return orderDumpList;
	}

	// Ganesh 24-10-2017

	@RequestMapping(value = "/updateOrderQty", method = RequestMethod.POST)
	public @ResponseBody String updateOrderQty(@RequestParam int orderId, @RequestParam int orderQty) {
		System.out.println("inside rest");

		updateorderService.updateOrderQty(orderId, orderQty);

		return "resulted ";
	}

	@RequestMapping(value = "/DeleteOrder", method = RequestMethod.POST)
	public @ResponseBody int DeleteOrder(@RequestParam int orderId) {
		System.out.println("inside rest");

		int isDelete = updateorderService.deleteOrder(orderId);

		return isDelete;
	}
	
	@Autowired ChangeOrderRecordRepo changeOrdeRecRepo;
	@Autowired OrderRepository ordRepo;
	@RequestMapping(value = "/saveChangeOrderRecord", method = RequestMethod.POST)
	public @ResponseBody ChangeOrderRecord saveChangeOrderRecord(@RequestBody ChangeOrderRecord reqBody) {
		System.out.println("inside REST  saveChangeOrderRecord");
		ChangeOrderRecord res=new ChangeOrderRecord();
		try{
			Orders ord=ordRepo.getOneOrder(reqBody.getOrderId());
			System.err.println("Orders "+ord);
			reqBody.setItemId(Integer.parseInt(ord.getItemId()));
			reqBody.setFrId(ord.getFrId());
			res=changeOrdeRecRepo.save(reqBody);
			
		}catch (Exception e) {
			e.printStackTrace();
			res=new ChangeOrderRecord();
		}

		return res;
	}
	
	
	
	@RequestMapping(value = "/getChangedOrdersRecordList", method = RequestMethod.POST)
	public @ResponseBody List<ChangeOrderRecord> getChangedOrdersRecordList(@RequestParam List<String> frIdList,
			@RequestParam String fromDate, @RequestParam String toDate) {
		System.out.println("inside REST  getChangedOrdersRecordList");
		List<ChangeOrderRecord> resList=new ArrayList<ChangeOrderRecord>();
		try{
			
			if(frIdList.contains("-1")) {
			resList=changeOrdeRecRepo.getChangeOrderRecListAllFr(fromDate, toDate);
			}else {
				resList=changeOrdeRecRepo.getChangeOrderRecListSpecFr(frIdList, fromDate, toDate);
			}
			
		}catch (Exception e) {
			resList=new ArrayList<ChangeOrderRecord>();
			e.printStackTrace();
		}

		return resList;
	}

	@RequestMapping(value = "/getChangeOrderRecordList", method = RequestMethod.POST)
	public @ResponseBody List<ChangeOrderRecord> getChangeOrderRecordList() {
		System.out.println("inside REST  saveChangeOrderRecord");
		List<ChangeOrderRecord> res=new ArrayList<ChangeOrderRecord>();
		try{
			res=changeOrdeRecRepo.findAll();
			
		}catch (Exception e) {
			res=new ArrayList<ChangeOrderRecord>();
		}

		return res;
	}
	// ganesh 25-10-2017

	// Ganesh 26-10-2017

	@RequestMapping(value = "/getFrGvnDetails", method = RequestMethod.POST)
	public @ResponseBody GetGrnGvnDetailsList getFrGvnDetails(@RequestParam("grnGvnHeaderId") int grnGvnHeaderId) {
		System.out.println("inside rest /getFrGvnDetails");

		GetGrnGvnDetailsList gvnDetailList = getGrnGvnDetailService.getFrGvnDetails(grnGvnHeaderId);

		return gvnDetailList;

	}

	@RequestMapping(value = "/getFrGrnDetails", method = RequestMethod.POST)
	public @ResponseBody GetGrnGvnDetailsList getFrGrnDetail(@RequestParam("grnGvnHeaderId") int grnGvnHeaderId) {
		System.out.println("inside rest");

		GetGrnGvnDetailsList grnDetailList = getGrnGvnDetailService.getFrGrnDetails(grnGvnHeaderId);

		System.out.println("List GR*N****  " + grnDetailList.toString());
		return grnDetailList;

	}

	// 28-10-2017 ganesh

	@RequestMapping(value = "/getSellBillHeader", method = RequestMethod.POST)
	public @ResponseBody List<GetSellBillHeader> getSellBillHeader(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {
		System.out.println("inside rest");

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);

		List<GetSellBillHeader> getSellBillHeaderList = getSellBillHeaderService.getSellBillHeader(fromDate, toDate,
				frId);

		System.out.println("List Sell Bill Header****  " + getSellBillHeaderList.toString());
		return getSellBillHeaderList;

	}

	@RequestMapping(value = "/getSellBillDetail", method = RequestMethod.POST)
	public @ResponseBody List<GetSellBillDetail> getSellBillDetail(@RequestParam("sellBillNo") int sellBillNo) {
		System.out.println("inside rest");

		List<GetSellBillDetail> getSellBillDetailList = getSellBillDetailService.getSellBillDetail(sellBillNo);

		System.out.println("List Sell Bill Detail****  " + getSellBillDetailList.toString());
		return getSellBillDetailList;

	}

	// 31-10-2017

	@RequestMapping(value = { "/placePushDumpOrder" }, method = RequestMethod.POST)

	public @ResponseBody List<Orders> placePushDumpItemOrder(@RequestBody List<Orders> orderJson)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		List<Orders> participantJsonList;
		List<Orders> jsonResult;

		System.out.println("Inside Place Order " + orderJson.toString());

		jsonResult = orderService.placePustDumpOrder(orderJson);

		return jsonResult;

	}

	// Get Menus By Cat Id
	@RequestMapping(value = { "/getMenuByCat" }, method = RequestMethod.POST)
	public @ResponseBody AllMenuJsonResponse findMenuByCat(@RequestParam("catId") int catId) {
		AllMenuJsonResponse menus = menuService.findMenuByCat(catId);
		return menus;
	}

	@RequestMapping(value = { "/updateBillStatus" }, method = RequestMethod.POST)

	public @ResponseBody Info updateBillStatus(@RequestBody UpdateBillStatus updateBillStatus)
	// throws ParseException, JsonParseException, JsonMappingException, IOException
	{

		System.out.println("Data  " + updateBillStatus.toString());
		String date = updateBillStatus.getBillDate();

		updateBillStatus.setBillDate(Common.convertToYMD(date));
		UpdateBillStatus updateBillStatusRes = getBillHeaderService.updateBillStatus(updateBillStatus);

		Info info = new Info();

		if (updateBillStatusRes.getBillDate() != null) {

			info.setError(false);
			info.setMessage("Update   Successfully");

		}

		else {

			info.setError(true);
			info.setMessage("update Unsuccessfull : RestApi");

		}

		return info;

	}

	@RequestMapping(value = { "/frItemStockPost" }, method = RequestMethod.POST)
	public @ResponseBody Info info(@RequestBody List<FrItemStockConfigurePost> frItemStockConfigurePosts)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		List<FrItemStockConfigurePost> jsonResult;
		Info info = new Info();

		try {

			jsonResult = frItemStockConfigurePostService.saveFrItemStockConf(frItemStockConfigurePosts);

			if (jsonResult.size() > 0) {

				info.setError(false);
				info.setMessage("fr Item stock Inserted Successfully");

			}

			else {
				info.setError(true);
				info.setMessage("Error in frItem Stock Insertion  : RestApi");
			}
		} catch (Exception e) {

			System.out.println("Exce in frItem Stock Insertion  : RestApi" + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getReorderByType" }, method = RequestMethod.POST)
	public @ResponseBody GetReorderByStockTypeList getReorderByType(@RequestParam("ItemId") List<String> ItemId,
			@RequestParam("StockType") int StockType)
			throws ParseException, JsonParseException, JsonMappingException, IOException {
		GetReorderByStockTypeList getReorderByStockTypeList = new GetReorderByStockTypeList();
		List<GetReorderByStockType> getReorderByType = new ArrayList<GetReorderByStockType>();

		try {

			getReorderByType = getReorderByStockTypeRepository.GetRegSpCakeOrderQty(ItemId, StockType);
			getReorderByStockTypeList.setGetReorderByStockTypeList(getReorderByType);
			System.out.println("getReorderByType  " + getReorderByType.toString());

		} catch (Exception e) {

			System.out.println("Exce in frItem Stock Insertion  : RestApi" + e.getMessage());
			e.printStackTrace();
		}
		return getReorderByStockTypeList;

	}

	@RequestMapping(value = { "/insertNewUser" }, method = RequestMethod.POST)
	public @ResponseBody Info insertNewUser(@RequestBody User user) {

		Info info = new Info();
		info = userService.insertUser(user);
		return info;
	}

	@RequestMapping(value = { "/getAllDept" }, method = RequestMethod.GET)
	public @ResponseBody DepartmentList getAllDept() {
		Info info = new Info();
		DepartmentList departmentList = new DepartmentList();
		List<Department> department = userService.getAllDept();
		if (department != null && !department.isEmpty()) {
			departmentList.setDepartmentList(department);
			info.setError(false);
			info.setMessage("success");
		} else {
			info.setError(true);
			info.setMessage("failed");
		}
		departmentList.setInfo(info);
		return departmentList;
	}

	@RequestMapping(value = { "/getAllUserType" }, method = RequestMethod.GET)
	public @ResponseBody GetUserTypeList getAllUserType() {
		Info info = new Info();
		GetUserTypeList getUserTypeList = new GetUserTypeList();
		List<GetUserType> getUserType = userService.getAllUserType();
		if (getUserType != null && !getUserType.isEmpty()) {
			getUserTypeList.setGetUserTypeList(getUserType);
			info.setError(false);
			info.setMessage("success");
		} else {
			info.setError(true);
			info.setMessage("failed");
		}
		getUserTypeList.setInfo(info);
		return getUserTypeList;
	}

	@RequestMapping(value = { "/getSpCakeOrderBySpOrderNo" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetSpCakeOrders> getSpCakeOrderBySpOrderNo(@RequestParam List<String> spOrderNo) {
		System.out.println("Order Id " + spOrderNo.toString());
		List<GetSpCakeOrders> spCakeOrder = spCkOrdersService.getSpCakeOrder(spOrderNo);

		System.out.println("Res  :" + spCakeOrder.toString());
		return spCakeOrder;
	}

	// -------------ANMOL 13-7-2019---------------------
	@RequestMapping(value = { "/getSpCakeAlbumOrderBySpOrderNo" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetSpCakeOrders> getSpCakeAlbumOrderBySpOrderNo(@RequestParam List<String> spOrderNo) {
		System.out.println("Order Id " + spOrderNo.toString());
		List<GetSpCakeOrders> spCakeOrder = spCkOrdersService.getSpCakeAlbumOrder(spOrderNo);

		System.out.println("Res  :" + spCakeOrder.toString());
		return spCakeOrder;
	}

	@RequestMapping(value = { "/getSpCKOrderBySpOrderNo" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetSpCkOrder> getSpCKOrderBySpOrderNo(@RequestParam("spOrderNo") List<String> spOrderNo) {

		List<GetSpCkOrder> spCakeOrder = spCkOrdersService.getSpCkOrder(spOrderNo);

		return spCakeOrder;
	}

	// ---------ANMOL 13-7-2019----------------
	@RequestMapping(value = { "/getSpCKAlbumOrderBySpOrderNo" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetSpCkOrder> getSpCKAlbumOrderBySpOrderNo(@RequestParam("spOrderNo") List<String> spOrderNo) {

		List<GetSpCkOrder> spCakeOrder = spCkOrdersService.getSpCkAlbumOrder(spOrderNo);

		return spCakeOrder;
	}

	@RequestMapping(value = { "/getRegSpCakeOrderBySpOrderNo" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetRegSpCakeOrders> getRegSpCakeOrderBySpOrderNo(@RequestParam List<String> orderNo) {
		System.out.println("Order Id " + orderNo.toString());
		List<GetRegSpCakeOrders> regSpCakeOrder = regularSpCkOrderService.getRegSpCakeOrder(orderNo);

		System.out.println("Res  :" + regSpCakeOrder.toString());
		return regSpCakeOrder;
	}

	@RequestMapping(value = { "/updatePhoto4ByAlbum" }, method = RequestMethod.POST)
	public @ResponseBody Info updatePhoto4ByAlbum(@RequestParam("tSpCakeOrderNo") int tSpCakeOrderNo,
			@RequestParam("photo4") String photo4) {

		System.out.println("tSpCakeOrderNotSpCakeOrderNo" + tSpCakeOrderNo);
		System.out.println("photo4photo4" + photo4);

		Info info = new Info();

		try {

			int update = tSpCakeSupRepo.updatePhoto4(tSpCakeOrderNo, photo4);

			if (update == 1) {
				info.setError(false);
				info.setMessage("successfully update");
			} else {
				info.setError(true);
				info.setMessage(" failed to update");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" failed to update");

		}
		return info;

	}

	// 21/6/2019

	@RequestMapping(value = "/getConfigListByFrAndMenu", method = RequestMethod.POST)
	public @ResponseBody List<ConfigureFranchisee> getConfigListByFrAndMenu(@RequestParam("frIds") List<Integer> frIds,
			@RequestParam("menuIds") List<Integer> menuIds) {
		System.err.println("in ws---------- FR " + frIds);
		System.err.println("in ws---------- MENU " + menuIds);

		List<ConfigureFranchisee> resultList = new ArrayList();
		resultList = connfigureService.getDataByFrAndMenu(frIds, menuIds);
		System.err.println("LIST -------------- " + resultList);
		return resultList;

	}

	@RequestMapping(value = "/updateFrConfItemShow")
	public @ResponseBody Info updateFrConfItemShow(@RequestParam("items") String items,
			@RequestParam("settingId") int settingId) {
		Info info = new Info();
		int result = 0;
		try {
			result = connfigureService.updateFrConfItems(items, settingId);

			if (result > 0) {
				info.setError(false);
				info.setMessage("update Conf fr Successs");
			} else {
				info.setError(true);
				info.setMessage("update Conf fr Failed");
			}
		} catch (Exception e) {
			System.err.println("Exc in rest /updateFrConfItems" + e.getMessage());
			e.printStackTrace();
		}
		return info;

	}

	@RequestMapping(value = "/getSubCatListByCatIdInForDisp", method = RequestMethod.POST)
	public @ResponseBody List<SubCategory> getSubCatListByCatIdInForDisp(@RequestParam("catId") List<String> catId,
			@RequestParam("isAllCatSelected") boolean isAllCatSelected) {
		List<SubCategory> subCategoryList = null;
		if (isAllCatSelected == false) {
			subCategoryList = subCategoryService.getSubCatListByCatIdInForDisp(catId);
		} else {
			SubCatergoryList subCategoryListRes = subCategoryService.findAllSubCategories();
			subCategoryList = subCategoryListRes.getSubCategory();
		}
		return subCategoryList;

	}

	@RequestMapping(value = "/getSubCateList", method = RequestMethod.GET)
	public @ResponseBody List<SubCategory> getSubCateList() {

		List<SubCategory> subCategoryList = subCategoryService.getAllSubCategory();
		return subCategoryList;

	}
	
	@RequestMapping(value = "/getSubCateListByCatId", method = RequestMethod.POST)
	public @ResponseBody List<SubCategory> getSubCateListByCatId(@RequestParam("catId") int catId) {

		List<SubCategory> subCategoryList = subCategoryService.findSubCatByCatId(catId);
		return subCategoryList;

	}
	
	@RequestMapping(value = "/getItemBySubCatId", method = RequestMethod.POST)
	public @ResponseBody GetItemByCatIdList getItemByCategoryIdAndSubCatId(@RequestParam("subCatId") int subCatId) {

		GetItemByCatIdList getItemByCatIdList = getItemByCatIdService.getItemBySubCatId(subCatId);

		return getItemByCatIdList;

	}
	
	@Autowired SpCakeEnqAlbmFrnchseRepo spAlbmFrRepo;
	
	/*@RequestMapping(value = "/getSpCakeEnaAlbmFrDetail", method = RequestMethod.GET)
	public @ResponseBody List<SpCakeEnqAlbmFrnchse> getSpCakeEnaAlbmFrDetail() {

		List<SpCakeEnqAlbmFrnchse> list = spAlbmFrRepo.getSpcakeEnqAlbmFrData();
		return list;

	}*/
	
	@RequestMapping(value = "/getSpCakeEnaAlbmFrDetail", method = RequestMethod.GET)
	public @ResponseBody List<SpCakeEnqAlbmFrnchse> getSpCakeEnaAlbmFrDetailBYDate(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SpCakeEnqAlbmFrnchse> list = spAlbmFrRepo.getSpcakeEnqAlbmFrDataByDate(fromDate,toDate);
		return list;

	}
	
	/***************************************************************************************************/
	@Autowired
	SalesReturnValueDaoRepository salesReturnValueDaoRepository;
	
	//Mahendra
	@RequestMapping(value = { "/getSalesReturnValueReport" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReturnValueDaoList> getSalesReturnValueReport(@RequestParam("fromYear") int fromYear,
			@RequestParam("toYear") int toYear) throws ParseException {

		List<SalesReturnValueDaoList> repList = new ArrayList<>();
		List<String> months = new ArrayList<String>();
		months.add(fromYear + "-04");
		months.add(fromYear + "-05");
		months.add(fromYear + "-06");
		months.add(fromYear + "-07");
		months.add(fromYear + "-08");
		months.add(fromYear + "-09");
		months.add(fromYear + "-10");
		months.add(fromYear + "-11");
		months.add(fromYear + "-12");
		months.add(toYear + "-01");
		months.add(toYear + "-02");
		months.add(toYear + "-03");

		for (int i = 0; i < months.size(); i++) {
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM");
			// output format: yyyy-MM-dd
			SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
			String month = formatter.format(parser.parse(months.get(i)));
			SalesReturnValueDaoList salesReturnValueReportList = new SalesReturnValueDaoList();
			salesReturnValueReportList.setMonth(month);
			List<SalesReturnValueDao> salesReturnValueDao = salesReturnValueDaoRepository
					.getSalesReturnValueReport(months.get(i));
			salesReturnValueReportList.setSalesReturnQtyValueList(salesReturnValueDao);
			repList.add(salesReturnValueReportList);
		}
		return repList;

	}

	@Autowired
	SalesReportRepo getSalesReportRepo;
	@RequestMapping(value = { "/getSalesReportV2" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReport> getSalesReportV2(@RequestParam("frIdList") List<String> frIdList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReport> saleList = new ArrayList<>();

		if (frIdList.contains("-1")) {

			saleList = getSalesReportRepo.getSalesReportAllFr(fromDate, toDate);

		} else {

			saleList = getSalesReportRepo.getSalesReportSpecFr(fromDate, toDate, frIdList);
		}

		return saleList;
	}
	
	
	
	
	
	@RequestMapping(value = { "/getItemwiseStockLimitByCat" }, method = RequestMethod.POST)
	public @ResponseBody List<ProdItemStock> getItemwiseStockLimitByCat(@RequestParam("catId") int catId) {

		List<ProdItemStock> result = new ArrayList<>();

		result = prodItemStockRepo.getItemwiseStocklimit(catId);

		return result;
	}
	
	@RequestMapping(value = { "/getItemwiseStockTotalByCat" }, method = RequestMethod.POST)
	public @ResponseBody List<ProdItemStockTotal> getItemwiseStockTotalByCat(@RequestParam("catId") int catId) {

		List<ProdItemStockTotal> result = new ArrayList<>();

		result = prodItemStockTotalRepo.getItemwiseStockTotal(catId);

		return result;
	}
	//Get All By Fr_Opening_Date
		@RequestMapping(value = { "/getAllFranchiseeByOpnDate" }, method = RequestMethod.GET)
		public @ResponseBody List<Franchisee> getAllFranchiseeByOpnDate() {
			List<Franchisee> franchisee = new ArrayList<Franchisee>();
			franchisee = franchiseeService.findAllFranchiseeOrderByFrOpeningDate();
			System.err.println("Fr Date List----------"+franchisee);
			ErrorMessage errorMessage = new ErrorMessage();
			if (franchisee != null) {
				errorMessage.setError(false);
				errorMessage.setMessage("Franchisee displayed Successfully");

			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Franchisee Not displayed");
			}

			return franchisee;
		}
		
		@Autowired
		ItemCreamTypeRepo itemCremTypeRepo;
		
		@RequestMapping(value = { "/saveItemCreamType" }, method = RequestMethod.POST)
		public @ResponseBody ItemCreamType saveItemCreamType(@RequestBody ItemCreamType itemCream ) {
			ItemCreamType item = new ItemCreamType();
					try {
						item=itemCremTypeRepo.save(itemCream);
					}catch (Exception e) {
						e.printStackTrace();
					}
			
			return item;
			
		}
		
		@RequestMapping(value = { "/getItmeCreamTypeList" }, method = RequestMethod.GET)
		public List<ItemCreamType> getItmeCreamTypeList(){
			List<ItemCreamType> list = new ArrayList<ItemCreamType>();
			try {
				list=itemCremTypeRepo.findBydelStatus(0);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
			
		}
		
		@RequestMapping(value = { "/getItmeCreamTypeById" }, method = RequestMethod.POST)
		public ItemCreamType getItmeCreamTypeById(@RequestParam int itemCreamId){
			ItemCreamType item = new ItemCreamType();
			try {
				item=itemCremTypeRepo.findByItemCreamIdAndDelStatus(itemCreamId, 0);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return item;
			
		}
		
		@RequestMapping(value = { "/deleteItemCreamTypeById" }, method = RequestMethod.POST)
		public @ResponseBody Info updatePhoto4ByAlbum(@RequestParam("itemCreamId") int itemCreamId) {
			Info info = new Info();

			try {

				int res = itemCremTypeRepo.deleteItemCreamType(itemCreamId);

				if (res>0) {
					info.setError(false);
					info.setMessage("successfully Deleted");
				} else {
					info.setError(true);
					info.setMessage(" failed to delete");
				}

			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMessage(" failed to delete");

			}
			return info;

		}
		
		/***************************************************************************************/
		@RequestMapping(value = { "/getUserInfoByEmail" }, method = RequestMethod.POST)
		public @ResponseBody User getUserInfoByEmail(@RequestParam String email) {

			User res = new User();
			res = userService.checkUniqueEmail(email);
			return res;
		}
		
		@RequestMapping(value = { "/getUserInfoByContact" }, method = RequestMethod.POST)
		public @ResponseBody User getUserInfoByContact(@RequestParam String contact) {

			User res = new User();
			res = userService.checkUniqueContact(contact);
			return res;
		}
		
		
		@RequestMapping(value = { "/getUserInfoByUser" }, method = RequestMethod.POST)
		public @ResponseBody User getUserInfoByUser(@RequestParam String uname) {

			User res = new User();
			res = userService.checkUniqueUser(uname);
			return res;
		}
		
		static String senderEmail ="atsinfosoft@gmail.com";
		static String senderPassword ="atsinfosoft@123";
		static String mailsubject = "";
		String otp1 = null;
		@RequestMapping(value = { "/getUserInfoByUsername" }, method = RequestMethod.POST)
		public @ResponseBody User getUserInfoByUsername(@RequestParam String username) {

			OTPVerification.setConNumber(null);
			OTPVerification.setEmailId(null);
			OTPVerification.setOtp(null);
			OTPVerification.setPass(null);
			Info info = new Info();
			
			User res = new User();
			res = userService.getUserData(username);
			System.err.println("Resss-------"+res);
			
			if(res!= null) {
				OTPVerification.setUserId(res.getId());
				
				String emailId = res.getEmail();
				String conNumber = res.getContact();
				
				char[] otp = Common.OTP(6);
				otp1 = String.valueOf(otp);
				System.err.println("User otp is" + otp1);
				
				Info inf = EmailUtility.sendOtp(otp1, conNumber, "MONGII OTP Verification ");
				
				 mailsubject = " OTP  Verification ";
				 String text = "\n OTP for change your Password: ";
				Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword,emailId, mailsubject,
						text, otp1);

			
				OTPVerification.setConNumber(conNumber);
				OTPVerification.setEmailId(emailId);
				OTPVerification.setOtp(otp1);
				OTPVerification.setPass(res.getPassword());
			}else {
				System.err.println("In Else ");

				info.setError(true);
				info.setMessage("not Matched");
				System.err.println(" not Matched ");
			}
			return res;
		}
		
		@RequestMapping(value = { "/VerifyOTP" }, method = RequestMethod.POST)
		public @ResponseBody User VerifyOTP(@RequestParam String otp) {
			Info info = new Info();
			
			Object object=new Object();
			HashMap<Integer, User>  hashMap=new HashMap<>();
			
			User user=new User();
			
			try {
			//	System.err.println("OTP Found------------------"+OTPVerification.getOtp()+" "+OTPVerification.getUserId());
				if (otp.equals(OTPVerification.getOtp()) == true) {
					info.setError(false);
					info.setMessage("success");

					String mobile = OTPVerification.getConNumber();
					String email = OTPVerification.getEmailId();
					String pass = Common.getAlphaNumericString(7);
					// System.out.println("pass");
					//int res = staffrepo.chagePass(pass, OTPVerification.getUserId());
					
					user=userService.findByIdAndDelStatus(OTPVerification.getUserId(),0);
					hashMap.put(1, user);

				} else {
					info.setError(true);
					info.setMessage("failed");
				}
				
			} catch (Exception e) {

				System.err.println("Exce in getAllInstitutes Institute " + e.getMessage());
				e.printStackTrace();
				info.setError(true);
				info.setMessage("excep");
			}

			return user;

		}
		
		@RequestMapping(value = { "/updateToNewPassword" }, method = RequestMethod.POST)
		public @ResponseBody Info updateToNewPassword(@RequestParam int userId, @RequestParam String newPass) {

			Info res = new Info();
			
			int a = updateUserRepo.changePassword(userId, newPass);
			if (a > 0) {

				mailsubject = " New Credentials ";
				String text = "\n Your new username and password are : \n";

				User usr = new User();
				usr = userService.findByUserId(userId);
				if (usr != null) {
					String emailId = usr.getEmail();
					String password = "\n Username : " + usr.getUsername() + " \n Password : " + usr.getPassword();

					Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword, emailId, mailsubject, text, password);
				}
				res.setError(false);
				res.setMessage("success");
			}else {
				res.setError(true);
				res.setMessage("fail");
			}
		
			return res;
		}
		
		/******************************************************************************/
		//OPS
	@RequestMapping(value = { "/getFranchiseeByFrCode" }, method = RequestMethod.POST)
		@ResponseBody
		public Franchisee getFranchiseeByFrCode(@RequestParam("frCode") String frCode) {
		
			OTPVerification.setConNumber(null);
			OTPVerification.setEmailId(null);
			OTPVerification.setOtp(null);
			OTPVerification.setPass(null);
			Info info = new Info();
			
			Franchisee franchisee = franchiseeService.getFranchiseeByFrCode(frCode);
			System.out.println("JsonString" + franchisee);
			if(franchisee!= null) {
				OTPVerification.setUserId(franchisee.getFrId());
				
				String emailId = franchisee.getFrEmail();
				String conNumber = franchisee.getFrMob();
				
				char[] otp = Common.OTP(6);
				otp1 = String.valueOf(otp);
				System.err.println("User otp is" + otp1);
				
				Info inf = EmailUtility.sendOtp(otp1, conNumber, "MONGII OTP Verification ");
				
				 mailsubject = " OTP  Verification ";
				 String text = "\n OTP for change your Password: ";
				
				Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword,emailId, mailsubject,
						text, otp1);

			
				OTPVerification.setConNumber(conNumber);
				OTPVerification.setEmailId(emailId);
				OTPVerification.setOtp(otp1);
				OTPVerification.setPass(franchisee.getFrPassword());
			}else {
				System.err.println("In Else ");

				info.setError(true);
				info.setMessage("not Matched");
				System.err.println(" not Matched ");
			}

			return franchisee;

		}
		
		@RequestMapping(value = { "/verifyOPSOTP" }, method = RequestMethod.POST)
		public @ResponseBody Franchisee VerifyOPSOTP(@RequestParam String otp) {
			Info info = new Info();
			
			Object object=new Object();
			HashMap<Integer, Franchisee>  hashMap=new HashMap<>();
			
			Franchisee franchisee=new Franchisee();
			
			try {
				//System.err.println("OTP Found------------------"+OTPVerification.getOtp()+" "+OTPVerification.getUserId()+" "+otp);
				if (otp.equals(OTPVerification.getOtp()) == true) {
					info.setError(false);
					info.setMessage("success");

					String mobile = OTPVerification.getConNumber();
					String email = OTPVerification.getEmailId();
					String pass = Common.getAlphaNumericString(7);
					// System.out.println("pass");
					//int res = staffrepo.chagePass(pass, OTPVerification.getUserId());
					
					franchisee=franchiseeService.findByFrId(OTPVerification.getUserId());
					hashMap.put(1, franchisee);

				} else {
					info.setError(true);
					info.setMessage("failed");
				}
				
			} catch (Exception e) {

				System.err.println("Exce in VerifyOPSOTP Institute " + e.getMessage());
				e.printStackTrace();
				info.setError(true);
				info.setMessage("excep");
			}
			return franchisee;
		}
		
		@RequestMapping(value = { "/updateToNewOPSPassword" }, method = RequestMethod.POST)
		public @ResponseBody Info updateToNewOPSPassword(@RequestParam int frId, @RequestParam String newPass) {

			Info res = new Info();
			
			int a = franchiseeRepository.changeOPSPassword(frId, newPass);
			if(a>0) {
				int b = franchiseSupRepository.updateOPSFrPwd(frId, newPass);
				if(b>0) {
					
				Franchisee franchisee=franchiseeService.findByFrId(OTPVerification.getUserId());
					if(franchisee!=null) {
						mailsubject = " New Credentials ";
						String text = "\n Your new username and password are : \n";					
						
						String password = "\n Username : " + franchisee.getFrCode() + " \n Password : " + franchisee.getFrPassword();
						String emailId = franchisee.getFrEmail();

						Info emailRes = EmailUtility.sendEmail(senderEmail, senderPassword, emailId, mailsubject, text, password);
					}
				res.setError(false);
				res.setMessage("success");
				}
				else {
					res.setError(true);
					res.setMessage("fail");
				}
			}else {
				res.setError(true);
				res.setMessage("fail");
			}
		
			return res;
		}
		
		/*****************************************************************************/
		//mahendra //31-01-2020
		@RequestMapping(value = { "/getAllFranchiseeByStatus" }, method = RequestMethod.POST)
		public @ResponseBody  List<Franchisee>  getAllFranchiseeByStatus(@RequestParam int status) {
			List<Franchisee> franchisee = new ArrayList<Franchisee>();
			if(status<0) {
				System.err.println("Status Found-----------"+status);
				franchisee = franchiseeService.getAllFranchisee();	
				
			}
			else{
				System.err.println("Status Found-----------"+status);
				franchisee = franchiseeService.getAllFranchiseeByStatus(status);	
			}
		/*
		 * FranchiseeList franchiseeList = new FranchiseeList();
		 * franchiseeList.setFranchiseeList(franchisee); ErrorMessage errorMessage = new
		 * ErrorMessage(); if (franchisee != null) { errorMessage.setError(false);
		 * errorMessage.setMessage("Franchisee displayed Successfully");
		 * franchiseeList.setErrorMessage(errorMessage);
		 * 
		 * } else { errorMessage.setError(true);
		 * errorMessage.setMessage("Franchisee Not displayed");
		 * franchiseeList.setErrorMessage(errorMessage); }
		 */

			return franchisee;
		
		}
		
		@RequestMapping(value = { "/showFrRouteList" }, method = RequestMethod.GET)
		@ResponseBody
		public List<Route> showFrRouteList() {

			List<Route> jsonRouteList = routeService.showAllRoute();
			System.out.println("jsonRouteList" + jsonRouteList.toString());
			RouteList routeList = new RouteList();
			routeList.setRoute(jsonRouteList);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Route displayed Successfully ");
			routeList.setInfo(info);

			return jsonRouteList;
		}
}
