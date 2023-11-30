package POM;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {

    private final String username = "xnicolaz96@gmail.com";
    private final String password = "Nicolas*010396";

    By ordersLink = By.xpath("//a[text()='Orders']");


    protected static By getOrderId(String orderId) {
        return By.xpath("//a[contains(text(),'" + orderId + "')]");
    }

    protected static By getAccountName(String accountName) {
        return By.xpath("//strong[contains(text(),'" + accountName + "')][1]");
    }

    protected static By getDateProduct(String orderId) {
        return By.xpath("//a[contains(text(),'"+orderId+"')]/../..//time");
    }

    protected static By getViewBtn(String orderId)
    {
        return By.xpath("//a[contains(text(),'"+orderId +"')]/../..//a[@class='woocommerce-button button view']");
    }

    public void validateAccountAfterFirstPurchase(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAccountName(name)));
        Assert.assertEquals("Account created", name, driver.findElement(getAccountName(name)).getText());
    }

    public void checkOrderId(String orderId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getOrderId(orderId)));
        String orderIdString = driver.findElement(getOrderId(orderId)).getText();
        String orderIdStringReplaced = orderIdString.replace("#", "");

        Assert.assertEquals("Order ID wassn't found", orderId, orderIdStringReplaced);

    }

    public void validateOrderIdDate(String orderId, String date)
    {
        String orderIdString = driver.findElement(getOrderId(orderId)).getText().replace("#","");
        String dateString = driver.findElement(getDateProduct(orderId)).getText();

        Assert.assertEquals("OrderId not found",orderIdString,orderId);
        Assert.assertEquals("Date not found", dateString,date);


    }

    public void clickOrderDetails(String orderId)
    {
        driver.findElement(getViewBtn(orderId)).click();
    }

    public void goToListOrders() {
        driver.findElement(ordersLink).click();
    }

}
