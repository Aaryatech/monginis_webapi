package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.SpCakeDispatchReport;
import com.ats.webapi.repo.spcakedispatchreport.SpCakeDispatchRepo;
@RestController
public class SpecialCakeDispatchReportController {

	@Autowired
	SpCakeDispatchRepo CakeDispatchRepo;
	

	  @RequestMapping(value="/getSpecialCakeDispatchReports",method=RequestMethod.GET)
	public @ResponseBody List<SpCakeDispatchReport> getSpecialCakeDispatchReports(@RequestParam String spCakeDelDate,@RequestParam int routId){
		  List<SpCakeDispatchReport> Spcake=new ArrayList<SpCakeDispatchReport>();
		
		try {
			Spcake=CakeDispatchRepo.getSpecialCakeDispatchReport(spCakeDelDate,routId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return Spcake;
		
	}
	
}
