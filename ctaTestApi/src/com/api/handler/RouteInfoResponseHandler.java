package com.api.handler;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.api.model.RouteInfoResponse;

public class RouteInfoResponseHandler extends DefaultHandler{
	
	RouteInfoResponse routeInfoResponse;
	StringBuffer buffer = new StringBuffer();

    @Override
	public void startDocument() throws SAXException {
        System.out.println("start document   : ");
    }

    @Override
	public void endDocument() throws SAXException {
        System.out.println("end document     : ");
    }

    @Override
	public void startElement(String uri, String localName,
        String qName, Attributes attributes)
    throws SAXException {

        System.out.println("start element    : " + qName);
        
        buffer.setLength(0);
        
        if(StringUtils.equals(qName, "tmst")){
        	routeInfoResponse = new RouteInfoResponse();
        }
    }

    @Override
	public void endElement(String uri, String localName, String qName)
    throws SAXException {
        System.out.println("end element      : " + qName);
        
        if(qName.equals("tmst")) {
        	routeInfoResponse.setTimeStamp(buffer.toString());
        	System.out.println("THIS IS THE TIMESTAMP" + routeInfoResponse.toString());
        }
        
    }

    @Override
	public void characters(char ch[], int start, int length)
    throws SAXException {
    	buffer.append(ch, start, length);
        System.out.println("start characters : " + buffer);
    }
}
