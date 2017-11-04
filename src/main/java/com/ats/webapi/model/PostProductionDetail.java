package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "t_production_plan_detail")
public class PostProductionDetail {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="production_detail_id")
	private int productionDetailId;
	
	@Column(name="production_header_id")
	private int productionHeaderId;

	@Column(name="production_qty")
	private int productionQty;
	
	@Column(name="item_id")
	private int itemId;

	public int getProductionDetailId() {
		return productionDetailId;
	}

	public void setProductionDetailId(int productionDetailId) {
		this.productionDetailId = productionDetailId;
	}

	public int getProductionHeaderId() {
		return productionHeaderId;
	}

	public void setProductionHeaderId(int productionHeaderId) {
		this.productionHeaderId = productionHeaderId;
	}

	public int getProductionQty() {
		return productionQty;
	}

	public void setProductionQty(int productionQty) {
		this.productionQty = productionQty;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "PostProductionDetail [productionDetailId=" + productionDetailId + ", productionHeaderId="
				+ productionHeaderId + ", productionQty=" + productionQty + ", itemId=" + itemId + "]";
	}
	
	
}
