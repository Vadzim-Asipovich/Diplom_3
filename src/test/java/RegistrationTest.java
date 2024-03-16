import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
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
    @DisplayName("Registration successful")
    public void registrationSuccessfulTest() {
        driver.get(URL.RegistrationPage);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.register(SampleUserData.name, SampleUserData.email, SampleUserData.password);
        objRegistrationPage.waitUrlUpdate();
        Assert.assertEquals(URL.LoginPage, driver.getCurrentUrl());
        Assert.assertTrue(Steps.isSampleUserRegistered());
    }
    @Test
    @DisplayName("Registration failed: incorrect password - 5 symbols (6 min)")
    public void registrationFailedIncorrectPasswordLengthTest() {
        driver.get(URL.RegistrationPage);
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.register(SampleUserData.name, SampleUserData.email, SampleUserData.shortPassword);
        Assert.assertEquals(Messages.incorrectPassword, objRegistrationPage.getPasswordFieldError());
        Assert.assertFalse(Steps.isSampleUserRegistered());
    }
}
