package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjectModel.RegistrationPage;
import stellarburgers.*;
import utility.SampleUserData;
import utility.Steps;

public class RegistrationTest extends BaseTest{
    @After
    public void tearDown() {
        if(Steps.isSampleUserRegistered()){
            Steps.deleteSampleUserViaAPI();
        }
        driver.quit();
    }
    @Test
    public void registrationSuccessful() {
        driver.get(URL.RegistrationPage);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.register(SampleUserData.name, SampleUserData.email, SampleUserData.password);
        objRegistrationPage.waitUrlUpdate();
        Assert.assertEquals(URL.LoginPage, driver.getCurrentUrl());
        Assert.assertTrue(Steps.isSampleUserRegistered());
    }
    @Test
    public void registrationFailedIncorrectPasswordLength() {
        driver.get(URL.RegistrationPage);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.register(SampleUserData.name, SampleUserData.email, SampleUserData.shortPassword);
        Assert.assertEquals(Messages.incorrectPassword, objRegistrationPage.getPasswordFieldError());
        Assert.assertFalse(Steps.isSampleUserRegistered());
    }
}
