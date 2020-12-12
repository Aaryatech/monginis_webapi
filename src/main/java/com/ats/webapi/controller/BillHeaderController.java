package com.ats.webapi.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.BillHeader;
import com.ats.webapi.model.MenuOrderLimit;
import com.ats.webapi.model.ProdQtyLimitCnt;
import com.ats.webapi.model.SettingNew;
import com.ats.webapi.repository.BillHeaderRepository;
import com.ats.webapi.repository.ProdQtyLimitCntRepository;
import com.ats.webapi.repository.SettingNewRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



//Akhilesh Friday 11/12/2020 15:34
@RestController
public class BillHeaderController {

	@Autowired
	BillHeaderRepository billHeaderRepo;
	
	@Autowired
	SettingNewRepository settingNewRepository;
	
	@Autowired
	ProdQtyLimitCntRepository prodQtyRepo;
	
	
	@RequestMapping(value="/getListGreaterThanBillNo",method=RequestMethod.POST)
	public @ResponseBody List<BillHeader> getListGreaterThanBillNo(@RequestParam int billNo){
		List<BillHeader> BillHeaderRespList=new ArrayList<BillHeader>();
		
		try {
			BillHeaderRespList=billHeaderRepo.getListGreaterThanBillNo(billNo);
			System.err.println("size Of BillHeaderRespList== "+BillHeaderRespList.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /getListGreaterThanBillNo");
			e.printStackTrace();
			
		}
		
		return BillHeaderRespList;
		
	}
	
	
	
	@RequestMapping(value="/getProdtCntByDateAndCatId",method=RequestMethod.POST)
	public @ResponseBody List<ProdQtyLimitCnt>  getProdtCntByDateAndCatId(@RequestParam String prodDate,@RequestParam int catId) {
		List<ProdQtyLimitCnt> prodQtyList=new ArrayList<ProdQtyLimitCnt>();
		try {
			prodQtyList=prodQtyRepo.getProdQtyLimitCntList(prodDate);
			
			SettingNew setting = settingNewRepository.findBySettingKey("MENULIMIT");
			if (setting != null) {
				if (!setting.getSettingValue1().isEmpty()) {
						Gson gson = new Gson();

					Type userListType = new TypeToken<ArrayList<MenuOrderLimit>>() {
					}.getType();

					ArrayList<MenuOrderLimit> jsonList = gson.fromJson(setting.getSettingValue1(), userListType);

					//System.err.println("SETTINGS JSON ----> " + jsonList);

					if (jsonList != null) {
						for(MenuOrderLimit res :jsonList) {
							for(ProdQtyLimitCnt cnt : prodQtyList) {
								if(res.getMenuId()==cnt.getMenuId() && res.getCatId()==catId) {
									cnt.setTotal(res.getQtyLimit());
									//System.err.println(res);
								}
							}
						}
					}

				}

			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception Occuered In /hello ");
			e.printStackTrace();
		}
		
		
		return prodQtyList;
		
	}
	
	
	
	
	
}
