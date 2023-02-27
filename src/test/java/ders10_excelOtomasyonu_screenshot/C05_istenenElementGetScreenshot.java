package ders10_excelOtomasyonu_screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

import java.io.File;
import java.io.IOException;

public class C05_istenenElementGetScreenshot extends TestBaseMethod {

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

        // rapora eklenmek üzere arama sonuç yazısının fotografını çekelim

        File istenenElement = new File("target/ekranResimleri/istenenElement.png");

        File geciciDosya = aramaSonucYazisi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya, istenenElement);


    }
}
