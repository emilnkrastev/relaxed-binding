package com.example.relaxedbinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  Configuration config;
  
  @GetMapping
  public void get() {
    System.out.println(config.getTokenRuntime());
    
  }
  
}
