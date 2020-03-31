package com.data.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.data.exception.ResourceNotFoundException;
import com.data.model.ApplianceType;
import com.data.model.ApplienceMetaData;
import com.data.model.RoomSize;
import com.data.repositories.ApplianceMetaDataRepository;
import com.data.repositories.ApplianceTypeRepository;
import com.data.repositories.DeviceMetaDataRepository;
import com.data.repositories.RoomSizeRepository;
import com.data.service.RoomSizeService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/kafka")
public class BasicController {
	
    @Autowired
	  private RoomSizeRepository roomSizeRepository;
    
    @Autowired
	  private ApplianceTypeRepository applianceTypeRepository;
    
    
    @Autowired
	  private DeviceMetaDataRepository deviceMetaDataRepository;
    
    @Autowired
	  private ApplianceMetaDataRepository applianceMetaDataRepository;
    	
    @Autowired
  	  private RoomSizeService roomSizeService;
	
	 @GetMapping(value = "/hello")
	    public String sendMessageToKafkaTopic() {
	    	String data="test message";

	        
	        return data;
	    }
	 
	 @GetMapping(value = "/roomsize")
	    public ResponseEntity<List<RoomSize>> getRoomSize() {
	    	String data="test message";

	    	List<RoomSize> list = roomSizeRepository.findAll();
	    	      
	    	 return new ResponseEntity<List<RoomSize>>(list, HttpStatus.OK);
	    }
	 @GetMapping(value = "/aptype")
	    public ResponseEntity<List<ApplianceType>> getApplianceType() {
	

	    	List<ApplianceType> appliancelist = applianceTypeRepository.findAll();
	    		        
	    	 return new ResponseEntity<List<ApplianceType>>(appliancelist, HttpStatus.OK);
	    }
	 	
	  @GetMapping("/apliance/{deviceId}")
	    public ResponseEntity<List<ApplienceMetaData>> getAllCommentsByPostId(@PathVariable (value = "deviceId") int deviceId
               ) {
		  
		  List<ApplienceMetaData> applienceMetaDatalist=applianceMetaDataRepository.findAll();
		  
		  List<ApplienceMetaData> filtersapplienceMetaDatalist=applienceMetaDatalist.stream().filter(e->e.getDeviceMetaData().getId()==deviceId).collect(Collectors.toList());
		  
		  return new ResponseEntity<List<ApplienceMetaData>>(filtersapplienceMetaDatalist, HttpStatus.OK);
	    }

	 	@PostMapping("/apliance/{deviceId}/apliancedata")
	    public ApplienceMetaData createApplianceMetaData(@PathVariable (value = "deviceId") int deviceId,
                @Valid @RequestBody ApplienceMetaData applienceMetaData) {
				return deviceMetaDataRepository.findById(deviceId).map(deviceMetaData -> {
					applienceMetaData.setDeviceMetaData(deviceMetaData);
				return applianceMetaDataRepository.save(applienceMetaData);
				}).orElseThrow(() -> new ResourceNotFoundException("deviceId " + deviceId + " not found"));
				}
	 	
	 	
	 	 @PutMapping("/apliance/{deviceId}/apliancedata/{applianceId}")
	     public ApplienceMetaData updateAppliance(@PathVariable (value = "deviceId") int deviceId,
	                                  @PathVariable (value = "applianceId") int applianceId,
	                                  @Valid @RequestBody ApplienceMetaData applienceMetaDataRequest) {
	         if(!deviceMetaDataRepository.existsById(deviceId)) {
	             throw new ResourceNotFoundException("deviceId " + deviceId + " not found");
	         }

	         return applianceMetaDataRepository.findById(applianceId).map(appliancedata -> {
	        	 
	        	 appliancedata.setName(applienceMetaDataRequest.getName());
	        	 appliancedata.setRoomSize(applienceMetaDataRequest.getRoomSize());
	        	 appliancedata.setApplianceType(applienceMetaDataRequest.getApplianceType());
	        	 appliancedata.setIrenable(applienceMetaDataRequest.isIrenable());
	        	 appliancedata.setIrxPosition(applienceMetaDataRequest.getIrxPosition());
	        	 appliancedata.setIryPosition(applienceMetaDataRequest.getIryPosition());
	           
	        	 return applianceMetaDataRepository.save(appliancedata);
	         }).orElseThrow(() -> new ResourceNotFoundException("applianceId " + applianceId + "not found"));
	     }
	 	 
	 	  @DeleteMapping("/apliancedata/{applianceId}")
	 	    public ResponseEntity<?> deleteappliance( @PathVariable (value = "applianceId") int applianceId) {
	 	        return applianceMetaDataRepository.findById(applianceId).map(appliance -> {
	 	        	applianceMetaDataRepository.delete(appliance);
	 	        	
	 	            return ResponseEntity.ok().build();
	 	        }).orElseThrow(() -> new ResourceNotFoundException("Appliance not found with id " + applianceId ));
	 	    }

}
