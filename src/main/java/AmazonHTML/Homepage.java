package AmazonHTML;
import Common.WebAPI;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static AmazonHTML.WebElements.*;

public class Homepage extends WebAPI {
    //public access modifier which is inheriting from WebAPI class


    //Using FindBY Annotation to locate and initialize the web elements that were indicated in
    //in WebElement Class
    @FindBy(how = How.XPATH, using = amazonMouseHoverLogInButtonXpath)
    public WebElement amazonSignInMouseHover;


    @FindBy(how = How.XPATH, using = SignInButtonXpath)
    public WebElement amazonSignInButton;

    @FindBy(how = How.XPATH, using = amazonuserEmailOrPhoneNumberXpath)
    public WebElement amusernameWebElement;

    @FindBy(how = How.XPATH, using = amazoncontinueButtonXpath)
    public WebElement acontinueButtonWebElement;
    @FindBy(how = How.XPATH, using = forgotPasswordButtonXpath)
    public WebElement forgotPassWebelement;



    // Method to perform hover action on a web element
    public void amazonSignInHover(WebElement element) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        WebDriverWait wait = new WebDriverWait(driver,10);

    }

public void forgotPassButton (){
        forgotPassWebelement.click();
        WebDriverWait wait= new WebDriverWait(driver,5);
}
    public void amazonSignIn() throws InterruptedException {
        amazonSignInButton.click();
        //click action on webElent
        Thread.sleep(3);
        // Thread.sleep pausing in the execution of the program for a specified number of milliseconds
    }

    public void usernameInputfield() throws InterruptedException {
        amusernameWebElement.click();
        inputValueInTextBoxByWebElement(amusernameWebElement, "+16098755259");
        Thread.sleep(2000);
    }

    public void continueButton() {
        acontinueButtonWebElement.click();
    }

    //public void amazonHoverButton(WebElement element1) throws InterruptedException {
       // Actions actions = new Actions(driver);
       // actions.moveToElement(element1).build().perform();
        //Thread.sleep(1000);
   // }


    public void TestCase1() throws InterruptedException {
        amazonSignInHover(amazonSignInMouseHover);
        amazonSignIn();
        usernameInputfield();
        forgotPassButton();

    }

    public void TestCase2() throws InterruptedException {
        getCurrentUrl();
        Thread.sleep(4000);
    }
}