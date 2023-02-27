package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.junit.Assert;

public class D04_searchStepDef {
    private P03_homePage homePage;
    private String searchedProduct;
    private String searchedSku;
    private P03_homePage searchResultsPage;

    @Given("user is on the home page of the website")
    public void user_is_on_the_home_page_of_the_website() {
       homePage = new P03_homePage();
        homePage.goToHomePage();
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        searchedProduct = product;
        homePage.searchForProduct(product);
    }

    @When("user searches for product with sku {string}")
    public void user_searches_for_product_with_sku(String sku) {
        searchedSku = sku;
        homePage.searchForProduct(sku);
    }

    @Then("search shows relevant results")
    public void search_shows_relevant_results() {
        P03_homePage P03_homePage;
        P03_homePage = new P03_homePage();
        Assert.assertTrue(P03_homePage.isSearchResultsDisplayed());
    }

    @Then("URL contains {string}")
    public void url_contains(String url) {
        Assert.assertTrue(searchResultsPage.getCurrentURL().contains(url));
    }

    @Then("verify the search results contain the searched product")
    public void verify_the_search_results_contain_the_searched_product() {
        Assert.assertTrue(P03_homePage.isProductInSearchResults(searchedProduct));
    }

    @Then("click on the product in search result")
    public void click_on_the_product_in_search_result() {
        P03_homePage.clickProductInSearchResults();
    }

    @Then("verify the sku of the product is {string}")
    public void verify_the_sku_of_the_product_is(String sku) {
        Assert.assertEquals(sku, P03_homePage.getProductSku());
    }
}

