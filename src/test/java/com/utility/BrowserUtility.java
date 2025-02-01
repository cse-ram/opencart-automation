package com.utility;

import com.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class BrowserUtility {

    private final WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    protected BrowserUtility(WebDriver driver){
        this.driver = driver;
    }

    protected BrowserUtility(String browser){
        driver = switch (browser.toLowerCase()){
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
    }

    protected BrowserUtility(Browser browser){
        driver = switch (browser){
            case CHROME -> new ChromeDriver();
            case EDGE -> new EdgeDriver();
        };
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

    public void quit(){
        if(driver!=null){
            driver.quit();
        }
    }
}
