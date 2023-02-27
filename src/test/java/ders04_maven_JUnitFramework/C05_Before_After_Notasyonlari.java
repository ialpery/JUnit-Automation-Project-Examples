package ders04_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Before_After_Notasyonlari {

    /*
    3 farklı test methodu oluşturun,
    bu methodlarda amazon, wisequarter ve youtube anasayfasına gidip
    o sayfalara gittiğimizi test edin ve sayfayı kapatın
     */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");

        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Amazon Testi PASSED");
        }else{
            System.out.println("Amazon Testi FAILED");
        }
        driver.close();

    }


    @Test
    public void test02(){

        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wise Quarter Testi PASSED");
        }else{
            System.out.println("Wise Quarter Testi FAILED");
        }
        driver.close();


    }


    @Test
    public void test03(){


        driver.get("https://www.youtube.com");

        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube Testi PASSED");
        }else{
            System.out.println("Youtube Testi FAILED");
        }
        driver.close();

    }
}
