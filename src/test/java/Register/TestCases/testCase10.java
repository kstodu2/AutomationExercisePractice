package Register.TestCases;

import PageObjects.homePage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase10 extends baseTest {

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
    public void subscribeEmailTest() {
        homePage hp = new homePage(driver);
        hp.setSubcribtionEmail("firstaccount@practice.com");
        hp.clickSubscribe();
        Assert.assertEquals("You have been successfully subscribed!",hp.subscriptionMessage());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}