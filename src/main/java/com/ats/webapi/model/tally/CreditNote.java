package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CreditNote implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="crnd_id")
	private int crndId;
	
	@Column(name="crn_no")
	private String crnNo;

	@Column(name="crn_id")
	private String vNo;
	
	@Column(name="crn_date")
	private Date date;
	
	@Transient
	private String vType;
	
	@Column(name="fr_name")
	private String partyName;
	
	@Column(name="fr_gst_no")
	private String gstin;
	
	@Column(name="fr_state")
	private String state;

	@Column(name="item_name")
	private String itemName;
	
	@Column(name="hsn_code")
	private String hsnCode;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="grn_gvn_qty")
	private int qty;
	
	@Column(name="base_rate")
	private float rate;
	
	@Column(name="taxable_amt")
	private float amount;

	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="cess_per")
	private float cessPer;
	
	@Column(name="cgst_rs")
	private float cgstRs;
	
	@Column(name="sgst_rs")
	private float sgstRs;
	
	@Column(name="igst_rs")
	private float igstRs;
	
	@Column(name="cess_rs")
	private float cessRs;
	
	@Transient
	private float itemDiscPer;
	
	@Transient 
	private float totalDisc;
	
	@Column(name="round_off")
	private float roundOff;
	
	@Transient
	private float totalAmt;
	
	@Column(name="crn_final_amt")
	private float billTotal;
	
	
	@Column(name="ref_invoice_no")
	private String refBillNo;
	
	@Column(name="ref_invoice_date")
	private Date refBillDate;
	
	@Column(name="grn_gvn_id")
	private String crDbNo;
	
	@Column(name="grn_gvn_date")
	private String crDbDate;
	
	/*@Column(name="remark")
	private String remark;*/
	
	@PostLoad
	public void onLoad() {
		this.vType="Credit Note";
		this.itemDiscPer=0.0f;
		this.totalDisc=0.0f;
		this.totalAmt=amount+cgstRs+sgstRs+cessRs;
	
	}

	public int getCrndId() {
		return crndId;
	}

	public void setCrndId(int crndId) {
		this.crndId = crndId;
	}

	public String getvNo() {
		return vNo;
	}

	public void setvNo(String vNo) {
		this.vNo = vNo;
	}

	
	public String getCrnNo() {
		return crnNo;
	}

	public void setCrnNo(String crnNo) {
		this.crnNo = crnNo;
	}
    @JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getCessRs() {
		return cessRs;
	}

	public void setCessRs(float cessRs) {
		this.cessRs = cessRs;
	}

	public float getItemDiscPer() {
		return itemDiscPer;
	}

	public void setItemDiscPer(float itemDiscPer) {
		this.itemDiscPer = itemDiscPer;
	}

	public float getTotalDisc() {
		return totalDisc;
	}

	public void setTotalDisc(float totalDisc) {
		this.totalDisc = totalDisc;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public float getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}

	
    public String getRefBillNo() {
		return refBillNo;
	}

	public void setRefBillNo(String refBillNo) {
		this.refBillNo = refBillNo;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRefBillDate() {
		return refBillDate;
	}

	public void setRefBillDate(Date refBillDate) {
		this.refBillDate = refBillDate;
	}

	public String getCrDbNo() {
		return crDbNo;
	}

	public void setCrDbNo(String crDbNo) {
		this.crDbNo = crDbNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public String getCrDbDate() {
		return crDbDate;
	}

	public void setCrDbDate(String crDbDate) {
		this.crDbDate = crDbDate;
	}

	/*public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}*/

	@Override
	public String toString() {
		return "CreditNote [crndId=" + crndId + ", vNo=" + vNo + ", date=" + date + ", vType=" + vType + ", partyName="
				+ partyName + ", gstin=" + gstin + ", state=" + state + ", itemName=" + itemName + ", hsnCode="
				+ hsnCode + ", uom=" + uom + ", qty=" + qty + ", rate=" + rate + ", amount=" + amount + ", cgstPer="
				+ cgstPer + ", sgstPer=" + sgstPer + ", igstPer=" + igstPer + ", cessPer=" + cessPer + ", cgstRs="
				+ cgstRs + ", sgstRs=" + sgstRs + ", igstRs=" + igstRs + ", cessRs=" + cessRs + ", itemDiscPer="
				+ itemDiscPer + ", totalDisc=" + totalDisc + ", roundOff=" + roundOff + ", totalAmt=" + totalAmt
				+ ", billTotal=" + billTotal + ", refBillNo=" + refBillNo + ", refBillDate=" + refBillDate + ", crDbNo="
				+ crDbNo + ", crDbDate=" + crDbDate +  "]";
	}
	
	
	
}
