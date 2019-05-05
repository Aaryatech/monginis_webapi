package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SpCakeWtCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private float spSelectedWt;
	private int count;

	public float getSpSelectedWt() {
		return spSelectedWt;
	}

	public void setSpSelectedWt(float spSelectedWt) {
		this.spSelectedWt = spSelectedWt;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SpCakeWtCount [spSelectedWt=" + spSelectedWt + ", count=" + count + "]";
	}

}
