package com.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.data.model.ApplianceType;
import com.data.model.ApplienceMetaData;
import com.data.model.Mobileoperators;


@Repository
public interface MobileRepositiry  extends JpaRepository<Mobileoperators, Integer> {
	
	
}
