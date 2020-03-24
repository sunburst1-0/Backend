package com.data.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.data.processor.BasicController;

@SpringBootApplication
//@ComponentScan(basePackageClasses = BasicController.class)
@ComponentScan(basePackages="com.data.processor,com.data.kafka.consumer")
public class SpringKafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringKafkaApplication.class, args);
  }
}
