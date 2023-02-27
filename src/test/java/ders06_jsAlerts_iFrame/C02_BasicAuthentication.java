package ders06_jsAlerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BasicAuthentication {

    // 1- Bir class olusturun : BasicAuthentication
    // 2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    // 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    // 4- Html komutu : https://username:password@URL
    //     Username    : admin
    //     password     : admin
    // 5- Basarili sekilde sayfaya girildigini dogrulayin

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

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);

    }

    @Test
    public void test02(){

        WebElement message = driver.findElement(By.tagName("p"));

        Assert.assertTrue(message.getText().contains("Congratulations! You must have the proper credentials."));

    }

}
