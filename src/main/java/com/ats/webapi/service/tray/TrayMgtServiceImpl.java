package com.ats.webapi.service.tray;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.tray.FrOutTrays;
import com.ats.webapi.model.tray.FranchiseInRoute;
import com.ats.webapi.model.tray.GetTrayMgtHeader;
import com.ats.webapi.model.tray.TrayMgtDetail;
import com.ats.webapi.model.tray.TrayMgtHeader;
import com.ats.webapi.repository.tray.FrOutTrayRepository;
import com.ats.webapi.repository.tray.FranchiseInRouteRepository;
import com.ats.webapi.repository.tray.GetTrayMgtHeaderRepository;
import com.ats.webapi.repository.tray.TrayMgtDetailRepository;
import com.ats.webapi.repository.tray.TrayMgtHeaderRepository;

@Service
public class TrayMgtServiceImpl implements TrayMgtService{

	@Autowired
	TrayMgtHeaderRepository trayMgtHeaderRepository;
	
	@Autowired
	TrayMgtDetailRepository trayMgtDetailRepository;
	
	@Autowired
	FrOutTrayRepository frOutTraysRepository;
	
	@Autowired
	GetTrayMgtHeaderRepository getTrayMgtHeaderRepository;
	
	@Autowired
	FranchiseInRouteRepository franchiseInRouteRepository;
	@Override
	public TrayMgtHeader saveTrayMgtHeader(TrayMgtHeader trayMgtHeader) {

		TrayMgtHeader trayMgtHeaderRes=trayMgtHeaderRepository.saveAndFlush(trayMgtHeader);
		
		return trayMgtHeaderRes;
	}

	@Override
	public TrayMgtDetail saveTrayMgtDetail(TrayMgtDetail trayMgtDetail) {

		TrayMgtDetail trayMgtDetailsRes=trayMgtDetailRepository.saveAndFlush(trayMgtDetail);
		
		return trayMgtDetailsRes;
	}

	@Override
	public List<FrOutTrays> getOutTraysForFr(int frId, String billDate) {

		List<FrOutTrays> frOutTrays;
		try {
			frOutTrays=frOutTraysRepository.findOutTrays(frId,billDate);
		}
		catch(Exception e)
		{
			frOutTrays=new ArrayList<>();
			e.printStackTrace();
		}
		return frOutTrays;
	}

	@Override
	public Info updateExtraOutTrays(int tranId, int extraOutTrays) {

		int isUpdated=trayMgtHeaderRepository.updateExtraOutTrays(tranId,extraOutTrays);
		Info info=new Info();
		if(isUpdated>=1)
		{
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		}
		else
		{
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public List<GetTrayMgtHeader> getLoadedVehicles(String date,int vehStatus) {


		List<GetTrayMgtHeader> trayMgtHeaders;
		try {
		
			trayMgtHeaders=getTrayMgtHeaderRepository.getLoadedVehicles(date,vehStatus);
		}
		catch (Exception e) {
			trayMgtHeaders=new ArrayList<GetTrayMgtHeader>();
			e.printStackTrace();
		}
		return trayMgtHeaders;
	}

	@Override
	public Info updateVehicleOutData(int tranId, String vehOuttime, float vehOutKm) {

		int isUpdated=trayMgtHeaderRepository.updateVehicleOutData(tranId,vehOuttime,vehOutKm);
		Info info=new Info();
		if(isUpdated>=1)
		{
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		}
		else
		{
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public Info updateInVehicleData(int tranId, String vehIntime, float vehInkm, float vehRunningkm) {

		int isUpdated=trayMgtHeaderRepository.updateInVehicleData(tranId,vehIntime,vehInkm,vehRunningkm);
		Info info=new Info();
		if(isUpdated>=1)
		{
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		}
		else
		{
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public List<FranchiseInRoute> getFranchiseInRoute(int routeId) {

		List<FranchiseInRoute> frInRoute = null;
		try {
		 frInRoute=franchiseInRouteRepository.findFrInRoute(routeId);
		}
		catch(Exception e)
		{
			frInRoute=new ArrayList<FranchiseInRoute>();
			e.printStackTrace();
		}
		return frInRoute;
	}

	@Override
	public TrayMgtDetail getTrayMgtDetailByFrId(int frId,int tranId) {
		
		TrayMgtDetail trayMgtDetailRes=trayMgtDetailRepository.findByFrIdAndTranIdAndDelStatus(frId,tranId,0);
		return trayMgtDetailRes;
	}

	@Override
	public GetTrayMgtHeader getTrayMgtHeader(int tranId) {

		GetTrayMgtHeader trayMgtHeaderRes;
		try {
		
			trayMgtHeaderRes=getTrayMgtHeaderRepository.getTrayMgtHeader(tranId);
		}
		catch (Exception e) {
			trayMgtHeaderRes=new GetTrayMgtHeader();
			e.printStackTrace();
		}
		return trayMgtHeaderRes;
	}

	@Override
	public Info updateDieselForTransaction(int tranId, float diesel) {
		int isUpdated=trayMgtHeaderRepository.updateDieselForTransaction(tranId,diesel);
		Info info=new Info();
		if(isUpdated>=1)
		{
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		}
		else
		{
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public Info updateExtraInTrays(int tranId, int extraInTrays) {
		int isUpdated=trayMgtHeaderRepository.updateExtraInTrays(tranId,extraInTrays);
		Info info=new Info();
		if(isUpdated>=1)
		{
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		}
		else
		{
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public TrayMgtDetail getTrayDetailByStatus(int frId, int trayStatus, int isSameDay) {
		TrayMgtDetail trayMgtDetailRes;
		try {
		
			trayMgtDetailRes=trayMgtDetailRepository.findByFrIdAndTrayStatusAndIsSameDayAndDelStatus(frId,trayStatus,isSameDay,0);
		}
		catch (Exception e) {
			trayMgtDetailRes=new TrayMgtDetail();
			e.printStackTrace();
		}
		return trayMgtDetailRes;	
		}

	@Override
	public TrayMgtDetail getTrayDetailByDetailId(int tranStatus3) {
		TrayMgtDetail trayMgtDetailRes;
		try {
		
			trayMgtDetailRes=trayMgtDetailRepository.findByTranDetailId(tranStatus3);
		}
		catch (Exception e) {
			trayMgtDetailRes=new TrayMgtDetail();
			e.printStackTrace();
		}
		return trayMgtDetailRes;	
	}

	@Override
	public int updateTrayStatus(int tranStatus1,int status) {

		int isUpdated=trayMgtDetailRepository.updateTrayStatus(tranStatus1,status);
		
		return isUpdated;
	}

	@Override
	public TrayMgtHeader getTrayMgtHeaderByTranId(int tranId) {

		TrayMgtHeader trayMgtHeaderRes=trayMgtHeaderRepository.findByTranId(tranId);
		
		return trayMgtHeaderRes;
	}

}
