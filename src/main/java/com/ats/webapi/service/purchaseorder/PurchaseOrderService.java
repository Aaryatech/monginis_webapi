package com.ats.webapi.service.purchaseorder;

import java.util.List;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.purchaseorder.GetPurchaseOrder;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetail;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetailedList;
import com.ats.webapi.model.purchaseorder.PurchaseOrderHeader;
import com.ats.webapi.model.purchaseorder.TransporterDetails;

public interface PurchaseOrderService {

	Info insertHeader(PurchaseOrderHeader purchaseOrderHeader);

	

	GetPurchaseOrder perchaseorderList(int suppId);
	PurchaseOrderDetailedList purchaseOrderDetailedList(int poId);

 
 

}
