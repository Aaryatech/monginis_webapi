package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetFranchiseSup implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	private int frId;
	
	private String frName;
	
	private String frPanNo;
	
	private String frState;
	
	private String frCountry;
	
	private int delStatus;

	private String pass1;
	
	private String pass2;
	
	private String pass3;
	
	private String pass4;

	private String pass5;

    private int frequency;
	
	private String pestControlDate;
	
	private String remainderDate;
	
	private int isTallySync;
	
	private int noInRoute;;

	
	
	public int getNoInRoute() {
		return noInRoute;
	}

	public void setNoInRoute(int noInRoute) {
		this.noInRoute = noInRoute;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public String getPestControlDate() {
		return pestControlDate;
	}

	public void setPestControlDate(String pestControlDate) {
		this.pestControlDate = pestControlDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public String getRemainderDate() {
		return remainderDate;
	}

	public void setRemainderDate(String remainderDate) {
		this.remainderDate = remainderDate;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getPass3() {
		return pass3;
	}

	public void setPass3(String pass3) {
		this.pass3 = pass3;
	}

	public String getPass4() {
		return pass4;
	}

	public void setPass4(String pass4) {
		this.pass4 = pass4;
	}

	public String getPass5() {
		return pass5;
	}

	public void setPass5(String pass5) {
		this.pass5 = pass5;
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

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
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
		return "GetFranchiseSup [id=" + id + ", frId=" + frId + ", frName=" + frName + ", frPanNo=" + frPanNo
				+ ", frState=" + frState + ", frCountry=" + frCountry + ", delStatus=" + delStatus + ", pass1=" + pass1
				+ ", pass2=" + pass2 + ", pass3=" + pass3 + ", pass4=" + pass4 + ", pass5=" + pass5 + ", isTallySync="
				+ isTallySync + "]";
	}

}
