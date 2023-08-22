package Register.TestCases;

import PageObjects.cartPage;
import PageObjects.homePage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase11 extends baseTest {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }
    @Test(priority = 2)
    public void cartTest() {
        homePage hp = new homePage(driver);
        hp.clickCart();
    }
    @Test(priority = 3)
    public void subscriptionCartTest() {
        cartPage cartp = new cartPage(driver);
        Assert.assertEquals("SUBSCRIPTION", cartp.getSubscriptionText());
    }
    @Test(priority = 4)
    public void enterEmailInCartTest() {
        cartPage cartp = new cartPage(driver);
        cartp.setSubscriptionEmail("firstaccount@practice.com");
        cartp.clickSubscribe();
        Assert.assertEquals("You have been successfully subscribed!", cartp.getSubscriptionMessage());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}