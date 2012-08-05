package com.api.util.cta.bus;

import java.io.InputStream;

import com.api.util.ConnectionUtil;




/**
 * @author jwineman
 *
 */
public enum BusTrackerUtil {
	INSTANCE;
	public static final String API_KEY_CODE = "Z7RQQUVV7cby5Wr42z68FS4XZ"; // API Code provided from CTA to make requests
	public static final String API_KEY_CODE_PARAMETER = "key";
	// Query String Parameters
	public static final String CTA_BASE_REQUEST_URL = "http://www.ctabustracker.com/bustime/api/v1/getpredictions"; // Base URL for requests
	public enum BUS_LINE{Red,Blue,Brn,G,Org,P,Pink,Y}; //All of the possible CTA train lines
	private static final String EQUALS = "=";
	/**
	 * @return returns URL that contains the CTA_BASE_REQUEST_URL with the API_KEY parameter in the query string.
	 */
	public static String createRequestUrl(BusTrackerRequest busTrackerRequest){
		StringBuilder sb = new StringBuilder();
		sb.append(BusTrackerUtil.CTA_BASE_REQUEST_URL + "?" + API_KEY_CODE_PARAMETER + EQUALS + API_KEY_CODE +  busTrackerRequest.toString() );
		return sb.toString();
	}
	public static InputStream getBusTrackerInputStream(BusTrackerRequest busTrackerRequest){
		return ConnectionUtil.getInputStream(BusTrackerUtil.createRequestUrl(busTrackerRequest));
	}
	
}