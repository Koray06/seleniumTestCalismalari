package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.testBase;

public class bireyselCalisma18 extends testBase {
    /*       2- https://www.amazon.com sayfasina gidelim
            3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
            4  - aramanin gerceklestigini test edin */
    @Test
    public void test01 (){
        // https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

    //Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        Actions action = new Actions(driver);
        action.click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();
        WebElement results = driver.findElement(By.xpath("//span[text()='1-16 of 127 results for']"));
        Assert.assertTrue(results.isDisplayed());


    }
}
