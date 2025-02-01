package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }

    @Test
    public void testWithValidCredentials(){
        MyAccountPage myAccountPage =  new HomePage(driver)
                .navigateToLoginPage()
                .loginWithCredentials("ramkripal.ai@gmail.com", "dEKZkjdSEf@j4TG");

        Assert.assertEquals(myAccountPage.getTitle(), "My Account");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
