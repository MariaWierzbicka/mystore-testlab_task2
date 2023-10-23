package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsListPage extends BasePage {
    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    private WebElement findProductElement(String name) {
        return driver.findElement(By.xpath("//*[@class=\"product-description\"]//a[contains(text(), \"" + name + "\")]"));
    }
    public WebElement getProductElement(String productName) {
        return getVisibleElement(findProductElement(productName));
    }
/*
  --- Alternative way: fixed product ---
    @FindBy(xpath = "//a[contains(text(), \"Hummingbird printed sweater\")]")
    private WebElement productElement;

    public WebElement getProductElement() {
        return getVisibleElement(productElement);
    }
*/

}
