package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarburgers.URL;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By emailField = By.xpath("//form/fieldset[1]//input");
    private final By passwordField = By.xpath("//form/fieldset[2]//input");
    private final By enterButton = By.xpath("//form//button");
    private void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    private void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    private void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    public void login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        clickEnterButton();
    }
    public void waitUrlUpdate() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.not(ExpectedConditions.urlToBe(URL.LoginPage)));
    }
}
