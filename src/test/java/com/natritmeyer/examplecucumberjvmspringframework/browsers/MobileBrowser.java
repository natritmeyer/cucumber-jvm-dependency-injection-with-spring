package com.natritmeyer.examplecucumberjvmspringframework.browsers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
public class MobileBrowser {
  @Value("${browser.mobile.width}")
  private int mobileWidth;

  @Value("${browser.mobile.height}")
  private int mobileHeight;

  @Value("${browser.mobile.useragent}")
  private String userAgent;

  @Bean
  @Profile("mobile")
  public WebDriver getDriver() {
    String userAgentString = String.format("--user-agent=%s", userAgent);

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments(userAgentString);

    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.manage().window().setSize(new Dimension(mobileWidth, mobileHeight));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
  }
}
