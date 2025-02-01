package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BrowserUtility {

    private final WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    protected BrowserUtility(WebDriver driver){
        this.driver = driver;
    }

    protected void goToApp(String url){
        driver.get(url);
    }

    protected void maximizeWindow(){
        driver.manage().window().maximize();
    }

    protected void clickOn(By locator){
        WebElement elt = driver.findElement(locator);
        elt.click();
    }

    protected void typeText(By locator, String text){
        WebElement elt = driver.findElement(locator);
        elt.sendKeys(text);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
