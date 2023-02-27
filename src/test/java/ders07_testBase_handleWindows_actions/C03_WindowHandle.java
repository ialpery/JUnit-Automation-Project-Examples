package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

import java.util.Set;

public class C03_WindowHandle extends TestBaseMethod {

    @Test
    public void test01(){

        // https://the-internet.herokuapp.com/windows adrese gidin
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki yazinin "Opening a new window" oldugunu test edin
        WebElement yaziElementi = driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        String expectedText = "Opening a new window";
        String actualText = yaziElementi.getText();

        Assert.assertEquals(actualText,expectedText);

        String ilkWindowHandle = driver.getWindowHandle();


        // click here linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        /*

            -Burada switchTo kullanmadan, click here butonuna tıklayrak otomatik bir şekilde
         yeni bir taba geçiş yaptık.
            -Bu durumda driver otomatik olarak yeni sayfaya geçmez.
            Javadaki yöntemleri kullanarak 2. sayfanın windowHandle değerini bulmalıyız

            - getWindowhandles() iki sayfanın handle değerlerini Set olarak verir.
            - Set index desteklemediği için 2. wimdowHandleDeğerini direk alamayız.

            -Bir loop ile Set'i gözden geçirip ilk sayfanın windowHandleDeğerine eşit olmayan
          stringi ikinciSayfaWindowHandleDegeri olarak atalım.

         */

        Set<String> windowHandlesSeti = driver.getWindowHandles();
        String ikinciWindowHandleDegeri = "";

        for (String each:windowHandlesSeti){

            if (!each.equals(ilkWindowHandle)){
                ikinciWindowHandleDegeri = each;
            }

        }

        // ikinci sayfaya gecerek oradaki yazinin "New window" oldugunu test edin
        driver.switchTo().window(ikinciWindowHandleDegeri);
        WebElement newWindowText = driver.findElement(By.xpath("//h3[text()='New Window']"));
        String expectedNewText = "New Window" ;
        String actualNewText = newWindowText.getText();

        Assert.assertEquals(expectedNewText, actualNewText);

        // yeniden ilk sayfaya gecerek, url'in
        driver.switchTo().window(ilkWindowHandle);

        // "https://the-internet.herokuapp.com/windows" oldugunu test edin
        String expectedUrl = "https://the-internet.herokuapp.com/windows";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);

    }
}
