package com.example.relaxedbinding;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.net.URI;
import java.net.URISyntaxException;


@ConfigurationProperties(prefix = "vault")
@Validated
public class Configuration {


  private static final String IS_NOT_ONLY_NUMBERS = "(?![0-9]+$)";
  private static final String DOES_NOT_START_WITH_DASH = "(?<!-)";
  private static final String DOES_NOT_END_WITH_DASH = "(?!-)";
  private static final String CONTAINS_NO_MORE_THAN_63_ALPHANUMERICAL_CHARS = "[a-zA-Z0-9-.]{0,63}";

  /**
   * The hostname where the vault resides.
   */
  private String host;

  /**
   * The port on which the vault should be accessed.
   */
  private Integer port = 8200;

  /**
   * The scheme to be used. Either 'http' or 'https'.
   */
  private String scheme = "https";

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

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public String getScheme() {
    return scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  public URI getUri() {
    try {
      return new URI(scheme, null, host, port, null, null, null);
    } catch (URISyntaxException uriSyntaxException) {
      throw new IllegalArgumentException("Vault credentials cannot build up a valid URL.", uriSyntaxException);
    }
  }

  public static class Token {

    /**
     * The token to be used when accessing vault runtime.
     */
    private String runtime;

    public String getRuntime() {
      return runtime;
    }

    public void setRuntime(String runtime) {
      this.runtime = runtime;
    }
  }
  
}
