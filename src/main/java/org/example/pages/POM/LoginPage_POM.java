package org.example.pages.POM;

import org.example.Base.RecurringFunctionality;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM extends RecurringFunctionality {

    WebDriver driver;

    public LoginPage_POM(){
        super();
//        driver = new EdgeDriver();
//        driver.get("https://app.vwo.com");
    }

    // Page Locators
    By username = By.id("login-username");
    By password = By.id("login-password");
    By signButton = By.id("js-login-btn");
    By errorMsg = By.id("js-notification-box-msg");


    // Page Actions
    public String loginAction(){
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password,"admin");
        clickElement(signButton);
        presenceOfElement(errorMsg);
        visibilityOfElement(errorMsg);
        return getElement(errorMsg).getText();
    }


    public void positiveLoginAction(){
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password, PropertyReader.readKey("password"));
        clickElement(signButton);
    }

    public DashboardPage_POM afterSuccessfulLogin(){
        return new DashboardPage_POM();
    }
}
