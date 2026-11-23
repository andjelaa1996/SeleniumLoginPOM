package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    String validUsername;
    String validPassword;
    String invalidUsername;
    String invalidPassword;

    @BeforeMethod
    public void pageSetUp(){
        //preduslov da bi dosli na nasu stranicu
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButon();
        validUsername = "student";
        validPassword = "Password123";
        invalidUsername = "nonstudent";
        invalidPassword = "nonpassword";

    }
    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies(); //stavljeno odmah ispod BeforeMethod da se vidi da ne mora na kraju da bude
    }

    @Test(priority = 1)
    public void userCanLogIn() throws InterruptedException {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLoggedInMessage().isDisplayed());
        Assert.assertTrue(profilePage.getLoggedOutButton().isDisplayed());
        //Thread.sleep(3000); //vezuje se za metodu, ne za klasu zato svuda mora da se doda
    }

    @Test(priority = 2)
    public void userCannotLogInWithInvalidUsername() {
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        //Assert.assertEquals(loginPage.getError().getText(),"Your username is invalid!"); //bolja opcija ispod
        Assert.assertEquals(loginPage.errorText(),"Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

    }
    @Test(priority = 3)
    public void userCannotLogInWithInvalidPassword() {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnSubmitButton();
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.errorText(),"Your password is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

    }
    @Test(priority = 4)
    public void userCannotLogInWithEmptyUsernameField() {
        loginPage.inputUsername("");
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.errorText(),"Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

    }
    @Test(priority = 5)
    public void userCannotLogInWithEmptyPasswordField() {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword("");
        loginPage.clickOnSubmitButton();
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.errorText(),"Your password is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

    }

}
