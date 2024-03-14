package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    By logoLink = By.xpath("//header/nav/div");
    By constructorLink = By.xpath("//nav//li[1]/a/p");
}
