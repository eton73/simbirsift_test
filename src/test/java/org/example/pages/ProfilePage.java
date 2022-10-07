package org.example.pages;

import org.openqa.selenium.By;
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

    // поле названия логина
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div")
    private WebElement usernameLabel;

    // кнопка пользовательского меню
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div")
    private WebElement userMenu;

    // кнопка "выйти"
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/ul/li[1]/a")
    private WebElement loginButton;

    // получить логин
    public String getUsernameLabel() {
        // ожидание, чтобы элементы успели загрузиться
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div[2]")));
        String username = usernameLabel.getText();
        return username;
    }

    public void entryMenu() {
        userMenu.click();
    }

    public void clickEmailsButton() {
        loginButton.click();
    }

}
