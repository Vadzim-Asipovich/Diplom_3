package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stellarburgers.*;

public class Steps {
    @Step("Setup Chrome driver")
    public static WebDriver setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }
    @Step("Register sample user via API")
    public static void registerSampleUserViaAPI() {
        User user = new User(SampleUserData.email, SampleUserData.password, SampleUserData.name);
        RegisterAPI.registerUser(user);
    }
    @Step("Delete sample user via API")
    public static void deleteSampleUserViaAPI() {
        UserAPI.deleteUser(getSampleUserAccessToken());
    }
    @Step("Login sample user via API")
    public static void loginSampleUserViaLocalStorage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String scriptAccToken = "window.localStorage.setItem(\"accessToken\", \"" + getSampleUserAccessToken() + "\");";
        String scriptRefrToken = "window.localStorage.setItem(\"refreshToken\", \"" + getSampleUserRefreshToken() + "\");";
        driver.get(URL.HomePage);
        js.executeScript(scriptAccToken);
        js.executeScript(scriptRefrToken);
    }
    @Step("Get access token for sample user")
    public static String getSampleUserAccessToken() {
        User user = new User(SampleUserData.email, SampleUserData.password);
        return LoginAPI.loginUser(user).then().extract().path("accessToken");
    }
    @Step("Get refresh token for sample user")
    public static String getSampleUserRefreshToken() {
        User user = new User(SampleUserData.email, SampleUserData.password);
        return LoginAPI.loginUser(user).then().extract().path("refreshToken");
    }
    @Step("Check if sample user is registered")
    public static boolean isSampleUserRegistered() {
        User user = new User(SampleUserData.email, SampleUserData.password);
        return LoginAPI.loginUser(user).then().extract().statusCode() == 200;
    }
    @Step("Check via API if sample user is logged in")
    public static boolean isSampleUserLoggedIn(WebDriver driver, String currentUrl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return window.localStorage.getItem(\"accessToken\");";
        driver.get(currentUrl);
        String accessToken = (String) js.executeScript(script);
        return accessToken != null;
    }
}
