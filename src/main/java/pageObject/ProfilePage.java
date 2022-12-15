package pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {
    
    private final SelenideElement contactFirstName = $("#contact-first-name");
    private final SelenideElement contactLastName = $("#contact-last-name");
    
    public ProfilePage assertFirstAndLastName(String firstName, String lastName) {
        contactFirstName.shouldHave(Condition.text(firstName));
        contactLastName.shouldHave(Condition.text(lastName));
        return this;
    }
    
    public ProfilePage assertLinkRowFields(){
        List<String> expectedLinks = List.of("Profile","Jobs","Alerts","Settings");
        ElementsCollection linksLink =$$(".personal-links-section div[class*=link-row]");
        // receving list -> trim to get clean data
        List <String> linksLinkText = linksLink.texts()
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    
        
        System.out.println(linksLinkText);
        Assert.assertEquals(expectedLinks,linksLinkText);
        return this;
    }
}
