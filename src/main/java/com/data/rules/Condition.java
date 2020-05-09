package com.data.rules;

public class Condition {

	private String roomName;
	private String conditionType;
	private int conditionLimit;
	private int nowValue;
	private int humidityConditionLimit;
	//private int value;
	private String message;
	private String desicion;
	
	
//	public int getValue() {
//		return value;
//	}
//
//	public void setValue(int value) {
//		this.value = value;
//	}


	
	public int getNowValue() {
		return nowValue;
	}

	public void setNowValue(int nowValue) {
		this.nowValue = nowValue;
	}


	public String getroomName() {
		return roomName;
	}

	public void setName(String roomName) {
		this.roomName = roomName;
	}

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}

	public int getConditionLimit() {
		return conditionLimit;
	}

	public void setConditionLimit(int conditionLimit) {
		this.conditionLimit = conditionLimit;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDesicion() {
		return desicion;
	}

	public void setDesicion(String desicion) {
		this.desicion = desicion;
	}

	public int getHumidityConditionLimit() {
		return humidityConditionLimit;
	}

	public void setHumidityConditionLimit(int humidityConditionLimit) {
		this.humidityConditionLimit = humidityConditionLimit;
	}

	

}
