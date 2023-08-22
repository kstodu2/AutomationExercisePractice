package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class productPage {

    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement pageHeading;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement firstProduct;

    @FindBy(xpath = "//div[@class='product-information']//h2")
    private WebElement productName;
    @FindBy(css = "p:nth-of-type(2)")
    private WebElement productCategory;
    @FindBy(css = "span span")
    private WebElement productPrice;
    @FindBy(xpath = "//p[b[text()='Availability:']]")
    private WebElement productAvailability;

    @FindBy(xpath = "//p[b[text()='Condition:']]")
    private WebElement productCondition;
    @FindBy(xpath = "//p[b[text()='Brand:']]")
    private WebElement productBrand;

    @FindBy(id = "search_product")
    private WebElement productSearch;
    @FindBy(id = "submit_search")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    private WebElement searchResult;
    @FindBy(xpath = "//a[@data-product-id='1']")
    private WebElement addToCartFirstProduct;
    @FindBy(xpath = "//a[@data-product-id='2']")
    private WebElement addToCartSecondProduct;
    @FindBy(css = ".single-products:first-child .add-to-cart")
    private WebElement addToCartSearchedProduct;
    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    private WebElement continueShoppingButton;
    @FindBy(xpath="//a[@href='/view_cart']")
    private WebElement cart;
    @FindBy(css="#cart_info_table tbody tr:first-child .cart_description h4 a")
    private WebElement firstProductinCart;
    @FindBy(xpath="//a[@href='/product_details/2']")
    private WebElement secondProductinCart;

    @FindBy(xpath="//*[@id='product-1']/td[3]")
    private WebElement firstItemPrice;
    @FindBy(xpath="//*[@id='product-2']/td[3]")
    private WebElement secondItemPrice;

    @FindBy(xpath="//*[@id='product-1']/td[@class='cart_quantity']")
    private WebElement firstItemQuantity;
    @FindBy(xpath="//*[@id='product-2']/td[@class='cart_quantity']")
    private WebElement secondItemQuantity;
    @FindBy(xpath="//*[@id='product-1']/td[@class='cart_total']")
    private WebElement firstItemTotal;
    @FindBy(xpath="//*[@id='product-2']/td[@class='cart_total']")
    private WebElement secondItemTotal;



    @FindBy(xpath = "//input[@id='quantity']")
    private WebElement productQuantity;

    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement viewCartButton;
    @FindBy(xpath = "//td[@class='cart_quantity']")
    private WebElement cartQuantity;
    @FindBy(xpath = "//a[@href='#Women']")
    private WebElement categoryFilterWomen;
    @FindBy(xpath = "//a[@href='/category_products/1']")
    private WebElement categoryWomenDress;

    @FindBy(xpath = "//a[@href='#Men']")
    private WebElement categoryFilterMen;
    @FindBy(xpath = "//a[@href='/category_products/3']")
    private WebElement categoryMenTshirts;

    @FindBy(xpath = "//a[@href='/brand_products/Madame']")
    private WebElement filterBrandMadame;
    @FindBy(xpath = "//a[@href='/brand_products/Biba']")
    private WebElement filterBrandBiba;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement reviewName;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement reviewEmail;
    @FindBy(xpath = "//textarea[@name='review']")
    private WebElement reviewMessage;
    @FindBy(xpath = "//button[@id='button-review']")
    private WebElement reviewSubmitButton;

    @FindBy(css = "div.brands-name")
    private List<WebElement> brandList;

    @FindBy(css = "div.features_items")
    private List<WebElement> displayedProducts;

    public WebDriver driver;

    public productPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public String getPageHeader() {
        return pageHeading.getText();
    }

    public void getFirstProductInfo() {
        firstProduct.click();
    }

    public String getProductsName() {
        return productName.getText();
    }

    public String getProductCategory() {
        return productCategory.getText();
    }
    public String getProductPrice() {
        return productPrice.getText();
    }
    public String getProductAvailability() {
        return productAvailability.getText();
    }

    public String getProductCondition() {
        return productCondition.getText();
    }

    public String getProductBrand() {
        return productBrand.getText();
    }

    public void getSpecificProduct(String product) {
        productSearch.sendKeys(product);
    }
    public void clickSearchSubmit( ) {
        searchButton.click();
    }
    public String searchResult( ) {
       return searchResult.getText();
    }
    public void clickAddToCartFirstProduct( ) {
        addToCartFirstProduct.click();
    }
    public void clickContinueShoppingButton( ) {
        continueShoppingButton.click();
    }
    public void clickAddToCartSecondProduct( ) {
        addToCartSecondProduct.click();
    }
    public void clickCart(){
        cart.click();
    }
    public String firstProduct() {
        return firstProductinCart.getText();
    }
    public String secondProduct() {
        return secondProductinCart.getText();
    }

    public String firstItemPrice() {
        return firstItemPrice.getText();
    }
    public String secondItemPrice() {
        return secondItemPrice.getText();
    }
    public String firstItemQuantity() {
        return firstItemQuantity.getText();
    }
    public String secondItemQuantity() {
        return secondItemQuantity.getText();
    }
    public String firstItemTotal() {
        return firstItemTotal.getText();
    }
    public String secondItemTotal() {
        return secondItemTotal.getText();
    }


    public void setProductQuantity(String quantity) {
        productQuantity.clear();
        productQuantity.sendKeys(quantity);
    }
    public void clickAddToButton() {
        addToCartButton.click();
    }
    public void clickViewCart() {
        viewCartButton.click();
    }
    public String itemQuantity() {
        return cartQuantity.getText();
    }

    public void filterWomenCategory() {
        categoryFilterWomen.click();
    }
    public void filterWomenDressCategory() {
        categoryWomenDress.click();
    }

    public void filterMenCategory() {
        categoryFilterMen.click();
    }
    public void filterMenTshirtCategory() {
        categoryMenTshirts.click();
    }
    public void filterBrandsMadame() {
        filterBrandMadame.click();
    }
    public boolean brandListFilter() {
        return !brandList.isEmpty();
    }
    public void filterBrandsBiba() {
        filterBrandBiba.click();
    }
    public boolean brandListFilteredProducts() {
        return !displayedProducts.isEmpty();
    }
    public void clickAddToCartSearchedProduct( ) {
        addToCartSearchedProduct.click();
    }

    public void setReviewName(String name) {
        reviewName.sendKeys(name);
    }
    public void setReviewEmail(String email) {
        reviewEmail.sendKeys(email);
    }
    public void setReviewMessage(String message) {
        reviewMessage.sendKeys(message);
    }
    public void clickSubmitReview( ) {
        reviewSubmitButton.click();
    }

}

