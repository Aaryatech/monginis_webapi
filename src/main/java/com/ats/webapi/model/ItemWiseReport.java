package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemWiseReport {
	
		
		private int itemId;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="bill_detail_no")
		private int billDetailNo;
		
		private float rate;
		
		private int qty;
		
		private float total;
		
		private String itemName;

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public int getBillDetailNo() {
			return billDetailNo;
		}

		public void setBillDetailNo(int billDetailNo) {
			this.billDetailNo = billDetailNo;
		}

		public float getRate() {
			return rate;
		}

		public void setRate(float rate) {
			this.rate = rate;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public float getTotal() {
			return total;
		}

		public void setTotal(float total) {
			this.total = total;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		@Override
		public String toString() {
			return "ItemWiseReport [itemId=" + itemId + ", billDetailNo=" + billDetailNo + ", rate=" + rate + ", qty="
					+ qty + ", total=" + total + ", itemName=" + itemName + "]";
		}

		
		
		
}
