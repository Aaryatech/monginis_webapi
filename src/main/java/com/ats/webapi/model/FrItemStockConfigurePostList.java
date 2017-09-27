package com.ats.webapi.model;

import java.util.List;

public class FrItemStockConfigurePostList {
	
	List<FrItemStockConfigurePost> frItemStockConfigurePosts;
	Info info;
	public List<FrItemStockConfigurePost> getFrItemStockConfigurePosts() {
		return frItemStockConfigurePosts;
	}
	public void setFrItemStockConfigurePosts(List<FrItemStockConfigurePost> frItemStockConfigurePosts) {
		this.frItemStockConfigurePosts = frItemStockConfigurePosts;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "FrItemStockConfigurePostList [frItemStockConfigurePosts=" + frItemStockConfigurePosts + ", info=" + info
				+ "]";
	}
	
	

}
