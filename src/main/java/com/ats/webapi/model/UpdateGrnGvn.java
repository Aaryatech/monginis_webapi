package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="UpdateGrnGvn")
@Table(name = "t_grn_gvn")
public class UpdateGrnGvn  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_gvn_id")
	int grnGvnId;
	
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
	private String approvedDateTimeAcc;

	@Column(name = "approved_remark_acc")
	private String approvedRemarkAcc;

	public int getGrnGvnId() {
		return grnGvnId;
	}

	public void setGrnGvnId(int grnGvnId) {
		this.grnGvnId = grnGvnId;
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

	
	public String getApprovedRemarkAcc() {
		return approvedRemarkAcc;
	}

	public void setApprovedRemarkAcc(String approvedRemarkAcc) {
		this.approvedRemarkAcc = approvedRemarkAcc;
	}

	public String getApprovedDateTimeAcc() {
		return approvedDateTimeAcc;
	}

	public void setApprovedDateTimeAcc(String approvedDateTimeAcc) {
		this.approvedDateTimeAcc = approvedDateTimeAcc;
	}
	
	
	
	
	

}
