package com.ats.webapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

//import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.AllMenus;
import com.ats.webapi.model.CategoryList;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.MCategory;
import com.ats.webapi.model.prodapp.ProdAppUser;
import com.ats.webapi.model.prodapp.RoutewiseLastCakeEndTime;
import com.ats.webapi.model.prodapp.RoutewiseOrdCountBean;
import com.ats.webapi.model.prodapp.StockTransfDataByTypeGrpBySubC;
import com.ats.webapi.model.prodapp.StockTransfDetail;
import com.ats.webapi.model.prodapp.StockTransfHeader;
import com.ats.webapi.model.prodapp.StockTransfType;
import com.ats.webapi.model.prodapp.DashRegSpCakeCount;
import com.ats.webapi.model.prodapp.DashSpCakeCount;
import com.ats.webapi.model.prodapp.FrWiseSpCakeOrd;
import com.ats.webapi.model.prodapp.FrwiseRateChangedItemReport;
import com.ats.webapi.model.prodapp.FrwiseStockTransfData;
import com.ats.webapi.model.prodapp.GateSaleStockDetail;
import com.ats.webapi.model.prodapp.GateSaleStockEntry;
import com.ats.webapi.model.prodapp.GateSaleStockHeader;
import com.ats.webapi.model.prodapp.GetDataForGateSaleDayEnd;
import com.ats.webapi.model.prodapp.GetRegSpCakeOrderForProdApp;
import com.ats.webapi.model.prodapp.GetRoutewiseOrderData;
import com.ats.webapi.model.prodapp.GetSpCakeOrderForProdApp;
import com.ats.webapi.model.prodapp.MisrtrywiseFrItemReport;
import com.ats.webapi.model.prodapp.MistrywiseReport;
import com.ats.webapi.model.prodapp.TRegSpCakeSup;
import com.ats.webapi.model.prodapp.TSpCakeSup;
import com.ats.webapi.model.prodapp.temp.RegSpOrd;
import com.ats.webapi.model.prodapp.temp.SpOrder;
import com.ats.webapi.model.spprod.GetEmployeeList;
import com.ats.webapi.repository.prodapp.DashRegSpCakeCountRepo;
import com.ats.webapi.repository.prodapp.DashSpCakeCountRepo;
import com.ats.webapi.repository.prodapp.FrwiseStockTransfDataRepo;
import com.ats.webapi.repository.prodapp.GateSaleStockDetailRepo;
import com.ats.webapi.repository.prodapp.GateSaleStockHeaderRepo;
import com.ats.webapi.repository.prodapp.GetDataForGateSaleDayEndRepo;
import com.ats.webapi.repository.prodapp.GetRegSpCakeOrderForProdAppRepo;
import com.ats.webapi.repository.prodapp.MenusRepo;
import com.ats.webapi.repository.prodapp.ProdAppUserRepo;
import com.ats.webapi.repository.prodapp.RoutewiseOrdCountBeanRepo;
import com.ats.webapi.repository.prodapp.SpCakeForProdAppRepo;
import com.ats.webapi.repository.prodapp.StockTransfDataByTypeGrpBySubcat;
import com.ats.webapi.repository.prodapp.StockTransfDetailRepo;
import com.ats.webapi.repository.prodapp.StockTransfHeaderRepo;
import com.ats.webapi.repository.prodapp.StockTransfTypeRepo;
import com.ats.webapi.repository.prodapp.TRegSpCakeSupRepo;
import com.ats.webapi.repository.prodapp.TSpCakeSupRepo;
import com.ats.webapi.repository.prodapp.report.FrWiseSpCakeOrdRepo;
import com.ats.webapi.repository.prodapp.report.FrwiseRateChangedItemReportRepo;
import com.ats.webapi.repository.prodapp.report.MisrtrywiseFrItemReportRepo;
import com.ats.webapi.repository.prodapp.report.MistrywiseReportRepo;
import com.ats.webapi.repository.prodapp.report.RoutewiseLastCakeEndTimeRepo;
import com.ats.webapi.service.CategoryService;
import com.ats.webapi.service.ItemService;
import com.ats.webapi.service.MenuService;
import com.ats.webapi.service.spprod.SpProdService;

@RestController
public class ProdAppController {

	/*
	 * 
	 * SELECT
	 * t_sp_cake_sup.t_sp_cake_sup_no,m_franchisee.fr_name,m_franchisee.fr_code,
	 * m_sp_cake.sp_code,m_sp_cake.sp_name,t_sp_cake_sup.input_kg_fr,t_sp_cake_sup.
	 * input_kg_prod, (t_sp_cake_sup.input_kg_prod-t_sp_cake_sup.input_kg_fr) as
	 * weight_diff FROM t_sp_cake_sup,m_franchisee,m_sp_cake WHERE
	 * t_sp_cake_sup.date BETWEEN '2018-10-01' AND '2018-10-10' AND
	 * t_sp_cake_sup.fr_id=m_franchisee.fr_id AND
	 * t_sp_cake_sup.sp_cake_id=m_sp_cake.sp_id
	 */
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

	@Autowired
	StockTransfHeaderRepo stockTransfHeaderRepo;
	@Autowired
	StockTransfDetailRepo stockTransfDetailRepo;

	@Autowired
	StockTransfTypeRepo stockTransfTypeRepo;

	@Autowired
	GateSaleStockDetailRepo gateSaleStockDetailRepo;
	@Autowired
	GateSaleStockHeaderRepo gateSaleStockHeaderRepo;

