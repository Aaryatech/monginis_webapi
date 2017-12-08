package com.ats.webapi.service.purchaseorder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.purchaseorder.GetPurchaseOrderList;
import com.ats.webapi.model.purchaseorder.GetPurchaseOrderList;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetail;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetailedList;
import com.ats.webapi.model.purchaseorder.PurchaseOrderHeader;
import com.ats.webapi.model.purchaseorder.TransporterDetails;
import com.ats.webapi.repository.PurchaseOrderDetailRepository;
import com.ats.webapi.repository.PurchaseOrderHeaderRepository;

@Service
public class PurchaseOrderServiceImlp implements PurchaseOrderService{

	//private static  List<PurchaseOrderHeader> purchaseOrderHeader = new ArrayList<PurchaseOrderHeader>();

	@Autowired
	PurchaseOrderHeaderRepository purchaseOrderHeaderRepository;
	
	@Autowired
	PurchaseOrderDetailRepository purchaseOrderDetailRepository;
	
	
	@Override
	public Info insertHeader(PurchaseOrderHeader purchaseOrderHeader) {
		PurchaseOrderHeader pOHeader=new PurchaseOrderHeader();
		pOHeader=purchaseOrderHeaderRepository.save(purchaseOrderHeader);
		
		int headerId=pOHeader.getPoId();
		
		//PurchaseOrderDetail PurchaseOrderDetail=new PurchaseOrderDetail();
		List<PurchaseOrderDetail> purchaseOrderDetailList=purchaseOrderHeader.getPurchaseOrderDetail();
		
		for(int i=0;i<purchaseOrderDetailList.size();i++)
		{
			PurchaseOrderDetail purchaseOrderDetail=purchaseOrderDetailList.get(i);
			purchaseOrderDetail.setPoId(headerId);
			purchaseOrderDetailRepository.save(purchaseOrderDetail);
		}
		Info info=new Info();
		if(pOHeader!=null)
		{
			info.setError(false);
			info.setMessage("Insert Successfully");
			
		}
		else
		{
			info.setError(true);
			info.setMessage("Insert UnSuccessfully");
		}	
		 
		return info;
	}


	@Override
	public GetPurchaseOrderList perchaseorderList(int suppId) {
		
	 
		GetPurchaseOrderList getPurchaseOrderList=new GetPurchaseOrderList();
		ErrorMessage errorMessage=new   ErrorMessage();
		try
		{
			
			List<PurchaseOrderHeader> purchaseOrderHeaderList =purchaseOrderHeaderRepository.findBySuppId(suppId);
			 
			getPurchaseOrderList.setPurchaseOrderHeaderList(purchaseOrderHeaderList);
			
		
			
			if(purchaseOrderHeaderList!=null)
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Successfully");
			}
			else
			{
				errorMessage.setError(true);
				errorMessage.setMessage("UnSuccessfully");
			}
			 
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			errorMessage.setError(true);
			errorMessage.setMessage(" failed");
			getPurchaseOrderList.setErrorMessage(errorMessage);
		}
		return getPurchaseOrderList;
		
		
		
		
	}


	@Override
	public PurchaseOrderDetailedList purchaseOrderDetailedList(int poId) {
		
		PurchaseOrderDetailedList purchaseOrderDetailed = new PurchaseOrderDetailedList();
		ErrorMessage errorMessage=new ErrorMessage();
		try
		{
			List<PurchaseOrderDetail> purchaseOrderDetaillist = purchaseOrderDetailRepository.purchaseOrderDetaillist(poId);
			purchaseOrderDetailed.setPurchaseOrderDetaillist(purchaseOrderDetaillist);
			errorMessage.setError(false);
			errorMessage.setMessage("success");
			purchaseOrderDetailed.setErrorMessage(errorMessage);
			System.out.println("LIst in nService :"+purchaseOrderDetailed.toString() );
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			errorMessage.setError(true);
			errorMessage.setMessage("unsuccess");
			purchaseOrderDetailed.setErrorMessage(errorMessage);
		}
		return purchaseOrderDetailed;
		
	}

 
	

}
