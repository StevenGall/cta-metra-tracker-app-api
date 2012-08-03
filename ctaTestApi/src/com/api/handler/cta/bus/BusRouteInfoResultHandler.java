package com.api.handler.cta.bus;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BusRouteInfoResultHandler extends DefaultHandler {
	
	private final StringBuffer buffer = new StringBuffer();
	
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
    }

    @Override
	public void endElement(String uri, String localName, String qName)
    throws SAXException {
        System.out.println("end element      : " + qName);
    }

    @Override
	public void characters(char ch[], int start, int length)
    throws SAXException {
    	buffer.append(ch, start, length);
        System.out.println("start characters : " + buffer);
    }
}
