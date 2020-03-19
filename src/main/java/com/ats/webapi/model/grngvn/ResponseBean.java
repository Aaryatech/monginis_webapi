package com.ats.webapi.model.grngvn;

import java.util.List;

import com.ats.webapi.model.GetGrnGvnDetails;

public class ResponseBean {

	
	List<GHeader> ggHeaderList;
	List<GetGrnGvnDetails> ggDetailList;
	
	public List<GHeader> getGgHeaderList() {
		return ggHeaderList;
	}
	public void setGgHeaderList(List<GHeader> ggHeaderList) {
		this.ggHeaderList = ggHeaderList;
	}
	public List<GetGrnGvnDetails> getGgDetailList() {
		return ggDetailList;
	}
	public void setGgDetailList(List<GetGrnGvnDetails> ggDetailList) {
		this.ggDetailList = ggDetailList;
	}
	
	
	
}
