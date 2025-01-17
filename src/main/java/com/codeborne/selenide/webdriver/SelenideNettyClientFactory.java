package com.codeborne.selenide.webdriver;

import com.google.auto.service.AutoService;
import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpClientName;
import org.openqa.selenium.remote.http.netty.NettyClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.webdriver.HttpClientTimeouts.defaultLocalReadTimeout;

@AutoService(HttpClient.Factory.class)
@HttpClientName("selenide-netty-client-factory")
public class SelenideNettyClientFactory extends NettyClient.Factory {
  private static final Logger logger = LoggerFactory.getLogger(SelenideNettyClientFactory.class);

  @Override
  public HttpClient createClient(ClientConfig config) {
    ClientConfig configWithShorterTimeout = config.readTimeout(defaultLocalReadTimeout);
    logger.info("Changed readTimeout from {} to {}", config.readTimeout(), configWithShorterTimeout.readTimeout());
    return super.createClient(configWithShorterTimeout);
  }
}
