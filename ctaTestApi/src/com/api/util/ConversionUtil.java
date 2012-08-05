package com.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

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

}
