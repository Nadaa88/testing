package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    private SoftAssert softAssert = new SoftAssert();

    @Given("the user is on the homepage")
    public void userIsOnHomepage() {
        homePage = new P03_homePage();
    }

    @When("the user clicks on the wishlist button for {string}")
    public void userClicksOnWishlistButton(String productName) {
        homePage.clickWishlistButton(productName);
    }

    @Then("a success message with a green background color should be displayed")
    public void successMessageIsDisplayed() {
        softAssert.assertTrue(homePage.isSuccessMessageDisplayed(), "Success message is not displayed.");
    }

    @And("the success message should contain the text {string}")
    public void successMessageContainsText(String expectedText) {
        String actualText = homePage.getSuccessMessageText();
        softAssert.assertTrue(actualText.contains(expectedText),
                String.format("Success message text '%s' does not contain expected text '%s'.", actualText, expectedText));
    }

    @And("the success message background color should be green")
    public void successMessageHasGreenBackgroundColor() {
        String actualColor = homePage.getSuccessMessageBackgroundColor();
        softAssert.assertEquals(actualColor, "rgba(85, 173, 85, 1)",
                String.format("Success message background color '%s' is not green.", actualColor));
    }
    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        homePage.navigateToHomePage();
    }

    @When("User clicks on the wishlist button of {string} product")
    public void user_clicks_on_wishlist_button_of_product(String productName) {
        homePage.clickOnWishlistButton(productName);
    }

    @Then("User waits for the success message to disappear and clicks on the Wishlist tab")
    public void user_waits_for_success_message_to_disappear_and_clicks_on_wishlist_tab() {
        homePage.waitForSuccessMessageToDisappear();
        homePage.clickOnWishlistTab();
    }

    @And("User verifies that the Qty value is greater than 0")
    public void user_verifies_qty_is_greater_than_0() {
        int qty = homePage.getQtyFromWishlistTab();
        Assert.assertTrue(qty > 0, "Qty value is not greater than 0");
    }
}

