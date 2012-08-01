package com.test;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.api.cta.TrainTrackerRequest;
import com.api.cta.TrainTrackerUtil;
import com.api.handler.RouteInfoResponseHandler;

public class TestMain {
	
	public static void main(String[] args){
		TrainTrackerRequest trainTrackerRequest = new TrainTrackerRequest();
		trainTrackerRequest.setMaxResults(3);
		trainTrackerRequest.setNumericStationId("40360");
		URL url;
		try {
			url = new URL(TrainTrackerUtil.createRequestUrl(trainTrackerRequest));
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
		RouteInfoResponseHandler routeInfoResponseHandler = new RouteInfoResponseHandler();
		xmlReader.setContentHandler(routeInfoResponseHandler);
		xmlReader.parse(new InputSource(xml));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
