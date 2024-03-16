package pageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarburgers.URL;

public class RegistrationPage {
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By nameField = By.xpath("//form/fieldset[1]//input");
    private final By emailField = By.xpath("//form/fieldset[2]//input");
    private final By passwordField = By.xpath("//form/fieldset[3]//input");
    private final By registerButton = By.xpath("//form//button");
    private final By passwordFieldError = By.xpath("//form/fieldset[3]//p");
    private final By loginLink = By.xpath("//p/a");
    @Step("Fill name field")
    private void fillName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    @Step("Fill email field")
    private void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Fill password field")
    private void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Click register button")
    private void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Register with credentials provided")
    public void register(String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegisterButton();
    }
    @Step("Wait for URL update")
    public void waitUrlUpdate(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.urlToBe(URL.RegistrationPage)));
    }
    @Step("Get password field error")
    public String getPasswordFieldError() {
        return driver.findElement(passwordFieldError).getText();
    }
    @Step("Click login link")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
