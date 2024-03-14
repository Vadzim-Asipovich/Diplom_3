package tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjectModel.HomePage;
import stellarburgers.*;
import utility.Steps;

public class ConstructorTest extends BaseTest{
    HomePage objHomePage;
    @Before
    public void startUp() {
        objHomePage = new HomePage(driver);
        driver.get(URL.HomePage);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void transitionFromDefaultToSauceTab() {
        objHomePage.clickConstructorSauceTab();
        Assert.assertTrue(objHomePage.isSauceTabActive());
    }
    @Test
    public void transitionFromDefaultToFillingsTab() {
        objHomePage.clickConstructorFillingsTab();
        Assert.assertTrue(objHomePage.isFillingsTabActive());
    }
    @Test
    public void transitionFromSauceToBunsTab() {
        objHomePage.clickConstructorSauceTab();
        Assert.assertTrue(objHomePage.isSauceTabActive());
        objHomePage.clickConstructorBunsTab();
        Assert.assertTrue(objHomePage.isBunsTabActive());
    }
}
