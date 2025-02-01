package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class LoginTest {

    HomePage homePage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage(Browser.EDGE);
    }


    @Test
    public void testWithValidCredentials() {
        MyAccountPage myAccountPage = homePage.navigateToLoginPage()
                .loginWithCredentials("ramkripal.ai@gmail.com", "dEKZkjdSEf@j4TG");

        Assert.assertEquals(myAccountPage.getTitle(), "My Account");
    }

    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }
}
