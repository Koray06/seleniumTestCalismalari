package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilites.testBaseBeforeClass;

public class bireyselCalisma15  extends testBaseBeforeClass {

    //gerekli ayarlamalari yapin
    //Amazon anasayfaya gidin
    // Title nin Amazon kelimesi içerdiğini test edin
    // yeni bir tab açarak wisequarter sayfasına gidin
    //url'nin wisequarter içerdiğini test edin

    @Test
    public void test01 (){
        //Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // Title nin Amazon kelimesi içerdiğini test edin
        String expectedTitle = "Amazon";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        // adres ile ilgili olarak sol üst tarafta çıkan uyarıyı kapatalım
        WebElement adressCooki = driver.findElement(By.xpath("//input[@data-action-type=\"DISMISS\"]"));
        adressCooki.click();
        // başka pencere veya tag a geçme ihtimalne karşı handle değerini alalım.
        String ilkWindowHandle = driver.getWindowHandle();
        // yeni bir tab açarak wisequarter sayfasına gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        //url'nin wisequarter içerdiğini test edin
        String expectedResult = "wisequarter";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
