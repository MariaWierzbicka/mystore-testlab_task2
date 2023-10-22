package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@id=\"addresses-link\"]/span")
    private WebElement addressButton;

    public WebElement getAddressButton(){
        return getVisibleElement(addressButton);
    }
    public void clickAddressButton(){
        getAddressButton().click();
    }
}
