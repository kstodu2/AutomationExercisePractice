package Register.TestCases;

import PageObjects.cartPage;
import PageObjects.checkOutPage;
import PageObjects.paymentPage;
import PageObjects.productPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase16 extends baseTest {


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
    public void visitLoginPage() {
        signingUpTest();
    }
    @Test(priority = 3)
    public void loggingInTest() {
        loginingInTest();
    }
    @Test(dataProvider = "correctLoginData", priority = 4)
    public void enterCorrectCredentialTest(String email, String password, String name) {
        enterLoginTest(email,password,name);
    }
    @Test(priority = 5)
    public void visitProductTest() {
        visitProductPageTest();

    }

    @Test(priority = 6)
    public void TwoProductsAddToCartTest() {
        firstTwoProductsAddToCartTest();
    }

    @Test(priority = 7)
    public void clickViewCartTest() {
        productPage pp = new productPage(driver);
        pp.clickViewCart();
    }

    @Test(priority = 8)
    public void proceedCheckOutInCartTest() {
        cartPage cartP = new cartPage(driver);
        cartP.clickCheckOut();
    }


    @Test(dataProvider = "singUpPageData", priority =9)
    public void verifyCartAddressTest(String day, String month, String year, String first_name,
                                      String last_name, String password,
                                      String address, String country, String state,
                                      String city, String zip, String phoneNum) {

        checkOutPage checkPage = new checkOutPage(driver);
        Assert.assertEquals(address, checkPage.getDeliveryAddress());
        Assert.assertEquals(city + " " + state + " " + zip, checkPage.getDeliveryCityState());
        Assert.assertEquals(country, checkPage.getDeliveryCountry());

    }

    @Test(priority = 10)
    public void setDeliveryCommentTest() {
        checkOutPage checkPage = new checkOutPage(driver);
        checkPage.setDevlieryComment("Twee actually disrupt, blog pour-over grailed franzen echo park. ");
        checkPage.clickPlaceOrderButton();
    }


    @Test(dataProvider = "paymentProcessData", priority = 11)
    public void paymentProcessTest(String name, String cardNum, String cardCvc, String cardMonth, String cardYear) {
        paymentPage payp = new paymentPage(driver);
        payp.setName(name);
        payp.setCardNumber(cardNum);
        payp.setCardCvc(cardCvc);
        payp.setCardExpirationMonth(cardMonth);
        payp.setCardExpirationYear(cardYear);
        payp.clickPayAndConfirm();
    }

    @Test(priority = 12)
    public void orderConfirmationTest() {
        paymentPage payp = new paymentPage(driver);
        Assert.assertEquals("ORDER PLACED!", payp.getorderConfimation());
        payp.clickContinueButton();
    }

    @Test(priority = 13)
    public void deleteUserAccountTest() {
        deleteAccountTest();
    }


    @DataProvider
    private Object[][] correctLoginData() {

        Object[][] data = new Object[1][3];
        data[0][0] = "firstaccount@practice.com";
        data[0][1] = "password123";
        data[0][2] = "John Doe";
        return data;
    }
    @DataProvider
    private Object[][] signUpData() {

        Object[][] data = new Object[1][2];
        data[0][0] = "John Doe";
        data[0][1] = "firstaccount@practice.com";
        return data;
    }
    @DataProvider
    private Object[][] singUpPageData() {
        Object[][] data = new Object[1][12];
        data[0][0] = "5"; // Day
        data[0][1] = "6"; // Month
        data[0][2] = "1956"; // Year
        data[0][3] = "John"; // First Name
        data[0][4] = "Doe"; // Last Name
        data[0][5] = "password123"; // Password
        data[0][6] = "5929 W Washington"; // Address
        data[0][7] = "United States"; // Country
        data[0][8] = "Illinois"; // State
        data[0][9] = "Chicago"; // City
        data[0][10] = "55555"; // Zip
        data[0][11] = "555-555-5555"; // Phone Number
        return data;
    }
    @DataProvider
    private Object[][] paymentProcessData() {

        Object[][] data = new Object[1][5];
        data[0][0] = "John Doe";
        data[0][1] = "4916491679076519";
        data[0][2] = "270";
        data[0][3] = "2";
        data[0][4] = "2028";
        return data;
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
