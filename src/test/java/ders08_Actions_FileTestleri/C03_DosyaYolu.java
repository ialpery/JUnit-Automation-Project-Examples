package ders08_Actions_FileTestleri;

import org.junit.Test;

public class C03_DosyaYolu {

    @Test
    public void test01(){

        /*

        Java, kişisel bilgisayarların farklılıklarından
        bağımsız bir dosya yolu oluşturmak için
        bize 2 kısa yol veriyor

         */

        System.out.println(System.getProperty("user.dir"));
        // içinde olduğumuz projenin dosya yolunu verir


        System.out.println(System.getProperty("user.home"));
        // kullandığımız bilgisayarın temel dosya yolunu verir

        /*

        Biz masaüstümüzdeki abc.txt dosyasına ait dosya yolunu yazarsak:
        /Users/ibrahimalperyigit/Desktop/abc.txt olur


        Downloadsdaki xyz.jpg dosyasının yolu:
        /Users/ibrahimalperyigit/Downloads/xyz.jpg olur

        Ancak bu yazım dinamik olmaz, sadece ibrahimalperyigit kullanıcısında çalışır
        Eğer dinamik yazmak istersek:

        /Users/ibrahimalperyigit/Desktop/abc.txt ==> System.getProperty("user.home") + "/Desktop/abc.txt"
        /Users/ibrahimalperyigit/Downloads/xyz.jpg ==> System.getProperty("user.home") + "/Downloads/xyz.jpg"

         */


    }
}
