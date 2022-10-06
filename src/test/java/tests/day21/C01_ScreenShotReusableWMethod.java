package tests.day21;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableWMethod {

    @Test
    public void test01() throws IOException {

        //hepsiburada sayfasına gidiniz
        //ve sayfanın resmini alınız
        //sayfayi kapatiniz

        Driver.getDriver().get("https://hepsiburada.com");
        ReusableMethods.getScreenshot("hepsiburada");
        Driver.closeDriver();

    }

    @Test
    public void test02() throws IOException {
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys("nutella", Keys.ENTER);
        ReusableMethods.getScreenshotWebElement("AramaSonucWeb", amazonPage.aramaSonucWE);
        Driver.closeDriver();


    }
}
