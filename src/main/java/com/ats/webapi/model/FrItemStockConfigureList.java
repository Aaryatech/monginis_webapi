package com.ats.webapi.model;

import java.util.List;

public class FrItemStockConfigureList {
	List<FrItemStockConfigure> frItemStockConfigure;
	Info info;
	public List<FrItemStockConfigure> getFrItemStockConfigure() {
		return frItemStockConfigure;
	}
	public void setFrItemStockConfigure(List<FrItemStockConfigure> frItemStockConfigure) {
		this.frItemStockConfigure = frItemStockConfigure;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "FrItemStockConfigureList [frItemStockConfigure=" + frItemStockConfigure + ", info=" + info + "]";
	}
	
	
	
	

}
