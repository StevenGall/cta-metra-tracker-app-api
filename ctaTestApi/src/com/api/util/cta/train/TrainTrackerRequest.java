package com.api.util.cta.train;

import org.apache.commons.lang3.StringUtils;

public class TrainTrackerRequest {
	public static final String NUMERIC_STATION_ID_PARAMETER = "mapid"; 
	public static final String NUMERIC_STOP_ID_PARAMETER = "stpid";
	public static final String MAXIMUM_RESULTS_PARAMETER = "max";
	public static final String ROUTE_CODE_PARAMETER = "rt";
	private static final String EQUALS = "=";
	private static final String AMPERSAND = "&";
	public String numericStationId;
	public String numericStopId;
	public int maxResults;
	public String routeCode;
	public TrainTrackerRequest(){
		maxResults = 0;
	}
	public void setNumericStationId(String numericStationId){
		this.numericStationId = numericStationId;
	}
	public void setNumericStopId (String numericStopId){
		this.numericStopId = numericStopId;
	}
	public void setMaxResults(int maxResults){
		this.maxResults = maxResults;
	}
	public void setRouteCode(String routeCode){
		this.routeCode = routeCode;
	}
	public String getNumericStationId(String numericStationId)
	{
		return numericStationId;
	}
	public String getNumericStopId(String numericStopId){
		return numericStopId;
	}
	public int getMaxResults(){
		return maxResults;
	}
	public String getRouteCode(){
		return routeCode;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotBlank(numericStationId)){
			sb.append(AMPERSAND + NUMERIC_STATION_ID_PARAMETER + EQUALS + numericStationId);
		}
		if (StringUtils.isNotBlank(numericStopId)){
			sb.append(AMPERSAND + NUMERIC_STOP_ID_PARAMETER + EQUALS  + numericStopId);
		}
		if (maxResults > 0){
			sb.append(AMPERSAND + MAXIMUM_RESULTS_PARAMETER + EQUALS + maxResults);
		}
		if (StringUtils.isNotBlank(routeCode)){
			sb.append(AMPERSAND + ROUTE_CODE_PARAMETER + EQUALS + routeCode);
		}
		return sb.toString();
	}

}
