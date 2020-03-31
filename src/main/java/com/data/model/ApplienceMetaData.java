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

/**
 * ApplienceMetaData entity.
 */
@Entity
@Table(name = "applience_meta_data")
public class ApplienceMetaData {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@Column(name="name")
	private String name;	
	
	@ManyToOne
	@JoinColumn(name="room_size", nullable=false)
	private RoomSize roomSize;
	
	
	@ManyToOne
	@JoinColumn(name="applience_type", nullable=false)
	private ApplianceType applianceType;
	
	
	@Column(name="ir_enable")
	private boolean irenable;
	
	@Column(name="ir_x")
	private Integer irxPosition;
	
	 
	@Column(name="ir_y")
	private Integer iryPosition;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("device_id")
    private DeviceMetaData deviceMetaData;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public RoomSize getRoomSize() {
		return roomSize;
	}


	public void setRoomSize(RoomSize roomSize) {
		this.roomSize = roomSize;
	}


	public ApplianceType getApplianceType() {
		return applianceType;
	}


	public void setApplianceType(ApplianceType applianceType) {
		this.applianceType = applianceType;
	}

	


	public boolean isIrenable() {
		return irenable;
	}


	public void setIrenable(boolean irenable) {
		this.irenable = irenable;
	}


	public Integer getIrxPosition() {
		return irxPosition;
	}


	public void setIrxPosition(Integer irxPosition) {
		this.irxPosition = irxPosition;
	}


	public Integer getIryPosition() {
		return iryPosition;
	}


	public void setIryPosition(Integer iryPosition) {
		this.iryPosition = iryPosition;
	}


	public DeviceMetaData getDeviceMetaData() {
		return deviceMetaData;
	}


	public void setDeviceMetaData(DeviceMetaData deviceMetaData) {
		this.deviceMetaData = deviceMetaData;
	}
	
	
}
