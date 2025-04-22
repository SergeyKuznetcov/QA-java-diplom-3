package ru.yandex.pracricum.page;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PersonalAccountPage {
    private static final By LOGOUT_BUTTON = byText("Выход");
    private static final By PROFILE_HEADER = byText("Профиль");

    @Step("Click logout button")
    public AuthPage clickLogoutButton() {
        $(LOGOUT_BUTTON).click();
        return new AuthPage();
    }

    @Step("Check profile header")
    public void checkProfileHeader() {
        $(PROFILE_HEADER).shouldBe(Condition.exist);
    }
}
