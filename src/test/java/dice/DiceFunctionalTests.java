package dice;

import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.BaseTest;
import pageObject.LoginPage;
import pageObject.ProfilePage;

@Listeners({SoftAsserts.class})
public class DiceFunctionalTests extends BaseTest {
    
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage;
    
    @Test(priority = 1, groups = "negative")
    public void negativeLoginTestEmail() {
        loginPage.fillUpFields("woj_luk@com.pl", "Automation2022");
        profilePage = loginPage.pushSignInButton();
        loginPage.assertIncorrectEmailMessage();
    }
    
    @Test(priority = 2, groups = "negative")
    public void negativeLoginTestPassword() {
        loginPage.fillUpFields("woj_luk@wp.pl", "BadPassword2022");
        profilePage = loginPage.pushSignInButton();
        loginPage.assertIncorrectEmailMessage();
    }
    
    @Test(priority = 0, groups = "positive")
    public void positiveLoginTest() throws InterruptedException {
        loginPage.fillUpFields("woj_luk@wp.pl", "Automation2022");
        profilePage = loginPage.pushSignInButton();
        profilePage.assertFirstAndLastName("Wojti", "Luko");
        profilePage.assertLinkRowFields();
    }
}
