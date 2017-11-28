package com.ats.webapi.service.purchaseorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetail;
import com.ats.webapi.model.purchaseorder.PurchaseOrderHeader;
import com.ats.webapi.model.purchaseorder.TransporterDetails;
import com.ats.webapi.repository.PurchaseOrderDetailRepository;
import com.ats.webapi.repository.PurchaseOrderHeaderRepository;

@Service
public class PurchaseOrderServiceImlp implements PurchaseOrderService{

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

 
	

}
