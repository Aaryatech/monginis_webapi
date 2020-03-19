package com.ats.webapi.model.grngvnreport;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GGHeaderApr {
	
	@Id
	private int grnGvnHeaderId;//

	private String grngvnSrno;//

	private Date grngvnDate;//

	private int frId;//

	private String frName;//

	private int isGrn;
	private float totalAmt;
	private float aprGrandTotal;
	private int grngvnStatus;
	
	private String approvedDatetime;
	
	
	@Transient
	List<GGDetailApr> ggDetailList;


	public int getGrnGvnHeaderId() {
		return grnGvnHeaderId;
	}


	public void setGrnGvnHeaderId(int grnGvnHeaderId) {
		this.grnGvnHeaderId = grnGvnHeaderId;
	}


	public String getGrngvnSrno() {
		return grngvnSrno;
	}


	public void setGrngvnSrno(String grngvnSrno) {
		this.grngvnSrno = grngvnSrno;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGrngvnDate() {
		return grngvnDate;
	}


	public void setGrngvnDate(Date grngvnDate) {
		this.grngvnDate = grngvnDate;
	}


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


	public int getIsGrn() {
		return isGrn;
	}


	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}


	public float getTotalAmt() {
		return totalAmt;
	}


	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}


	public float getAprGrandTotal() {
		return aprGrandTotal;
	}


	public void setAprGrandTotal(float aprGrandTotal) {
		this.aprGrandTotal = aprGrandTotal;
	}


	public int getGrngvnStatus() {
		return grngvnStatus;
	}


	public void setGrngvnStatus(int grngvnStatus) {
		this.grngvnStatus = grngvnStatus;
	}


	public String getApprovedDatetime() {
		return approvedDatetime;
	}


	public void setApprovedDatetime(String approvedDatetime) {
		this.approvedDatetime = approvedDatetime;
	}


	public List<GGDetailApr> getGgDetailList() {
		return ggDetailList;
	}


	public void setGgDetailList(List<GGDetailApr> ggDetailList) {
		this.ggDetailList = ggDetailList;
	}


	@Override
	public String toString() {
		return "GGHeaderApr [grnGvnHeaderId=" + grnGvnHeaderId + ", grngvnSrno=" + grngvnSrno + ", grngvnDate="
				+ grngvnDate + ", frId=" + frId + ", frName=" + frName + ", isGrn=" + isGrn + ", totalAmt=" + totalAmt
				+ ", aprGrandTotal=" + aprGrandTotal + ", grngvnStatus=" + grngvnStatus + ", approvedDatetime="
				+ approvedDatetime + ", ggDetailList=" + ggDetailList + "]";
	}
	
}
