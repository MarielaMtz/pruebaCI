package com.example.PruebaGoogle;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class TestUntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;
  
		
	

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    WebDriverManager.chromedriver().setup();
    
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void UntitledTestCase() throws Exception {
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("coronavirus");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//div[@id='kp-wp-tab-overview']/div[4]/div/div[2]/div/div/div/div/div/div/div/div/a/h3")).click();
    pause(20000);
    assertEquals("Coronavirus – gob.mx", driver.getTitle());
    //Preguntas y respuestas  sobre la enfermedad por coronavirus (COVID-19)
  }

  

@AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  private void pause (long mils) {
  	try {
  	     Thread.sleep(mils);	
  	}catch(Exception e){
  		e.printStackTrace();
  	}
  }
}
