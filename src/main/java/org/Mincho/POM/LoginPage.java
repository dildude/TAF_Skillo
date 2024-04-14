package org.Mincho.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    //const
    public static final String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4300/users/login";

    //Members of the constructor
    private WebDriver driver;
    private WebDriverWait wait;

    //WebElements or other  UI Map
    @FindBy(css = "p.h4")
    private WebElement loginPageHeaderTitle;
    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameInputField;
    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordInputField;
    @FindBy(xpath = "//span[contains(text(),'Remember me')]")
    private WebElement rememberMeLabelText;
    @FindBy(xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement rememberMeCheckBox;
    @FindBy(id = "sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy(xpath = "//a[contains(.,'Register')]")
    private WebElement loginFormRegistrationLink;
    @FindBy(xpath = "//div[@class=\"toast-message ng-star-inserted\"]")
    private WebElement popUpMsg;

    //Create a constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        PageFactory.initElements(driver, this);
    }

    //User Actions
    public void openLoginPage(){
        this.driver.get(LOGIN_PAGE_URL);
        wait.until(ExpectedConditions.urlContains(LOGIN_PAGE_URL));
    }
    public void validationOfTheHeaderInLoginPage(){
        String expectedTitleHeader = "Sign in";
        String loginFormTitleHeader = loginPageHeaderTitle.getText();
        Assert.assertEquals(loginFormTitleHeader,expectedTitleHeader);

    }
    public void enterCredentialsValid() {
        usernameInputField.clear();
        usernameInputField.sendKeys("Minchotest");

        passwordInputField.clear();
        passwordInputField.sendKeys("123456");
    }
    public void enterCredentialsInvalid() {
        usernameInputField.clear();
        usernameInputField.sendKeys("invalid");

        passwordInputField.clear();
        passwordInputField.sendKeys("123456");
    }
    public void submitCredentials() {
        waitAndClick(loginFormSubmitButton);
    }
    public void msgStatusAfterSubmitSuccessfulLogin() {
        String expectedMsgText = "Successful login!";
        String msgText = popUpMsg.getText();
        Assert.assertEquals(msgText,expectedMsgText);
    }
    public void msgStatusAfterInvalidLogin() {
        String expectedMsgText ="Wrong username or password!";
        String msgText = popUpMsg.getText();
        Assert.assertEquals(msgText,expectedMsgText);
    }
    public void selectingRememberMeCheckBox(){
        rememberMeCheckBox.click();
        System.out.println("Remember me is selected");
    }

    //6.Support verification methods
    private void waitAndClick(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
        System.out.println("Element is clicked ");
    }
}