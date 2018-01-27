package com.ats.webapi.service;

import static org.mockito.Matchers.isNull;

import java.util.Date;
import java.util.List;
import org.hamcrest.core.IsAnything;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Scheduler;
import com.ats.webapi.model.SchedulerList;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.SchedulerRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class SchedulerServiceImpl implements SchedulerService {
	
	String jsonScheduler= "{}";
	Scheduler scheduler=null;
		
	@Autowired
	SchedulerRepository schedulerRepository;
	
	@Autowired
	FranchiseSupRepository franchiseSupRepository;
	
	@Override
	public String save(Scheduler scheduler) {
		SchedulerList schedulerList=new SchedulerList();
		Info info=new Info();
		
		try {
			if(scheduler.getSchMessage()!=null && ! scheduler.getSchMessage().trim().equals("")&& 
					scheduler.getSchOccasionname()!=null && !scheduler.getSchOccasionname().trim().equals("")){
					scheduler = schedulerRepository.save(scheduler);
					
					List<String> frTokens=franchiseSupRepository.findTokens();
					
					 try {
				    	 for(String token:frTokens)
				    	 {
				    	
				          Firebase.sendPushNotifForCommunication(token,scheduler.getSchOccasionname(),scheduler.getSchMessage(),"news");
				    	 }
				         }
				         catch(Exception e)
				         {
					       e.printStackTrace();
				         }
					info.setError(false);
					info.setMessage("Scheduler inserted Successfully");
					jsonScheduler = JsonUtil.javaToJson(info);
				}
				else {
					scheduler.setSchMessage(scheduler.getSchMessage());
				    scheduler.setSchOccasionname(scheduler.getSchOccasionname());
					//schedulerList.setSchedulerList((List<Scheduler>) scheduler);
					info.setError(true);
					info.setMessage("Scheduler insertion Failed");
					jsonScheduler = JsonUtil.javaToJson(info);
				}
			
		} catch(Exception e) {
				System.out.println("SchedularServiceImpl Excep: " + e.getMessage());
				e.printStackTrace();
		}
	return jsonScheduler;
	}

	
	@Override
	public Scheduler findScheduler(int schId) {
		Scheduler scheduler=schedulerRepository.findOne(schId);
	return scheduler;
			
	}

	
	@Override
	public List<Scheduler> showAllScheduler() {
		List<Scheduler> schedulerList=schedulerRepository.findByDelStatus(0);
		return schedulerList ;
	}
	@Override
	public List<Scheduler> showAllLatestNews(Date cDate) {
		
		List<Scheduler> schedulerList=schedulerRepository.findLatestNews(cDate);
		return schedulerList ;
		
	}
}
