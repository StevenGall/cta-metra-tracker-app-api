package com.api.handler;

import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.api.constants.cta.train.RouteInfoResultConstants;
import com.api.constants.cta.train.TrainEtaXmlConstants;
import com.api.model.RouteInfoResult;
import com.api.model.TrainETA;

public class RouteInfoResultHandler extends DefaultHandler{
	
	private RouteInfoResult routeInfoResult;
	private TrainETA trainETA;
	private final StringBuffer buffer = new StringBuffer();
	private LinkedList <TrainETA> trainETAList;
	
    @Override
	public void startDocument() throws SAXException {
        System.out.println("start document   : ");
    }

    @Override
	public void endDocument() throws SAXException {
        System.out.println("end document     : ");
    }

    @Override
	public void startElement(String uri, String localName,
        String qName, Attributes attributes)
    throws SAXException {

        System.out.println("start element    : " + qName);
        
        buffer.setLength(0);
        
        if(StringUtils.equals(qName, RouteInfoResultConstants.TIME_STAMP_TAG)){
        	routeInfoResult = new RouteInfoResult();
        }
        else if(StringUtils.equals(qName, TrainEtaXmlConstants.TRAIN_ETA_CONTAINER_TAG)){
        	trainETA = new TrainETA();
        	trainETAList = new LinkedList <TrainETA>();
        }
    }

    @Override
	public void endElement(String uri, String localName, String qName)
    throws SAXException {
        System.out.println("end element      : " + qName);
        
        if(StringUtils.equals(qName, RouteInfoResultConstants.TIME_STAMP_TAG)) {
        	routeInfoResult.setTimeStamp(buffer.toString());
        }
        else if(StringUtils.equals(qName, RouteInfoResultConstants.NUMERIC_ERROR_CODE_TAG)) {
        	routeInfoResult.setNumericErrorCode(Integer.parseInt(buffer.toString()));
        }
        else if(StringUtils.equals(qName, TrainEtaXmlConstants.TRAIN_ETA_CONTAINER_TAG)) {
        	 //consider replacing setTrainETA with an addTrainETA so we dont copy entire list all the time
        	trainETAList = routeInfoResult.getTrainEta();
        	trainETAList.add(trainETA);
        	routeInfoResult.setTrainEta(trainETAList);
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.NUMERIC_STATION_ID_TAG)) {
        	trainETA.setNumericStationId(Integer.parseInt(buffer.toString()));
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.NUMERIC_STOP_ID_TAG)){
        	trainETA.setNumericStopId(Integer.parseInt(buffer.toString()));
        }
        else if(StringUtils.equals(qName, TrainEtaXmlConstants.STATION_NAME_TAG)) {
        	trainETA.setStationName(buffer.toString());
        }
        else if(StringUtils.equals(qName, TrainEtaXmlConstants.STOP_DESCRIPTION_TAG)) {
        	trainETA.setStopDescription(buffer.toString());
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.RUN_NUMBER_TAG)) {
        	trainETA.setRunNumber(Integer.parseInt(buffer.toString()));
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.ROUTE_ABBR_TAG)) {
        	trainETA.setRouteAbbr(buffer.toString());
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.DESTINATION_STOP_TAG)) {
        	trainETA.setDestinationStop(buffer.toString());
        }
        else if(StringUtils.equals(qName, TrainEtaXmlConstants.DESTINATION_DESCRIPTION_TAG)) {
        	trainETA.setStopDescription(buffer.toString());
        }
        else if(StringUtils.equals(qName, TrainEtaXmlConstants.TRAIN_DIRECTION_TAG)) {
        	trainETA.setTrainDirection(Integer.parseInt(buffer.toString()));
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.PREDICTION_GENERATED_TIME_STAMP_TAG)) {
        	trainETA.setPredictionGeneratedTimeStamp(buffer.toString());
        }
        else if(StringUtils.equals(qName, TrainEtaXmlConstants.PREDICTION_ARRIVAL_TIME_STAMP_TAG)) {
        	trainETA.setPredictionArrivalTimeStamp(buffer.toString());
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.APPROACHING_TAG)) {
        	trainETA.setApproaching(Boolean.parseBoolean(buffer.toString()));
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.SCHEDULE_TAG)) {
        	trainETA.setSchedule(Boolean.parseBoolean(buffer.toString()));
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.FAULT_DECTECTED_TAG)) {
        	trainETA.setFaultDetected(Boolean.parseBoolean(buffer.toString()));
        }
        else if(StringUtils.equals(qName,TrainEtaXmlConstants.DELAYED_TAG)) {
        	trainETA.setDelayed(Boolean.parseBoolean(buffer.toString()));
        }
        else if(StringUtils.equals(qName,RouteInfoResultConstants.ROUTE_INFO_RESULT_CONTAINER_TAG)) {
        	//System.out.println(routeInfoResult.toString()); //Debugging
        }
    }

    @Override
	public void characters(char ch[], int start, int length)
    throws SAXException {
    	buffer.append(ch, start, length);
        System.out.println("start characters : " + buffer);
    }
}
