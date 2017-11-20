package com.yourcompany.Tests;

import com.yourcompany.Pages.DemoBlazePage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

/**
 * Created by mehmetgerceker on 12/7/15.
 */

public class LoginTest extends TestBase {

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    private String username = "username";
    private String password = "password";

    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyLoginSuccess(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting DemoBlaze page...");
        DemoBlazePage page = DemoBlazePage.visitPage(driver);

        this.annotate("Logging in");
        page.Login(username, password);

        //Assert(We Were Able To Login)
    }

    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyLoginFailure(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting DemoBlaze page...");
        DemoBlazePage page = DemoBlazePage.visitPage(driver);

        this.annotate("Logging in with invalid username");
        page.Login("BadUsername", "BadPassword");

        this.annotate("Verifying invalid login alert and alert text");
        Assert.assertFalse(isAlertPresent(driver));
        Assert.assertEquals(getAlertText(driver), "User does not exist.");
    }


    public String getAlertText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    boolean isAlertPresent(WebDriver driver){
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }
}