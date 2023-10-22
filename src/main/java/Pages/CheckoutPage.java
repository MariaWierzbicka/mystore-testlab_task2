package Pages;

import dev.failsafe.internal.util.Assert;
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

    @FindBy(xpath = "(//*[contains(text(), \"Pay by Check\")])/../preceding-sibling::span/input")
    private WebElement paymentRadio;
    @FindBy(xpath = "//*[contains(text(), \"Pay by Check\")]")
    private WebElement paymentOption;
    @FindBy(id="conditions_to_approve[terms-and-conditions]")
    private WebElement termsAndConditionsCheckbox;
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]//button")
    private WebElement placeOrderButton;

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
    public WebElement getPaymentOption(){
        return getVisibleElement(paymentOption);
    }
    public WebElement getPaymentRadio() {
        return paymentRadio;
    }
    public void pickPaymentOption() {
        getPaymentOption().click();
    }
    public WebElement getTermsAndConditionsCheckbox() {
        return getVisibleElement(termsAndConditionsCheckbox);
    }
    public void checkTermsAndConditionsCheckbox() {
        if(!termsAndConditionsCheckbox.isSelected()){
            termsAndConditionsCheckbox.click();
        }
    }
    public WebElement getPlaceOrderButton() {
        boolean activePlaceOrderButton = placeOrderButton.isEnabled();
        Assert.isTrue(activePlaceOrderButton, "Terms not accepted");
        return getVisibleElement(placeOrderButton);
    }
    public void clickPlaceOrderButton() {
        getPlaceOrderButton().click();
    }
}
