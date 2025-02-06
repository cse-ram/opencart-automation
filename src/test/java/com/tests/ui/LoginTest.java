package com.tests.ui;

import com.constants.Browser;
import com.libs.pages.HomePage;
import com.libs.pojos.User;
import com.utility.LoggerUtility;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class LoginTest {

    private HomePage homePage;

    @BeforeMethod(description = "Load the home page of the application before test start.")
    public void setup() {
        homePage = new HomePage(Browser.EDGE);
    }


    @Test(description = "Verify that user is able to login to the application using valid user id",
            groups = {"e2e", "sanity"},
            retryAnalyzer = com.ui.listners.retryAnalyzer.class,
            dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginTestDataProvider")
    public void testLoginScenarios(User user) {
        String title = homePage.navigateToLoginPage()
                .loginWithCredentials(user.email(), user.password())
                .getTitle();
        Logger logger = LoggerUtility.getLogger(this.getClass());
        logger.info("Title is: {}", title);
        if (user.type().equals("valid")) {
            Assert.assertEquals(title, "My Account");
        } else {
            Assert.assertEquals(title, "Account Login");
        }
    }

    @AfterMethod
    public void tearDown() {
        homePage.quit();
    }
}
