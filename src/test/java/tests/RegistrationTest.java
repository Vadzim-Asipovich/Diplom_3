package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjectModel.RegistrationPage;
import stellarburgers.*;

public class RegistrationTest {
    private WebDriver driver;
    private String accessToken;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }
    @After
    public void tearDown() {
        User user = new User(SampleUserData.email, SampleUserData.password);
        accessToken = LoginAPI.loginUser(user).then().extract().path("accessToken");
        UserAPI.deleteUser(accessToken);
        driver.quit();
    }
    @Test
    public void registrationSuccessful() {
        driver.get(URL.RegistrationPage);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.register(SampleUserData.name, SampleUserData.email, SampleUserData.password);
        objRegistrationPage.waitUrlUpdate();
        Assert.assertEquals(driver.getCurrentUrl(),URL.LoginPage);
    }
    @Test
    public void registrationFailedIncorrectPasswordLength() {
        driver.get(URL.RegistrationPage);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.register(SampleUserData.name, SampleUserData.email, SampleUserData.shortPassword);
        Assert.assertEquals(Messages.incorrectPassword, objRegistrationPage.getPasswordFieldError());
    }
}
