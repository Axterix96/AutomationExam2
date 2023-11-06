package Tests;

import POM.BasePage;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

public class BaseTest {


    BaseDriver base = new BaseDriver();



    @Before
    public void Setup() throws IOException {
        base.initializeDriver();
        base.driver.manage().window().maximize();
        base.driver.get("https://demos.bellatrix.solutions/");
        BasePage.wait = base.wait;
        BasePage.driver = base.driver;

    }

    @After
    public void cleanup()
    {
        base.driver.quit();
    }
}
