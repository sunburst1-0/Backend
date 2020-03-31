package com.data.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.exception.ResourceNotFoundException;
import com.data.model.IRsignal;
import com.data.repositories.ApplianceMetaDataRepository;
import com.data.repositories.IRSignalRepository;




@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/kafka")
public class IRSignalController {
	
	
	  @Autowired
	  private IRSignalRepository iRSignalRepository;
	  
	  @Autowired
	  private ApplianceMetaDataRepository applianceMetaDataRepository;
	  
	  
	 	@PostMapping("/irsignal/{applianceId}")
	    public IRsignal createIRSignalValue(@PathVariable (value = "applianceId") int applianceId,
                @Valid @RequestBody IRsignal irSignalData) {
				return applianceMetaDataRepository.findById(applianceId).map(deviceMetaData -> {
					irSignalData.setApplianceId(deviceMetaData);
				return iRSignalRepository.save(irSignalData);
				}).orElseThrow(() -> new ResourceNotFoundException("applianceId " + applianceId + " not found"));
		}
	 	
	 	 @PutMapping("/irsignal/{applianceId}/data/{irId}")
	     public IRsignal updateIRSignalValue(@PathVariable (value = "irId") int irId,
	                                  @PathVariable (value = "applianceId") int applianceId,
	                                  @Valid @RequestBody IRsignal irDataRequest) {
	         if(!applianceMetaDataRepository.existsById(applianceId)) {
	             throw new ResourceNotFoundException("applianceId " + applianceId + " not found");
	         }

	         return iRSignalRepository.findById(irId).map(irdata -> {
	        	 
	        	 irdata.setDisplayName(irDataRequest.getDisplayName());
	        	 irdata.setValue(irDataRequest.getValue());
	           
	        	 return iRSignalRepository.save(irdata);
	         }).orElseThrow(() -> new ResourceNotFoundException("irId " + irId + "not found"));
	     }
	 	 
	 	  @DeleteMapping("/irsignal/{irId}")
	 	    public ResponseEntity<?> deleteIRSignalValue( @PathVariable (value = "irId") int irId) {
	 	        return iRSignalRepository.findById(irId).map(signal -> {
	 	        	iRSignalRepository.delete(signal);
	 	        	
	 	            return ResponseEntity.ok().build();
	 	        }).orElseThrow(() -> new ResourceNotFoundException("Sample signal not found with id " + irId ));
	 	    }

}
