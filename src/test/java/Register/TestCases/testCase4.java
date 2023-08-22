package Register.TestCases;

import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase4 extends baseTest {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
    }

    //Creates new account again because testcase2 deletes it
    @Test(priority = 1)
    public void visitHomePageTest() {
        homePageTest();
    }

    @Test(priority = 2)
    public void navigateSignUpTest() {
        signingUpTest();
    }

    @Test(dataProvider = "signUpData", priority = 3)
    public void fillOutSignUpTest(String name, String email) {
        enterSignupTest(name, email);
    }


    @Test(dataProvider = "singUpPageData", priority = 4)
    public void completeSignUpTest(String day, String month, String year, String first_name,
                                   String last_name, String password,
                                   String address, String country, String state,
                                   String city, String zip, String phoneNum) {
        signUpAccountInfo(day, month, year, first_name, last_name, password, address, country, state, city, zip, phoneNum);

    }

    @Test(dataProvider = "signUpData", priority = 5)
    public void verifyNewAccount(String name, String email) {
        verifyUserTest(name);
    }
    @Test(priority = 6)
    public void logOutCurrentUserTest() {
        logoutUserTest();
    }

    //start of testcase4

    @Test(priority = 7)
    public void loggingInTest() {
        loginingInTest();
    }
    @Test(dataProvider = "correctLoginData", priority = 8)
    public void enterCorrectCredentialTest(String email, String password, String name) {
        enterLoginTest(email,password,name);
    }
    @Test(priority = 6)
    public void logoutCurrentUserTest() {
        logoutUserTest();
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
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
