package com.data.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.data.model.IRsignal;
import com.data.model.RoomSize;
import com.data.model.SensorType;

@Repository
public interface IRSignalRepository extends JpaRepository<IRsignal, Integer> {
	
	
	

}
