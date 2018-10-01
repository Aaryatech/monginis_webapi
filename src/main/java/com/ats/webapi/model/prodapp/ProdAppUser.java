package com.ats.webapi.model.prodapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_prod_app_user")

public class ProdAppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	private String uName;
	
	private String uMobNo;
	
	private String uPass;
	
	private int uType;
	
	private String uDeviceToken;
	
	private int delStatus;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuMobNo() {
		return uMobNo;
	}

	public void setuMobNo(String uMobNo) {
		this.uMobNo = uMobNo;
	}

	public String getuPass() {
		return uPass;
	}

	public void setuPass(String uPass) {
		this.uPass = uPass;
	}

	public int getuType() {
		return uType;
	}

	public void setuType(int uType) {
		this.uType = uType;
	}

	public String getuDeviceToken() {
		return uDeviceToken;
	}

	public void setuDeviceToken(String uDeviceToken) {
		this.uDeviceToken = uDeviceToken;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "ProdAppUser [userId=" + userId + ", uName=" + uName + ", uMobNo=" + uMobNo + ", uPass=" + uPass
				+ ", uType=" + uType + ", uDeviceToken=" + uDeviceToken + ", delStatus=" + delStatus + "]";
	}
	

}
