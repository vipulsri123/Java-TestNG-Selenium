package com.yourcompany.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DemoBlazePage {

    @FindBy(css = ".col-lg-3 .list-group-item")
    private List<WebElement> categories;

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

//     @FindBy(id = "your_comments")
//     private WebElement yourCommentsSpan;
// 
//     @FindBy(id = "comments")
//     private WebElement commentsTextAreaInput;
// 
//     @FindBy(id = "submit")
//     private WebElement submitButton;

    public WebDriver driver;
    public static String url = "https://www.demoblaze.com";

    public static DemoBlazePage visitPage(WebDriver driver) {
        DemoBlazePage page = new DemoBlazePage(driver);
        page.visitPage();
        return page;
    }

    public DemoBlazePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public int getCategoriesCount() {
        return (categories.size() - 1);
    }

    public List<WebElement> getCategories() {
        return categories;
    }

    public void Login(String username, String password){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(login)).click();
//        login.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(uname)).click();

//        uname.click();
        uname.sendKeys(username);
        pword.click();
        pword.sendKeys(password);
        buttonSubmit.click();


    }

}
	
    // public void followLink() {
//         theActiveLink.click();
//     }
//     
// 
//     public void submitComment(String text) {
//         commentsTextAreaInput.sendKeys(text);
//         submitButton.click();
// 
//         // Race condition for time to populate yourCommentsSpan
//         WebDriverWait wait = new WebDriverWait(driver, 15);
//         wait.until(ExpectedConditions.textToBePresentInElement(yourCommentsSpan, text));
//     }
// 
//     public String getSubmittedCommentText() {
//         return yourCommentsSpan.getText();
//     }
// 
//     public boolean isOnPage() {
//         String title = "I am a page title - Sauce Labs";
//         return driver.getTitle() == title;
//     }
// 
// }
