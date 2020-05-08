package com.data.model;

import java.util.Date;

public class WarningMessage {
	
	private String message;
	private Date msgResponseTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getMsgResponseTime() {
		return msgResponseTime;
	}
	public void setMsgResponseTime(Date msgResponseTime) {
		this.msgResponseTime = msgResponseTime;
	}
	
	

}
