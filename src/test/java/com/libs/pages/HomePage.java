package com.libs.pages;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.EnvUtility;
import com.utility.PropertyUtility;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtility {
    private static final By MY_ACCOUNT = By.cssSelector("a[title='My Account']");
    private static final By LOGIN = By.xpath("//a[contains(text(), 'Login')]");
    private static final By REGISTER = By.xpath("//a[contains(text(),'Register')]");

    public HomePage(Browser browser) {
        super(browser);
        goToApp(EnvUtility.getURL(Env.QA));
    }

    public LoginPage navigateToLoginPage() {
        clickOn(MY_ACCOUNT);
        clickOn(LOGIN);
        return new LoginPage(getDriver());
    }
}
