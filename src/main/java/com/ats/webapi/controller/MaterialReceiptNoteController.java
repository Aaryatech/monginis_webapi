package com.ats.webapi.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.GetMaterialRecNoteList;

import com.ats.webapi.model.MaterialRecNote;
import com.ats.webapi.service.MaterialRcNote.MaterialRecNoteService;


@RestController
public class MaterialReceiptNoteController {

	@Autowired
	MaterialRecNoteService materialRecNoteService;
	
	
	@RequestMapping(value = { "/postMaterialRecNote" }, method = RequestMethod.POST)
	public @ResponseBody MaterialRecNote postMaterialRecNote(@RequestBody MaterialRecNote materialRecNote)
	{
		
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Date utilCurrentDate = sf.parse(sf.format(new Date()));
			 SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

			    Date now = new Date();

			    String strTime = sdfTime.format(now);
			    
			materialRecNote.setGateEntryDate(utilCurrentDate);
			materialRecNote.setGateEntryTime(strTime);

		} catch (ParseException e) {

			e.printStackTrace();
		}
        

		MaterialRecNote materialRecNotes = materialRecNoteService.postMaterialRecNote(materialRecNote);
		System.out.println(materialRecNotes.toString());
		return materialRecNotes;

	}

	@RequestMapping(value = { "/getMaterialRecNotes" }, method = RequestMethod.POST)
	public @ResponseBody GetMaterialRecNoteList getMaterialRecNote(@RequestParam("status")int status)
	{

		GetMaterialRecNoteList materialRNoteResponse = materialRecNoteService.getMaterialRecNote(status);

		return materialRNoteResponse;

	}
	
	
	@RequestMapping(value = { "/getMaterialRecNotesHeaderDetails" }, method = RequestMethod.POST)
	public @ResponseBody MaterialRecNote getMaterialRecNotesHeaderDetails(@RequestParam("mrnId")int mrnId)
	{

		MaterialRecNote materialRecNoteRes = materialRecNoteService.getMaterialRecNotesHeaderDetails(mrnId);

		return materialRecNoteRes;

	}
	
}
