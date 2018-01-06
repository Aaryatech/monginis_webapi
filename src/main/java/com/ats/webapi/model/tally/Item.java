package com.ats.webapi.model.tally;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;

@Entity
@Table(name="m_item")
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="item_name")
	private String itemName;

	@Column(name="item_group")
	private String itemGroup;
	
	@Column(name="sub_group")
	private String subGroup;
	
	@Column(name="item_grp3")
	private String subSubGroup;
	
	@Column(name="item_hsncd")
	private String hsnCode;
	
	@Column(name="item_uom")
	private String uom;
	
	@Column(name="item_tax1")
	private float sgstPer;
	
	@Column(name="item_tax2")
	private float cgstPer;
	
	@Column(name="item_tax3")
	private float igstPer;

	@Column(name="item_cess")
	private float cessPer;

	@PostLoad
	public void onLoad() {
		if(this.subSubGroup.equalsIgnoreCase("1"))
		{
			this.subSubGroup="Small";
		}
		else
			if(this.subSubGroup.equalsIgnoreCase("2"))
			{
				this.subSubGroup="Medium";
				
			}else
				if(this.subSubGroup.equalsIgnoreCase("3"))
				{
					this.subSubGroup="Large";
				}
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemGroup=" + itemGroup + ", subGroup=" + subGroup
				+ ", subSubGroup=" + subSubGroup + ", hsnCode=" + hsnCode + ", uom=" + uom + ", sgstPer=" + sgstPer
				+ ", cgstPer=" + cgstPer + ", igstPer=" + igstPer + ", cessPer=" + cessPer + "]";
	}


}
