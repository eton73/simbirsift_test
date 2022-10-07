package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        // Для того, чтобы аннотация @FindBy заработала
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // кнопка "войти"
    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement loginField;

    // кнопка "выйти"
    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement loginButton;

    // поле вести пароль
    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement passwordField;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void passwordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
