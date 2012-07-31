package com.api.model;

import java.util.LinkedList;

public class RouteInfoResponse {

	public String timeStamp;
	public int numericErrorCode;
	public String errorDescription;
	public LinkedList<TrainETA> trainEta;
	public RouteInfoResponse(){
		
	}
	public RouteInfoResponse(String timeStamp, int numericErrorCode, String errorDescription){
		this.timeStamp = timeStamp;
		this.numericErrorCode = numericErrorCode;
		this.errorDescription = errorDescription;
	}
	public String getTimeStamp(){
		return timeStamp;
	}
	public int getNumericErrorCode(){
		return numericErrorCode;
	}
	public String getErrorDescription(){
		return errorDescription;
	}
	public LinkedList<TrainETA> getTrainEta(){
		return trainEta;
	}
	public void setTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;
	}
	public void setNumericErrorCode(int numericErrorCode){
		this.numericErrorCode = numericErrorCode;
	}
	public void setErrorDescription(String errorDescription){
		this.errorDescription = errorDescription;
	}
	public void setTrainEta(LinkedList<TrainETA> trainEta){
		this.trainEta=trainEta;
	}
}
