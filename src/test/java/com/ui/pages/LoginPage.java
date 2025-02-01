package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private static final By EMAIL = By.id("input-email");
    private static final By PASSWORD = By.id("input-password");
    private static final By LOGIN_BUTTON = By.cssSelector("input[value='Login']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public MyAccountPage loginWithCredentials(String email, String password){
        typeText(EMAIL, email);
        typeText(PASSWORD, password);
        clickOn(LOGIN_BUTTON);
        return new MyAccountPage(getDriver());
    }
}
