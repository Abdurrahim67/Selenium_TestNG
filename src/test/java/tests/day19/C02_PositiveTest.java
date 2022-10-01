package tests.day19;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PositiveTest {

    //Bir Class olustur : PositiveTest
    //2) Bir test method olustur positiveLoginTest()  https://www.hotelmycamp.com/ adresine git  login butonuna bas
    //test data username: manager ,  test data password : Manager1!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et


    @Test
    public void test01() {

        // https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCamp"));
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.login.click();

        //test data username: manager ,  test data password : Manager1!
        String userName = ConfigReader.getProperty("userName");
        hotelMyCampPage.username.sendKeys(userName);
        String password = ConfigReader.getProperty("password");
        hotelMyCampPage.password.sendKeys(password);
        hotelMyCampPage.submit.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelMyCampPage.userManagemenet.isDisplayed());

        Driver.closeDriver();

}}
