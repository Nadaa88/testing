package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage {
   public P03_homePage(){

       PageFactory.initElements(Hooks.driver,this);
   }
    @FindBy(css ="href=\"http://www.facebook.com/nopCommerce\"")
    public WebElement facebooklink;
   @FindBy(name = "customerCurrency")
   public WebElement currencydropdown;

     @FindBy(className = "prices")
     public
     List<WebElement>productPrices;
     @FindBy(name = "email")
    public WebElement email;
     @FindBy(name = "pass")
    public WebElement pass;
     @FindBy(name = "login")
    public WebElement loginbutton;
     @FindBy(id = "small-searchterms")
    public WebElement searchbox;
     @FindBy(className = "ui-menu-item")
    public List<WebElement>results;

}
