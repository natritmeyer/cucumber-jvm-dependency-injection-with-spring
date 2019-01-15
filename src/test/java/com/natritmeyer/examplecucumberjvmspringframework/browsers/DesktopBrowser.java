package com.natritmeyer.examplecucumberjvmspringframework.browsers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
public class DesktopBrowser {
  @Value("${browser.desktop.width}")
  private int desktopWidth;

  @Value("${browser.desktop.height}")
  private int desktopHeight;

  @Bean
  @Profile("desktop")
  public WebDriver getDriver() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(desktopWidth, desktopHeight));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
  }
}
