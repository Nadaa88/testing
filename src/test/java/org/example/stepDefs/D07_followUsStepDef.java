package org.example.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class D07_followUsStepDef {
    private final WebDriver driver;
    private P03_homePage homePage;

    public D07_followUsStepDef() {
        driver = Hooks.driver;
        homePage = new P03_homePage(driver);
    }

    @Given("the user is on the website homepage")
    public void the_user_is_on_the_website_homepage() {
        homePage = new P03_homePage(driver);
    }

    @When("the user clicks on the Facebook link")
    public void the_user_clicks_on_the_facebook_link() {
        homePage.clickFacebookLink();
        try {
            Thread.sleep(2000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }

    @When("the user clicks on the Twitter link")
    public void the_user_clicks_on_the_twitter_link() {
        homePage.clickTwitterLink();
        try {
            Thread.sleep(2000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }

    @When("the user clicks on the RSS link")
    public void the_user_clicks_on_the_rss_link() {
        homePage.clickRssLink();
        try {
            Thread.sleep(2000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }

    @When("the user clicks on the YouTube link")
    public void the_user_clicks_on_the_youtube_link() {
        homePage.clickYoutubeLink();
        try {
            Thread.sleep(2000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }

    @Then("a new tab should open")
    public void a_new_tab_should_open() {
        Assert.assertEquals(2, driver.getWindowHandles().size());
    }
}


