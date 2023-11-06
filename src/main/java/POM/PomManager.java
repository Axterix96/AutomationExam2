package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PomManager extends BasePage{
    public PomManager(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);


    }
    HomePage homePage = new HomePage(driver,wait);



}
