package com.ats.webapi.controller.typewisefr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.typewisefr.TypeWiseFr;
import com.ats.webapi.model.typewisefr.TypeWiseFrDisplay;
import com.ats.webapi.repository.typewisefr.TypeWiseFrDisplayRepo;
import com.ats.webapi.repository.typewisefr.TypeWiseFrRepo;

@RestController
public class TypeWiseFrController {
	
	@Autowired
	TypeWiseFrDisplayRepo typeWiseFrDisplayRepo;
	
	@Autowired
	TypeWiseFrRepo typeWiseFrRepo;
	

	@RequestMapping(value = { "/getTypeWiseFrNameList" }, method = RequestMethod.GET)
	public @ResponseBody List<TypeWiseFrDisplay> getTypeWiseFrNameList() {

		List<TypeWiseFrDisplay> frList = new ArrayList<>();

		try {

			frList = typeWiseFrDisplayRepo.getTypeWiseFrList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return frList;

	}
	
	@RequestMapping(value = { "/getTypeWiseFrList" }, method = RequestMethod.GET)
	public @ResponseBody List<TypeWiseFr> getTypeWiseFrList() {

		List<TypeWiseFr> frList = new ArrayList<>();

		try {

			frList = typeWiseFrRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return frList;

	}
	
	
	@RequestMapping(value = { "/saveType" }, method = RequestMethod.POST)
	public @ResponseBody TypeWiseFr saveType(@RequestBody TypeWiseFr typeWiseFr) {

		TypeWiseFr res = new TypeWiseFr();

		try {

			res = typeWiseFrRepo.save(typeWiseFr);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}
	
	@RequestMapping(value = { "/getTypeFrById" }, method = RequestMethod.POST)
	public @ResponseBody TypeWiseFr getTypeFrById(@RequestParam("typeId") int typeId) {

		TypeWiseFr res = new TypeWiseFr();

		try {

			res = typeWiseFrRepo.findByTypeId(typeId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}
	
	
}
