package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SpCakeDispatchReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="fr_code")
private String frCode;

@Column(name="fr_name")
private String frName;

@Column(name="sp_id")
private int spId;

@Column(name="sr_no")
private int srNo;

@Column(name="sp_delivery_place")
private String spDeliveryPlace;

public String getFrCode() {
	return frCode;
}
public void setFrCode(String frCode) {
	this.frCode = frCode;
}
public String getFrName() {
	return frName;
}
public void setFrName(String frName) {
	this.frName = frName;
}
public int getSpId() {
	return spId;
}
public void setSpId(int spId) {
	this.spId = spId;
}
public int getSrNo() {
	return srNo;
}
public void setSrNo(int srNo) {
	this.srNo = srNo;
}
public String getSpDeliveryPlace() {
	return spDeliveryPlace;
}
public void setSpDeliveryPlace(String spDeliveryPlace) {
	this.spDeliveryPlace = spDeliveryPlace;
}
@Override
public String toString() {
	return "SpCakeDispatchReport [frCode=" + frCode + ", frName=" + frName + ", spId=" + spId + ", srNo=" + srNo
			+ ", spDeliveryPlace=" + spDeliveryPlace + "]";
}
 

}
