package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetSpCkOrderAlbum {
 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_order_no")
	private int spOrderNo;

	
	@Column(name="fr_name") 
	private String frName;
	
	@Column(name="fr_mob") 
	private String frMob;
	
	@Column(name="sp_name") 
	private String spName;
	
	@Column(name="order_date") 
	private Date orderDate;
	
	@Column(name="sp_price")
	private float spPrice;
	
	@Column(name="sp_selected_weight")
	private float spSelectedWeight;
	
	
	@Column(name="sp_instructions") 
	private String spInstructions;
	
	@Column(name="sp_sub_total")
	private float spSubTotal;
	
	@Column(name="sp_advance")
	private float spAdvance;
	
	@Column(name="rm_amount")
	private float rmAmount;
	
	@Column(name="sp_delivery_date")
	private Date spDeliveryDate;
	
	private String itemId;
	
	@Column(name="sp_delivery_place") 
	private String spDeliveryPlace;
	
	@Column(name="sp_cust_name") 
	private String spCustName;
	
	private String spEvents;
	
	private String spEventsName;
	
	@Column(name="sp_cust_mob_no") 
	private String spCustMobNo;

	
	@Column(name="spf_name") 
	private String spfName;

	@Column(name="order_photo")
	 private String cusChoicePhoto;
	
	@Column(name="order_photo2")
	 private String orderPhoto;
	
	private String albumPhoto1;
	private String albumPhoto2;

	
	
	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getSpEvents() {
		return spEvents;
	}


	public void setSpEvents(String spEvents) {
		this.spEvents = spEvents;
	}


	public String getSpEventsName() {
		return spEventsName;
	}


	public void setSpEventsName(String spEventsName) {
		this.spEventsName = spEventsName;
	}


	public int getSpOrderNo() {
		return spOrderNo;
	}


	public void setSpOrderNo(int spOrderNo) {
		this.spOrderNo = spOrderNo;
	}


	public String getFrName() {
		return frName;
	}


	public void setFrName(String frName) {
		this.frName = frName;
	}


	public String getFrMob() {
		return frMob;
	}


	public void setFrMob(String frMob) {
		this.frMob = frMob;
	}


	public String getSpName() {
		return spName;
	}


	public void setSpName(String spName) {
		this.spName = spName;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public float getSpPrice() {
		return spPrice;
	}


	public void setSpPrice(float spPrice) {
		this.spPrice = spPrice;
	}


	public String getSpInstructions() {
		return spInstructions;
	}


	public void setSpInstructions(String spInstructions) {
		this.spInstructions = spInstructions;
	}


	public float getSpSubTotal() {
		return spSubTotal;
	}


	public void setSpSubTotal(float spSubTotal) {
		this.spSubTotal = spSubTotal;
	}


	public float getSpAdvance() {
		return spAdvance;
	}


	public void setSpAdvance(float spAdvance) {
		this.spAdvance = spAdvance;
	}


	public float getRmAmount() {
		return rmAmount;
	}


	public void setRmAmount(float rmAmount) {
		this.rmAmount = rmAmount;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpDeliveryDate() {
		return spDeliveryDate;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setSpDeliveryDate(Date spDeliveryDate) {
		this.spDeliveryDate = spDeliveryDate;
	}


	public String getSpDeliveryPlace() {
		return spDeliveryPlace;
	}


	public void setSpDeliveryPlace(String spDeliveryPlace) {
		this.spDeliveryPlace = spDeliveryPlace;
	}


	public String getSpCustName() {
		return spCustName;
	}


	public void setSpCustName(String spCustName) {
		this.spCustName = spCustName;
	}


	public String getSpCustMobNo() {
		return spCustMobNo;
	}


	public void setSpCustMobNo(String spCustMobNo) {
		this.spCustMobNo = spCustMobNo;
	}


	public String getSpfName() {
		return spfName;
	}


	public void setSpfName(String spfName) {
		this.spfName = spfName;
	}


	public float getSpSelectedWeight() {
		return spSelectedWeight;
	}


	public void setSpSelectedWeight(float spSelectedWeight) {
		this.spSelectedWeight = spSelectedWeight;
	}


	public String getCusChoicePhoto() {
		return cusChoicePhoto;
	}


	public void setCusChoicePhoto(String cusChoicePhoto) {
		this.cusChoicePhoto = cusChoicePhoto;
	}


	public String getOrderPhoto() {
		return orderPhoto;
	}


	public void setOrderPhoto(String orderPhoto) {
		this.orderPhoto = orderPhoto;
	}


	public String getAlbumPhoto1() {
		return albumPhoto1;
	}


	public void setAlbumPhoto1(String albumPhoto1) {
		this.albumPhoto1 = albumPhoto1;
	}


	public String getAlbumPhoto2() {
		return albumPhoto2;
	}


	public void setAlbumPhoto2(String albumPhoto2) {
		this.albumPhoto2 = albumPhoto2;
	}


	@Override
	public String toString() {
		return "GetSpCkOrderAlbum [spOrderNo=" + spOrderNo + ", frName=" + frName + ", frMob=" + frMob + ", spName="
				+ spName + ", orderDate=" + orderDate + ", spPrice=" + spPrice + ", spSelectedWeight="
				+ spSelectedWeight + ", spInstructions=" + spInstructions + ", spSubTotal=" + spSubTotal
				+ ", spAdvance=" + spAdvance + ", rmAmount=" + rmAmount + ", spDeliveryDate=" + spDeliveryDate
				+ ", itemId=" + itemId + ", spDeliveryPlace=" + spDeliveryPlace + ", spCustName=" + spCustName
				+ ", spEvents=" + spEvents + ", spEventsName=" + spEventsName + ", spCustMobNo=" + spCustMobNo
				+ ", spfName=" + spfName + ", cusChoicePhoto=" + cusChoicePhoto + ", orderPhoto=" + orderPhoto
				+ ", albumPhoto1=" + albumPhoto1 + ", albumPhoto2=" + albumPhoto2 + "]";
	}


}
	

	