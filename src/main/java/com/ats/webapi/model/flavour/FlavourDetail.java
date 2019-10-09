package com.ats.webapi.model.flavour;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_flavour_detail")
public class FlavourDetail {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="flavour_detail_id")
	private int flavourDetailId;
	
	@Column(name="flavour_id")
	private int flavourId;
	
	@Column(name="flavour_name")
	private String flavourName;
	
	@Column(name="no_pieces_per_flavour")
	private int noPiecesPerFlavour;

	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_type")
	private int rmType;
	
	@Column(name="rm_uom_id")
	private int rmUomId;
	
	@Column(name="rm_qty")
	private float rmQty;
	
	@Column(name="rm_weight")
	private float rmWeight;
	
	@Column(name="sequence_no")
	private int sequenceNo;
	
	@Column(name="del_Status")
	private int delStatus;
	
	@Column(name="int_1")
	private int int1;

	@Column(name="int_2")
	private int int2;
	
	@Column(name="varchar_1")
	private String varchar1;
	
	@Column(name="varchar_2")
	private String varchar2;
	
	@Column(name="boll1")
	private int boll1;
	
	@Column(name="boll2")
	private int boll2;

	public int getFlavourDetailId() {
		return flavourDetailId;
	}

	public void setFlavourDetailId(int flavourDetailId) {
		this.flavourDetailId = flavourDetailId;
	}

	public int getFlavourId() {
		return flavourId;
	}

	public void setFlavourId(int flavourId) {
		this.flavourId = flavourId;
	}

	public String getFlavourName() {
		return flavourName;
	}

	public void setFlavourName(String flavourName) {
		this.flavourName = flavourName;
	}

	public int getNoPiecesPerFlavour() {
		return noPiecesPerFlavour;
	}

	public void setNoPiecesPerFlavour(int noPiecesPerFlavour) {
		this.noPiecesPerFlavour = noPiecesPerFlavour;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

	public int getRmUomId() {
		return rmUomId;
	}

	public void setRmUomId(int rmUomId) {
		this.rmUomId = rmUomId;
	}

	public float getRmQty() {
		return rmQty;
	}

	public void setRmQty(float rmQty) {
		this.rmQty = rmQty;
	}

	public float getRmWeight() {
		return rmWeight;
	}

	public void setRmWeight(float rmWeight) {
		this.rmWeight = rmWeight;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public String getVarchar1() {
		return varchar1;
	}

	public void setVarchar1(String varchar1) {
		this.varchar1 = varchar1;
	}
	

	public String getVarchar2() {
		return varchar2;
	}

	public void setVarchar2(String varchar2) {
		this.varchar2 = varchar2;
	}

	public int getBoll1() {
		return boll1;
	}

	public void setBoll1(int boll1) {
		this.boll1 = boll1;
	}

	public int getBoll2() {
		return boll2;
	}

	public void setBoll2(int boll2) {
		this.boll2 = boll2;
	}

	@Override
	public String toString() {
		return "FlavourDetail [flavourDetailId=" + flavourDetailId + ", flavourId=" + flavourId + ", flavourName="
				+ flavourName + ", noPiecesPerFlavour=" + noPiecesPerFlavour + ", rmId=" + rmId + ", rmName=" + rmName
				+ ", rmType=" + rmType + ", rmUomId=" + rmUomId + ", rmQty=" + rmQty + ", rmWeight=" + rmWeight
				+ ", sequenceNo=" + sequenceNo + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2
				+ ", varchar1=" + varchar1 + ", varchar2=" + varchar2 + ", boll1=" + boll1 + ", boll2=" + boll2 + "]";
	}

	
	
}
