package com.ats.webapi.model.logistics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_logis_sprpart")
public class SparePart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spr_id")
	private int sprId; 
	
	@Column(name = "spr_name")
	private String sprName;

	@Column(name = "typeId")
	private int typeId;
	
	@Column(name = "group_id")
	private int groupId; 
	
	@Column(name = "spr_uom")
	private String sprUom;

	@Column(name = "spr_date1")
	private Date sprDate1;
	
	@Column(name = "spr_rate1")
	private float sprRate1;
	
	@Column(name = "spr_date2")
	private Date sprDate2;
	
	@Column(name = "spr_rate2")
	private float sprRate2;
	
	@Column(name = "spr_date3")
	private Date sprDate3;
	
	@Column(name = "spr_rate3")
	private float sprRate3;
	
	@Column(name = "spr_iscritical")
	private int sprIscritical;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "spr_warranty_period")
	private float sprWarrantyPeriod;
	
	@Column(name = "make_id")
	private int makeId;
	
	@Column(name = "spr_type")
	private int sprType;
	
	@Column(name = "cgst")
	private float cgst;
	
	@Column(name = "sgst")
	private float sgst;
	
	@Column(name = "igst")
	private float igst;
	
	@Column(name = "disc")
	private float disc;
	
	@Column(name = "extra_charges")
	private float extraCharges;

	public int getSprId() {
		return sprId;
	}

	public void setSprId(int sprId) {
		this.sprId = sprId;
	}

	public String getSprName() {
		return sprName;
	}

	public void setSprName(String sprName) {
		this.sprName = sprName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getSprUom() {
		return sprUom;
	}

	public void setSprUom(String sprUom) {
		this.sprUom = sprUom;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSprDate1() {
		return sprDate1;
	}

	public void setSprDate1(Date sprDate1) {
		this.sprDate1 = sprDate1;
	}

	public float getSprRate1() {
		return sprRate1;
	}

	public void setSprRate1(float sprRate1) {
		this.sprRate1 = sprRate1;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSprDate2() {
		return sprDate2;
	}

	public void setSprDate2(Date sprDate2) {
		this.sprDate2 = sprDate2;
	}

	public float getSprRate2() {
		return sprRate2;
	}

	public void setSprRate2(float sprRate2) {
		this.sprRate2 = sprRate2;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getSprDate3() {
		return sprDate3;
	}

	public void setSprDate3(Date sprDate3) {
		this.sprDate3 = sprDate3;
	}

	public float getSprRate3() {
		return sprRate3;
	}

	public void setSprRate3(float sprRate3) {
		this.sprRate3 = sprRate3;
	}

	public int getSprIscritical() {
		return sprIscritical;
	}

	public void setSprIscritical(int sprIscritical) {
		this.sprIscritical = sprIscritical;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public float getSprWarrantyPeriod() {
		return sprWarrantyPeriod;
	}

	public void setSprWarrantyPeriod(float sprWarrantyPeriod) {
		this.sprWarrantyPeriod = sprWarrantyPeriod;
	}

	public int getMakeId() {
		return makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public int getSprType() {
		return sprType;
	}

	public void setSprType(int sprType) {
		this.sprType = sprType;
	}
	

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getDisc() {
		return disc;
	}

	public void setDisc(float disc) {
		this.disc = disc;
	}

	public float getExtraCharges() {
		return extraCharges;
	}

	public void setExtraCharges(float extraCharges) {
		this.extraCharges = extraCharges;
	}

	@Override
	public String toString() {
		return "SparePart [sprId=" + sprId + ", sprName=" + sprName + ", typeId=" + typeId + ", groupId=" + groupId
				+ ", sprUom=" + sprUom + ", sprDate1=" + sprDate1 + ", sprRate1=" + sprRate1 + ", sprDate2=" + sprDate2
				+ ", sprRate2=" + sprRate2 + ", sprDate3=" + sprDate3 + ", sprRate3=" + sprRate3 + ", sprIscritical="
				+ sprIscritical + ", delStatus=" + delStatus + ", sprWarrantyPeriod=" + sprWarrantyPeriod + ", makeId="
				+ makeId + ", sprType=" + sprType + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", disc="
				+ disc + ", extraCharges=" + extraCharges + "]";
	}
	
	

}
