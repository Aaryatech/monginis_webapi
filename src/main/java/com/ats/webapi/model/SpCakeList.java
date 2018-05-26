package com.ats.webapi.model;

import java.util.List;

public class SpCakeList {
	
	String status;
	List<SpecialCake> specialCake;
	
	 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<SpecialCake> getSpecialCake() {
		return specialCake;
	}
	public void setSpecialCake(List<SpecialCake> specialCake) {
		this.specialCake = specialCake;
	}
	@Override
	public String toString() {
		return "SpCakeList [status=" + status + ", specialCake=" + specialCake + "]";
	}
	
}



