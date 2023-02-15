package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    P02_login login = new P02_login();

    @Given("user go to login page")
    public void userGoToLoginPage() {

        login.loginlink.click();
    }

    @When("user login with valid email {string} and {string}")
    public void userLoginWithValidEmailAnd(String arg0, String arg1) {
        login.email.sendKeys(arg0);
        login.password.sendKeys(arg1);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {

        login.loginbutton.click();
    }

    @Then("user logs in to the system successfully")
    public void userLogsInToTheSystemSuccessfully() {
        SoftAssert soft = new SoftAssert();
        String actualURL = Hooks.driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/";

        soft.assertEquals(actualURL, expectedURL);

        soft.assertTrue(login.myaccountlink.isDisplayed(),"Tab is not displayed");
        soft.assertAll();
    }


    @Given("user verify to login page")
    public void userVerifyToLoginPage() {

        login.loginlink.click();
    }

    @When("user login with invalid email {string} and {string}")
    public void userLoginWithInvalidemailAnd(String arg0, String arg1) {
        login.email.sendKeys(arg0);
        login.password.sendKeys(arg1);
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() {

        login.loginbutton.click();
    }

    @Then("user could not log in to the system")
    public void userCouldNotLogInToTheSystem() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.errormassage.getText().toLowerCase().contains("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found"));
        String actualcolor = login.errormassage.getCssValue("color");
        soft.assertEquals(Color.fromString(actualcolor).asHex(), "e4434b");
        soft.assertAll();
    }

}


