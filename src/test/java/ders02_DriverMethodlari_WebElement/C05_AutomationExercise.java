package ders02_DriverMethodlari_WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_AutomationExercise {
    public static void main(String[] args) {

        //1. Bir test class'ı oluşturalım

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. https://www.automationexercise.com adresine gidin
        driver.get("https://www.automationexercise.com");
        //3. Sayfada 147 adet link bulunduğunu test edin
        List<WebElement> linkElementleriListesi = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkElementleriListesi.size();

        if (expectedLinkSayisi == actualLinkSayisi) {
            System.out.println("Link sayısı testi PASSED");
        }else{
            System.out.println("Link sayısı testi FAILED");
        }
        // 4. Products linkine tıklayın
        WebElement productsLinki = driver.findElement(By.partialLinkText("Products"));
        productsLinki.click();
        // 5. Special offer yazısının göründüğünü test edin
        WebElement specialOfferElementi = driver.findElement(By.id("sale_image"));

        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special offer yazısı görünüyor, test PASSED");
        }else{
            System.out.println("Special offer yazısı görünmüyor, test FAILED");
        }
        // 6. Sayfayı kapatın
        driver.close();

    }
}
