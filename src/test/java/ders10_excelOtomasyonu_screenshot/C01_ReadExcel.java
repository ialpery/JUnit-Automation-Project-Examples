package ders10_excelOtomasyonu_screenshot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        /*
        Excel dosyası fiziki olarak bilgisayarımızda
        Bizim kod ortamında online olarak bilgisayardaki bir dosya üzerinde çalışmamız mümkün değil

        Java bize ihtiyacımız olduğunda bilgisayarımızdaki fiziki bir dosyadaki bilgileri okuma,
        ve kod ortamımızdakn yolladığımız bilgilerle dosyayı update etme imkanı veriyor

        Bu sebeple, biz kod ortamımızda excel'in bir kopyasını oluşturup exceldeki tüm bilgileri,
        kopya excelimize kaydedeceğiz. Kod ortmımızda olduğundan kopya excel üzerinde istediğimiz işlemleri yapıp
        işimiz bittikten sonra excel dosyasını update etmek istersek kopya exceldeki tüm bilgileri, fiziki
        excel dosyamıza kaydederiz.
         */

        // 1- fiziki excel dosyasına java ile ulaşalım

        String dosyaYolu = "src/test/java/ders10_excelOtomasyonu_screenshot/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 2- Java ile ulaştığımız excel dosyasının bir kopyasını kod ortamımızda oluşturalım
        Workbook workbook = WorkbookFactory.create(fis);

        // 3- Bundan sonra excelin bir kopyasına sahibiz. Şimdi excelde birden fazla sayfa olabileceğinden
        //    ilgili sayfaya gitmeliyiz.

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(11);  // 12. satır
        Cell cell = row.getCell(3);  // 4. sütun

        System.out.println(cell);



    }

}
