package pages;

import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.bs.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ScrollHelper;

import static org.junit.Assert.assertEquals;

public class StudentReportPage extends BasePage{

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Student\"]")
    public AndroidElement studentBtn;

    @FindBy (xpath = "//*[@text = 'Please create an account first. Already have an account?0']")
    public AndroidElement signinBtn;

    @FindBy(xpath = "//*[@text ='Email']")
    public AndroidElement usernameInput;

    @FindBy(xpath = "//*[@text ='Password']")
    public AndroidElement passwordInput;

    @FindBy (xpath = "//*[@text = 'login.']")
    public AndroidElement loginInput;

    @FindBy (xpath = "//*[@text = 'While using the app']")
    public AndroidElement allowAppBtn;

    @FindBy (xpath = "//*[@text = 'Enter report details here. Be as specific as possible regarding the source of the threat by including names, location, dates/times, etc.']")
    public AndroidElement reportDetailPlace;

    @FindBy (xpath = "//android.view.ViewGroup[@content-desc=\"I want to share my contact info with law enforcement to contact me about this report.\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    public AndroidElement myContactBtn;

    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.RectView")
    public AndroidElement firstFileInput;

    @FindBy (xpath = "//android.view.ViewGroup[@content-desc=\"send report..\"]")
    public AndroidElement sendReportBtn;

    @FindBy (xpath = "//android.view.ViewGroup[@content-desc=\"new report..\"]")
    public AndroidElement newReportBtn;

    @FindBy (xpath = "//*[@text = 'report to law enforcement.']")
    public AndroidElement assertText;

    public void signIn(String username, String password){
        waitUntil(studentBtn).click();
        signinBtn.click();
        waitUntil(usernameInput).sendKeys(username);
        passwordInput.sendKeys(password);
        loginInput.click();
        waitUntil(allowAppBtn).click();

    }

    public void reportPage(String reportDetails){
        ScrollHelper scrollHelper = new ScrollHelper();
        waitUntil(reportDetailPlace).click();
        reportDetailPlace.sendKeys(reportDetails);
       // reportDetailPlace.sendKeys(Keys.ENTER);
        myContactBtn.click();
        scrollHelper.scrollVerticalHelper("additional media.");
       // firstFileInput.click();
        waitUntil(sendReportBtn).click();
        waitUntil(newReportBtn).click();
    }
    public void assertionForReport(){
        String actualText = assertText.getText();
        String expectedText = "report to law enforcement.";
        assertEquals(expectedText,actualText);
    }

    public AndroidElement waitUntil(AndroidElement element) {
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));

    }
}
