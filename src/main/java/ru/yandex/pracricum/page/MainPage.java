package ru.yandex.pracricum.page;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private static final By LOGIN_BUTTON = byText("Войти в аккаунт");
    private static final By BURGER_CONSTRUCTOR_HEADER = byText("Соберите бургер");

    private static final By BUN_SELECT_BUTTON = byText("Булки");
    private static final By SOUSE_SELECT_BUTTON = byText("Соусы");
    private static final By FILLING_SELECT_BUTTON = byText("Начинки");

    private static final String CURRENT_SELECTOR_CLASS = "tab_tab_type_current__2BEPc";

    @Step("Check that burger constructor header exists")
    public void checkBurgerConstructorHeader() {
        $(BURGER_CONSTRUCTOR_HEADER).shouldBe(Condition.exist);
    }

    @Step("Click auth button")
    public AuthPage clickAuthButton() {
        $(LOGIN_BUTTON).click();
        return new AuthPage();
    }

    @Step("Click buns selector")
    public void selectBuns() {
        $(BUN_SELECT_BUTTON).click();
    }

    @Step("Click souses selector")
    public void selectSouses() {
        $(SOUSE_SELECT_BUTTON).click();
    }

    @Step("Click fillings selector")
    public void selectFillings() {
        $(FILLING_SELECT_BUTTON).click();
    }

    @Step("Check buns selector is active")
    public void checkBunsSelector() {
        $(BUN_SELECT_BUTTON).parent().shouldHave(Condition.cssClass(CURRENT_SELECTOR_CLASS));
    }

    @Step("Check souses selector is active")
    public void checkSousesSelector() {
        $(SOUSE_SELECT_BUTTON).parent().shouldHave(Condition.cssClass(CURRENT_SELECTOR_CLASS));
    }

    @Step("Check filling selector is active")
    public void checkFillingSelector() {
        $(FILLING_SELECT_BUTTON).parent().shouldHave(Condition.cssClass(CURRENT_SELECTOR_CLASS));
    }
}
