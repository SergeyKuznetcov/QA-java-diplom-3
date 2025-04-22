package ru.yandex.practicum.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import ru.yandex.pracricum.EnvConfig;
import ru.yandex.pracricum.RandomUtil;
import ru.yandex.pracricum.page.*;
import ru.yandex.pracricum.page.dto.User;
import rules.DriverRule;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("LogIn tests")
public class LoginTests {
    @ClassRule
    public static DriverRule driverRule = new DriverRule();

    private static User user;

    @BeforeClass
    public static void init() {
        open(EnvConfig.REGISTER_PAGE_URL);
        RegistrationPage registrationPage = new RegistrationPage();
        user = RandomUtil.getRandomUser();
        registrationPage.registerUser(user);
    }

    @Test
    @DisplayName("Auth by login button test")
    @Description("Auth by login button on main page")
    public void authByLoginButton() {
        open(EnvConfig.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage();
        AuthPage authPage = mainPage.clickAuthButton();
        mainPage = authPage.login(user);
        mainPage.checkBurgerConstructorHeader();
    }

    @Test
    @DisplayName("Auth by personal account page test")
    @Description("Auth by personal account button on main page")
    public void authByPersonalAccountButton() {
        open(EnvConfig.MAIN_PAGE_URL);
        HeaderPage headerPage = new HeaderPage();
        AuthPage authPage = headerPage.clickPersonalAccountButtonNotAuth();
        MainPage mainPage = authPage.login(user);
        mainPage.checkBurgerConstructorHeader();
    }

    @Test
    @DisplayName("Auth by register page test")
    @Description("Auth by login link on register page")
    public void authByRegisterPage() {
        open(EnvConfig.REGISTER_PAGE_URL);
        RegistrationPage registrationPage = new RegistrationPage();
        AuthPage authPage = registrationPage.clickLoginLink();
        MainPage mainPage = authPage.login(user);
        mainPage.checkBurgerConstructorHeader();
    }

    @Test
    @DisplayName("Auth by recover pass page test")
    @Description("Auth by login link on recover password page")
    public void authByRecoverPassPage() {
        open(EnvConfig.RECOVER_PASS_PAGE_URL);
        RecoverPassPage recoverPassPage = new RecoverPassPage();
        AuthPage authPage = recoverPassPage.clickLoinLink();
        MainPage mainPage = authPage.login(user);
        mainPage.checkBurgerConstructorHeader();
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
