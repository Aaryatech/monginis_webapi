package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_franchise_sup")
public class FranchiseSup implements Serializable{
	
	@Transient
	private boolean error;
	
	@Transient
	private String message;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	private int frId;
	
	private String frPanNo;
	
	private String frState;
	
	private String frCountry;
	
	private int delStatus;

	
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrPanNo() {
		return frPanNo;
	}

	public void setFrPanNo(String frPanNo) {
		this.frPanNo = frPanNo;
	}

	public String getFrState() {
		return frState;
	}

	public void setFrState(String frState) {
		this.frState = frState;
	}

	public String getFrCountry() {
		return frCountry;
	}

	public void setFrCountry(String frCountry) {
		this.frCountry = frCountry;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "FranchiseSup [id=" + id + ", frId=" + frId + ", frPanNo=" + frPanNo + ", frState=" + frState
				+ ", frCountry=" + frCountry + ", delStatus=" + delStatus + "]";
	}
}
