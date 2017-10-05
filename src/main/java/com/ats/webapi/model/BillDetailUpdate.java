package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity()
public class BillDetailUpdate {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_no")
	private int billDetailNo;
	
	@Column(name="bill_qty")
	int  billQty;

	@Column(name="total")
	float  total;
	
	@Column(name="total_without_tax")
	float  totalWithoutTax;

	public int getBillDetailNo() {
		return billDetailNo;
	}

	public void setBillDetailNo(int billDetailNo) {
		this.billDetailNo = billDetailNo;
	}

	public int getBillQty() {
		return billQty;
	}

	public void setBillQty(int billQty) {
		this.billQty = billQty;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getTotalWithoutTax() {
		return totalWithoutTax;
	}

	public void setTotalWithoutTax(float totalWithoutTax) {
		this.totalWithoutTax = totalWithoutTax;
	}
	
	
	

}
