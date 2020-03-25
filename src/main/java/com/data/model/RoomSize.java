package com.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RoomSize entity.
 */
@Entity
@Table(name = "room_size")
public class RoomSize {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@Column(name="type")
	private String type;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	

}
