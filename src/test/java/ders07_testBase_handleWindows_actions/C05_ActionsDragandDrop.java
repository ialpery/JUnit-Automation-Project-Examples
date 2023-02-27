package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class C05_ActionsDragandDrop extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {

        // Yeni bir class olusturalim: MouseActions2
        // 1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropMe = driver.findElement(By.xpath("(//*[@class='drop-box ui-droppable'])[1]"));

        Actions actions =new Actions(driver);
        actions.dragAndDrop(dragMe, dropMe).perform();
        Thread.sleep(2000);

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedText = driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String expectedText = "Dropped!";
        String actualText = droppedText.getText();

        Assert.assertEquals(expectedText, actualText);


    }

}
