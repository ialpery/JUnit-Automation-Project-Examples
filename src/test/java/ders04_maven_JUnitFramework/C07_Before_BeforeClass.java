package ders04_maven_JUnitFramework;

import org.junit.*;

public class C07_Before_BeforeClass {

    @BeforeClass
    public static void setupClass(){
        System.out.println("BeforeClass çalıştı");
    }
    @Before
    public void setupMethod(){
        System.out.println("Before Çalıştı");
    }

    @After
    public void teardownMethod(){
        System.out.println("After Çalıştı");
    }

    @AfterClass
    public static void teardownClass(){
        System.out.println("AfterClass çalıştı");
    }

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
