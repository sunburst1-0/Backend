package com.data.kafka;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import com.data.model.DecodedSignal;
import com.data.kafka.consumer.Receiver;
import com.data.kafka.producer.Sender;
import com.data.model.SensorData;

   //      @RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaApplicationTest {



//  @Before
//  public void setUp() throws Exception {
//    // wait until the partitions are assigned
//    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistr
	
//        .getListenerContainers()) {
//      ContainerTestUtils.waitForAssignment(messageListenerContainer,
//          embeddedKafka.getPartitionsPerTopic());
//    }
//  }

//  @Test
//  public void testReceive() throws Exception {
//    sender.send(BAR_TOPIC, new Bar("bar"));
//    sender.send(FOO_TOPIC, new SensorData("foo"));
//
//    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
//  }
}
