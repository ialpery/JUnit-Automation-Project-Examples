package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseMethod;

public class C01_testBaseIlkTest extends TestBaseMethod {  // inheritance

    @Test
    public void test01(){
        // amazona gidin
        driver.get("https://www.amazon.com");

        // amazona gittiğimizi test edelim
        String urlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(urlIcerik));


    }

}
