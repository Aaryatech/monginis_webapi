package com.ats.webapi.model.prodapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoutewiseLastCakeEndTime {
	
	@Id
	private int routeId;
	
	private int routeSeqNo;
	
	private String routeName;
	
	private Long lastSpEndTime;
	private Long lastRegSpEndTime;
	
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getRouteSeqNo() {
		return routeSeqNo;
	}
	public void setRouteSeqNo(int routeSeqNo) {
		this.routeSeqNo = routeSeqNo;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public Long getLastSpEndTime() {
		return lastSpEndTime;
	}
	public void setLastSpEndTime(Long lastSpEndTime) {
		this.lastSpEndTime = lastSpEndTime;
	}
	public Long getLastRegSpEndTime() {
		return lastRegSpEndTime;
	}
	public void setLastRegSpEndTime(Long lastRegSpEndTime) {
		this.lastRegSpEndTime = lastRegSpEndTime;
	}
	
	
	@Override
	public String toString() {
		return "RoutewiseLastCakeEndTime [routeId=" + routeId + ", routeSeqNo=" + routeSeqNo + ", routeName="
				+ routeName + ", lastSpEndTime=" + lastSpEndTime + ", lastRegSpEndTime=" + lastRegSpEndTime + "]";
	}
	
	
	
	

}
