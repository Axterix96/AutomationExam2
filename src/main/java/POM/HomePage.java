package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage{

    By productsList = By.xpath("//ul[@class='products columns-4']//li");

    By viewCartBtn = By.xpath("//a[@class='added_to_cart wc-forward']");

    public void addProduct(String productName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsList));

        List<WebElement> products = driver.findElements(productsList);


        for(int i =0; i <products.size();i++)
        {
            String textProduct = products.get(i).getText();
            String[] parts = textProduct.split("\n");

            if(parts[0].equals(productName))
            {
                WebElement prod = products.get(i).findElement(By.xpath("//h2[text()='"+productName+"']/../..//a[text()='Add to cart']"));
                prod.click();

                WebElement viewCartBtn = products.get(i).findElement(By.xpath("//h2[text()='"+productName+"']/../..//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart loading']"));

                wait.until(ExpectedConditions.visibilityOf(viewCartBtn));
                wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));

            }
        }




     }
public void clickCartBtn()
{
    wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));
    driver.findElement(viewCartBtn).click();
}

}
