package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "form-control-select")
    private WebElement sizeSelectElement;
    @FindBy(id="quantity_wanted")
    private WebElement quantityInputElement;
    @FindBy(xpath = "//*[@class=\"add\"]/button")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[contains(text(), \"Proceed to checkout\")]")
    private WebElement proceedToCheckoutButton;
    public WebElement getSizeElement(){
        return getVisibleElement(sizeSelectElement);
    }
    public WebElement getQuantityInputElement() {
        return getVisibleElement(quantityInputElement);
    }
    public WebElement getAddToCartBtn(){
        return getVisibleElement(addToCartButton);
    }
    public WebElement getProceedToCheckoutButton(){
        return getVisibleElement(proceedToCheckoutButton);
    }
    public void clickAddToCartButton() {
        getAddToCartBtn().click();
    }
    public void clickProceedToCheckoutButton() {
        getProceedToCheckoutButton().click();
    }
}
