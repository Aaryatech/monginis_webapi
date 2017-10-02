package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetRegularSpCkItems {

	@Id
	private int id;
	private String itemName;
	private String itemImage;
	private String itemRate1;
	private String itemRate2;
	private String itemRate3;
	private String itemMrp1;
	private String itemMrp2;
	private String itemMrp3;
	private String itemShelfLife;
	private String ItemTax1;
	private String ItemTax2;
	private String ItemTax3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public String getItemRate1() {
		return itemRate1;
	}
	public void setItemRate1(String itemRate1) {
		this.itemRate1 = itemRate1;
	}
	public String getItemRate2() {
		return itemRate2;
	}
	public void setItemRate2(String itemRate2) {
		this.itemRate2 = itemRate2;
	}
	public String getItemRate3() {
		return itemRate3;
	}
	public void setItemRate3(String itemRate3) {
		this.itemRate3 = itemRate3;
	}
	public String getItemMrp1() {
		return itemMrp1;
	}
	public void setItemMrp1(String itemMrp1) {
		this.itemMrp1 = itemMrp1;
	}
	public String getItemMrp2() {
		return itemMrp2;
	}
	public void setItemMrp2(String itemMrp2) {
		this.itemMrp2 = itemMrp2;
	}
	public String getItemMrp3() {
		return itemMrp3;
	}
	public void setItemMrp3(String itemMrp3) {
		this.itemMrp3 = itemMrp3;
	}
	public String getItemShelfLife() {
		return itemShelfLife;
	}
	public void setItemShelfLife(String itemShelfLife) {
		this.itemShelfLife = itemShelfLife;
	}
	public String getItemTax1() {
		return ItemTax1;
	}
	public void setItemTax1(String itemTax1) {
		ItemTax1 = itemTax1;
	}
	public String getItemTax2() {
		return ItemTax2;
	}
	public void setItemTax2(String itemTax2) {
		ItemTax2 = itemTax2;
	}
	public String getItemTax3() {
		return ItemTax3;
	}
	public void setItemTax3(String itemTax3) {
		ItemTax3 = itemTax3;
	}
	
}
