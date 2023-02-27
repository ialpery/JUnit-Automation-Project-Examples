package ders06_jsAlerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_jsAlerts {

    static WebDriver driver;
    WebElement resultMessage = driver.findElement(By.xpath("//*[@id='result']"));

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @AfterClass
    public static void teardown(){

        driver.close();

    }

    @Test
    public void test01() throws InterruptedException {
        // ilk butona tıklayın
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);

        // ok diyerek alerti kapatın
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // ok butonuna basıldığını test edin
        Assert.assertEquals("You successfully clicked an alert", resultMessage.getText());

    }
    @Test
    public void test02() throws InterruptedException {
        // ikinci butona tıklayın
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);

        // alert üzerindeki yazının "I am a JS Confirm" olduğunu test edin"
        String actualAlertMessage = driver.switchTo().alert().getText();
        String expectedAlertMessage = "I am a JS Confirm";

        Assert.assertEquals(expectedAlertMessage, actualAlertMessage);


        // cancel diyerek alerti kapatın
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);


        // cancel butonuna tıklanıldığını kontrol edin
        Assert.assertEquals("You clicked: Cancel", resultMessage.getText());


    }
    @Test
    public void test03() throws InterruptedException {
        // üçüncü alert butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);

        // çıkan alert'e "Selenium heyecandır" yazdırın
        driver.switchTo().alert().sendKeys("Selenium heyecandır");
        Thread.sleep(2000);


        // OK butonuna basarak alert'i kapatın
        driver.switchTo().alert().accept();
        Thread.sleep(2000);


        //çıkan sonuç yazısının "Selenium heyecandır" içerdiğini kontrol edin.
        Assert.assertTrue(resultMessage.getText().contains("Selenium heyecandır"));
        Thread.sleep(1000);



    }



}