	@Autowired
	StockTransfDataByTypeGrpBySubcat getStockTransfDataByTypeGrpByItemRepo;

	@Autowired
	DashRegSpCakeCountRepo getDashRegSpCakeCountRepo;
	@Autowired
	DashSpCakeCountRepo getDashSpCakeCountRepo;

	@Autowired
	FrwiseStockTransfDataRepo getFrwiseStockTransfDataRepo;

	@RequestMapping(value = { "/getFrwiseStockTransfData" }, method = RequestMethod.POST) // task no 50 webservice for
																							// based on selection of
																							// date & multiple
																							// category/All: show all
																							// record in stock transfer
																							// tabel which type is dummy
																							// franchasi (header &
																							// detail)
	public @ResponseBody List<FrwiseStockTransfData> getFrwiseStockTransfData(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("stockTypeList") List<Integer> stockTypeList,
			@RequestParam("menuIdList") List<Integer> menuIdList, @RequestParam("frIdList") List<Integer> frIdList) {

		List<FrwiseStockTransfData> frWiseitemStockTransfList = new ArrayList<FrwiseStockTransfData>();
		try {

			frWiseitemStockTransfList = getFrwiseStockTransfDataRepo.getFrwiseStockTransfData(fromDate, toDate,
					stockTypeList, menuIdList, frIdList);

		} catch (Exception e) {

			System.err.println("Exception in getFrwiseStockTransfData @ProdAppCont  " + e.getMessage());

			e.printStackTrace();
		}

		return frWiseitemStockTransfList;

	}

	@RequestMapping(value = { "/getDashRegSpCakeCount" }, method = RequestMethod.POST)
	public @ResponseBody List<DashRegSpCakeCount> getDashRegSpCakeCount(@RequestParam("prodDate") String prodDate,
			@RequestParam("menuIdList") List<Integer> menuIdList) {

		List<DashRegSpCakeCount> getDashRegSpCakeCountList = new ArrayList<DashRegSpCakeCount>();
		try {

			if (menuIdList.contains(-1)) {

				getDashRegSpCakeCountList = getDashRegSpCakeCountRepo.getRegSpCakeOrdCountAllMenu(prodDate);

			} else {

				getDashRegSpCakeCountList = getDashRegSpCakeCountRepo.getRegSpCakeOrdCountSpecMenu(prodDate,
						menuIdList);

			}

		} catch (Exception e) {

			System.err.println("Exception in getDashRegSpCakeCount @ProdAppCont  " + e.getMessage());

			e.printStackTrace();
		}

		return getDashRegSpCakeCountList;

	}

	@RequestMapping(value = { "/getDashSpCakeCount" }, method = RequestMethod.POST)
	public @ResponseBody List<DashSpCakeCount> getDashSpCakeCount(@RequestParam("prodDate") String prodDate,
			@RequestParam("menuIdList") List<Integer> menuIdList) {

		List<DashSpCakeCount> getDashSpCakeCountList = new ArrayList<DashSpCakeCount>();
		try {

			if (menuIdList.contains(-1)) {

				getDashSpCakeCountList = getDashSpCakeCountRepo.getSpCakeOrdCountAllMenu(prodDate);

			} else {

				getDashSpCakeCountList = getDashSpCakeCountRepo.getSpCakeOrdCountSpecMenu(prodDate, menuIdList);

			}

		} catch (Exception e) {

			System.err.println("Exception in getDashSpCakeCount @ProdAppCont  " + e.getMessage());

			e.printStackTrace();
		}

		return getDashSpCakeCountList;

	}

	// route wise count reg and sp cakes task no 47
	@Autowired
	RoutewiseOrdCountBeanRepo getRoutewiseOrdCountBeanRepo;

	@RequestMapping(value = { "/getRoutewiseOrdCount" }, method = RequestMethod.POST)
	public @ResponseBody List<RoutewiseOrdCountBean> getRoutewiseOrdCount(@RequestParam("prodDate") String prodDate,
			@RequestParam("menuIdList") List<Integer> menuIdList) {

		List<RoutewiseOrdCountBean> ordCountResList = new ArrayList<>();

		try {

			if (menuIdList.contains(-1)) {

				ordCountResList = getRoutewiseOrdCountBeanRepo.getRoutewiseOrderCountAllMenu(prodDate);

			} else {

				ordCountResList = getRoutewiseOrdCountBeanRepo.getRoutewiseOrderCountSpecMenu(prodDate, menuIdList);

			}

		} catch (Exception e) {
			System.err.println("Exception in getRoutewiseOrdCount @ProdAppCont  " + e.getMessage());

			e.printStackTrace();
		}

		return ordCountResList;

	}

	// end route wise count reg and sp cakes

	// task no 48 getGetRoutewiseOrderData

