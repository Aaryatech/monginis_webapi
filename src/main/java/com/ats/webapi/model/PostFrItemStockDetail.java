package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_fr_opening_stock_detail")
public class PostFrItemStockDetail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="opening_stock_detail_id")
	private int openingStockDetailId;
	
	@Column(name="opening_stock_header_id")
	private int openingStockHeaderId;

	@Column(name="item_id")
	private int 	itemId;
	
	@Column(name="opening_stock")
	private int openingStock;
	
	@Column(name="physical_stock")
	private int physicalStock;
	
	@Column(name="stock_difference")
	private int stockDifference;
	
	@Column(name="total_purchase")
	private int totalPurchase;
	
	@Column(name="total_grn_grvn")
	private int totalGrnGvn;
	
	@Column(name="total_sell")
	private int totalSell;
	
	@Column(name="remark")
	private String remark;

	
	
	
	public int getOpeningStockDetailId() {
		return openingStockDetailId;
	}

	public void setOpeningStockDetailId(int openingStockDetailId) {
		this.openingStockDetailId = openingStockDetailId;
	}

	public int getOpeningStockHeaderId() {
		return openingStockHeaderId;
	}

	public void setOpeningStockHeaderId(int openingStockHeaderId) {
		this.openingStockHeaderId = openingStockHeaderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}

	public int getPhysicalStock() {
		return physicalStock;
	}

	public void setPhysicalStock(int physicalStock) {
		this.physicalStock = physicalStock;
	}

	public int getStockDifference() {
		return stockDifference;
	}

	public void setStockDifference(int stockDifference) {
		this.stockDifference = stockDifference;
	}

	public int getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(int totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public int getTotalGrnGvn() {
		return totalGrnGvn;
	}

	public void setTotalGrnGvn(int totalGrnGvn) {
		this.totalGrnGvn = totalGrnGvn;
	}

	public int getTotalSell() {
		return totalSell;
	}

	public void setTotalSell(int totalSell) {
		this.totalSell = totalSell;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	
	@Override
	public String toString() {
		return "PostFrItemStockDetail [openingStockDetailId=" + openingStockDetailId + ", openingStockHeaderId="
				+ openingStockHeaderId + ", itemId=" + itemId + ", openingStock=" + openingStock + ", physicalStock="
				+ physicalStock + ", stockDifference=" + stockDifference + ", totalPurchase=" + totalPurchase
				+ ", totalGrnGvn=" + totalGrnGvn + ", totalSell=" + totalSell + ", remark=" + remark + "]";
	}
	
	
	

}
