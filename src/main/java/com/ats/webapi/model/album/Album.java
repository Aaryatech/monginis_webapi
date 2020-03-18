package com.ats.webapi.model.album;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_sp_cake_album")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int albumId;

	private String albumCode;

	private String albumName;

	private String photo1;
	private String photo2;

	private float minWt;
	private float maxWt;

	private int delStatus;

	private int spId;

	private String flavourId;
	private int isActive;
	private int isVisibleToAlbum;

	@Column(name = "album_desc")
	private String albumDesc;

	// Extra Not for save/Insert Just to call other methods to reduce Android
	// Webservice calls

	// 18-03-2020
@Transient
	private int enqNo;
@Transient
	private int status;
@Transient
	private List<Integer> menuList;
@Transient
	List<Integer> frIds;
	
@Transient 
private String token;




	public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

	public int getEnqNo() {
		return enqNo;
	}

	public void setEnqNo(int enqNo) {
		this.enqNo = enqNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Integer> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Integer> menuList) {
		this.menuList = menuList;
	}

	public List<Integer> getFrIds() {
		return frIds;
	}

	public void setFrIds(List<Integer> frIds) {
		this.frIds = frIds;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumCode() {
		return albumCode;
	}

	public void setAlbumCode(String albumCode) {
		this.albumCode = albumCode;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public float getMinWt() {
		return minWt;
	}

	public void setMinWt(float minWt) {
		this.minWt = minWt;
	}

	public float getMaxWt() {
		return maxWt;
	}

	public void setMaxWt(float maxWt) {
		this.maxWt = maxWt;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public String getFlavourId() {
		return flavourId;
	}

	public void setFlavourId(String flavourId) {
		this.flavourId = flavourId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getAlbumDesc() {
		return albumDesc;
	}

	public void setAlbumDesc(String albumDesc) {
		this.albumDesc = albumDesc;
	}

	public int getIsVisibleToAlbum() {
		return isVisibleToAlbum;
	}

	public void setIsVisibleToAlbum(int isVisibleToAlbum) {
		this.isVisibleToAlbum = isVisibleToAlbum;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", albumCode=" + albumCode + ", albumName=" + albumName + ", photo1="
				+ photo1 + ", photo2=" + photo2 + ", minWt=" + minWt + ", maxWt=" + maxWt + ", delStatus=" + delStatus
				+ ", spId=" + spId + ", flavourId=" + flavourId + ", isActive=" + isActive + ", isVisibleToAlbum="
				+ isVisibleToAlbum + ", albumDesc=" + albumDesc + ", enqNo=" + enqNo + ", status=" + status
				+ ", menuList=" + menuList + ", frIds=" + frIds + "]";
	}


}
