package com.data.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.data.model.DecodedSignal;
import com.data.model.SensorData;

public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(2);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = "${kafka.topic.signal}")
  public void receiveBar(DecodedSignal signal) {
    LOGGER.info("received {}", signal.toString());
    latch.countDown();
  }

  @KafkaListener(topics = "${kafka.topic.sensor}")
  public void receiveFoo(SensorData data) {
    LOGGER.info("received {}", data.toString());
    latch.countDown();
  }
}
