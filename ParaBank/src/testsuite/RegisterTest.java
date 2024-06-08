package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseurl);  }
    @Test
    public void testregister(){
        //click on the ‘Register’ link
        driver.findElement(By.linkText("Register")).click();
        String actualText = driver.findElement(By.cssSelector("h1")).getText();
        String expectedText = "Signing up is easy!";
        Assert.assertEquals("Verifying signup message",expectedText, actualText);
    }
    @Test
    public void testsigning(){
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Anand");
        driver.findElement(By.id("customer.lastName")).sendKeys("Patidar");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 big Bazar");
        driver.findElement(By.id("customer.address.city")).sendKeys("Harrow");
        driver.findElement(By.id("customer.address.state")).sendKeys("UK");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("HA00UU");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
        driver.findElement(By.id("customer.username")).sendKeys("anandp");
        driver.findElement(By.id("customer.password")).sendKeys("password");
        driver.findElement(By.id("repeatedPassword")).sendKeys("password");
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        String actualText = driver.findElement(By.cssSelector("p.title")).getText();
        Assert.assertEquals(actualText, "Your account was created successfully. You are now logged in.");
    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
