package org.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collection;
import java.util.Collections;

public class BaseTest {
    WebDriver driver;

    WebDriver startDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Home\\Tools\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        System.out.println(options.getBrowserName());
        options.addArguments("incognito", "start-maximized");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        return driver;
    }

    void quitDriver(){
        driver.quit();
    }
}