	@RequestMapping(value = { "/getGetRoutewiseOrderData" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRoutewiseOrderData> getGetRoutewiseOrderData(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("menuIdList") List<Integer> menuIdList,
			@RequestParam("isOrderBy") int isOrderBy, @RequestParam("routeId") int routeId) {

		List<GetRegSpCakeOrderForProdApp> regSpCakeOrderList = new ArrayList<GetRegSpCakeOrderForProdApp>();
		List<GetSpCakeOrderForProdApp> spCakeOrdList = new ArrayList<GetSpCakeOrderForProdApp>();

		List<GetRoutewiseOrderData> orderDataList = new ArrayList<>();

		try {

			if (menuIdList.contains(-1)) {

				System.err.println("getGetRoutewiseOrderData/ menuId -1 ");

				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderByRouteIdAllMenu(fromDate, toDate,
						routeId);

				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderByRouteIdAllMenu(fromDate, toDate, routeId);

			} else {

				System.err.println("getGetRoutewiseOrderData/ specific menus ");

				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderByRouteIdSpecMenu(fromDate,
						toDate, menuIdList, routeId);

				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderByRouteIdSpecMenu(fromDate, toDate, menuIdList,
						routeId);
				System.err.println("regSpCakeOrderList/  " + regSpCakeOrderList.toString());

				System.err.println("spCakeOrdList/  " + spCakeOrdList.toString());

			}

			List<Integer> frIdArray = new ArrayList<>();
			for (int i = 0; i < spCakeOrdList.size(); i++) {

				frIdArray.add(spCakeOrdList.get(i).getFrId());

			}

			for (int j = 0; j < regSpCakeOrderList.size(); j++) {

				frIdArray.add(regSpCakeOrderList.get(j).getFrId());
			}
			System.err.println("Fr Id array list before sort  " + frIdArray);

			// sort frIdarray for unique frIds
			HashSet<Integer> tempList = new HashSet<>();
			tempList.addAll(frIdArray);
			frIdArray.clear();
			frIdArray.addAll(tempList);
			System.err.println("Fr Id array list after sort  " + frIdArray);

			// List<RegSpOrd> regOrdListRes = new ArrayList<RegSpOrd>();
			// List<SpOrder> spOrdListRes = new ArrayList<SpOrder>();

			for (int a = 0; a < frIdArray.size(); a++) {

				GetRoutewiseOrderData orderData = new GetRoutewiseOrderData();

				orderData.setFrId(frIdArray.get(a));

				List<SpOrder> spOrdListRes = new ArrayList<SpOrder>();
				List<RegSpOrd> regOrdListRes = new ArrayList<RegSpOrd>();

				for (int b = 0; b < spCakeOrdList.size(); b++) {

					System.err.println("Inside  spCakeOrdList index " + b);

					if (frIdArray.get(a) == spCakeOrdList.get(b).getFrId()) {

						orderData.setFrCode(spCakeOrdList.get(b).getFrCode());
						orderData.setFrName(spCakeOrdList.get(b).getFrName());
						orderData.setRouteId(spCakeOrdList.get(b).getRouteId());

						SpOrder spOrder = new SpOrder();

						spOrder.setDate(spCakeOrdList.get(b).getDate());
						spOrder.setEndTimeStamp(spCakeOrdList.get(b).getEndTimeStamp());
						spOrder.setFrCode(spCakeOrdList.get(b).getFrCode());
						spOrder.setFrId(spCakeOrdList.get(b).getFrId());
						spOrder.setFrName(spCakeOrdList.get(b).getFrName());
						spOrder.setInputKgFr(spCakeOrdList.get(b).getInputKgFr());
						spOrder.setInputKgProd(spCakeOrdList.get(b).getInputKgProd());
						spOrder.setIsCharUsed(spCakeOrdList.get(b).getIsCharUsed());
						spOrder.setNoInRoute(spCakeOrdList.get(b).getNoInRoute());
						spOrder.setOrderPhoto(spCakeOrdList.get(b).getOrderPhoto());
						spOrder.setOrderPhoto2(spCakeOrdList.get(b).getOrderPhoto2());
						spOrder.setRouteId(spCakeOrdList.get(b).getRouteId());
						spOrder.setRouteName(spCakeOrdList.get(b).getRouteName());
						spOrder.setSpCode(spCakeOrdList.get(b).getSpCode());
						spOrder.setSpDeliveryDate(spCakeOrdList.get(b).getSpDeliveryDate());
						spOrder.setSpDeliveryPlace(spCakeOrdList.get(b).getSpDeliveryPlace());
						spOrder.setSpEvents(spCakeOrdList.get(b).getSpEvents());
						spOrder.setSpEventsName(spCakeOrdList.get(b).getSpEventsName());
						spOrder.setSpFlavourId(spCakeOrdList.get(b).getSpFlavourId());
						spOrder.setSpfName(spCakeOrdList.get(b).getSpfName());
						spOrder.setSpImage(spCakeOrdList.get(b).getSpImage());
						spOrder.setSpInstructions(spCakeOrdList.get(b).getSpInstructions());
						spOrder.setSpName(spCakeOrdList.get(b).getSpName());
						spOrder.setSrNo(spCakeOrdList.get(b).getSrNo());
						spOrder.setStartTimeStamp(spCakeOrdList.get(b).getStartTimeStamp());
						spOrder.setStatus(spCakeOrdList.get(b).getStatus());
						spOrder.settSpCakeSupNo(spCakeOrdList.get(b).gettSpCakeSupNo());

						spOrdListRes.add(spOrder);

					} // end of if

				} // end of for
				orderData.setSpCakeOrdList(spOrdListRes);

				for (int c = 0; c < regSpCakeOrderList.size(); c++) {
					System.err.println("Inside regular regSpCakeOrderList index " + c);

					if (frIdArray.get(a) == regSpCakeOrderList.get(c).getFrId()) {

						orderData.setFrCode(regSpCakeOrderList.get(c).getFrCode());
						orderData.setFrName(regSpCakeOrderList.get(c).getFrName());
						orderData.setRouteId(regSpCakeOrderList.get(c).getRouteId());

						RegSpOrd regSpOrd = new RegSpOrd();

						regSpOrd.setCatId(regSpCakeOrderList.get(c).getCatId());
						regSpOrd.setCatName(regSpCakeOrderList.get(c).getCatName());
						regSpOrd.setEndTime(regSpCakeOrderList.get(c).getEndTime());
						regSpOrd.setFrCode(regSpCakeOrderList.get(c).getFrCode());
						regSpOrd.setFrId(regSpCakeOrderList.get(c).getFrId());
						regSpOrd.setFrName(regSpCakeOrderList.get(c).getFrName());
						regSpOrd.setId(regSpCakeOrderList.get(c).getId());
						regSpOrd.setInputKgProd(regSpCakeOrderList.get(c).getInputKgProd());
						regSpOrd.setIsCharUsed(regSpCakeOrderList.get(c).getIsCharUsed());
						regSpOrd.setItemId(regSpCakeOrderList.get(c).getItemId());
						regSpOrd.setItemImage(regSpCakeOrderList.get(c).getItemImage());
						regSpOrd.setItemName(regSpCakeOrderList.get(c).getItemName());
						regSpOrd.setNoInRoute(regSpCakeOrderList.get(c).getNoInRoute());
						regSpOrd.setPhoto1(regSpCakeOrderList.get(c).getPhoto1());
						regSpOrd.setPhoto2(regSpCakeOrderList.get(c).getPhoto2());
						regSpOrd.setProdDate(regSpCakeOrderList.get(c).getProdDate());
						regSpOrd.setRouteId(regSpCakeOrderList.get(c).getRouteId());
						regSpOrd.setRouteName(regSpCakeOrderList.get(c).getRouteName());
						regSpOrd.setRspDeliveryDt(regSpCakeOrderList.get(c).getRspDeliveryDt());
						regSpOrd.setRspPlace(regSpCakeOrderList.get(c).getRspPlace());
						regSpOrd.setSrNo(regSpCakeOrderList.get(c).getSrNo());
						regSpOrd.setStartTime(regSpCakeOrderList.get(c).getStartTime());
						regSpOrd.setStatus(regSpCakeOrderList.get(c).getStatus());
						regSpOrd.setSubCatId(regSpCakeOrderList.get(c).getSubCatId());
						regSpOrd.setSubCatName(regSpCakeOrderList.get(c).getSubCatName());
						regSpOrd.setSupId(regSpCakeOrderList.get(c).getSupId());
						regSpOrd.settRegSupOrderId(regSpCakeOrderList.get(c).gettRegSupOrderId());

						regOrdListRes.add(regSpOrd);
					} // end of if
				}
				orderData.setRegSpCakeOrdList(regOrdListRes);
				orderDataList.add(orderData);

			}
			System.err.println("orderDataList = " + orderDataList.toString());
		} catch (Exception e) {
			System.err.println("Exce in getGetRoutewiseOrderData   " + e.getMessage());
			e.printStackTrace();
		}
		return orderDataList;

	}

	// task no 40

	@RequestMapping(value = { "/getStockTransfDataByTypeGrpBySubcat" }, method = RequestMethod.POST) // task no 40
	public @ResponseBody List<StockTransfDataByTypeGrpBySubC> getStockTransfDataByTypeGrpByItem(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("typeIdList") List<Integer> typeIdList) {

		List<StockTransfDataByTypeGrpBySubC> itemWiseStockTransfList = new ArrayList<StockTransfDataByTypeGrpBySubC>();
		try {

			itemWiseStockTransfList = getStockTransfDataByTypeGrpByItemRepo.getStockTransfDataByTypeGrpByItem(fromDate,
					toDate, typeIdList);

		} catch (Exception e) {

			System.err.println("Exception in getStockTransfDataByTypeGrpBySubcat @ProdAppCont  " + e.getMessage());

			e.printStackTrace();
		}

		return itemWiseStockTransfList;

	}

	// 12 no web service on google sheet
	@Autowired
	GetDataForGateSaleDayEndRepo getDataForGateSaleDayEndRepo;

	@RequestMapping(value = { "/getDataForGateSaleDayEnd" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDataForGateSaleDayEnd> getDataForGateSaleDayEnd(
			@RequestParam("stockType") int stockType) {

		List<GetDataForGateSaleDayEnd> gateSaleDataDayEndList = new ArrayList<GetDataForGateSaleDayEnd>();
		try {
			GateSaleStockHeader saleStockHeader = gateSaleStockHeaderRepo.findByStockStatusAndDelStatus(0, 0);

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			String date = df.format(saleStockHeader.getStockDate());

			System.err.println("date " + date);

			// int stockType=1;//gate sale stock type

			gateSaleDataDayEndList = getDataForGateSaleDayEndRepo.getInQtyAndSaleQtySubCatwise(date, stockType);

		} catch (Exception e) {

			System.out.println("Exce in getAllTrasnfTyPe Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return gateSaleDataDayEndList;

	}

	@RequestMapping(value = { "/insertOrUpdateOpQtyInGateSaleStock" }, method = RequestMethod.POST)
	public @ResponseBody Info insertOpQtyInGateSaleStock(@RequestBody List<GateSaleStockEntry> stockEntryList) {

		Info info = new Info();

		try {

			List<GateSaleStockDetail> stockDetailList = new ArrayList<>();

			GateSaleStockHeader saleStockHeader = gateSaleStockHeaderRepo.findByStockStatusAndDelStatus(0, 0);

			if (saleStockHeader == null) {

				System.err.println("Null Header Found so insert new Record insert sale stock header and detail");

				GateSaleStockHeader stockHead = new GateSaleStockHeader();

				stockHead.setDelStatus(0);
				stockHead.setStockDate(new Date());
				stockHead.setStockStatus(0);

				saleStockHeader = new GateSaleStockHeader();

				saleStockHeader = gateSaleStockHeaderRepo.save(stockHead);
				if (saleStockHeader == null) {

					info.setError(true);
					info.setMessage("failed to save new sale stock header ");
				}
				System.err.println("New Record Inserted " + gateSaleStockHeaderRepo.toString());

				for (int i = 0; i < stockEntryList.size(); i++) {

					GateSaleStockDetail stockDetail = new GateSaleStockDetail();

					stockDetail.setCatId(stockEntryList.get(i).getCatId());
					stockDetail.setClosingQty(0);
					stockDetail.setDelStatus(0);
					stockDetail.setGateSaleStockHeaderId(saleStockHeader.getGateSaleStockHeaderId());
					stockDetail.setInQty(0);
					stockDetail.setOpQty(stockEntryList.get(i).getQty());
					stockDetail.setSaleQty(0);
					stockDetail.setStockDate(new Date());
					stockDetail.setSubCatId(stockEntryList.get(i).getSubCatId());

					GateSaleStockDetail detailResponse = gateSaleStockDetailRepo.save(stockDetail);

					if (detailResponse == null) {

						info.setError(true);
						info.setMessage("failed to save new sale stock detail ");
					}

				}

			} else {

				System.err.println(" Header Found with 0 status so update sale stock detail");

				stockDetailList = gateSaleStockDetailRepo
						.findByGateSaleStockHeaderId(saleStockHeader.getGateSaleStockHeaderId());

				for (int j = 0; j < stockDetailList.size(); j++) {

					for (int i = 0; i < stockEntryList.size(); i++) {

						if (stockEntryList.get(i).getSubCatId() == stockDetailList.get(j).getSubCatId()) {

							stockDetailList.get(j).setOpQty(stockEntryList.get(i).getQty());

						}

					}

					GateSaleStockDetail detailResponse = gateSaleStockDetailRepo.save(stockDetailList.get(j));

					if (detailResponse == null) {

						info.setError(true);
						info.setMessage("failed to update sale stock detail ");
					}
				}

			}

		} catch (Exception e) {

			System.out.println("Exce in insertOrUpdateOpQtyInGateSaleStock Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllTrasnfTyPe" }, method = RequestMethod.GET)
	public @ResponseBody List<StockTransfType> getAllTrasnfTyPe() {

		List<StockTransfType> stockTransfTypeList = new ArrayList<StockTransfType>();
		try {

			stockTransfTypeList = stockTransfTypeRepo.findByDelStatus(0);

		} catch (Exception e) {

			System.out.println("Exce in getAllTrasnfTyPe Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return stockTransfTypeList;

	}

	@RequestMapping(value = { "/addStockTransfHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody StockTransfHeader addStockTransfHeaderDetail(
			@RequestBody StockTransfHeader stockTransfHeader) {

		StockTransfHeader response = new StockTransfHeader();
		try {

			response = stockTransfHeaderRepo.save(stockTransfHeader);

			List<StockTransfDetail> stockTransfDetails = stockTransfHeader.getStockTransfDetailList();
			for (int i = 0; i < stockTransfDetails.size(); i++) {

				stockTransfDetails.get(i).setStockTransfHeaderId(response.getStockTransfHeaderId());

			}

			List<StockTransfDetail> stockDetailRes = stockTransfDetailRepo.save(stockTransfDetails);

			response.setStockTransfDetailList(stockDetailRes);

		} catch (Exception e) {

			System.out.println("Exce in addStockTransfHeaderDetail Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/addGateSaleStockHeadDetail" }, method = RequestMethod.POST)
	public @ResponseBody GateSaleStockHeader addGateSaleStockHeadDetail(
			@RequestBody GateSaleStockHeader saleStockHeader) {

		GateSaleStockHeader response = new GateSaleStockHeader();
		try {

			response = gateSaleStockHeaderRepo.save(saleStockHeader);

			List<GateSaleStockDetail> saleStockDetailList = saleStockHeader.getGetGateSaleStockDetailList();

			for (int i = 0; i < saleStockDetailList.size(); i++) {

				saleStockDetailList.get(i).setGateSaleStockHeaderId(response.getGateSaleStockHeaderId());

			}

			List<GateSaleStockDetail> gateSaleStockDetailRes = gateSaleStockDetailRepo.save(saleStockDetailList);

			response.setGetGateSaleStockDetailList(gateSaleStockDetailRes);

		} catch (Exception e) {

			System.out.println("Exce in addGateSaleStockHeadDetail Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return response;

	}

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
			@RequestParam("uDeviceToken") String uDeviceToken) {

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

			if (user.getuPass().equals(oldPass))
				;

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
	public @ResponseBody List<AllMenus> getMenusByCatId(@RequestParam("catId") int catId,
			@RequestParam("isSameDayApp") int isSameDayApp) {

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
	public @ResponseBody Info startSpCakeProd(@RequestParam("startTimeStamp") Long startTimeStamp,
			@RequestParam("tSpCakeSupNo") int tSpCakeSupNo, @RequestParam("status") int status) {

		Info info = new Info();

		int response = 0;

		try {

			response = tSpCakeSupRepo.startProdByApp(startTimeStamp, tSpCakeSupNo, status);

			if (response > 0) {

				info.setError(false);
				info.setMessage("sp cake prod started successfully");
			} else {

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
			@RequestParam("inputKgProd") float inputKgProd, @RequestParam("photo1") String photo1,
			@RequestParam("photo2") String photo2, @RequestParam("tSpCakeSupNo") int tSpCakeSupNo,

			@RequestParam("mistryId") int mistryId, @RequestParam("mistryName") String mistryName,
			@RequestParam("isCharUsed") String isCharUsed,

			@RequestParam("status") int status, @RequestParam("isRateChange") int isRateChange,
			@RequestParam("timeRequired") String timeRequired) {

		Info info = new Info();

		int response = 0;

		try {

			response = tSpCakeSupRepo.endProdByApp(endTimeStamp, inputKgProd, status, photo1, photo2, mistryId,
					mistryName, isCharUsed, tSpCakeSupNo, isRateChange, timeRequired);

			if (response > 0) {

				info.setError(false);
				info.setMessage("sp cake endSpCakeProd  successfull");
			} else {

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
	public @ResponseBody Info startRegSpCakeProd(@RequestParam("startTimeStamp") Long startTimeStamp,
			@RequestParam("supId") int supId, @RequestParam("status") int status) {

		Info info = new Info();

		int response = 0;

		try {

			response = tRegSpCakeSupRepo.startRegSpCakeProdByApp(startTimeStamp, supId, status);

			if (response > 0) {

				info.setError(false);
				info.setMessage(" reg sp cake prod started successfully");
			} else {

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
			@RequestParam("inputKgProd") float inputKgProd, @RequestParam("photo1") String photo1,
			@RequestParam("photo2") String photo2, @RequestParam("supId") int supId,

			@RequestParam("mistryId") int mistryId, @RequestParam("mistryName") String mistryName,
			@RequestParam("isCharUsed") String isCharUsed, @RequestParam("timeRequired") String timeRequired,

			@RequestParam("status") int status) {

		Info info = new Info();

		int response = 0;

		try {

			response = tRegSpCakeSupRepo.endRegSpCakeProdByApp(endTime, inputKgProd, status, photo1, photo2, mistryId,
					mistryName, isCharUsed, timeRequired, supId);

			if (response > 0) {

				info.setError(false);
				info.setMessage("sp cake endRegSpCakeProd  successfull");
			} else {

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
			@RequestParam("toDate") String toDate, @RequestParam("menuIdList") List<Integer> menuIdList,
			@RequestParam("isSlotUsed") List<Integer> isSlotUsed, @RequestParam("isOrderBy") int isOrderBy) {

		List<GetSpCakeOrderForProdApp> spCakeOrdList = new ArrayList<GetSpCakeOrderForProdApp>();
		try {
			System.err.println(
					"For  getSpCakeOrdersForApp // menuId List " + menuIdList.toString() + "order By " + isOrderBy);

			if (menuIdList.contains(-1) && isOrderBy == 0) {
				System.err.println("A] menuId -1 and order by 0 ");

				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderForProdGenAllMenu(fromDate, toDate, isSlotUsed);

			} else if (menuIdList.contains(-1) && isOrderBy == 1) {

				System.err.println(" B] menuId -1 and order by 1 ");

				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderForProdOrderByAndAllMenu(fromDate, toDate,
						isSlotUsed);

			}

			else if (isOrderBy == 0) {
				System.err.println(" C] specific menu and order by 0 ");

				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderForProdGen(fromDate, toDate, menuIdList,
						isSlotUsed);

			} else {

				System.err.println(" D] specific menu and order by 1 ");
				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeOrderForProdOrderBy(fromDate, toDate, menuIdList,
						isSlotUsed);

			}

		} catch (Exception e) {

			System.out.println("Exce in getSpCakeOrdersForApp Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return spCakeOrdList;

	}
	
	
	//--------ANMOL 13-7-2019-----------------------
	@RequestMapping(value = { "/getSpCakeAlbumOrdersForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSpCakeOrderForProdApp> getSpCakeAlbumOrdersForApp(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("menuIdList") List<Integer> menuIdList,
			@RequestParam("isSlotUsed") List<Integer> isSlotUsed, @RequestParam("isOrderBy") int isOrderBy) {

		List<GetSpCakeOrderForProdApp> spCakeOrdList = new ArrayList<GetSpCakeOrderForProdApp>();
		try {
			System.err.println(
					"For  getSpCakeOrdersForApp // menuId List " + menuIdList.toString() + "order By " + isOrderBy);

			if (menuIdList.contains(-1) && isOrderBy == 0) {
				System.err.println("A] menuId -1 and order by 0 ");

				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeAlbumOrderForProdGenAllMenu(fromDate, toDate, isSlotUsed);

			} else if (menuIdList.contains(-1) && isOrderBy == 1) {

				System.err.println(" B] menuId -1 and order by 1 ");

				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeAlbumOrderForProdOrderByAndAllMenu(fromDate, toDate,
						isSlotUsed);

			}

			else if (isOrderBy == 0) {
				System.err.println(" C] specific menu and order by 0 ");

				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeAlbumOrderForProdGen(fromDate, toDate, menuIdList,
						isSlotUsed);

			} else {

				System.err.println(" D] specific menu and order by 1 ");
				spCakeOrdList = getSpCakeForProdAppRepo.getSpCakeAlbumOrderForProdOrderBy(fromDate, toDate, menuIdList,
						isSlotUsed);

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
	public @ResponseBody List<GetRegSpCakeOrderForProdApp> geRegtSpCakeOrdersForApp(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("menuIdList") List<Integer> menuIdList, @RequestParam("isOrderBy") int isOrderBy) {

		List<GetRegSpCakeOrderForProdApp> regSpCakeOrderList = new ArrayList<GetRegSpCakeOrderForProdApp>();
		try {
			System.err.println(
					"For  getSpCakeOrdersForApp // menuId List " + menuIdList.toString() + "order By " + isOrderBy);

			if (menuIdList.contains(-1) && isOrderBy == 0) {
				System.err.println("A] menuId -1 and order by 0 ");

				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderForProdGenAllMenu(fromDate,
						toDate);

			} else if (menuIdList.contains(-1) && isOrderBy == 1) {

				System.err.println(" B] menuId -1 and order by 1 ");

				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderForProdOrderByAndAllMenu(fromDate,
						toDate);

			}

			else if (isOrderBy == 0) {
				System.err.println(" C] specific menu and order by 0 ");

				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderForProdGen(fromDate, toDate,
						menuIdList);

			} else {

				System.err.println(" D] specific menu and order by 1 ");
				regSpCakeOrderList = getRegSpCakeOrderForProdAppRepo.getRegSpCakeOrderForProdOrderBy(fromDate, toDate,
						menuIdList);

			}

		} catch (Exception e) {

			System.out.println("Exce in geRegSpCakeOrdersForApp Rest ProdAppController " + e.getMessage());

			e.printStackTrace();
		}

		return regSpCakeOrderList;

	}

	@Autowired
	SpProdService spProdService;

	// ---------------------------Getting Employee List--- existing in web service
	// just renamed ----------------------
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

	@Autowired
	private CategoryService categoryService;

	// Show All Main and sub Category /showAllCategory changed for name from rest
	@RequestMapping(value = { "/getAllCatWithSubCatList" }, method = RequestMethod.GET)

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

	// reports

	@Autowired
	FrWiseSpCakeOrdRepo getFrWiseSpCakeOrdRepo; // report /report no 2 only on t_sp_cake_sup
	@Autowired
	MistrywiseReportRepo getMistrywiseReportRepo; // report no 3 and 4 on both table
	@Autowired
	MisrtrywiseFrItemReportRepo getMisrtrywiseFrItemReportRepo; // report 5 no group by all table
	@Autowired
	FrwiseRateChangedItemReportRepo getFrwiseRateChangedItemReportRepo; // report 6

	@RequestMapping(value = { "/getFrWiseSpCakeOrd" }, method = RequestMethod.POST)
	public @ResponseBody List<FrWiseSpCakeOrd> getFrWiseSpCakeOrd(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<FrWiseSpCakeOrd> frWiseSpCakeOrdList = new ArrayList<FrWiseSpCakeOrd>();
		try {
			frWiseSpCakeOrdList = getFrWiseSpCakeOrdRepo.getFrWiseSpCakeOrd(fromDate, toDate);
			System.err.println("frWiseSpCakeOrdList" + frWiseSpCakeOrdList.toString());
		}

		catch (Exception e) {
			System.err.println("Exce in getFrWiseSpCakeOrd " + e.getMessage());
			e.printStackTrace();
		}
		return frWiseSpCakeOrdList;
	}

	@RequestMapping(value = { "/getMistrywiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<MistrywiseReport> getMistrywiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("mistryIdList") List<Integer> mistryIdList,
			@Param("table") String table, @Param("groupBy") String groupBy) {

		List<MistrywiseReport> mistrywiseOrdList = new ArrayList<MistrywiseReport>();

		try {

			if (table.equalsIgnoreCase("sp")) {
				System.err.println("sp table query");

				if (mistryIdList.contains(-1)) {
					System.err.println("mistry Id -1 all");
					if (groupBy.equalsIgnoreCase("date")) {
						System.err.println("group by date ");
						mistrywiseOrdList = getMistrywiseReportRepo.getMistrywiseReportSpAllMistryGrpDate(fromDate,
								toDate);

					} else {
						// group by mistry id

						System.err.println("group by mistry Id ");
						mistrywiseOrdList = getMistrywiseReportRepo.getMistrywiseReportSpAllMistry(fromDate, toDate);
					}
				} else {
					System.err.println("spec mistry ids");
					if (groupBy.equalsIgnoreCase("date")) {
						System.err.println("group by date ");
						mistrywiseOrdList = getMistrywiseReportRepo.getMistrywiseReportSpSpecMistryGrpDate(fromDate,
								toDate, mistryIdList);

					} else {
						// group by mistry id
						System.err.println("group by mistry Id ");
						mistrywiseOrdList = getMistrywiseReportRepo.getMistrywiseReportSpSpecMistry(fromDate, toDate,
								mistryIdList);
					}

				}

			} else {
				System.err.println("reg sp table query");
				if (mistryIdList.contains(-1)) {
					System.err.println("mistry Id -1 all");
					if (groupBy.equalsIgnoreCase("date")) {
						System.err.println("group by date ");
						mistrywiseOrdList = getMistrywiseReportRepo.getMistrywiseReportRegSpAllMistryGrpDate(fromDate,
								toDate);

					} else {
						// group by mistry id
						System.err.println("group by mistry Id ");
						mistrywiseOrdList = getMistrywiseReportRepo.getMistrywiseReportRegSpAllMistry(fromDate, toDate);
					}
				} else {
					System.err.println("spec mistry ids");
					if (groupBy.equalsIgnoreCase("date")) {
						System.err.println("group by date ");
						mistrywiseOrdList = getMistrywiseReportRepo.getMistrywiseReportRegSpSpecMistryGrpDate(fromDate,
								toDate, mistryIdList);

					} else {
						// group by mistry id
						System.err.println("group by mistry Id ");
						mistrywiseOrdList = getMistrywiseReportRepo.getMistrywiseReportRegSpSpecMistry(fromDate, toDate,
								mistryIdList);
					}

				}

			}

		} catch (Exception e) {
			System.err.println("Exce in getMistrywiseReport " + e.getMessage());
			e.printStackTrace();
		}

		return mistrywiseOrdList;

	}

	@RequestMapping(value = { "/getMisrtrywiseFrItemReport" }, method = RequestMethod.POST)
	public @ResponseBody List<MisrtrywiseFrItemReport> getMisrtrywiseFrItemReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("mistryIdList") List<Integer> mistryIdList, @Param("table") String table) {

		List<MisrtrywiseFrItemReport> misrtrywiseFrItemReportList = new ArrayList<MisrtrywiseFrItemReport>();

		try {

			if (table.equalsIgnoreCase("sp")) {

				if (mistryIdList.contains(-1)) {

					misrtrywiseFrItemReportList = getMisrtrywiseFrItemReportRepo
							.getMisrtrywiseFrItemReportSpAllMis(fromDate, toDate);
				} else {

					misrtrywiseFrItemReportList = getMisrtrywiseFrItemReportRepo
							.getMisrtrywiseFrItemReportSpSpecMis(fromDate, toDate, mistryIdList);

				}
			} else {

				if (mistryIdList.contains(-1)) {

					misrtrywiseFrItemReportList = getMisrtrywiseFrItemReportRepo
							.getMisrtrywiseFrItemReportRegSpAllMis(fromDate, toDate);
				} else {

					misrtrywiseFrItemReportList = getMisrtrywiseFrItemReportRepo
							.getMisrtrywiseFrItemReportRegSpSpecMis(fromDate, toDate, mistryIdList);

				}

			}

		} catch (Exception e) {
			System.err.println("Exce in getMisrtrywiseFrItemReport " + e.getMessage());
			e.printStackTrace();
		}

		return misrtrywiseFrItemReportList;
	}

	// getFrwiseRateChangedItemReportRepo

	@RequestMapping(value = { "/getFrwiseRateChangedItemReport" }, method = RequestMethod.POST)
	public @ResponseBody List<FrwiseRateChangedItemReport> getFrWiseSpCakeOrd(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frIdList") List<Integer> frIdList) {

		List<FrwiseRateChangedItemReport> frwiseRateChangedItemReportList = new ArrayList<FrwiseRateChangedItemReport>();

		try {

			if (frIdList.contains(-1)) {

				frwiseRateChangedItemReportList = getFrwiseRateChangedItemReportRepo
						.getFrwiseRateChangedItemReportAllFr(fromDate, toDate);

			} else {

				frwiseRateChangedItemReportList = getFrwiseRateChangedItemReportRepo
						.getFrwiseRateChangedItemReportSpecFr(fromDate, toDate, frIdList);

			}

		} catch (Exception e) {

			System.err.println("Exce in getFrwiseRateChangedItemReport " + e.getMessage());
			e.printStackTrace();

		}

		return frwiseRateChangedItemReportList;
	}

	@Autowired
	RoutewiseLastCakeEndTimeRepo getRoutewiseLastCakeEndTimeRepo;

	@RequestMapping(value = { "/getRoutewiseLastCakeEndTime" }, method = RequestMethod.POST)
	public @ResponseBody List<RoutewiseLastCakeEndTime> getRoutewiseLastCakeEndTime(
			@RequestParam("prodDate") String prodDate) {

		List<RoutewiseLastCakeEndTime> frwiseRateChangedItemReportList = new ArrayList<RoutewiseLastCakeEndTime>();

		try {

			frwiseRateChangedItemReportList = getRoutewiseLastCakeEndTimeRepo.getRoutewiseLastCakeEndTime(prodDate);

		} catch (Exception e) {
			System.err.println("Exce in getRoutewiseLastCakeEndTime " + e.getMessage());
			e.printStackTrace();
		}
		return frwiseRateChangedItemReportList;
	}

	/*
	 * route wise last record SELECT
	 * m_fr_route.route_id,m_fr_route.route_name,m_fr_route.route_seq_no,
	 * 
	 * COALESCE(( SELECT MAX(t_sp_cake_sup.end_time_stamp) FROM
	 * t_sp_cake_sup,m_franchisee WHERE t_sp_cake_sup.date BETWEEN '2018-10-10' AND
	 * '2018-10-10' AND t_sp_cake_sup.fr_id=m_franchisee.fr_id AND
	 * m_franchisee.fr_route_id=m_fr_route.route_id ),0)AS max_end_time_sp,
	 * 
	 * 
	 * COALESCE(( SELECT MAX(t_reg_sp_cake_sup.end_time) FROM
	 * t_reg_sp_cake_sup,m_franchisee WHERE t_reg_sp_cake_sup.prod_date BETWEEN
	 * '2018-10-10' AND '2018-10-10' AND t_reg_sp_cake_sup.fr_id=m_franchisee.fr_id
	 * AND m_franchisee.fr_route_id=m_fr_route.route_id ),0)AS max_end_time_reg_sp
	 * 
	 * FROM m_fr_route WHERE m_fr_route.del_status=0
	 */

}
