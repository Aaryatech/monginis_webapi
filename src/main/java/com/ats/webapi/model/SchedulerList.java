package com.ats.webapi.model;

import java.util.List;

public class SchedulerList {
	List <Scheduler> schedulerList;
	Info info;
	public List<Scheduler> getSchedulerList() {
		return schedulerList;
	}
	public void setSchedulerList(List<Scheduler> schedulerList) {
		this.schedulerList = schedulerList;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}

}
