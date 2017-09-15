package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.FrLoginResponse;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.repository.FranchiseeRepository;
import com.ats.webapi.util.JsonUtil;

@Service("franchiseeService")

public class FranchiseeServiceImpl implements FranchiseeService {

    @Autowired
    private FranchiseeRepository franchiseeRepository;

	@Override
	public String saveFranchisee(Franchisee franchisee) {
		
		Franchisee dbFranchisee= franchiseeRepository.save(franchisee);
		ErrorMessage errorMessage=new ErrorMessage();

		if(!dbFranchisee.equals(null))
		{
		 errorMessage.setError(false);
		 errorMessage.setMessage("Franchisee Inserted Successfully");
		
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Franchisee insertion Failed");
			
		}
		return JsonUtil.javaToJson(errorMessage);

	}

	@Override
	public List<Franchisee> findAllFranchisee() {
		 List<Franchisee> franchisee=new ArrayList<Franchisee>();
			franchisee=franchiseeRepository.findByDelStatus(0);
	
		
		return franchisee;
	}

	@Override
	public Franchisee findFranchisee(int frId) {
		Franchisee franchisee=franchiseeRepository.findOne(frId);
	     return franchisee;
	}

	@Override
	public String findFranchiseeByFrCode(String frCode, String frPassword) {
	
		String dbFrCode = null;
		String dbPassword = null;
		String jsonFr = "{}";
        Franchisee dbFranchisee=new Franchisee();

			
			FrLoginResponse frLoginResponse = new FrLoginResponse();
            ErrorMessage errorMessage=new ErrorMessage();
			try {
				dbFranchisee = franchiseeRepository.findByFrCode(frCode);
				System.out.println(" details "+dbFranchisee.toString());
				
				dbFrCode = dbFranchisee.getFrCode();
				dbPassword = dbFranchisee.getFrPassword();
			} catch (Exception e) {
				
				System.out.println("Exception while finding prev fr "+e.getMessage());
				
				frLoginResponse.setFranchisee(dbFranchisee);
				errorMessage.setError(true);
				errorMessage.setMessage("Franchisee Not Registerd");
				frLoginResponse.setErrorMessage(errorMessage);
				jsonFr = JsonUtil.javaToJson(frLoginResponse);
			}
			try {
				if (dbFranchisee.getFrCode() == null || dbFranchisee.getFrPassword() == null||dbFranchisee.getFrCode().equalsIgnoreCase("")||dbFranchisee.getFrPassword().equalsIgnoreCase("")) {

				
					System.out.println("Exception fr details null ");
					
					 frLoginResponse.setFranchisee(dbFranchisee);
					 errorMessage.setError(true);
					 errorMessage.setMessage("Franchisee Not Registered");
					 frLoginResponse.setErrorMessage(errorMessage);
					jsonFr = JsonUtil.javaToJson(frLoginResponse);
					
				} else if (dbFrCode.equals(frCode) && dbPassword.equals(frPassword)) {
					
				
					frLoginResponse.setFranchisee(dbFranchisee);
					errorMessage.setError(false);
					errorMessage.setMessage("Franchisee displayed Successfully");
					frLoginResponse.setErrorMessage(errorMessage);
					jsonFr = JsonUtil.javaToJson(frLoginResponse);

				} else if (dbFrCode.equals(frCode) && dbPassword != frPassword) {
					
					 frLoginResponse.setFranchisee(dbFranchisee);
					 errorMessage.setError(true);
					 errorMessage.setMessage("Invalid login details");
					 frLoginResponse.setErrorMessage(errorMessage);
					 jsonFr = JsonUtil.javaToJson(frLoginResponse);
				}
			} catch (Exception e) {
				System.out.println("Exception while converting prev fr "+e.getMessage());
				
				
				 frLoginResponse.setFranchisee(dbFranchisee);
				 errorMessage.setError(true);
				 errorMessage.setMessage("Franchisee Not Registered");
			     frLoginResponse.setErrorMessage(errorMessage);
				jsonFr = JsonUtil.javaToJson(frLoginResponse);
			}
			return jsonFr;

		}

	

	


}
