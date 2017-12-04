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
 * Created by llaskin on 11/28/17
 */

public class LoginTest extends TestBase {

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    private String username = "llaskin";
    private String password = "password";

    @Test(dataProvider = "hardCodedBrowsers", alwaysRun = true)
    public void verifyLoginSuccess(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting DemoBlaze page...");
        DemoBlazePage page = DemoBlazePage.visitPage(driver);

        this.annotate("Logging in");
        page.Login(username, password);

        Assert.assertTrue(page.WelcomeExists(username), "Welcome message does not exist");
    }

    @Test(dataProvider = "hardCodedBrowsers", alwaysRun = true)
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
        Assert.assertTrue(isAlertPresent(driver));
        Assert.assertEquals(getAlertText(driver), "User does not exist.");
    }

    public String getAlertText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    boolean isAlertPresent(WebDriver driver){
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 5);
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