package POM;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class CartPage extends BasePage{

By table = By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']//td");

By loadingIcon = By.xpath("//div[@class='blockUI blockOverlay']");

By cartMsg = By.xpath("//div[@class='woocommerce-message']");
By checkoutBtn = By.xpath("//a[@class='checkout-button button alt wc-forward']");

public void increaseProduct(String productName, int numberOfProducts) throws InterruptedException {
    List<WebElement> rockets = driver.findElements(table);

    for (WebElement rocket : rockets) {
        System.out.println(rocket.getText());
        if (rocket.getText().equals(productName)) {
            WebElement rocketFound = rocket.findElement(By.xpath("//a[text()='" + productName + "']//..//..//input[@class='input-text qty text']"));
            rocketFound.clear();
            rocketFound.sendKeys(String.valueOf(numberOfProducts)+Keys.ENTER);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartMsg));
            String cartMessage = driver.findElement(cartMsg).getText();

            Assert.assertEquals("Si se agrego el cambio de producto",cartMessage,"Cart updated.");
        }
    }
}

public void buyProductsWithoutCoupon()
{
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,350)", "");
    driver.findElement(checkoutBtn).click();
}


}
