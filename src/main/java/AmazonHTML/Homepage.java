package AmazonHTML;

import Common.WebAPI;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static AmazonHTML.WebElements.*;

public class Homepage extends WebAPI {
    //public access modifier which is inheriting from WebAPI class

    @FindBy(how = How.XPATH, using = amazonSignInHoverXpath)
    public WebElement amazonSignInHover;
    @FindBy(how = How.XPATH, using = amazonSignInButtonXpath)
    public WebElement amazonSignInButton;
    @FindBy(how = How.XPATH, using = phoneNumberInputXpath)
    public WebElement phoneNumberInput;
    @FindBy(how = How.XPATH, using = passwordInputXpath)
    public WebElement passwordInput;
    @FindBy(how = How.XPATH, using = amazonSearchBarXpath)
    public WebElement amazonSearchBar;
    @FindBy(how = How.XPATH, using = amazonFirstSearchResultXpath)
    public WebElement firstSearchResult;
    @FindBy(how = How.XPATH, using = addToCartButtonXpath)
    public WebElement addToCart;
    @FindBy(how = How.XPATH, using = goToCartButtonXpath)
    public WebElement goToCart;
    @FindBy(how = How.XPATH, using = goToMyAccountXpath)
    public WebElement goToMyAccount;
    @FindBy(how = How.XPATH, using = accountSecuritySettingsXpath)
    public WebElement accountSecuritySettings;
    @FindBy(how = How.XPATH, using = accountAddressSettingsXpath)
    public WebElement accountAddressSettings;
    @FindBy(how = How.XPATH, using = accountListSettingsXpath)
    public WebElement accountListSettings;
    @FindBy(how = How.XPATH, using = addAddressXpath)
    public WebElement addAddress;
    @FindBy(how = How.XPATH, using = addAddressButtonXpath)
    public WebElement addAddressButton;
    @FindBy(how = How.XPATH, using = addressInputXpath)
    public WebElement addressInput;
    @FindBy(how = How.XPATH, using = cityInputXpath)
    public WebElement cityInput;
    @FindBy(how = How.XPATH, using = zipInputXpath)
    public WebElement zipInput;
    @FindBy(how = How.XPATH, using = stateDropDownXpath)
    public WebElement stateDropDown;
    @FindBy(how = How.XPATH, using = quantityDropDownXpath)
    public WebElement quantityDropDown;
    @FindBy(how = How.XPATH, using = removeAddressXpath)
    public WebElement removeAddress;
    @FindBy(how = How.XPATH, using = removeAddressConfirmXpath)
    public WebElement removeAddressConfirm;
    @FindBy(how = How.XPATH, using = verificationInputXpath)
    public WebElement verificationInput;
    @FindBy(how = How.XPATH, using = passwordEditButtonXpath)
    public WebElement passwordEdit;
    @FindBy(how = How.XPATH, using = proceedToCheckoutXpath)
    public WebElement proceedToCheckout;
    @FindBy(how = How.XPATH, using = firstListElementXpath)
    public WebElement firstListElement;
    @FindBy(how = How.XPATH, using = secondListElementXpath)
    public WebElement secondListElement;
    @FindBy(how = How.XPATH, using = countryToShopXpath)
    public WebElement countryToShop;
    @FindBy(how = How.XPATH, using = countryToShopDropDownXpath)
    public WebElement countryToShopDropDown;


    // Method to perform hover action on a web element
    public void amazonHoverClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    public void waitUntilClickAble(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void goToAccountSecuritySettings() {
        amazonHoverClick(amazonSignInHover);
        accountSecuritySettings.click();
        implicitWait(8);
        passwordEdit.click();
    }

    public void goToAccountAddressSettings() {
        amazonHoverClick(amazonSignInHover);
        accountAddressSettings.click();
    }

    public void goToAccountList() {
        amazonHoverClick(amazonSignInHover);
        accountListSettings.click();
    }

    public void editCountryToShop() {
        countryToShop.click();
        Select select = new Select(countryToShopDropDown);
        select.selectByVisibleText("United Kingdom");
    }


    public void addAddress() throws InterruptedException {
        addAddress.click();
        addressInput.sendKeys("86-18 102nd Road");
        cityInput.sendKeys("Ozone Park");
        zipInput.sendKeys("11416");
        Select select = new Select(stateDropDown);
        select.selectByValue("NY");
        //Thread.sleep(2000);
        addAddressButton.click();
        //Thread.sleep(2000);
    }

    public void removeAddress() throws InterruptedException {
        goToAccountAddressSettings();
        amazonHoverClick(removeAddress);
        amazonHoverClick(removeAddressConfirm);
        //Thread.sleep(2000);
    }

    public void userInfoInput() {
        phoneNumberInput.sendKeys("347-385-9330" + Keys.ENTER);
        passwordInput.sendKeys("tqvWuPrkv*M77EH" + Keys.ENTER);
    }

    public void searchProduct(String query) {
        amazonSearchBar.sendKeys(query + Keys.ENTER);
    }

    public void addItemToCart() {
        firstSearchResult.click();
        addToCart.click();
        goToCart.click();
    }

    public void editCheckout() {
        Select select = new Select(quantityDropDown);
        select.selectByValue("3");
        proceedToCheckout.click();
    }


    //sign into user profile
    public void TestCase1() throws InterruptedException {
        amazonHoverClick(amazonSignInHover);
        userInfoInput();
    }

    //search for product and add to cart
    public void TestCase2()  {
        searchProduct("blanket");
        addItemToCart();
    }
    //go to change password
    public void TestCase3() {
        amazonHoverClick(amazonSignInHover);
        userInfoInput();
        goToAccountSecuritySettings();
    }

    //adding a new address and removing
    public void TestCase4() throws InterruptedException {
        amazonHoverClick(amazonSignInHover);
        userInfoInput();
        goToAccountAddressSettings();
        addAddress();
    }

    //removing address
    public void TestCase5() throws InterruptedException {
        amazonHoverClick(amazonSignInHover);
        userInfoInput();
        removeAddress();
    }
    //adjust quantity and place a delivery
    public void TestCase6() {
        amazonHoverClick(amazonSignInHover);
        userInfoInput();
        searchProduct("blanket");
        addItemToCart();
        editCheckout();
    }
    //organize elements on wish list with drag and drop
    public void TestCase7() {
        amazonHoverClick(amazonSignInHover);
        userInfoInput();
        goToAccountList();
        dragAndDrop(firstListElement, secondListElement);
    }

    //utilize page scroll
    public void TestCase8() {
        scrollUpDownByHeight();
        editCountryToShop();
    }

}