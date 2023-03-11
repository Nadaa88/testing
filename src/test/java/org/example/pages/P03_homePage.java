package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class P03_homePage {

    private static WebDriver driver;
    private WebDriverWait wait;


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

        Hooks.driver.get(HOMEPAGE_URL);
    }

    public void searchForProduct(String product) {
       Hooks.driver.findElement(searchField).sendKeys(product + Keys.ENTER);
    }

    private static final String SEARCH_RESULTS_URL_PARTIAL = "https://demo.nopcommerce.com/search?q=";

    private static final By searchResults = By.cssSelector(".product-item");
    private final By productLink = By.cssSelector(".product-item > div > a");
    private final By productSku = By.cssSelector(".sku");

    public static boolean isSearchResultsDisplayed() {

        return !Hooks.driver.findElements(searchResults).isEmpty();
    }

    public static String getCurrentURL() {

        return Hooks.driver.getCurrentUrl();
    }

    public static boolean isProductInSearchResults(String product) {
        List<WebElement> results = Hooks.driver.findElements(searchResults);
        return false;
    }

    private final By mainCategories = By.xpath("//div[@class='header-menu']/ul[1]/li/a");
    private final By subCategories = By.xpath("//div[@class='header-menu']/ul[1]/li//ul/li/a");

    public void NavigateToHomePage() {

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

    private final By firstSlider = By.xpath("//div[@class='slider-wrapper theme-default']/div[1]/a/img");
    private final By secondSlider = By.xpath("//div[@class='slider-wrapper theme-default']/div[2]/a/img");

    public P03_homePage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickOnFirstSlider() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement slider = wait.until(ExpectedConditions.elementToBeClickable(firstSlider));
        slider.click();
    }

    public void clickOnSecondSlider() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement slider = wait.until(ExpectedConditions.elementToBeClickable(secondSlider));
        slider.click();

    }

    public void clickFacebookLink() {
        By facebookLink = By.cssSelector("a[href='https://www.facebook.com/nopCommerce']");
        WebElement link = driver.findElement(facebookLink);
        link.click();
    }

    public void clickTwitterLink() {
        By twitterLink = By.cssSelector("a[href='https://twitter.com/nopCommerce']");
        WebElement link = driver.findElement(twitterLink);
        link.click();
    }

    public void clickRssLink() {
        By rssLink = By.cssSelector("a[href='https://demo.nopcommerce.com/new-online-store-is-open']");
        WebElement link = driver.findElement(rssLink);
        link.click();
    }

    public void clickYoutubeLink() {
        By youtubeLink = By.cssSelector("a[href='https://www.youtube.com/user/nopCommerce']");
        WebElement link = driver.findElement(youtubeLink);
        link.click();
    }

    public By wishlistButton(String productName) {
        return By.xpath(String.format("//h2[contains(.,'%s')]/following-sibling::div[@class='add-info']/div[@class='buttons']/button[@class='wishlist']",
                productName));
    }

    public By successMessage = By.xpath("//div[contains(@class,'bar-notification')]/p[contains(text(),'The product has been added to your wishlist')]");

    public void clickWishlistButton(String productName) {
        clickWishlistButton((productName));
    }

    public boolean isSuccessMessageDisplayed() {
        return isSuccessMessageDisplayed();
    }

    public String getSuccessMessageText() {
        return getSuccessMessageText();
    }

    public String getSuccessMessageBackgroundColor() {
        WebElement message = driver.findElement(successMessage);
        return message.getCssValue("background-color");
    }

    public void waitForSuccessMessageToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(successMessage));

    }
    private final By wishlistButton = By.xpath("//h2[@class='product-title']/a[contains(text(), '%s')]/ancestor::div[@class='item-box']//button[@class='wishlist-add']");
    private final By SuccessMessage = By.xpath("//div[@class='bar-notification success']/p[contains(text(), 'The product has been added to your wishlist')]");
    private final By wishlistTab = By.xpath("//a[contains(text(), 'Wishlist')]");
    private final By qtyFromWishlistTab = By.xpath("//div[@class='wishlist-content']//tbody//td[@class='quantity']/input[@class='qty-input']");

    public void navigateToHomePage() {
        driver.get("https://demo.nopcommerce.com/");
    }

    public void clickOnWishlistButton(String productName) {
        driver.findElement(By.xpath(String.format(productName, wishlistButton))).click();
    }

    public void WaitForSuccessMessageToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(successMessage));
    }

    public void clickOnWishlistTab() {
        driver.findElement(wishlistTab).click();
    }

    public int getQtyFromWishlistTab() {
        WebElement qtyInput = driver.findElement(qtyFromWishlistTab);
        String qtyValue = qtyInput.getAttribute("value");
        return Integer.parseInt(qtyValue);
    }
}


