package ders05_JUnitAssertions;

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

public class C04_AssertionsExample2 {

    /*
    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
        ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
        ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        Assert.assertEquals(driver.getTitle(),"YouTube");
    }

    @Test
    public void test02(){
        WebElement youtubeImage = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeImage.isDisplayed());
    }

    @Test
    public void test03(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test04(){
        Assert.assertNotEquals(driver.getTitle(),"youtube");
    }


}
