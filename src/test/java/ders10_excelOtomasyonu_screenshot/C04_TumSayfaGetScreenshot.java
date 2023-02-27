package ders10_excelOtomasyonu_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseMethod;

import java.io.File;
import java.io.IOException;

public class C04_TumSayfaGetScreenshot extends TestBaseMethod {

    @Test
    public void test01() throws IOException {

        // Amazona gidin
        driver.get("https://www.amazon.com");

        // Nutella aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        // Arama sonuçlarının Nutella içerdiğini test edin
        WebElement aramaSonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedIcerik = "Nutella";
        String actualSonucYazisi = aramaSonucYazisi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // rapora eklenmek üzere tüm sayfa fotoğrafını çekin

        // 1- obje oluşturalım, driverı cast ederek atayalım
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- dosyayı nerede ve hangi uzantı ile oluşturacaksak File classından bir obje oluşturup parametere olarak yazalım
        File tumSayfaScreenshot = new File("target/ekranresimleri/tumSayfa.png");

        // 3- tss objesini kullanarak fotografı çekip, geçici bir dosyaya atayalım
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4- geçici dosyayı, oluşturduğumuz tumSayfaScreenshota kopyalayalım
        FileUtils.copyFile(geciciDosya, tumSayfaScreenshot);


    }

}
