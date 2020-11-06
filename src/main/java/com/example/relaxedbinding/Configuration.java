package com.example.relaxedbinding;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.net.URI;
import java.net.URISyntaxException;


@ConfigurationProperties(prefix = "vault")
@Validated
public class Configuration {

  private Token token;

  public String getTokenRuntime() {
    return token.runtime;
  }

  public Token getToken() {
    return token;
  }
  
  public void setToken(Token token) {
    this.token = token;
  }

  public static class Token {

    private String runtime;

    public String getRuntime() {
      return runtime;
    }

    public void setRuntime(String runtime) {
      this.runtime = runtime;
    }
  }
  
}
