package com.ats.webapi.service;

import java.util.List;

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

	@Override
	public SupplierDetails getSupplier(int suppId) {
		 
		
		SupplierDetails supplierDetails=supplierDetailRepository.findBySuppId(suppId);
		return supplierDetails;
	}

	@Override
	public int deleteSupplier(int suppId) {

		int result=supplierDetailRepository.deleteSupplier(suppId);
		return result;
	}

	@Override
	public List<SupplierDetails> getAllSupplier() {
		
		int delStatus=0;
		List<SupplierDetails> supplierDetailsList=supplierDetailRepository.findByDelStatus(delStatus);
		return supplierDetailsList;
	}

}
