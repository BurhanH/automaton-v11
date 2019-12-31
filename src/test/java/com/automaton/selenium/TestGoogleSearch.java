package com.automaton.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestGoogleSearch {
    
    private WebDriver driver;
    
    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1280, 1024));
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.close();
    }
    
    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("TestNG");
        element.submit();
        
        WebElement element1 = driver.findElement(By.cssSelector(".bNg8Rb"));
        Assert.assertTrue(element1.isDisplayed(), "Unable to find a web element after search action!");
    }
}
