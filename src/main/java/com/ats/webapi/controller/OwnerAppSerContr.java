package com.ats.webapi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.repository.PostBillHeaderRepository;
import com.ats.webapi.repository.PostCreditNoteHeaderRepository;

@RestController
public class OwnerAppSerContr {

	
	@Autowired
	PostBillHeaderRepository billHeaderRepository;

	@RequestMapping(value = { "/getBillTotal" }, method = RequestMethod.POST)
	public @ResponseBody Object getBillTotal(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		
		Date d3 = sdf1.parse(fromDate);
		Date d4 = sdf1.parse(toDate);

		System.err.println("toDate " + toDate + "fromDate " + fromDate);
		int tot = 0;
		try {
			String d1 = sdf.format(d3);
			String d2 = sdf.format(d4);

			tot = billHeaderRepository.getTotalSellBetFdTd(d1, d2);
			System.err.println(tot + "tot");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tot;

	}
	
	@Autowired PostCreditNoteHeaderRepository creditNoteHeaderRepository;
	
	@RequestMapping(value = { "/getCrnTotal" }, method = RequestMethod.POST)
	public @ResponseBody Object getCrnTotal(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		
		Date d3 = sdf1.parse(fromDate);
		Date d4 = sdf1.parse(toDate);

		System.err.println("toDate " + toDate + "fromDate " + fromDate);
		int tot = 0;
		try {
			String d1 = sdf.format(d3);
			String d2 = sdf.format(d4);

			tot = creditNoteHeaderRepository.getTotalCrnBetFdTd(d1, d2);
			System.err.println(tot + "tot");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tot;

	}
	
	
}
