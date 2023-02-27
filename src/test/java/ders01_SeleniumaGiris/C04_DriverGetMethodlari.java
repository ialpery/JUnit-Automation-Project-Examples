package ders01_SeleniumaGiris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        // Otomasyonun ilk adımı driver'ı oluşturmak ve bunun için gerekli ayarlari yapmaktir

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        /*
        Testimiz çalışırken birden fazla sayfa açılıyorsa hepsinin windowHandle değerini getirir.
        Bu windowHandle değerlerini kullanarak sayfalar arası geçişler yapabiliriz

        */
        Thread.sleep(5000);
        driver.close();
    }
}
