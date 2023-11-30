package Tests;

import POM.BasePage;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class BaseTest {


    BaseDriver base = new BaseDriver();



    @BeforeClass
    public void Setup() throws IOException {
        base.initializeDriver();
        base.driver.manage().window().maximize();
        base.driver.get("https://demos.bellatrix.solutions/");
        BasePage.wait = base.wait;
        BasePage.driver = base.driver;

    }

    @AfterClass
    public void cleanup()
    {
        base.driver.close();
    }
}
