package pageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private By loginLink = By.xpath("//p/a");
    @Step("Click login link")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
