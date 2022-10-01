package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){ //Constructor olusturup public yapmamiz gerekir

        PageFactory.initElements(Driver.getDriver(),this);
       // this-> Driver class'indaki Driver.getDriver() 'i , Page class'indaki driver'a  esitledi/tanitti.


    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucWE;

}
