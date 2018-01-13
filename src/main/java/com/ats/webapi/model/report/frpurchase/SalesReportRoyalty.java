package com.ats.webapi.model.report.frpurchase;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class SalesReportRoyalty implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="item_name")
	private String item_name;
	
	@Column(name="cat_name")
	private String cat_name;
	
	float tBillQty;
	float tBillTaxableAmt;
	float tGrnQty;
	float tGrnTaxableAmt;
	float tGvnQty;
	float tGvnTaxableAmt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public float gettBillQty() {
		return tBillQty;
	}
	public void settBillQty(float tBillQty) {
		this.tBillQty = tBillQty;
	}
	public float gettBillTaxableAmt() {
		return tBillTaxableAmt;
	}
	public void settBillTaxableAmt(float tBillTaxableAmt) {
		this.tBillTaxableAmt = tBillTaxableAmt;
	}
	public float gettGrnQty() {
		return tGrnQty;
	}
	public void settGrnQty(float tGrnQty) {
		this.tGrnQty = tGrnQty;
	}
	public float gettGrnTaxableAmt() {
		return tGrnTaxableAmt;
	}
	public void settGrnTaxableAmt(float tGrnTaxableAmt) {
		this.tGrnTaxableAmt = tGrnTaxableAmt;
	}
	public float gettGvnQty() {
		return tGvnQty;
	}
	public void settGvnQty(float tGvnQty) {
		this.tGvnQty = tGvnQty;
	}
	public float gettGvnTaxableAmt() {
		return tGvnTaxableAmt;
	}
	public void settGvnTaxableAmt(float tGvnTaxableAmt) {
		this.tGvnTaxableAmt = tGvnTaxableAmt;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	@Override
	public String toString() {
		return "SalesReportRoyalty [id=" + id + ", catId=" + catId + ", item_name=" + item_name + ", cat_name="
				+ cat_name + ", tBillQty=" + tBillQty + ", tBillTaxableAmt=" + tBillTaxableAmt + ", tGrnQty=" + tGrnQty
				+ ", tGrnTaxableAmt=" + tGrnTaxableAmt + ", tGvnQty=" + tGvnQty + ", tGvnTaxableAmt=" + tGvnTaxableAmt
				+ "]";
	}
	

}

