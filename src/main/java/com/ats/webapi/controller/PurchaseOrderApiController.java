package com.ats.webapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetail;
import com.ats.webapi.model.purchaseorder.PurchaseOrderHeader;
import com.ats.webapi.model.purchaseorder.TransporterDetails;
import com.ats.webapi.service.purchaseorder.PurchaseOrderService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderApiController {

	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	//----------------------Get Data Of Raw Material Item Categories---------------
		@RequestMapping(value = { "/insertPurchaseOrder" }, method = RequestMethod.POST)
		public Info insertPurchaseOrder(@RequestBody  PurchaseOrderHeader purchaseOrderHeader)throws ParseException, JsonParseException, JsonMappingException, IOException 
		{
			System.out.println("Data for insert : "+purchaseOrderHeader.toString());
			purchaseOrderHeader.setDelvDateRem(Common.convertToYMD(purchaseOrderHeader.getDelvDateRem()));
			purchaseOrderHeader.setQuotationRefDate(Common.convertToYMD(purchaseOrderHeader.getQuotationRefDate()));
			System.out.println("Data for AFTER : "+purchaseOrderHeader.toString());
		/*	purchaseOrderHeader.setPoDate(Common.convertToYMD(purchaseOrderHeader.getPoDate()));
			List<PurchaseOrderDetail> purchaseOrderDetailList=new ArrayList<PurchaseOrderDetail>();
			for(int i=0; i<purchaseOrderHeader.getPurchaseOrderDetail().size();i++)
			{
				PurchaseOrderDetail PurchaseOrderDetail =purchaseOrderHeader.getPurchaseOrderDetail().get(i);
				PurchaseOrderDetail.setPoDate(Common.convertToYMD(PurchaseOrderDetail.getPoDate()));
				purchaseOrderDetailList.add(PurchaseOrderDetail);
				//purchaseOrderHeader.setPurchaseOrderDetail(PurchaseOrderDetail);
			}
			purchaseOrderHeader.setPurchaseOrderDetail(purchaseOrderDetailList);*/
			Info info=purchaseOrderService.insertHeader(purchaseOrderHeader);
		 
			return info;
		}
 
 
}
