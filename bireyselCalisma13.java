package BireyselCalisma02w;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilites.testBase;

public class bireyselCalisma13 extends testBase {
          /*1- https://demoqa.com/droppable adresine gidelim
            2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
            3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin */

    @Test
    public void Test01() throws InterruptedException {
        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragElementi = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement dropElementi = driver.findElement(By.xpath("//div[@id=\"droppable\"][1]"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragElementi,dropElementi).perform();

        //  “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedElementi = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Thread.sleep(1000);
        String expectedResult = "Dropped";
        String actulaResult = droppedElementi.getText();
        System.out.println(droppedElementi.getText());
        Assert.assertTrue(actulaResult.contains(expectedResult));
    }
}
