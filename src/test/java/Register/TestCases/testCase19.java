package Register.TestCases;

import PageObjects.productPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase19 extends baseTest {
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
    public void filterBrandsTest() {
        productPage pp = new productPage(driver);
        Assert.assertTrue(pp.brandListFilter());
    }
    @Test(priority = 4)
    public void filterBrandMadameTest() {
        productPage pp = new productPage(driver);
        pp.filterBrandsMadame();
    }

    @Test(priority = 5)
    public void verifyCorrectFilterBrandTest() {
        productPage pp = new productPage(driver);
        Assert.assertEquals("BRAND - MADAME PRODUCTS", pp.getPageHeader());
    }

    @Test(priority = 6)
    public void filterBrandBibaTest() {
        productPage pp = new productPage(driver);
        pp.filterBrandsBiba();
    }

    @Test(priority = 7)
    public void verifyCorrectFilterBrand2Test() {
        productPage pp = new productPage(driver);
        Assert.assertEquals("BRAND - BIBA PRODUCTS", pp.getPageHeader());
    }
    @Test(priority = 8)
    public void filterBrandsProductsDisplayTest() {
        productPage pp = new productPage(driver);
        Assert.assertTrue(pp.brandListFilteredProducts());
    }

    @AfterTest
    public void tearDown () {
        driver.close();
    }


}
