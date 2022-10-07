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
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get("https://passport.yandex.ru/auth/");

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        emailPage = new EmailPage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin("hotabsc");
        loginPage.clickLoginButton();
        loginPage.passwordField("my_pass");
        loginPage.clickLoginButton();

        profilePage.entryMenu();
        String login = profilePage.getUsernameLabel();
        System.out.println(login);
        // проверяем авторизовались ли
        Assert.assertEquals("my_login", login);

        profilePage.clickEmailsButton();
        int number = emailPage.emailsField(15, SIMBIRSOFT_TITLE);
        System.out.println(number);

        emailPage.clickNewMessageButton();
        emailPage.inputAddressReceiver("my_login@yandex.ru");
        emailPage.inputTopic(SIMBIRSOFT_TITLE + " " + "Nurtdinov");
        emailPage.inputText(String.valueOf(number));
        emailPage.sendButton();
    }

    @AfterClass
    public static void logout() {
        emailPage.entryMenu();
        // unexpected alert open: {Alert text : }
        // emailPage.userLogout();
        driver.close();
    }

}
