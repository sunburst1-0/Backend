package com.data.kafka.consumer;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.data.model.TempSignal;
import com.data.model.DecodedSignal;
import com.data.model.SensorData;
import com.data.repositories.TemprorarySignalRepository;

public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
  
  @Autowired
  private TemprorarySignalRepository temprorarySignalRepository;

  private CountDownLatch latch = new CountDownLatch(2);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = "${kafka.topic.signal}")
  public void receiveBar(TempSignal signal) throws IOException,NoSuchAlgorithmException {
	
	    LOGGER.info("received {}", signal.getTemprorarySignal());
	  TempSignal s=new TempSignal();
	
	  s.setTemprorarySignal(signal.getTemprorarySignal());
	  temprorarySignalRepository.save(s);
    
    latch.countDown();
  }

  @KafkaListener(topics = "${kafka.topic.sensor}")
  public void receiveFoo(SensorData data) {
	  
	LOGGER.info("received {}", data.toString());
	
    latch.countDown();
  }

}
