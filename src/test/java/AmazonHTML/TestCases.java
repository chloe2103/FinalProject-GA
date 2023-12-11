package AmazonHTML;

import Common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestCases extends WebAPI {
    //extendingWb API functions
    static Homepage homepage;
    //object of a class

    public static void getInitElements() {
        homepage = PageFactory.initElements(driver, Homepage.class);
    }

    @Test
    public void TestCase1() throws InterruptedException {
        getInitElements();
        homepage.TestCase1();
        //through homepage accessing the homepageClass

    }
}
