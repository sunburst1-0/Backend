package com.data.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * IRsignal entity.
 */
@Entity
@Table(name = "ir_signal")
public class IRsignal {
	

	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="value")
	private String value;
	
	@ManyToOne
	@JoinColumn(name="appliance_id", nullable=false)
	private ApplienceMetaData applianceId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ApplienceMetaData getApplianceId() {
		return applianceId;
	}

	public void setApplianceId(ApplienceMetaData applianceId) {
		this.applianceId = applianceId;
	}
	
	
}
