package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class signupPage {


    @FindBy(id = "id_gender1")
    private WebElement title;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement dayDropDown;

    @FindBy(id = "months")
    private WebElement monthDropDown;

    @FindBy(id = "years")
    private WebElement yearDropDown;

     @FindBy(xpath = "//h2[@class='title text-center']/b")
    private WebElement verifyPage;


    @FindBy(id = "newsletter")
    private WebElement newsLetter;

    @FindBy(id = "optin")
    private WebElement optin;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "country")
    private WebElement countryDropDown;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zipcode")
    private WebElement zipcode;

    @FindBy(id = "mobile_number")
    private WebElement number;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//h2[@data-qa='account-created']/b")
    private WebElement accountCreatedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(css="a > i.fa.fa-home")
    private WebElement home;
    @FindBy(xpath = "//p[contains(text(), 'Email Address already exist!')]")
    private WebElement incorrectSingUpCred;






    public WebDriver driver;
    public signupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    public String verifyText(){
        return verifyPage.getText();
    }

    public void inputTitle(){
        title.click();
    }

    public void inputPassword(String pswd){
        password.sendKeys(pswd);
    }

    public String getIncorrectSingupCred() {return incorrectSingUpCred.getText();}
    public void selectDay(String day){
        Select days = new Select(dayDropDown);
        days.selectByValue(day);
    }
    public void selectDay(int index){
        Select days = new Select(dayDropDown);
        days.selectByIndex(index);
    }
    public void selectMonth(int i){
        Select month = new Select(monthDropDown);
        month.selectByIndex(i);
    }
    public void selectMonth(String month){
        Select months = new Select(monthDropDown);
        months.selectByValue(month);
    }
    public void selectYear(String year){

        Select years = new Select(yearDropDown);
        years.selectByValue(year);
    }
    public void selectYear(int index){
        Select years = new Select(yearDropDown);
        years.selectByIndex(index);
    }


    public void clickNewsLetter(){
        newsLetter.click();
    }
    public void clickOptin(){
        optin.click();
    }
    public void inputFirstName(String fname){
        firstName.sendKeys(fname);
    }
    public void inputLastName(String lname){
        lastName.sendKeys(lname);
    }
    public void inputAddress(String addrs){
        address.sendKeys(addrs);
    }

    public void setCountry(String countries){
        Select country = new Select(countryDropDown);
        country.selectByValue(countries);
    }
    public void setCountry(int index){

        Select country = new Select(countryDropDown);
        country.selectByIndex(index);
    }
    public void moveToCountry(){
        //avoids nonclickable
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].scrollIntoView()", countryDropDown);
        Actions actions = new Actions(driver);
        actions.moveToElement(countryDropDown).perform();
    }
    public void moveToSubmitClick(){
        //avoids nonclickable
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].scrollIntoView()", createAccountButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(createAccountButton).perform();
    }

    public void adRemove() {
        //removes ads, workaround continue button misbehave
        String cssSelector = "[data-adsbygoogle-status^='done']";
        List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));

        for (WebElement element : elements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].remove()", element);
        }
        home.click();

    }

    public void inputState(String st){
        state.sendKeys(st);
    }

    public void inputCity(String cities){
        city.sendKeys(cities);
    }

    public void inputZipcode(String zip){
        zipcode.sendKeys(zip);
    }
    public void inputNumber(String num){
        number.sendKeys(num);
    }

    public void clickCreateAccount(){
        createAccountButton.click();
    }

    public String verifyAccCreation(){
        return accountCreatedText.getText();
    }

    public void clickContinue(){

        continueButton.click();
    }



}
