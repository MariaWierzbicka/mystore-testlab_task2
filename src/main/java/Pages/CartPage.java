package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(text(), \"Proceed to checkout\")]")
    private WebElement proceedToCheckoutButton;

    public WebElement getProceedToCheckoutButton() {
        return getVisibleElement(proceedToCheckoutButton);
    }
    public void clickProceedToCheckoutButton() {
        getProceedToCheckoutButton().click();
    }
}
