package Tests;

import POM.HomePage;
import POM.PomManager;
import org.junit.Test;

public class TestCase extends BaseTest{

PomManager pomManager = new PomManager();

@Test
        public void test1()
{
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.addProduct("Proton Rocket");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.increaseProduct("Falcon 9",2);
}

}
