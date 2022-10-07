package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {

    public WebDriver driver;
    public EmailPage(WebDriver driver) {
        // Для того, чтобы аннотация @FindBy заработала
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // пользовательское меню
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div/div/div[3]/div")
    private WebElement userMenu;

    // кнопка "написать новое сообщение"
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div/nav/div[2]/div/div/div/a")
    private WebElement newMessageButton;

    // кнопка "выйти"
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div/div/div[3]/div/div/div/ul/ul/li[6]/a")
    private WebElement logoutButton;

    // поле адреса получателя сообщения
    @FindBy(xpath = "//*[@id=\"compose-field-1\"]")
    private WebElement addressReceiver;

    // поле ввода названия темы
    @FindBy(xpath = "//*[@id=\"compose-field-subject-4\"]")
    private WebElement inputTopic;

    // поле ввода сообщения
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    private WebElement inputText;

    // кнопка "отправить" сообщение
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[10]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")
    private WebElement sendButton;

    // подсчитать количество сообщений с нужной темой
    public int emailsField(int count, String title) {
        int numberMessages = 0;
        for (int i=1; i<=count; i++) {
            WebElement res = driver.findElement(By.xpath("//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div/div[2]/div/main/div[7]/div[1]/div/div/div[3]/div/div[" + i + "]/div/div/div/a/div/span[2]/div/span/span[1]/span[1]/span"));
            if (title.equals(res.getAttribute("title"))) {
                numberMessages = numberMessages + 1;
            }
        }
        return numberMessages;
    }

    public void clickNewMessageButton() {
        newMessageButton.click();
    }

    public void inputAddressReceiver(String email) {
        addressReceiver.sendKeys(email);
    }

    public void inputTopic(String title) {
        inputTopic.sendKeys(title);
    }

    public void inputText(String text) {
        inputText.sendKeys(text);
    }

    public void sendButton() {
        sendButton.click();
    }

    public void entryMenu() {
        userMenu.click();
    }

    public void userLogout() {
        logoutButton.click();
    }

}
