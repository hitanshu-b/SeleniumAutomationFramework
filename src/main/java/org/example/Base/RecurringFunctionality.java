package org.example.Base;

import org.example.driver.DriverManager;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

import static org.example.driver.DriverManager.getDriver;

public class RecurringFunctionality {

    public RecurringFunctionality(){
        // If user wants to call something before every page object class call, Put code here
        // Open a file, Open a Database connection
    }

    public void openURL(){
        getDriver().get(PropertyReader.readKey("url"));
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void enterInput(By by, String key){
        getDriver().findElement(by).sendKeys(key);
    }

    // Waits

    public WebElement presenceOfElement(final By elementLocation){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(final By elementLocation){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key){
        return getDriver().findElement(key);
    }





}
