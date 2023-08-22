package Register.TestCases;

import PageObjects.contactUsPage;
import PageObjects.homePage;
import Register.resources.baseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase6 extends baseTest {

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
    public void contactUsTest() {
        homePage hp = new homePage(driver);
        hp.clickContactUs();
        contactUsPage cp = new contactUsPage(driver);
        Assert.assertEquals("GET IN TOUCH", cp.getPageHeader());
    }
    @Test(priority = 2)
    public void contactFormTest() {
        contactUsPage cp = new contactUsPage(driver);
        Assert.assertEquals("GET IN TOUCH", cp.getPageHeader());
    }
    @Test(dataProvider = "contactData", priority = 3)
    public void formFillTest(String name, String email, String subject, String text) {
        contactUsPage cp = new contactUsPage(driver);
        cp.setName(name);
        cp.setEmail(email);
        cp.setSubject(subject);
        cp.setMessage(text);
        String filePath = "C:\\Users\\Kacper\\Desktop\\test.txt";
        cp.uploadFile(filePath);
        cp.clickSubmit();
        cp.handlePopout();
        Assert.assertEquals("Success! Your details have been submitted successfully."
                , cp.getVerification());
        cp.clickHome();
    }

    @DataProvider
    private Object[][] contactData() {

        Object[][] data = new Object[1][4];
        data[0][0] = "John";
        data[0][1] = "firstaccount@practice.com";
        data[0][2] = "QA-Test";
        data[0][3] = "Artisanal kale chips quinoa, mixtape thundercats gastropub " +
                "sustainable irony marfa iPhone selvage.";

        return data;
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}