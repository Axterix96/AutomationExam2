package POM;


import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends BasePage {

By totalOrderBy = By.xpath("//td//span[@class='woocommerce-Price-amount amount']//bdi");




    public void validateOrderDetail(String totalOrder)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalOrderBy));
        Assert.assertEquals("Total not found", totalOrder ,driver.findElement(totalOrderBy).getText());


    }

}