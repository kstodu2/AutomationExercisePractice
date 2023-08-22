package Register.TestCases;

import PageObjects.productPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase9 extends baseTest {

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
    @Test(priority = 7)
    public void searchProductTest() {
        productPage pp = new productPage(driver);
        pp.getSpecificProduct("Winter Top");
        pp.clickSearchSubmit();
        Assert.assertEquals("Winter Top", pp.searchResult());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}