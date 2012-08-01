package com.api.model;

public class TrainETA {
	private int numericStationId;
	private int numericStopId;
	private String stationName;
	private String stopDescription;
	private int runNumber;
	private String routeAbbr;
	private String destinationStop;
	private int trainDirection;
	private String predictionGeneratedTimeStamp;
	private String predictionArrivalTimeStamp;
	private boolean approaching;
	private boolean schedule;
	private boolean faultDetected;
	private boolean delayed;
	
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
	
	public int getTrainDirection() {
		return trainDirection;
	}
	
	public void setTrainDirection(int trainDirection) {
		this.trainDirection = trainDirection;
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
	
	public boolean getApproaching() {
		return approaching;
	}
	
	public void setApproaching(boolean approaching) {
		this.approaching = approaching;
	}
	
	public boolean getSchedule() {
		return schedule;
	}
	
	public void setSchedule(boolean schedule) {
		this.schedule = schedule;
	}
	
	public boolean getFaultDetected() {
		return faultDetected;
	}
	
	public void setFaultDetected(boolean faultDetected) {
		this.faultDetected = faultDetected;
	}
	
	public boolean getDelayed() {
		return delayed;
	}
	
	public void setDelayed(boolean delayed) {
		this.delayed = delayed;
	}
	
}
