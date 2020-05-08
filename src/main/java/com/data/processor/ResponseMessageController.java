package com.data.processor;

import java.util.ArrayList;
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
import com.data.model.Incident;
import com.data.model.Location;
import com.data.model.Response;
import com.data.model.RoomSize;
import com.data.model.WarningHandler;
import com.data.model.WarningMessage;
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
		    public ResponseEntity<List<WarningHandler>> getAllResponse() {
		
			 List<WarningHandler> WarningMessageList =new ArrayList<WarningHandler>();
			 List<Response> responselist = responseRepository.findAll() ;
		     List<Integer> warninglist=responselist.stream().map(e->e.getWarning().getId()).distinct().collect(Collectors.toList());  	
		    	
		     
		     if(!warninglist.isEmpty()) {
		    	 
		    	for (Integer responseId :warninglist) {
		    		
		    		WarningHandler handelmessage= new WarningHandler();
		    		List<Response> filterdresponselist=responselist.stream().filter(e->e.getWarning().getId()==responseId).collect(Collectors.toList());  
		    		List<Incident>IncidentList =new ArrayList<Incident>();
		    	
		    		
		    		handelmessage.setRaisedPerson(filterdresponselist.stream().map(e->e.getMobileoperators()).findFirst().get());
		    		handelmessage.setRespondPerson((filterdresponselist.size()==1?null:filterdresponselist.get(1).getMobileoperators()));
		    		for(Response filterResponse:filterdresponselist) {
		    					    		
		    			if(handelmessage.getWarning()==null) {
		    				handelmessage.setWarning(filterResponse.getWarning());
				    		handelmessage.setApplianceType(filterResponse.getApplianceType());
				    	}
		    			
			    		WarningMessage message =new WarningMessage();
			    		message.setMessage(filterResponse.getRepplyMessage());
			    		message.setMsgResponseTime(filterResponse.getMsgResponseTime());
			    
			    		Incident incidentNode= new Incident();
			    		if((filterdresponselist.indexOf(filterResponse))%2 !=0) {
			    			
			    			incidentNode.setRaisedMessage(null);
			    			incidentNode.setRespondMessage(message);
			    		}
			    		else {
			    			incidentNode.setRaisedMessage(message);
			    			incidentNode.setRespondMessage(null);
			    			}
			    		
			    		IncidentList.add(incidentNode);
			    		handelmessage.setIncident(IncidentList);
			    		}
		    	
		    		WarningMessageList.add(handelmessage);
		    		   	
		    	}
		    	
		     }   	
	 
		    	 return new ResponseEntity<List<WarningHandler>>(WarningMessageList, HttpStatus.OK);
		    }
		 
		  @GetMapping("/{typeId}")
		    public ResponseEntity<List<Response>> getAllwarningByPostId(@PathVariable (value = "typeId") int typeId
	               ) {
			  
			  List<Response> Responselist=responseRepository.findAll();
			  
			  List<Response> filteredResponselist=Responselist.stream().filter(e->e.getApplianceType().getId()==typeId).collect(Collectors.toList());
			  
			  return new ResponseEntity<List<Response>>(filteredResponselist, HttpStatus.OK);
		    }

}
