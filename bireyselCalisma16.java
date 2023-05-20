package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.testBaseBeforeClass;

import java.util.Set;

public class bireyselCalisma16 extends testBaseBeforeClass {
    /* ● https://the-internet.herokuapp.com/windows adresine gidin.
            ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            ● Click Here butonuna basın.
            ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            ● Sayfadaki textin “New Window” olduğunu doğrulayın.
            ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın. */

    @Test
    public void test01(){
       // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

       //  ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedResult = "Opening a new window";
        String actualResult  = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(actualResult.equals(expectedResult));

        //  Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle ="The Internet";
        String actualTitle  = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
       // ilk pencereyi terkettiğimiz durumlarda handle nı almayı unutmuyoruz.!!!!!
        String ilkWindowHandle = driver.getWindowHandle();

      //  ● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        // yukarıda click yapmaya mütrakip yan taba browser geçti ancak ben henüz driver ı yan taba
        //geçirmedim. önce onu geçirmeliyim.

        Set<String> windowsHandles = driver.getWindowHandles();
        String ikinciWindowsHandle ="";
        for (String eachHandles:windowsHandles
             ) {
            if(!eachHandles.equals(ikinciWindowsHandle)){
                ikinciWindowsHandle=eachHandles;
            }
        }
        driver.switchTo().window(ikinciWindowsHandle);
        // şuan driverım ikinci açılan windows handle değerinde n o yeni penceye geçti
        String expectedTitle2Windows = "New Window";
        String actualTitle2Windows = driver.getTitle();
        Assert.assertTrue(expectedTitle2Windows.equals(actualTitle2Windows));

      //  Sayfadaki textin “New Window” olduğunu doğrulayın.
       String  ExpectedText = "New Window";
       String actualText= driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        Assert.assertTrue(actualText.equals(ExpectedText));

       // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın

        driver.switchTo().window(ilkWindowHandle);
        String expectedTitle3 ="The Internet";
        String actualTitle3 = driver.getTitle();
        Assert.assertTrue(actualTitle3.equals(expectedTitle3));

    }

}
