package com.ats.webapi.model.prodapp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_sp_cake_sup")
public class TSpCakeSup {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="t_sp_cake_sup_no")
	private int tSpCakeSupNo;
	
	private int tSpCakeOrderNo;
	
	private float inputKgProd;
	
	private float inputKgFr;
	
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	
	
	private Long startTimeStamp;
	private Long endTimeStamp;
	
	private int status;
	
	private Date date;
	
	private int frId;
	
	private int spCakeId;
	
	private int status2;
	
	private int srNo;
	private int mistryId;
	private String mistryName;
	private int menuId;
	private String isCharUsed;

	public String getIsCharUsed() {
		return isCharUsed;
	}

	public void setIsCharUsed(String isCharUsed) {
		this.isCharUsed = isCharUsed;
	}

	private String exVar;
	private int exInt;
	private int delStatus;
	
	

	public int gettSpCakeSupNo() {
		return tSpCakeSupNo;
	}

	public void settSpCakeSupNo(int tSpCakeSupNo) {
		this.tSpCakeSupNo = tSpCakeSupNo;
	}

	public int gettSpCakeOrderNo() {
		return tSpCakeOrderNo;
	}

	public void settSpCakeOrderNo(int tSpCakeOrderNo) {
		this.tSpCakeOrderNo = tSpCakeOrderNo;
	}

	public float getInputKgProd() {
		return inputKgProd;
	}

	public void setInputKgProd(float inputKgProd) {
		this.inputKgProd = inputKgProd;
	}

	public float getInputKgFr() {
		return inputKgFr;
	}

	public void setInputKgFr(float inputKgFr) {
		this.inputKgFr = inputKgFr;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public String getPhoto4() {
		return photo4;
	}

	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}

	

	public Long getStartTimeStamp() {
		return startTimeStamp;
	}

	public void setStartTimeStamp(Long startTimeStamp) {
		this.startTimeStamp = startTimeStamp;
	}

	public Long getEndTimeStamp() {
		return endTimeStamp;
	}

	public void setEndTimeStamp(Long endTimeStamp) {
		this.endTimeStamp = endTimeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getSpCakeId() {
		return spCakeId;
	}

	public void setSpCakeId(int spCakeId) {
		this.spCakeId = spCakeId;
	}

	public int getStatus2() {
		return status2;
	}

	public void setStatus2(int status2) {
		this.status2 = status2;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public int getMistryId() {
		return mistryId;
	}

	public void setMistryId(int mistryId) {
		this.mistryId = mistryId;
	}

	public String getMistryName() {
		return mistryName;
	}

	public void setMistryName(String mistryName) {
		this.mistryName = mistryName;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getExVar() {
		return exVar;
	}

	public void setExVar(String exVar) {
		this.exVar = exVar;
	}

	public int getExInt() {
		return exInt;
	}

	public void setExInt(int exInt) {
		this.exInt = exInt;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "TSpCakeSup [tSpCakeSupNo=" + tSpCakeSupNo + ", tSpCakeOrderNo=" + tSpCakeOrderNo + ", inputKgProd="
				+ inputKgProd + ", inputKgFr=" + inputKgFr + ", photo1=" + photo1 + ", photo2=" + photo2 + ", photo3="
				+ photo3 + ", photo4=" + photo4 + ", startTimeStamp=" + startTimeStamp + ", endTimeStamp="
				+ endTimeStamp + ", status=" + status + ", date=" + date + ", frId=" + frId + ", spCakeId=" + spCakeId
				+ ", status2=" + status2 + ", srNo=" + srNo + ", mistryId=" + mistryId + ", mistryName=" + mistryName
				+ ", menuId=" + menuId + ", isCharUsed=" + isCharUsed + ", exVar=" + exVar + ", exInt=" + exInt
				+ ", delStatus=" + delStatus + "]";
	}


}
