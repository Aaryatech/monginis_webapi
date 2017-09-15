package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.Franchisee;

public interface FranchiseeService {


	public String saveFranchisee(Franchisee franchisee);

	public List<Franchisee> findAllFranchisee();

	public Franchisee findFranchisee(int frId);

	public String findFranchiseeByFrCode(String frCode, String passwordKey);
	
}
