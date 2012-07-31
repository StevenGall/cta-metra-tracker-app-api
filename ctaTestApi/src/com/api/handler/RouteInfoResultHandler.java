package com.api.handler;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.api.constants.cta.train.RouteInfoResultConstants;
import com.api.model.RouteInfoResult;

public class RouteInfoResultHandler extends DefaultHandler{
	
	RouteInfoResult routeInfoResult;
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
        
        if(StringUtils.equals(qName, RouteInfoResultConstants.TIME_STAMP_TAG)){
        	routeInfoResult = new RouteInfoResult();
        }
    }

    @Override
	public void endElement(String uri, String localName, String qName)
    throws SAXException {
        System.out.println("end element      : " + qName);
        
        if(StringUtils.equals(qName, RouteInfoResultConstants.TIME_STAMP_TAG)) {
        	routeInfoResult.setTimeStamp(buffer.toString());
        	System.out.println("THIS IS THE TIMESTAMP" + routeInfoResult.toString());
        }
        
    }

    @Override
	public void characters(char ch[], int start, int length)
    throws SAXException {
    	buffer.append(ch, start, length);
        System.out.println("start characters : " + buffer);
    }
}
