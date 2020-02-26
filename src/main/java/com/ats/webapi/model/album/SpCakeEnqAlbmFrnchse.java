package com.ats.webapi.model.album;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SpCakeEnqAlbmFrnchse {


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
	
	private int enquiryNo;	
	private String custName;
	private String mobileNo;
	private String photo;
	private String enquiryDate;
	private String enquiryDateTime;
	private String approvedDateTime;
	private int approvedUserId;
	private String approvedUserName;
	private int status;
	private int noNotifictnFired;
	private String exVar1;
	private String exVar2;
	private int exInt1;
	private int exInt2;
	
	private int frId;
	private String frName;
	
	private int mrpRate1;
	
	
	

	
	public int getMrpRate1() {
		return mrpRate1;
	}

	public void setMrpRate1(int mrpRate1) {
		this.mrpRate1 = mrpRate1;
	}

	private String albumDesc;

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

	public int getEnquiryNo() {
		return enquiryNo;
	}

	public void setEnquiryNo(int enquiryNo) {
		this.enquiryNo = enquiryNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(String enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public String getEnquiryDateTime() {
		return enquiryDateTime;
	}

	public void setEnquiryDateTime(String enquiryDateTime) {
		this.enquiryDateTime = enquiryDateTime;
	}

	public String getApprovedDateTime() {
		return approvedDateTime;
	}

	public void setApprovedDateTime(String approvedDateTime) {
		this.approvedDateTime = approvedDateTime;
	}

	public int getApprovedUserId() {
		return approvedUserId;
	}

	public void setApprovedUserId(int approvedUserId) {
		this.approvedUserId = approvedUserId;
	}

	public String getApprovedUserName() {
		return approvedUserName;
	}

	public void setApprovedUserName(String approvedUserName) {
		this.approvedUserName = approvedUserName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNoNotifictnFired() {
		return noNotifictnFired;
	}

	public void setNoNotifictnFired(int noNotifictnFired) {
		this.noNotifictnFired = noNotifictnFired;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	@Override
	public String toString() {
		return "SpCakeEnqAlbmFrnchse [albumId=" + albumId + ", albumCode=" + albumCode + ", albumName=" + albumName
				+ ", photo1=" + photo1 + ", photo2=" + photo2 + ", minWt=" + minWt + ", maxWt=" + maxWt + ", delStatus="
				+ delStatus + ", spId=" + spId + ", flavourId=" + flavourId + ", isActive=" + isActive
				+ ", isVisibleToAlbum=" + isVisibleToAlbum + ", enquiryNo=" + enquiryNo + ", custName=" + custName
				+ ", mobileNo=" + mobileNo + ", photo=" + photo + ", enquiryDate=" + enquiryDate + ", enquiryDateTime="
				+ enquiryDateTime + ", approvedDateTime=" + approvedDateTime + ", approvedUserId=" + approvedUserId
				+ ", approvedUserName=" + approvedUserName + ", status=" + status + ", noNotifictnFired="
				+ noNotifictnFired + ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", exInt1=" + exInt1 + ", exInt2="
				+ exInt2 + ", frId=" + frId + ", frName=" + frName + ", mrpRate1=" + mrpRate1 + ", albumDesc="
				+ albumDesc + "]";
	}
	
	
}
