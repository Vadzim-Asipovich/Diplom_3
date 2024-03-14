package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pageObjectModel.ForgotPasswordPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import pageObjectModel.RegistrationPage;
import stellarburgers.*;
import utility.SampleUserData;
import utility.Steps;

public class LoginTest extends BaseTest{
    @Before
    public void startUp() {
        Steps.registerSampleUserViaAPI();
    }
    @After
    public void tearDown() {
        Steps.deleteSampleUserViaAPI();
        driver.quit();
    }
    @Test
    @DisplayName("Login with correct credentials")
    public void loginSuccessfulHomePageLoginButton() {
        driver.get(URL.HomePage);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickLoginButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(SampleUserData.email, SampleUserData.password);
        objLoginPage.waitUrlUpdate();
        Assert.assertEquals(URL.HomePage + "/",driver.getCurrentUrl());
        Assert.assertTrue(Steps.isSampleUserLoggedIn(driver, URL.HomePage));
    }
    @Test
    @DisplayName("Login with correct credentials")
    public void loginSuccessfulHomePagePersonalCabinet() {
        driver.get(URL.HomePage);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickProfileLink();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(SampleUserData.email, SampleUserData.password);
        objLoginPage.waitUrlUpdate();
        Assert.assertEquals(URL.HomePage + "/",driver.getCurrentUrl());
        Assert.assertTrue(Steps.isSampleUserLoggedIn(driver, URL.HomePage));
    }
    @Test
    @DisplayName("Login with correct credentials")
    public void loginSuccessfulRegistrationPage() {
        driver.get(URL.RegistrationPage);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.clickLoginLink();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(SampleUserData.email, SampleUserData.password);
        objLoginPage.waitUrlUpdate();
        Assert.assertEquals(URL.HomePage + "/",driver.getCurrentUrl());
        Assert.assertTrue(Steps.isSampleUserLoggedIn(driver, URL.HomePage));
    }
    @Test
    @DisplayName("Login with correct credentials")
    public void loginSuccessfulForgotPasswordPage() {
        driver.get(URL.ForgotPasswordPage);
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
        objForgotPasswordPage.clickLoginLink();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(SampleUserData.email, SampleUserData.password);
        objLoginPage.waitUrlUpdate();
        Assert.assertEquals(URL.HomePage + "/",driver.getCurrentUrl());
        Assert.assertTrue(Steps.isSampleUserLoggedIn(driver, URL.HomePage));
    }
}
