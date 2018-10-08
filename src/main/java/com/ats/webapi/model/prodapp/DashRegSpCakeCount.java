package com.ats.webapi.model.prodapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DashRegSpCakeCount {
	
	@Id
	private int status;
	
	private int regSpOrderCount;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRegSpOrderCount() {
		return regSpOrderCount;
	}

	public void setRegSpOrderCount(int regSpOrderCount) {
		this.regSpOrderCount = regSpOrderCount;
	}

	@Override
	public String toString() {
		return "DashRegSpCakeCount [status=" + status + ", regSpOrderCount=" + regSpOrderCount + "]";
	}

}
