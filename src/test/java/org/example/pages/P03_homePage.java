package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class P03_homePage {

    private static WebDriver driver;

    public P03_homePage(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public P03_homePage() {

        PageFactory.initElements(Hooks.driver, this);

    }

    @FindBy(name = "customerCurrency")
    public WebElement currencydropdown;

    @FindBy(className = "prices")
    public
    List<WebElement> productPrices;
    private static final String HOMEPAGE_URL = "https://demo.nopcommerce.com/";

    private final By searchField = By.id("small-searchterms");

    public static String getProductSku() {

        return null;
    }

    public static void clickProductInSearchResults() {
    }

    public void goToHomePage() {

        getDriver().get(HOMEPAGE_URL);
    }

    public void searchForProduct(String product) {
        getDriver().findElement(searchField).sendKeys(product + Keys.ENTER);
    }

    private static final String SEARCH_RESULTS_URL_PARTIAL = "https://demo.nopcommerce.com/search?q=";

    private static final By searchResults = By.cssSelector(".product-item");
    private final By productLink = By.cssSelector(".product-item > div > a");
    private final By productSku = By.cssSelector(".sku");

    public static boolean isSearchResultsDisplayed() {
        return !getDriver().findElements(searchResults).isEmpty();
    }

    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public static boolean isProductInSearchResults(String product) {
        List<WebElement> results = getDriver().findElements(searchResults);
        return false;
    }

    private final By mainCategories = By.xpath("//div[@class='header-menu']/ul[1]/li/a");
    private final By subCategories = By.xpath("//div[@class='header-menu']/ul[1]/li//ul/li/a");

    public void navigateToHomePage() {
        Hooks.driver.get("https://demo.nopcommerce.com/");
    }

    public void selectRandomMainCategory() {
        List<WebElement> categories = Hooks.driver.findElements(mainCategories);
        int categoryIndex = new Random().nextInt(categories.size());
        categories.get(categoryIndex).click();
    }

    public void hoverOnMainCategory() {
        List<WebElement> categories = Hooks.driver.findElements(mainCategories);
        int categoryIndex = new Random().nextInt(categories.size());
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(categories.get(categoryIndex)).perform();
    }

    public List<WebElement> getSubCategories() {
        return Hooks.driver.findElements(subCategories);
    }

    private final By subCategoryPageTitle = By.cssSelector("div[class='page-title'] h1");

    public void selectRandomSubCategory() {
        List<WebElement> subCategories = Hooks.driver.findElements(this.subCategories);
        int subCategoryIndex = new Random().nextInt(subCategories.size());
        subCategories.get(subCategoryIndex).click();
    }

    public String getSelectedSubCategory() {
        List<WebElement> subCategories = Hooks.driver.findElements(this.subCategories);
        int subCategoryIndex = new Random().nextInt(subCategories.size());
        return subCategories.get(subCategoryIndex).getText();
    }

    public static String getSubCategoryPageTitle() {

        return null;
    }
}


