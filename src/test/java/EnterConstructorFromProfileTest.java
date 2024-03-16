import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pageObjectModel.HomePage;
import pageObjectModel.ProfilePage;
import stellarburgers.*;
import utility.Steps;

public class EnterConstructorFromProfileTest extends BaseTest{
    HomePage objHomePage;
    ProfilePage objProfilePage;
    @Before
    public void startUp() {
        Steps.registerSampleUserViaAPI();
        Steps.loginSampleUserViaLocalStorage(driver);
        objHomePage = new HomePage(driver);
        objProfilePage = new ProfilePage(driver);
        driver.get(URL.HomePage);
        objHomePage.clickProfileLink();
    }
    @After
    public void tearDown() {
        Steps.deleteSampleUserViaAPI();
        driver.quit();
    }
    @Test
    @DisplayName("Enter constructor from profile via logo")
    public void enterConstructorFromProfileViaLogoTest() {
        objProfilePage.clickLogoLink();
        objProfilePage.waitUrlUpdate();
        Assert.assertEquals(URL.HomePage + "/", driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Enter constructor from profile via constructor link")
    public void enterConstructorFromProfileViaConstructorLinkTest() {
        objProfilePage.clickConstructorLink();
        objProfilePage.waitUrlUpdate();
        Assert.assertEquals(URL.HomePage + "/", driver.getCurrentUrl());
    }
}
