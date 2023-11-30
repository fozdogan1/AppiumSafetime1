package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.Initialize;

public abstract class BasePage {

    public AndroidDriver<MobileElement>driver;

    public WebDriverWait wait;



    public BasePage(){
        this.driver = Initialize.driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        wait = new WebDriverWait(driver,10);
    }
}
