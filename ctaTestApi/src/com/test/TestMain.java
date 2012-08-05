package com.test;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.api.handler.cta.bus.BusRouteInfoResultHandler;
import com.api.handler.cta.train.TrainRouteInfoResultHandler;
import com.api.util.ConversionUtil;
import com.api.util.cta.bus.BusTrackerRequest;
import com.api.util.cta.bus.BusTrackerUtil;
import com.api.util.cta.train.TrainTrackerRequest;
import com.api.util.cta.train.TrainTrackerUtil;
import com.api.util.metra.MetraTrackerUtil;

public class TestMain {
	
	public static void main(String[] args){
		testCtaBusTracker();
		testCtaTrainTracker();
		testMetraTrainTracker();
		
	}
	
	public static void testMetraTrainTracker(){
		Map<String,List<String>> trainLineStationMap = MetraTrackerUtil.getTrainLineStationMap();
		for (Entry entry : trainLineStationMap.entrySet()){
			
			for (String stop : (List<String>)entry.getValue()){
				System.out.println("From Map Line: " + entry.getKey() + ", Stop: " + stop);
			}
		}
		System.out.println("Map Size: " + trainLineStationMap.size());
		
	}
	public static void testCtaBusTracker(){
		BusTrackerRequest busTrackerRequest = new BusTrackerRequest();
		busTrackerRequest.setMaxResults(3);
		busTrackerRequest.setNumericStopId("2345");

		InputStream xml = new BufferedInputStream(BusTrackerUtil.getBusTrackerInputStream(busTrackerRequest));
		ConversionUtil.parseXML(xml, new BusRouteInfoResultHandler());
		
	}
	public static void testCtaTrainTracker(){
		TrainTrackerRequest trainTrackerRequest = new TrainTrackerRequest();
		trainTrackerRequest.setMaxResults(3);
		trainTrackerRequest.setNumericStopId("2345");
		InputStream xml = new BufferedInputStream(TrainTrackerUtil.getTrainTrackerInputStream(trainTrackerRequest));
		ConversionUtil.parseXML(xml, new TrainRouteInfoResultHandler());
	}
}
