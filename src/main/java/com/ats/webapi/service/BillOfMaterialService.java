package com.ats.webapi.service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.bom.BillOfMaterialHeader;
import com.ats.webapi.model.bom.GetBillOfMaterialList;

public interface BillOfMaterialService{
	
	GetBillOfMaterialList getBillOfMaterialithDate(String frmdate, String todate);

	BillOfMaterialHeader gettBomdetaildwithId(int reqId);

	/*ErrorMessage updatestatus(int reqId);*/

}
