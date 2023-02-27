package ders08_Actions_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class C01_KeyboardActions extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {

        /*

        Driver bir web sayfasına gittiğinde
        aşağı bölümlerde olduğu için görünmeyen
        bir elemente işlem yapmasını istersek
        işlem yapılacağını veya yapılamayacağını ÖNGÖREMEYİZ.

        Frontend developer'ın yazdığı kodlara göre işlem yapabildiğimiz
        sayfalar olabileceği gibi işlem yapamayacağımız sayfalar da olabilir.

        İşimizi garantiye almak istersek işlem yapacağımız
        webelemente kadar aşağı inmekte fayda var.

         */

        // wise quarter ana sayfaya gidin
        driver.get("https://www.wisequarter.com");

        // Java Test Automation Engineer menusune kadar asagi inin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);


        // menuye tıklayın.
        driver.findElement(By.xpath("(//img[@class='attachment-ecademy_810x545 size-ecademy_810x545 wp-image-5724'])[1]")).click();

        // Java test automation sayfasına tıkladığınızı test edin (urlden kontrol edelim)
        String expectedUrlIcerik = "automation-engineer";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));


    }

}
