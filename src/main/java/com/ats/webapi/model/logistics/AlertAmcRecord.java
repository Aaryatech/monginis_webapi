package com.ats.webapi.model.logistics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class AlertAmcRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="amc_id")
	private int amcId;
	
	@Column(name="mech_id")
	private int mechId;
	
	@Column(name="mech_name")
	private String mechName;
	
	@Column(name="dealer_id")
	private int dealerId;
	
	@Column(name="dealer_name")
	private String dealerName;
	
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="amc_from_date")
	private Date amcFromDate;
	
	@Column(name="amc_to_date")
	private Date amcToDate;
	
	@Column(name="amc_alert_date")
	private Date amcAlertDate;
	
	@Column(name="remaining_day")
	private int remainingDay;

	public int getAmcId() {
		return amcId;
	}

	public void setAmcId(int amcId) {
		this.amcId = amcId;
	}

	public int getMechId() {
		return mechId;
	}

	public void setMechId(int mechId) {
		this.mechId = mechId;
	}

	public String getMechName() {
		return mechName;
	}

	public void setMechName(String mechName) {
		this.mechName = mechName;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAmcFromDate() {
		return amcFromDate;
	}

	public void setAmcFromDate(Date amcFromDate) {
		this.amcFromDate = amcFromDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAmcToDate() {
		return amcToDate;
	}

	public void setAmcToDate(Date amcToDate) {
		this.amcToDate = amcToDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAmcAlertDate() {
		return amcAlertDate;
	}

	public void setAmcAlertDate(Date amcAlertDate) {
		this.amcAlertDate = amcAlertDate;
	}

	public int getRemainingDay() {
		return remainingDay;
	}

	public void setRemainingDay(int remainingDay) {
		this.remainingDay = remainingDay;
	}

	@Override
	public String toString() {
		return "AlertAmcRecord [amcId=" + amcId + ", mechId=" + mechId + ", mechName=" + mechName + ", dealerId="
				+ dealerId + ", dealerName=" + dealerName + ", typeId=" + typeId + ", amcFromDate=" + amcFromDate
				+ ", amcToDate=" + amcToDate + ", amcAlertDate=" + amcAlertDate + ", remainingDay=" + remainingDay
				+ "]";
	}
	
	

}
