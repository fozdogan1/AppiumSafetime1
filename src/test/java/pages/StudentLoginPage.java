package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StudentLoginPage extends BasePage{

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Student\"]")
    public AndroidElement studentBtn;

    @FindBy(xpath = "//*[@text ='Email']")
    public AndroidElement usernameInput;

    @FindBy(xpath = "//*[@text ='Password']")
    public AndroidElement passwordInput;

    @FindBy(xpath = "//*[@text ='Repeat Password']")
    public AndroidElement repeatPasswordInput;

    @FindBy(xpath = "//*[@text ='register.']")
    public AndroidElement submitBtn;

   @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.EditText")
   //MobileElement firstnameInput = driver.findElementByAccessibilityId("Your name");
    //MobileElement firstnameInput = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Your name"));

     public AndroidElement firstnameInput;

   @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.EditText")
    public AndroidElement lastnameInput;

   @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Your date of birth\"]")
   public AndroidElement dopBox;

   @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.Button")
    public AndroidElement yearBox;

   @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
   public AndroidElement confirmBox;

    //  (accessibility id) ile bir UI elemanını bulma
    // MobileElement pemailInput = driver.findElementByAccessibilityId("yourAccessibilityId");

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.widget.EditText")
    public AndroidElement pemailInput;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.widget.EditText")
    public AndroidElement pPhoneNumInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"What color backpack would you like?\"]/android.widget.TextView")
    public AndroidElement backpackInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"PURPLE/BLUE\"]/android.view.ViewGroup")
    public AndroidElement backpackChoose;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"done.\"]")
    public AndroidElement bacpackDoneBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"submit.\"]")
    public AndroidElement sSubmitBtn;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    public AndroidElement importantContinue;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"continue.\"]")
    public AndroidElement continueButton;

    @FindBy (xpath = "//*[@text = 'While using the app']")
    public AndroidElement allowAppBtn;

    @FindBy (xpath = "//*[@text = 'report to law enforcement.']")
    public AndroidElement assertElement;


    public void studentLogin(String username, String password){
    studentBtn.click();
        waitUntil(usernameInput).sendKeys(username);
        passwordInput.sendKeys(password);
        repeatPasswordInput.sendKeys(password);
        submitBtn.click();



    }

    public void studentPersonelInfo(String sfirstname, String slastname){
        waitUntil(firstnameInput).sendKeys(sfirstname);
        lastnameInput.sendKeys(slastname);
        dopBox.click();
        yearBox.click();
        confirmBox.click();

    }
    public void studentPemail(String pEmail, String pPhone){
        pemailInput.sendKeys(pEmail);
        pPhoneNumInput.sendKeys(pPhone);
        backpackInput.click();
        backpackChoose.click();
        bacpackDoneBtn.click();
        sSubmitBtn.click();
        importantContinue.click();
        waitUntil(continueButton).click();
        allowAppBtn.click();

    }
    public void succesfully(){
    boolean isVisible = assertElement.isDisplayed();
    }
    public AndroidElement waitUntil(AndroidElement element) {
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));

    }


}
