package com.api.model;

public class TrainETA {
	public int numericStationId;
	public int numericStopId;
	public String stationName;
	public String stopDescription;
	public int runNumber;
	public String routeAbbr;
	public String destinationStop;
	public String trainDirection;
	public String predictionGeneratedTimeStamp;
	public String predictionArrivalTimeStamp;
	public boolean approaching;
	public boolean schedule;
	public boolean faultDetected;
	public boolean delayed;
	public TrainETA(){
		
	}
	public int getNumericStationId(){
		return numericStationId;
	}
	
	public void setNumericStationId(int numericStationId) {
		this.numericStationId = numericStationId;
	}
	
	public int getNumericStopId(){
		return numericStopId;
	}
	
	public void setNumericStopId(int numericStopId) {
		this.numericStopId = numericStopId;
	}
	
	public String getStationName(){
		return stationName;
	}
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public String getStopDescription(){
		return stopDescription;
	}

	public void setStopDescription(String stopDescription){
		this.stopDescription = stopDescription;
	}
	
	public int getRunNumber(){
		return runNumber;
	}
	
	public void setRunNumber(int runNumber) {
		this.runNumber = runNumber;
	}
	
	public String getRouteAbbr(){
		return routeAbbr;
	}
	
	public void setRouteAbbr(String routeAbbr) {
		this.routeAbbr = routeAbbr;
	}
	
	public String getDestinationStop(){
		return destinationStop;
	}
	
	public void setDestinationStop(String destinationStop) {
		this.destinationStop = destinationStop;
	}
	
	public String getPredictionGeneratedTimeStamp(){
		return predictionGeneratedTimeStamp;
	}
	
	public void setPredictionGeneratedTimeStamp(String predictionGeneratedTimeStamp) {
		this.predictionGeneratedTimeStamp = predictionGeneratedTimeStamp;
	}
	
	public String getPredictionArrivalTimeStamp(){
		return predictionArrivalTimeStamp;
	}
	
	public void setPredictionArrivalTimeStamp(String predictionArrivalTimeStamp) {
		this.predictionArrivalTimeStamp = predictionArrivalTimeStamp;
	}
}
