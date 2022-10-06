package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_SoftAssert extends TestBaseBeforeMethodAfterMethod {

    /*
SoftAssert baslangic ve bitis satirlari arasindaki tum assertion'lari yapip
bitis olarak belirtmemiz gereken assertAll() methoduyla test methodumuzdaki
butun assertion'lari kontrol eder. Failed olan olursa assertion yaptigimiz
methodun sonuna yazdigimiz mesaji bize konsolda verir.
 */


    @Test
    public void test01() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"), "Girdiğiniz kelimeyi içermiyor");
        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(), "WE erişilemez");
        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        //5-arama yapıldıgını test edin
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonuc.isDisplayed(), "SonucWE görüntülenemedi");
        Thread.sleep(3000);
        //6-arama sonucunun Nutella içerdigini test edin
        System.out.println(sonuc.getText());
        softAssert.assertTrue(sonuc.getText().contains("Nutella"), "Nutella içermiyor");
        softAssert.assertAll();
        System.out.println("Hata varsa burasi calismaz");
    }
}




