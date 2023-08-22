package Register.TestCases;

import PageObjects.loginPage;
import PageObjects.signupPage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase5 extends baseTest {

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
    @Test(dataProvider = "signUpData", priority = 3)
    public void accountExistsTest(String name, String email) {
        loginPage lp = new loginPage(driver);
        lp.setName(name);
        lp.setEmail(email);
        lp.clickSignUp();
        signupPage sp = new signupPage(driver);
        Assert.assertEquals("Email Address already exist!", sp.getIncorrectSingupCred());
    }



    @DataProvider
    private Object[][] signUpData() {

        Object[][] data = new Object[1][2];
        data[0][0] = "John Doe";
        data[0][1] = "firstaccount@practice.com";
        return data;
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}

