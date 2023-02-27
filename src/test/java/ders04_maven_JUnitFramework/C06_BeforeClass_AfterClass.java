package ders04_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforeClass_AfterClass {

    /*
    3 farklı test methodu oluşturun
    1. methodda amazon anasayfaya gidip
    amazonda olduğunuzu test edin
    2. methodda arama kutusuna Nutella yazıp aratın
    ve sonuç yazısının Nutella içerdiğini test edin
    3. methodda ilk Nutella ürününe tıklayıp ürün
    isminin Nutella içerdiğini test edin
     */

    static WebDriver driver;

    /*
    JUnitte @Beforeclass ve @Afterclass notasyonlarının kullanıldığı methodlar
    static olmalıdır.
     */
    @BeforeClass
    public static void setup(){
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
    public void test01(){
        driver.get("https://www.amazon.com");

        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Amazon Testi PASSED");
        }else {
            System.out.println("Amazon Testi FAILED");
        }
    }
    @Test
    public void test02() throws InterruptedException {
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        Thread.sleep(3000);

        WebElement aramaSonucuKontrolu = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

        String expectedIcerik = "nutella";
        String actualIcerik = aramaSonucuKontrolu.getText();

        if (actualIcerik.contains(expectedIcerik)){
            System.out.println("Nutella arama testi PASSED");
        }else{
            System.out.println("Nutella arama testi FAILED");
        }
    }
    @Test
    public void test03(){

        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        ilkUrun.click();

        WebElement urunAdi = driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedUrunAdiIcerigi = "Nutella";
        String actualUrunAdi = urunAdi.getText();

        if (actualUrunAdi.contains(expectedUrunAdiIcerigi)){
            System.out.println("Ürün adı kontrolü PASSED");
        }else{
            System.out.println("Ürün adı kontrolü FAILED");
        }
    }
}
