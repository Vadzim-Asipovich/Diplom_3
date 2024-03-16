import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pageObjectModel.HomePage;
import stellarburgers.*;
import utility.Steps;

public class EnterProfileTest extends BaseTest{
    HomePage objHomePage;
    @Before
    public void startUp() {
        Steps.registerSampleUserViaAPI();
        Steps.loginSampleUserViaLocalStorage(driver);
        driver.get(URL.HomePage);
        objHomePage = new HomePage(driver);
    }
    @After
    public void tearDown() {
        Steps.deleteSampleUserViaAPI();
        driver.quit();
    }
    @Test
    @DisplayName("Enter profile")
    public void enterProfileTest() {
        objHomePage.clickProfileLink();
        objHomePage.waitUrlUpdate(URL.ProfilePage);
        Assert.assertEquals(URL.ProfilePage, driver.getCurrentUrl());
    }
}
