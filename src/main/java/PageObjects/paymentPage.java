package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class paymentPage {

    @FindBy(xpath = "//input[@name='name_on_card']")
    private WebElement nameOnCartPayment;
    @FindBy(xpath = "//input[@name='card_number']")
    private WebElement cardNumberPayment;
    @FindBy(xpath = "//input[@name='cvc']")
    private WebElement cardCvcPayment;

    @FindBy(xpath = "//input[@class='form-control card-expiry-month']")
    private WebElement cardExpirationMonthPayment;
    @FindBy(xpath = "//input[@name='expiry_year']")
    private WebElement cardExpirationYearPayment;

    @FindBy(xpath = "//button[@data-qa='pay-button']")
    private WebElement payAndConfirmOrderButton;

    @FindBy(xpath = "//h2[@data-qa='order-placed']")
    private WebElement orderConfirmation;

    @FindBy(css = "a.btn.btn-primary")
    private WebElement continueButton;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement downloadInvoice;

    public void setName(String cardName) {
        nameOnCartPayment.sendKeys(cardName);
    }
    public void setCardNumber(String cardNum) {
        cardNumberPayment.sendKeys(cardNum);
    }
    public void setCardCvc(String cardCvc) {
        cardCvcPayment.sendKeys(cardCvc);
    }
    public void setCardExpirationMonth(String cardExpMonth) {
        cardExpirationMonthPayment.sendKeys(cardExpMonth);
    }
    public void setCardExpirationYear(String cardExpYear) {
        cardExpirationYearPayment.sendKeys(cardExpYear);
    }

    public void clickPayAndConfirm() {
        payAndConfirmOrderButton.click();
    }
    public String getorderConfimation() {
        return orderConfirmation.getText();
    }
    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickDownloadInvoice() {
        downloadInvoice.click();
    }



    public WebDriver driver;

    public paymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
