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
 * DeviceMetaData entity.
 */
@Entity
@Table(name = "device_meta_data")
public class DeviceMetaData {
	
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@Column(name="version")
	private String version;	
	
	@Column(name="updated_time")
	private Date updatedTime;	
	
	@ManyToOne
	@JoinColumn(name="temp_meta_id", nullable=false)
	private SensorMetaData temId;	
	

	@ManyToOne
	@JoinColumn(name="humidity_meta_id", nullable=false)
	private SensorMetaData humidityId;	
	
	
	@ManyToOne
	@JoinColumn(name="gas_meta_id", nullable=false)
	private SensorMetaData gasId;	
	

	@ManyToOne
	@JoinColumn(name="light_meta_id", nullable=false)
	private SensorMetaData lightId;	
	
	@Column(name="topic_in")
	private String topicIn;	
	
	@Column(name="topic_out")
	private String topicOut;	
	
	@Column(name="dimmer_count")
	private int dimmerCount;	
	
	@Column(name="dimension")
	private String dimension;	
	
	@Column(name="floor_id")
	private int floorId;	
	
	@Column(name="location_id")
	private int locationId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	

	public String getTopicIn() {
		return topicIn;
	}

	public void setTopicIn(String topicIn) {
		this.topicIn = topicIn;
	}

	public String getTopicOut() {
		return topicOut;
	}

	public void setTopicOut(String topicOut) {
		this.topicOut = topicOut;
	}

	public int getDimmerCount() {
		return dimmerCount;
	}

	public void setDimmerCount(int dimmerCount) {
		this.dimmerCount = dimmerCount;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public SensorMetaData getTemId() {
		return temId;
	}

	public void setTemId(SensorMetaData temId) {
		this.temId = temId;
	}

	public SensorMetaData getHumidityId() {
		return humidityId;
	}

	public void setHumidityId(SensorMetaData humidityId) {
		this.humidityId = humidityId;
	}

	public SensorMetaData getGasId() {
		return gasId;
	}

	public void setGasId(SensorMetaData gasId) {
		this.gasId = gasId;
	}

	public SensorMetaData getLightId() {
		return lightId;
	}

	public void setLightId(SensorMetaData lightId) {
		this.lightId = lightId;
	}	
	
	

}
