package com.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public enum ConnectionUtil {
	INSTANCE;
	public static HttpURLConnection getHttpUrlConnection(String urlString){
		try{
			URL url = new URL(urlString);
			System.out.println(url.toString());
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setRequestMethod("GET");

			return httpUrlConnection;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static InputStream getInputStream(String urlString){
		HttpURLConnection httpUrlConnection = getHttpUrlConnection(urlString);
		if (null != httpUrlConnection){
			try {
				return httpUrlConnection.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
