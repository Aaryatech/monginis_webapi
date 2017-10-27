package com.ats.webapi.model;

public class GetCurrentStockDetails {
	
	private int itemId;
	private int openingBalance;
	private int totalPurchase;
	private int totalGrnGvn;
	private int totalSell;
	
	
	
	
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(int openingBalance) {
		this.openingBalance = openingBalance;
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
	
	
	@Override
	public String toString() {
		return "GetCurrentStockDetails [itemId=" + itemId + ", openingBalance=" + openingBalance + ", totalPurchase="
				+ totalPurchase + ", totalGrnGvn=" + totalGrnGvn + ", totalSell=" + totalSell + "]";
	}
	

	
	

}
