package Tests;

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
    pomManager.cartPage.editProduct("Falcon 9",4);
    pomManager.cartPage.checkCartUpdated();
    pomManager.cartPage.buyProductsWithoutCoupon();
    pomManager.checkoutPage.fillCheckoutDataWithoutAccount("Nicolas", "Sogbi","mexico","Paseos de Caucel 2", "merida","yucatan","97314","9999019879","xnicolaz96@gmail.com");



}
@Test
public void purchaseSpaceRocketDiscountCode() {
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.addProduct("Proton Rocket");
    pomManager.homePage.goToPromotions();
    String coupon = pomManager.promotionsPage.getCouponAndClickCart();
    pomManager.cartPage.editProduct("Falcon 9",4);
    pomManager.cartPage.checkCartUpdated();
    pomManager.cartPage.buyProductsWithCoupon(coupon);
    pomManager.cartPage.checkCouponWasApplied();
    pomManager.cartPage.goToCheckoutPage();
    pomManager.checkoutPage.fillCheckoutDataWithoutAccount("Nicolas", "Sogbi","mexico","Paseos de Caucel 2", "merida","yucatan","97314","9999019879","xnicolaz96@gmail.com");

}
    @Test
    public void addNewItemsBeforePurchase()
    {
        pomManager.homePage.addProduct("Falcon 9");
        pomManager.homePage.addProduct("Proton Rocket");
        pomManager.homePage.goToPromotions();
        String coupon = pomManager.promotionsPage.getCouponAndClickCart();
        pomManager.cartPage.editProduct("Falcon 9",4);
        pomManager.cartPage.checkCartUpdated();
    }
@Test
public void createAccountAfterFirstPurchase()
{
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.editProduct("Falcon 9",4);
    pomManager.cartPage.buyProductsWithoutCoupon();
    List<String> objects = pomManager.checkoutPage.fillCheckoutDataCreateAccount("Nicolas", "Sogbi","mexico","Paseos de Caucel 2", "merida","yucatan","97314","9999019879");
    pomManager.homePage.goToAccount();
    pomManager.accountPage.validateAccountAfterFirstPurchase(objects.get(0));

}
@Test
    public void checkListOfOrders()
{
    pomManager.homePage.goToAccount();
    pomManager.accountPage.loginAccount();
    pomManager.accountPage.validateLogin();
    pomManager.accountPage.goToListOrders();
    pomManager.accountPage.validateOrdersList();
}
@Test
    public void checkLastOrderCreated()
{
    pomManager.homePage.goToAccount();
    pomManager.accountPage.loginAccount();
    pomManager.accountPage.validateLogin();
    pomManager.accountPage.goToHomePage();
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.editProduct("Falcon 9",4);
    pomManager.cartPage.buyProductsWithoutCoupon();
    String orderId = pomManager.checkoutPage.fillCheckoutDataWithoutAccountReturningOrderId();
    pomManager.homePage.goToAccount();
    pomManager.accountPage.checkOrderId(orderId);
}

}
