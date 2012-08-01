package com.api.model;

import java.util.LinkedList;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RouteInfoResult {

	private String timeStamp;
	private int numericErrorCode;
	private String errorDescription;
	private LinkedList<TrainETA> trainEta;
	
	public RouteInfoResult(){
		this.trainEta = new LinkedList<TrainETA>();
	}
	
	public RouteInfoResult(String timeStamp, int numericErrorCode, String errorDescription){
		this.timeStamp = timeStamp;
		this.numericErrorCode = numericErrorCode;
		this.errorDescription = errorDescription;
		this.trainEta = new LinkedList<TrainETA>();
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
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
