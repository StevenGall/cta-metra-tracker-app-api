package com.api.constants.metra;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public enum TrainConstants {
	INSTANCE;
	public static final Map<String,String> railLAbbrToNameMap = Collections.unmodifiableMap(new TreeMap<String, String>() {
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{ 
        put("UP-N", "Union Pacific / North Line");
        put("MD-N", "Milwaukee District / North Line");
        put("NCS", "North Central Service");
        put("UP-NW", "Union Pacific / Northwest Line");
        put("MD-W", "Milwaukee District / West Line");
        put("UP-W", "Union Pacific / West Line");
        put("BNSF", "BNSF Railway");
        put("HC", "Heritage Corridor");
        put("SWS", "SouthWest Service");
        put("RI", "Rock Island District");
        put("ME", "Metra Electric District");
    }});
	
}
