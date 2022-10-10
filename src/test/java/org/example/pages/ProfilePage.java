package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class=\"personal-info-login__text personal-info-login__text_decorated\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@class=\"user-pic user-pic_has-plus_ user-account__pic\"]")
    private WebElement userMenuButton;

    @FindBy(xpath = "//*[@class=\"menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_mail\"]")
    private WebElement emailsButton;

    public String getUsernameField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        return usernameField.getText();
    }

    public void clickMenuButton() {
        userMenuButton.click();
    }

    public void clickEmailsButton() {
        emailsButton.click();
    }

}
