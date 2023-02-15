package org.example.stepDefs;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D01_registerStepDef {
    P01_register register = new P01_register();

    @Given("user goes to the register page")
    public void go_to_register() {

        register.registerLink.click();
    }

    @When("user selects a gender type")
    public void select_gender_type() {
        register.gender.click();
    }

    @When("user enters first name {string} and last name {string}")
    public void enter_name(String firstName, String lastName) {
        register.firstname.sendKeys(firstName);
        register.lastname.sendKeys(lastName);
    }

    @When("user enters date of birth")
    public void enter_dob() {
        Select selectday = new Select(register.day);
        selectday.selectByValue("4");
        Select selectmonth = new Select(register.month);
        selectmonth.selectByValue("1");
        Select selectyear = new Select(register.year);
        selectyear.selectByValue("1988");
    }

    @When("user enters email")
    public void enter_email() {
        Faker fake = new Faker();
        String emailaddress = fake.internet().safeEmailAddress();
        register.email.sendKeys(emailaddress);

    }

    @When("user enters {string} password and confirm password")
    public void userEntersPasswordAndConfirmPassword(String arg0) {
            register.password.sendKeys(arg0);
            register.confirmpassword.sendKeys(arg0);
        }
    @When("user clicks on the register button")
    public void click_register() {
        register.registerbutton.click();
    }

    @Then("account is created successfully")
    public void accountIsCreatedSuccessfully() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.succesmassege.getText().toLowerCase().contains("Your registration completed"));
        String actualcolor = register.succesmassege.getCssValue("color");
        soft.assertEquals(Color.fromString(actualcolor).asHex(), "4cb17c");

        soft.assertAll();
    }

}

