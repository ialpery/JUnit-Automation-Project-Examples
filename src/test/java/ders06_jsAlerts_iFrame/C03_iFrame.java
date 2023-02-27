package ders06_jsAlerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_iFrame {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown(){

        driver.close();

    }

    @Test
    public void test01() throws InterruptedException {

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        //     - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement baslikYazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(baslikYazisi.isEnabled());
        System.out.println(baslikYazisi.getText());

        //     - Text Box’a “Merhaba Dunya!” yazin.
        /*
        Gidilen bir web sayfasında aldığınız locate doğru olmasına rağmen
        webelementi kullanamıyorsanız bu web element bir iframein içinde
        olabilir.

        Bunu anlamak için kullanmak istediğiniz webelementin bir iframe'in
        child'i veya grandchild'ı olup olmadığını kontrol etmeliyiz

        Eğer kullanmak istediğimiz webelement bir iframe'in içinde ise
        önce o iframe'e switchto() ile geçmeliyiz

        Geçiş yapmak için iframe'i locate edip bir web element olarak kaydetmeliyiz

         */

        WebElement iframeElementi = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);

        WebElement textBoxElementi = driver.findElement(By.xpath("//*[@id='tinymce']"));
        Thread.sleep(3000);
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dünya");
        Thread.sleep(2000);

        //     - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        /*
        Bir önceki adımda iframe'e girmiştik şimdi tekrar çıkmamız gerekiyor.
         */
        // driver.switchTo().parentFrame();  bir üst frame'e geçiş için kullanılır.

        driver.switchTo().defaultContent(); // anasayfaya geçiş yapar.

        WebElement elementalSeleniumText = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumText.isEnabled());
        System.out.println(elementalSeleniumText.getText());

    }

}
