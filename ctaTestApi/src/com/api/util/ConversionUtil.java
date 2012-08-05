package com.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public enum ConversionUtil {
	INSTANCE;
	public static Iterator<String> convertInputStreamToIterator(InputStream is) {
		Iterator<String> lineIterator = null;
		try {
				lineIterator = IOUtils.lineIterator(is, "UTF-8");
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineIterator;
	}
	public static String convertInputStreamToString(InputStream is){
		String inputStreamString = StringUtils.EMPTY;
		try {
			inputStreamString = IOUtils.toString(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputStreamString;
	}
	public static void parseXML(InputStream xml, DefaultHandler handler ){
		try{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// create a parser
		SAXParser parser = factory.newSAXParser();
		// create the reader (scanner)
		
		XMLReader xmlReader = parser.getXMLReader();
		xmlReader.setContentHandler(handler);
		xmlReader.parse(new InputSource(xml));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
