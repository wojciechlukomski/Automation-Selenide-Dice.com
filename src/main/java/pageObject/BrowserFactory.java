package pageObject;

import com.codeborne.selenide.Configuration;

public class BrowserFactory {
    
    public void getDriver(String browser) {
        
        if ("safari".equals(browser)) {
            Configuration.browser = "safari";
        } else {
            Configuration.browser = "chrome";
        }
    }
}
