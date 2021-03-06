package com.automaton.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation {
    // test case one
    @Test
    public void testCaseOne() {
        System.out.println("------> test case one");
    }

    // test case two
    @Test
    public void testCaseTwo() {
        System.out.println("------> test case two");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("----> before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("----> after method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("---> before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("---> after class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("--> after test");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("--> before test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("-> after suite");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("-> before suite");
    }
}
