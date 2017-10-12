package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.SellBillHeader;

public interface SellBillDataService {

	List<SellBillHeader> saveSellBillHeader(List<SellBillHeader> sellBillHeaderList);

}
