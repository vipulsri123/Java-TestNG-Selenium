package com.yourcompany.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HTCOnePage {

    @FindBy(css = "#login2")
    private WebElement login;

    @FindBy(id = "loginusername")
    private WebElement uname;

    @FindBy(id = "loginpassword")
    private WebElement pword;

    @FindBy(css = "#logInModal .btn-primary")
    private WebElement buttonSubmit;

    @FindBy(css = "div(aria-labelledby=\"logInModalLabel\")")
    private WebElement loginForm;

    @FindBy(id = "nameofuser")
    private WebElement welcomeMessage;

    @FindBy(css = ".btn-success")
    private WebElement addToCart;

    public WebDriver driver;
    public static String url = "http://www.demoblaze.com/prod.html?idp_=7";


    public static HTCOnePage visitPage(WebDriver driver) {
        HTCOnePage page = new HTCOnePage(driver);
        page.visitPage();
        return page;
    }

    public HTCOnePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void selectItem(String linkText){
        driver.findElement(By.linkText(linkText)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(addToCart));
    }

    public void addToCart(){
        addToCart.click();
    }

    public void Login(String username, String password){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(login)).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(uname)).click();
        uname.sendKeys(username);
        pword.click();
        pword.sendKeys(password);
        buttonSubmit.click();


    }

    public boolean WelcomeExists(String username){
        return ("Welcome " + username).equals(welcomeMessage.getText());
    }

}
	
