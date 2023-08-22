package Register.TestCases;

import PageObjects.productPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase21 extends baseTest {

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
    public void visitProductTest() {
        visitProductPageTest();

    }

    @Test(priority = 3)
    public void firstProductPageTest() {
        firstProductInfoTest();
    }
    @Test(dataProvider = "reviewMessageData",priority = 4)
    public void setReviewNameTest(String name, String email, String message) {
        productPage pp = new productPage(driver);
        pp.setReviewName(name);
    }
    @Test(dataProvider = "reviewMessageData",priority = 5)
    public void setReviewEmailTest(String name, String email, String message) {
        productPage pp = new productPage(driver);
        pp.setReviewEmail(email);
    }
    @Test(dataProvider = "reviewMessageData",priority = 6)
    public void setReviewMessageTest(String name, String email, String message) {
        productPage pp = new productPage(driver);
        pp.setReviewMessage(message);
    }
    @Test(priority = 7)
    public void submitReviewTest() {
        productPage pp = new productPage(driver);
        pp.clickSubmitReview();
    }


    @DataProvider
    private Object[][] reviewMessageData() {

        Object[][] data = new Object[1][3];
        data[0][0] = "John Doe";
        data[0][1] = "firstaccount@practice.com";
        data[0][2] = "This is the review of Blue Top, Blah blah blah.";
        return data;
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
