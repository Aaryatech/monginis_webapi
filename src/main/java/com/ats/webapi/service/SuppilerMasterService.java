package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.SupplierMaster.SupplierDetails;

public interface SuppilerMasterService {
	
	SupplierDetails addSuppler(SupplierDetails supplierDetails);

	SupplierDetails getSupplier(int suppId);

	int deleteSupplier(int suppId);

	List<SupplierDetails> getAllSupplier();
}
