package ru.yandex.pracricum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private static final By CONSTRUCTOR_BUTTON = byText("Конструктор");
    private static final By PERSONAL_ACCOUNT_BUTTON = byText("Личный Кабинет");
    private static final By LOGO = byClassName("AppHeader_header__logo__2D0X2");

    @Step("Click logo")
    public MainPage clickLogo() {
        $(LOGO).click();
        return new MainPage();
    }

    @Step("Click constructor button")
    public MainPage clickConstructorButton() {
        $(CONSTRUCTOR_BUTTON).click();
        return new MainPage();
    }

    @Step("Click personal account button without authorisation")
    public AuthPage clickPersonalAccountButtonNotAuth() {
        $(PERSONAL_ACCOUNT_BUTTON).click();
        return new AuthPage();
    }

    @Step("Click personal account button with authorisation")
    public PersonalAccountPage clickPersonalAccountButton() {
        $(PERSONAL_ACCOUNT_BUTTON).click();
        return new PersonalAccountPage();
    }
}
