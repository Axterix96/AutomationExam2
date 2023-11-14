package POM;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartPage extends BasePage {

//a[contains(text(),'Falcon 9')]//ancestor::tr//div[@class='quantity']//input
    By loadingIconProducts = By.xpath("//div[@class='cart_totals calculated_shipping processing']//div[@class='blockUI blockOverlay']");

    By loadingIconSubtotal = By.xpath("//form[@class='woocommerce-cart-form processing']//div[@class='blockUI blockOverlay']");

    By cartMsg = By.xpath("//div[@class='woocommerce-message']");
    By checkoutBtn = By.xpath("//a[@class='checkout-button button alt wc-forward']");

    By couponInput = By.id("coupon_code");

    By couponBtn = By.xpath("//button[@name='apply_coupon']");

    By couponMsg = By.xpath("//div[@class='woocommerce-message']");

    private static WebElement findRocket(String productName)
    {
        return driver.findElement(By.xpath("//a[text()='" + productName + "']/../..//input[@class='input-text qty text']"));
    }

    public void increaseProduct(String productName, int numberOfProducts) {
        findRocket(productName).clear();
        findRocket(productName).sendKeys(String.valueOf(numberOfProducts) + Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIconProducts));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartMsg));
        String cartMessage = driver.findElement(cartMsg).getText();
        Assert.assertEquals("Cart wasn't updated", cartMessage, "Cart updated.");
    }

    public void buyProductsWithoutCoupon() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        driver.findElement(checkoutBtn).click();
    }
    public void buyProductsWithCoupon(String couponName) {
        driver.findElement(couponInput).sendKeys(couponName);
        driver.findElement(couponBtn).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIconProducts));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingIconSubtotal));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIconSubtotal));
        Assert.assertEquals("Coupon wasn't applied",
                "Coupon code applied successfully.",driver.findElement(couponMsg).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        driver.findElement(checkoutBtn).click();
    }

}
