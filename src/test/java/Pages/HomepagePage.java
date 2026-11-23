package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepagePage {

    WebDriver driver; // ne mora da bude public jer pozivamo samo za ovu klasu
    WebElement practiceButton; //getter-e radimo za WebElemente
    public HomepagePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPracticeButton() {
        //return practiceButton; //umesto ovog sto se generise - ide lokator driver.findElement(...)
        return driver.findElement(By.id("menu-item-20"));
    }

    //---------------------ispod idu akcije/metode dok su iznad WebElementi-----------------------

    public void clickOnPracticeButton(){
        getPracticeButton().click();
    }


}
