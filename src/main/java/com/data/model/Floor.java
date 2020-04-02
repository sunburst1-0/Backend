package com.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Floor entity.
 */
@Entity
@Table(name = "floor")
public class Floor {
	
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@Column(name="floor_id")
	private Integer floorId;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getFloorId() {
		return floorId;
	}


	public void setFloorId(Integer floorId) {
		this.floorId = floorId;
	}
	
	

}
