package Nike;

import Common.WebAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static Nike.WebElements.*;

public class Homepage extends WebAPI {
    //public access modifier which is inheriting from WebAPI class
    //Using FindBY Annotation to locate and initialize the web elements that were indicated in WebElement Class
    @FindBy(how = How.XPATH, using = nikeSearchBarXpath)
    public WebElement nikeSearchBar;

    public void searchBarInteract() throws InterruptedException {
        nikeSearchBar.sendKeys("Airforces");
        nikeSearchBar.sendKeys(Keys.RETURN);
        //Assert.fail("Intentionally failing the test. This is a forced failure.");
        Thread.sleep(5000);
    }

    public void TestCase1() throws InterruptedException {
        searchBarInteract();

    }
}
