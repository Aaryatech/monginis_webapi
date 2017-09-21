package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="menuShow")
@Table(name = "m_fr_menu_show")



public class OrderCounts implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="menu_id")
	int menuId;
	@Column(name="menu_title")
	String menuTitle;
	int Total;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuTitle() {
		return menuTitle;
	}
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	@Override
	public String toString() {
		return "OrderCounts [menuId=" + menuId + ", menuTitle=" + menuTitle + ", Total=" + Total + "]";
	}
	
	
	
	
	
	
}
