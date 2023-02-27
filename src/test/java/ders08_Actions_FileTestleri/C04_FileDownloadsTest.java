package ders08_Actions_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseMethod;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadsTest extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {

        // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // 3. logo.png dosyasını indirelim
        driver.findElement(By.linkText("logo.png")).click();
        Thread.sleep(5000);

        // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));



    }

}
