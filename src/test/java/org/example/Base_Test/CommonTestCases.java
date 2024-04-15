package org.example.Base_Test;

import org.example.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTestCases {

    @BeforeMethod
    public void openBrowser(){
        DriverManager.init();
    }

    @AfterMethod
    public void closeBrowser(){
        DriverManager.down();
    }
}
