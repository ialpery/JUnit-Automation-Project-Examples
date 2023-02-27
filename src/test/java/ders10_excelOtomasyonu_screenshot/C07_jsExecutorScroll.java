package ders10_excelOtomasyonu_screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class C07_jsExecutorScroll extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.wisequarter.com");
        Thread.sleep(2000);

        WebElement automationEngineer = driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", automationEngineer);

        jse.executeScript("alert('yaşasın');");
        Thread.sleep(2000);

    }

}
