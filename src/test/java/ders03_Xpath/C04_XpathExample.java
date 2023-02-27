package ders03_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_XpathExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        driver.navigate().refresh();
        Thread.sleep(3000);

        String expectedIcerik = "Spendless";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title'da aranan içerik yok, test FAILED");
        }

        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@alt='Birthday'])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-mini a-spacing-top-micro acs-product-block__product-image'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='gc-mini-picker-amount-1']")).click();
        Thread.sleep(3000);

        WebElement urunUcretElementi = driver.findElement(By.xpath("//span[@id='gc-live-preview-amount']"));

        String expectedUcret = "$25.00";
        String actualUcret = urunUcretElementi.getText();

        if (expectedUcret.equals(actualUcret)){
            System.out.println("Ücret testi PASSED");
        }else{
            System.out.println("Ücret beklenenden farklı, FAILED");
            System.out.println("Actual Ücret : " + actualUcret);

        }

    }
}
