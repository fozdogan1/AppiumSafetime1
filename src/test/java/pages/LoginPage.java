package pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Teacher / Administration\"]")
    public AndroidElement teacherBtn;

    @FindBy(xpath = "//*[@text ='Email']")
    public AndroidElement usernameInput;

    @FindBy(xpath = "//*[@text ='Password']")
    public AndroidElement passwordInput;

    @FindBy(xpath = "//*[@text ='Repeat Password']")
    public AndroidElement repeatPasswordInput;

    @FindBy(xpath = "//*[@text ='register.']")
    public AndroidElement submitBtn;

    @FindBy (xpath = "//*[@text ='First Name']")
    public AndroidElement firstNameInput;

    @FindBy (xpath = "//*[@text ='Last Name']")
    public AndroidElement lastNameInput;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
    public AndroidElement schoolButton;

    @FindBy(xpath = "//*[@text = 'St. Michaels Middle High']")
    public AndroidElement schoolName;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"submit.\"]/android.widget.TextView")
    public AndroidElement submitInfoBtn;

    //@FindBy(xpath = "//*[@content-desc='your-accessibility-id']")
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='continue.']")
    public AndroidElement warnContinueBtn;

    @FindBy (xpath = "//*[@text = 'While using the app']")
    public AndroidElement allowAppBtn;
   // @FindBy(xpath = "//*[@text ='register.']")
    public AndroidElement reportText;




    public void login (String username, String password, String firstname, String lastname){
        teacherBtn.click();
        waitUntil(usernameInput).sendKeys(username);
        passwordInput.sendKeys(password);
        repeatPasswordInput.sendKeys(password);
        submitBtn.click();
        waitUntil(firstNameInput).sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        schoolButton.click();
        schoolName.click();
        submitInfoBtn.click();
        waitUntil(warnContinueBtn).click();
        allowAppBtn.click();
       // waitUntil(reportText);
    }

    public AndroidElement waitUntil(AndroidElement element) {
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));

    }
}
