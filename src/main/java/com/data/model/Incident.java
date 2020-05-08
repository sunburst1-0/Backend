package com.data.model;

import java.util.Date;


public class Incident {
	
	
	private WarningMessage raisedMessage;
	private WarningMessage respondMessage;
	
	
	public WarningMessage getRaisedMessage() {
		return raisedMessage;
	}
	public void setRaisedMessage(WarningMessage raisedMessage) {
		this.raisedMessage = raisedMessage;
	}
	public WarningMessage getRespondMessage() {
		return respondMessage;
	}
	public void setRespondMessage(WarningMessage respondMessage) {
		this.respondMessage = respondMessage;
	}

	
	

}


