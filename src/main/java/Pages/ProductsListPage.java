package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsListPage extends BasePage{
    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

//    private String productName;
    @FindBy(xpath = "//a[contains(text(), \"Hummingbird printed sweater\")]")
    private WebElement productElement;

    public WebElement getProductElement() {
        return getVisibleElement(productElement);
    }

    //    private WebElement findProductElement(String productName){
//        WebElement productElement = driver.findElement(By.xpath("//*[@class=\"product-description\"]//a[contains(text(), " + productName + ")]"));
//        return productElement;
//    }
//    public WebElement getProductElement(String name){
//        return getVisibleElement(findProductElement(name));
//    }
}
