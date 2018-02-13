package com.ats.webapi.service.tray;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.tray.TrayMgtDetail;
import com.ats.webapi.model.tray.TrayMgtHeader;

@Service
public interface TrayMgtService {

	TrayMgtHeader saveTrayMgtHeader(TrayMgtHeader trayMgtHeader);

	List<TrayMgtDetail> saveTrayMgtDetail(List<TrayMgtDetail> trayMgtDetails);

}
