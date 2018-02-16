package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;

import com.ats.webapi.model.tray.FrOutTrays;
import com.ats.webapi.model.tray.FranchiseInRoute;
import com.ats.webapi.model.tray.GetTrayMgtHeader;
import com.ats.webapi.model.tray.TrayMgtDetail;
import com.ats.webapi.model.tray.TrayMgtHeader;
import com.ats.webapi.service.tray.TrayMgtService;


@RestController
@RequestMapping("/traymgt")
public class TrayManagementController {

	@Autowired
	TrayMgtService trayMgtService;
	
	     // ----------------------------SAVE Tray Management Header---------------------------
			@RequestMapping(value = { "/saveTrayMgtHeader" }, method = RequestMethod.POST)
			public @ResponseBody Info saveTrayMgtHeader(@RequestBody TrayMgtHeader trayMgtHeader) {

				TrayMgtHeader trayMgtHeaderRes = null;
				Info info = new Info();
				try {

					trayMgtHeaderRes = trayMgtService.saveTrayMgtHeader(trayMgtHeader);

					if (trayMgtHeaderRes != null) {
						info.setError(false);
						info.setMessage("TrayMgtHeader Saved Successfully.");
					} else {
						info.setError(true);
						info.setMessage("TrayMgtHeader Not Saved .");
					}

				} catch (Exception e) {

					info.setError(true);
					info.setMessage("TrayMgtHeader Not Saved .");

					e.printStackTrace();
					System.out.println("Exception In TrayManagementController /saveTrayMgtHeader" + e.getMessage());

				}
				return info;

			}
	      //---------------------------------------------------------------------------
			 // ----------------------------SAVE Tray Management Detail---------------------------
			@RequestMapping(value = { "/saveTrayMgtDetail" }, method = RequestMethod.POST)
			public @ResponseBody Info saveTrayMgtDetail(@RequestBody TrayMgtDetail trayMgtDetail) {

				TrayMgtDetail trayMgtDetailRes = null;
				Info info = new Info();
				try {

					trayMgtDetailRes = trayMgtService.saveTrayMgtDetail(trayMgtDetail);

					if (trayMgtDetailRes!=null) {
						info.setError(false);
						info.setMessage("TrayMgtDetail Saved Successfully.");
					} else {
						info.setError(true);
						info.setMessage("TrayMgtDetail Not Saved .");
					}

				} catch (Exception e) {

					info.setError(true);
					info.setMessage("TrayMgtDetail Not Saved .");

					e.printStackTrace();
					System.out.println("Exception In TrayManagementController /saveTrayMgtDetail" + e.getMessage());

				}
				return info;

			}
	      //---------------------------------------------------------------------------	
			// ---------------------------Getting TrayMgtDetail By FrId-------------------------
			@RequestMapping(value = { "/getTrayMgtDetailByFrId" }, method = RequestMethod.POST)
			public @ResponseBody TrayMgtDetail getTrayMgtDetailByFrId(@RequestParam("frId")int frId,@RequestParam("tranId")int tranId) {

				TrayMgtDetail trayMgtDetailRes= trayMgtService.getTrayMgtDetailByFrId(frId,tranId);
	            
				return trayMgtDetailRes;

			}
		    //------------------------------------------------------------------------------------
			// ---------------------------Getting TrayMgtDetail By FrId And status-------------------------
						@RequestMapping(value = { "/getTrayDetailByStatus" }, method = RequestMethod.POST)
						public @ResponseBody TrayMgtDetail getTrayDetailByStatus(@RequestParam("frId")int frId,@RequestParam("trayStatus")int trayStatus,@RequestParam("isSameDay")int isSameDay) {

							TrayMgtDetail trayMgtDetailRes= trayMgtService.getTrayDetailByStatus(frId,trayStatus,isSameDay);
				            
							return trayMgtDetailRes;

						}
		 //------------------------------------------------------------------------------------
		//--------Getting Out Trays of different types For Franchise(Based on order of Items,no. of tray needed to Franchise)----
			@RequestMapping(value = { "/getOutTraysForFr" }, method = RequestMethod.POST)
			public @ResponseBody List<FrOutTrays> getOutTraysForFr(@RequestParam("frId")int frId,@RequestParam("billDate")String billDate) {
				
				List<FrOutTrays> frOutTrays=trayMgtService.getOutTraysForFr(frId,billDate);
				
				return frOutTrays;
			}
		//--------------------------------------------------------------------------------------------------------------------------
		//--------------------------Update Extra Out Trays------------------------------------------------------
			@RequestMapping(value = { "/updateExtraOutTrays" }, method = RequestMethod.POST)
			public @ResponseBody Info updateExtraOutTrays(@RequestParam("tranId")int tranId,@RequestParam("extraOutTrays")int extraOutTrays) {
				
				Info info=trayMgtService.updateExtraOutTrays(tranId,extraOutTrays);
				
				return info;
			}
		//----------------------------------------------------------------------------------------------------------
			//--------------------------Update Extra In Trays------------------------------------------------------
			@RequestMapping(value = { "/updateExtraInTrays" }, method = RequestMethod.POST)
			public @ResponseBody Info updateExtraInTrays(@RequestParam("tranId")int tranId,@RequestParam("extraInTrays")int extraInTrays) {
				
				Info info=trayMgtService.updateExtraInTrays(tranId,extraInTrays);
				
				return info;
			}
		//----------------------------------------------------------------------------------------------------------
			//--------------------------Update Diesel ------------------------------------------------------
			@RequestMapping(value = { "/updateDieselOfVehicle" }, method = RequestMethod.POST)
			public @ResponseBody Info updateDieselForTransaction(@RequestParam("tranId")int tranId,@RequestParam("diesel")float diesel) {
				
				Info info=trayMgtService.updateDieselForTransaction(tranId,diesel);
				
				return info;
			}
		//----------------------------------------------------------------------------------------------------------
			//--------------------------------Getting Tray Management Headers---------------------------
			@RequestMapping(value = { "/getLoadedVehicles" }, method = RequestMethod.POST)
			public @ResponseBody List<GetTrayMgtHeader> getLoadedVehicles(@RequestParam("date")String date,@RequestParam("vehStatus")int vehStatus) {
				
				List<GetTrayMgtHeader> getTrayMgtHeaders=trayMgtService.getLoadedVehicles(date,vehStatus);
				
				return getTrayMgtHeaders;
			}
		//--------------------------------------------------------------------------------------------------------------------------
			//--------------------------------Getting Tray Management Header---------------------------
			@RequestMapping(value = { "/getTrayMgtHeader" }, method = RequestMethod.POST)
			public @ResponseBody GetTrayMgtHeader getTrayMgtHeader(@RequestParam("tranId")int tranId) {
				
				GetTrayMgtHeader getTrayMgtHeaderRes=trayMgtService.getTrayMgtHeader(tranId);
				
				return getTrayMgtHeaderRes;
			}
		//--------------------------------------------------------------------------------------------------------------------------
			//--------------------------Update Vehicle Status to (1) and out km&time------------------------------------------------------
			@RequestMapping(value = { "/updateOutVehicleData" }, method = RequestMethod.POST)
			public @ResponseBody Info updateVehicleOutData(@RequestParam("tranId")int tranId,@RequestParam("vehOuttime")String vehOuttime,@RequestParam("vehOutkm")float vehOutKm) {
				
				Info info=trayMgtService.updateVehicleOutData(tranId,vehOuttime,vehOutKm);
				
				return info;
			}
		//----------------------------------------------------------------------------------------------------------	
			//--------------------------Update Vehicle Status to (2) and In km,running km & time------------------------------------------------------
			@RequestMapping(value = { "/updateInVehicleData" }, method = RequestMethod.POST)
			public @ResponseBody Info updateInVehicleData(@RequestParam("tranId")int tranId,@RequestParam("vehIntime")String vehIntime,@RequestParam("vehInkm")float vehInkm) {
				
				Info info = null;
				try {
				TrayMgtHeader getTrayMgtHeaderRes=trayMgtService.getTrayMgtHeaderByTranId(tranId);
				getTrayMgtHeaderRes.setVehIntime(vehIntime);
				getTrayMgtHeaderRes.setVehInkm(vehInkm);
				getTrayMgtHeaderRes.setVehOutkm(vehInkm-getTrayMgtHeaderRes.getVehOutkm());
				
				TrayMgtHeader trayMgtHeader = trayMgtService.saveTrayMgtHeader(getTrayMgtHeaderRes);
				if(trayMgtHeader!=null)
				{
					info=new Info();  
					info.setError(false);
					info.setMessage("In Vehicle Data Updated");
				}
				}
				catch(Exception e)
				{
					info=new Info();  
					info.setError(true);
					info.setMessage("In Vehicle Data Not Updated");
					e.printStackTrace();
				}
				return info;
			}
		//----------------------------------------------------------------------------------------------------------
			//----------------------------------------Getting Franchise In Route-----------------------------------------------------
			@RequestMapping(value = { "/getFranchiseInRoute" }, method = RequestMethod.POST)
			public @ResponseBody List<FranchiseInRoute> getFranchiseInRoute(@RequestParam("routeId")int routeId) {
				
				List<FranchiseInRoute> franchiseInRoute=trayMgtService.getFranchiseInRoute(routeId);
				
				return franchiseInRoute;
			}
		//--------------------------------------------------------------------------------------------------------------------------	
			@RequestMapping(value = { "/insertTrayInAndBalance" }, method = RequestMethod.POST)
			public @ResponseBody Info insertTrayInAndBalance(@RequestParam("tranStatus1")int tranStatus1,@RequestParam("tranStatus2")int tranStatus2,@RequestParam("intrayBig")int intrayBig,@RequestParam("intraySmall")int intraySmall
					,@RequestParam("intrayLead")int intrayLead,@RequestParam("intrayExtra")int intrayExtra,@RequestParam("tranStatus3")int tranStatus3,@RequestParam("intrayBig1")int intrayBig1,@RequestParam("intraySmall1")int intraySmall1
					,@RequestParam("intrayLead1")int intrayLead1,@RequestParam("intrayExtra1")int intrayExtra1) {
				
				try {
			if(tranStatus3!=0)
			{
				TrayMgtDetail trayMgtDetailRes= trayMgtService.getTrayDetailByDetailId(tranStatus3);
				
			   int balanceBig=trayMgtDetailRes.getOuttrayBig()-(trayMgtDetailRes.getIntrayBig()+intrayBig1);
			   int balanceSmall=trayMgtDetailRes.getOuttraySmall()-(trayMgtDetailRes.getIntraySmall()+intraySmall1);
			   int balanceLead=trayMgtDetailRes.getOuttrayLead()-(trayMgtDetailRes.getIntrayLead()+intrayLead1);
			   int balanceExtra=trayMgtDetailRes.getOuttrayExtra()-(trayMgtDetailRes.getIntrayExtra()+intrayExtra1);

			   trayMgtDetailRes.setBalanceBig(balanceBig);
			   trayMgtDetailRes.setBalanceSmall(balanceSmall);
			   trayMgtDetailRes.setBalanceLead(balanceLead);
			   trayMgtDetailRes.setBalanceExtra(balanceExtra);
			   
			   trayMgtDetailRes.setIntrayBig1(intrayBig1);
			   trayMgtDetailRes.setIntraySmall1(intraySmall1);
			   trayMgtDetailRes.setIntrayExtra1(intrayExtra1);
			   trayMgtDetailRes.setIntrayLead1(intrayLead1);
			   int trayStatus;
			   if(balanceBig>0||balanceSmall>0||balanceLead>0||balanceExtra>0)
			   {
				   trayStatus=4;
			   }
			   else    
			   {
				   trayStatus=5;
			   }
			   trayMgtDetailRes.setTrayStatus(trayStatus);
			   TrayMgtDetail  trayMgtDetailUpdated = trayMgtService.saveTrayMgtDetail(trayMgtDetailRes);
			  // int isUpdated=trayMgtService.updateTrayStatus(tranStatus3,status);

			}
			if(tranStatus2!=0)
			{
				TrayMgtDetail trayMgtDetailRes= trayMgtService.getTrayDetailByDetailId(tranStatus2);
				
				  int balanceBig=trayMgtDetailRes.getOuttrayBig()-(intrayBig);
				   int balanceSmall=trayMgtDetailRes.getOuttraySmall()-(intraySmall);
				   int balanceLead=trayMgtDetailRes.getOuttrayLead()-(intrayLead);
				   int balanceExtra=trayMgtDetailRes.getOuttrayExtra()-(intrayExtra);

				   trayMgtDetailRes.setBalanceBig(balanceBig);
				   trayMgtDetailRes.setBalanceSmall(balanceSmall);
				   trayMgtDetailRes.setBalanceLead(balanceLead);
				   trayMgtDetailRes.setBalanceExtra(balanceExtra);
				   
				   trayMgtDetailRes.setIntrayBig(intrayBig);
				   trayMgtDetailRes.setIntraySmall(intraySmall);
				   trayMgtDetailRes.setIntrayExtra(intrayExtra);
				   trayMgtDetailRes.setIntrayLead(intrayLead);
				   int trayStatus;
				   if(balanceBig>0||balanceSmall>0||balanceLead>0||balanceExtra>0)
				   {
					   trayStatus=3;
				   }
				   else
				   {
					   trayStatus=5;
				   }
				   trayMgtDetailRes.setTrayStatus(trayStatus);
				   TrayMgtDetail  trayMgtDetailUpdated = trayMgtService.saveTrayMgtDetail(trayMgtDetailRes);
				//   int isUpdated=trayMgtService.updateTrayStatus(tranStatus2,status);

			}
			if(tranStatus1!=0)
			{
			   int isUpdated=trayMgtService.updateTrayStatus(tranStatus1,2);
			}
				
				
				}
				catch (Exception e) {
                 e.printStackTrace();
				}
				return new Info();
			}
}
