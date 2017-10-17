package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity(name="spCakeOrdersBean")
//bean to be changed frId inserted 
@Immutable
public class SpCakeOrdersBean implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_order_no")
	private int spOrderNo;

	@Column(name="sp_code")//m_sp_cake
	private String spCode;
	
	@Column(name="sp_name")//m_sp_cake
	private String spName;
	
	//@Column(name="sp_flavour")
	private String spfName;
	
	//@Column(name="sp_events")
	private String spEvents;
	
	@Column(name="sp_delivery_date")
	private Date spDeliveryDate;
	
	//@Column(name="sp_price")
	private String spPrice;
	
	@Column(name="sp_total_add_rate")
	private String spTotalAddRate;
	
	
	@Column(name="fr_name")//franchisee table
	private String frName;
	
	

	@Column(name="item_id")
	private String itemId;



	public int getSpOrderNo() {
		return spOrderNo;
	}



	public void setSpOrderNo(int spOrderNo) {
		this.spOrderNo = spOrderNo;
	}



	public String getSpCode() {
		return spCode;
	}



	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}



	public String getSpName() {
		return spName;
	}



	public void setSpName(String spName) {
		this.spName = spName;
	}



	public String getSpfName() {
		return spfName;
	}



	public void setSpfName(String spfName) {
		this.spfName = spfName;
	}



	public String getSpEvents() {
		return spEvents;
	}



	public void setSpEvents(String spEvents) {
		this.spEvents = spEvents;
	}



	public Date getSpDeliveryDate() {
		return spDeliveryDate;
	}



	public void setSpDeliveryDate(Date spDeliveryDate) {
		this.spDeliveryDate = spDeliveryDate;
	}



	public String getSpPrice() {
		return spPrice;
	}



	public void setSpPrice(String spPrice) {
		this.spPrice = spPrice;
	}



	public String getSpTotalAddRate() {
		return spTotalAddRate;
	}



	public void setSpTotalAddRate(String spTotalAddRate) {
		this.spTotalAddRate = spTotalAddRate;
	}



	public String getFrName() {
		return frName;
	}



	public void setFrName(String frName) {
		this.frName = frName;
	}



	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	

	
	

}
