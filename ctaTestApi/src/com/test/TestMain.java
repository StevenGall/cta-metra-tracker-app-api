package com.test;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.api.handler.cta.bus.BusRouteInfoResultHandler;
import com.api.util.cta.bus.BusTrackerRequest;
import com.api.util.cta.bus.BusTrackerUtil;
import com.api.util.metra.MetraTrackerUtil;

public class TestMain {
	
	public static void main(String[] args){
		BusTrackerRequest busTrackerRequest = new BusTrackerRequest();
		busTrackerRequest.setMaxResults(3);
		busTrackerRequest.setNumericStopId("2345");
		//busTrackerRequest.getRouteCodes().add(new String("11"));
		URL url;
		try {
			url = new URL(BusTrackerUtil.createRequestUrl(busTrackerRequest));
		System.out.println(url.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/xml");

		InputStream xml = new BufferedInputStream(connection.getInputStream());
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// create a parser
		SAXParser parser = factory.newSAXParser();
		// create the reader (scanner)
		
		XMLReader xmlReader = parser.getXMLReader();
		BusRouteInfoResultHandler busRouteInfoResultHandler = new BusRouteInfoResultHandler();
		xmlReader.setContentHandler(busRouteInfoResultHandler);
		xmlReader.parse(new InputSource(xml));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testMetra();
		
	}
	
	public static void testMetra(){
		Map<String,List<String>> trainLineStationMap = MetraTrackerUtil.getTrainLineStationMap();
		for (Entry entry : trainLineStationMap.entrySet()){
			
			for (String stop : (List<String>)entry.getValue()){
				System.out.println("From Map Line: " + entry.getKey() + ", Stop: " + stop);
			}
		}
		System.out.println("Map Size: " + trainLineStationMap.size());
		
	}
}
