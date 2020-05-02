package com.data.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Warning  entity.
 */
@Entity
@Table(name = "warning")
public class Warning {
	
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="status")
	private String status;
	
		
	@Column(name="warn_message")
	private String warnMessage;
	
	
	@Column(name="occur_time")
	private Date occurTime;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getWarnMessage() {
		return warnMessage;
	}


	public void setWarnMessage(String warnMessage) {
		this.warnMessage = warnMessage;
	}


	public Date getOccurTime() {
		return occurTime;
	}


	public void setOccurTime(Date occurTime) {
		this.occurTime = occurTime;
	}
	
	

}
