package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    public static final String PROPERTIES = "src/main/resources/config.properties";
    private static String browser;

    @Before
    public void getWebDriver() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(PROPERTIES);
            properties.load(fileInputStream);
            browser = properties.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectBrowser();
    }

    public void selectBrowser() {
        switch (browser) {
            case "chrome":
                setUpChrome();
                break;
            case "yandex":
                setUpYandex();
                break;
        }
    }

    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    public void setUpYandex() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
}
