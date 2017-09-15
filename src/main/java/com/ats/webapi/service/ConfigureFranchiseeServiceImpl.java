package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ConfigureFranchisee;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.FrMenus;
import com.ats.webapi.model.FrMenusList;
import com.ats.webapi.repository.ConfigureFrRepository;
import com.ats.webapi.repository.FrMenusRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class ConfigureFranchiseeServiceImpl implements ConfigureFranchiseeService {

	@Autowired
	ConfigureFrRepository configureFrRepository;

	ConfigureFranchisee configureFranchisee = null;
	List<FrMenus> frMenus;



	@Autowired
	FrMenusRepository frMenusRepository;

	@Override
	public String configureFranchisee(ConfigureFranchisee configureFranchisee) {

		configureFranchisee = configureFrRepository.save(configureFranchisee);
		ErrorMessage errorMessage = new ErrorMessage();

		if (configureFranchisee != null) {
			errorMessage.setError(false);
			errorMessage.setMessage("Franchisee Configured Successfully");
		}

		return JsonUtil.javaToJson(errorMessage);

	}

	@Override
	public List<FrMenus> findFrMenus(int frId) {

			frMenus = frMenusRepository.findAllByFrId(frId);
		
		return frMenus;
	}
	@Override
	public ConfigureFranchisee findFranchiseeById(int setting_id) {
		ConfigureFranchisee configureFranchisee=configureFrRepository.findOne(setting_id);
		
		
		
		return configureFranchisee;
	}
	@Override
	public ConfigureFranchisee updateFrConfig(int setting_id) {
		
ConfigureFranchisee configureFranchisee=configureFrRepository.findOne(setting_id);
		
		
		
		return configureFranchisee;
	}

}
