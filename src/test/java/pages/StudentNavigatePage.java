package pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class StudentNavigatePage extends BasePage {

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

    @FindBy (xpath = "//android.view.View[@content-desc=\"SafeTimeme\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[1]")
    public AndroidElement safeTimemeTab;

    @FindBy (xpath = "//android.view.View[@content-desc=\"My Account\"]")
     public AndroidElement myAccountTab;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Logout\"]")
    public AndroidElement logoutBtn;

    @FindBy (xpath = "//*[@text = 'Please select your user type']")
    public AndroidElement assertText;

public void loginApp(String username, String password){
    waitUntil(studentBtn).click();
    signinBtn.click();
    waitUntil(usernameInput).sendKeys(username);
    passwordInput.sendKeys(password);
    loginInput.click();
    waitUntil(allowAppBtn).click();
    waitUntil(safeTimemeTab).click();
    waitUntil(myAccountTab).click();
    logoutBtn.click();



}
    public void closeSuccessfully(){
        String actualText = assertText.getText();
        String expectedText = "Please select your user type";
        assertEquals(expectedText,actualText);

    }



    public AndroidElement waitUntil(AndroidElement element) {
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));

    }
}
