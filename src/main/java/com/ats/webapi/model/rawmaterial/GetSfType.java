package com.ats.webapi.model.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_sf_type")
public class GetSfType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
    
	@Column(name="sf_name")
	private String sfName;
	
	@Column(name="del_status")
	private int delStatus;

	public int getId() {
		return id;
	}

	public String getSfName() {
		return sfName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSfName(String sfName) {
		this.sfName = sfName;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
}
