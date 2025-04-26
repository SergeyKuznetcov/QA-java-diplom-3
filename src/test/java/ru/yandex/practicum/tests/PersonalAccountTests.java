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

@DisplayName("Personal account tests")
public class PersonalAccountTests {
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
    @DisplayName("Logout test")
    @Description("Logout on personal account page button")
    public void logoutTest() {
        open(EnvConfig.AUTH_PAGE_URL);
        AuthPage authPage = new AuthPage();
        authPage.login(user);
        PersonalAccountPage personalAccountPage = new HeaderPage().clickPersonalAccountButton();
        authPage = personalAccountPage.clickLogoutButton();
        authPage.waitForPageLoad();
    }
}
