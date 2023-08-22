package Register.TestCases;

import PageObjects.productPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase18 extends baseTest {
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
    public void filterCategoryWomenTest() {
        productPage pp = new productPage(driver);
        pp.filterWomenCategory();
    }
    @Test(priority = 4)
    public void filterCategoryWomenDressTest() {
        productPage pp = new productPage(driver);
        pp.filterWomenDressCategory();
    }
    @Test(priority = 5)
    public void verifyCorrectFilterCategoryTest() {
        productPage pp = new productPage(driver);
        Assert.assertEquals("WOMEN - DRESS PRODUCTS",pp.getPageHeader());
    }
    @Test(priority = 6)
    public void filterCategoryMenTest() {
        productPage pp = new productPage(driver);
        pp.filterMenCategory();
    }
    @Test(priority = 7)
    public void filterCategoryMenTshirt() {
        productPage pp = new productPage(driver);
        pp.filterMenTshirtCategory();
    }
    @Test(priority = 8)
    public void verifyCorrectFilterCategoryMenTest() {
        productPage pp = new productPage(driver);
        Assert.assertEquals("MEN - TSHIRTS PRODUCTS",pp.getPageHeader());
    }

    @AfterTest
    public void tearDown () {
        driver.close();
    }
}
