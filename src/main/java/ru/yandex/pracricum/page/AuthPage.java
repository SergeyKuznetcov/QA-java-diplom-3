package ru.yandex.pracricum.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.yandex.pracricum.page.dto.User;

import static com.codeborne.selenide.Selectors.*;

public class AuthPage {
    private static final By EMAIL_FIELD = byXpath("//label[text()='Email']/parent::div/input");
    private static final By PASSWORD_FIELD = byXpath("//label[text()='Пароль']/parent::div/input");

    private static final By AUTH_PAGE_HEADER = byText("Вход");
    private static final By LOGIN_BUTTON = byText("Войти");

    public MainPage login(User user) {
        fillEmailField(user.getEmail());
        fillPassField(user.getPassword());
        return clickLoginButton();
    }

    @Step("Click login button")
    private MainPage clickLoginButton() {
        Selenide.$(LOGIN_BUTTON).click();
        return new MainPage();
    }

    @Step("Fill email field")
    private void fillEmailField(String value) {
        Selenide.$(EMAIL_FIELD).setValue(value);
    }

    @Step("Fill password field")
    private void fillPassField(String value) {
        Selenide.$(PASSWORD_FIELD).setValue(value);
    }

    @Step("Check auth page header")
    public void waitForPageLoad() {
        Selenide.$(AUTH_PAGE_HEADER).shouldBe(Condition.exist);
    }
}
