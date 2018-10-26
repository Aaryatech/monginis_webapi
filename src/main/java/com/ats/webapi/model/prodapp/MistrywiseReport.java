package com.ats.webapi.model.prodapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

//report no 3 and 4  on both table
@Entity
public class MistrywiseReport {
	
	@Id
	private int mistryId;
	
	private String empName;
	
	private int noOfCakes;
	
	private float timeRequired;
	
	private Date prodDate;
	
	

	public int getMistryId() {
		return mistryId;
	}

	public Date getProdDate() {
		return prodDate;
	}

	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}

	public void setMistryId(int mistryId) {
		this.mistryId = mistryId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getNoOfCakes() {
		return noOfCakes;
	}

	public void setNoOfCakes(int noOfCakes) {
		this.noOfCakes = noOfCakes;
	}

	public float getTimeRequired() {
		return timeRequired;
	}

	public void setTimeRequired(float timeRequired) {
		this.timeRequired = timeRequired;
	}

	@Override
	public String toString() {
		return "MistrywiseReport [mistryId=" + mistryId + ", empName=" + empName + ", noOfCakes=" + noOfCakes
				+ ", timeRequired=" + timeRequired + ", prodDate=" + prodDate + "]";
	}
	
	

}
