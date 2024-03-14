package pageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarburgers.URL;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private final By loginButton = By.xpath("//section[2]//button");
    private final By profileLink = By.xpath("//nav/a/p");
    private final By constructorBunsTab = By.xpath("//div[span[contains(text(), \"Булки\")]]");
    private final By constructorSauceTab = By.xpath("//div[span[contains(text(), \"Соусы\")]]");
    private final By constructorFillingsTab = By.xpath("//div[span[contains(text(), \"Начинки\")]]");
    private final By constructorSauceHeader = By.xpath("//h2[contains(text(), \"Соусы\")]");
    private final By constructorBunsHeader = By.xpath("//h2[contains(text(), \"Булки\")]");
    private final By constructorFillingsHeader = By.xpath("//h2[contains(text(), \"Начинки\")]");

    @Step("Click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Click personal cabinet")
    public void clickProfileLink() {
        driver.findElement(profileLink).click();
        waitUrlUpdate();
    }

    @Step("Wait for URL update")
    public void waitUrlUpdate() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.not(ExpectedConditions.urlToBe(URL.HomePage)));
    }
    @Step("Click constructor sauce tab")
    public void clickConstructorSauceTab() {
        driver.findElement(constructorSauceTab).click();
    }
    @Step("Click constructor fillings tab")
    public void clickConstructorFillingsTab() {
        driver.findElement(constructorFillingsTab).click();
    }
    @Step("Click constructor buns tab")
    public void clickConstructorBunsTab() {
        driver.findElement(constructorBunsTab).click();
    }

    @Step("Is sauce tab selected")
    public boolean isSauceTabActive() {
        return driver.findElement(constructorSauceTab).getAttribute("class").contains("tab_tab_type_current__2BEPc")
                && driver.findElement(constructorSauceHeader).isDisplayed();
    }
    @Step("Is fillings tab selected")
    public boolean isFillingsTabActive() {
        return driver.findElement(constructorFillingsTab).getAttribute("class").contains("tab_tab_type_current__2BEPc")
                && driver.findElement(constructorFillingsHeader).isDisplayed();
    }
    @Step("Is buns tab selected")
    public boolean isBunsTabActive() {
        return driver.findElement(constructorBunsTab).getAttribute("class").contains("tab_tab_type_current__2BEPc")
                && driver.findElement(constructorBunsHeader).isDisplayed();
    }
}
