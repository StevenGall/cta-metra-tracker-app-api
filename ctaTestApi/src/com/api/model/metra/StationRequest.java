package com.api.model.metra;

public class StationRequest {
	private String corridor;
	private String destination;
	private String origin;
	private String timeStamp;
	public StationRequest(){
		
	}
	public StationRequest(String corridor, String destination, String origin, String timeStamp){
		this.corridor = corridor;
		this.destination = destination;
		this.origin = origin;
		this.timeStamp = timeStamp;
	}
	public String getCorridor() {
		return corridor;
	}
	public String getDestination(){
		return destination;
	}
	public String getOrigin(){
		return origin;
	}
	public String getTimeStamp(){
		return timeStamp;
	}
	public void setCorridor(String corridor){
		this.corridor = corridor;
	}
	public void setDestination(String destination){
		this.destination = destination;
	}
	public void setOrigin(String origin){
		this.origin = origin;
	}
	public void setTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;
	}
}
