package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseMethod;

public class C02_HandleWindows extends TestBaseMethod {

    @Test
    public void  test01() throws InterruptedException {
        // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella aratalım
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("nutella" + Keys.ENTER);
        Thread.sleep(2000);

        // Arama sonuçlarının nutella içerdiğini test edelim
        WebElement searchResultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedIcerik = "nutella";
        String actualResultText = searchResultText.getText();

        Assert.assertTrue(actualResultText.contains(expectedIcerik));

        /*
        Testimizde yeni windowa gidip geri bu windowa döneceğimiz için henüz bu windowdayken
        windowHandle değerini elde etmeliyiz.
         */

        String ilkSayfaWindowHandle = driver.getWindowHandle();

        // Yeni bir tabta yeniden amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        // Samsung aratalım
            // - arama kutusunu daha önce locate ettik fakat yeni bir tab açtığımız için tekrar değer atamalıyız

        searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("samsung" + Keys.ENTER);
        Thread.sleep(2000);

        // Arama sonuçlarının samsung içerdiğini test edelim
        searchResultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        expectedIcerik = "samsung";
        actualResultText = searchResultText.getText();

        Assert.assertTrue(actualResultText.contains(expectedIcerik));

        // Yeniden nutella arattığımız sayfaya geçip arama sonuçlarını yazdıralım
            /*

              - Daha önceden oluşturulmuş bir windowa geçmek için o windowsun windowHandle
                değerine ihtiyacımız var

             */

        driver.switchTo().window(ilkSayfaWindowHandle);
        Thread.sleep(2000);
        searchResultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(searchResultText.getText());





    }

}
