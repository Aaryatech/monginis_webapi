package com.ats.webapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_production_plan_header")
public class PostProductionHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="production_header_id")
	private int productionHeaderId;
	 
	@Column(name="cat_id")
	private int itemGrp1;
	
	@Column(name="time_slot")
	private int timeSlot;
	
	@Column(name="production_date")
	private Date productionDate;
	
	@Transient
	private List<PostProductionDetail> postProductionDetail;

	public int getProductionHeaderId() {
		return productionHeaderId;
	}

	public void setProductionHeaderId(int productionHeaderId) {
		this.productionHeaderId = productionHeaderId;
	}


	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public List<PostProductionDetail> getPostProductionDetail() {
		return postProductionDetail;
	}

	public void setPostProductionDetail(List<PostProductionDetail> postProductionDetail) {
		this.postProductionDetail = postProductionDetail;
	}

	public int getItemGrp1() {
		return itemGrp1;
	}

	public void setItemGrp1(int itemGrp1) {
		this.itemGrp1 = itemGrp1;
	}

	@Override
	public String toString() {
		return "PostProductionHeader [productionHeaderId=" + productionHeaderId + ", itemGrp1=" + itemGrp1
				+ ", timeSlot=" + timeSlot + ", productionDate=" + productionDate + ", postProductionDetail="
				+ postProductionDetail + "]";
	}

	
	
	
	
	

}
