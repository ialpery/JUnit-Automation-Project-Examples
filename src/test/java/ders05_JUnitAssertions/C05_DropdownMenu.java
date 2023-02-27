package ders05_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropdownMenu {

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
    public void dropdownTesti() throws InterruptedException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // arama kutusunun yanındakş dropdown menüden books seçeneğini seçin
        //  - önce dropdown menüyü locate edelim
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //  - Select classından bir obje oluşturup, parametre olarak locate ettiğimiz dropdown menüyü girelim
        Select select = new Select(ddm);
        //  - select objesini kullanarak istenen işlemi yapın
        select.selectByVisibleText("Books");

        // arama kutusuna java yazıp aratın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java" + Keys.ENTER);

        // arama sonuçlarının 1000den fazla olduğunu test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));

        // verilen bir metinden sayıyı alıp onu tam sayıya çevirmemiz için javadan
        // string manipılation methodlarını kullanırız.

        String sonucYazisiStr = sonucYazisi.getText();

        String[] sonucYaziArr = sonucYazisiStr.split(" ");

        String sonucSayisiStr = sonucYaziArr[3];
        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D", ""); // bu sayede sayı harici her şeyi kaldırdık

        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr);

        Assert.assertTrue(sonucSayisiInt > 1000);

        Thread.sleep(3000);

    }
}
