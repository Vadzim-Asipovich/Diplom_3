package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObjectModel.HomePage;
import pageObjectModel.ProfilePage;
import stellarburgers.URL;
import utility.Steps;

public class SignOutTest extends BaseTest{
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
    public void signOutTest() {
        objProfilePage.clickExitButton();
        Assert.assertEquals(URL.LoginPage, driver.getCurrentUrl());
        Assert.assertFalse(Steps.isSampleUserLoggedIn(driver, URL.LoginPage));
    }
}
