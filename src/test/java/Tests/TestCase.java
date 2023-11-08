package Tests;

import POM.HomePage;
import POM.PomManager;
import org.junit.Test;

public class TestCase extends BaseTest{

PomManager pomManager = new PomManager();

@Test
        public void purchaseSpaceRocket()  {
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.addProduct("Proton Rocket");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.increaseProduct("Falcon 9",4);
    pomManager.cartPage.buyProductsWithoutCoupon();
    pomManager.checkoutPage.fillCheckoutData("Nicolas", "Sogbi","mexico","Paseos de Caucel 2", "merida","yucatan","97314","9999019879","xnicolaz96@gmail.com");



}
@Test
public void purchaseSpaceRocketDiscountCode()
{
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.addProduct("Proton Rocket");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.increaseProduct("Falcon 9",4);
    pomManager.cartPage.buyProductsWithoutCoupon();
    pomManager.checkoutPage.fillCheckoutData("Nicolas", "Sogbi","mexico","Paseos de Caucel 2", "merida","yucatan","97314","9999019879","xnicolaz96@gmail.com");

}
public void addNewitemsBeforePurchase()
{

}

}
