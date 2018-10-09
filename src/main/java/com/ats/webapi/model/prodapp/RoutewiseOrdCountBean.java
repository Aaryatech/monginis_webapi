package com.ats.webapi.model.prodapp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoutewiseOrdCountBean {

	@Id
	private int routeId;

	private int routeSeqNo;

	private String routeName;

	private int spStatusZeroOrdCount;
	private int spStatusOneOrdCount;
	private int spStatusTwoOrdCount;
	private int spStatusThreeOrdCount;
	private int spTotalOrdCount;

	private int regSpStatusZeroOrdCount;
	private int regSpStatusOneOrdCount;
	private int regSpStatusTwoOrdCount;
	private int regSpStatusThreeOrdCount;
	private int regSpTotalOrdCount;
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
	public int getSpStatusZeroOrdCount() {
		return spStatusZeroOrdCount;
	}
	public void setSpStatusZeroOrdCount(int spStatusZeroOrdCount) {
		this.spStatusZeroOrdCount = spStatusZeroOrdCount;
	}
	public int getSpStatusOneOrdCount() {
		return spStatusOneOrdCount;
	}
	public void setSpStatusOneOrdCount(int spStatusOneOrdCount) {
		this.spStatusOneOrdCount = spStatusOneOrdCount;
	}
	public int getSpStatusTwoOrdCount() {
		return spStatusTwoOrdCount;
	}
	public void setSpStatusTwoOrdCount(int spStatusTwoOrdCount) {
		this.spStatusTwoOrdCount = spStatusTwoOrdCount;
	}
	public int getSpStatusThreeOrdCount() {
		return spStatusThreeOrdCount;
	}
	public void setSpStatusThreeOrdCount(int spStatusThreeOrdCount) {
		this.spStatusThreeOrdCount = spStatusThreeOrdCount;
	}
	public int getSpTotalOrdCount() {
		return spTotalOrdCount;
	}
	public void setSpTotalOrdCount(int spTotalOrdCount) {
		this.spTotalOrdCount = spTotalOrdCount;
	}
	public int getRegSpStatusZeroOrdCount() {
		return regSpStatusZeroOrdCount;
	}
	public void setRegSpStatusZeroOrdCount(int regSpStatusZeroOrdCount) {
		this.regSpStatusZeroOrdCount = regSpStatusZeroOrdCount;
	}
	public int getRegSpStatusOneOrdCount() {
		return regSpStatusOneOrdCount;
	}
	public void setRegSpStatusOneOrdCount(int regSpStatusOneOrdCount) {
		this.regSpStatusOneOrdCount = regSpStatusOneOrdCount;
	}
	public int getRegSpStatusTwoOrdCount() {
		return regSpStatusTwoOrdCount;
	}
	public void setRegSpStatusTwoOrdCount(int regSpStatusTwoOrdCount) {
		this.regSpStatusTwoOrdCount = regSpStatusTwoOrdCount;
	}
	public int getRegSpStatusThreeOrdCount() {
		return regSpStatusThreeOrdCount;
	}
	public void setRegSpStatusThreeOrdCount(int regSpStatusThreeOrdCount) {
		this.regSpStatusThreeOrdCount = regSpStatusThreeOrdCount;
	}
	public int getRegSpTotalOrdCount() {
		return regSpTotalOrdCount;
	}
	public void setRegSpTotalOrdCount(int regSpTotalOrdCount) {
		this.regSpTotalOrdCount = regSpTotalOrdCount;
	}
	@Override
	public String toString() {
		return "RoutewiseOrdCountBean [routeId=" + routeId + ", routeSeqNo=" + routeSeqNo + ", routeName=" + routeName
				+ ", spStatusZeroOrdCount=" + spStatusZeroOrdCount + ", spStatusOneOrdCount=" + spStatusOneOrdCount
				+ ", spStatusTwoOrdCount=" + spStatusTwoOrdCount + ", spStatusThreeOrdCount=" + spStatusThreeOrdCount
				+ ", spTotalOrdCount=" + spTotalOrdCount + ", regSpStatusZeroOrdCount=" + regSpStatusZeroOrdCount
				+ ", regSpStatusOneOrdCount=" + regSpStatusOneOrdCount + ", regSpStatusTwoOrdCount="
				+ regSpStatusTwoOrdCount + ", regSpStatusThreeOrdCount=" + regSpStatusThreeOrdCount
				+ ", regSpTotalOrdCount=" + regSpTotalOrdCount + "]";
	}
	
	
	

	/*List<RoutewiseRegSpOrderCount> getRoutewiseRegSpOrderCount;
	List<RoutewiseSpOrderCount> getRoutewiseSpOrderCount;

	public List<RoutewiseRegSpOrderCount> getGetRoutewiseRegSpOrderCount() {
		return getRoutewiseRegSpOrderCount;
	}

	public void setGetRoutewiseRegSpOrderCount(List<RoutewiseRegSpOrderCount> getRoutewiseRegSpOrderCount) {
		this.getRoutewiseRegSpOrderCount = getRoutewiseRegSpOrderCount;
	}

	public List<RoutewiseSpOrderCount> getGetRoutewiseSpOrderCount() {
		return getRoutewiseSpOrderCount;
	}

	@Override
	public String toString() {
		return "RoutewiseOrdCountBean [getRoutewiseRegSpOrderCount=" + getRoutewiseRegSpOrderCount
				+ ", getRoutewiseSpOrderCount=" + getRoutewiseSpOrderCount + "]";
	}

	public void setGetRoutewiseSpOrderCount(List<RoutewiseSpOrderCount> getRoutewiseSpOrderCount) {
		this.getRoutewiseSpOrderCount = getRoutewiseSpOrderCount;
	}
*/
}
