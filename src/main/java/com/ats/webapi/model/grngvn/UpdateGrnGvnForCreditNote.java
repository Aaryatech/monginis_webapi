package com.ats.webapi.model.grngvn;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_grn_gvn")

public class UpdateGrnGvnForCreditNote implements Serializable {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_gvn_id")
	int grnGvnId;

	
	@Column(name = "is_credit_note")
	private int isCreditNote;
	
	
	



}
