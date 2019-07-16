package com.ats.webapi.model.album;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.OrderSpecialCake;

public class SearchAlbumCakeResponse {

	ErrorMessage errorMessage;
	OrderSpecialCake specialCake;
	Album album;
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	public OrderSpecialCake getSpecialCake() {
		return specialCake;
	}
	public void setSpecialCake(OrderSpecialCake specialCake) {
		this.specialCake = specialCake;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	@Override
	public String toString() {
		return "SearchAlbumCakeResponse [errorMessage=" + errorMessage + ", specialCake=" + specialCake + ", album="
				+ album + "]";
	}
	
	
	
}
