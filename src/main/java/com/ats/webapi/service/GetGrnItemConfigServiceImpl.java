package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetGrnItemConfig;
import com.ats.webapi.model.GetGrnItemConfigList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GetGrnItemConfigRepository;

@Service
public class GetGrnItemConfigServiceImpl implements GetGrnItemConfigService {
	
	@Autowired
	GetGrnItemConfigRepository grnItemConfigRepository;

	@Override
	public GetGrnItemConfigList getAllGrnItemConfiguration(Date cDate,int frId) {
	
		GetGrnItemConfigList getGrnItemConfigList=new GetGrnItemConfigList();
		
		Info info=new Info();
		
		List<GetGrnItemConfig> getGrnItemConfigs=grnItemConfigRepository.getAllGrnItemConfig(cDate, frId);
		
		if(getGrnItemConfigs!=null) {
			
			getGrnItemConfigList.setGetGrnItemConfigs(getGrnItemConfigs);
			
			info.setError(false);
			info.setMessage("success grn confi get");
			
			
		}
		else {
			
			info.setError(true);
			info.setMessage("error grn confi get");
		
			
		}
		
		getGrnItemConfigList.setInfo(info);
		
	return getGrnItemConfigList;
	
	}
	

}
