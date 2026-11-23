package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class PracticePage {

    WebDriver driver;
    WebElement testLoginPageButton;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTestLoginPageButton() {
        //return testLoginPageButton;
        return driver.findElement(By.linkText("Test Login Page"));

        //---------------------------


    }
    public void clickOnTestLoginPageButon(){
        getTestLoginPageButton().click();
    }



}
