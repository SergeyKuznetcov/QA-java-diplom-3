package ru.yandex.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.ClassRule;
import org.junit.Test;
import ru.yandex.pracricum.EnvConfig;
import ru.yandex.pracricum.RandomUtil;
import ru.yandex.pracricum.page.AuthPage;
import ru.yandex.pracricum.page.RegistrationPage;
import ru.yandex.pracricum.page.dto.User;
import rules.DriverRule;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Registration tests")
public class RegistrationTests {
    private static final String DUMMY_PASS = "asdfg";

    @ClassRule
    public static DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Register user test")
    @Description("Register new user and check redirect to auth page")
    public void registrationTest() {
        open(EnvConfig.REGISTER_PAGE_URL);
        RegistrationPage registrationPage = new RegistrationPage();
        User user = RandomUtil.getRandomUser();
        AuthPage authPage = registrationPage.registerUser(user);
        authPage.waitForPageLoad();
    }

    @Test
    @DisplayName("Registration with short password test")
    @Description("Try to register user with password with length = 5 and check error message")
    public void registrationWithShortPassTest() {
        open(EnvConfig.REGISTER_PAGE_URL);
        RegistrationPage registrationPage = new RegistrationPage();
        User user = RandomUtil.getRandomUser().withPassword(DUMMY_PASS);
        registrationPage.registerUser(user);
        registrationPage.checkPasswordErrorMessage();
    }
}
