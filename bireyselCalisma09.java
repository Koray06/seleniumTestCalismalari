package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.testBase;

public class bireyselCalisma09 extends testBase {
     /* 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        2 ) Bir metod olusturun: iframeTest
            - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
            - Text Box’a “Merhaba Dunya!” yazin.
            - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
    oldugunu dogrulayin ve  konsolda yazdirin.*/

    @Test
    public void test1 () throws InterruptedException {
        //  1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iFramecontainingdriver = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iFramecontainingdriver.isDisplayed());
        System.out.println(iFramecontainingdriver.getText());

        //- Text Box’a “Merhaba Dunya!” yazin
       WebElement frameElementi = driver.findElement(By.xpath("//iframe[@id=\"mce_0_ifr\"]"));
       driver.switchTo().frame(frameElementi);
       WebElement texBox = driver.findElement(By.xpath("//body[@id=\"tinymce\"]"));
        Thread.sleep(4000);
       texBox.clear();

        texBox.sendKeys("Merhaba Dunya!");
        Thread.sleep(4000);
      //  - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
        // oldugunu dogrulayin ve  konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[@href=\"http://elementalselenium.com/\"]"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println(elementalSelenium.getText());

    }
}
