package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage {
    private final SelenideElement inputEmail = $(By.id("email")).as("input Email");
    private final SelenideElement inputPassword = $(By.id("password"));
    private final SelenideElement signInButton = $("button[type='submit']");
    private final SelenideElement emailIncorrect = $("span[data-automation-id='login-failure-help-message']");
    
    public void clickInsideShadowRootOnAllowAllButton() {
        $(shadowCss("#cmpbntyestxt", "#cmpwrapper")).click();
    }
    
    public LoginPage goTo() {
        open("https://www.dice.com/dashboard/login");
        getWebDriver().manage().window().maximize();
        return this;
    }
    
    public LoginPage fillUpFields(String email, String password) {
        inputEmail.setValue(email);
        inputPassword.setValue(password);
        return this;
    }
    
    public ProfilePage pushSignInButton() {
        signInButton.click();
        return new ProfilePage();
    }
    
    public LoginPage assertIncorrectEmailMessage() {
        emailIncorrect.shouldHave(Condition.text("Email and/or password incorrect"));
        return this;
    }
}
