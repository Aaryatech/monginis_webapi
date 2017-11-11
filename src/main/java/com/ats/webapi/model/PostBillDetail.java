package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_bill_detail")
public class PostBillDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_no")
	private int billDetailNo;
		
	@Column(name="bill_no")
	private int billNo;
	
	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="order_qty")
	private int orderQty;
	
	@Column(name="bill_qty")
	private int billQty;
	
	@Column(name="order_id")
	private int orderId;
	
	
	@Column(name="rate_type")
	private int rateType;
	
	@Column(name="rate")
	private float rate;
	
	@Column(name="mrp")
	private float mrp;
	
	@Column(name="grand_total")
	private float grandTotal;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="sgst_rs")
	private float sgstRs;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="cgst_rs")
	private float cgstRs;
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="igst_rs")
	private float igstRs;
	
	@Column(name="base_rate")
	private float baseRate;
	
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="total_tax")
	private float totalTax;
	
	
	@Column(name="del_status")
	private int delStatus;

	@Column(name="grn_type")//new added
	private int grnType;
	
	
	@Column(name="expiry_date")//new added
	private Date expiryDate;
	
	@Column(name="is_grngvn_applied")//new added
	private int  isGrngvnApplied;
	
	
	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public int getBillQty() {
		return billQty;
	}

	public void setBillQty(int billQty) {
		this.billQty = billQty;
	}

	public int getRateType() {
		return rateType;
	}

	public void setRateType(int rateType) {
		this.rateType = rateType;
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

	
	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	
	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(float baseRate) {
		this.baseRate = baseRate;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public int getIsGrngvnApplied() {
		return isGrngvnApplied;
	}

	public void setIsGrngvnApplied(int isGrngvnApplied) {
		this.isGrngvnApplied = isGrngvnApplied;
	}

	@Override
	public String toString() {
		return "PostBillDetail [billDetailNo=" + billDetailNo + ", billNo=" + billNo + ", menuId=" + menuId + ", catId="
				+ catId + ", itemId=" + itemId + ", orderQty=" + orderQty + ", billQty=" + billQty + ", orderId="
				+ orderId + ", rateType=" + rateType + ", rate=" + rate + ", mrp=" + mrp + ", grandTotal=" + grandTotal
				+ ", sgstPer=" + sgstPer + ", sgstRs=" + sgstRs + ", cgstPer=" + cgstPer + ", cgstRs=" + cgstRs
				+ ", igstPer=" + igstPer + ", igstRs=" + igstRs + ", baseRate=" + baseRate + ", taxableAmt="
				+ taxableAmt + ", remark=" + remark + ", totalTax=" + totalTax + ", delStatus=" + delStatus
				+ ", grnType=" + grnType + ", expiryDate=" + expiryDate + ", isGrngvnApplied=" + isGrngvnApplied + "]";
	}

	
	
	
}
