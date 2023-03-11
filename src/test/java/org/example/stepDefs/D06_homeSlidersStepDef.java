package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = new P03_homePage();

    @Given("the user is on the Home page")
    public void userIsOnHomePage() {

        homePage.goToHomePage();
    }

    @When("user clicks on the first slider")
    public void userClicksOnTheFirstSlider() {

    }

    @Then("user should be redirected to {string} page")
    public void userShouldBeRedirectedToPage(String arg0) {
    }

    @And("the page should be fully loaded")
    public void thePageShouldBeFullyLoaded() {
    }
}
