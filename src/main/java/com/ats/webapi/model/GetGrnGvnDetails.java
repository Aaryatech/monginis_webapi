package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetGrnGvnDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_gvn_id")
	int grnGvnId;

	@Column(name = "grn_gvn_date")
	Date grnGvnDate;
	

	@Column(name = "bill_no")
	private int billNo;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_rate")
	private float itemRate;
	
	@Column(name = "item_mrp")
	private float itemMrp;

	@Column(name = "grn_gvn_qty")
	private int grnGvnQty;

	@Column(name = "grn_gvn_amt")
	private float grnGvnAmt;

	@Column(name = "grn_type")
	private int grnType;
	
	@Column(name = "is_grn")
	private int isGrn;
	
	@Column(name = "is_grn_edit")
	private int isGrnEdit;
	
	@Column(name = "grn_gvn_entry_datetime")
	private String grnGvnEntryDateTime;

	@Column(name = "fr_grn_gvn_remark")
	private String frGrnGvnRemark;

	@Column(name = "gvn_photo_upload1")
	private String gvnPhotoUpload1;

	@Column(name = "gvn_photo_upload2")
	private String gvnPhotoUpload2;

	@Column(name = "grn_gvn_status")
	private int grnGvnStatus;

	@Column(name = "approved_login_gate")
	private int approvedLoginGate;

	@Column(name = "approved_datetime_gate")
	private String approveimedDateTimeGate;

	@Column(name = "approved_remark_gate")
	private String approvedRemarkGate;

	@Column(name = "approved_login_store")
	private int approvedLoginStore;

	@Column(name = "approved_datetime_store")
	private String approvedDateTimeStore;

	@Column(name = "approved_remark_store")
	private String approvedRemarkStore;

	@Column(name = "approved_login_acc")
	private int approvedLoginAcc;

	@Column(name = "approved_datetime_acc")
	private String grnApprovedDateTimeAcc;

	@Column(name = "approved_remark_acc")
	private String approvedRemarkAcc;
	

	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "grn_gvn_qty_auto")
	private int grnGvnQtyAuto;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "fr_name")
	private String frName;
	
	//newly Added
	
	@Column(name = "is_tally_sync")
	private int isTallySync;
	
	
	@Column(name = "base_rate")
	private float baseRate;
	
	@Column(name = "sgst_per")
	private float sgstPer;
	
	@Column(name = "cgst_per")
	private float cgstPer;
	
	@Column(name = "igst_per")
	private float igstPer;
	
	@Column(name = "taxable_amt")
	private float taxableAmt;
	
	@Column(name = "total_tax")
	private float totalTax;
	
	
	
	@Column(name = "round_up_amt")
	private float roundUpAmt;
	
	@Column(name = "final_amt")
	private float finalAmt;
	

	public int getGrnGvnId() {
		return grnGvnId;
	}

	public void setGrnGvnId(int grnGvnId) {
		this.grnGvnId = grnGvnId;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGrnGvnDate() {
		return grnGvnDate;
	}

	public void setGrnGvnDate(Date grnGvnDate) {
		this.grnGvnDate = grnGvnDate;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getItemRate() {
		return itemRate;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}

	public float getItemMrp() {
		return itemMrp;
	}

	public void setItemMrp(float itemMrp) {
		this.itemMrp = itemMrp;
	}

	public int getGrnGvnQty() {
		return grnGvnQty;
	}

	public void setGrnGvnQty(int grnGvnQty) {
		this.grnGvnQty = grnGvnQty;
	}

	public float getGrnGvnAmt() {
		return grnGvnAmt;
	}

	public void setGrnGvnAmt(float grnGvnAmt) {
		this.grnGvnAmt = grnGvnAmt;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	public int getIsGrn() {
		return isGrn;
	}

	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}

	public int getIsGrnEdit() {
		return isGrnEdit;
	}

	public void setIsGrnEdit(int isGrnEdit) {
		this.isGrnEdit = isGrnEdit;
	}

	public String getGrnGvnEntryDateTime() {
		return grnGvnEntryDateTime;
	}

	public void setGrnGvnEntryDateTime(String grnGvnEntryDateTime) {
		this.grnGvnEntryDateTime = grnGvnEntryDateTime;
	}

	public String getFrGrnGvnRemark() {
		return frGrnGvnRemark;
	}

	public void setFrGrnGvnRemark(String frGrnGvnRemark) {
		this.frGrnGvnRemark = frGrnGvnRemark;
	}

	public String getGvnPhotoUpload1() {
		return gvnPhotoUpload1;
	}

	public void setGvnPhotoUpload1(String gvnPhotoUpload1) {
		this.gvnPhotoUpload1 = gvnPhotoUpload1;
	}

	public String getGvnPhotoUpload2() {
		return gvnPhotoUpload2;
	}

	public void setGvnPhotoUpload2(String gvnPhotoUpload2) {
		this.gvnPhotoUpload2 = gvnPhotoUpload2;
	}

	public int getGrnGvnStatus() {
		return grnGvnStatus;
	}

	public void setGrnGvnStatus(int grnGvnStatus) {
		this.grnGvnStatus = grnGvnStatus;
	}

	public int getApprovedLoginGate() {
		return approvedLoginGate;
	}

	public void setApprovedLoginGate(int approvedLoginGate) {
		this.approvedLoginGate = approvedLoginGate;
	}

	public String getApproveimedDateTimeGate() {
		return approveimedDateTimeGate;
	}

	public void setApproveimedDateTimeGate(String approveimedDateTimeGate) {
		this.approveimedDateTimeGate = approveimedDateTimeGate;
	}

	public String getApprovedRemarkGate() {
		return approvedRemarkGate;
	}

	public void setApprovedRemarkGate(String approvedRemarkGate) {
		this.approvedRemarkGate = approvedRemarkGate;
	}

	public int getApprovedLoginStore() {
		return approvedLoginStore;
	}

	public void setApprovedLoginStore(int approvedLoginStore) {
		this.approvedLoginStore = approvedLoginStore;
	}

	public String getApprovedDateTimeStore() {
		return approvedDateTimeStore;
	}

	public void setApprovedDateTimeStore(String approvedDateTimeStore) {
		this.approvedDateTimeStore = approvedDateTimeStore;
	}

	public String getApprovedRemarkStore() {
		return approvedRemarkStore;
	}

	public void setApprovedRemarkStore(String approvedRemarkStore) {
		this.approvedRemarkStore = approvedRemarkStore;
	}

	public int getApprovedLoginAcc() {
		return approvedLoginAcc;
	}

	public void setApprovedLoginAcc(int approvedLoginAcc) {
		this.approvedLoginAcc = approvedLoginAcc;
	}

	public String getGrnApprovedDateTimeAcc() {
		return grnApprovedDateTimeAcc;
	}

	public void setGrnApprovedDateTimeAcc(String grnApprovedDateTimeAcc) {
		this.grnApprovedDateTimeAcc = grnApprovedDateTimeAcc;
	}

	public String getApprovedRemarkAcc() {
		return approvedRemarkAcc;
	}

	public void setApprovedRemarkAcc(String approvedRemarkAcc) {
		this.approvedRemarkAcc = approvedRemarkAcc;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getGrnGvnQtyAuto() {
		return grnGvnQtyAuto;
	}

	public void setGrnGvnQtyAuto(int grnGvnQtyAuto) {
		this.grnGvnQtyAuto = grnGvnQtyAuto;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	public float getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(float baseRate) {
		this.baseRate = baseRate;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public float getRoundUpAmt() {
		return roundUpAmt;
	}

	public void setRoundUpAmt(float roundUpAmt) {
		this.roundUpAmt = roundUpAmt;
	}

	public float getFinalAmt() {
		return finalAmt;
	}

	public void setFinalAmt(float finalAmt) {
		this.finalAmt = finalAmt;
	}

	@Override
	public String toString() {
		return "GetGrnGvnDetails [grnGvnId=" + grnGvnId + ", grnGvnDate=" + grnGvnDate + ", billNo=" + billNo
				+ ", frId=" + frId + ", itemId=" + itemId + ", itemRate=" + itemRate + ", itemMrp=" + itemMrp
				+ ", grnGvnQty=" + grnGvnQty + ", grnGvnAmt=" + grnGvnAmt + ", grnType=" + grnType + ", isGrn=" + isGrn
				+ ", isGrnEdit=" + isGrnEdit + ", grnGvnEntryDateTime=" + grnGvnEntryDateTime + ", frGrnGvnRemark="
				+ frGrnGvnRemark + ", gvnPhotoUpload1=" + gvnPhotoUpload1 + ", gvnPhotoUpload2=" + gvnPhotoUpload2
				+ ", grnGvnStatus=" + grnGvnStatus + ", approvedLoginGate=" + approvedLoginGate
				+ ", approveimedDateTimeGate=" + approveimedDateTimeGate + ", approvedRemarkGate=" + approvedRemarkGate
				+ ", approvedLoginStore=" + approvedLoginStore + ", approvedDateTimeStore=" + approvedDateTimeStore
				+ ", approvedRemarkStore=" + approvedRemarkStore + ", approvedLoginAcc=" + approvedLoginAcc
				+ ", grnApprovedDateTimeAcc=" + grnApprovedDateTimeAcc + ", approvedRemarkAcc=" + approvedRemarkAcc
				+ ", delStatus=" + delStatus + ", grnGvnQtyAuto=" + grnGvnQtyAuto + ", itemName=" + itemName
				+ ", frName=" + frName + ", isTallySync=" + isTallySync + ", baseRate=" + baseRate + ", sgstPer="
				+ sgstPer + ", cgstPer=" + cgstPer + ", igstPer=" + igstPer + ", taxableAmt=" + taxableAmt
				+ ", totalTax=" + totalTax + ", roundUpAmt=" + roundUpAmt + ", finalAmt=" + finalAmt + "]";
	}

	

}
