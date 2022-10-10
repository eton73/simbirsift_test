package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {

    public WebDriver driver;
    public EmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class=\"textinput__control\"]")
    private WebElement searchField;

    @FindBy (xpath = "//*[@class=\"control button2 button2_view_default button2_tone_mail-suggest-themed button2_size_n button2_theme_normal button2_pin_clear-round button2_type_submit search-input__form-button\"]")
    private WebElement searchButton;

    @FindBy (xpath = "//*[@class=\"mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap\"]")
    private WebElement countFoundMessagesField;

    @FindBy(xpath = "//*[@class=\"Button2 Button2_type_link Button2_view_action Button2_size_m Layout-m__compose--pTDsx qa-LeftColumn-ComposeButton ComposeButton-m__root--fP-o9\"]")
    private WebElement newMessageButton;

    @FindBy(xpath = "//*[@id=\"compose-field-1\"]")
    private WebElement addressReceiverField;

    @FindBy(xpath = "//*[@id=\"compose-field-subject-4\"]")
    private WebElement topicNewMessageField;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    private WebElement messageTextField;

    @FindBy(xpath = "//*[@class=\"Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l\"]")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//*[@class=\"user-pic user-pic_has-plus_ user-account__pic\"]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@class=\"menu__item menu__item_type_link count-me legouser__menu-item legouser__menu-item_action_exit legouser__menu-item legouser__menu-item_action_exit\"]")
    private WebElement logoutButton;

    public void searchMessagesByTopicInInbox(String topic){
        searchField.sendKeys(String.format("папка:Входящие тема: \"%s\"", topic));
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public String getCountFoundMessagesField(){
        return countFoundMessagesField.getText();
    }

    public void clickNewMessageButton() {
        newMessageButton.click();
    }

    public void inputAddressReceiver(String email) {
        addressReceiverField.sendKeys(email);
    }

    public void inputTopicNewMessage(String title) {
        topicNewMessageField.sendKeys(title);
    }

    public void inputMessageText(String text) {
        messageTextField.sendKeys(text);
    }

    public void clickSendButton() {
        sendMessageButton.click();
    }

    public void clickUserMenu(){
        userMenu.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

}
