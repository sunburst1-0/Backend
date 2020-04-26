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
 * TemporarySignal  entity.
 */
@Entity
@Table(name = "temp_signal")
public class TempSignal {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	
	@Column(name="value")
	private String temprorarySignal;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTemprorarySignal() {
		return temprorarySignal;
	}


	public void setTemprorarySignal(String temprorarySignal) {
		this.temprorarySignal = temprorarySignal;
	}
	
	

}
