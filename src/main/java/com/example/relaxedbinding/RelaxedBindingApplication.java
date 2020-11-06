package com.example.relaxedbinding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Configuration.class)
public class RelaxedBindingApplication {


  public static void main(String[] args) {
    SpringApplication.run(RelaxedBindingApplication.class, args);
  }

}
