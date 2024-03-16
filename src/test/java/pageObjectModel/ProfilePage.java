package pageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarburgers.URL;

public class ProfilePage extends BasePage{
    private final WebDriver driver;
    private final WebDriverWait wait;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    @Step("Click exit button")
    public void clickExitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
        waitUrlUpdate();
    }
    @Step("Click logo link")
    public void clickLogoLink() {
        driver.findElement(logoLink).click();
    }
    @Step("Click constructor link")
    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }
    @Step("Wait for URL update")
    public void waitUrlUpdate() {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(URL.ProfilePage)));
    }

}
