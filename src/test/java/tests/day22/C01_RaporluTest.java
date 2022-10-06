package tests.day22;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {


    // -https://www.bluerentalcars.com/ adresine git
    // -login butonuna bas
    // -test data user email: customer@bluerentalcars.com ,
    // -test data password : 12345 dataları girip login e basın
    // -login butonuna tiklayin
    // -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et


    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitf Test","Gecerli kullanici adi ve password ile giris yapildi");

        // -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Blue RentaCar sitesine gidildi");
        // -login butonuna bas
        BrcPage brcPage=new BrcPage();
        brcPage.login.click();
        extentTest.info("Login butonuna basildi");
        // -test data user email: customer@bluerentalcars.com ,
        brcPage.email.sendKeys(ConfigReader.getProperty("userEmail"));
        extentTest.info("Dogru kullanici email adresi girildi");
        // -test data password : 12345 dataları girip login e basın
        brcPage.password.sendKeys(ConfigReader.getProperty("pass"));
        extentTest.info("Dogru kullanici password'u girildi");
        // -login butonuna tiklayin
        brcPage.submit.click();
        extentTest.info("Login butonuna basildi");
        // -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName = brcPage.basariliGiris.getText();
        String expectedUserName = "John Walker";
        Assert.assertEquals(expectedUserName,actualUserName);
        extentTest.pass("Sayfaya basarili sekilde girildi");

/*
Hatanin resmini RAPORDA görmek istersek  target altinda Rapor icinde yazdirilan resmin uzernie sag tiklayin --->
Open in --> uzerine gelin -->  Explorer tiklayin bilgisayardaki dosyaninzin icine yönleneceksiniz
oradan raporu cift tiklayin acilan yeni sayfada alta kucuk resim var uzerini tiklayin
ve karsimiza resim cikmis olacak .

 */

    }
}
