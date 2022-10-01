package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {

    public HotelMyCampPage() {

        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy (xpath = "//*[@href='/Account/Logon']\n")
    public WebElement login;

    @FindBy(xpath = "//*[@id='UserName']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='Password']")
    public WebElement password;

    @FindBy(id="btnSubmit")
    public WebElement submit;

    @FindBy(xpath = "//*[text()='User Management']")
    public WebElement userManagemenet;

    @FindBy(xpath = "//*[text()=\"Try again please\"]")
    public WebElement tryAgainPlease;



}
