package com.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;

/**
 * ApplienceDescription entity.
 */
@Entity
@Table(name = "sensor_meta_data")
public class SensorDescription {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@Column(name="version")
	private String version;	
	
	@Column(name="vender_info")
	private String vendor;	
	
	
	@Column(name="accuracy")
	private String accuracy;	
	
	@Column(name="voltage")
	private String voltage;
	
	
	@Column(name="output_type")
	private String outputType;
	
	
	@ManyToOne
	@JoinColumn(name="type", nullable=false)
	private SensorType type;


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


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public String getAccuracy() {
		return accuracy;
	}


	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}


	public String getVoltage() {
		return voltage;
	}


	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}


	public String getOutputType() {
		return outputType;
	}


	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}


	public SensorType getType() {
		return type;
	}


	public void setType(SensorType type) {
		this.type = type;
	}



	
	
	
	
	

}
