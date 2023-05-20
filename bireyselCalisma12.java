package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.testBaseBeforeClass;

import java.util.Set;

public class bireyselCalisma12 extends testBaseBeforeClass {

     /*      2- https://the-internet.herokuapp.com/context_menu sitesine gidin
            3- Cizili alan uzerinde sag click yapin
            4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
            5- Tamam diyerek alert’i kapatalim
            6- Elemental Selenium linkine tiklayalim
            7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim*/



    @Test
            public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.xpath("//div[@id=\"hot-spot\"]"));
        Actions action = new Actions(driver);
        action.contextClick(ciziliAlan).perform();
        Thread.sleep(3000);
       // Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.

        String expectedResult = "You selected a context menu";
        String actualResult =  driver.switchTo().alert().getText();
        Assert.assertTrue(actualResult.equals(expectedResult));

      //  Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim
        driver.switchTo().defaultContent();
        String ilkSayfaWinHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@target=\"_blank\"]")).click();
        Set<String> windowsHandle = driver.getWindowHandles();
        String ikinciWinHandle= "";
        for (String handleEach: windowsHandle
             ) {
            if (!handleEach.equals(ilkSayfaWinHandle)){
                ikinciWinHandle =handleEach;
            }
        }
        driver.switchTo().window(ikinciWinHandle);
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        WebElement tagName = driver.findElement(By.tagName("h1"));
        String expectedTag = "Elemental Selenium" ;
        String actualTag = tagName.getText();
        System.out.println(tagName.getText());
        Assert.assertTrue(actualTag.equals(expectedTag));
    }
}
