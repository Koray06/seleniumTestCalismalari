package BireyselCalisma02w;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class bireyselCalisma04 {
    //  https://the-internet.herokuapp.com/dropdown adresine gidin.
    //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //  4.Tüm dropdown değerleri(value) yazdırın
    //  5. Dropdown’un boyutunun 4 olduğunu test edin

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
        //  https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement menu = driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));
       Select select = new Select(menu);
       select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //  Tüm dropdown değerleri(value) yazdırın
        List<WebElement>tumDrobdownDegerler = select.getOptions();

        for (WebElement eachDrops: tumDrobdownDegerler
             ) {
            System.out.println(eachDrops.getText());
        }
        //  Dropdown’un boyutunun 4 olduğunu test edin
        System.out.println("==================");
        int expectedResult = 4;
        int actualResult = tumDrobdownDegerler.size();
        Assert.assertEquals(expectedResult,actualResult);
    }
}
