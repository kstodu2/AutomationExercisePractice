package Register.resources;

import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class baseTest {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Kacper\\Desktop\\AutomationExercise" +
                "\\src\\test\\java\\Register\\resources\\data.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        switch (browserName) {
            case "firefox" ->
                // execute in firefox driver
                    System.setProperty("webdriver.firefox.driver", "C:\\Users\\Kacper\\Desktop\\WebDrivers\\geckodriver.exe");
            case "chrome" -> {
                //execute in chrome
                System.setProperty("webdriver.firefox.driver", "C:\\Users\\Kacper\\Desktop\\WebDrivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addExtensions(new File("C:\\Users\\Kacper\\Desktop\\WebDrivers\\extension_1_49_2_0.crx"));
                driver = new ChromeDriver(options);
            }
            case "IE" -> {
                //execute in edge
                System.setProperty("webdriver.firefox.driver", "C:\\Users\\Kacper\\Desktop\\WebDrivers\\msedgedriver.exe");
                driver = new EdgeDriver();
            }
        }
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    @Test()
    public void homePageTest() {
        driver.get(prop.getProperty("url"));
        homePage hp = new homePage(driver);
        Assert.assertEquals("Automation Exercise", hp.homepageTitle());
    }
    @Test()
    public void signingUpTest() {
        homePage hp = new homePage(driver);
        hp.clickSignBtn();
        loginPage lp = new loginPage(driver);
        Assert.assertEquals("New User Signup!", lp.getSignupText());
    }
    @Test()
    public void enterSignupTest(String name, String email) {
        loginPage lp = new loginPage(driver);
        lp.setName(name);
        lp.setEmail(email);
        lp.clickSignUp();
        signupPage sp = new signupPage(driver);
        Assert.assertEquals("ENTER ACCOUNT INFORMATION", sp.verifyText());
    }
    @Test()
    public void signUpAccountInfo(String day, String month, String year, String first_name,
                                   String last_name, String password,
                                   String address, String country, String state,
                                   String city, String zip, String phoneNum) {
        signupPage sp = new signupPage(driver);
        sp.selectDay(day);
        sp.selectMonth(month);
        sp.selectYear(year);
        sp.inputTitle();
        sp.inputPassword(password);
        sp.inputFirstName(first_name);
        sp.inputLastName(last_name);
        sp.clickNewsLetter();
        sp.clickOptin();
        sp.inputAddress(address);
        sp.moveToCountry();
        sp.setCountry(country);
        sp.inputState(state);
        sp.inputCity(city);
        sp.inputZipcode(zip);
        sp.inputNumber(phoneNum);
        sp.moveToSubmitClick();
        sp.clickCreateAccount();
        Assert.assertEquals("ACCOUNT CREATED!", sp.verifyAccCreation());
        sp.clickContinue();
    }
    @Test()
    public void verifyUserTest(String name) {
        homePage hp = new homePage(driver);
        Assert.assertEquals(name, hp.loggedInUserText());
    }
    @Test()
    public void deleteAccountTest() {
        homePage hp = new homePage(driver);
        hp.clickDeleteAccount();
        Assert.assertEquals("ACCOUNT DELETED!", hp.deleteAccountText());
        hp.clickDeleteContinue();
    }

    @Test()
    public void loginingInTest() {
        homePage hp = new homePage(driver);
        hp.clickSignBtn();
        loginPage lp = new loginPage(driver);
        Assert.assertEquals("Login to your account", lp.getLoginTxt());
    }
    public void logoutUserTest() {
        homePage hp = new homePage(driver);
        hp.clickLogout();
        Assert.assertEquals("https://www.automationexercise.com/login", driver.getCurrentUrl());
    }
    @Test()
    public void enterLoginTest(String email, String password, String name) {
        loginPage lp = new loginPage(driver);
        lp.setLoginEmail(email);
        lp.setLoginPassword(password);
        lp.clickLoginButton();
        homePage hp = new homePage(driver);
        Assert.assertEquals(name, hp.loggedInUserText());
    }
    @Test()
    public void visitProductPageTest() {
        homePage hp = new homePage(driver);
        hp.clickProducts();
        // if iframe ad pops out because of the click, this works around it.
        int iframeCount = driver.findElements(By.tagName("iframe")).size();
        if(iframeCount > 0){
            driver.switchTo().defaultContent();
            try {
                hp.clickProducts();
            }
            catch (ElementClickInterceptedException e){
                hp.clickProducts();
            }
        }
        productPage pp = new productPage(driver);
        String pageHeader = pp.getPageHeader();
        Assert.assertTrue(pageHeader.equals("ALL PRODUCTS") || pageHeader.equals("FEATURES ITEMS"),
                "Comparison assertion failed");

    }
    @Test()
    public void visitCartPageTest() {
        productPage pp = new productPage(driver);
        pp.clickCart();
        // if iframe ad pops out because of the click, it renders the click usless, this works around it.
        int iframeCount = driver.findElements(By.tagName("iframe")).size();
        if(iframeCount > 0){
            driver.switchTo().defaultContent();
            pp.clickCart();
        }
    }
    @Test()
    public void firstProductInfoTest() {
        productPage pp = new productPage(driver);
        pp.getFirstProductInfo();
    }
    @Test()
    public void firstTwoProductsAddToCartTest() {
        productPage pp = new productPage(driver);
        pp.clickAddToCartFirstProduct();
        pp.clickContinueShoppingButton();
        pp.clickAddToCartSecondProduct();
        pp.clickContinueShoppingButton();
        pp.clickCart();
    }
    @Test()
    public void testCaseTest() {
        homePage hp = new homePage(driver);
        hp.clickTestCases();
        // if iframe ad pops out because of the click, it renders the click usless, this works around it.
        int iframeCount = driver.findElements(By.tagName("iframe")).size();
        if(iframeCount > 0){
            driver.switchTo().defaultContent();
            hp.clickTestCases();
        }
        testCasePage tp = new testCasePage(driver);
        Assert.assertEquals("TEST CASES", tp.getPageHeader());
    }

}
