package Register.TestCases;

import PageObjects.productPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase20 extends baseTest {

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
    @Test(dataProvider = "searchItemData",priority = 3)
    public void searchProductTest(String itemSearched) {
        productPage pp = new productPage(driver);
        pp.getSpecificProduct(itemSearched);
        pp.clickSearchSubmit();
        Assert.assertEquals(itemSearched, pp.searchResult());
    }
    @Test(priority = 4)
    public void addFirstSearchedItemTest() {
        productPage pp = new productPage(driver);
        pp.clickAddToCartSearchedProduct();
    }
    @Test(priority = 5)
    public void visitCartTest() {
        visitCartPageTest();
        driver.navigate().refresh();
    }
    @Test(dataProvider = "searchItemData",priority = 6)
    public void verifyAddedProductInCartTest(String itemAdded) {
        productPage pp = new productPage(driver);
        Assert.assertEquals(itemAdded, pp.firstProduct());
    }
    @Test(priority = 7)
    public void loginFromCartTest() {
        loginingInTest();
    }
    @Test(dataProvider = "correctLoginData",priority = 8)
    public void loginTest(String email, String password, String name) {
        enterLoginTest(email,password, name);
    }
    @Test(priority = 9)
    public void continueToCartTest() {
        visitCartPageTest();
    }
    @Test(dataProvider = "searchItemData",priority = 10)
    public void verifyAddedProductInCartAfterLogginTest(String itemAdded) {
        productPage pp = new productPage(driver);
        Assert.assertEquals(itemAdded, pp.firstProduct());
    }


    @DataProvider
    private Object[][] searchItemData() {

        Object[][] data = new Object[1][1];
        data[0][0] = "Winter Top";
        return data;
    }
    @DataProvider
    private Object[][] correctLoginData() {

        Object[][] data = new Object[1][3];
        data[0][0] = "firstaccount@practice.com";
        data[0][1] = "password123";
        data[0][2] = "John Doe";
        return data;
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
