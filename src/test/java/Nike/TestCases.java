package Nike;

import Common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCases extends WebAPI {
    //extendingWb API functions
    static Nike.Homepage homepage;
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

    @Test
    public void TestCase2() throws InterruptedException {
        getInitElements();
        homepage.TestCase2();
        //through homepage accessing the homepageClass
    }

    @Test
    public void TestCase3() throws InterruptedException {
        getInitElements();
        homepage.TestCase3();
    }

    @Test
    @Parameters("zipcode")
    public void TestCase4(String zipcode) throws InterruptedException {
        getInitElements();
        homepage.TestCase4(zipcode);
    }

}
