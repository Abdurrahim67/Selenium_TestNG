package tests.practise07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
// http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
// Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
//Tüm yapılacakların üzerini çiz.
//Tüm yapılacakları sil.
//Tüm yapılacakların silindiğini doğrulayın.

    //EXPLORATORY testing demek kesif testing demek yani sayifayi manuel olarak tanima testidi


    @Test
    public void test01() throws InterruptedException {
        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");
        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)

        WebUniversityPage webUniversityPage=new WebUniversityPage();
        List<String> worklist=new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla","Bulaşıkları yıka","Bebekle ilgilen","Çocuğunun ödevine yardım et","Selenyum çalış","Uyu"));
        Actions actions=new Actions(Driver.getDriver());
        for (String w:worklist) {
           actions.click(webUniversityPage.adNewToDo).sendKeys(w).sendKeys(Keys.ENTER).perform();

        }

        //Tüm yapılacakların üzerini çiz.
        webUniversityPage.todosWebElement.forEach(WebElement::click);

        //Tüm yapılacakları sil.
        webUniversityPage.deleteButtons.forEach(WebElement::click);


        Thread.sleep(3000);
        //Tüm yapılacakların silindiğini doğrulayın.
        Assert.assertEquals(webUniversityPage.todosWebElement.size(),0);




    }
}
