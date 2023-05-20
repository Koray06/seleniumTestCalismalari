package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.testBase;

public class bireyselCalisma07 extends testBase {
    /*
            3 test method'u olusturup asagidaki gorevi tamamlayin
        1. Test
            -  https://the-internet.herokuapp.com/javascript_alerts adresine gidin

            - 1.alert'e tiklayin
            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
            -  OK tusuna basip alert'i kapatin
        2.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 2.alert'e tiklayalim
            - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        3.Test
            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            - 3.alert'e tiklayalim
            - Cikan prompt ekranina "Abdullah" yazdiralim
            - OK tusuna basarak alert'i kapatalim
            - Cikan sonuc yazisinin Abdullah icerdigini test edelim
     */

  //1. Test
    @Test
            public void test01 (){
            //-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

           // - 1.alert'e tiklayin
            driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();

            //-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
                 String expectedResult = "I am a JS Alert";
                String actualResult = driver.switchTo().alert().getText();
        System.out.println(driver.switchTo().alert().getText());
                Assert.assertEquals(expectedResult,actualResult);

            //OK tusuna basip alert'i kapatin

            driver.switchTo().alert().dismiss();
            }

            @Test
            public void test02 (){
            //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
              driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            //- 2.alert'e tiklayalim
                driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();

                //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
                driver.switchTo().alert().dismiss();

                String expectedResult = "Cancel";
                String actualResult= driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
                Assert.assertTrue(actualResult.contains(expectedResult));
            }
            @Test
            public void test03 (){
                //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
                driver.get("https://the-internet.herokuapp.com/javascript_alerts");

                //- 3.alert'e tiklayalim
                driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();

                //- Cikan prompt ekranina "Koray" yazdiralim
                driver.switchTo().alert().sendKeys("Koray");

                //- OK tusuna basarak alert'i kapatalim
                driver.switchTo().alert().accept();

                //- Cikan sonuc yazisinin Koray icerdigini test edelim
                String actualResult = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
                String expectedResult = "Koray";
                Assert.assertTrue(actualResult.contains(expectedResult));
            }
}