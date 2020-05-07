package com.data.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ApplienceMetaData entity.
 */
@Entity
@Table(name = "response")
public class Response {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@Column(name="message")
	private String repplyMessage;	
	
	@ManyToOne
	@JoinColumn(name="mobile_oprator_id", nullable=false)
	private Mobileoperators mobileoperators;
	
	
	@Column(name="time")
	private Date msgResponseTime;
	
	@ManyToOne
	@JoinColumn(name="applience_type", nullable=false)
	private ApplianceType applianceType;
	
	@ManyToOne
	@JoinColumn(name="warning_id", nullable=false)
	private Warning warning;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRepplyMessage() {
		return repplyMessage;
	}

	public void setRepplyMessage(String repplyMessage) {
		this.repplyMessage = repplyMessage;
	}

	public Mobileoperators getMobileoperators() {
		return mobileoperators;
	}

	public void setMobileoperators(Mobileoperators mobileoperators) {
		this.mobileoperators = mobileoperators;
	}

	public Date getMsgResponseTime() {
		return msgResponseTime;
	}

	public void setMsgResponseTime(Date msgResponseTime) {
		this.msgResponseTime = msgResponseTime;
	}

	public ApplianceType getApplianceType() {
		return applianceType;
	}

	public void setApplianceType(ApplianceType applianceType) {
		this.applianceType = applianceType;
	}

	public Warning getWarning() {
		return warning;
	}

	public void setWarning(Warning warning) {
		this.warning = warning;
	}
	
	

}
