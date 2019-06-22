package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.SpCakeWtCount;
import com.ats.webapi.model.reportv2.CrNoteRegItem;
import com.ats.webapi.model.reportv2.CrNoteRegSp;
import com.ats.webapi.model.reportv2.CrNoteRegisterList;
import com.ats.webapi.repository.SpCakeWtCountRepo;
import com.ats.webapi.repository.reportv2.CrNoteRegItemRepo;
import com.ats.webapi.repository.reportv2.CrNoteRegSpRepo;

@RestController
public class ReportApiCon {

	@Autowired
	SpCakeWtCountRepo spCakeWtCountRepo;

	@Autowired
	CrNoteRegSpRepo getCrNoteRegSpRepo;

	@Autowired
	CrNoteRegItemRepo getCrNoteRegItemRepo;

	@RequestMapping(value = { "/getSpCakeCountBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<SpCakeWtCount> getSpCakeCountBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("menuIdList") List<String> menuIdList) {
		System.out.println(fromDate);
		System.out.println(toDate);
		List<SpCakeWtCount> spCakeList = null;
		try {

			spCakeList = spCakeWtCountRepo.getSpCakeBetDateCount(fromDate, toDate, menuIdList);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return spCakeList;
	}

	@RequestMapping(value = { "/getCrNoteRegisterDoneByFrId" }, method = RequestMethod.POST)
	public @ResponseBody CrNoteRegisterList getCrNoteRegisterDoneByFrId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		CrNoteRegisterList crNoteList = new CrNoteRegisterList();

		List<CrNoteRegItem> crNoteRegItemList;
		List<CrNoteRegSp> crNoteRegSpList;

		crNoteRegItemList = getCrNoteRegItemRepo.getCrNoteRegItemDoneByFrId(frId, fromDate, toDate);
		crNoteList.setCrNoteRegItemList(crNoteRegItemList);

		crNoteRegSpList = getCrNoteRegSpRepo.getCrNoteRegSpDoneByFrId(frId, fromDate, toDate);
		crNoteList.setCrNoteRegSpList(crNoteRegSpList);

		System.err.println("size Item  crNoteList " + crNoteList.getCrNoteRegItemList().size());
		System.err.println("size Sp  crNoteList " + crNoteList.getCrNoteRegSpList());

		return crNoteList;
	}
}
