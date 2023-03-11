package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

     public class D06_hoverCategoriesStepDef {
         private WebDriver driver;
         private P03_homePage homePage;

         @Given("User is on the home page of nopCommerce website")
         public void user_is_on_home_page() {
             System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
             driver = new ChromeDriver();
             driver.manage().window().maximize();

             driver.get("https://demo.nopcommerce.com/");
             homePage = new P03_homePage(driver);
         }

         @When("User clicks on the first slider")
         public void user_clicks_on_first_slider() {
             homePage.clickOnFirstSlider();
         }

         @Then("User should be redirected to https:\\/\\/demo.nopcommerce.com\\/nokia-lumia{int}")
         public void user_should_be_redirected_to(String expectedUrl) {
             homePage.waitForUrlToContain(expectedUrl);
             String actualUrl = driver.getCurrentUrl();
             Assert.assertEquals(actualUrl, "https://demo.nopcommerce.com/" + expectedUrl);
         }


         @When("User clicks on the second slider")
         public void user_clicks_on_second_slider() {
             homePage.clickOnSecondSlider();
         }

         @Then("User should be redirected to https:\\/\\/demo.nopcommerce.com\\/iphone{int}")
         public void the_url_should_contain(String expected) {
             homePage.waitForUrlToContain(expected);
             String actualUrl = driver.getCurrentUrl();
             Assert.assertTrue(actualUrl.contains(expected));
         }

         @Then("Close the browser")
         public void close_the_browser() {
             driver.quit();
         }

     }