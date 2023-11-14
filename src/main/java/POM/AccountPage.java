package POM;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage{

By ordersLink = By.xpath("//a[text()='Orders']");

    protected static By getOrderId(String orderId)
    {
        return By.xpath("//a[contains(text(),'"+orderId+"')]");
    }
    protected static By getAccountName(String accountName)
    {
        return By.xpath("//strong[contains(text(),'"+accountName+"')][1]");
    }
public void validateAccount(String name)
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(getAccountName(name)));
    Assert.assertEquals("Ya se creo la cuenta", name,driver.findElement(getAccountName(name)).getText());
}



public void checkOrderId(String orderId)
{
    driver.findElement(ordersLink).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(getOrderId(orderId)));
    String orderIdString =driver.findElement(getOrderId(orderId)).getText();
    String orderIdStringReplaced = orderIdString.replace("#","");

    Assert.assertEquals("Se encontro la orden id",orderId,orderIdStringReplaced);

}

}
