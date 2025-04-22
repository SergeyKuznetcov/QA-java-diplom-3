package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import ru.yandex.pracricum.EnvConfig;
import ru.yandex.pracricum.RandomUtil;
import ru.yandex.pracricum.page.*;
import ru.yandex.pracricum.page.dto.User;
import rules.DriverRule;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Redirect tests")
public class RedirectTests {
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
    @DisplayName("Open personal account test")
    @Description("Check personal account redirect on header button click")
    public void openPersonalAccount() {
        open(EnvConfig.AUTH_PAGE_URL);
        AuthPage authPage = new AuthPage();
        authPage.login(user);
        HeaderPage headerPage = new HeaderPage();
        PersonalAccountPage personalAccountPage = headerPage.clickPersonalAccountButton();
        personalAccountPage.checkProfileHeader();
    }

    @Test
    @DisplayName("Open burger constructor test")
    @Description("Check redirect on burger constructor button click")
    public void openBurgerConstructor() {
        open(EnvConfig.REGISTER_PAGE_URL);
        HeaderPage headerPage = new HeaderPage();
        MainPage mainPage = headerPage.clickConstructorButton();
        mainPage.checkBurgerConstructorHeader();
    }

    @Test
    @DisplayName("Open burger constructor by logo test")
    @Description("Check redirect on logo click")
    public void openBurgerConstructorByLogo() {
        open(EnvConfig.REGISTER_PAGE_URL);
        HeaderPage headerPage = new HeaderPage();
        MainPage mainPage = headerPage.clickLogo();
        mainPage.checkBurgerConstructorHeader();
    }

}
