package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity(name="spCakeOrdersBean")
//bean to be changed frId inserted 
@Immutable
public class SpCakeOrdersBean implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_vno")
	private int spVno;
	
	
	



	@Column(name="sp_code")//m_sp_cake
	private String spCode;
	
	@Column(name="sp_name")//m_sp_cake
	private String spName;
	
	//@Column(name="sp_flavour")
	private String spFlavour;
	
	//@Column(name="sp_events")
	private String spEvents;
	
	@Column(name="sp_delivery_dt")
	private String spDeliverydt;
	
	//@Column(name="sp_price")
	private String spPrice;
	
	@Column(name="sp_add_rate")
	private String spAddrate;
	
	
	@Column(name="fr_name")//franchisee table
	private String frName;
	
	

	@Column(name="item_id")
	private String itemId;
	

	
	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public int getSpVno() {
		return spVno;
	}


	public void setSpVno(int spVno) {
		this.spVno = spVno;
	}


	public String getSpCode() {
		return spCode;
	}


	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}


	public String getSpName() {
		return spName;
	}


	public void setSpName(String spName) {
		this.spName = spName;
	}


	public String getSpFlavour() {
		return spFlavour;
	}


	public void setSpFlavour(String spFlavour) {
		this.spFlavour = spFlavour;
	}


	public String getSpEvents() {
		return spEvents;
	}


	public void setSpEvents(String spEvents) {
		this.spEvents = spEvents;
	}


	public String getSpDeliverydt() {
		return spDeliverydt;
	}


	public void setSpDeliverydt(String spDeliverydt) {
		this.spDeliverydt = spDeliverydt;
	}


	public String getSpPrice() {
		return spPrice;
	}


	public void setSpPrice(String spPrice) {
		this.spPrice = spPrice;
	}



	

	public String getSpAddrate() {
		return spAddrate;
	}


	public void setSpAddrate(String spAddrate) {
		this.spAddrate = spAddrate;
	}


	public String getFrName() {
		return frName;
	}


	public void setFrName(String frName) {
		this.frName = frName;
	}


	@Override
	public String toString() {
		return "SpCakeOrdersBean [spVno=" + spVno + ", spCode=" + spCode + ", spName=" + spName + ", spFlavour="
				+ spFlavour + ", spEvents=" + spEvents + ", spDeliverydt=" + spDeliverydt + ", spPrice=" + spPrice
				+ ", spAddrate=" + spAddrate + ", frName=" + frName + ", itemId=" + itemId + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	

}
