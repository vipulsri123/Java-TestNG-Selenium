package com.yourcompany.Tests;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by llaskin on 11/28/17.
 */

public class CartTest extends TestBase {

    private String username = "llaskin";
    private String password = "password";

    /**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
//    @Test(dataProvider = "hardCodedBrowsers", alwaysRun = true)
//    public void addHTCtoCart(String browser, String version, String os, Method method)
//            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
//
//        //create webdriver session
//        this.createDriver(browser, version, os, method.getName());
//        WebDriver driver = this.getWebDriver();
//
//        this.annotate("Visiting HTCOnePage page...");
//        HTCOnePage page = HTCOnePage.visitPage(driver);
//
//        this.annotate("Login In");
//        page.Login(username, password);
//
//        this.annotate("Adding to cart");
//        page.addToCart();
//
//        Assert.assertEquals(getAlertText(driver), "Product Added");
//
//    }
//
//    @Test(dataProvider = "hardCodedBrowsers", alwaysRun = true)
//    public void checkEmptyCart(String browser, String version, String os, Method method)
//            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
//
//        //create webdriver session
//        this.createDriver(browser, version, os, method.getName());
//        WebDriver driver = this.getWebDriver();
//
//        this.annotate("Visiting Cart page...");
//        Cart.visitCartLogin(username, password);
//
//        this.annotate("Verifying cart is empty");
//        Assert.assertEquals(0, Cart.getCartItemCount());
//
//    }
//
//    @Test(dataProvider = "hardCodedBrowsers", alwaysRun = true)
//    public void checkFullCartNoWait(String browser, String version, String os, Method method)
//            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
//
//
//        //create webdriver session
//        this.createDriver(browser, version, os, method.getName());
//        WebDriver driver = this.getWebDriver();
//
//
//        this.annotate("Visiting HTCOnePage page...");
//        HTCOnePage page = HTCOnePage.visitPage(driver);
//
//        this.annotate("Login In");
//        page.Login(username, password);
//
//        this.annotate("Adding to cart");
//        page.addToCart();
//        acceptAlert(driver);
//
//        Cart.openCart();
//        Assert.assertEquals(1, Cart.getCartItemCount());
//
//    }


    public String getAlertText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }

}