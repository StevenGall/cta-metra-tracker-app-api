package com.api.cta;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author sgall
 *
 */
public enum TrainTrackerUtil {
	INSTANCE;
	public static final String API_KEY_CODE = "04d49799a0e84c729dfed8de8545dd35"; // API Code provided from CTA to make requests
	// Query String Parameters
	public static final String CTA_BASE_REQUEST_URL = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx"; // Base URL for requests
	public enum TRAIN_LINE{Red,Blue,Brn,G,Org,P,Pink,Y}; //All of the possible CTA train lines
	
	/**
	 * @return retunrs URL that contains the CTA_BASE_REQUEST_URL with the API_KEY parameter in the query string.
	 */
	public URL createRequestUrl(){
		URL requestUrl;
		try {
			requestUrl = new URL (TrainTrackerUtil.CTA_BASE_REQUEST_URL);

			return requestUrl;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
