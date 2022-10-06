package tests.practise08;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuPage;
import utilities.Driver;

import java.util.List;

public class P01 {

    //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked


    HerokuPage herokuPage;
    Actions actions;
    //kodlarımızı yazrken clean kod kapsamında daha sade kod yazabilmek amacıyla
    //her test methodu içerisinde, ayrı bir object create temektense bu
    // objecti class seviyesinde instance olarak create edip
    //test methodlarında buna değer atamak ve kullanmak daha uygun bir yöntemdir

    @Test
    public void test01() {

        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        herokuPage = new HerokuPage();
        actions = new Actions(Driver.getDriver());


        herokuPage.onBlur.click();
        herokuPage.onClick.click();
        herokuPage.onClick.click();
        actions.contextClick(herokuPage.onContextMenu).
                doubleClick(herokuPage.onDoubleClick).
                click(herokuPage.onFocus).
                click(herokuPage.onKeyDown).sendKeys(Keys.ENTER).
                click(herokuPage.onKeyUp).sendKeys(Keys.ENTER).
                click(herokuPage.onKeyPress).sendKeys(Keys.ENTER).
                moveToElement(herokuPage.onMouseOver).
                moveToElement(herokuPage.onMouseLeave).
                moveToElement(herokuPage.onMouseOver).
                click(herokuPage.onMouseDown).perform();






    }

    @Test (dependsOnMethods ="test01" )
    public void test02()
    {
        Assert.assertEquals(herokuPage.eventTriggered.size(),11);


    }
}
