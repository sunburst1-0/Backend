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
 * Location entity.
 */
@Entity
@Table(name = "location")
public class Location {

	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="floor_id", nullable=false)
	private Floor floorId;
	
	@Column(name="loaction")
	private String loaction;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Floor getFloorId() {
		return floorId;
	}

	public void setFloorId(Floor floorId) {
		this.floorId = floorId;
	}

	public String getLoaction() {
		return loaction;
	}

	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}
	
	
}
