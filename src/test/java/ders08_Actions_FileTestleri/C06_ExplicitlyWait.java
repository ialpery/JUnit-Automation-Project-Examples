package ders08_Actions_FileTestleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseMethod;

import java.time.Duration;

public class C06_ExplicitlyWait{
    // 1. Bir class olusturun : WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    // Iki metod icin de asagidaki adimlari test edin.

    @Test
    public void implicitlyWait(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneText = driver.findElement(By.xpath("//P[text()=\"It's gone!\"]"));

        Assert.assertTrue(itsGoneText.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackText = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));

        Assert.assertTrue(itsBackText.isDisplayed());

        driver.quit();



    }

    @Test
    public void explicitlyWait(){

        /*
         Esxplicitly wait sadece implicitly wait'in bekleme süresinden
         daha fazla zamana ihtiyaç duyan spesifik görevlerde kullanılır.

         IW ==> tüm sayfa ve tüm webelementler için geçerli maksimum bekleme süresi
         EW ==> sadece bir webelement ve tanımlanan tek bir işlem için geçerli olur.
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        WebElement itsGoneText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//P[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneText.isDisplayed());



        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        // 7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackText.isDisplayed());

        driver.quit();

    }

}
