package com.ats.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.SellBillDataCommon;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;
import com.ats.webapi.service.rawmaterial.ItemSfService;

@RestController
public class ItemSfController {
	
	@Autowired
	ItemSfService itemSfService;

	@RequestMapping(value = { "/postSfItem" }, method = RequestMethod.POST)
	public @ResponseBody Info postSfItem(@RequestBody ItemSfHeader itemSfHeader) {
		
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
	
}
