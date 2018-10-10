package com.ats.webapi.model.prodapp;

import javax.persistence.Entity;
import javax.persistence.Id;

//report no 2 only on t_sp_cake_sup
@Entity
public class FrWiseSpCakeOrd {
	
	@Id
	private int tSpCakeSupNo;
	
	private String frName;
	private String frCode;
	private String spCode;
	private String spName;
	
	private int inputKgFr;
	private int inputKgProd;
	
	private float weightDiff;
	
	
}
