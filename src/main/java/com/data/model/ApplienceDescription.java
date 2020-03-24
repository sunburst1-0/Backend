package com.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.math.BigDecimal;

/**
 * Product entity.
 */
@Entity
public class ApplienceDescription {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
		
		
	 
	 

}
