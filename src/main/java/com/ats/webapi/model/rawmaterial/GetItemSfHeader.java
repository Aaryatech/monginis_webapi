package com.ats.webapi.model.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetItemSfHeader {

	
	
	@Column(name="sf_name")
	private String sfName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sf_id")
	private int sfId;
	
	
	@Column(name="sf_type")
	private String sfType;
	
	
	@Column(name="sf_uom_id")
	private int sfUomId;
	
	@Column(name="sf_weight")
	private int sfWeight;
	
	@Column(name="stock_qty")
	private int stockQty;
	
	@Column(name="min_level_qty")
	private float minLevelQty;
	
	@Column(name="max_level_qty")
	private float maxLevelQty;
	
	@Column(name="reorder_level_qty")
	private float reorderLevelQty;

	@Column(name="del_status")
	private int delStatus;

	
	
	public int getSfId() {
		return sfId;
	}

	public String getSfName() {
		return sfName;
	}

	public String getSfType() {
		return sfType;
	}

	public int getSfUomId() {
		return sfUomId;
	}

	public int getSfWeight() {
		return sfWeight;
	}

	public int getStockQty() {
		return stockQty;
	}

	public float getMinLevelQty() {
		return minLevelQty;
	}

	public float getMaxLevelQty() {
		return maxLevelQty;
	}

	public float getReorderLevelQty() {
		return reorderLevelQty;
	}

	public int getDelStatus() {
		return delStatus;
	}

	
	

	public void setSfId(int sfId) {
		this.sfId = sfId;
	}

	public void setSfName(String sfName) {
		this.sfName = sfName;
	}

	public void setSfType(String sfType) {
		this.sfType = sfType;
	}

	public void setSfUomId(int sfUomId) {
		this.sfUomId = sfUomId;
	}

	public void setSfWeight(int sfWeight) {
		this.sfWeight = sfWeight;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}

	public void setMinLevelQty(float minLevelQty) {
		this.minLevelQty = minLevelQty;
	}

	public void setMaxLevelQty(float maxLevelQty) {
		this.maxLevelQty = maxLevelQty;
	}

	public void setReorderLevelQty(float reorderLevelQty) {
		this.reorderLevelQty = reorderLevelQty;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	
}
