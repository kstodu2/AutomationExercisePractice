package Register.TestCases;


import PageObjects.cartPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase17 extends baseTest {

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
    public void TwoProductsAddToCartTest() {
        firstTwoProductsAddToCartTest();
    }
    @Test(priority = 4)
    public void visitCartTest() {
        visitCartPageTest();
    }
    @Test(priority = 5)
    public void deleteProductFromCartTest() {
        cartPage cartP = new cartPage(driver);
        Assert.assertEquals(2, cartP.getProductCartCount());
        cartP.deleteCertainProductFromCartTest(2);
    }
    @Test(priority = 6)
    public void amountOfItemsInCartTest() {
        cartPage cartP = new cartPage(driver);
        driver.navigate().refresh();
        Assert.assertEquals(1, cartP.getProductCartCount());
    }


    @AfterTest
    public void tearDown () {
        driver.close();
    }

}