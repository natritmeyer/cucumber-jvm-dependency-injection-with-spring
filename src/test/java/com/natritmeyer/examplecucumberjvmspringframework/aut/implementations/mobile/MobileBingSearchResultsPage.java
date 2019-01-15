package com.natritmeyer.examplecucumberjvmspringframework.aut.implementations.mobile;

import com.natritmeyer.examplecucumberjvmspringframework.aut.model.BingSearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mobile")
public class MobileBingSearchResultsPage implements BingSearchResultsPage {
  private final WebDriver driver;

  @Autowired
  public MobileBingSearchResultsPage(WebDriver driver) {
    this.driver = driver;
  }

  @Override
  public String getFirstResultTitle() {
    driver.findElement(By.cssSelector("ol#b_results")); //waits for the results to be displayed
    return driver.findElement(By.cssSelector("ol#b_results > li.b_algo > div > a > h2")).getText();
  }
}
