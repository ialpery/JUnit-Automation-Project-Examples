package ders09_cookies_webtables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseMethod;

import java.util.Set;

public class C01_Cookies extends TestBaseMethod {

    @Test
    public void test01(){

        // Yeni bir class olusturun : cookiesAutomation
        // 1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // 2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSeti =driver.manage().getCookies();

        int siraNo = 1;
        for (Cookie eachCookie: cookiesSeti){

            System.out.println(siraNo+" - "+ eachCookie);
            siraNo++;

        }
        // 3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSeti.size()>5);

        // 4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedDeger = "USD";
        String actualDeger = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedDeger, actualDeger);

        // 5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie eklenecekCookie = new Cookie("enSevdigimCookie", "cikolatali");
        driver.manage().addCookie(eklenecekCookie);


        // 6- eklediginiz cookie’nin sayfaya eklendigini test edin
        System.out.println("============");
        cookiesSeti =driver.manage().getCookies();

        siraNo = 1;
        for (Cookie eachCookie: cookiesSeti){

            System.out.println(siraNo+" - "+ eachCookie);
            siraNo++;

        }

        // 7- ismi skin olan cookie’yi silin ve silindigini test edin
        System.out.println("============");

        driver.manage().deleteCookieNamed("skin");
        cookiesSeti =driver.manage().getCookies();

        siraNo = 1;
        for (Cookie eachCookie: cookiesSeti){

            System.out.println(siraNo+" - "+ eachCookie);
            siraNo++;

        }


        // 8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        Assert.assertTrue(cookiesSeti.size()==0);

        }

    }




