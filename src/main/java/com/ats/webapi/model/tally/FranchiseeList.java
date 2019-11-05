package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class FranchiseeList implements Serializable{

	List<TallyFranchisee> franchiseeList;
	
	ErrorMessage errorMessage;

	public List<TallyFranchisee> getFranchiseeList() {
		return franchiseeList;
	}

	public void setFranchiseeList(List<TallyFranchisee> franchiseeList) {
		this.franchiseeList = franchiseeList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "FranchiseeList [franchiseeList=" + franchiseeList + ", errorMessage=" + errorMessage + "]";
	}
	
	
}
