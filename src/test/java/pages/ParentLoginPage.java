package pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ParentLoginPage extends BasePage{

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Parent / Guardian\"]")
    public AndroidElement parentBtn;

    @FindBy(xpath = "//*[@text ='Email']")
    public AndroidElement usernameInput;

    @FindBy(xpath = "//*[@text ='Password']")
    public AndroidElement passwordInput;

    @FindBy(xpath = "//*[@text ='Repeat Password']")
    public AndroidElement repeatPasswordInput;

    @FindBy(xpath = "//*[@text ='register.']")
    public AndroidElement submitBtn;

    @FindBy (xpath = "//*[@text ='Your name']")
    public AndroidElement parentNameInput;

    @FindBy(xpath = "//*[@text ='Your last name']")
    public AndroidElement parentLastnameInput;

    @FindBy (xpath = "//*[@text ='Phone number (10 Digits)']" )
    public AndroidElement parentPhonenumInput;

    @FindBy (xpath = "//android.view.ViewGroup[@content-desc=\"submit.\"]")
    public AndroidElement persInfoSubmitBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"continue.\"]")
    public AndroidElement continueBtn;

    @FindBy (xpath = "//*[@text = 'While using the app']")
    public AndroidElement allowAppBtn;

    @FindBy(id = "android:id/button1")
    public AndroidElement approvelRequest;

    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")
    public AndroidElement schoolBox;

    @FindBy (xpath = "//*[@text = 'Easton Middle School']")
    public AndroidElement chooseSchool;

    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")
   public AndroidElement gradeBox;

    @FindBy (xpath = "//*[@text ='9th Grade']")
    public AndroidElement chooseGrade;

    @FindBy (xpath = "//android.view.ViewGroup[@content-desc=\"approve.\"]")
    public AndroidElement approveBtn;

    public void parentLogin(String parentEmail, String password){

        parentBtn.click();
        waitUntil(usernameInput).sendKeys(parentEmail);
        passwordInput.sendKeys(password);
        repeatPasswordInput.sendKeys(password);
        submitBtn.click();
    }
    public void personalInfo(String pfirstname, String plastname, String pphonenumber){
        waitUntil(parentNameInput).sendKeys(pfirstname);
        parentLastnameInput.sendKeys(plastname);
        parentPhonenumInput.sendKeys(pphonenumber);
        persInfoSubmitBtn.click();
        continueBtn.click();
        allowAppBtn.click();
        waitUntil(approvelRequest).click();
        schoolBox.click();
        chooseSchool.click();
        gradeBox.click();
        chooseGrade.click();
        approveBtn.click();

    }

    public AndroidElement waitUntil(AndroidElement element) {
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));

    }
}
