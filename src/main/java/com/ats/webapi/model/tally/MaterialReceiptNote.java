package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MaterialReceiptNote implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mrn_detail_id")
	private int mrnDetailId;

	@Column(name="mrn_id")
	private int mrnId;
	
	@Column(name="mrn_no")
	private String mrnNo;
	
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="supp_name")
	private String supplierName;
	
	@Column(name="inv_book_date")
	private Date invoiceBookDate;
	
	@Column(name="invoice_number")
	private String invoiceNumber;
	
	@Column(name="inv_date")
	private Date invoiceDate;
	
	@Column(name="basic_value")
	private float basicValue;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_uom")
	private String rmUom;
	
	@Column(name="recd_qty")
	private int recdQty;
	
	@Column(name="po_rate")
	private float poRate;
	
	@Column(name="value")
	private float value;
	
	@Column(name="gst_per")
	private float gstPer;
	
	
	@Column(name="item_cgst_per")
	private float itemCgstPer;
	
	@Column(name="item_cgst_rs")
	private float itemCgstRs;

	@Column(name="item_sgst_per")
	private float itemSgstPer;
	
	@Column(name="item_sgst_rs")
	private float itemSgstRs;
	
	@Column(name="item_igst_per")
	private float itemIgstPer;
	
	@Column(name="item_igst_rs")
	private float itemIgstRs;
	
	@Column(name="item_cess_per")
	private float itemCessPer;
	
	@Column(name="item_cess_rs")
	private float itemCessRs;
	
	@Column(name="extra_disc_amt_on_item")
	private float extraDiscountAmtOnItem;
	
	@Column(name="extra_disc_amt_on_bill")
	private float extraDiscountAmtOnBill;
	
	@Column(name="extra_charges_on_item")
	private float extraChargesOnItem;
	
	@Column(name="extra_charges_on_bill")
	private float extraChargesOnBill;
	
	@Column(name="amount")
	private float itemTotalamount;
	
	@Column(name="total_extra_disc_amt_on_item")
	private float totalExtraDiscountAmtOnItem;
	
	@Column(name="total_extra_disc_amt_on_bill")
	private float totalExtraDiscountAmtOnBill;
	
	@Column(name="total_extra_charges_on_item")
	private float totalExtraChargesOnItem;
	
	@Column(name="total_extra_charges_on_bill")
	private float totalExtraChargesOnBill;
	
	@Column(name="cgst")
	private float cgst;
	
	@Column(name="sgst")
	private float sgst;
	
	@Column(name="igst")
	private float igst;
	
	@Column(name="cess")
	private float cess;
	
	@Column(name="disc_per")
	private float discPer;
	
	@Column(name="disc_amt")
	private float discAmt;
	
	@Column(name="disc_amt2")
	private float discAmt2;
	
	@Column(name="freight_amt")
	private float freightAmt;

	@Column(name="insurance_amt")
	private float insurance_amt;
	
	@Column(name="round_off")
	private float roundOff;
	
	@Column(name="bill_amount")
	private float billAmount;

	
	@Column(name="is_tally_sync")
	private int isTallySync;

	public int getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(int mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Date getInvoiceBookDate() {
		return invoiceBookDate;
	}

	public void setInvoiceBookDate(Date invoiceBookDate) {
		this.invoiceBookDate = invoiceBookDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public float getBasicValue() {
		return basicValue;
	}

	public void setBasicValue(float basicValue) {
		this.basicValue = basicValue;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public String getRmUom() {
		return rmUom;
	}

	public void setRmUom(String rmUom) {
		this.rmUom = rmUom;
	}

	public int getRecdQty() {
		return recdQty;
	}

	public void setRecdQty(int recdQty) {
		this.recdQty = recdQty;
	}

	public float getPoRate() {
		return poRate;
	}

	public void setPoRate(float poRate) {
		this.poRate = poRate;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getDiscAmt2() {
		return discAmt2;
	}

	public void setDiscAmt2(float discAmt2) {
		this.discAmt2 = discAmt2;
	}

	public float getGstPer() {
		return gstPer;
	}

	public void setGstPer(float gstPer) {
		this.gstPer = gstPer;
	}

	public float getFreightAmt() {
		return freightAmt;
	}

	public void setFreightAmt(float freightAmt) {
		this.freightAmt = freightAmt;
	}

	public float getInsurance_amt() {
		return insurance_amt;
	}

	public void setInsurance_amt(float insurance_amt) {
		this.insurance_amt = insurance_amt;
	}

	public float getItemCgstPer() {
		return itemCgstPer;
	}

	public void setItemCgstPer(float itemCgstPer) {
		this.itemCgstPer = itemCgstPer;
	}

	public float getItemCgstRs() {
		return itemCgstRs;
	}

	public void setItemCgstRs(float itemCgstRs) {
		this.itemCgstRs = itemCgstRs;
	}

	public float getItemSgstPer() {
		return itemSgstPer;
	}

	public void setItemSgstPer(float itemSgstPer) {
		this.itemSgstPer = itemSgstPer;
	}

	public float getItemSgstRs() {
		return itemSgstRs;
	}

	public void setItemSgstRs(float itemSgstRs) {
		this.itemSgstRs = itemSgstRs;
	}

	public float getItemIgstPer() {
		return itemIgstPer;
	}

	public void setItemIgstPer(float itemIgstPer) {
		this.itemIgstPer = itemIgstPer;
	}

	public float getItemIgstRs() {
		return itemIgstRs;
	}

	public void setItemIgstRs(float itemIgstRs) {
		this.itemIgstRs = itemIgstRs;
	}

	public float getItemCessPer() {
		return itemCessPer;
	}

	public void setItemCessPer(float itemCessPer) {
		this.itemCessPer = itemCessPer;
	}

	public float getItemCessRs() {
		return itemCessRs;
	}

	public void setItemCessRs(float itemCessRs) {
		this.itemCessRs = itemCessRs;
	}

	public float getItemTotalamount() {
		return itemTotalamount;
	}

	public void setItemTotalamount(float itemTotalamount) {
		this.itemTotalamount = itemTotalamount;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getCess() {
		return cess;
	}

	public void setCess(float cess) {
		this.cess = cess;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}
    
	public float getExtraDiscountAmtOnItem() {
		return extraDiscountAmtOnItem;
	}

	public void setExtraDiscountAmtOnItem(float extraDiscountAmtOnItem) {
		this.extraDiscountAmtOnItem = extraDiscountAmtOnItem;
	}

	public float getExtraDiscountAmtOnBill() {
		return extraDiscountAmtOnBill;
	}

	public void setExtraDiscountAmtOnBill(float extraDiscountAmtOnBill) {
		this.extraDiscountAmtOnBill = extraDiscountAmtOnBill;
	}

	public float getExtraChargesOnItem() {
		return extraChargesOnItem;
	}

	public void setExtraChargesOnItem(float extraChargesOnItem) {
		this.extraChargesOnItem = extraChargesOnItem;
	}

	public float getExtraChargesOnBill() {
		return extraChargesOnBill;
	}

	public void setExtraChargesOnBill(float extraChargesOnBill) {
		this.extraChargesOnBill = extraChargesOnBill;
	}

	public float getTotalExtraDiscountAmtOnItem() {
		return totalExtraDiscountAmtOnItem;
	}

	public void setTotalExtraDiscountAmtOnItem(float totalExtraDiscountAmtOnItem) {
		this.totalExtraDiscountAmtOnItem = totalExtraDiscountAmtOnItem;
	}

	public float getTotalExtraDiscountAmtOnBill() {
		return totalExtraDiscountAmtOnBill;
	}

	public void setTotalExtraDiscountAmtOnBill(float totalExtraDiscountAmtOnBill) {
		this.totalExtraDiscountAmtOnBill = totalExtraDiscountAmtOnBill;
	}

	public float getTotalExtraChargesOnItem() {
		return totalExtraChargesOnItem;
	}

	public void setTotalExtraChargesOnItem(float totalExtraChargesOnItem) {
		this.totalExtraChargesOnItem = totalExtraChargesOnItem;
	}

	public float getTotalExtraChargesOnBill() {
		return totalExtraChargesOnBill;
	}

	public void setTotalExtraChargesOnBill(float totalExtraChargesOnBill) {
		this.totalExtraChargesOnBill = totalExtraChargesOnBill;
	}

	@Override
	public String toString() {
		return "MaterialReceiptNote [mrnDetailId=" + mrnDetailId + ", mrnId=" + mrnId + ", mrnNo=" + mrnNo
				+ ", supplierId=" + supplierId + ", supplierName=" + supplierName + ", invoiceBookDate="
				+ invoiceBookDate + ", invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate
				+ ", basicValue=" + basicValue + ", rmId=" + rmId + ", rmName=" + rmName + ", rmUom=" + rmUom
				+ ", recdQty=" + recdQty + ", poRate=" + poRate + ", value=" + value + ", gstPer=" + gstPer
				+ ", itemCgstPer=" + itemCgstPer + ", itemCgstRs=" + itemCgstRs + ", itemSgstPer=" + itemSgstPer
				+ ", itemSgstRs=" + itemSgstRs + ", itemIgstPer=" + itemIgstPer + ", itemIgstRs=" + itemIgstRs
				+ ", itemCessPer=" + itemCessPer + ", itemCessRs=" + itemCessRs + ", extraDiscountAmtOnItem="
				+ extraDiscountAmtOnItem + ", extraDiscountAmtOnBill=" + extraDiscountAmtOnBill
				+ ", extraChargesOnItem=" + extraChargesOnItem + ", extraChargesOnBill=" + extraChargesOnBill
				+ ", itemTotalamount=" + itemTotalamount + ", totalExtraDiscountAmtOnItem="
				+ totalExtraDiscountAmtOnItem + ", totalExtraDiscountAmtOnBill=" + totalExtraDiscountAmtOnBill
				+ ", totalExtraChargesOnItem=" + totalExtraChargesOnItem + ", totalExtraChargesOnBill="
				+ totalExtraChargesOnBill + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", cess=" + cess
				+ ", discPer=" + discPer + ", discAmt=" + discAmt + ", discAmt2=" + discAmt2 + ", freightAmt="
				+ freightAmt + ", insurance_amt=" + insurance_amt + ", roundOff=" + roundOff + ", billAmount="
				+ billAmount + ", isTallySync=" + isTallySync + "]";
	}

	
}
