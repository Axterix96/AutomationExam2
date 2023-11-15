package POM;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage{

    private final String username = "xnicolaz96@gmail.com";
    private final String password = "Nicolas*010396";

By ordersLink = By.xpath("//a[text()='Orders']");

By usernameInput = By.id("username");

By passwordInput = By.id("password");

By loginBtn = By.name("login");

By myAccountTitle = By.xpath("//h1[text()='My account']");

By ordersTitle = By.xpath("//h1[text()='Orders']");

By homeNav = By.xpath("//ul[@class='nav-menu']//a[text()='Home']");

    protected static By getOrderId(String orderId)
    {
        return By.xpath("//a[contains(text(),'"+orderId+"')]");
    }
    protected static By getAccountName(String accountName)
    {
        return By.xpath("//strong[contains(text(),'"+accountName+"')][1]");
    }
public void validateAccountAfterFirstPurchase(String name)
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(getAccountName(name)));
    Assert.assertEquals("Account created", name,driver.findElement(getAccountName(name)).getText());
}

public void checkOrderId(String orderId)
{
    driver.findElement(ordersLink).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(getOrderId(orderId)));
    String orderIdString =driver.findElement(getOrderId(orderId)).getText();
    String orderIdStringReplaced = orderIdString.replace("#","");

    Assert.assertEquals("Order ID wassn't found",orderId,orderIdStringReplaced);

}

public void loginAccount()
{
   driver.findElement(usernameInput).sendKeys(this.username);
   driver.findElement(passwordInput).sendKeys(password);
   driver.findElement(loginBtn).click();
}

public void validateLogin()
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountTitle));
    Assert.assertEquals("Account didn't login",driver.findElement(myAccountTitle).getText(),"My account");
}
public void goToListOrders()
{
    driver.findElement(ordersLink).click();
}

public void validateOrdersList()
{
    Assert.assertEquals("Couldn't access to Orders list","Orders",driver.findElement(ordersTitle).getText());
}

public void goToHomePage()
{
    driver.findElement(homeNav).click();
}

}
