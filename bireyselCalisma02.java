package BireyselCalisma02w;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class bireyselCalisma02 {
    // https://www.youtube.com adresine gidin
    // Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //   ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
    //   ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //   ○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
    //   ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01 (){
        // https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        // titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedResult = "YouTube";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult,actualResult);

        //   ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logoisDisplayed = driver.findElement(By.xpath("//yt-icon[@id=\"logo-icon\"][1]"));
        Assert.assertTrue(logoisDisplayed.isDisplayed());

        //   ○ Search Box’in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//input[@id=\"search\"]"));
        Assert.assertTrue(searchBox.isEnabled());

        //   ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedResult2 = "youtube";
        String actualResult2 = driver.getTitle();
        Assert.assertNotEquals(expectedResult2,actualResult2);
        driver.close();
    }

}
