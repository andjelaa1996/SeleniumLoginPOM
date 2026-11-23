package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    WebDriver driver;
    WebElement loggedInMessage;
    WebElement loggedOutButton;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoggedInMessage() {
        //return loggedInMessage;
        return driver.findElement(By.className("post-title"));
    }

    public WebElement getLoggedOutButton() {
        //return loggedOutButton;
        return driver.findElement(By.linkText("Log out"));
    }

    //----------------------

    public void clickOnTestLogoutPageButon(){
        getLoggedOutButton().click(); //metoda click
    }





}
