package com.ats.webapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.ats.webapi.controller.DateAndQty;

@Entity
public class ItemListWithDateRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	private String itemName; 
	
	@Transient
	List<DateAndQty> list;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public List<DateAndQty> getList() {
		return list;
	}
	public void setList(List<DateAndQty> list) {
		this.list = list;
	}
	
	

}
