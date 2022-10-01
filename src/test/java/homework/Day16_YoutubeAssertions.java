package homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class Day16_YoutubeAssertions extends TestBaseBeforeClassAfterClass {
     //Odev

    //Priority
    //1) Bir class olusturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Asagidaki adlari kullanarak 4 test metodu olusturun ve gerekli testleri yapin

    //titleTest> Sayfa basliginin "YouTube" oldugunu test edin
    //imageTest> YouTube resminin goruntulendigini (isDisplayed()) test edin
    //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin


    @Test //->Priority default(0)
    public void goToYoutube() {

        //https://www.youtube.com adresine gidin
        driver.get("https://youtube.com");
    }

    @Test(priority = 1)
    public void titleTest() {

        //Sayfa basliginin "YouTube" oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        driver.findElement(By.xpath("//*[text()='Alle akzeptieren']")).click(); //->cookies


    }

    @Test(priority = 2)
    public void imageTest() {
        //YouTube resminin goruntulendigini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());


    }

    @Test(priority = 3)
    public void searchBoxTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//div//input[@id='search']")).isEnabled());

    }

    @Test(priority = 4)
    public void wrongTitleTest() {
        String expectedTitle = "youTube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(expectedTitle, actualTitle);

    }
}
