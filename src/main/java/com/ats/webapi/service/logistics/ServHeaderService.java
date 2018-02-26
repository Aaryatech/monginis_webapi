package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.ServHeader;

@Service
public interface ServHeaderService {

	ServHeader postServHeader(ServHeader servHeader);

	List<ServHeader> getAllServHeader();

	ServHeader getServHeaderAndDetailById(int servId);

	List<ServHeader> showServicingListPendingAndCurrentDate();

	List<ServHeader> showServicingListBetweenDate(String fromDate, String toDate);

	Info approvedServiceHeader(int servId);

	List<ServHeader> showServicingListBetweenDateAndFilter(String fromDate, String toDate, int type); 

}
