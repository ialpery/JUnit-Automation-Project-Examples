package ders01_SeleniumaGiris;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_ManuelYuklemeyleDriverOlusturma {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        /*
         Testleri otomatize etmek için 3 bileşeni kullanıyoruz

         1. Java
         2. Selenium
         3. IntelliJ
         4. Maven

        */
    }
}
