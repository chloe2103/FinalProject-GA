package Nike;

import Common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.util.List;

import static Nike.WebElements.*;

public class Homepage extends WebAPI {
    //public access modifier which is inheriting from WebAPI class
    //Using FindBY Annotation to locate and initialize the web elements that were indicated in WebElement Class
    @FindBy(how = How.XPATH, using = nikeSearchBarXpath)
    public WebElement nikeSearchBar;
    @FindBy(how = How.CSS, using = firstResultCSS)
    public WebElement firstResult;
    @FindBy(how = How.XPATH, using = productSizeGuideXpath)
    public WebElement productSizeGuide;
    @FindBy(how = How.XPATH, using = addToBagButtonXpath)
    public WebElement addToBagButton;
    @FindBy(how = How.XPATH, using = checkCartButtonXpath)
    public WebElement checkCartButton;
    @FindBy(how = How.XPATH, using = nikeHomepageSignInXpath)
    public WebElement nikeHomepageSignIn;
    @FindBy(how = How.XPATH, using = nikeUsernameXpath)
    public WebElement nikeUsername;
    @FindBy(how = How.XPATH, using = countryDropDownMenuXpath)
    public static WebElement countryDropDownMenu;
    @FindBy(how = How.XPATH, using = thumbnailContainerXpath)
    public static WebElement thumbnailContainer;
    @FindBy(how = How.CSS, using = nextButtonCSS)
    public static WebElement nextButton;
    @FindBy(how = How.XPATH, using = findAStoreXpath)
    public static WebElement findAStore;
    @FindBy(how = How.XPATH, using = zipcodeInputXpath)
    public static WebElement zipcodeInput;
    @FindBy(how = How.CSS, using = zipcodeListCSS)
    public static WebElement zipcodeList;
    @FindBy(how = How.CSS, using = searchIconCSS)
    public static WebElement searchIcon;
    @FindBy(how = How.XPATH, using = storeFilterButtonXpath)
    public static WebElement storeFilterButton;
    @FindBy(how = How.XPATH, using = filterOptionXpath)
    public static WebElement filterOption;
    @FindBy(how = How.CSS, using = storeResultCSS)
    public static WebElement storeResult;

    public void waitUntilClickAble(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void selectDropDownByValue() throws InterruptedException {
        Select select = new Select(countryDropDownMenu);
        for(int i = 0; i < 10; i++){
            select.selectByIndex(i);
            Thread.sleep(500);
        }
    }

    public void userNameInput() {
        nikeHomepageSignIn.click();
        nikeUsername.click();
        nikeUsername.sendKeys("snkwempnt@gmail.com");
    }

    public void searchBarInteract() throws InterruptedException {
        nikeSearchBar.sendKeys("shoes");
        nikeSearchBar.sendKeys(Keys.RETURN);
        firstResult.click();
        //Assert.fail("Intentionally failing the test. This is a forced failure.");
    }

    public void selectSizeGuide() throws InterruptedException {
        //firstResult.click();
        productSizeGuide.click();
        Thread.sleep(2000);
    }

    public void imageCycle() throws InterruptedException {
        List<WebElement> childDivs = thumbnailContainer.findElements(By.tagName("img"));
        int listLength = childDivs.size();
        Actions actions = new Actions(driver);
        for (int i = 0; i < listLength; i++) {
            actions.moveToElement(nextButton).click().perform();
            Thread.sleep(1000);
        }
    }

    public void storeSelect(String zipcode) {
        findAStore.click();
        zipcodeInput.sendKeys(zipcode + Keys.ENTER);
        WebElement firstResult = storeResult.findElement(By.tagName("section"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstResult).doubleClick().perform();
    }


    //search for an item, click on the first result, check products size guide
    public void TestCase1() throws InterruptedException {
        searchBarInteract();
        selectSizeGuide();
    }

    //head to username page, loop through first ten values on country drop down
    public void TestCase2() throws InterruptedException{
        userNameInput();
        selectDropDownByValue();
    }

    //cycle through images on a products page
    public void TestCase3() throws InterruptedException{
        searchBarInteract();
        imageCycle();
    }

    //find stores near me
    public void TestCase4(String zipcode) throws InterruptedException {
        storeSelect(zipcode);
    }


}
