package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class checkOutPage {

    @FindBy(xpath = "//*[@id='address_delivery']/li[4]")
    private WebElement devlieryAddress;

    @FindBy(xpath = "//*[@id='address_invoice']/li[4]")
    private WebElement billingAddress;
    @FindBy(xpath = "//*[@id='address_delivery']/li[6]")
    private WebElement deliveryCityState;

    @FindBy(xpath = "//*[@id='address_delivery']/li[7]")
    private WebElement devliveryCountry;

    @FindBy(xpath = "//textarea[@class='form-control']")
    private WebElement devlieryComment;
    @FindBy(css = "a[href='/payment']")
    private WebElement placeOrderButton;


    public String getDeliveryAddress() {
        return devlieryAddress.getText();
    }
    public String getDeliveryCityState() {
        return deliveryCityState.getText();
    }
    public String getDeliveryCountry() {
        return devliveryCountry.getText();
    }
    public void setDevlieryComment(String comment) {
        devlieryComment.sendKeys(comment);
    }
    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }


    public String getBillingAddress() {
        return billingAddress.getText();
    }
    public WebDriver driver;

    public checkOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
