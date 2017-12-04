package com.yourcompany.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Cart {

    @FindBy(css = ".col-lg-3 .list-group-item")
    private List<WebElement> categories;

    @FindBy(css = ".success")
    private static List<WebElement> cartItem;


    @FindBy(css = "#login2")
    private static WebElement login;

    @FindBy(id = "loginusername")
    private static WebElement uname;

    @FindBy(id = "loginpassword")
    private static WebElement pword;

    @FindBy(css = "#logInModal .btn-primary")
    private static WebElement buttonSubmit;

    @FindBy(css = "div(aria-labelledby=\"logInModalLabel\")")
    private WebElement loginForm;

    @FindBy(xpath = "//a[contains(getText(), 'Cart']")
    private static WebElement cartLink;

    public WebDriver driver;

    public static String url = "http://www.demoblaze.com/prod.html?idp_=7";
    public static String cartURL = "http://www.demoblaze.com/cart.html";


    public static Cart visitPage(WebDriver driver) {
        Cart page = new Cart(driver);
        page.visitPage();

        return page;
    }

    public Cart visitCartLogin(WebDriver webdriver, String username, String password) {
        Cart page = new Cart(webdriver);
        page.visitCart();
        Login(username, password);


        return page;
    }

    public Cart (WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(this.driver, this);
    }

    public void visitPage() {
        this.driver.get(cartURL);
    }

    public void visitCart() { this.driver.get(cartURL); }

    public static void openCart() {
        cartLink.click();

    }


    public void Login(String username, String password){
//        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(login)).click();
        login.click();
        new WebDriverWait(this.driver, 1).until(ExpectedConditions.visibilityOf(uname)).click();

        uname.sendKeys(username);
        pword.click();
        pword.sendKeys(password);
        buttonSubmit.click();
    }

    public static int getCartItemCount(){
        //Find all cart items and return their count
        return cartItem.size();

    }

}

