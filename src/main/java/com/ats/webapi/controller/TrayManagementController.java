package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.ItemSup;
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
			public @ResponseBody Info saveTrayMgtDetail(@RequestBody List<TrayMgtDetail> trayMgtDetails) {

				List<TrayMgtDetail> trayMgtDetailRes = null;
				Info info = new Info();
				try {

					trayMgtDetailRes = trayMgtService.saveTrayMgtDetail(trayMgtDetails);

					if (!trayMgtDetailRes.isEmpty()) {
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
			
			
}
