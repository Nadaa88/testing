package Outline;

import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.junit.Cucumber;

import javax.swing.*;

@RunWith(Cucumber.Class)
@CucumberOptions (format = {"pretty","html:target/cucumber"})
public class runTest {

}