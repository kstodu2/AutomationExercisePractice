package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class cartPage {

    @FindBy(xpath = "//div[@class='single-widget']//h2")
    private WebElement subscriptionText;
    @FindBy(id = "susbscribe_email")
    private WebElement subscriptionEmail;
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    private WebElement subscriptionButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    private WebElement subscriptionMessage;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement checkoutButton;
    @FindBy(css = "a[href='/login'] u")
    private WebElement registerLoginButton;
    @FindBy(css = "[data-product-id]")
    private List<WebElement> productDeleteElements;

    @FindBy(css = "tbody tr")
    private List<WebElement> ElementsinCart;



    public WebDriver driver;

    public cartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public String getSubscriptionText() {
        return subscriptionText.getText();
    }

    public void setSubscriptionEmail(String email) {
        subscriptionEmail.sendKeys(email);
    }

    public void clickSubscribe() {
        subscriptionButton.click();
    }

    public String getSubscriptionMessage() {
        return subscriptionMessage.getText();
    }
    public void clickCheckOut() {
        checkoutButton.click();
    }
    public void clickRegister() {
        registerLoginButton.click();
    }

    public void deleteCertainProductFromCartTest(int index) {
        if (index >= 1 && index <= productDeleteElements.size()) {
            WebElement productElement = productDeleteElements.get(index - 1);
            productElement.click();
        } else {
            throw new IllegalArgumentException("Invalid product index: " + index);
        }
    }
    public int getProductCartCount(){
        return ElementsinCart.size();
    }


}
