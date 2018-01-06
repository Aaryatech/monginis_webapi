package com.ats.webapi.model.tally;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_sp_cake")
public class SpecialCake implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_id")
	private int id;
	
	@Column(name="sp_name")
	private String ItemName;

	@Transient
	private String itemGroup;
	
	@Transient
	private String subGroup;
	
	@Transient
	private String subSubGroup;
	
	@Column(name="sp_hsncd")
	private String hsnCode;
	
	@Column(name="sp_uom")
	private String uom;
	
	@Column(name="sp_tax1")
	private float sgstPer;
	
	@Column(name="sp_tax2")
	private float cgstPer;
	
	@Column(name="sp_tax3")
	private float igstPer;

	@Column(name="sp_cess")
	private float cessPer;

	@PostLoad
	public void onLoad() {
		this.itemGroup="Special Cake";
		this.subGroup="Special Cake";
		this.subSubGroup="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

	public String getSubSubGroup() {
		return subSubGroup;
	}

	public void setSubSubGroup(String subSubGroup) {
		this.subSubGroup = subSubGroup;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	@Override
	public String toString() {
		return "SpecialCake [id=" + id + ", ItemName=" + ItemName + ", itemGroup=" + itemGroup + ", subGroup="
				+ subGroup + ", subSubGroup=" + subSubGroup + ", hsnCode=" + hsnCode + ", uom=" + uom + ", sgstPer="
				+ sgstPer + ", cgstPer=" + cgstPer + ", igstPer=" + igstPer + ", cessPer=" + cessPer + "]";
	}

	
}
