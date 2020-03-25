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
@Table(name = "applience_meta_data")
public class ApplienceDescription {
	
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
	private String irenable;
	
	@Column(name="ir_x")
	private Integer irxPosition;
	
	 
	@Column(name="ir_y")
	private Integer iryPosition;
	
	
	
	

}
