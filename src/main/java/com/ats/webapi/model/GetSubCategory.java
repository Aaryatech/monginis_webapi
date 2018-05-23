package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "m_cat_sub")
public class GetSubCategory implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sub_cat_id")
	private int subCatId;
	
	@Column(name="sub_cat_name")
	private String subCatName;
	
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="del_status")
	private int delStatus;

	public int getSubCatId() {
		return subCatId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public int getCatId() {
		return catId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GetSubCategory [subCatId=" + subCatId + ", subCatName=" + subCatName + ", catId=" + catId
				+ ", delStatus=" + delStatus + "]";
	}	
	
	
}
