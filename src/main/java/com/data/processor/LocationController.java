package com.data.processor;

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
import com.data.model.ApplienceMetaData;
import com.data.model.Floor;
import com.data.model.IRsignal;
import com.data.model.Location;
import com.data.repositories.FloorRepository;
import com.data.repositories.LocationRepository;




@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/bas")
public class LocationController {
	
	  @Autowired
	  private LocationRepository locationRepository;   
	  
	  
	  @Autowired
	  private FloorRepository floorRepository; 
	  
	 	@PostMapping("/location/{floorId}")
	    public Location createLocation(@PathVariable (value = "floorId") int floorId,
                @Valid @RequestBody Location locationData) {
				return floorRepository.findById(floorId).map(floorData -> {
					locationData.setFloorId(floorData);
				return locationRepository.save(locationData);
				}).orElseThrow(() -> new ResourceNotFoundException("floorId " + floorId + " not found"));
		}
	 	
	 	 @PutMapping("/location/{floorId}/loactiondata/{locationId}")
	     public Location updateLocation(@PathVariable (value = "floorId") int floorId,
	                                  @PathVariable (value = "locationId") int locationId,
	                                  @Valid @RequestBody Location applienceMetaDataRequest) {
	         if(!floorRepository.existsById(floorId)) {
	             throw new ResourceNotFoundException("floorId " + floorId + " not found");
	         }

	         return locationRepository.findById(locationId).map(loacationdata -> {
	        	 
	        	 loacationdata.setLoaction(applienceMetaDataRequest.getLoaction());
	           
	        	 return locationRepository.save(loacationdata);
	         }).orElseThrow(() -> new ResourceNotFoundException("locationId " + locationId + "not found"));
	     }
	 	 
	 	  @DeleteMapping("/loactiondata/{locationId}")
	 	    public ResponseEntity<?> deleteLocation( @PathVariable (value = "locationId") int locationId) {
	 	        return locationRepository.findById(locationId).map(location -> {
	 	        	locationRepository.delete(location);
	 	        	
	 	            return ResponseEntity.ok().build();
	 	        }).orElseThrow(() -> new ResourceNotFoundException("location not found with id " + locationId ));
	 	    }
	 	  
	 	  
		 	@PostMapping("/location")
		    public Floor createFloorLocation( @Valid @RequestBody Floor FloorData) {
				
					return floorRepository.save(FloorData);
				
			}

}
