package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GenerateBill;
import com.ats.webapi.model.GenerateBillList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GenerateBillRepository;

@Service
public class GenerateBillServiceImpl implements GenerateBillService {
	
	@Autowired
	GenerateBillRepository billRepository;

	@Override
	public GenerateBillList generateBillService(List<String> frId,List<String> menuId, String delDate) {
	
		GenerateBillList generateBillList=new GenerateBillList();
		
		List<GenerateBill> generateBills=billRepository.generateBill(frId, menuId, delDate);
		
		Info info=new Info();
		
		
		if(generateBills!=null) {
			
			generateBillList.setGenerateBills(generateBills);
			
			info.setError(false);
			info.setMessage("Success in bill generation for selected Franchisees");
			
			generateBillList.setInfo(info);
			
			
		}
		else {
			
			info.setError(true);
			info.setMessage("failed to generate bill");
			
			generateBillList.setInfo(info);
		}
		
		
		
		
		
		return generateBillList;
	}

	@Override
	public GenerateBillList generateBillServiceForAllFr(List<String> menuId, String delDate) {
		
GenerateBillList generateBillList=new GenerateBillList();
		
		List<GenerateBill> generateBills=billRepository.generateBillForAllFr(menuId, delDate);
		
		Info info=new Info();
		
		
		if(generateBills!=null) {
			
			generateBillList.setGenerateBills(generateBills);
			
			info.setError(false);
			info.setMessage("Success in bill generation for All Fr");
			
			generateBillList.setInfo(info);
			
			
		}
		else {
			
			info.setError(true);
			info.setMessage("failed to generate bill");
			
			generateBillList.setInfo(info);
		}
		
		
	return generateBillList;
	}

	@Override
	public GenerateBillList generateBillForAllFrAllMenu(String delDate) {
		
		GenerateBillList generateBillList=new GenerateBillList();
		
		List<GenerateBill> generateBills=billRepository.generateBillForAllFrAllMenu(delDate);
		
		Info info=new Info();
		
		
		if(generateBills!=null) {
			
			generateBillList.setGenerateBills(generateBills);
			
			info.setError(false);
			info.setMessage("Success in bill generation for All Fr All Menu");
			
			generateBillList.setInfo(info);
			
			
		}
		else {
			
			info.setError(true);
			info.setMessage("failed to generate bill");
			
			generateBillList.setInfo(info);
		}
		
		
	return generateBillList;
		
	
	}

	@Override
	public GenerateBillList generateBillForAllMenu(List<String> frId, String delDate) {
		
GenerateBillList generateBillList=new GenerateBillList();
		
		List<GenerateBill> generateBills=billRepository.generateBillForAllMenu(frId, delDate);
		
		Info info=new Info();
		
		
		if(generateBills!=null) {
			
			generateBillList.setGenerateBills(generateBills);
			
			info.setError(false);
			info.setMessage("Success in bill generation for All Fr All Menu and selected Franchisee");
			
			generateBillList.setInfo(info);
			
			
		}
		else {
			
			info.setError(true);
			info.setMessage("failed to generate bill");
			
			generateBillList.setInfo(info);
		}
		
		
	return generateBillList;
	
	}
	

}
