package com.ats.webapi.model.album;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuForAlbum {
	@Id
	private String id;
	private String itemShow;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemShow() {
		return itemShow;
	}
	public void setItemShow(String itemShow) {
		this.itemShow = itemShow;
	}
	@Override
	public String toString() {
		return "MenuForAlbum [id=" + id + ", itemShow=" + itemShow + "]";
	}
	
	

}
