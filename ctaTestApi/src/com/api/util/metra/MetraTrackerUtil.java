package com.api.util.metra;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import com.api.constants.metra.TrainConstants;
import com.api.util.ConnectionUtil;
import com.api.util.ConversionUtil;

public enum MetraTrackerUtil {
	INSTANCE;
	public static final String METRA_LINE_STATION_MAP_REQUEST_URL = "http://metrarail.com/content/metra/en/home/jcr:content/trainTracker.lataexport.html"; // Base URL to retrieve metra stations
	public static final String METRA_TRACKER_REQUEST_URL = "http://12.205.200.243/AJAXTrainTracker.svc/GetAcquityTrainData";
	public static final String METRA_STATION_JSON_REQUEST_URL = "http://metrarail.com/content/metra/en/home/jcr:content/trainTracker.get_stations_from_line.json?trackerNumber=0&trainLineId=";
	public List<String> getStationByLine(String lineAbbr){
		List<String> stationList = new LinkedList<String>();
		
		return stationList;
	}
	public static Map<String,List<String>> getTrainLineStationMap(){
		Map<String,List<String>> trainLineStationMap = new TreeMap<String,List<String>>();
		InputStream inputStream = ConnectionUtil.getInputStream(MetraTrackerUtil.METRA_LINE_STATION_MAP_REQUEST_URL);
		String resultString = ConversionUtil.convertInputStreamToString(inputStream);
		resultString = resultString.replaceAll("<[^>]*>", "\n");
		String stationStopArray[] = resultString.split("\n");
		for (String stationStop : stationStopArray){
			String[] tokens = stationStop.split(",");
			if ((tokens.length >= 2) && (StringUtils.isNotBlank(tokens[0])) && (StringUtils.isNotBlank(tokens[1]))){
				
				if (trainLineStationMap.containsKey(tokens[0])){
					trainLineStationMap.get(tokens[0]).add(tokens[1]);
				}
				else{
					List<String> stopList = new LinkedList<String>();
					stopList.add(tokens[1]);
					trainLineStationMap.put(tokens[0], stopList);
				}
				
			}
		}
		return trainLineStationMap;
		
	}
	public static Map<String,String> getStationListByLineAbbr(String lineAbbr){
		Map<String,String> stationName = new TreeMap<String,String>();
		InputStream inputStream = ConnectionUtil.getInputStream(METRA_STATION_JSON_REQUEST_URL + lineAbbr);
		return stationName;
	}
	public static String getLineNameFromAbbr(String lineAbbr){
		return TrainConstants.railLAbbrToNameMap.get(lineAbbr);
	}
}
