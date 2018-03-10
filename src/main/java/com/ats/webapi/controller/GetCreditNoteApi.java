package com.ats.webapi.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.grngvn.GetCreditNoteHeaders;
import com.ats.webapi.model.grngvn.GetCreditNoteHeadersList;
import com.ats.webapi.model.grngvn.GetCrnDetails;
import com.ats.webapi.model.grngvn.GetCrnDetailsList;
import com.ats.webapi.model.grngvn.PostCreditNoteDetails;
import com.ats.webapi.repository.getcreditnote.GetCreditNoteDetailRepo;
import com.ats.webapi.repository.getcreditnote.GetCreditNoteHeaderRepo;

@RestController // 2 March
public class GetCreditNoteApi {

	@Autowired
	GetCreditNoteHeaderRepo getCreditNoteHeaderRepo;

	@Autowired
	GetCreditNoteDetailRepo creditNoteDetailRepo;

	@RequestMapping(value = { "/getCreditNoteHeaders" }, method = RequestMethod.POST)
	public @ResponseBody GetCreditNoteHeadersList getCreditNoteHeaders(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frIdList") List<String> frIdList)

	{
		GetCreditNoteHeadersList headerResponse = new GetCreditNoteHeadersList();
		List<GetCreditNoteHeaders> headerList = new ArrayList<>();

		try {

			Date fDate = Common.convertToSqlDate(fromDate);
			Date tDate = Common.convertToSqlDate(toDate);

			if (frIdList.get(0).equalsIgnoreCase("0")) {
				System.out.println("In zero case ");
				headerList = getCreditNoteHeaderRepo.getCreditHeadersAllFr(fDate, tDate);
			} else {
				System.out.println("In other case ");

				headerList = getCreditNoteHeaderRepo.getCreditHeadersSelectedFr(fDate, tDate, frIdList);
			}
			headerResponse.setCreditNoteHeaders(headerList);
			System.err.println("Headers " + headerList);
		} catch (Exception e) {
			System.out.println("Exce In getting cn Headers " + e.getMessage());

			e.printStackTrace();
		}

		return headerResponse;
	}

	@RequestMapping(value = { "/getCrnDetails" }, method = RequestMethod.POST)
	public @ResponseBody GetCrnDetailsList getCrnDetails(@RequestParam("crnId") List<String> crnId) {

		GetCrnDetailsList returnList = new GetCrnDetailsList();
		List<GetCrnDetails> details = new ArrayList<>();

		try {

			details = creditNoteDetailRepo.getCrnDetailsById(crnId);

			returnList.setCrnDetails(details);

			System.out.println("CREDIT NOTE DETAILS " + details);

		} catch (Exception e) {
			System.err.println("Exce in  Getting Credit note Details " + e.getMessage());

			e.printStackTrace();
		}

		return returnList;
	}
}
