package step_definitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Initialize {

    public static AndroidDriver<MobileElement>driver;
    @Before
    public void setUP(){
        initializeDriver();
        //driver.resetApp();

    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }


    }
    public void initializeDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.VERSION,"13.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL_7_API33");

        capabilities.setCapability("appPackage","com.magi.safe.schools");
        capabilities.setCapability("appActivity","com.magi.safe.schools.MainActivity");
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

    }
public static class StudentReport_stepdef {
    @Given("Student sign in with <username> and <password>")
    public void studentSignInWithUsernameAndPassword() {
    }
}
}
