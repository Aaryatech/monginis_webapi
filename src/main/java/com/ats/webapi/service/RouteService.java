package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.Route;
import com.ats.webapi.model.RoutesFrDetail;

public interface RouteService {

	public String save(Route route);
	public List<Route> showAllRoute();
	public Route findRoute(int routeId);
	
	public List<RoutesFrDetail> showRoutesFrDetail();
}
