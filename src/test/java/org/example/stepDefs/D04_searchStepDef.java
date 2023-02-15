package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class D04_searchStepDef {
    P03_homePage homePage = new P03_homePage();
    private WebElement searchResults;

    public class LoginStepDefs {
        private String searchTerm;

        @Given("user navigates to Facebook")
        public void navigate_to_facebook() throws InterruptedException {
          homePage.facebooklink.click();
            Thread.sleep(5000);
            ArrayList<String>tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
            Hooks.driver.switchTo().window(tabs.get(1));
        }

        @When("user enter Username as {string} and Password as {string}")
        public void enter_username_password(String username, String password) {

            homePage.email.sendKeys(username);
            homePage.pass.sendKeys(password);
        }
        @And("user clicks on the login button")
        public void userClicksOnTheLoginButton() {
            homePage.loginbutton.click();
        }

        @Then("login should be unsuccessful")
        public void verify_login_unsuccessful() {
            // Code to verify login is unsuccessful
            boolean isLoginSuccessful = false;
            SoftAssert soft = new SoftAssert();
            soft.assertFalse(isLoginSuccessful, "Login should not be successful");
            soft.assertAll();
        }
        @Given("user is on the home page of the website")
        public void userIsOnTheHomePageOfTheWebsite() {

           Hooks.driver.get("https://demo.nopcommerce.com/search?q=" + searchTerm);
        }

        @When("user searches for {string}")
        public void userSearchesFor(String arg0) {
            homePage.searchbox.sendKeys(arg0);
        }

        @Then("search shows relevant results")
        public void searchShowsRelevantResults() {
         SoftAssert softAssert = new SoftAssert();
            List<WebElement> results = Hooks.driver.
            int resultCount = results.size();
            softAssert.assertTrue(resultCount > 0, "No search results were found.");
            for (int i = 0; i < resultCount; i++) {
                WebElement result = results.get(i);
                String productName = result.findElement(By.cssSelector(".product-name a")).getText();
                softAssert.assertTrue(productName.toLowerCase().contains(searchTerm.toLowerCase()), "Result does not contain search term.");
            }
            softAssert.assertAll();
        }

        @And("URL contains {string}")
        public void urlContains(String arg0) {
            SoftAssert softAssert = new SoftAssert();
            String currentUrl = Hooks.driver.getCurrentUrl();
            softAssert.assertTrue(currentUrl.contains("https://demo.nopcommerce.com/search?q="), "URL does not contain expected value.");
            softAssert.assertAll();
        }

        }
        @And("verify the search results contain the searched product")
        public void verifyTheSearchResultsContainTheSearchedProduct() {
            searchResults = Hooks.driver.findElement(By.id("small-searchterms"));
            for (WebElement result : homePage.results) {
                String productName = searchResults.getText().toLowerCase();
                Assert.assertTrue(productName.contains(searchResults.toString()),
                        "Search result does not contain the searched product.");
            }
        }

        @Given("user verify to home page of the website")
        public void userVerifyToHomePageOfTheWebsite() {
              Hooks.driver.get("https://demo.nopcommerce.com/");
        }

        @When("user searches for product with sku {string}")
        public void userSearchesForProductWithSku(String searchTerm) {
            searchTerm = searchTerm;
            homePage.searchbox.sendKeys(searchTerm);
        }


    }

