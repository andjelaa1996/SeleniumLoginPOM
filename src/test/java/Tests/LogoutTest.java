package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        //preduslov da bi dosli na nasu stranicu
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButon();
        //ovde je suvisan profilePage.clickOnTestLogoutPageButon(); jer na login stranici nema logout dugmeta
        loginPage.inputUsername("student");
        loginPage.inputPassword("password");
        loginPage.clickOnSubmitButton();
    }


    @Test(priority = 1)
    public void userCanLogOut() throws InterruptedException {

        profilePage.clickOnTestLogoutPageButon();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");


    }
    /*@Test(priority = 2)
    public void logOutByChangingPages(){
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButon();
    }*/

}
