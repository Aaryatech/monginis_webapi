package com.ats.webapi.model.prodapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DashSpCakeCount {
	
	@Id
	private int status;
	
	private int spOrderCount;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSpOrderCount() {
		return spOrderCount;
	}

	public void setSpOrderCount(int spOrderCount) {
		this.spOrderCount = spOrderCount;
	}

	@Override
	public String toString() {
		return "DashSpCakeCount [status=" + status + ", spOrderCount=" + spOrderCount + "]";
	}


}
