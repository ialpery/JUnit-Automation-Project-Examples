package ders04_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_zeroWebAPP {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        // 3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@name='user_login']")).sendKeys("username");
        // 4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        Thread.sleep(2000);
        // 6. Online banking menüsünden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
        Thread.sleep(2000);
        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("50");
        // 8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        // 9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        Thread.sleep(2000);
        // 10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement message = driver.findElement(By.xpath("//*[@id='alert_content']"));

        String expectedMessage = "The payment was successfully submitted.";
        String actualMessage = message.getText();


        if (expectedMessage.equals(actualMessage)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        driver.close();


    }
}
