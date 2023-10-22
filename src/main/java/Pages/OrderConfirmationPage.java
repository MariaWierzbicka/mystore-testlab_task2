package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage{
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[text()[contains(.,\"Your order is confirmed\")]]")
    private WebElement confirmationAlert;
    public WebElement getConfirmationAlert() {
        return getVisibleElement(confirmationAlert);
    }

}
