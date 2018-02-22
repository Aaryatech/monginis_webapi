package com.ats.webapi.service.tray;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.tray.FrOutTrays;
import com.ats.webapi.model.tray.FranchiseInRoute;
import com.ats.webapi.model.tray.GetTrayMgtHeader;
import com.ats.webapi.model.tray.TrayMgtDetail;
import com.ats.webapi.model.tray.TrayMgtDetailBean;
import com.ats.webapi.model.tray.TrayMgtHeader;

@Service
public interface TrayMgtService {

	TrayMgtHeader saveTrayMgtHeader(TrayMgtHeader trayMgtHeader);

	TrayMgtDetailBean saveTrayMgtDetail(TrayMgtDetailBean trayMgtDetails);


	List<FrOutTrays> getOutTraysForFr(int frId, String billDate);

	Info updateExtraOutTrays(int tranId, int extraOutTrays);


	Info updateVehicleOutData(int tranId, String vehOuttime, float vehOutKm);

	Info updateInVehicleData(int tranId, String vehIntime, float vehInkm, float vehRunningkm);

	List<FranchiseInRoute> getFranchiseInRoute(int routeId);

	TrayMgtDetail getTrayMgtDetailByFrId(int frId, int tranId);

	GetTrayMgtHeader getTrayMgtHeader(int tranId);

	List<GetTrayMgtHeader> getLoadedVehicles(String date, int vehStatus);

	Info updateDieselForTransaction(int tranId, float diesel);

	Info updateExtraInTrays(int tranId, int extraInTrays);

	TrayMgtDetail getTrayDetailByStatus(int frId, int trayStatus, int isSameDay);

	TrayMgtDetailBean getTrayDetailByDetailId(int tranStatus3);

	int updateTrayStatus(int tranStatus1,int status);

	TrayMgtHeader getTrayMgtHeaderByTranId(int tranId);

	List<TrayMgtDetail> getTrayMgtDetailByTranId(int tranId);

	List<TrayMgtDetail> getTrayDetailForTrayIn(int frId, int isSameDay);

	List<GetTrayMgtHeader> getAllVehicles(String date);

}
