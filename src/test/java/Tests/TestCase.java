package Tests;

import POM.PomManager;
import org.testng.annotations.Test;

import java.util.List;
public class TestCase extends BaseTest{

 PomManager pomManager = new PomManager();

 String firstname = "Nicolas";
 String lastname = "Sogbi";

 String country = "Mexico";

 String address = "Paseos de Caucel 2";

 String city = "merida";

 String state = "Yucatan";

 String zip = "97314";

 String phone = "9999019879";

 String personalEmail = "xnicolaz96@gmail.com";

@Test
        public  void purchaseSpaceRocket()  {
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.addProduct("Proton Rocket");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.editProduct("Falcon 9",4);
    pomManager.cartPage.checkCartUpdated();
    pomManager.cartPage.buyProductsWithoutCoupon();
    pomManager.checkoutPage.fillData(firstname, lastname,country,address, city,state,zip,phone,personalEmail);
    pomManager.checkoutPage.clickPlaceOrderBtn();
    pomManager.checkoutPage.validatePurchaseSuccesful();
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
    pomManager.checkoutPage.fillData(firstname, lastname,country,address, city,state,zip,phone,personalEmail);
    pomManager.checkoutPage.clickPlaceOrderBtn();
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
    pomManager.cartPage.checkCartUpdated();
    pomManager.cartPage.buyProductsWithoutCoupon();
    String email = pomManager.checkoutPage.createRandomEmail();
    pomManager.checkoutPage.fillData(firstname, lastname,country,address, city,state,zip,phone,email);
    pomManager.checkoutPage.createAccount();
    pomManager.checkoutPage.clickPlaceOrderBtn();
    String object = pomManager.checkoutPage.returnFullName(firstname,lastname);
    pomManager.checkoutPage.waitLoadingIcon();
    pomManager.homePage.goToAccount();
    pomManager.accountPage.validateAccountAfterFirstPurchase(object);

}
@Test
    public void checkListOfOrders()
{
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.editProduct("Falcon 9",4);
    pomManager.cartPage.checkCartUpdated();
    pomManager.cartPage.buyProductsWithoutCoupon();
    String email = pomManager.checkoutPage.createRandomEmail();
    pomManager.checkoutPage.fillData(firstname, lastname,country,address, city,state,zip,phone,email);
    pomManager.checkoutPage.createAccount();
    pomManager.checkoutPage.clickPlaceOrderBtn();
    pomManager.checkoutPage.waitLoadingIcon();
    List<String> orderData = pomManager.checkoutPage.returnOrderData();
    pomManager.homePage.goToAccount();
    pomManager.accountPage.goToListOrders();
    pomManager.accountPage.validateOrderIdDate(orderData.get(0),orderData.get(1));
    pomManager.accountPage.clickOrderDetails(orderData.get(0));
    pomManager.orderPage.validateOrderDetail(orderData.get(2));


}
@Test
    public void checkLastOrderCreated()
{
    pomManager.homePage.addProduct("Falcon 9");
    pomManager.homePage.clickCartBtn();
    pomManager.cartPage.editProduct("Falcon 9",4);
    pomManager.cartPage.checkCartUpdated();
    pomManager.cartPage.buyProductsWithoutCoupon();
    String email = pomManager.checkoutPage.createRandomEmail();
    pomManager.checkoutPage.fillData(firstname, lastname,country,address, city,state,zip,phone,email);
    pomManager.checkoutPage.createAccount();
    pomManager.checkoutPage.clickPlaceOrderBtn();
    pomManager.checkoutPage.waitLoadingIcon();
    String orderId = pomManager.checkoutPage.returnOrderId();
    pomManager.homePage.goToAccount();
    pomManager.accountPage.goToListOrders();
    pomManager.accountPage.checkOrderId(orderId);
}

}
