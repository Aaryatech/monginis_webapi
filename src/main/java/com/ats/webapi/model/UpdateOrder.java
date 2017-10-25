package com.ats.webapi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public class UpdateOrder {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;

	@Column(name="order_qty")
	private int orderQty;
	
	@Column(name="order_status")
	private int orderStatus;


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	

	


	
}
