package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    private P03_homePage homePage;

    @Given("the user is on the Home page")
    public void userIsOnHomePage() {
        homePage.goToHomePage();
    }

    @When("user selects a random main category")
    public void userSelectsRandomMainCategory() {
        homePage.selectRandomMainCategory();
    }

    @And("user hovers on the selected category")
    public void userHoversOnSelectedCategory() {
        homePage.hoverOnMainCategory();
    }

    @And("user selects a random sub category")
    public void userSelectsRandomSubCategory() {
        P03_homePage.selectRandomSubCategory();
    }

    @Then("the sub category page title should contain the selected sub category name")
    public void subCategoryPageTitleShouldContainSelectedSubCategoryName() {
        String expectedTitle = P03_homePage.getSelectedSubCategory().toLowerCase().trim();
        String actualTitle = P03_homePage.getSubCategoryPageTitle().toLowerCase().trim();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
