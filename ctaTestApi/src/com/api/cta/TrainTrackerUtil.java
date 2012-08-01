package com.api.cta;


/**
 * @author sgall
 *
 */
public enum TrainTrackerUtil {
	INSTANCE;
	public static final String API_KEY_CODE = "04d49799a0e84c729dfed8de8545dd35"; // API Code provided from CTA to make requests
	public static final String API_KEY_CODE_PARAMETER = "key";
	// Query String Parameters
	public static final String CTA_BASE_REQUEST_URL = "http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx"; // Base URL for requests
	public enum TRAIN_LINE{Red,Blue,Brn,G,Org,P,Pink,Y}; //All of the possible CTA train lines
	private static final String EQUALS = "=";
	/**
	 * @return retunrs URL that contains the CTA_BASE_REQUEST_URL with the API_KEY parameter in the query string.
	 */
	public static String createRequestUrl(TrainTrackerRequest trainTrackerRequest){
		StringBuilder sb = new StringBuilder();
		sb.append(TrainTrackerUtil.CTA_BASE_REQUEST_URL + "?" + API_KEY_CODE_PARAMETER + EQUALS + API_KEY_CODE +  trainTrackerRequest.toString() );
		return sb.toString();
	}
	
}
