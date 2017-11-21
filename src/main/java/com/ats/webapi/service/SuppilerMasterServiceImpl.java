package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.SupplierMaster.SupplierDetails;
import com.ats.webapi.repository.SupplierDetailRepository;

@Service
public class SuppilerMasterServiceImpl implements SuppilerMasterService{

	@Autowired
	SupplierDetailRepository supplierDetailRepository;
	
	@Override
	public SupplierDetails addSuppler(SupplierDetails supplierDetails) {
		
		SupplierDetails supplier=supplierDetailRepository.save(supplierDetails);
		return supplier;
	}

}
