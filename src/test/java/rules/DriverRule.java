package rules;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;
import org.junit.rules.ExternalResource;

@Getter
public class DriverRule extends ExternalResource {

    @Override
    protected void before() {
        initDriver();
    }

    @Override
    protected void after() {
        WebDriverRunner.closeWebDriver();
    }

    public void initDriver() {
        if ("firefox".equalsIgnoreCase(System.getProperty("browser"))) {
            Configuration.browser = "firefox";
        } else {
            Configuration.browser = "chrome";
        }
    }
}
