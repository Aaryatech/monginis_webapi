package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class GetOrderItemQty implements Serializable{

	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	int orderId;
	
	private int qty;
	
	@Column(name="item_id")
	private String itemId;

	

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "GetOrderItemQty [orderId=" + orderId + ", qty=" + qty + ", itemId=" + itemId + "]";
	}

	
	

	
	
	
	
}
