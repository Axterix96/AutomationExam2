package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

By table = By.xpath("//tbody//tr[@class='woocommerce-cart-form__cart-item cart_item']//td");

By increaseProductInput = By.xpath("//tbody//tr[@class='woocommerce-cart-form__cart-item cart_item']//input[@class='input-text qty text']//..//..//..//a[text()='Proton Rocket']");


public void increaseProduct(String productName, int numberOfProducts)
{
    List<WebElement> rockets = driver.findElements(table);

    for (WebElement rocket : rockets) {
        if (rocket.getText().equals(productName)) {
            WebElement rocketFound = rocket.findElement(By.xpath("//a[text()='" + productName + "']//..//..//input[@class='input-text qty text']"));
            for (int j = 0; j <= numberOfProducts; j++) {
                rocketFound.sendKeys(Keys.UP);
            }
        }
    }
}


}
