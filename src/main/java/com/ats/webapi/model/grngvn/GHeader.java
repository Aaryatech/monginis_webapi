package com.ats.webapi.model.grngvn;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class GHeader {
	
	@Id
	private int grnGvnHeaderId;

	private int frId;
	
	private String grngvnSrno;
	
	private Date grngvnDate;
	
	
	private int isGrn;
	
	private String frName;

	
	
	public int getGrnGvnHeaderId() {
		return grnGvnHeaderId;
	}

	public void setGrnGvnHeaderId(int grnGvnHeaderId) {
		this.grnGvnHeaderId = grnGvnHeaderId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
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

	public int getIsGrn() {
		return isGrn;
	}

	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	@Override
	public String toString() {
		return "GHeader [grnGvnHeaderId=" + grnGvnHeaderId + ", frId=" + frId + ", grngvnSrno=" + grngvnSrno
				+ ", grngvnDate=" + grngvnDate + ", isGrn=" + isGrn + ", frName=" + frName + "]";
	}

	
	
}
