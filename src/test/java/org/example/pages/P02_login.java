package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {
    public P02_login(){

        PageFactory.initElements(Hooks.driver,this);
    }
     @FindBy(className = "ico-login")
    public WebElement loginlink;
     @FindBy(className = "Email")
    public WebElement email;
     @FindBy(name = "Password")
    public WebElement password;
     @FindBy(className = "button-1 login-button")
    public WebElement loginbutton;
     @FindBy(className = "ico-account")
    public WebElement myaccountlink;
     @FindBy(className = "message-error validation-summary-errors")
    public WebElement errormassage;


}
