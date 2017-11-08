package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.report.GetRepFrDatewiseSell;
import com.ats.webapi.model.report.GetRepItemwiseSell;
import com.ats.webapi.model.report.GetRepMonthwiseSell;
import com.ats.webapi.model.report.GetRepTaxSell;
import com.ats.webapi.repository.RepFrDatewiseSellRepository;
import com.ats.webapi.repository.RepFrItemwiseSellRepository;
import com.ats.webapi.repository.RepFrMonthwiseSellRepository;
import com.ats.webapi.repository.RepTaxSellRepository;

@Service
public class RepFrSellServiseImpl implements RepFrSellServise{

	@Autowired
	RepFrDatewiseSellRepository repFrDateSellRepository;
	@Autowired
	RepFrMonthwiseSellRepository repFrMonthwiseSellRepository;
	@Autowired
	RepFrItemwiseSellRepository repFrItemwiseSellRepository;
	@Autowired
	RepTaxSellRepository repTaxSellRepository;
	@Override
	public List<GetRepFrDatewiseSell> getDatewiseSellReport(String fromDate, String toDate,  List<String> frId) {
		
		List<GetRepFrDatewiseSell> repFrDatewiseSellServiseList=repFrDateSellRepository.getRepFrDatewiseSell(fromDate, toDate, frId);
		
		return repFrDatewiseSellServiseList;
	}
	@Override
	public List<GetRepMonthwiseSell> getMonthwiseSellReport(String fromDate, String toDate, List<String> frId) {
List<GetRepMonthwiseSell> repFrMonthwiseSellServiseList=repFrMonthwiseSellRepository.getRepFrMonthwiseSell(fromDate, toDate, frId);
		
		return repFrMonthwiseSellServiseList;
	}
	@Override
	public List<GetRepItemwiseSell> getItemwiseSellReport(String fromDate, String toDate, List<String> frId,
			List<String> catId) {

List<GetRepItemwiseSell> getRepItemwiseSellList=repFrItemwiseSellRepository.getRepFrItemwiseSell(fromDate, toDate, frId, catId);
		
		return getRepItemwiseSellList;
	}
	@Override
	public List<GetRepItemwiseSell> getDateItemwiseSellReport(String fromDate, String toDate, List<String> frId,
			List<String> catId) {
List<GetRepItemwiseSell> getRepItemwiseSellList=repFrItemwiseSellRepository.getRepFrDateItemwiseSell(fromDate, toDate, frId, catId);
		
		return getRepItemwiseSellList;
	}
	@Override
	public List<GetRepTaxSell> getTaxSellReport(String fromDate, String toDate, List<String> frId) {
		 
		List<GetRepTaxSell> getRepTaxSellList=repTaxSellRepository.getRepFrTaxSell(fromDate, toDate, frId);
		
		return getRepTaxSellList;
	}
	@Override
	public List<GetRepTaxSell> getDatewiseTaxSellReport(String fromDate, String toDate, List<String> frId) {
		List<GetRepTaxSell> getRepTaxSellList=repTaxSellRepository.getRepFrDatewiseTaxSell(fromDate, toDate, frId);
		
		return getRepTaxSellList;
	}
	@Override
	public List<GetRepTaxSell> getBillwiseTaxSellReport(String fromDate, String toDate, List<String> frId) {
		List<GetRepTaxSell> getRepTaxSellList=repTaxSellRepository.getRepFrBillwiseTaxSell(fromDate, toDate, frId);
		
		return getRepTaxSellList;
	}

	

}
