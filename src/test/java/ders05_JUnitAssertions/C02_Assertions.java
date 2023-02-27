package ders05_JUnitAssertions;

import org.junit.Test;

public class C02_Assertions {

    /*

     3 test methodu oluşturup class levelda verilen bir tam sayının
     - 100'den büyük olduğunu
     - çift sayı olduğunu
     - 3 basamaklı olduğunu test edin

     */

    int sayi = 2455;

    @Test
    public void test01(){

        if (sayi > 100){
            System.out.println("Sayı 100den büyük, 1. test PASSED");
        }else{
            System.out.println("Sayı 100den küçük, 1. test FAILED");
        }

    }

    @Test
    public void test02(){

        if (sayi % 2 == 0){
            System.out.println("Sayı çift, 2. test PASSED");
        }else{
            System.out.println("Sayı tek, 2. test FAILED");
        }

    }
    @Test
    public void test03(){

        if (sayi > 99 && sayi < 1000){
            System.out.println("Sayı 3 basamaklı, 3. test PASSED");
        }else{
            System.out.println("Sayı 3 basamaklı değil, 3. test FAILED");
        }

    }
    /*

    Testler çalıştığı sürece konsolda hep passed yazıyor.
    Daha sağlıklı bir test takibi için if yerine assertions kullanmak gerekiyor

     */


}
