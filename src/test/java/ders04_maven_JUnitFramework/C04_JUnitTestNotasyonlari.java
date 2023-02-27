package ders04_maven_JUnitFramework;

import org.junit.Test;

public class C04_JUnitTestNotasyonlari {

    // bir class içerisinde 3 test oluşturun
    //bu testleri istersek hep birlikte istersek de ayrı ayrı çalıştırabilelim

    /*  şimdiyer kadar hep main kethod içinde işlem yaptık ancak
        birden fazla method oluşturamayız.JUnitin bize sağladığı
        en büyük avantaj main method mecburiyetini ortadan kaldırmaktır
     */
    @Test
    public void test01(){
        System.out.println("test01 çalıştı");

    }


    @Test
    public void test02(){
        System.out.println("test02 çalıştı");

    }


    @Test
    public void test03(){
        System.out.println("test03 çalıştı");

    }
}
