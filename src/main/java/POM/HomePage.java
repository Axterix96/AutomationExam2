package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.List;

public class HomePage extends BasePage {

    By viewCartBtn = By.xpath("//a[@class='added_to_cart wc-forward']");

    By promotionsLink = By.xpath("//ul[@class='nav-menu']//a[text()='Promotions']");

    By accountLink = By.xpath("//ul[@class='nav-menu']//a[text()='My account']");

    private static WebElement prod(String productName) {
        return driver.findElement(By.xpath("//h2[text()='" + productName + "']/../..//a[text()='Add to cart']"));
    }
//button product_type_simple add_to_cart_button ajax_add_to_cart loading
    protected static By viewCartProd(String productName){
        return By.xpath("//h2[contains(text(),'"+productName+"')]/../..//a[@class='added_to_cart wc-forward']");
    }
    protected static By viewCartLoading(String productName){
        return By.xpath("//h2[contains(text(),'"+productName+"')]/../..//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart loading']");
    }
    public void addProduct(String productName)  {
                prod(productName).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLoading(productName)));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(viewCartLoading(productName)));
                wait.until(ExpectedConditions.presenceOfElementLocated(viewCartProd(productName)));
            }

    public void clickCartBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartBtn));
        driver.findElement(viewCartBtn).click();
    }


    public void goToPromotions() {
        driver.findElement(promotionsLink).click();
    }
    public void goToAccount()
    {
        driver.findElement(accountLink).click();
    }
}
