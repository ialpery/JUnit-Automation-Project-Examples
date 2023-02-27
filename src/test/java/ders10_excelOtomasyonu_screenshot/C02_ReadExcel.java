package ders10_excelOtomasyonu_screenshot;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/test/java/ders10_excelOtomasyonu_screenshot/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        Cell istenenCell = workbook.getSheet("Sayfa1").getRow(0).getCell(1);
        System.out.println("1. satırdaki 2. cell :" + istenenCell);

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1Cell2Str = istenenCell.toString();

        // - 2.satir 4.cell’in afganistan’in baskentinin kabil oldugunu test edelim
        Cell satir2cell4Cell = workbook.getSheet("Sayfa1").getRow(1).getCell(3);
        String expectedResult = "Kabil";
        String actualResult = satir2cell4Cell.toString();
        Assert.assertEquals(expectedResult, actualResult);

        // - Satir sayisini bulalim
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()+1);
        // kullanılan son satırın indexini verir

        // - Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Fiziki kullanılan satır sayısı : "+workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());
        // boş olmayan satır sayısını verir


        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String, String> ulkeisimleriMap = new TreeMap<>();

        for (int i = 0; i<= workbook.getSheet("Sayfa1").getLastRowNum(); i++){

            String ulkeIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskentIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkeisimleriMap.put(ulkeIsmi, baskentIsmi);

        }
        System.out.println(ulkeisimleriMap);

        System.out.println(ulkeisimleriMap.get("Turkey"));
    }
}
