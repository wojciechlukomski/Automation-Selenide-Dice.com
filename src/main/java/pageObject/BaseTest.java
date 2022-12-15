package pageObject;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    
    BrowserFactory browserFactory = new BrowserFactory();
    LoginPage loginPage = new LoginPage();
    
    @BeforeTest(alwaysRun = true)
    public void setUpBrowser() {
        Configuration.timeout = 8000;
        Configuration.assertionMode = AssertionMode.SOFT;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(false).savePageSource(true));
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethodSetUp(String browser) {
        browserFactory.getDriver(browser);
        loginPage.goTo();
        loginPage.clickInsideShadowRootOnAllowAllButton();
    }
    
    @AfterMethod
    public void afterMethodSetUp() {
        WebDriverRunner.closeWebDriver();
    }
    
}
