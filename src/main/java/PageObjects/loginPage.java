package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class loginPage {

    public WebDriver driver;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPass;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='signup-form']//h2")
    private WebElement signupText;

    @FindBy(xpath = "//div[@class='login-form']//h2")
    private WebElement loginText;

    @FindBy(xpath = "//p[contains(text(), 'Your email or password is incorrect!')]")
    private WebElement incorrectCredentials;





    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public String getSignupText() {
        return signupText.getText();
    }
    public String getLoginTxt() {return loginText.getText();}
    public String getIncorrectCredentials() {return incorrectCredentials.getText();}


    public void setName(String name) {
        signName.sendKeys(name);
    }

    public void setEmail(String email) {
        signEmail.sendKeys(email);
    }

    public void clickSignUp() {
        signButton.click();
    }

    public void setLoginEmail(String email) {
        loginEmail.sendKeys(email);
    }

    public void setLoginPassword(String password) {
        loginPass.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
