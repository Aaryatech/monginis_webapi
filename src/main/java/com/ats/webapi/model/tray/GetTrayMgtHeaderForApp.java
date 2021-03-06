package com.ats.webapi.model.tray;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetTrayMgtHeaderForApp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tran_id")
	private int tranId;

	@Column(name = "tran_date")
	private String tranDate;

	@Column(name = "veh_id")
	private int vehId;

	@Column(name = "drv_id")
	private int drvId;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "route_id")
	private int routeId;

	@Column(name = "route_name")
	private String routeName;

	@Column(name = "veh_no")
	private String vehNo;

	@Column(name = "veh_outtime")
	private String vehOuttime;

	@Column(name = "veh_intime")
	private String vehIntime;

	@Column(name = "veh_outkm")
	private float vehOutkm;

	@Column(name = "veh_inkm")
	private float vehInkm;

	@Column(name = "veh_running_km")
	private float vehRunningKm;

	@Column(name = "diesel")
	private float diesel;

	@Column(name = "veh_status")
	private int vehStatus;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "extra_tray_out")
	private String extraTrayOut;

	@Column(name = "extra_tray_in")
	private String extraTrayIn;

	@Column(name = "veh_is_regular")
	private int vehIsRegular;

	@Column(name = "is_same_day")
	private int isSameDay;

	@Column(name = "mobile1")
	private String mobile1;

	@Column(name = "mobile2")
	private String mobile2;

	@Column(name = "mobile3")
	private String mobile3;

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

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getVehOuttime() {
		return vehOuttime;
	}

	public void setVehOuttime(String vehOuttime) {
		this.vehOuttime = vehOuttime;
	}

	public String getVehIntime() {
		return vehIntime;
	}

	public void setVehIntime(String vehIntime) {
		this.vehIntime = vehIntime;
	}

	public float getVehOutkm() {
		return vehOutkm;
	}

	public void setVehOutkm(float vehOutkm) {
		this.vehOutkm = vehOutkm;
	}

	public float getVehInkm() {
		return vehInkm;
	}

	public void setVehInkm(float vehInkm) {
		this.vehInkm = vehInkm;
	}

	public float getVehRunningKm() {
		return vehRunningKm;
	}

	public void setVehRunningKm(float vehRunningKm) {
		this.vehRunningKm = vehRunningKm;
	}

	public float getDiesel() {
		return diesel;
	}

	public void setDiesel(float diesel) {
		this.diesel = diesel;
	}

	public int getVehStatus() {
		return vehStatus;
	}

	public void setVehStatus(int vehStatus) {
		this.vehStatus = vehStatus;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getExtraTrayOut() {
		return extraTrayOut;
	}

	public void setExtraTrayOut(String extraTrayOut) {
		this.extraTrayOut = extraTrayOut;
	}

	public String getExtraTrayIn() {
		return extraTrayIn;
	}

	public void setExtraTrayIn(String extraTrayIn) {
		this.extraTrayIn = extraTrayIn;
	}

	public int getVehIsRegular() {
		return vehIsRegular;
	}

	public void setVehIsRegular(int vehIsRegular) {
		this.vehIsRegular = vehIsRegular;
	}

	public int getIsSameDay() {
		return isSameDay;
	}

	public void setIsSameDay(int isSameDay) {
		this.isSameDay = isSameDay;
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

	public String getMobile3() {
		return mobile3;
	}

	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}

	@Override
	public String toString() {
		return "GetTrayMgtHeaderForApp [tranId=" + tranId + ", tranDate=" + tranDate + ", vehId=" + vehId + ", drvId="
				+ drvId + ", driverName=" + driverName + ", routeId=" + routeId + ", routeName=" + routeName
				+ ", vehNo=" + vehNo + ", vehOuttime=" + vehOuttime + ", vehIntime=" + vehIntime + ", vehOutkm="
				+ vehOutkm + ", vehInkm=" + vehInkm + ", vehRunningKm=" + vehRunningKm + ", diesel=" + diesel
				+ ", vehStatus=" + vehStatus + ", delStatus=" + delStatus + ", extraTrayOut=" + extraTrayOut
				+ ", extraTrayIn=" + extraTrayIn + ", vehIsRegular=" + vehIsRegular + ", isSameDay=" + isSameDay
				+ ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", mobile3=" + mobile3 + "]";
	}

}
