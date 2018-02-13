package com.ats.webapi.service.tray;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.tray.TrayMgtDetail;
import com.ats.webapi.model.tray.TrayMgtHeader;
import com.ats.webapi.repository.tray.TrayMgtDetailRepository;
import com.ats.webapi.repository.tray.TrayMgtHeaderRepository;

@Service
public class TrayMgtServiceImpl implements TrayMgtService{

	@Autowired
	TrayMgtHeaderRepository trayMgtHeaderRepository;
	
	@Autowired
	TrayMgtDetailRepository trayMgtDetailRepository;
	
	@Override
	public TrayMgtHeader saveTrayMgtHeader(TrayMgtHeader trayMgtHeader) {

		TrayMgtHeader trayMgtHeaderRes=trayMgtHeaderRepository.saveAndFlush(trayMgtHeader);
		
		return trayMgtHeaderRes;
	}

	@Override
	public List<TrayMgtDetail> saveTrayMgtDetail(List<TrayMgtDetail> trayMgtDetails) {

		List<TrayMgtDetail> trayMgtDetailsRes=trayMgtDetailRepository.save(trayMgtDetails);
		
		return trayMgtDetailsRes;
	}

}
