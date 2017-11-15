package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_fr_opening_stock_detail")

public class GetCurrentStockDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "opening_stock_detail_id")
	private int stockDetailId;
	

	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "reg_opening_stock")
	private int regOpeningStock;

	@Column(name = "sp_opening_stock")
	private int spOpeningStock;
	
	@Column(name = "reg_total_purchase")
	private int regTotalPurchase;
	
	@Column(name = "sp_total_purchase")
	private int spTotalPurchase;
	
	
	@Column(name = "reg_total_grn_gvn")
	private int regTotalGrnGvn;
	
	@Column(name = "reg_total_sell")
	private int regTotalSell;

	@Column(name = "sp_total_sell")
	private int spTotalSell;

	
	@Column(name = "opening_stock_header_id")
	private int stockHeaderId;
	
	
	@Transient
	private int currentRegStock;
	
	@Transient
	private int currentSpStock;
	
	@Transient
	private int id;
	
	
	@PostLoad
	private void onLoad() {
	    this.currentRegStock = (regOpeningStock + regTotalPurchase) - (regTotalGrnGvn + regTotalSell );
	    this.currentSpStock = (spOpeningStock + spTotalPurchase) - spTotalSell ;
	
	}


	public int getStockDetailId() {
		return stockDetailId;
	}


	public void setStockDetailId(int stockDetailId) {
		this.stockDetailId = stockDetailId;
	}


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




	public int getRegOpeningStock() {
		return regOpeningStock;
	}




	public void setRegOpeningStock(int regOpeningStock) {
		this.regOpeningStock = regOpeningStock;
	}




	public int getSpOpeningStock() {
		return spOpeningStock;
	}




	public void setSpOpeningStock(int spOpeningStock) {
		this.spOpeningStock = spOpeningStock;
	}




	public int getRegTotalPurchase() {
		return regTotalPurchase;
	}




	public void setRegTotalPurchase(int regTotalPurchase) {
		this.regTotalPurchase = regTotalPurchase;
	}




	public int getSpTotalPurchase() {
		return spTotalPurchase;
	}




	public void setSpTotalPurchase(int spTotalPurchase) {
		this.spTotalPurchase = spTotalPurchase;
	}




	



	public int getRegTotalGrnGvn() {
		return regTotalGrnGvn;
	}


	public void setRegTotalGrnGvn(int regTotalGrnGvn) {
		this.regTotalGrnGvn = regTotalGrnGvn;
	}


	public int getRegTotalSell() {
		return regTotalSell;
	}




	public void setRegTotalSell(int regTotalSell) {
		this.regTotalSell = regTotalSell;
	}




	public int getSpTotalSell() {
		return spTotalSell;
	}




	public void setSpTotalSell(int spTotalSell) {
		this.spTotalSell = spTotalSell;
	}




	public int getStockHeaderId() {
		return stockHeaderId;
	}




	public void setStockHeaderId(int stockHeaderId) {
		this.stockHeaderId = stockHeaderId;
	}




	public int getCurrentRegStock() {
		return currentRegStock;
	}




	public void setCurrentRegStock(int currentRegStock) {
		this.currentRegStock = currentRegStock;
	}




	public int getCurrentSpStock() {
		return currentSpStock;
	}




	public void setCurrentSpStock(int currentSpStock) {
		this.currentSpStock = currentSpStock;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "GetCurrentStockDetails [stockDetailId=" + stockDetailId + ", itemId=" + itemId + ", itemName="
				+ itemName + ", regOpeningStock=" + regOpeningStock + ", spOpeningStock=" + spOpeningStock
				+ ", regTotalPurchase=" + regTotalPurchase + ", spTotalPurchase=" + spTotalPurchase
				+ ", regTotalGrnGvn=" + regTotalGrnGvn + ", regTotalSell=" + regTotalSell + ", spTotalSell="
				+ spTotalSell + ", stockHeaderId=" + stockHeaderId + ", currentRegStock=" + currentRegStock
				+ ", currentSpStock=" + currentSpStock + ", id=" + id + "]";
	}


	

}
