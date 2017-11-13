package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.report.GetRepFrDatewiseSell;
import com.ats.webapi.model.report.GetRepItemwiseSell;
import com.ats.webapi.model.report.GetRepMenuwiseSell;
import com.ats.webapi.model.report.GetRepMonthwiseSell;
import com.ats.webapi.model.report.GetRepTaxSell;

public interface RepFrSellServise {
	
	List<GetRepFrDatewiseSell> getDatewiseSellReport(String fromDate, String toDate,  List<String> frId);
	List<GetRepMonthwiseSell> getMonthwiseSellReport(String fromDate, String toDate,  List<String> frId);
	List<GetRepItemwiseSell> getItemwiseSellReport(String fromDate, String toDate,  List<String> frId, List<String> catId);
	List<GetRepItemwiseSell> getDateItemwiseSellReport(String fromDate, String toDate, List<String> frId,
			List<String> catId);
	List<GetRepTaxSell> getTaxSellReport(String fromDate, String toDate, List<String> frId);
	List<GetRepTaxSell> getDatewiseTaxSellReport(String fromDate, String toDate, List<String> frId);
	List<GetRepTaxSell> getBillwiseTaxSellReport(String fromDate, String toDate, List<String> frId);
	List<GetRepMenuwiseSell> getMenuwiseSellReport(String fromDate, String toDate, List<String> frId);
	List<GetRepItemwiseSell> getDateCatwiseSellReport(String fromDate, String toDate, List<String> frId,
			List<String> catId);

}
