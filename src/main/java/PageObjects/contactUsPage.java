package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class contactUsPage {

    @FindBy(xpath = "//h2[contains(text(), 'Get In Touch')]")
    private WebElement pageHeading;

    @FindBy(xpath = "//input[@data-qa='name']")
    private WebElement contactName;
    @FindBy(xpath = "//input[@data-qa='email']")
    private WebElement contactEmail;
    @FindBy(xpath = "//input[@data-qa='subject']")
    private WebElement contactSubject;
    @FindBy(xpath = "//textarea[@data-qa='message']")
    private WebElement contactMessage;
    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement choseFile;
    @FindBy(xpath = "//input[@data-qa='submit-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement getVerification;
    @FindBy(css="a > i.fa.fa-home")
    private WebElement home;


    public WebDriver driver;

    public contactUsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public String getPageHeader(){
        return pageHeading.getText();
    }

    public void setName(String name){
        contactName.sendKeys(name);
    }
    public void setEmail(String email){
        contactEmail.sendKeys(email);
    }
    public void setSubject(String subject){
        contactSubject.sendKeys(subject);
    }
    public void setMessage(String message){
        contactMessage.sendKeys(message);
    }
    public void uploadFile(String filePath){
        choseFile.sendKeys(filePath);
    }
    public void clickSubmit(){
        submitButton.click();
    }
    public void handlePopout(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
    }
    public String getVerification(){
        return getVerification.getText();
    }

    public void clickHome(){
        home.click();
    }
}
