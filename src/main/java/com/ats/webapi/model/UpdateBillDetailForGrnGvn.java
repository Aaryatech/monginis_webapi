package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_bill_detail")
public class UpdateBillDetailForGrnGvn implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_no")
	 private int billNo;

	@Column(name="is_grngvn_applied")
	 private int isGrngvnApplied;

	

	public int getIsGrngvnApplied() {
		return isGrngvnApplied;
	}

	public void setIsGrngvnApplied(int isGrngvnApplied) {
		this.isGrngvnApplied = isGrngvnApplied;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	 
	 
	 
}
