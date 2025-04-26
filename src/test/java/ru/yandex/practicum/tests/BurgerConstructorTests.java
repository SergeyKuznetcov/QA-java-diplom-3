package ru.yandex.practicum.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.ClassRule;
import org.junit.Test;
import ru.yandex.pracricum.EnvConfig;
import ru.yandex.pracricum.page.MainPage;
import rules.DriverRule;

@DisplayName("Burger constructor tests")
public class BurgerConstructorTests {
    @ClassRule
    public static DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Check bun selector")
    @Description("Check bun selector in burger constructor")
    public void checkBunSelector() {
        Selenide.open(EnvConfig.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage();

        //По умолчанию выбраны булки, поэтому нужно выбрать что то другое, чтобы кнопка стала кликабельна
        mainPage.selectSouses();

        mainPage.selectBuns();
        mainPage.checkBunsSelector();
    }

    @Test
    @DisplayName("Check souse selector")
    @Description("Check souse selector in burger constructor")
    public void checkSouseSelector() {
        Selenide.open(EnvConfig.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage();

        mainPage.selectSouses();
        mainPage.checkSousesSelector();
    }

    @Test
    @DisplayName("Check filling selector")
    @Description("Check filling selector in burger constructor")
    public void checkFillingSelector() {
        Selenide.open(EnvConfig.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage();

        mainPage.selectFillings();
        mainPage.checkFillingSelector();
    }
}
