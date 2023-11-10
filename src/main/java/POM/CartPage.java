package POM;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

//a[contains(text(),'Falcon 9')]//ancestor::tr//div[@class='quantity']//input
    By loadingIconProducts = By.xpath("//div[@class='cart_totals calculated_shipping processing']//div[@class='blockUI blockOverlay']");

    By loadingIconSubtotal = By.xpath("//form[@class='woocommerce-cart-form processing']//div[@class='blockUI blockOverlay']");

    By cartMsg = By.xpath("//div[@class='woocommerce-message']");
    By checkoutBtn = By.xpath("//a[@class='checkout-button button alt wc-forward']");

    By couponInput = By.id("coupon_code");

    By couponBtn = By.xpath("//button[@name='apply_coupon']");

    By couponMsg = By.xpath("//div[@class='woocommerce-message']");

    By thPresence = By.xpath("//*[name()='th']");
    public void increaseProduct(String productName, int numberOfProducts) {
        WebElement rocketFound = driver.findElement(By.xpath("//a[text()='" + productName + "']/../..//input[@class='input-text qty text']"));
        rocketFound.clear();
        rocketFound.sendKeys(String.valueOf(numberOfProducts) + Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIconProducts));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartMsg));
        String cartMessage = driver.findElement(cartMsg).getText();
        Assert.assertEquals("Si se agrego el cambio de producto", cartMessage, "Cart updated.");
    }

    public void buyProductsWithoutCoupon() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        driver.findElement(checkoutBtn).click();
    }
    public void buyProductsWithCoupon(String couponName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        driver.findElement(couponInput).sendKeys(couponName);
        driver.findElement(couponBtn).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIconProducts));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingIconSubtotal));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIconSubtotal));
        Assert.assertEquals("Se ha aplicado el cupon",
                "Coupon code applied successfully.",driver.findElement(couponMsg).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        driver.findElement(checkoutBtn).click();
    }

}
