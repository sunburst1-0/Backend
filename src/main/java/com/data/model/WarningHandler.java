package com.data.model;

import java.util.Date;
import java.util.List;

public class WarningHandler {
	
	
	private Warning warning;
	private ApplianceType applianceType;
	private Mobileoperators raisedPerson;
	private Mobileoperators respondPerson;
	private List<Incident> incident;
	public Warning getWarning() {
		return warning;
	}
	public void setWarning(Warning warning) {
		this.warning = warning;
	}
	public ApplianceType getApplianceType() {
		return applianceType;
	}
	public void setApplianceType(ApplianceType applianceType) {
		this.applianceType = applianceType;
	}
	public Mobileoperators getRaisedPerson() {
		return raisedPerson;
	}
	public void setRaisedPerson(Mobileoperators raisedPerson) {
		this.raisedPerson = raisedPerson;
	}
	public Mobileoperators getRespondPerson() {
		return respondPerson;
	}
	public void setRespondPerson(Mobileoperators respondPerson) {
		this.respondPerson = respondPerson;
	}
	public List<Incident> getIncident() {
		return incident;
	}
	public void setIncident(List<Incident> incident) {
		this.incident = incident;
	}



}






