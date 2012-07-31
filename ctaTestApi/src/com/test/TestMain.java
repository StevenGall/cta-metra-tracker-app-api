package com.test;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.api.cta.TrainTrackerRequest;
import com.api.cta.TrainTrackerUtil;

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
		System.out.println(xml.available());
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    dbf.setValidating(false);
	    dbf.setIgnoringComments(false);
	    dbf.setIgnoringElementContentWhitespace(true);
	    dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc =  db.parse(xml);
		System.out.print(doc.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
