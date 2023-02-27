package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class C06_ActionsMovetoElement extends TestBaseMethod {


    @Test
    public void test01(){

        // 1- https://www.amazon.com adresine gidin
        driver.get("https://www.amazon.com");
        // 2- Sağ üstte bulunan "Account & Lists" menüsünün açılması için mouse'u bu menünün üstüne getirin
        WebElement menu = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();

        // 3- "Create a List" butonuna basin
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        // 4- Açılan sayfada "Your Lists" yazısı olduğunu test edin
        WebElement yourListText = driver.findElement(By.xpath("//*[@role='heading']"));

        String expectedText = "Your Lists";
        String actualText = yourListText.getText();

        Assert.assertEquals(expectedText,actualText);

    }


}
