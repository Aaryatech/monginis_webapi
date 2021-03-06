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

	private float preGrnTarget;
	private float preSaleTarget;

	private float curGrnTarget;
	private float curSaleTarget;

	private float curSchoolTarget;
	private float curAchSchoolTarget;

	private float preSaleSpGrandTotal;
	private float curSaleSpGrandTotal;

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

	public float getPreGrnTarget() {
		return preGrnTarget;
	}

	public void setPreGrnTarget(float preGrnTarget) {
		this.preGrnTarget = preGrnTarget;
	}

	public float getPreSaleTarget() {
		return preSaleTarget;
	}

	public void setPreSaleTarget(float preSaleTarget) {
		this.preSaleTarget = preSaleTarget;
	}

	public float getCurGrnTarget() {
		return curGrnTarget;
	}

	public void setCurGrnTarget(float curGrnTarget) {
		this.curGrnTarget = curGrnTarget;
	}

	public float getCurSaleTarget() {
		return curSaleTarget;
	}

	public void setCurSaleTarget(float curSaleTarget) {
		this.curSaleTarget = curSaleTarget;
	}

	public float getPreSaleSpGrandTotal() {
		return preSaleSpGrandTotal;
	}

	public void setPreSaleSpGrandTotal(float preSaleSpGrandTotal) {
		this.preSaleSpGrandTotal = preSaleSpGrandTotal;
	}

	public float getCurSaleSpGrandTotal() {
		return curSaleSpGrandTotal;
	}

	public void setCurSaleSpGrandTotal(float curSaleSpGrandTotal) {
		this.curSaleSpGrandTotal = curSaleSpGrandTotal;
	}

	@Override
	public String toString() {
		return "FrPurchaseDash [prevPurchaseTotal=" + prevPurchaseTotal + ", curPurchaseTotal=" + curPurchaseTotal
				+ ", prevGrnTotal=" + prevGrnTotal + ", curGrnTotal=" + curGrnTotal + ", prevGvnTotal=" + prevGvnTotal
				+ ", curGvnTotal=" + curGvnTotal + ", prevActualTotal=" + prevActualTotal + ", curActualTotal="
				+ curActualTotal + ", preGrnTarget=" + preGrnTarget + ", preSaleTarget=" + preSaleTarget
				+ ", curGrnTarget=" + curGrnTarget + ", curSaleTarget=" + curSaleTarget + ", curSchoolTarget="
				+ curSchoolTarget + ", curAchSchoolTarget=" + curAchSchoolTarget + ", preSaleSpGrandTotal="
				+ preSaleSpGrandTotal + ", curSaleSpGrandTotal=" + curSaleSpGrandTotal + "]";
	}

}
