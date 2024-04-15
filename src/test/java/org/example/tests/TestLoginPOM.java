package org.example.tests;

import io.qameta.allure.Description;
import org.example.pages.POM.LoginPage_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPOM {

    @Test
    @Description("Negative Test Case for VWO Login")
    public void vwoLogin(){

        LoginPage_POM loginPagePom = new LoginPage_POM();

        String error_msg = loginPagePom.loginAction();

        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

    }
}
