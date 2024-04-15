package org.example.tests;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.example.Base_Test.CommonTestCases;
import org.example.pages.POM.DashboardPage_POM;
import org.example.pages.POM.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPOMBaseTest extends CommonTestCases {

    @Test(priority = 1)
    @Description("Negative Test Case for VWO Login")
    public void vwoLogin() {
        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.openURL();
        String error_msg = loginPagePom.loginAction();

        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

        Assertions.assertThat(error_msg)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readKey("errorMessage"));
    }

    @Test(priority = 2)
    @Description("Positive Test Case for VWO Login")
    public void vwoLogin2() {
        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.openURL();
        loginPagePom.positiveLoginAction();
        DashboardPage_POM dashboardPagePom = loginPagePom.afterSuccessfulLogin();
        String expected_username = dashboardPagePom.loggedInUser();

        Assert.assertEquals(expected_username, PropertyReader.readKey("expectedUsername"));

        Assertions.assertThat(expected_username)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readKey("expectedUsername"));

    }
}
