package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseurl);  }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("anandp");
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        String expectedText = "Accounts Overview";
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.name("username")).sendKeys("anandp");
        driver.findElement(By.name("password")).sendKeys("invalidPassword");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        String expectedErrorMessage = "The username and password could not be verified.";
        String actualErrorMessage = driver.findElement(By.xpath("//p[@class='error']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        driver.findElement(By.name("username")).sendKeys("anandp");
        driver.findElement(By.name("password")).sendKeys("Password");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        driver.findElement(By.linkText("Log Out")).click();
        String expectedText = "Customer Login";
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedText, actualText);

    }
    @After
    public void teardown(){
        closeBrowser();
}


}
