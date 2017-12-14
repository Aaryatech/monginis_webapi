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
import com.ats.webapi.model.bom.BillOfMaterialDetailed;
import com.ats.webapi.model.bom.BillOfMaterialHeader;
import com.ats.webapi.repository.BillOfMaterialDetailedRepository;
import com.ats.webapi.repository.BillOfMaterialRepository;

@RestController
public class BomController {

	@Autowired
	BillOfMaterialRepository billOfMaterialRepository;

	@Autowired
	BillOfMaterialDetailedRepository billOfMaterialDetailedRepository;

	@RequestMapping(value = { "/saveBom" }, method = RequestMethod.POST)
	public @ResponseBody Info saveBom(@RequestBody BillOfMaterialHeader billOfMaterialHeader) {

		Info info = new Info();
		
		System.out.println("Input Req Param "+billOfMaterialHeader.toString());
		try {

			BillOfMaterialDetailed bDetail=null;
			BillOfMaterialHeader billMatHeader = billOfMaterialRepository.save(billOfMaterialHeader);

			List<BillOfMaterialDetailed> bomDetailList = billOfMaterialHeader.getBillOfMaterialDetailed();

			int reqId = billMatHeader.getReqId();

			for (int i = 0; i < bomDetailList.size(); i++) {

				bomDetailList.get(i).setReqId(reqId);

				 bDetail = billOfMaterialDetailedRepository.save(bomDetailList.get(i));
				 System.out.println("Inside For Detail ");

			}

			if (billMatHeader != null) {

				info.setError(false);
				info.setMessage("insert successfull");
			}

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("Exce in Bom Insert " + e.getMessage());
		}

		return info;

	}

}
