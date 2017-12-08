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

import com.ats.webapi.model.Info;
import com.ats.webapi.model.SellBillDataCommon;
import com.ats.webapi.model.rawmaterial.GetItemSfHeader;
import com.ats.webapi.model.rawmaterial.GetSfType;
import com.ats.webapi.model.rawmaterial.ItemSfDetail;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;
import com.ats.webapi.repository.GetItemSfHeaderRepo;
import com.ats.webapi.repository.SfTypeRepository;
import com.ats.webapi.service.rawmaterial.ItemSfService;

@RestController
public class ItemSfController {
	
	@Autowired
	ItemSfService itemSfService;
	
	@Autowired
	SfTypeRepository sfTypeRepository;
	
	@Autowired
	GetItemSfHeaderRepo  getItemSfHeaderRepo;

	@RequestMapping(value = { "/postSfItemHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info postSfItemHeader(@RequestBody ItemSfHeader itemSfHeader) {
		
		Info info =new Info();
		try {
				ItemSfHeader header = itemSfService.saveHeader(itemSfHeader);
			
				if(header!=null) {
					
					info.setError(false);
					info.setMessage("Sf Header Inserted Successfully");
				}
				else {
					
					info.setError(true);
					info.setMessage(" Error:Sf Header insert failed");
				}
			
		}catch (Exception e) {
			
			System.out.println("Exce in itemSf insert Rest controller "+e.getMessage());
			e.printStackTrace();
		}
	
	return info;
		
	  }
	
	
	@RequestMapping(value = { "/postSfItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info postSfItemDetail(@RequestBody List<ItemSfDetail> itemSfDetailList) {
		
		Info info =new Info();
		
		try {
				info=itemSfService.saveDetail(itemSfDetailList);
				
				if(!info.isError()) {
					
					info.setError(false);
					info.setMessage("Sf Detail Inserted Successfully");
				}
				else {
					
					info.setError(true);
					info.setMessage(" Error:Sf Detail insert failed");
				}
			
		}catch (Exception e) {
			
			System.out.println("Exce in itemSf insert Rest controller "+e.getMessage());
			e.printStackTrace();
		}
	
	return info;
		
	  }
	
	
	@RequestMapping(value = { "/getSfType" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSfType> getSfType(@RequestParam("delStatus") int delStatus) {
		
		List<GetSfType> sfTypeList=null;
		
		try {
			
			sfTypeList=sfTypeRepository.findByDelStatus(delStatus);
		
		}catch (Exception e) {
			
			System.out.println("Exe getting Sf Type "+e.getMessage());
			e.printStackTrace();
		}
		
	return sfTypeList;
	
	}
	
	
	@RequestMapping(value = { "/getItemSfHeader" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItemSfHeader> getItemSfHeader() {
		
		List<GetItemSfHeader> sfHeader=null;
		
		try {
			
			sfHeader=getItemSfHeaderRepo.getItemSfHeaderDetail();
		
		}catch (Exception e) {
			
			System.out.println("Exe getting Sf Item Header  "+e.getMessage());
			e.printStackTrace();
		}
		
	return sfHeader;
	
	}
		
}