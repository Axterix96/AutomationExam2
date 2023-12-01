package Tests;

import POM.BasePage;

import java.io.IOException;

import org.testng.annotations.*;

public class BaseTest {


    BaseDriver base = new BaseDriver();



    @BeforeMethod
    public void Setup() throws IOException {
        base.initializeDriver();
        base.driver.manage().window().maximize();
        base.driver.get("https://demos.bellatrix.solutions/");
        BasePage.wait = base.wait;
        BasePage.driver = base.driver;

    }

    @AfterMethod
    public void cleanup()
    {
        base.driver.quit();
    }
}
