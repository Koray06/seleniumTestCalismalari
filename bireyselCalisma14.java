package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.testBase;

public class bireyselCalisma14 extends testBase {
          //  1- https://www.amazon.com/ adresine gidin
          // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
         //  3- “Create a list” butonuna basin
        //  4- Acilan sayfada “Your Lists” yazisi oldugunu test edin */

    @Test
    public void Test01() {
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);
        // ekranda çıkan lokasyon ile ilgili olan utarıyı kapatalım
        WebElement dismiss = driver.findElement(By.xpath("//input[@data-action-type=\"DISMISS\"]"));
        action.click(dismiss).perform();

        // Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement accountList = driver.findElement(By.xpath("//span[@class=\"nav-line-2 \"]"));
        action.moveToElement(accountList).perform();

        //  “Create a list” butonuna basin
        WebElement createList = driver.findElement(By.xpath("//*[@id=\"nav-al-wishlist\"]/a[1]/span"));
        action.click(createList).perform();

        //  Acilan sayfada “Your Lists” yazisi oldugunu test edin */
        String expextedResult =  "Your Lists";
        String actualResult = driver.findElement(By.xpath("//div[@role=\"heading\"]")).getText();

        Assert.assertTrue(actualResult.contains(expextedResult));
    }
}
