package BireyselCalisma02w;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class bireyselCalisma01 {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //  a. Verilen web sayfasına gidin. ""- https://facebook.com""
    //  b. Cookies’i kabul edin
    //  c. Create an account buton’una basin
    //  d. Radio button elementlerini locate edin ve size uygun olani secin
    //  e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public void terdown(){
        driver.close();
    }
    @Test
    public void test01 () throws InterruptedException {

        //  a. Verilen web sayfasına gidin. ""- https://facebook.com""
        driver.get("https://facebook.com");
        //b. Cookies’i kabul edin (Cookies çıkmamaktadır!!!!)
        //  c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();
        //Radio button elementlerini locate edin
        Thread.sleep(3000);
        WebElement radioButton1 = driver.findElement(By.xpath("//input[@value=\"1\"]"));
        WebElement radioButton2 = driver.findElement(By.xpath("//input[@value=\"2\"]"));
        WebElement radioButton3 = driver.findElement(By.xpath("//input[@value=\"-1\"]"));
        Thread.sleep(3000);
        //ve size uygun olani secin
        radioButton2.click();

        //   Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Thread.sleep(3000);
        Assert.assertFalse(radioButton1.isSelected());
        Assert.assertTrue(radioButton2.isSelected());
        Assert.assertFalse(radioButton3.isSelected());

    }

}
