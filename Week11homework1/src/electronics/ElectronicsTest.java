package electronics;

import browsertest.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectronicsTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";
    @Before
    public void setupTest() {
        openBrowser(baseURL);
    }
    @Test
    public void UserShouldNavigateToCellPhonePageSuccessfully(){
    driver.findElement(By.xpath("//ul[contains(@class,'top-menu notmobile')]/li[2]/a")).click();
    driver.findElement(By.xpath("//a[text()=' Cell phones ']")).click();

    }
    @Test
    public void ThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully(){
        driver.findElement(By.xpath("//ul[contains(@class,'top-menu notmobile')]/li[2]/a")).click();
        driver.findElement(By.xpath("//a[text()=' Cell phones ']")).click();
        driver.findElement(By.xpath("//a[text()='List']")).click();
        driver.get("https://demo.nopcommerce.com/nokia-lumia-1020");
        driver.findElement(By.xpath("//div[contains(@class,'add-to-cart-panel')]/input")).clear();
        WebElement QTY = driver.findElement(By.xpath("//div[contains(@class,'add-to-cart-panel')]/input"));
        QTY.sendKeys("2");
        driver.findElement(By.xpath("//div[contains(@class,'add-to-cart-panel')]/button")).click();
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        driver.get("https://demo.nopcommerce.com/cart");
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        driver.findElement(By.xpath("//button[@class='button-1 register-button']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Perish");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Blue");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("davisnudas@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Bamania@3");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Bamania@3");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        driver.findElement(By.xpath("//option[text()='United Kingdom']")).click();
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Nuneaton");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("22 Short Street");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("WD25 7DP");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("0123589");
        driver.findElement(By.xpath("//div[contains(@id,'billing-buttons-container')]/button[2]")).click();


    }
}
