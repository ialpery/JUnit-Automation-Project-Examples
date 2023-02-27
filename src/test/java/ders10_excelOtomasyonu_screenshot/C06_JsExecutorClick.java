package ders10_excelOtomasyonu_screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class C06_JsExecutorClick extends TestBaseMethod {

    @Test
    public void test01(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButonu = driver.findElement(By.xpath("//button[text()='Remove']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", removeButonu);

    }

}
