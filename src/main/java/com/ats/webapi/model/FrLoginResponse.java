package com.ats.webapi.model;

public class FrLoginResponse {
	ErrorMessage errorMessage;
	Franchisee franchisee;
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Franchisee getFranchisee() {
		return franchisee;
	}
	public void setFranchisee(Franchisee franchisee) {
		this.franchisee = franchisee;
	}
	

}
