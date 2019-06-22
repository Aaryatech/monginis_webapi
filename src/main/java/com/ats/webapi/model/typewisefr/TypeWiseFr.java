package com.ats.webapi.model.typewisefr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_typewise_fr")
public class TypeWiseFr {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int typeId;
	private String typeName;
	private String frIds;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getFrIds() {
		return frIds;
	}

	public void setFrIds(String frIds) {
		this.frIds = frIds;
	}

	@Override
	public String toString() {
		return "TypeWiseFr [typeId=" + typeId + ", typeName=" + typeName + ", frIds=" + frIds + "]";
	}

}
