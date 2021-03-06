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
private String srNo;

@Column(name="sp_delivery_place")
private String spDeliveryPlace;

public String getFrCode() {
	return frCode;
}

public String getFrName() {
	return frName;
}

public int getSpId() {
	return spId;
}

public String getSrNo() {
	return srNo;
}

public String getSpDeliveryPlace() {
	return spDeliveryPlace;
}

public void setFrCode(String frCode) {
	this.frCode = frCode;
}

public void setFrName(String frName) {
	this.frName = frName;
}

public void setSpId(int spId) {
	this.spId = spId;
}

public void setSrNo(String srNo) {
	this.srNo = srNo;
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
