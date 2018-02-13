package com.ats.webapi.model.tray;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FrOutTrays implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tray_type")
	private int trayType;
	
	@Column(name="no_of_tray")
	private float noOfTray;

	public int getTrayType() {
		return trayType;
	}

	public void setTrayType(int trayType) {
		this.trayType = trayType;
	}

	public float getNoOfTray() {
		return noOfTray;
	}

	public void setNoOfTray(float noOfTray) {
		this.noOfTray = noOfTray;
	}

	@Override
	public String toString() {
		return "FrOutTrays [trayType=" + trayType + ", noOfTray=" + noOfTray + "]";
	}
	
	
}
