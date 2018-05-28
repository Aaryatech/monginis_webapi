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
import com.ats.webapi.model.SpCakeDetailed;
import com.ats.webapi.model.SpCakeDetailedList;
import com.ats.webapi.repository.SpCakeDetailedRepository;


@RestController
public class SpCakeApiController {
	
	@Autowired
	SpCakeDetailedRepository spCakeDetailedRepository;
	
	
	@RequestMapping(value = { "/getSpCakeList" }, method = RequestMethod.POST)
	public @ResponseBody SpCakeDetailedList getSpCakeList(@RequestParam("SpId")int SpId) {

		SpCakeDetailedList spCakeDetailedList = new SpCakeDetailedList();
		
		System.out.println("SpId  "+SpId);
		try {

			
			List<SpCakeDetailed> spCakeDetailedlist = spCakeDetailedRepository.findBySpId(SpId);
			
			spCakeDetailedList.setSpCakeDetailed(spCakeDetailedlist);
			System.out.println("spCakeDetailedList "+spCakeDetailedList.toString());

			
		} catch (Exception e) 
		{
			e.printStackTrace();

			System.out.println("Exce in getlist" + e.getMessage());
		}
		return spCakeDetailedList;

	}
	
	@RequestMapping(value = { "/insertSpCakeDetailed" }, method = RequestMethod.POST)
	public @ResponseBody Info insertSpCakeDetailed(@RequestBody SpCakeDetailedList spCakeDetailedList) {

		Info info = new Info();
		
		System.out.println("SpCakeDetailedList "+spCakeDetailedList.toString());
		try {

			

			for (int i = 0; i < spCakeDetailedList.getSpCakeDetailed().size(); i++) 
			{

				SpCakeDetailed spCakeDetailed = spCakeDetailedRepository.save(spCakeDetailedList.getSpCakeDetailed().get(i));
				System.out.println("spCakeDetailed  "+spCakeDetailed.toString());
			}
			
			info.setError(false);
			info.setMessage("insert successfull");

		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("failed");
			System.out.println("Exce in  Insert " + e.getMessage());
		}

		return info;

	}

}
