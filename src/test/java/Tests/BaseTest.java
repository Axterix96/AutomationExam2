package Tests;

import POM.BasePage;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

public class BaseTest {


    BaseDriver base = new BaseDriver();
    public BasePage page;


    @Before
    public void Setup() throws IOException {
        base.initializeDriver();
        base.driver.manage().window().maximize();
        base.driver.get("https://demos.bellatrix.solutions/");
        page = new BasePage(base.driver,base.wait);


    }

    @After
    public void cleanup()
    {
        base.driver.quit();
    }
}
