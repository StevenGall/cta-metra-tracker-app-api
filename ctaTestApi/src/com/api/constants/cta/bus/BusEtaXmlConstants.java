package com.api.constants.cta.bus;

public enum BusEtaXmlConstants {
	INSTANCE;
	public static final String BUSTIME_RESPONSE_CONTAINER_TAG = "bustime-response";
	public static final String ERROR_TAG = "error";
	public static final String PREDICTED_ARRIVAL_CONTAINER_TAG = "prd";
	public static final String PREDICTION_GENERATED_TIMESTAMP_TAG = "tmstmp";
	public static final String TYPE_TAG = "typ";
	public static final String NUMERIC_STOP_ID_TAG = "stpid";
	public static final String STOP_DESCRIPTION_TAG = "stpnm";
	public static final String NUMERIC_VEHICLE_ID_TAG = "vid";
	public static final String DISTANCE_TO_STOP_TAG = "dstp";
	public static final String NUMERIC_ROUTE_ID_TAG = "rt";
	public static final String ROUTE_DIRECTION_TAG = "rtdir";
	public static final String DESTINATION_TAG = "des";
	public static final String PREDICTED_ARRIVAL_TIME_TAG = "prdtm";
}
