package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.afe.AfeQuestion;
import com.ats.webapi.model.afe.AfeQuestionList;
import com.ats.webapi.model.afe.AfeScoreDetail;
import com.ats.webapi.model.afe.AfeScoreHeader;
import com.ats.webapi.repository.afe.AfeQueRepository;
import com.ats.webapi.repository.afe.AfeScoreDetailRepo;
import com.ats.webapi.repository.afe.AfeScoreHeaderRepo;

@RestController
public class AfeQueScoreController {

	@Autowired
	AfeScoreHeaderRepo afeHeadRepo;

	@Autowired
	AfeScoreDetailRepo afeDetailRepo;
	
	@Autowired
	AfeQueRepository afeQueRepo;

	@RequestMapping(value = { "/postAfeScore" }, method = RequestMethod.POST)
	public @ResponseBody AfeScoreHeader postAfeScore(@RequestBody AfeScoreHeader header) {
		
		AfeScoreHeader response = new AfeScoreHeader();
		
		try {

			response = afeHeadRepo.save(header);

			int headerId = response.getAfeScoreHeaderId();

			List<AfeScoreDetail> detailList = header.getAfeDetail();

			List<AfeScoreDetail> detailReturnList = new ArrayList<AfeScoreDetail>();

			for (int i = 0; i < detailList.size(); i++) {

				detailList.get(i).setAfeScoreHeaderId(headerId);

				AfeScoreDetail detailResponse = afeDetailRepo.save(detailList.get(i));

				detailReturnList.add(detailResponse);

			}

			response.setAfeDetail(detailReturnList);

		} catch (Exception e) {
			System.err.println("AfeQueScoreController -- Exce in /postAfeScore" + e.getMessage());

			e.printStackTrace();
		}
System.out.println("postAfeScore ->response " +response.toString());
		return response;
	}
	
	
	@RequestMapping(value = { "/postAfeQuestion" }, method = RequestMethod.POST)
	public @ResponseBody AfeQuestion postAfeQuestion(@RequestBody AfeQuestion afeQue) {
		
		AfeQuestion queResponse = new AfeQuestion();
		
		try {
			
			queResponse = afeQueRepo.save(afeQue);

		} catch (Exception e) {
			
			System.err.println("AfeQueScoreController -- Exce in /postAfeQuestion" +  e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("postAfeQuestion ->response " +queResponse.toString());

		return queResponse;
	}
	
	
	@RequestMapping(value = { "/getAfeQuestionList" }, method = RequestMethod.POST)
	public @ResponseBody AfeQuestionList getAfeQuestionList(@RequestParam("delStatus") int delStatus) {
		
		AfeQuestionList responseList=new AfeQuestionList();
		
		List<AfeQuestion> afeQuestionList;
		
		try {
			
			Info info=new Info();
			afeQuestionList = afeQueRepo.findByDelStatus(delStatus);

			if(!afeQuestionList.isEmpty()) {
				
				info.setError(false);
				info.setMessage("success");
				responseList.setAfeQuestion(afeQuestionList);
			}
			else {
				info.setError(true);
				info.setMessage("failed");
			}
			responseList.setInfo(info);
			
		} catch (Exception e) {
			
			System.err.println("AfeQueScoreController -- Exce in /getAfeQuestionList" + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("getAfeQuestionList ->response " +responseList.toString());

		return responseList;
	}

}
