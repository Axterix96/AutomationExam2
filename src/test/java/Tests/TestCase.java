package Tests;

import POM.HomePage;
import POM.PomManager;
import org.junit.Test;

import java.util.List;

public class TestCase extends BaseTest{

PomManager pomManager = new PomManager();

@Test
        public void purchaseSpaceRocket()  {
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.addProduct("Proton Rocket");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.increaseProduct("Falcon 9",4);
    pomManager.cartPage.buyProductsWithoutCoupon();
    pomManager.checkoutPage.fillCheckoutDataWithoutAccount("Nicolas", "Sogbi","mexico","Paseos de Caucel 2", "merida","yucatan","97314","9999019879","xnicolaz96@gmail.com");



}
@Test
public void purchaseSpaceRocketDiscountCode() {
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.addProduct("Proton Rocket");
    pomManager.homePage.goToPromotions();
    String coupon = pomManager.promotionsPage.getCouponAndClickCart();
    pomManager.cartPage.increaseProduct("Falcon 9",4);
    pomManager.cartPage.buyProductsWithCoupon(coupon);
    pomManager.checkoutPage.fillCheckoutDataWithoutAccount("Nicolas", "Sogbi","mexico","Paseos de Caucel 2", "merida","yucatan","97314","9999019879","xnicolaz96@gmail.com");

}
@Test
public void createAccountFirstPurchase()
{
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.increaseProduct("Falcon 9",4);
    pomManager.cartPage.buyProductsWithoutCoupon();
    List<String> objects = pomManager.checkoutPage.fillCheckoutDataCreateAccount("Nicolas", "Sogbi","mexico","Paseos de Caucel 2", "merida","yucatan","97314","9999019879");
    pomManager.homePage.goToAccount();
    pomManager.accountPage.validateAccount(objects.get(0));
    pomManager.accountPage.checkOrderId(objects.get(1));


}

}
