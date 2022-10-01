package tests.day19;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_NegativeTest {

    //NegativeTest 3 Farkli test Methodunda 3 senaryoyu test et
    //- yanlisSifre
    //- yanlisKulllanici
    //- yanlisSifreKullanici
    //test data yanlis username: manager1 , yanlis password : manager1
    //2) https://www.hotelmycamp.com adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et
    //test data username: manager ,
    //test data password : Manager1!


    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void yanlisSifre() {
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        hotelMyCampPage.login.click();
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("userName"));
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("invalidPassword"));
        hotelMyCampPage.submit.click();
        softAssert.assertTrue(hotelMyCampPage.tryAgainPlease.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void yanlisKullanici() {

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        hotelMyCampPage.login.click();
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("invalidUserName"));
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("password"));
        hotelMyCampPage.submit.click();
        softAssert.assertTrue(hotelMyCampPage.tryAgainPlease.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void yanlisSifreKullanici() {

        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        hotelMyCampPage.login.click();
        hotelMyCampPage.username.sendKeys(ConfigReader.getProperty("invalidUserName"));
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("invalidPassword"));
        hotelMyCampPage.submit.click();
        softAssert.assertTrue(hotelMyCampPage.tryAgainPlease.isDisplayed());
        Driver.closeDriver();

    }


}

