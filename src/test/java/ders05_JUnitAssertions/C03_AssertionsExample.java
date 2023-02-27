package ders05_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionsExample {

    // 1) Bir class oluşturun: BestBuyAssertions
    // 2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // ○ logoTest => BestBuy logosunun görüntülendigini test edin
    // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver; // Hatırlatma : tüm methodlarda kullanabilmek için driver dışarda tanımlanır

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.bestbuy.com/");
    }

    @Test
    public void test02(){
        Assert.assertFalse(driver.getTitle().contains("Rest"));
    }

    @Test
    public void test03(){
        WebElement logo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test04(){
        WebElement franceLink = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(franceLink.isDisplayed());
    }

}
