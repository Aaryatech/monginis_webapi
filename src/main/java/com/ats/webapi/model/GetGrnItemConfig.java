package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetGrnItemConfig implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_no")
	private int billDetailNo;
	
		
	@Column(name="item_id")
	private int  itemId;
	
	@Column(name="id")
	private int  id;
	

	@Column(name="item_name")
	private String itemName;
	
	@Column(name="grn_type")
	private int grnType;
	
	@Column(name="bill_no")
	private int billNo;
	

	@Column(name="rate")
	private float rate;
	
	@Column(name="mrp")
	private float mrp;
	
	@Column(name="bill_qty")
	private float billQty;

	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public float getBillQty() {
		return billQty;
	}

	public void setBillQty(float billQty) {
		this.billQty = billQty;
	}
	
	

	
	
	
	

}
