package com.ats.webapi.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.GetMaterialRecNoteList;
import com.ats.webapi.model.GetTaxByRmId;
import com.ats.webapi.model.CheckSuppGst;
import com.ats.webapi.model.GetTaxListByRmId;
import com.ats.webapi.model.MaterialRecNote;
import com.ats.webapi.repository.GetSuppGstRepository;
import com.ats.webapi.repository.GetTaxListByRmIdRepository;
import com.ats.webapi.service.MaterialRcNote.MaterialRecNoteService;


@RestController
public class MaterialReceiptNoteController {

	@Autowired
	MaterialRecNoteService materialRecNoteService;
	
	@Autowired
	GetTaxListByRmIdRepository getTaxListByRmIdRepository;
	
	@Autowired
	GetSuppGstRepository getSuppGstRepository;
	
	@RequestMapping(value = { "/postMaterialRecNote" }, method = RequestMethod.POST)
	public @ResponseBody MaterialRecNote postMaterialRecNote(@RequestBody MaterialRecNote materialRecNote)
	{
		System.out.println("Input List :"+materialRecNote.toString());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date utilCurrentDate = sf.parse(sf.format(new Date()));
			 SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

			    Date now = new Date();

			    String strTime = sdfTime.format(now.getTime());
			    if(materialRecNote.getMrnId()==0) {
			materialRecNote.setGateEntryDate(utilCurrentDate);
			materialRecNote.setGateEntryTime(strTime);
			    }
		} catch (ParseException e) {

			e.printStackTrace();
		}
        
		System.out.println("Podate "+materialRecNote.getPoDate());
		MaterialRecNote materialRecNotes = materialRecNoteService.postMaterialRecNote(materialRecNote);
		System.out.println(materialRecNotes.toString());
		return materialRecNotes;

	}

	@RequestMapping(value = { "/getMaterialRecNotes" }, method = RequestMethod.POST)
	public @ResponseBody GetMaterialRecNoteList getMaterialRecNote(@RequestParam("status")List<String> status)
	{
System.out.println("Status : "+status);
System.out.println("Status : "+status.toString());
		GetMaterialRecNoteList materialRNoteResponse = materialRecNoteService.getMaterialRecNote(status);

		return materialRNoteResponse;

	}
	
	
	@RequestMapping(value = { "/getTaxByRmId" }, method = RequestMethod.POST)
	public @ResponseBody GetTaxListByRmId getTaxByRmId(@RequestParam("rmId")List<String> rmId)
	{
		GetTaxListByRmId getTaxListByRmId = new GetTaxListByRmId();
		List<GetTaxByRmId> getTaxByRmIdList = new ArrayList<GetTaxByRmId>();

		getTaxByRmIdList = getTaxListByRmIdRepository.GetTaxByRmIdlist(rmId);
		getTaxListByRmId.setGetTaxByRmIdList(getTaxByRmIdList);

		return getTaxListByRmId;

	}
	
	@RequestMapping(value = { "/CheckSuppGst" }, method = RequestMethod.POST)
	public @ResponseBody int CheckSuppGst(@RequestParam("suppId")int suppId)
	{

		CheckSuppGst checkSuppGst = getSuppGstRepository.checkSuppGst(suppId);
		
		String value = String.valueOf(checkSuppGst.getSettingValue());
		String gst = checkSuppGst.getSuppGstin();
		System.out.println("value "+value);
		System.out.println("gst "+gst);
		int flag = 0;
		if(gst.substring(0, 2).equals(value.substring(0, 2)))
		{
			flag=1;
		}
		

		return flag;

	}
	
	@RequestMapping(value = { "/getMaterialRecNotesHeaderDetails" }, method = RequestMethod.POST)
	public @ResponseBody MaterialRecNote getMaterialRecNotesHeaderDetails(@RequestParam("mrnId")int mrnId)
	{

		MaterialRecNote materialRecNoteRes = materialRecNoteService.getMaterialRecNotesHeaderDetails(mrnId);

		return materialRecNoteRes;

	}
	
}
