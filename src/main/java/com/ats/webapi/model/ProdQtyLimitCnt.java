package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;




//Akhilesh 11/12/2020 Friday 16:54
@Entity
public class ProdQtyLimitCnt {

	@Id
	private int menuId;
	
	private int prodCount;
	
	private int total;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getProdCount() {
		return prodCount;
	}

	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ProdQtyLimitCnt [menuId=" + menuId + ", prodCount=" + prodCount + ", total=" + total + "]";
	}
	
	
	
	
	
	
	
	
	
}
