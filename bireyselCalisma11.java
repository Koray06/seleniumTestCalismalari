package BireyselCalisma02w;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.testBaseBeforeClass;

import java.util.Set;

public class bireyselCalisma11 extends testBaseBeforeClass {
           /* ● https://the-internet.herokuapp.com/windows adresine gidin.
            ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            ● Click Here butonuna basın.
            ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            ● Sayfadaki textin “New Window” olduğunu doğrulayın.
            ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın. */

    @Test
    public void test01() throws InterruptedException {
       // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
       // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedResult  = "Opening a new window";
        String actualResult = driver.findElement(By.tagName("h3")).getText();
        System.out.println(actualResult);
        Assert.assertTrue(actualResult.equals(expectedResult));
        String ilkWindowsHandle = driver.getWindowHandle();


      //  Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedResult2 = "The Internet";
        String actualResult2 = driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertTrue(actualResult2.equals(expectedResult2));
        //Click Here butonuna basın.
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@target=\"_blank\"][1]")).click();

       Set<String> winowsHandles = driver.getWindowHandles();
       String ikinciWindowsHandle = "";
        for (String handlesEach:winowsHandles
             ) {
            if(!handlesEach.equals(ilkWindowsHandle)){
                ikinciWindowsHandle = handlesEach;
            }
        }
          driver.switchTo().window(ikinciWindowsHandle);

       // acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedResult3 = "New Window";
        String actualResult3 = driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertTrue(actualResult3.equals(expectedResult3));

       //Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedResult4  ="New Window";
        String actualResult4 = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(actualResult4.equals(expectedResult4));

       // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkWindowsHandle);
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));


    }
}
