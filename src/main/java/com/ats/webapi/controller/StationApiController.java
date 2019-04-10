package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.station.Station;
import com.ats.webapi.model.station.StationRepo;
import com.ats.webapi.repository.ItemRepository;
import com.ats.webapi.service.ItemService;

@RestController
public class StationApiController {

	@Autowired
	StationRepo stationRepo;

	@Autowired
	ItemService itemService;
	
	
	@Autowired
	ItemRepository itemRepository;

	@RequestMapping(value = { "/saveStation" }, method = RequestMethod.POST)
	public @ResponseBody Station saveStation(@RequestBody Station station) {
		System.out.println(station.toString());

		Station res = new Station();

		try {

			res = stationRepo.save(station);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = "/getAllStationList", method = RequestMethod.GET)
	public @ResponseBody List<Station> getAllStationList() {
		List<Station> stationList = null;

		try {
			stationList = stationRepo.findByDelStatus(0);
			try {
				if (stationList.size() > 0) {
					for (int i = 0; i < stationList.size(); i++) {

						List<Integer> itemids = Stream.of(stationList.get(i).getItemId().split(","))
								.map(Integer::parseInt).collect(Collectors.toList());

						List<Item> itemList = itemRepository.findByDelStatusAndIdIn(0, itemids);
						String itemNames = "";
						for (int j = 0; j < itemList.size(); j++) {
							itemNames = itemList.get(j).getItemName() + "," + itemNames;
						}
						stationList.get(i).setItemId(itemNames);

					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stationList;

	}
	
	@RequestMapping(value = "/getStationCount", method = RequestMethod.POST)
	public @ResponseBody List<Station> getStationCount(@RequestParam("Bill_date") String Bill_date) {
		List<Station> stationList = null;

		try {
			System.out.println("Bill_date"+Bill_date);
			stationList = stationRepo.stationOrdercount(Bill_date);
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stationList;

	}
	//

	@RequestMapping(value = { "/getStationList" }, method = RequestMethod.GET)
	public @ResponseBody List<Station> getStationList() {

		List<Station> userList = new ArrayList<Station>();

		try {

			userList = stationRepo.findByDelStatus(0);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}

	@RequestMapping(value = { "/deleteStation" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteStation(@RequestParam("stationId") int stationId) {

		Info errorMessage = new Info();

		try {

			int delete = stationRepo.delteStation(stationId, 1);

			if (delete == 1) {

				errorMessage.setError(false);
				errorMessage.setMessage("deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("failed deleted");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getStationByStationId" }, method = RequestMethod.POST)
	public @ResponseBody Station getStationByStationId(@RequestParam("stationId") int stationId) {

		Station user = new Station();

		try {

			user = stationRepo.findByStationIdAndDelStatus(stationId, 0);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return user;

	}

}
