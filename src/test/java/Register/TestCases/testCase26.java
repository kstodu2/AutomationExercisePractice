package Register.TestCases;

import PageObjects.homePage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase26 extends baseTest {
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
    public void scrollToTheBottomTest() {
        homePage hp = new homePage(driver);
        hp.ScrollToTheBottom();
    }
    @Test(priority = 3)
    public void verifySubscriptionWidget() {
        homePage hp = new homePage(driver);
        Assert.assertEquals("SUBSCRIPTION",hp.getSubscriptionWidget());
    }
    @Test(priority = 4)
    public void scrollUpTest() {
        homePage hp = new homePage(driver);
        hp.ScrollToTheTop();
    }
    @Test(priority = 5)
    public void verifyTopFrontPageTest() {
        homePage hp = new homePage(driver);
        Assert.assertEquals("Full-Fledged practice website for Automation Engineers",hp.getFrontPageCarousel());
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}