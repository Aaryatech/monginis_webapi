package com.ats.webapi.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.SpCakeWtCount;
import com.ats.webapi.repository.SpCakeWtCountRepo;

@RestController
public class ReportApiCon {

	@Autowired
	SpCakeWtCountRepo spCakeWtCountRepo;

	@RequestMapping(value = { "/getSpCakeCountBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<SpCakeWtCount> getSpCakeCountBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		System.out.println(fromDate);
		System.out.println(toDate);
		List<SpCakeWtCount> spCakeList = null;
		try {

			spCakeList = spCakeWtCountRepo.getSpCakeBetDateCount(fromDate, toDate);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return spCakeList;
	}
}
