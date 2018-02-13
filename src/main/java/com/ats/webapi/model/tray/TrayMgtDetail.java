package com.ats.webapi.model.tray;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tray_mgt_detail")
public class TrayMgtDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tran_detail_id")
	private int tranDetailId;
	
	@Column(name="tran_id")
	private int tranId;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="outtray_b")
	private int outtrayB;
	
	@Column(name="outtray_s")
	private int outtrayS;
	
	@Column(name="outlead")
	private int outlead;
	
	@Column(name="outextra")
	private int outextra;
	
	@Column(name="intray_b")
	private int intrayB;
	
	@Column(name="intray_s")
	private int intrayS;
	
	@Column(name="inlead")
	private int inlead;
	
	@Column(name="inextra")
	private int inextra;
	
	@Column(name="diesel")
	private float diesel;
	
	@Column(name="op_b")
	private int opB;
	
	@Column(name="op_s")
	private int opS;
	
	@Column(name="op_lead")
	private int opLead;
	
	@Column(name="op_extra")
	private int opExtra;
	
	@Column(name="cl_b")
	private int clB;
	
	@Column(name="cl_s")
	private int clS;
	
	@Column(name="cl_lead")
	private int clLead;
	
	@Column(name="cl_extra")
	private int clExtra;
	
	@Column(name="bal1_b")
	private int bal1B;
	
	@Column(name="bal1_s")
	private int bal1S;
	
	@Column(name="bal1_lead")
	private int bal1Lead;
	
	@Column(name="bal1_extra")
	private int bal1Extra;
	
	
	@Column(name="bal2_b")
	private int bal2B;
	
	@Column(name="bal2_s")
	private int bal2S;
	
	@Column(name="bal2_lead")
	private int bal2Lead;
	
	@Column(name="bal2_extra")
	private int bal2Extra;
	
	@Column(name="del_status")
	private int delStatus;

	public int getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(int tranDetailId) {
		this.tranDetailId = tranDetailId;
	}

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getOuttrayB() {
		return outtrayB;
	}

	public void setOuttrayB(int outtrayB) {
		this.outtrayB = outtrayB;
	}

	public int getOuttrayS() {
		return outtrayS;
	}

	public void setOuttrayS(int outtrayS) {
		this.outtrayS = outtrayS;
	}

	public int getOutlead() {
		return outlead;
	}

	public void setOutlead(int outlead) {
		this.outlead = outlead;
	}

	public int getOutextra() {
		return outextra;
	}

	public void setOutextra(int outextra) {
		this.outextra = outextra;
	}

	public int getIntrayB() {
		return intrayB;
	}

	public void setIntrayB(int intrayB) {
		this.intrayB = intrayB;
	}

	public int getIntrayS() {
		return intrayS;
	}

	public void setIntrayS(int intrayS) {
		this.intrayS = intrayS;
	}

	public int getInlead() {
		return inlead;
	}

	public void setInlead(int inlead) {
		this.inlead = inlead;
	}

	public int getInextra() {
		return inextra;
	}

	public void setInextra(int inextra) {
		this.inextra = inextra;
	}

	public float getDiesel() {
		return diesel;
	}

	public void setDiesel(float diesel) {
		this.diesel = diesel;
	}

	public int getOpB() {
		return opB;
	}

	public void setOpB(int opB) {
		this.opB = opB;
	}

	public int getOpS() {
		return opS;
	}

	public void setOpS(int opS) {
		this.opS = opS;
	}

	public int getOpLead() {
		return opLead;
	}

	public void setOpLead(int opLead) {
		this.opLead = opLead;
	}

	public int getOpExtra() {
		return opExtra;
	}

	public void setOpExtra(int opExtra) {
		this.opExtra = opExtra;
	}

	public int getClB() {
		return clB;
	}

	public void setClB(int clB) {
		this.clB = clB;
	}

	public int getClS() {
		return clS;
	}

	public void setClS(int clS) {
		this.clS = clS;
	}

	public int getClLead() {
		return clLead;
	}

	public void setClLead(int clLead) {
		this.clLead = clLead;
	}

	public int getClExtra() {
		return clExtra;
	}

	public void setClExtra(int clExtra) {
		this.clExtra = clExtra;
	}

	public int getBal1B() {
		return bal1B;
	}

	public void setBal1B(int bal1b) {
		bal1B = bal1b;
	}

	public int getBal1S() {
		return bal1S;
	}

	public void setBal1S(int bal1s) {
		bal1S = bal1s;
	}

	public int getBal1Lead() {
		return bal1Lead;
	}

	public void setBal1Lead(int bal1Lead) {
		this.bal1Lead = bal1Lead;
	}

	public int getBal1Extra() {
		return bal1Extra;
	}

	public void setBal1Extra(int bal1Extra) {
		this.bal1Extra = bal1Extra;
	}

	public int getBal2B() {
		return bal2B;
	}

	public void setBal2B(int bal2b) {
		bal2B = bal2b;
	}

	public int getBal2S() {
		return bal2S;
	}

	public void setBal2S(int bal2s) {
		bal2S = bal2s;
	}

	public int getBal2Lead() {
		return bal2Lead;
	}

	public void setBal2Lead(int bal2Lead) {
		this.bal2Lead = bal2Lead;
	}

	public int getBal2Extra() {
		return bal2Extra;
	}

	public void setBal2Extra(int bal2Extra) {
		this.bal2Extra = bal2Extra;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "TrayMgtDetail [tranDetailId=" + tranDetailId + ", tranId=" + tranId + ", frId=" + frId + ", outtrayB="
				+ outtrayB + ", outtrayS=" + outtrayS + ", outlead=" + outlead + ", outextra=" + outextra + ", intrayB="
				+ intrayB + ", intrayS=" + intrayS + ", inlead=" + inlead + ", inextra=" + inextra + ", diesel="
				+ diesel + ", opB=" + opB + ", opS=" + opS + ", opLead=" + opLead + ", opExtra=" + opExtra + ", clB="
				+ clB + ", clS=" + clS + ", clLead=" + clLead + ", clExtra=" + clExtra + ", bal1B=" + bal1B + ", bal1S="
				+ bal1S + ", bal1Lead=" + bal1Lead + ", bal1Extra=" + bal1Extra + ", bal2B=" + bal2B + ", bal2S="
				+ bal2S + ", bal2Lead=" + bal2Lead + ", bal2Extra=" + bal2Extra + ", delStatus=" + delStatus + "]";
	}
	
	
}
