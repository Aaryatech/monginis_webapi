package com.ats.webapi.model;

import java.util.List;

public class SellBillDetailList {
	
List<SellBillDetails> sellBillDetailList;
ErrorMessage errorMessage;

public List<SellBillDetails> getSellBillDetailList() {
	return sellBillDetailList;
}
public void setSellBillDetailList(List<SellBillDetails> sellBillDetailList) {
	this.sellBillDetailList = sellBillDetailList;
}
public ErrorMessage getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(ErrorMessage errorMessage) {
	this.errorMessage = errorMessage;
}
      
}
