package BireyselCalisma02w;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class bireyselCalisma06 {

    @Test
    public void googleTest (){
        //google anasayfaya gidip, url'in google icerdigini test edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");
        String expectedResult = "google" ;
        String   actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));
        driver.close();
    }
    @Test
    public void wiseTest (){
        // wisequarter anasayfaya, gidip url'in wisequarter icerdigini test edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.wisequarter.com");
        String expectedResult = "wisequarter" ;
        String   actualResult = driver.getCurrentUrl();

        Assert.assertTrue(actualResult.contains(expectedResult));

        driver.close();
    }
    @Test
    public void amazonTest (){
        //amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(amazonLogo.isDisplayed());
        driver.close();
    }
}
