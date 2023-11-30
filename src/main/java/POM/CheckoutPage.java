package POM;

import junit.framework.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage{

    By firstNameInput = By.id("billing_first_name");

    By lastNameInput = By.id("billing_last_name");

    By countryDropdown = By.id("select2-billing_country-container");

    By countryDropdownSearch = By.xpath("//span[@class='select2-search select2-search--dropdown']//input");

    By cityInput = By.id("billing_city");

    By stateDropdown = By.id("select2-billing_state-container");

    By stateDropdownInput = By.xpath("//span[@class='select2-search select2-search--dropdown']//input");

   By addressInput = By.id("billing_address_1");

   By postCodeInput = By.id("billing_postcode");

   By phoneInput = By.id("billing_phone");

   By emailInput = By.id("billing_email");

   By placeOrderBtn = By.id("place_order");

    By loadingIcon = By.xpath("//div[@class='blockUI blockOverlay']");

   By orderReceived = By.xpath("//h1[text()='Order received']");

   By creatAccountInput = By.id("createaccount");

   By orderId = By.xpath("//li[@class='woocommerce-order-overview__order order']//strong");

   By dateCheckout = By.xpath("//li[@class='woocommerce-order-overview__date date']//strong");

   By totalCheckout = By.xpath("//li[@class='woocommerce-order-overview__total total']//bdi");


    public String returnOrderId()  {

        String orderIdString = driver.findElement(orderId).getText();
        return orderIdString;
    }

    public List<String> returnOrderData()  {

        String dateCheckoutString = driver.findElement(dateCheckout).getText();
        String orderIdString = driver.findElement(orderId).getText();
        String totalOrderString = driver.findElement(totalCheckout).getText();

        List<String> listOrders = new ArrayList<>();
        listOrders.add(orderIdString);
        listOrders.add(dateCheckoutString);
        listOrders.add(totalOrderString);

        return listOrders;
    }


    public void fillData(String firstname, String lastname, String country, String address, String city, String state, String zip, String phone, String email)  {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameInput));
        driver.findElement(firstNameInput).sendKeys(firstname);
        driver.findElement(lastNameInput).sendKeys(lastname);
        driver.findElement(countryDropdown).click();
        driver.findElement(countryDropdownSearch).sendKeys(country);
        driver.findElement(countryDropdownSearch).sendKeys(Keys.ENTER);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(stateDropdown).click();
        driver.findElement(stateDropdownInput).sendKeys(state);
        driver.findElement(stateDropdownInput).sendKeys(Keys.ENTER);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(postCodeInput).sendKeys(zip);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickPlaceOrderBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingIcon));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
        driver.findElement(placeOrderBtn).click();
    }

    public void waitLoadingIcon()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingIcon));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
    }

    public void createAccount()
    {
        driver.findElement(creatAccountInput).click();
    }

    public void validatePurchaseSuccesful()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingIcon));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));

        Assert.assertEquals("Order wasn't received","Order received",driver.findElement(orderReceived).getText());
    }

    public String  createRandomEmail()
    {
        String stringRandom = RandomStringUtils.randomAlphabetic(10);
        String email = stringRandom + "@" + "gmail.com";
        return email;
    }

    public String returnFullName(String firstname, String lastname)  {
        String fullName = firstname +" "+ lastname;


        return fullName;

    }
}
