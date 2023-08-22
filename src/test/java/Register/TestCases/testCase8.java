package Register.TestCases;

import PageObjects.productPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase8 extends baseTest {

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
    public void clickProductPageTest() {
        visitProductPageTest();
    }
    @Test(priority = 3)
    public void firstProductTest() {
        productPage pp = new productPage(driver);
        pp.getFirstProductInfo();
    }
    @Test(priority = 4)
    public void firstProductDetailsTest() {
        productPage pp = new productPage(driver);
        Assert.assertEquals("Blue Top", pp.getProductsName());
        Assert.assertEquals("Rs. 500", pp.getProductPrice());
        Assert.assertEquals("Availability: In Stock", pp.getProductAvailability());
        Assert.assertEquals("Condition: New", pp.getProductCondition());
        Assert.assertEquals("Brand: Polo", pp.getProductBrand());
    }


    @AfterTest
    public void tearDown() {
        driver.close();
    }
}