package ders03_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_TextleXpath {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // add element butonuna tıkla
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        Thread.sleep(2000);
        //delete butonunun görünür olduğunu test et
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        if (deleteButton.isDisplayed()){
            System.out.println("Delete butonu görünüyor, test PASSED");
        }else{
            System.out.println("Delete butonu görünmüyori test FAILED");
        }
        deleteButton.click();

        // add/remove elements yazısının görünür olduğunu test edin
        Thread.sleep(2000);
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add remove yazısı görünüyor, test PASSED");
        }else {
            System.out.println("Add remove yazısı görünmüyori test FAILED");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
