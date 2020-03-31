package com.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.data.model.ApplianceType;
import com.data.model.ApplienceMetaData;


@Repository
public interface ApplianceMetaDataRepository extends JpaRepository<ApplienceMetaData, Integer> {
	
	//@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
	//Optional<ApplienceMetaData> findByIdAnddeviceId(Integer id);

}
