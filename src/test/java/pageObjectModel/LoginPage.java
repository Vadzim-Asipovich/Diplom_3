package pageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarburgers.URL;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By emailField = By.xpath("//form/fieldset[1]//input");
    private final By passwordField = By.xpath("//form/fieldset[2]//input");
    private final By enterButton = By.xpath("//form//button");
    @Step("Fill email")
    private void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Fill password")
    private void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Click enter button")
    private void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    @Step("Login")
    public void login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        clickEnterButton();
    }
    @Step("Wait for URL update")
    public void waitUrlUpdate() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.urlToBe(URL.LoginPage)));
    }
}
