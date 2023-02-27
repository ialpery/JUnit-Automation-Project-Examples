package ders03_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        // Berlini Boston'ın sağında tag'i img olan element şeklinde locate edelim
        WebElement bostonElementi = driver.findElement(By.xpath("//*[@id='pid6_thumb']"));
        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElementi));

        // Relative locatorlarla doğru çalıştığını test edin

        String actualIdDegeri = berlin1.getAttribute("id");
        String expectedIdDegeri = "pid7_thumb";

        if (actualIdDegeri.equals(expectedIdDegeri)){
            System.out.println("1. Berlin locate testi PASSED");
        }else{
            System.out.println("1. Berlin locate testi FAILED");
            System.out.println(actualIdDegeri);
        }
        // Berlini Sailor'in üstündeki diye tarif edelim. Bu sefer berlinin classname'ini kullanalım
        WebElement sailorElementi = driver.findElement(By.xpath("//*[@id='pid11_thumb']"));
        WebElement berlin2 = driver.findElement(RelativeLocator.with(By.className("ui-li-thumb")).above(sailorElementi));

        if (actualIdDegeri.equals(expectedIdDegeri)){
            System.out.println("2. Berlin locate testi PASSED");
        }else{
            System.out.println("2. Berlin locate testi FAILED");
            System.out.println(actualIdDegeri);
        }

        driver.close();
    }
}
