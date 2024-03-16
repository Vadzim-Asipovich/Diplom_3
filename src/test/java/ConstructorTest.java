import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pageObjectModel.HomePage;
import stellarburgers.*;

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
    @DisplayName("Transition from default to buns tab")
    public void transitionFromDefaultToSauceTabTest() {
        objHomePage.clickConstructorSauceTab();
        Assert.assertTrue(objHomePage.isSauceTabActive());
    }
    @Test
    @DisplayName("Transition from default to fillings tab")
    public void transitionFromDefaultToFillingsTabTest() {
        objHomePage.clickConstructorFillingsTab();
        Assert.assertTrue(objHomePage.isFillingsTabActive());
    }
    @Test
    @DisplayName("Transition from default to buns tab")
    public void transitionFromSauceToBunsTabTest() {
        objHomePage.clickConstructorSauceTab();
        Assert.assertTrue(objHomePage.isSauceTabActive());
        objHomePage.clickConstructorBunsTab();
        Assert.assertTrue(objHomePage.isBunsTabActive());
    }
}
