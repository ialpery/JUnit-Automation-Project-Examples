package ders08_Actions_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class C02_KeyboardActionsTabButton_Faker extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {

        /*

        Bir tablo doldurulurken
        rastgele isim,soyisim,tel no,adres,şehir,şifre
        gibi bilgileri rastgele girmek istersek
        faker kütüphanesinden faydalanırız

        Bunun için öncelikle faker dependency'yi pom.xml'ekler
        ve kullanmak için de Faker classından bir obje oluştururuz

         */
        Faker faker = new Faker();

        // facebook sayfasına gidin
        driver.get("https://www.facebook.com");

        // yeni kayıt oluştur butonuna basın
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

        // Açılan formda tüm alanları doldurun
        WebElement firstname = driver.findElement(By.xpath("//*[@name='firstname']"));

        String mail = faker.internet().emailAddress();

        Actions actions = new Actions(driver);

        actions.click(firstname)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mail)
                .sendKeys(Keys.TAB)
                .sendKeys(mail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("Feb")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)

        // Kaydol tuşuna basın

                .sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);
    }
}
