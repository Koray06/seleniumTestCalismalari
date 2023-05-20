package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.testBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class bireyselCalisma17 extends testBase {
    /*
           driver ile gittigimiz bir websayfasinda
           bilgisayarimizdaki bir dosyayi upload etmek istersek
           bilgisayarimizdaki klasorlere erismemiz gerekir
           Selenium webdriver bilgisayardaki dosyalara erisemez
           bunun yerine 3 adimla su islemleri yapariz
           1- choose file  butonunu locate edelim
           2- bilgisayarimizdan yuklemek istedigimiz dosyanin dosya yolunu olusturalim
              (Mumkunse dinamik dosya yolu olsun)
           3- chooseButonu.sendkeys(dosyaYolu) ile dosya yolunu sisteme tanitalim
        */
    @Test
    public void test01(){

        /*System.out.println(System.getProperty("user.dir"));
        ///Users/koray/IdeaProjects/com.team113_jUnit
        String herkesteAyni = System.getProperty("user.dir");

       String dosyaYolubendeAyni = System.getProperty("user.dir");
       String dosyaYoluFarkli = "/src/test/java/day10/deneme.txt";
       String dosyaYolu = dosyaYolubendeAyni+dosyaYoluFarkli;
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); */

        //https://the-internet.herokuapp.com/upload adresine gidelim
        // chooseFile butonunu kullanarak
        // projemizdeki deneme.txt dosyasini secelim
        //Upload butonuna basalim.
        //“File Uploaded!” textinin goruntulendigini test edelim.

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement cohooseButton =driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));

        String bilgDosyaYolu = System.getProperty("user.dir");
        String dosyaninKendisi = "/src/test/java/day10/deneme.txt";
        String dosyaYolu= bilgDosyaYolu+dosyaninKendisi;
        cohooseButton.sendKeys(dosyaYolu);
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();
        WebElement uploded = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploded.isDisplayed());
    }
}
