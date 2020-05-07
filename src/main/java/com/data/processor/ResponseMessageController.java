package com.data.processor;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.data.exception.ResourceNotFoundException;
import com.data.model.ApplienceMetaData;
import com.data.model.Floor;
import com.data.model.IRsignal;
import com.data.model.Location;
import com.data.model.Response;
import com.data.model.RoomSize;
import com.data.repositories.FloorRepository;
import com.data.repositories.LocationRepository;
import com.data.repositories.ResponseRepository;




@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/warn")
public class ResponseMessageController {
	
	  @Autowired
	  private ResponseRepository responseRepository;   
	  
	
		 @GetMapping(value = "/all")
		    public ResponseEntity<List<Response>> getAllResponse() {
		

		    	List<Response> list = responseRepository.findAll() ;
	 
		    	 return new ResponseEntity<List<Response>>(list, HttpStatus.OK);
		    }
		 
		  @GetMapping("/{typeId}")
		    public ResponseEntity<List<Response>> getAllwarningByPostId(@PathVariable (value = "typeId") int typeId
	               ) {
			  
			  List<Response> Responselist=responseRepository.findAll();
			  
			  List<Response> filteredResponselist=Responselist.stream().filter(e->e.getApplianceType().getId()==typeId).collect(Collectors.toList());
			  
			  return new ResponseEntity<List<Response>>(filteredResponselist, HttpStatus.OK);
		    }

}
