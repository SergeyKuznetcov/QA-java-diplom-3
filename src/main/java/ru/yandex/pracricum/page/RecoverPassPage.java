package ru.yandex.pracricum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RecoverPassPage {
    private static final By LOGIN_LINK = byText("Войти");

    @Step("Click login lick")
    public AuthPage clickLoinLink() {
        $(LOGIN_LINK).click();
        return new AuthPage();
    }
}
