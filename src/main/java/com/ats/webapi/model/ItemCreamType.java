package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_cream_type")
public class ItemCreamType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_cream_id")
	private int itemCreamId;
	
	@Column(name="item_cream_name")
	private String itemCreamName;
	
	@Column(name="sequence_no")
	private int sequenceNo;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="category_id")
	private int categoryId;

	public int getItemCreamId() {
		return itemCreamId;
	}

	public void setItemCreamId(int itemCreamId) {
		this.itemCreamId = itemCreamId;
	}

	public String getItemCreamName() {
		return itemCreamName;
	}

	public void setItemCreamName(String itemCreamName) {
		this.itemCreamName = itemCreamName;
	}
	
	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ItemCreamType [itemCreamId=" + itemCreamId + ", itemCreamName=" + itemCreamName + ", sequenceNo="
				+ sequenceNo + ", delStatus=" + delStatus + ", categoryId=" + categoryId + "]";
	}


}
