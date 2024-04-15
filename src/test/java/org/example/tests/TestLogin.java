package org.example.tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {

    @Test
    @Description("Negative Test Case for VWO Login")
    public void vwoLogin(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        // <input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi">
        WebElement emailInput = driver.findElement(By.id("login-username"));
        emailInput.sendKeys("admin@admin.com");

        // <input type="password" class="text-input W(100%)" name="password" id="login-password" data-qa="jobodapuxe">
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("admin");

        // <button type="submit" id="js-login-btn" class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)"
        // onclick="login.login(event)"
        // data-qa="sibequkica">
        driver.findElement(By.id("js-login-btn")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // <div class="notification-box-description"
        // id="js-notification-box-msg" data-qa="rixawilomi">
        // Your email, password, IP address or location did not match</div>
        WebElement errorMsg = driver.findElement(By.className("notification-box-description"));
        String error_msg = errorMsg.getText();
        String error_msg_attribute = errorMsg.getAttribute("data-qa");
        System.out.println(error_msg_attribute);
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

        driver.quit();
    }
}
