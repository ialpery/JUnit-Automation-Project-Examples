package ders02_DriverMethodlari_WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DriverManagerMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // 15 saniye boyunca sürekli elementi arar bulunca direk devam eder.

        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        System.out.println("Maximum boyutta position" + driver.manage().window().getPosition());
        System.out.println("Maximum boyutta size" + driver.manage().window().getSize());

        driver.manage().window().fullscreen();
        System.out.println("Fullscreende position" + driver.manage().window().getPosition());
        System.out.println("Fullscreende size" + driver.manage().window().getSize());

        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(800,800));
        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(60, 50));
        Thread.sleep(5000);

        System.out.println("İstenen boyutta position" + driver.manage().window().getPosition());
        System.out.println("İstenen boyutta size" + driver.manage().window().getSize());

        driver.close();
    }
}
