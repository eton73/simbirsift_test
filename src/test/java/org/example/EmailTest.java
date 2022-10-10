package org.example;

import org.example.pages.EmailPage;
import org.example.pages.LoginPage;
import org.example.pages.ProfilePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class EmailTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static EmailPage emailPage;
    public static WebDriver driver;

    private static final String SIMBIRSOFT_TITLE = "Simbirsoft Тестовое задание";

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ConfProperties.getProperty("startPage"));

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        emailPage = new EmailPage(driver);
    }

    @Test
    public void emailTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginButton();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();

        profilePage.clickMenuButton();
        String login = profilePage.getUsernameField();
        Assert.assertEquals(ConfProperties.getProperty("login"), login);

        profilePage.clickEmailsButton();

        emailPage.searchMessagesByTopicInInbox(ConfProperties.getProperty("topic"));
        emailPage.clickSearchButton();
        String countMessages = emailPage.getCountFoundMessagesField();
        emailPage.clickNewMessageButton();
        emailPage.inputAddressReceiver(ConfProperties.getProperty("login") + "@yandex.ru");
        emailPage.inputTopicNewMessage(ConfProperties.getProperty("topic") + " Nurtdinov");
        emailPage.inputMessageText(countMessages);
        emailPage.clickSendButton();
    }

    @AfterClass
    public static void logout() {
        emailPage.clickUserMenu();
        emailPage.clickLogoutButton();
        driver.quit();
    }

}
