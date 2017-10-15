package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GrnGvn;
import com.ats.webapi.repository.PostGrnGvnRepository;

@Service
public class PostGrnGvnServiceImpl implements PostGrnGvnService {
	
	
	@Autowired
	PostGrnGvnRepository grnGvnRepository;

	@Override
	public List<GrnGvn> saveGrnGvn(List<GrnGvn> grnGvnList) {
		
		List<GrnGvn> grnGvnReturnList=new ArrayList<GrnGvn>();
		
		for(int i=0;i<grnGvnList.size();i++) {
			
			grnGvnReturnList=grnGvnRepository.save(grnGvnList);
			
		}
		
	return grnGvnReturnList;
	
	}

}
