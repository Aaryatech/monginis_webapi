package com.ats.webapi.model.prodapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetSpCakeOrderForProdApp {
	
	/*
	 
	SELECT t_sp_cake_sup.sr_no,t_sp_cake_sup.t_sp_cake_sup_no,t_sp_cake_sup.date,t_sp_cake_sup.status,
t_sp_cake_sup.input_kg_fr,m_fr_route.route_name,m_franchise_sup.no_in_route,
m_franchisee.fr_name,m_franchisee.fr_code,m_franchisee.fr_id,m_fr_route.route_id,
m_sp_cake.sp_name,m_sp_cake.sp_code,m_sp_cake.sp_image,t_sp_cake.sp_flavour_id,m_sp_flavour.spf_name,
t_sp_cake.sp_delivery_place,t_sp_cake.sp_instructions,t_sp_cake.sp_delivery_date,
t_sp_cake_sup.start_time_stamp,t_sp_cake_sup.end_time_stamp,t_sp_cake.order_photo,t_sp_cake.order_photo2
FROM t_sp_cake_sup,m_fr_route,m_franchise_sup,t_sp_cake,m_franchisee,m_sp_cake,m_sp_flavour

WHERE t_sp_cake_sup.date BETWEEN '2018-10-03' AND '2018-10-03' AND t_sp_cake_sup.menu_id IN(40) AND t_sp_cake.is_slot_used=0
AND t_sp_cake.sp_order_no=t_sp_cake_sup.t_sp_cake_order_no AND t_sp_cake_sup.fr_id=m_franchisee.fr_id
AND m_franchisee.fr_id=m_franchise_sup.fr_id AND m_franchisee.fr_route_id=m_fr_route.route_id
AND m_sp_cake.sp_id=t_sp_cake_sup.sp_cake_id AND m_sp_flavour.spf_id=t_sp_cake.sp_flavour_id

ORDER BY m_fr_route.route_id DESC,m_franchise_sup.no_in_route,t_sp_cake_sup.fr_id 
	 */

	
	
	@Id
	private int tSpCakeSupNo;
	
	private int srNo;
	
	private Date date;
	
	private int status;
	
	private float inputKgFr;
	private float inputKgProd;
	
	private String routeName;
	private int noInRoute;
	
	private String frName;
	private String frCode;
	private int frId;
	private int routeId;
	
	private String spName;
	private String spCode;
	private String spImage;
	
	private int spFlavourId;
	private String spfName;
	private String spDeliveryPlace;
	private String spInstructions;
	
	private Date spDeliveryDate;
	
	
	private Long startTimeStamp;
	private Long endTimeStamp;
	
	
	private String orderPhoto;
	private String orderPhoto2;
	
	
	private String isCharUsed;
	
	private String spEvents;
	
	private String spEventsName;
	
	
	public String getIsCharUsed() {
		return isCharUsed;
	}
	public void setIsCharUsed(String isCharUsed) {
		this.isCharUsed = isCharUsed;
	}
	public int gettSpCakeSupNo() {
		return tSpCakeSupNo;
	}
	public void settSpCakeSupNo(int tSpCakeSupNo) {
		this.tSpCakeSupNo = tSpCakeSupNo;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public float getInputKgFr() {
		return inputKgFr;
	}
	public void setInputKgFr(float inputKgFr) {
		this.inputKgFr = inputKgFr;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public int getNoInRoute() {
		return noInRoute;
	}
	public void setNoInRoute(int noInRoute) {
		this.noInRoute = noInRoute;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public String getFrCode() {
		return frCode;
	}
	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public String getSpCode() {
		return spCode;
	}
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	public String getSpImage() {
		return spImage;
	}
	public void setSpImage(String spImage) {
		this.spImage = spImage;
	}
	public int getSpFlavourId() {
		return spFlavourId;
	}
	public void setSpFlavourId(int spFlavourId) {
		this.spFlavourId = spFlavourId;
	}
	public String getSpfName() {
		return spfName;
	}
	public void setSpfName(String spfName) {
		this.spfName = spfName;
	}
	public String getSpDeliveryPlace() {
		return spDeliveryPlace;
	}
	public void setSpDeliveryPlace(String spDeliveryPlace) {
		this.spDeliveryPlace = spDeliveryPlace;
	}
	public String getSpInstructions() {
		return spInstructions;
	}
	public void setSpInstructions(String spInstructions) {
		this.spInstructions = spInstructions;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSpDeliveryDate() {
		return spDeliveryDate;
	}
	public void setSpDeliveryDate(Date spDeliveryDate) {
		this.spDeliveryDate = spDeliveryDate;
	}
	public Long getStartTimeStamp() {
		return startTimeStamp;
	}
	public void setStartTimeStamp(Long startTimeStamp) {
		this.startTimeStamp = startTimeStamp;
	}
	public Long getEndTimeStamp() {
		return endTimeStamp;
	}
	public void setEndTimeStamp(Long endTimeStamp) {
		this.endTimeStamp = endTimeStamp;
	}
	public String getOrderPhoto() {
		return orderPhoto;
	}
	public void setOrderPhoto(String orderPhoto) {
		this.orderPhoto = orderPhoto;
	}
	public String getOrderPhoto2() {
		return orderPhoto2;
	}
	public void setOrderPhoto2(String orderPhoto2) {
		this.orderPhoto2 = orderPhoto2;
	}
	
	
	
	public float getInputKgProd() {
		return inputKgProd;
	}
	public void setInputKgProd(float inputKgProd) {
		this.inputKgProd = inputKgProd;
	}
	
	
	
	
	public String getSpEvents() {
		return spEvents;
	}
	public void setSpEvents(String spEvents) {
		this.spEvents = spEvents;
	}
	public String getSpEventsName() {
		return spEventsName;
	}
	public void setSpEventsName(String spEventsName) {
		this.spEventsName = spEventsName;
	}
	@Override
	public String toString() {
		return "GetSpCakeOrderForProdApp [tSpCakeSupNo=" + tSpCakeSupNo + ", srNo=" + srNo + ", date=" + date
				+ ", status=" + status + ", inputKgFr=" + inputKgFr + ", inputKgProd=" + inputKgProd + ", routeName="
				+ routeName + ", noInRoute=" + noInRoute + ", frName=" + frName + ", frCode=" + frCode + ", frId="
				+ frId + ", routeId=" + routeId + ", spName=" + spName + ", spCode=" + spCode + ", spImage=" + spImage
				+ ", spFlavourId=" + spFlavourId + ", spfName=" + spfName + ", spDeliveryPlace=" + spDeliveryPlace
				+ ", spInstructions=" + spInstructions + ", spDeliveryDate=" + spDeliveryDate + ", startTimeStamp="
				+ startTimeStamp + ", endTimeStamp=" + endTimeStamp + ", orderPhoto=" + orderPhoto + ", orderPhoto2="
				+ orderPhoto2 + ", isCharUsed=" + isCharUsed + "]";
	}
	
	
	
	
	
	
	
}
