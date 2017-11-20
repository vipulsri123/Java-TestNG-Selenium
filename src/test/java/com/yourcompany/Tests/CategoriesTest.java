package com.yourcompany.Tests;

import com.yourcompany.Pages.DemoBlazePage;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

/**
 * Created by mehmetgerceker on 12/7/15.
 */

public class CategoriesTest extends TestBase {

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyCategoriesCount(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting DemoBlaze page...");
        DemoBlazePage page = DemoBlazePage.visitPage(driver);

        this.annotate("Verifying Categories");
        Assert.assertEquals(page.getCategoriesCount(), 3);
    }

    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyCategories(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting DemoBlaze page...");
        DemoBlazePage page = DemoBlazePage.visitPage(driver);

        this.annotate("Verifying Categories");
        Assert.assertEquals(page.getCategories().get(0).getText(), "CATEGORIES");
        Assert.assertEquals(page.getCategories().get(1).getText(), "Phones");
        Assert.assertEquals(page.getCategories().get(2).getText(), "Laptops");
        Assert.assertEquals(page.getCategories().get(3).getText(), "Monitors");
    }

}