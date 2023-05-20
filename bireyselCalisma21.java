package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilites.testBase;

import java.util.Set;

public class bireyselCalisma21 extends testBase {

     /*   1- Amazon anasayfaya gidin
2- tum cookie’leri listeleyin
3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
6- eklediginiz cookie’nin sayfaya eklendigini test edin
7- ismi skin olan cookie’yi silin ve silindigini test edin
8- tum cookie’leri silin ve silindigini test edin */

    @Test
    public void test01(){
        //Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
       int siraNu = 1;
       for (Cookie eachCookie: cookieSet
             ) {
            System.out.println("Sıra NU " + siraNu +" : "+ eachCookie);
            siraNu++;

        }
       // Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int expectedResult = 5 ;
       int actualResult = cookieSet.size();
        Assert.assertTrue(actualResult>expectedResult);

        //ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        String expectedCookieNameValue = "USD";
        String actualCookieNameValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertTrue(actualCookieNameValue.equals(expectedCookieNameValue));

       // ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie eklenecekCokie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(eklenecekCokie);

        //eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies() ;
        int siraNu2 = 1;
        for (Cookie eachCookie: cookieSet
        ) {
            System.out.println("Sıra NU " + siraNu2 +" : "+ eachCookie);
            siraNu2++;
    }
        String expectedAddCookie = "cikolatali";
        String actualAddCookie = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertTrue(actualAddCookie.equals(expectedAddCookie));

       // ismi skin olan cookie’yi silin ve silindigini test edin

       // Cookie silinecekCokie = new Cookie("skin","noskin");
        driver.manage().deleteCookieNamed("skin");
       cookieSet = driver.manage().getCookies();
       int siraNu1 =1 ;
        String flag = "Skin isminde bir cookie yok";
       for (Cookie eachCokie1:cookieSet
             ) {
            if(eachCokie1.getName().equals("skin")){
                flag = "Skin isminde bir cookie bulundu";
            }
            siraNu1++;
        }
       Assert.assertTrue(flag.equals("Skin isminde bir cookie yok"));

        //tum cookie’leri silin ve silindigini test edin */
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
      Assert.assertEquals(cookieSet,0);
}
    }