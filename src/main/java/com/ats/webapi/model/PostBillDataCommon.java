package com.ats.webapi.model;

import java.util.Date;
import java.util.List;

public class PostBillDataCommon {
	
	
	List<PostBillHeader> postBillHeadersList;
	
	List<PostBillDetail> postBillDetailsList;

	public List<PostBillHeader> getPostBillHeadersList() {
		return postBillHeadersList;
	}

	public void setPostBillHeadersList(List<PostBillHeader> postBillHeadersList) {
		this.postBillHeadersList = postBillHeadersList;
	}

	public List<PostBillDetail> getPostBillDetailsList() {
		return postBillDetailsList;
	}

	public void setPostBillDetailsList(List<PostBillDetail> postBillDetailsList) {
		this.postBillDetailsList = postBillDetailsList;
	}

	@Override
	public String toString() {
		return "PostBillDataCommon [postBillHeadersList=" + postBillHeadersList + ", postBillDetailsList="
				+ postBillDetailsList + "]";
	}
	
	
	








	



	
	
	

}
