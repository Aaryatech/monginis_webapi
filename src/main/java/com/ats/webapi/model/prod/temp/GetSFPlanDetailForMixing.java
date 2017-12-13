package com.ats.webapi.model.prod.temp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//same Bean Used for Bom and Mixing
@Entity
public class GetSFPlanDetailForMixing implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_detail_id")
	private int itemDetailId;
	
	
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="rm_type")
	private int rmType;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="uom")
	private String uom;
	
	
	@Column(name="rm_qty")
	private float rmQty;
	
	/*@Column(name="rm_weight")
	private float rmWeight;
	*/
	@Column(name="no_pieces_per_item")
	private float noPiecesPerItem;
	
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="plan_qty")
	private float planQty;
	
	
	
	int total;
	
	
	public int getItemDetailId() {
		return itemDetailId;
	}
	public void setItemDetailId(int itemDetailId) {
		this.itemDetailId = itemDetailId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRmType() {
		return rmType;
	}
	public void setRmType(int rmType) {
		this.rmType = rmType;
	}
	public int getRmId() {
		return rmId;
	}
	public void setRmId(int rmId) {
		this.rmId = rmId;
	}
	
	
	
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public float getRmQty() {
		return rmQty;
	}
	public void setRmQty(float rmQty) {
		this.rmQty = rmQty;
	}
/*	public float getRmWeight() {
		return rmWeight;
	}
	public void setRmWeight(float rmWeight) {
		this.rmWeight = rmWeight;
	}*/
	public float getNoPiecesPerItem() {
		return noPiecesPerItem;
	}
	public void setNoPiecesPerItem(float noPiecesPerItem) {
		this.noPiecesPerItem = noPiecesPerItem;
	}
	public String getRmName() {
		return rmName;
	}
	public void setRmName(String rmName) {
		this.rmName = rmName;
	}
	public float getPlanQty() {
		return planQty;
	}
	public void setPlanQty(float planQty) {
		this.planQty = planQty;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	/*rm_id
	item_id
	rm_name
	rm_type
	uom
	
	unit as
	total as
	
	plan_qty
	rm_qty
	no_pieces_per_item
	*/
	

}
