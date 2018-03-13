package com.ats.webapi.model.grngvn;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_credit_note_header")
public class PostCreditNoteHeader implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crn_id")
	private int crnId;

	// newly added
	@Column(name = "crn_no")
	private String crnNo;

	@Column(name = "crn_date")
	private Date crnDate;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "crn_taxable_amt")
	private float crnTaxableAmt;

	@Column(name = "crn_total_tax")
	private float crnTotalTax;

	@Column(name = "crn_grand_total")
	private float crnGrandTotal;

	@Column(name = "crn_final_amt")
	private float crnFinalAmt;

	@Column(name = "round_off")
	private float roundOff;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "created_date_time")
	private String createdDateTime;

	@Column(name = "is_tally_sync")
	private int isTallySync;
	
	@Column(name = "is_grn")
	private int isGrn;


	@Transient
	List<PostCreditNoteDetails> postCreditNoteDetails;

	// new field 23 FEB
	@Column(name = "grn_gvn_sr_no_list")
	String grnGvnSrNoList;// comma seperated unique;

	// new field 23 FEB
	@Column(name = "is_deposited")
	int isDeposited; // default 0 when actually deposited in bank set value

	public int getCrnId() {
		return crnId;
	}

	public void setCrnId(int crnId) {
		this.crnId = crnId;
	}

	public Date getCrnDate() {
		return crnDate;
	}

	public void setCrnDate(Date crnDate) {
		this.crnDate = crnDate;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public float getCrnTaxableAmt() {
		return crnTaxableAmt;
	}

	public void setCrnTaxableAmt(float crnTaxableAmt) {
		this.crnTaxableAmt = crnTaxableAmt;
	}

	public float getCrnTotalTax() {
		return crnTotalTax;
	}

	public void setCrnTotalTax(float crnTotalTax) {
		this.crnTotalTax = crnTotalTax;
	}

	public float getCrnGrandTotal() {
		return crnGrandTotal;
	}

	public void setCrnGrandTotal(float crnGrandTotal) {
		this.crnGrandTotal = crnGrandTotal;
	}

	public float getCrnFinalAmt() {
		return crnFinalAmt;
	}

	public void setCrnFinalAmt(float crnFinalAmt) {
		this.crnFinalAmt = crnFinalAmt;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	public List<PostCreditNoteDetails> getPostCreditNoteDetails() {
		return postCreditNoteDetails;
	}

	public void setPostCreditNoteDetails(List<PostCreditNoteDetails> postCreditNoteDetails) {
		this.postCreditNoteDetails = postCreditNoteDetails;
	}

	public String getCrnNo() {
		return crnNo;
	}

	public void setCrnNo(String crnNo) {
		this.crnNo = crnNo;
	}

	public String getGrnGvnSrNoList() {
		return grnGvnSrNoList;
	}

	public void setGrnGvnSrNoList(String grnGvnSrNoList) {
		this.grnGvnSrNoList = grnGvnSrNoList;
	}

	public int getIsDeposited() {
		return isDeposited;
	}

	public void setIsDeposited(int isDeposited) {
		this.isDeposited = isDeposited;
	}

	public int getIsGrn() {
		return isGrn;
	}

	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}

	@Override
	public String toString() {
		return "PostCreditNoteHeader [crnId=" + crnId + ", crnNo=" + crnNo + ", crnDate=" + crnDate + ", frId=" + frId
				+ ", crnTaxableAmt=" + crnTaxableAmt + ", crnTotalTax=" + crnTotalTax + ", crnGrandTotal="
				+ crnGrandTotal + ", crnFinalAmt=" + crnFinalAmt + ", roundOff=" + roundOff + ", userId=" + userId
				+ ", createdDateTime=" + createdDateTime + ", isTallySync=" + isTallySync + ", isGrn=" + isGrn
				+ ", postCreditNoteDetails=" + postCreditNoteDetails + ", grnGvnSrNoList=" + grnGvnSrNoList
				+ ", isDeposited=" + isDeposited + "]";
	}

}
