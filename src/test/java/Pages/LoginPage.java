package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    WebElement usernameField; //mrtav kod koji je siv moze da se obrise ili da ostane da sluzi kao lista
    WebElement passwordField;
    WebElement submitButton;
    WebElement error;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        //return usernameField;
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        //return passwordField;
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        //return submitButton;
        return driver.findElement(By.id("submit"));
    }

    public WebElement getError() {
        //return error;
        return driver.findElement(By.id("error"));
    }
//------------kreiranje akcija za ova tri WebElementa------------------

    public void inputUsername(String username){
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void inputPassword(String password){
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnSubmitButton(){
        getSubmitButton().click();
    }

    public String errorText(){
        return getError().getText(); //kreiranje metode da uhvati text
    }
}
