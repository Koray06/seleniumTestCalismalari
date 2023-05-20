package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilites.testBase;

public class bireyselCalisma10 extends testBase {
    //gerekli ayarlamalari yapin
    //Amazon anasayfaya gidin
    // Title nin amazon kelimesi içerdiğini test edin
    // yeni bir tab açarak wisequarter sayfasına gidin
    //url'nin wisequarter içerdiğini test edin

    @Test
    //Amazon anasayfaya gidin
   public void test01 () throws InterruptedException {
        driver.get("https://www.amazon.com");

        // başka taba geçeceğim için bulunduğum sayfanıb handle değerin alıyorum .
        String amazonHandle = driver.getWindowHandle();

        // Title nin Amazon kelimesi içerdiğini test edin
        String expectedResult = "Amazon";
        String actualResult = driver.getTitle();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(3000);

        // yeni bir tab açarak wisequarter sayfasına gidin
        driver.switchTo().newWindow(WindowType.TAB);

        //url'nin "wisequarter" içerdiğini test edin
        driver.get("https://www.wisequarter.com");
       String expectedResult1 = "wisequarter";
       String  actualResult1= driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
       Assert.assertTrue(actualResult1.contains(expectedResult1));
       Thread.sleep(3000);
    }


}
