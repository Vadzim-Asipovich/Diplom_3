package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private By nameField = By.xpath("//form/fieldset[1]//input");
    private By emailField = By.xpath("//form/fieldset[2]//input");
    private By passwordField = By.xpath("//form/fieldset[3]//input");
    private By registerButton = By.xpath("//form//button");
    private By passwordFieldError = By.xpath("//form/fieldset[3]//p");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void register(String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegisterButton();
    }
    public void waitUrlUpdate(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("login"));
    }

    public String getPasswordFieldError() {
        return driver.findElement(passwordFieldError).getText();
    }
}
