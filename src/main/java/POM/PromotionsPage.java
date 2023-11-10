package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PromotionsPage extends BasePage{

    By couponBtn = By.id("couponBtn");

    By cartLink = By.xpath("//ul[@id='site-header-cart']//a");

    public String getCouponAndClickCart()
    {
        driver.findElement(couponBtn).click();
        String couponString = driver.switchTo().alert().getText();
        String couponReplaced = couponString.replace("Try the coupon- ","");
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        driver.findElement(cartLink).click();

        return couponReplaced;
    }


}
