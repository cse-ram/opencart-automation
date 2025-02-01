package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtility {
    private static final By MY_ACCOUNT = By.cssSelector("a[title='My Account']");
    private static final By LOGIN = By.xpath("//a[contains(text(), 'Login')]");
    private static final By REGISTER = By.xpath("//a[contains(text(),'Register')]");

    public HomePage(Browser browser) {
        super(browser);
        goToApp("https://naveenautomationlabs.com/opencart/index.php");
    }

    public LoginPage navigateToLoginPage() {
        clickOn(MY_ACCOUNT);
        clickOn(LOGIN);
        return new LoginPage(getDriver());
    }
}
