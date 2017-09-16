package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_franchisee")
public class Franchisee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fr_id")
	private int frId;
    
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="fr_code")
	private String frCode;
	
	@Column(name="fr_opening_date")
	private Date frOpeningDate;

	@Column(name="fr_rate")
	private int frRate;
		
	@Column(name="fr_image")
	String frImage;
	
	@Column(name="fr_route_id")
	private int frRouteId;
	
	@Column(name="fr_city")
	String frCity;

	@Column(name="kg_1")
	private int frKg1;
	
	@Column(name="kg_2")
	private int frKg2;
	
	@Column(name="kg_3")
	private int frKg3;
	
	@Column(name="kg_4")
	private int frKg4;
	
	@Column(name="fr_email")
	String frEmail;

	@Column(name="fr_password")
	String frPassword;

	@Column(name="fr_mob")
	String frMob;
	
	@Column(name="fr_owner")
	String frOwner;

	@Column(name="fr_rate_cat")
	private 	int frRateCat;
	
	@Column(name="grn_two")
	private int grnTwo;
	
	@Column(name="del_status")
	private int delStatus;

	@Column(name="fr_rmn_1")
	private String frRmn1;
	
	@Column(name="show_items")
	private String showItems;
	
	@Column(name="not_show_items")
	private String notShowItems;
	
	@Column(name="fr_opening")
	private int frOpening;

	public String getFrRmn1() {
		return frRmn1;
	}

	public void setFrRmn1(String frRmn1) {
		this.frRmn1 = frRmn1;
	}

	public String getShowItems() {
		return showItems;
	}

	public void setShowItems(String showItems) {
		this.showItems = showItems;
	}

	public String getNotShowItems() {
		return notShowItems;
	}

	public void setNotShowItems(String notShowItems) {
		this.notShowItems = notShowItems;
	}

	public int getFrOpening() {
		return frOpening;
	}

	public void setFrOpening(int frOpening) {
		this.frOpening = frOpening;
	}

	public String getFrPasswordKey() {
		return frPasswordKey;
	}

	public void setFrPasswordKey(String frPasswordKey) {
		this.frPasswordKey = frPasswordKey;
	}

	public int getIsSameDayApplicable() {
		return isSameDayApplicable;
	}

	public void setIsSameDayApplicable(int isSameDayApplicable) {
		this.isSameDayApplicable = isSameDayApplicable;
	}

	@Column(name="fr_password_key")
	private String frPasswordKey;
	
	@Column(name="is_same_day_applicable")
	private int isSameDayApplicable;
	
	
	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getFrOpeningDate() {
		return frOpeningDate;
	}

	public void setFrOpeningDate(Date frOpeningDate) {
		this.frOpeningDate = frOpeningDate;
	}

	public int getFrRate() {
		return frRate;
	}

	public void setFrRate(int frRate) {
		this.frRate = frRate;
	}

	public String getFrImage() {
		return frImage;
	}

	public void setFrImage(String frImage) {
		this.frImage = frImage;
	}

	public int getFrRouteId() {
		return frRouteId;
	}

	public void setFrRouteId(int frRouteId) {
		this.frRouteId = frRouteId;
	}

	public String getFrCity() {
		return frCity;
	}

	public void setFrCity(String frCity) {
		this.frCity = frCity;
	}

	public int getFrKg1() {
		return frKg1;
	}

	public void setFrKg1(int frKg1) {
		this.frKg1 = frKg1;
	}

	public int getFrKg2() {
		return frKg2;
	}

	public void setFrKg2(int frKg2) {
		this.frKg2 = frKg2;
	}

	public int getFrKg3() {
		return frKg3;
	}

	public void setFrKg3(int frKg3) {
		this.frKg3 = frKg3;
	}

	public int getFrKg4() {
		return frKg4;
	}

	public void setFrKg4(int frKg4) {
		this.frKg4 = frKg4;
	}

	public String getFrEmail() {
		return frEmail;
	}

	public void setFrEmail(String frEmail) {
		this.frEmail = frEmail;
	}

	public String getFrPassword() {
		return frPassword;
	}

	public void setFrPassword(String frPassword) {
		this.frPassword = frPassword;
	}

	public String getFrMob() {
		return frMob;
	}

	public void setFrMob(String frMob) {
		this.frMob = frMob;
	}

	public String getFrOwner() {
		return frOwner;
	}

	public void setFrOwner(String frOwner) {
		this.frOwner = frOwner;
	}

	public int getFrRateCat() {
		return frRateCat;
	}

	public void setFrRateCat(int frRateCat) {
		this.frRateCat = frRateCat;
	}

	public int getGrnTwo() {
		return grnTwo;
	}

	public void setGrnTwo(int grnTwo) {
		this.grnTwo = grnTwo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Franchisee [frId=" + frId + ", frName=" + frName + ", frCode=" + frCode + ", frOpeningDate="
				+ frOpeningDate + ", frRate=" + frRate + ", frImage=" + frImage + ", frRouteId=" + frRouteId
				+ ", frCity=" + frCity + ", frKg1=" + frKg1 + ", frKg2=" + frKg2 + ", frKg3=" + frKg3 + ", frKg4="
				+ frKg4 + ", frEmail=" + frEmail + ", frPassword=" + frPassword + ", frMob=" + frMob + ", frOwner="
				+ frOwner + ", frRateCat=" + frRateCat + ", grnTwo=" + grnTwo + ", delStatus=" + delStatus + ", frRmn1="
				+ frRmn1 + ", showItems=" + showItems + ", notShowItems=" + notShowItems + ", frOpening=" + frOpening
				+ ", frPasswordKey=" + frPasswordKey + ", isSameDayApplicable=" + isSameDayApplicable + "]";
	}

	
	
}
