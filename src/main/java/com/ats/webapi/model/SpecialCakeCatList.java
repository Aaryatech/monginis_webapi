package com.ats.webapi.model;

import java.util.List;

public class SpecialCakeCatList {

	List<SpecialCakeCat> specialCakeCat;
	Info info;
	public List<SpecialCakeCat> getSpecialCakeCat() {
		return specialCakeCat;
	}
	public void setSpecialCakeCat(List<SpecialCakeCat> specialCakeCat) {
		this.specialCakeCat = specialCakeCat;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "SpecialCakeCatList [specialCakeCat=" + specialCakeCat + ", info=" + info + "]";
	}

	

}
