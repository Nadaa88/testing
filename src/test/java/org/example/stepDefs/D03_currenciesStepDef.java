package org.example.stepDefs;
import org.example.pages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class D03_currenciesStepDef {
    P03_homePage homePage = new P03_homePage();

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        // code to navigate to the home page
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("I select {string} currency from the dropdown list on the top left")
    public void i_select_currency_from_the_dropdown_list_on_the_top_left(String currency) {
        // code to select the currency from the dropdown list
        Select select = new Select (homePage.currencydropdown);
        select.selectByVisibleText(currency);
    }

        List<WebElement> productPrices = homePage.productPrices;

    @Then("I should see the Euro Symbol (€) displayed on the products in the home page")
    public void iShouldSeeTheEuroSymbol€DisplayedOnTheProductsInTheHomePage() {
        for (int i = 0; i < productPrices.size(); i++) {
            String price = productPrices.get(i).getText();
            Assert.assertTrue(productPrices.contains("€"), "The euro symbol is not present in product price: " + productPrices);
        }

    }
}
