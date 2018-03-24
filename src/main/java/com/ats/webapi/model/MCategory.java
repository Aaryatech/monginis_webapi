package com.ats.webapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "m_category")
public class MCategory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	@Column(name="is_same_day")
    private int isSameDay;
	
	@Column(name="del_status")
    private int delStatus;
	
	@OneToMany(mappedBy="catId",cascade=CascadeType.ALL)
	private List<SubCategory> subCategory=new ArrayList<SubCategory>();
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public int getIsSameDay() {
		return isSameDay;
	}
	public void setIsSameDay(int isSameDay) {
		this.isSameDay = isSameDay;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public List<SubCategory> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(List<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + ", isSameDay=" + isSameDay + ", delStatus="
				+ delStatus + ", subCategory=" + subCategory + "]";
	}
	
	

}
