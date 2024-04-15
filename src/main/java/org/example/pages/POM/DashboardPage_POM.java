package org.example.pages.POM;

import org.example.Base.RecurringFunctionality;
import org.openqa.selenium.By;

public class DashboardPage_POM extends RecurringFunctionality {

    public DashboardPage_POM(){

    }

    // Page Locators
    By username = By.cssSelector("[data-qa=\"lufexuloga\"]");

    // Page Actions
    public String loggedInUser(){
        presenceOfElement(username);
        return getElement(username).getText();
    }
}
