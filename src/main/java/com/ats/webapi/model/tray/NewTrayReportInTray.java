package com.ats.webapi.model.tray;

public class NewTrayReportInTray {
	private String id;
	private int tranId;
	private int tranDetailId;

	private String outtrayDate;
	private int outtrayBig;
	private int outtraySmall;
	private int outtrayLead;

	private int intrayId;
	private int tranIntrayId;
	private String intrayDate;
	private int intrayBig;
	private int intrayLead;
	private int intraySmall;

	private int balSmall;
	private int balBig;
	private int balLead;

	public NewTrayReportInTray() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewTrayReportInTray(String id, int tranId, int tranDetailId, String outtrayDate, int outtrayBig,
			int outtraySmall, int outtrayLead, int intrayId, int tranIntrayId, String intrayDate, int intrayBig,
			int intrayLead, int intraySmall, int balSmall, int balBig, int balLead) {
		super();
		this.id = id;
		this.tranId = tranId;
		this.tranDetailId = tranDetailId;
		this.outtrayDate = outtrayDate;
		this.outtrayBig = outtrayBig;
		this.outtraySmall = outtraySmall;
		this.outtrayLead = outtrayLead;
		this.intrayId = intrayId;
		this.tranIntrayId = tranIntrayId;
		this.intrayDate = intrayDate;
		this.intrayBig = intrayBig;
		this.intrayLead = intrayLead;
		this.intraySmall = intraySmall;
		this.balSmall = balSmall;
		this.balBig = balBig;
		this.balLead = balLead;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public int getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(int tranDetailId) {
		this.tranDetailId = tranDetailId;
	}

	public String getOuttrayDate() {
		return outtrayDate;
	}

	public void setOuttrayDate(String outtrayDate) {
		this.outtrayDate = outtrayDate;
	}

	public int getOuttrayBig() {
		return outtrayBig;
	}

	public void setOuttrayBig(int outtrayBig) {
		this.outtrayBig = outtrayBig;
	}

	public int getOuttraySmall() {
		return outtraySmall;
	}

	public void setOuttraySmall(int outtraySmall) {
		this.outtraySmall = outtraySmall;
	}

	public int getOuttrayLead() {
		return outtrayLead;
	}

	public void setOuttrayLead(int outtrayLead) {
		this.outtrayLead = outtrayLead;
	}

	public int getIntrayId() {
		return intrayId;
	}

	public void setIntrayId(int intrayId) {
		this.intrayId = intrayId;
	}

	public int getTranIntrayId() {
		return tranIntrayId;
	}

	public void setTranIntrayId(int tranIntrayId) {
		this.tranIntrayId = tranIntrayId;
	}

	public String getIntrayDate() {
		return intrayDate;
	}

	public void setIntrayDate(String intrayDate) {
		this.intrayDate = intrayDate;
	}

	public int getIntrayBig() {
		return intrayBig;
	}

	public void setIntrayBig(int intrayBig) {
		this.intrayBig = intrayBig;
	}

	public int getIntrayLead() {
		return intrayLead;
	}

	public void setIntrayLead(int intrayLead) {
		this.intrayLead = intrayLead;
	}

	public int getIntraySmall() {
		return intraySmall;
	}

	public void setIntraySmall(int intraySmall) {
		this.intraySmall = intraySmall;
	}

	public int getBalSmall() {
		return balSmall;
	}

	public void setBalSmall(int balSmall) {
		this.balSmall = balSmall;
	}

	public int getBalBig() {
		return balBig;
	}

	public void setBalBig(int balBig) {
		this.balBig = balBig;
	}

	public int getBalLead() {
		return balLead;
	}

	public void setBalLead(int balLead) {
		this.balLead = balLead;
	}

	@Override
	public String toString() {
		return "NewTrayReportInTray [id=" + id + ", tranId=" + tranId + ", tranDetailId=" + tranDetailId
				+ ", outtrayDate=" + outtrayDate + ", outtrayBig=" + outtrayBig + ", outtraySmall=" + outtraySmall
				+ ", outtrayLead=" + outtrayLead + ", intrayId=" + intrayId + ", tranIntrayId=" + tranIntrayId
				+ ", intrayDate=" + intrayDate + ", intrayBig=" + intrayBig + ", intrayLead=" + intrayLead
				+ ", intraySmall=" + intraySmall + ", balSmall=" + balSmall + ", balBig=" + balBig + ", balLead="
				+ balLead + "]";
	}

}
