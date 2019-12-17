package com.ats.webapi.model.tray;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CalCulateTray {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	private int frId;

	private int subCatId;

	private int frRouteId;
	
	private String routeName;

	private String frName;

	private String subCatName;

	private float orderQty;

	private float trayQty;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getFrRouteId() {
		return frRouteId;
	}

	public void setFrRouteId(int frRouteId) {
		this.frRouteId = frRouteId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public float getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(float orderQty) {
		this.orderQty = orderQty;
	}

	public float getTrayQty() {
		return trayQty;
	}

	public void setTrayQty(float trayQty) {
		this.trayQty = trayQty;
	}

	@Override
	public String toString() {
		return "CalCulateTray [orderId=" + orderId + ", frId=" + frId + ", subCatId=" + subCatId + ", frRouteId="
				+ frRouteId + ", routeName=" + routeName + ", frName=" + frName + ", subCatName=" + subCatName
				+ ", orderQty=" + orderQty + ", trayQty=" + trayQty + "]";
	}
	
	

}
