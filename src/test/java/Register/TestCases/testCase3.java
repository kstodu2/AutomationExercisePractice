package Register.TestCases;

import PageObjects.loginPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase3 extends baseTest {

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
    public void navigateSignUpTest() {
        signingUpTest();
    }


    @Test(dataProvider = "incorrectLoginData", priority = 4)
    public void enterIncorrectLoginTest(String email, String password) {
        loginPage lp = new loginPage(driver);
        lp.setLoginEmail(email);
        lp.setLoginPassword(password);
        lp.clickLoginButton();
        Assert.assertEquals("Your email or password is incorrect!", lp.getIncorrectCredentials());
    }
    @DataProvider
    public Object[][] incorrectLoginData(){
        Object[][] data = new Object[1][2];
        data[0][0] = "wrongaccount@practice.com";
        data[0][1] = "wrongpassword123";
        return data;
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}