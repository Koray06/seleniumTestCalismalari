package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilites.testBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class bireyselCalisma19 extends testBase {

    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
    // Dosyayi Downloads klasorune indirecek
    // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
    // herkesin dosya yolu birbirinden farkli olur
    // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz
    //C:\Users\emre.cigit\Downloads\foto.png"
    //"C:\Users\Berke\Downloads\foto.png"

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement resimElementi = driver.findElement(By.xpath("//a[text()='capture.jpg']"));
        resimElementi.click();
       Thread.sleep(5000);
        String dosyaYolu = "/Users/koray/Downloads/capture.jpg";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        String ilkWindowHandle = driver.getWindowHandle();
        Thread.sleep(5000);


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));

        Thread.sleep(3000);


        dosyaSec.sendKeys(dosyaYolu);
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();
        WebElement uploded = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploded.isDisplayed());


    }
}
