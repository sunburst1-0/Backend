package com.data.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.service.RoomSizeService;
import com.data.model.RoomSize;
import com.data.repositories.RoomSizeRepository;


/**
 * RoomSize service implement.
 */
@Service
public class RoomSizeServiceImpl implements RoomSizeService{
	
	 @Autowired
	private RoomSizeRepository roomSizeRepository;
	
 
	@Override
	public List<RoomSize> listAllCombinations() {
		// TODO Auto-generated method stub
		return roomSizeRepository.listAllCombinations();
	}

}
