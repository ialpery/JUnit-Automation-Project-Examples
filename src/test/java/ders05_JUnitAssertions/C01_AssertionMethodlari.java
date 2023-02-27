package ders05_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;

public class C01_AssertionMethodlari {

    int sayi = 2354 ;
    @Test
    public void test01(){
        Assert.assertTrue(sayi>100);

    }

    @Test
    public void test02(){
        Assert.assertEquals(0,sayi%2);
    }

    @Test
    public void test03(){
        Assert.assertTrue(sayi>99 && sayi < 1000);
    }

}
