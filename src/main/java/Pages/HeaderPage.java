package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{
    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class=\"user-info\"]/a")
    private WebElement signInButton;
    @FindBy(id = "category-3")
    private WebElement clothesCategoryButton;

    public WebElement getSignInButton(){
        return getVisibleElement(signInButton);
    }
    public WebElement getClothesCategoryButton(){
        return getVisibleElement(clothesCategoryButton);
    }
    public void clickSignInButton(){
        getSignInButton().click();
    }
    public void clickClothesCategoryButton(){
        getClothesCategoryButton().click();
    }
}
