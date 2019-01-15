package com.natritmeyer.examplecucumberjvmspringframework.aut.implementations.mobile;

import com.natritmeyer.examplecucumberjvmspringframework.aut.model.BingHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mobile")
public class MobileBingHomePage implements BingHomePage {
  @Value("${aut.urls.home}")
  private String homePageUrl;

  private final WebDriver driver;

  @Autowired
  public MobileBingHomePage(WebDriver driver) {
    this.driver = driver;
  }

  @Override
  public void load() {
    driver.get(homePageUrl);
  }

  @Override
  public void searchFor(String searchTerm) {
    driver.findElement(By.id("hc_popnow")); //wait for the trending stories - js has done loading by this point
    driver.findElement(By.id("sb_form_q")).sendKeys(searchTerm);
    driver.findElement(By.id("sbBtn")).click();
  }
}
