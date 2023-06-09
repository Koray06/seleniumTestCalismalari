package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilites.testBaseBeforeClass;

public class bireyselCalisma08 extends testBaseBeforeClass {
    /* 1- Bir class olusturun : BasicAuthentication
      2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
      3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
         Html komutu : https://username:password@URL
             Username    : admin
             password     : admin
      4- Basarili sekilde sayfaya girildigini dogrulayin */

    @Test
    public void test01(){
        //Bir class olusturun : BasicAuthentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

       String actualResult =  driver.findElement(By.tagName("p")).getText();
       String expectedResult = "Congratulations";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}