package com.ats.webapi.model;

public class FrLoginResponse {
	LoginInfo loginInfo;
	Franchisee franchisee;
    
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	public Franchisee getFranchisee() {
		return franchisee;
	}
	public void setFranchisee(Franchisee franchisee) {
		this.franchisee = franchisee;
	}
	

}
