package com.ats.webapi.model.dashboard;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrPurchaseDash {
	@Id
	private float prevPurchaseTotal;
	private float curPurchaseTotal;

	private float prevGrnTotal;
	private float curGrnTotal;

	private float prevGvnTotal;
	private float curGvnTotal;

	private float prevActualTotal;
	private float curActualTotal;

	private float preSchoolTarget;
	private float preAchSchoolTarget;

	private float curSchoolTarget;
	private float curAchSchoolTarget;

	public float getPrevPurchaseTotal() {
		return prevPurchaseTotal;
	}

	public void setPrevPurchaseTotal(float prevPurchaseTotal) {
		this.prevPurchaseTotal = prevPurchaseTotal;
	}

	public float getCurPurchaseTotal() {
		return curPurchaseTotal;
	}

	public void setCurPurchaseTotal(float curPurchaseTotal) {
		this.curPurchaseTotal = curPurchaseTotal;
	}

	public float getPrevGrnTotal() {
		return prevGrnTotal;
	}

	public void setPrevGrnTotal(float prevGrnTotal) {
		this.prevGrnTotal = prevGrnTotal;
	}

	public float getCurGrnTotal() {
		return curGrnTotal;
	}

	public void setCurGrnTotal(float curGrnTotal) {
		this.curGrnTotal = curGrnTotal;
	}

	public float getPrevGvnTotal() {
		return prevGvnTotal;
	}

	public void setPrevGvnTotal(float prevGvnTotal) {
		this.prevGvnTotal = prevGvnTotal;
	}

	public float getCurGvnTotal() {
		return curGvnTotal;
	}

	public void setCurGvnTotal(float curGvnTotal) {
		this.curGvnTotal = curGvnTotal;
	}

	public float getPrevActualTotal() {
		return prevActualTotal;
	}

	public void setPrevActualTotal(float prevActualTotal) {
		this.prevActualTotal = prevActualTotal;
	}

	public float getCurActualTotal() {
		return curActualTotal;
	}

	public void setCurActualTotal(float curActualTotal) {
		this.curActualTotal = curActualTotal;
	}

	public float getPreSchoolTarget() {
		return preSchoolTarget;
	}

	public void setPreSchoolTarget(float preSchoolTarget) {
		this.preSchoolTarget = preSchoolTarget;
	}

	public float getPreAchSchoolTarget() {
		return preAchSchoolTarget;
	}

	public void setPreAchSchoolTarget(float preAchSchoolTarget) {
		this.preAchSchoolTarget = preAchSchoolTarget;
	}

	public float getCurSchoolTarget() {
		return curSchoolTarget;
	}

	public void setCurSchoolTarget(float curSchoolTarget) {
		this.curSchoolTarget = curSchoolTarget;
	}

	public float getCurAchSchoolTarget() {
		return curAchSchoolTarget;
	}

	public void setCurAchSchoolTarget(float curAchSchoolTarget) {
		this.curAchSchoolTarget = curAchSchoolTarget;
	}

	@Override
	public String toString() {
		return "FrPurchaseDash [prevPurchaseTotal=" + prevPurchaseTotal + ", curPurchaseTotal=" + curPurchaseTotal
				+ ", prevGrnTotal=" + prevGrnTotal + ", curGrnTotal=" + curGrnTotal + ", prevGvnTotal=" + prevGvnTotal
				+ ", curGvnTotal=" + curGvnTotal + ", prevActualTotal=" + prevActualTotal + ", curActualTotal="
				+ curActualTotal + ", preSchoolTarget=" + preSchoolTarget + ", preAchSchoolTarget=" + preAchSchoolTarget
				+ ", curSchoolTarget=" + curSchoolTarget + ", curAchSchoolTarget=" + curAchSchoolTarget + "]";
	}

}
