package com.ats.webapi.model.tray;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DriverDetailByFr {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tranId;
	
	private String tranDate;
	private int vehId;
	private String vehNo;
	private int drvId;
	private String driverName;
	private String mobile1;
	private String mobile2;
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public int getVehId() {
		return vehId;
	}
	public void setVehId(int vehId) {
		this.vehId = vehId;
	}
	public String getVehNo() {
		return vehNo;
	}
	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}
	public int getDrvId() {
		return drvId;
	}
	public void setDrvId(int drvId) {
		this.drvId = drvId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	@Override
	public String toString() {
		return "DriverDetailByFr [tranId=" + tranId + ", tranDate=" + tranDate + ", vehId=" + vehId + ", vehNo=" + vehNo
				+ ", drvId=" + drvId + ", driverName=" + driverName + ", mobile1=" + mobile1 + "]";
	}


	
}
