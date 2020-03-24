package com.data.processor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class BasicController {
	
	 @GetMapping(value = "/hello")
	    public String sendMessageToKafkaTopic() {
	    	String data="test message";
//	        this.producer.sendMessage(data);
	        
	        return data;
	    }

}
