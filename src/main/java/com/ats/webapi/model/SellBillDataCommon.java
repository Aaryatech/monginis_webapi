package com.ats.webapi.model;

import java.util.List;

public class SellBillDataCommon {
List<SellBillHeader> sellBillHeaderList;

public List<SellBillHeader> getSellBillHeaderList() {
	return sellBillHeaderList;
}

public void setSellBillHeaderList(List<SellBillHeader> sellBillHeaderList) {
	this.sellBillHeaderList = sellBillHeaderList;
}

@Override
public String toString() {
	return "SellBillDataCommon [sellBillHeaderList=" + sellBillHeaderList + "]";
}

}
