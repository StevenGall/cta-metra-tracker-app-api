package com.api.util.metra;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.api.util.ConnectionUtil;
import com.api.util.ConversionUtil;

public enum MetraTrackerUtil {
	INSTANCE;
	public static final String METRA_STATION_REQUEST_URL = "http://metrarail.com/content/metra/en/home/jcr:content/trainTracker.lataexport.html"; // Base URL to retrieve metra stations
	public static final String METRA_TRACKER_REQUEST_URL = "http://12.205.200.243/AJAXTrainTracker.svc/GetAcquityTrainData";
	
	public List<String> getStationByLine(String lineAbbr){
		List<String> stationList = new LinkedList<String>();
		
		return stationList;
	}
	public static Map<String,String> getTrainLineStationMap(){
		Map<String,String> trainLineStationMap = new HashMap<String,String>();
		InputStream inputStream = ConnectionUtil.getInputStream(MetraTrackerUtil.METRA_STATION_REQUEST_URL);
		String resultString = ConversionUtil.convertInputStreamToString(inputStream);
		System.out.println(resultString);
		String stationStopArray[] = resultString.split("<br />");
		for (String stationStop : stationStopArray){
			String[] tokens = stationStop.split(",");
			if ((tokens.length >= 2) && (StringUtils.isNotBlank(tokens[0])) && (StringUtils.isNotBlank(tokens[1]))){
				trainLineStationMap.put(tokens[0], tokens[1]);
				System.out.println("Line: " + tokens[0] + ", Stop: " + tokens[1] +"\n");
			}
		}
		
		
		return trainLineStationMap;
	}
	
}
