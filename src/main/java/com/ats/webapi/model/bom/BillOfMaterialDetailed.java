package com.ats.webapi.model.bom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_req_bom_detail")
public class BillOfMaterialDetailed {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="req_detail_id")
	private int reqDetailId;

	@Column(name="req_id")
	private int reqId;
	
	@Column(name="rm_type")
	private int rmType;

	@Column(name="rm_id")
	private int rmId;

	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="uom")
	private String uom;

	@Column(name="rm_req_qty")
	private float rmReqQty;
	
	@Column(name="rm_issue_qty")
	private float rmIssueQty;
	
	@Column(name="ex_int1")
	private int exInt1;

	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_varchar1")
	private String exVarchar1;

	@Column(name="ex_varchar2")
	private String exVarchar2;
	
	@Column(name="ex_varchar3")
	private String exVarchar3;
	
	@Column(name="ex_bool1")
	private int exBool1;
	
	@Column(name="ex_bool2")
	private int exBool2;
	
	@Column(name="del_status")
	private int delStatus;
	
	
	//Newly Added
	@Column(name="auto_rm_req_qty")
	private float autoRmReqQty;
	
	@Column(name="rejected_qty")
	private float rejectedQty;
	
	@Column(name="return_qty")
	private float returnQty;
	
	
	

	public float getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(float returnQty) {
		this.returnQty = returnQty;
	}

	public float getAutoRmReqQty() {
		return autoRmReqQty;
	}

	public void setAutoRmReqQty(float autoRmReqQty) {
		this.autoRmReqQty = autoRmReqQty;
	}

	public int getReqDetailId() {
		return reqDetailId;
	}

	public void setReqDetailId(int reqDetailId) {
		this.reqDetailId = reqDetailId;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
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

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public float getRmReqQty() {
		return rmReqQty;
	}

	public void setRmReqQty(float rmReqQty) {
		this.rmReqQty = rmReqQty;
	}

	public float getRmIssueQty() {
		return rmIssueQty;
	}

	public void setRmIssueQty(float rmIssueQty) {
		this.rmIssueQty = rmIssueQty;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVarchar1() {
		return exVarchar1;
	}

	public void setExVarchar1(String exVarchar1) {
		this.exVarchar1 = exVarchar1;
	}

	public String getExVarchar2() {
		return exVarchar2;
	}

	public void setExVarchar2(String exVarchar2) {
		this.exVarchar2 = exVarchar2;
	}

	public String getExVarchar3() {
		return exVarchar3;
	}

	public void setExVarchar3(String exVarchar3) {
		this.exVarchar3 = exVarchar3;
	}

	public int getExBool1() {
		return exBool1;
	}

	public void setExBool1(int exBool1) {
		this.exBool1 = exBool1;
	}

	public int getExBool2() {
		return exBool2;
	}

	public void setExBool2(int exBool2) {
		this.exBool2 = exBool2;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public float getRejectedQty() {
		return rejectedQty;
	}

	public void setRejectedQty(float rejectedQty) {
		this.rejectedQty = rejectedQty;
	}

	@Override
	public String toString() {
		return "BillOfMaterialDetailed [reqDetailId=" + reqDetailId + ", reqId=" + reqId + ", rmType=" + rmType
				+ ", rmId=" + rmId + ", rmName=" + rmName + ", uom=" + uom + ", rmReqQty=" + rmReqQty + ", rmIssueQty="
				+ rmIssueQty + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exVarchar1=" + exVarchar1
				+ ", exVarchar2=" + exVarchar2 + ", exVarchar3=" + exVarchar3 + ", exBool1=" + exBool1 + ", exBool2="
				+ exBool2 + ", delStatus=" + delStatus + ", autoRmReqQty=" + autoRmReqQty + ", rejectedQty="
				+ rejectedQty + ", returnQty=" + returnQty + "]";
	}

	
}
