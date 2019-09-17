package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_cat_sub2")
public class SubCategory2 implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mini_cat_id")
	private int miniCatId;
	
	@Column(name="mini_cat_name")
	private String miniCatName;
	 
	@Column(name="sub_cat_id")
	private int subCatId;	
	
	@Column(name="del_status")
	private int delStatus;

	public int getMiniCatId() {
		return miniCatId;
	}

	public String getMiniCatName() {
		return miniCatName;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setMiniCatId(int miniCatId) {
		this.miniCatId = miniCatId;
	}

	public void setMiniCatName(String miniCatName) {
		this.miniCatName = miniCatName;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "SubCategory2 [miniCatId=" + miniCatId + ", miniCatName=" + miniCatName + ", subCatId=" + subCatId
				+ ", delStatus=" + delStatus + "]";
	}

	
	
}
