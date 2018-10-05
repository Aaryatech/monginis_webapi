/*package com.ats.webapi.model.prodapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="m_fr_menu_show")
public class Menus {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="menu_id")
	private int menuId;
	@Column(name="menu_title")
	private String menuTitle;
	@Column(name="menu_desc")
	private String menuDesc;
	@Column(name="menu_image")
	private String menuImage;
	@Column(name="selected_menu_image")
	private String selectedMenuImage;
	@Column(name="is_same_day_applicable")
	private String isSameDayApplicable;
	
	
	private int catId;
	@Column(name="del_status")
	private int delStatus;
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
	public String getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	public String getSelectedMenuImage() {
		return selectedMenuImage;
	}
	public void setSelectedMenuImage(String selectedMenuImage) {
		this.selectedMenuImage = selectedMenuImage;
	}
	public String getIsSameDayApplicable() {
		return isSameDayApplicable;
	}
	public void setIsSameDayApplicable(String isSameDayApplicable) {
		this.isSameDayApplicable = isSameDayApplicable;
	}
	
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	@Override
	public String toString() {
		return "Menus [menuId=" + menuId + ", menuTitle=" + menuTitle + ", menuDesc=" + menuDesc + ", menuImage="
				+ menuImage + ", selectedMenuImage=" + selectedMenuImage + ", isSameDayApplicable="
				+ isSameDayApplicable + ", catId=" + catId + ", delStatus=" + delStatus + "]";
	}
	
	
}
*/