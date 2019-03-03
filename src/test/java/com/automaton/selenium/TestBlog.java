package com.automaton.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBlog {
    private static int timeout = 10;

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Creating a web driver instance for each test
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1280, 1024));
    }

    @AfterTest
    public void tearDown() {
        // Closing a web driver after each test
        if (driver != null)
            driver.close();
    }

    @Test
    public void testBlog() {
        /* Test case:
         * 1) Go to burhanh.github.io site
         * 2) Check target URL after
         * 3) Then find a link to the Automaton Project on a page
         * 4) Check if the link is presented
         * 5) Click the link
         * 6) Check target URL after
         * 7) Find a link to the Automaton-v11 project in GitHub on a page
         * 8) Verify that the link is clickable
         */

        // 1
        driver.get("https://burhanh.github.io/");
        // 2
        Assert.assertEquals(driver.getCurrentUrl(), "https://burhanh.github.io/");
        // 3
        WebElement element = driver.findElement(By.cssSelector(".page-link:nth-of-type(2)"));
        // 4
        Assert.assertTrue(element.isDisplayed(), "Project Automation link is not presented!");
        // 5
        element.click();
        // 6
        Assert.assertEquals(driver.getCurrentUrl(), "https://burhanh.github.io/automaton/");
        // 7
        WebElement element1 = driver.findElement(By.cssSelector("[title='Automaton-v11 project']"));
        // 8
        Assert.assertTrue(isClickable(element1, driver), "Web element is not clickable!");
    }

    private static boolean isClickable(WebElement element, WebDriver driver) {
        /*
         * This method helps to verify that a web element is clickable or not. Syntactic Sugar?
         *
         * @param element       a web element for verification
         * @param driver        a web driver instance
         *
         * @return true         if a web element is clickable
         * @return false        if a web element is not clickable
         */
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
