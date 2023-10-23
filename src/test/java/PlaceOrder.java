import Pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.regex.qual.Regex;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import javax.annotation.RegEx;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PlaceOrder {

    WebDriver driver;
    HeaderPage headerPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    OrderConfirmationPage orderConfirmationPage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("user has an account on mystore-testlab.coderslab.pl and is not logged in")
    public void userHasAnAccountOnMystoreTestlabCoderslabPlAndIsNotLoggedIn() {
        driver.get("https://mystore-testlab.coderslab.pl/");
    }

    @When("sign in button is clicked")
    public void signInButtonIsClicked() {
        headerPage = new HeaderPage(driver);
        headerPage.clickSignInButton();
    }

    @And("valid {} and {} are given and sign in button is clicked")
    public void validEmailAndPasswordAreGivenAndSignInButtonIsClicked(String email, String password) {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.logIntoAnExistingAccount(email, password);
    }

    @And("user navigates to the clothes section")
    public void userNavigatesToTheClothesSection() {
        headerPage.clickClothesCategoryButton();
    }

    @And("user navigates to {} page by clicking on its name")
    public void userNavigatesToPageByClickingOnItsName(String name) {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.getProductElement(name).click();
    }
/*
    --- Alternative way: fixed product ---
    @And("user navigates to product page by clicking on its name")
    public void userNavigatesToProductPageByClickingOnItsName() {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        productsListPage.getProductElement().click();
    }
*/
    @And("chooses size {} and quantity {}")
    public void choosesSizeSizeAndQuantityQuantity(String size, int quantity) throws InterruptedException  {
        productPage = new ProductPage(driver);
        WebElement sizeElement = productPage.getSizeElement();
        Select select = new Select(sizeElement);
        select.selectByVisibleText(size);

        String strQuantity = String.valueOf(quantity);
        productPage.getQuantityInputElement().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Thread.sleep(Duration.ofMillis(100)); //Wait for ctrl+a to take effect
        productPage.getQuantityInputElement().sendKeys(strQuantity);
    }

    @And("adds product to cart")
    public void addsProductToCart() {
        Assert.assertTrue(productPage.checkDiscount().matches("(.*)20%(.*)")); // Check if discount is 20%
        productPage.clickAddToCartButton();
    }

    @And("clicks proceed to checkout in the success popup")
    public void clicksProceedToCheckoutInTheSuccessPopup() {
        productPage.clickProceedToCheckoutButton();
    }

    @And("clicks proceed to checkout in the cart view")
    public void clicksProceedToCheckoutInTheCartView() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickProceedToCheckoutButton();
    }

    @And("address is confirmed by clicking continue")
    public void addressIsConfirmedByClickingContinue() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickConfirmAddressButton();
    }

    @And("user chooses shipping option self-pick-up and clicks continue")
    public void userChoosesShippingOptionSelfPickUpAndClicksContinue() {
        checkoutPage.pickDeliveryOption();
        Assert.assertTrue(checkoutPage.deliveryOptionRadioIsSelected());
        checkoutPage.clickConfirmDeliveryButton();
    }

    @And("chooses payment method pay-by-check")
    public void choosesPaymentMethodPayByCheck() {
        checkoutPage.pickPaymentOption();
        Assert.assertTrue(checkoutPage.getPaymentRadio().isSelected());
    }

    @And("accepts terms of service")
    public void acceptsTermsOfService() {
        checkoutPage.checkTermsAndConditionsCheckbox();
    }

    @And("confirms by clicking place order")
    public void confirmsByClickingPlaceOrder() {
        checkoutPage.clickPlaceOrderButton();
    }

    @Then("order confirmation is displayed")
    public void orderConfirmationIsDisplayed() {
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.getConfirmationAlert();
    }

    @And("screenshot is taken")
    public void screenshotIsTaken() throws IOException {

/*
--- Alternative screenshot ---
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '0.7'");
        WebElement element = orderConfirmationPage.getConfirmationCard();
        js.executeScript("arguments[0].scrollIntoView();", element);
        File orderInfoScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
*/
        File orderInfoScreenshot = orderConfirmationPage.getConfirmationCard().getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(orderInfoScreenshot, new File("C:\\CodersLab\\Zaliczenie\\mystore-testlab_task2\\screenshots\\orderInfo.png"));
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }

}
