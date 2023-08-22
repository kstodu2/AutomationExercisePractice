package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class homePage {

    @FindBy(xpath="//a[@href='/login']")
    private WebElement signupButton;
    @FindBy(xpath="//a[@href='/logout']")
    private WebElement logoutButton;
    @FindBy(xpath="//a[@href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(xpath="//i[@class='fa fa-user']/following-sibling::b")
    private WebElement loggedUser;

    @FindBy(xpath="//a[@href='/delete_account']")
    private WebElement deleteAccount;
    @FindBy(xpath="//a[@href='/test_cases']")
    private WebElement testCases;
    @FindBy(xpath="//a[@href='/products']")
    private WebElement products;
    @FindBy(xpath="//a[@href='/view_cart']")
    private WebElement cart;

    @FindBy(css="h2[data-qa='account-deleted'] b")
    private WebElement deleteAccountText;

    @FindBy(xpath="//a[@data-qa='continue-button']")
    private WebElement deleteAccountContinueButton;

    @FindBy(css="a > i.fa.fa-home")
    private WebElement home;
    @FindBy(xpath="//input[@type='email']")
    private WebElement subscribeEmail;
    @FindBy(xpath="//button[@id='subscribe']")
    private WebElement clickSubscribe;
    @FindBy(xpath="//div[@class='alert-success alert']")
    private WebElement subscriptionMessage;
    @FindBy(css="div.recommended_items :first-child")
    private WebElement recommendedItems;

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    private WebElement subscriptionWidget;

    @FindBy(xpath = "//div[@id='recommended-item-carousel']" +
            "//div[@class='item active']//div[@class='productinfo text-center']" +
            "//a[contains(@class, 'add-to-cart')]")
    private List<WebElement> visibleRecommendedItemsAddToCartButtons;

    @FindBy(xpath="//a[@href='/view_cart']")
    private WebElement viewCart;

    @FindBy(xpath="//i[@class='fa fa-angle-up']")
    private WebElement upArrow;


    @FindBy(xpath="//div[@class='carousel-inner']/div[@class='item active']//*[contains(text(),'Full-Fledged practice website')]")
    private WebElement frontPageCarousel;

    public WebDriver driver;

    public homePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public String homepageTitle(){
        return driver.getTitle();
    }
    public void clickSignBtn(){
        signupButton.click();
    }
    public void clickLogout(){
        logoutButton.click();
    }
    public void clickContactUs(){
        contactUsButton.click();
    }
    public void clickTestCases(){
        testCases.click();
    }

    public void clickProducts(){
        products.click();
    }


    public String loggedInUserText(){
        return loggedUser.getText();
    }
    public void clickDeleteAccount(){
        deleteAccount.click();
    }

    public void clickCart(){
        cart.click();
    }
    public String deleteAccountText(){
        return deleteAccountText.getText();
    }
    public void clickDeleteContinue(){
        deleteAccountContinueButton.click();
    }
    public void setSubcribtionEmail(String email){
        subscribeEmail.sendKeys(email);
    }
    public void clickSubscribe(){
        clickSubscribe.click();
    }
    public String subscriptionMessage(){
        return subscriptionMessage.getText();
    }
    public String recommendedItems(){
        return recommendedItems.getText();
    }
    public String getSubscriptionWidget(){
        return subscriptionWidget.getText();
    }
    public void recommendedAddItemRandom(){

        int totalVisibleItems = visibleRecommendedItemsAddToCartButtons.size();
        Random random = new Random();
        int randomIndex = random.nextInt(totalVisibleItems);
        WebElement addToCartButton = visibleRecommendedItemsAddToCartButtons.get(randomIndex);
        addToCartButton.click();
    }
    public void clickViewCart(){
        viewCart.click();
    }

    public void adRemove() {
        //removes ads, workaround continue button misbehave
        String cssSelector = "[data-adsbygoogle-status^='done']";
        List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));

        for (WebElement element : elements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].remove()", element);
        }

    }

    public void ScrollToTheBottom() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
 }
    public void clickUpArrow(){
        upArrow.click();
    }
    public String getFrontPageCarousel(){
        return frontPageCarousel.getText();
    }
    public void ScrollToTheTop() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0,0 )");
    }
}
