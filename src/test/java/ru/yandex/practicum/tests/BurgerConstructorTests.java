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
    @DisplayName("Check constructor selector")
    @Description("Check ingredient type selector in burger constructor")
    public void checkBurgerConstructorSelector() {
        Selenide.open(EnvConfig.MAIN_PAGE_URL);
        MainPage mainPage = new MainPage();

        mainPage.selectFillings();
        mainPage.checkFillingSelector();

        mainPage.selectBuns();
        mainPage.checkBunsSelector();

        mainPage.selectSouses();
        mainPage.checkSousesSelector();
    }
}
