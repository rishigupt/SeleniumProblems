package org.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.devtools.*;

import java.util.*;

public class Selenium extends BaseTest {


    @Test
    void googleAutoSuggestUsingForEach() throws InterruptedException {
        WebDriver driver = startDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium");
        By suggestions = By.xpath("//ul/li[@class='sbct']");
        Thread.sleep(4000);
        List<WebElement> autoSuggestions = driver.findElements(suggestions);
        for (WebElement suggestion: autoSuggestions) {
            if (suggestion.getText().equalsIgnoreCase("selenium webdriver")) {
                suggestion.click();
                break;
            }
        }
    }

    @Test
    void googleAutoSuggestUsingForLoop() throws InterruptedException {
        WebDriver driver = startDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium");
        By suggestions = By.xpath("//ul/li[@class='sbct']");
        Thread.sleep(4000);
        List<WebElement> autoSuggestions = driver.findElements(suggestions);
        for (int i = 0; i<autoSuggestions.size(); i++){
            if (autoSuggestions.get(i).getText().equalsIgnoreCase("selenium webdriver")){
                autoSuggestions.get(i).click();
                break;
            }
        }
        quitDriver();
    }


    @Test
    void openLinkInNewTab(){
        WebDriver driver = startDriver();
        driver.get("https://linkedin.com");
        WebElement ele = driver.findElement(By.partialLinkText("people"));
        ele.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
    }

    @Test
    void getWindowHandlesUsingForEach() throws InterruptedException {
        WebDriver driver = startDriver();
        driver.get("https://linkedin.com");
        By topNavMenu = By.xpath("//ul[contains(@class,'top-nav-menu')]/li");
        List<WebElement> menuList = driver.findElements(topNavMenu);
        for (WebElement menu: menuList){
            driver.findElement(By.partialLinkText(menu.getText())).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }

        for (String winHandle: driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
            if (driver.getTitle().contains("people")){
                driver.findElement(By.linkText("Sign in")).click();
                break;
            }
        }
    }


    @Test
    void getWindowHandlesUsingIterator() throws InterruptedException {
        WebDriver driver = startDriver();
        driver.get("https://linkedin.com");
        By topNavMenu = By.xpath("//ul[contains(@class,'top-nav-menu')]/li");
        List<WebElement> menuList = driver.findElements(topNavMenu);
        for (WebElement menu: menuList){
            driver.findElement(By.partialLinkText(menu.getText())).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> winHandle = windows.iterator();
        while (winHandle.hasNext()) {
            driver.switchTo().window(winHandle.next());
            if (driver.getTitle().contains("people")){
                driver.findElement(By.linkText("Sign in")).click();
                break;
            }
        }
    }

    @Test
    void getWindowHandlesUsingStreams() {
        WebDriver driver = startDriver();
        driver.get("https://linkedin.com");
        By topNavMenu = By.xpath("//ul[contains(@class,'top-nav-menu')]/li");
        List<WebElement> menuList = driver.findElements(topNavMenu);
        for (WebElement menu: menuList){
            driver.findElement(By.partialLinkText(menu.getText())).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }
        System.out.println(driver.getWindowHandles().stream().findFirst().get());
    }

    @Test
    public void geoLocationTest(){
        WebDriver driver = startDriver();
        Map coordinates = new HashMap()
        {{
            put("latitude", 50.2334);
            put("longitude", 0.2334);
            put("accuracy", 1);
        }};

       /* driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);*/
        driver.get("<your site url>");
    }

    @Test
    public void closeTabUsingWindowHandles(){
        
    }


}
