package ders08_Actions_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class C05_FileUploadTest extends TestBaseMethod {

    @Test
    public void test01(){

        // 1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // 2.chooseFile butonuna basalim
        // 3.Yuklemek istediginiz dosyayi secelim.

        /*

        Selenium webdriver kullanır ve bu webdriver bilgisayarımızdaki
        dosyalara ulaşamaz.

        Ancak bunun yerine selenium yükleme yapabilmek için bize
        bir yöntem oluşturmuştur

         */

        //  -- önce yüklemek istediğimiz dosyanın yolunu oluşturalım
        String dosyaYolu = System.getProperty("user.home") + "/Downloads/logo.png";

        //  -- sonra chooseFile elementini locate edip oluşturduğumuz dosya yolu elementini sendKeys ile gönderelim
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys(dosyaYolu);

        // 4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        // 5.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement yuklendiText = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

        Assert.assertTrue(yuklendiText.isDisplayed());



    }

}
