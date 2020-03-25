package com.data.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.data.model.RoomSize;

@Repository
public interface RoomSizeRepository extends JpaRepository<RoomSize, Integer> {
	
	
	@Query(value = "SELECT u FROM RoomSize u where u.id=1")
	List<RoomSize> listAllCombinations();

}
