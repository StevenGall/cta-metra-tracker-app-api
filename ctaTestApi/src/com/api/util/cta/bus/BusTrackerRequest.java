package com.api.util.cta.bus;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;


public class BusTrackerRequest {
	private static final String NUMERIC_STOP_ID_PARAMETER = "stpid";
	private static final String MAXIMUM_RESULTS_PARAMETER = "top";
	private static final String ROUTE_CODES_PARAMETER = "rt"; //comma delimited 
	private static final String VEHICLE_CODES_PARAMETER = "vid"; //comma delimited
	private static final String EQUALS = "=";
	private static final String AMPERSAND = "&";
	
	public String numericStopId;
	public int maxResults;
	public ArrayList<String> routeCodes;
	public ArrayList<String> vehicleCodes;
	
	public BusTrackerRequest(){
		maxResults = 0;
		routeCodes = new ArrayList<String>();
		vehicleCodes = new ArrayList<String>();
	}
	
	public void setNumericStopId(String numericStopId) {
		this.numericStopId = numericStopId;
	}
	
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	
	public void setRouteCodes(ArrayList<String> routeCodes) {
		this.routeCodes = new ArrayList<String>(routeCodes);
	}
	
	public void setVehicleCodes(ArrayList<String> vehicleCodes) {
		this.vehicleCodes = new ArrayList<String>(vehicleCodes);
	}
	
	public String getNumericStopId() {
		return this.numericStopId;
	}
	
	public int getMaxResults() {
		return this.maxResults;
	}
	
	public ArrayList<String> getRouteCodes() {
		return this.routeCodes;
	}
	
	public ArrayList<String> getVehicleCodes() {
		return this.vehicleCodes;
	}
	
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotBlank(numericStopId)){
			sb.append(AMPERSAND + NUMERIC_STOP_ID_PARAMETER + EQUALS + numericStopId);
		}
		if (maxResults > 0){
			sb.append(AMPERSAND + MAXIMUM_RESULTS_PARAMETER + EQUALS + maxResults);
		}
		if (!routeCodes.isEmpty()){
			sb.append(AMPERSAND + ROUTE_CODES_PARAMETER + EQUALS + StringUtils.join(routeCodes,","));
		}
		if (!vehicleCodes.isEmpty()){
			sb.append(AMPERSAND + VEHICLE_CODES_PARAMETER + EQUALS + StringUtils.join(vehicleCodes,","));
		}
		return sb.toString();
	}
}
