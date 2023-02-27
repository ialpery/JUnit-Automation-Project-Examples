package ders01_SeleniumaGiris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_IlkTest {
    public static void main(String[] args) {

        // gerekli ayarlamaları yapıp driverı oluşturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // amazon anasayfaya gittiğinizi test edin
        // Nasıl yapacağımız söylenmediği için kendi yöntemlerimizi kullanabiliriz
        String expectedMetin = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedMetin)){
            System.out.println("TEST PASSED");
            }
        else {
            System.out.println("Url istenen metni içermiyor, TEST FAILED");
        }

        driver.close();
    }
}
