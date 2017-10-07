package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ConfiguredSpDayCkResponse;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetConfiguredSpDayCk;
import com.ats.webapi.model.SpDayConfigure;
import com.ats.webapi.repository.ConfigureSpDayCakeRepository;
import com.ats.webapi.repository.GetConfSpDayCakeRepository;
@Service
public class ConfigureSpDayCakeServiceImpl implements ConfigureSpDayCakeService{

	@Autowired
	ConfigureSpDayCakeRepository configureSpDayCakeRepository;
	@Autowired
	GetConfSpDayCakeRepository getConfSpDayCakeRepository;
	
	@Override
	public ErrorMessage configureSpDayCake(SpDayConfigure spDayConfigure) {

		ErrorMessage errorMessage=new ErrorMessage();
		SpDayConfigure spDayConfigureRes=configureSpDayCakeRepository.save(spDayConfigure);
		
		if(spDayConfigureRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Special Day Cake Failed to Configure.");
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Special Day Cake Configured Successfully.");
		}
		return errorMessage;
	}

	@Override
	public ConfiguredSpDayCkResponse getConfiguredSpDayCkList() {

		List<GetConfiguredSpDayCk> configuredSpDayCkList=getConfSpDayCakeRepository.findAllByDelStatus(0);
		ConfiguredSpDayCkResponse configuredSpDayCkResponse=new ConfiguredSpDayCkResponse();
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(configuredSpDayCkList!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Configured Special Day Cake List Found Successfully.");
			configuredSpDayCkResponse.setConfiguredSpDayCkList(configuredSpDayCkList);
			configuredSpDayCkResponse.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Configured Special Day Cake List Not Found");
			configuredSpDayCkResponse.setErrorMessage(errorMessage);
		}
		
		return configuredSpDayCkResponse;
	}
	

}
