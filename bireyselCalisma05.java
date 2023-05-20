package BireyselCalisma02w;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class bireyselCalisma05 {
    //  https://www.amazon.com/ adresine gidin.
    //- Test 1
    //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //  1. Kategori menusunden Books secenegini  secin
    //  2. Arama kutusuna Java yazin ve aratin
    //  3. Bulunan sonuc sayisini yazdirin
    //  4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
        //  https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com");

        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement kategori = driver.findElement(By.xpath("//select[@data-nav-selected=\"0\"]"));
        Select select = new Select(kategori);
        List<WebElement> kategoriList = select.getOptions();

        int expectedResult = 45;
        int actualResult = kategoriList.size();
        Assert.assertEquals(expectedResult, actualResult);
        driver.close();
    }

    @Test
    public void test02() throws InterruptedException {
        //  1. Kategori menusunden Books secenegini  secin
        driver.get("https://www.amazon.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class=\"a-button-input\"][1]")).click();
        WebElement kategori = driver.findElement(By.xpath("//select[@title=\"Search in\"]"));
        Select select = new Select(kategori);
        select.selectByVisibleText("Books");
        //  2. Arama kutusuna Java yazin ve aratin

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        //  3. Bulunan sonuc sayisini yazdirin
        WebElement bulunanSonuc = driver.findElement(By.xpath("//div[@class=\"sg-col-inner\"][1]"));
        System.out.println(bulunanSonuc.getText());

        //  4. Sonucun Java kelimesini icerdigini test edin

        WebElement javaisThis = driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]"));
        String expectedResult = "Java";
        String actualResult = javaisThis.getText();
        Assert.assertTrue(expectedResult.contains(expectedResult));
        driver.close();
}
}