package com.ats.webapi.model.prodapp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_reg_sp_cake_sup")
public class TRegSpCakeSup {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sup_id")
	private int supId;
	
	private int tRegSupOrderId;
	
	private int itemId;
	private int frId;
	private int catId;
	private int subCatId;
	
	private int menuId;
	
	
	
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	private String photo1;
	private String photo2;
	private String photo3;
	
	private Long startTime;
	private Long endTime;
	
	private int status;
	
	private Date prodDate;
	
	
	private int srNo;
	private int mistryId;
	private String mistryName;
	
	private String isCharUsed;
	
	private int exChar;
	private int exInt;
	
	private float inputKgProd;
	
	
	
	public float getInputKgProd() {
		return inputKgProd;
	}
	public void setInputKgProd(float inputKgProd) {
		this.inputKgProd = inputKgProd;
	}
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public int gettRegSupOrderId() {
		return tRegSupOrderId;
	}
	public void settRegSupOrderId(int tRegSupOrderId) {
		this.tRegSupOrderId = tRegSupOrderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
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
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getProdDate() {
		return prodDate;
	}
	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
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
	public String getIsCharUsed() {
		return isCharUsed;
	}
	public void setIsCharUsed(String isCharUsed) {
		this.isCharUsed = isCharUsed;
	}
	public int getExChar() {
		return exChar;
	}
	public void setExChar(int exChar) {
		this.exChar = exChar;
	}
	public int getExInt() {
		return exInt;
	}
	public void setExInt(int exInt) {
		this.exInt = exInt;
	}
	
	@Override
	public String toString() {
		return "TRegSpCakeSup [supId=" + supId + ", tRegSupOrderId=" + tRegSupOrderId + ", itemId=" + itemId + ", frId="
				+ frId + ", catId=" + catId + ", subCatId=" + subCatId + ", menuId=" + menuId + ", photo1=" + photo1
				+ ", photo2=" + photo2 + ", photo3=" + photo3 + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", status=" + status + ", prodDate=" + prodDate + ", srNo=" + srNo + ", mistryId=" + mistryId
				+ ", mistryName=" + mistryName + ", isCharUsed=" + isCharUsed + ", exChar=" + exChar + ", exInt="
				+ exInt + ", inputKgProd=" + inputKgProd + "]";
	}
	
	
}
