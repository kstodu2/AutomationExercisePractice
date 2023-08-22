package Register.TestCases;

import PageObjects.productPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.time.Duration.ofSeconds;

public class testCase13 extends baseTest {

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

    @Test(priority = 4)
    public void setProductQuantityTest() {
        productPage pp = new productPage(driver);
        pp.setProductQuantity("4");
        pp.clickAddToButton();
    }
    @Test(priority = 5)
    public void continueToCart(){
        productPage pp = new productPage(driver);
        pp.clickViewCart();
        // refresh because the website doesn't update the cart on time
        driver.navigate().refresh();
    }
    @Test(priority = 6)
    public void checkItemQuantity(){
        productPage pp = new productPage(driver);
        Assert.assertEquals("4",pp.itemQuantity());
    }


        @AfterTest
        public void tearDown () {
            driver.close();
        }

}