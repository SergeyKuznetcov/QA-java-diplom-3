package ru.yandex.pracricum.page;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.yandex.pracricum.page.dto.User;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private static final By NAME_FIELD = byXpath("//label[text()='Имя']/parent::div/input");
    private static final By EMAIL_FIELD = byXpath("//label[text()='Email']/parent::div/input");
    private static final By PASSWORD_FIELD = byXpath("//label[text()='Пароль']/parent::div/input");
    private static final By REGISTRATION_BUTTON = byText("Зарегистрироваться");
    private static final By PASSWORD_ERROR_MESSAGE = byText("Некорректный пароль");
    private static final By LOGIN_LINK = byText("Войти");

    @Step("Click logIn link")
    public AuthPage clickLoginLink() {
        $(LOGIN_LINK).click();
        return new AuthPage();
    }

    @Step("Check password error message")
    public void checkPasswordErrorMessage() {
        $(PASSWORD_ERROR_MESSAGE).shouldBe(Condition.visible);
    }

    public AuthPage registerUser(User user) {
        fillNameField(user.getName());
        fillEmailField(user.getEmail());
        fillPasswordField(user.getPassword());
        return clickRegistrationButton();
    }

    @Step("Fill name field")
    private void fillNameField(String value) {
        $(NAME_FIELD).setValue(value);
    }

    @Step("Fill email field")
    private void fillEmailField(String value) {
        $(EMAIL_FIELD).setValue(value);
    }

    @Step("Fill password field")
    private void fillPasswordField(String value) {
        $(PASSWORD_FIELD).setValue(value);
    }

    @Step("Click registration button")
    private AuthPage clickRegistrationButton() {
        $(REGISTRATION_BUTTON).click();
        return new AuthPage();
    }
}
