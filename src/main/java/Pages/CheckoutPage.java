package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressButton;
    @FindBy(xpath = "//*[contains(text(), \"Self pick up\")]")
    private WebElement deliveryOption;
    @FindBy(xpath = "(//*[contains(text(), \"Self pick up\")]/ancestor::label)/preceding-sibling::*//input")
    private WebElement deliveryOptionRadio;
    @FindBy(name="confirmDeliveryOption")
    private WebElement confirmDeliveryButton;
    public WebElement getConfirmAddressButton(){
        return getVisibleElement(confirmAddressButton);
    }
    public WebElement getDeliveryOption() {
        return getVisibleElement(deliveryOption);
    }
    public void clickConfirmAddressButton() {
        getConfirmAddressButton().click();
    }
    public void pickDeliveryOption() {
        getDeliveryOption().click();
    }
    public WebElement getDeliveryOptionRadio() {
        return deliveryOptionRadio;
    }
    public boolean deliveryOptionRadioIsSelected(){
        return getDeliveryOptionRadio().isSelected();
    }
    public WebElement getConfirmDeliveryButton(){
        return getVisibleElement(confirmDeliveryButton);
    }
    public void clickConfirmDeliveryButton(){
        getConfirmDeliveryButton().click();
    }

}
