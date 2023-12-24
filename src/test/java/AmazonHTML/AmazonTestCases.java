package AmazonHTML;

import Common.WebAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AmazonTestCases extends WebAPI {
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

    @Test
    public void TestCase2() throws InterruptedException {
        getInitElements();
        homepage.TestCase2();
        //through homepage accessing the homepageClass

    }

    @Test
    public void TestCase3() {
        getInitElements();
        homepage.TestCase3();
    }

    @Test
    public void TestCase4() throws InterruptedException {
        getInitElements();
        homepage.TestCase4();
    }

    @Test
    public void TestCase5() throws InterruptedException {
        getInitElements();
        homepage.TestCase5();
    }

    @Test
    public void TestCase6() throws InterruptedException {
        getInitElements();
        homepage.TestCase6();
    }

    @Test
    public void TestCase7() throws InterruptedException {
        getInitElements();
        homepage.TestCase7();
    }

    @Test
    public void TestCase8() throws InterruptedException {
        getInitElements();
        homepage.TestCase8();
    }
}
