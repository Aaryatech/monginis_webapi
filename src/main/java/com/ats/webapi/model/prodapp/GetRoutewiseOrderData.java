package com.ats.webapi.model.prodapp;

import java.util.List;

import com.ats.webapi.model.prodapp.temp.RegSpOrd;
import com.ats.webapi.model.prodapp.temp.SpOrder;

public class GetRoutewiseOrderData {
	
	private String frName;
	private String frCode;
	private int frId;
	private int routeId;

	List<RegSpOrd> regSpCakeOrdList ;
	List<SpOrder> spCakeOrdList ;
	
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public List<RegSpOrd> getRegSpCakeOrdList() {
		return regSpCakeOrdList;
	}
	public void setRegSpCakeOrdList(List<RegSpOrd> regSpCakeOrdList) {
		this.regSpCakeOrdList = regSpCakeOrdList;
	}
	public List<SpOrder> getSpCakeOrdList() {
		return spCakeOrdList;
	}
	public void setSpCakeOrdList(List<SpOrder> spCakeOrdList) {
		this.spCakeOrdList = spCakeOrdList;
	}
	
	@Override
	public String toString() {
		return "GetRoutewiseOrderData [frName=" + frName + ", frCode=" + frCode + ", frId=" + frId + ", routeId="
				+ routeId + ", regSpCakeOrdList=" + regSpCakeOrdList + ", spCakeOrdList=" + spCakeOrdList + "]";
	}
	
	
}
