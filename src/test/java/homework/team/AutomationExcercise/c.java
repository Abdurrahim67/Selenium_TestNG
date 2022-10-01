package homework.team.AutomationExcercise;



import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

import java.time.Duration;

public class c extends TestBaseBeforeMethodAfterMethod {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    @Test
    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("[class='logo pull-left']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Alp");
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("alp1@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("123abc.1").perform();

        WebElement ddmDays= driver.findElement(By.xpath("//select[@id='days']"));
        Select select=new Select(ddmDays);
        select.selectByVisibleText("6");


        WebElement ddmMonths= driver.findElement(By.xpath("//select[@id='months']"));
        Select select2=new Select(ddmMonths);
        select2.selectByVisibleText("April");

        WebElement ddmyears= driver.findElement(By.xpath("//select[@id='years']"));
        Select select3=new Select(ddmyears);
        select3.selectByVisibleText("1995");


        //10. Select checkbox 'Sign up for our newsletter!'
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement we= driver.findElement(By.xpath("//input[@type='checkbox']"));

        jse.executeScript("arguments[0].scrollIntoView(true);",we);
        jse.executeScript("arguments[0].click()",we);
        Thread.sleep(2000);



        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@name='optin']")).click();



        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        Faker faker=new Faker();

        actions.sendKeys(Keys.TAB).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.company().name())
                .sendKeys(Keys.TAB).sendKeys(faker.address().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.address().lastName())
                .sendKeys(Keys.TAB).sendKeys("Canada")
                .sendKeys(Keys.TAB).sendKeys(faker.address().state())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys("123456").perform();
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    }
}
