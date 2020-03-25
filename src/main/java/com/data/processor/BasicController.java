package com.data.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.model.ApplianceType;
import com.data.model.RoomSize;
import com.data.repositories.ApplianceTypeRepository;
import com.data.repositories.RoomSizeRepository;
import com.data.service.RoomSizeService;

@RestController
@RequestMapping(value = "/kafka")
public class BasicController {
	
    @Autowired
	  private RoomSizeRepository roomSizeRepository;
    
    @Autowired
	  private ApplianceTypeRepository applianceTypeRepository;
    	
    @Autowired
  	  private RoomSizeService roomSizeService;
	
	 @GetMapping(value = "/hello")
	    public String sendMessageToKafkaTopic() {
	    	String data="test message";
//	        this.producer.sendMessage(data);
	        
	        return data;
	    }
	 
	 @GetMapping(value = "/roomsize")
	    public ResponseEntity<List<RoomSize>> getRoomSize() {
	    	String data="test message";
//	        this.producer.sendMessage(data);
	    //	Iterable<RoomSize> k=roomSizeRepository.fi;
	    	List<RoomSize> list = roomSizeRepository.findAll();
	    	
	    	System.out.println("excuted");
	    
	        
	        
	    	 return new ResponseEntity<List<RoomSize>>(list, HttpStatus.OK);
	    }
	 @GetMapping(value = "/aptype")
	    public ResponseEntity<List<ApplianceType>> getApplianceType() {
	

	    	List<ApplianceType> appliancelist = applianceTypeRepository.findAll();
	    	
	    	System.out.println("excuted");
	    
	        
	        
	    	 return new ResponseEntity<List<ApplianceType>>(appliancelist, HttpStatus.OK);
	    }

}
