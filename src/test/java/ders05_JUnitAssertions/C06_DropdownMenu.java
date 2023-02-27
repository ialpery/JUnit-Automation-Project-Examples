package ders05_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C06_DropdownMenu {
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

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusu yanındaki dropdown menüden Books seçeneğini seçin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(ddm);

        select.selectByVisibleText("Books");

        // seçtiğimiz optionı yazdırın

        System.out.println(select.getFirstSelectedOption().getText());


        // dropdown menüde toplam 28 option olduğunu test edin
        int ddmOptionSayisi = select.getOptions().size();

        Assert.assertEquals(28,ddmOptionSayisi);


    }

}
