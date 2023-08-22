package Register.TestCases;

import PageObjects.cartPage;
import PageObjects.homePage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase22 extends baseTest {

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
    public void verifyVisibleRecommendedTest() {
        homePage hp = new homePage(driver);
        Assert.assertEquals("RECOMMENDED ITEMS",hp.recommendedItems());

    }
    @Test(priority = 3)
    public void addToCartRandomRecommendedTest() {
        homePage hp = new homePage(driver);
        hp.recommendedAddItemRandom();
    }
    @Test(priority = 4)
    public void viewCartTest() {
        homePage hp = new homePage(driver);
        hp.clickViewCart();
        driver.navigate().refresh();
    }
    @Test(priority = 5)
    public void cartNotEmptyTest() {
        cartPage cartP = new cartPage(driver);
        Assert.assertNotEquals(0, cartP.getProductCartCount());
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }

}
