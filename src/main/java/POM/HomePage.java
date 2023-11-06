package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage{

    By productsList = By.id("primary");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void addProduct(String productName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsList));

        List<WebElement> products = driver.findElements(productsList);

        for(int i =0; i <products.size();i++)
        {
            if(products.get(i).getText().toLowerCase().equals(productName))
            {
                WebElement prod = products.get(i).findElement(By.xpath("//h2[text()='"+productName+"']/../..//a[text()='Add to cart']"));
                prod.click();

            }
        }



    }


}
