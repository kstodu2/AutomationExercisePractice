package Register.TestCases;

import PageObjects.productPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase12 extends baseTest {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
    }
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
        visitProductPageTest();
    }
    @Test(priority = 2)
    public void visitProductTest() {
        visitProductPageTest();

    }
    @Test(priority = 3)
    public void TwoProductsAddToCartTest() {
        firstTwoProductsAddToCartTest();
    }
    @Test(priority = 4)
    public void visitCartTest() {
        visitCartPageTest();
    }

    @Test(priority = 5)
    public void verifyProductsinCartTest() {
        productPage pp = new productPage(driver);
        Assert.assertEquals("Blue Top", pp.firstProduct());
        Assert.assertEquals("Men Tshirt", pp.secondProduct());
        Assert.assertEquals("Rs. 500", pp.firstItemPrice());
        Assert.assertEquals("Rs. 400", pp.secondItemPrice());
        Assert.assertEquals("1", pp.firstItemQuantity());
        Assert.assertEquals("1", pp.secondItemQuantity());
        Assert.assertEquals("Rs. 500", pp.firstItemTotal());
        Assert.assertEquals("Rs. 400", pp.secondItemTotal());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}