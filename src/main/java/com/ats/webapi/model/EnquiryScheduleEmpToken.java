package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EnquiryScheduleEmpToken {

	@Id
	private int empId;
	private String token1;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getToken1() {
		return token1;
	}

	public void setToken1(String token1) {
		this.token1 = token1;
	}

	@Override
	public String toString() {
		return "EnquiryScheduleEmpToken [empId=" + empId + ", token1=" + token1 + "]";
	}

}
