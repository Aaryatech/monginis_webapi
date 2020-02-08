package com.ats.webapi.model.alenqchat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ats.webapi.model.Info;

@Entity
@Table(name = "t_album_enq_chat")
public class AlbumEnqChat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int albEnqChatId;

	private int enqNo;// PK of t_album_enquiry

	private int chatType;

	private String chatDesc;
	private String chatDttime;

	private int chatBy;
	private int delStatus;

	private int isRead;
	private int isClosed;

	private String exVar1;
	private String exVar2;

	private int exInt1;
	private float exFloat1;

	public int getAlbEnqChatId() {
		return albEnqChatId;
	}

	public void setAlbEnqChatId(int albEnqChatId) {
		this.albEnqChatId = albEnqChatId;
	}

	public int getEnqNo() {
		return enqNo;
	}

	public void setEnqNo(int enqNo) {
		this.enqNo = enqNo;
	}

	public int getChatType() {
		return chatType;
	}

	public void setChatType(int chatType) {
		this.chatType = chatType;
	}

	public String getChatDesc() {
		return chatDesc;
	}

	public void setChatDesc(String chatDesc) {
		this.chatDesc = chatDesc;
	}

	public String getChatDttime() {
		return chatDttime;
	}

	public void setChatDttime(String chatDttime) {
		this.chatDttime = chatDttime;
	}

	public int getChatBy() {
		return chatBy;
	}

	public void setChatBy(int chatBy) {
		this.chatBy = chatBy;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public int getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(int isClosed) {
		this.isClosed = isClosed;
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

	public float getExFloat1() {
		return exFloat1;
	}

	public void setExFloat1(float exFloat1) {
		this.exFloat1 = exFloat1;
	}

	@javax.persistence.Transient
	private Info info;

	@Override
	public String toString() {
		return "AlbumEnqChat [albEnqChatId=" + albEnqChatId + ", enqNo=" + enqNo + ", chatType=" + chatType
				+ ", chatDesc=" + chatDesc + ", chatDttime=" + chatDttime + ", chatBy=" + chatBy + ", delStatus="
				+ delStatus + ", isRead=" + isRead + ", isClosed=" + isClosed + ", exVar1=" + exVar1 + ", exVar2="
				+ exVar2 + ", exInt1=" + exInt1 + ", exFloat1=" + exFloat1 + "]";
	}

}
