package computer;

import browsertest.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class TestSuite extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest() {
        openBrowser(baseURL);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]")).click();
        driver.findElement(By.xpath("//a[text()=' Desktops ']")).click();
        WebElement sortByNameZtoA = driver.findElement(By.id(("products-orderby")));
        Select select1 = new Select(sortByNameZtoA);
        select1.selectByVisibleText("Name: Z to A");
        String expectedText = "Build your own computer";
        String actualText = driver.findElement(By.xpath("//a[text()='Build your own computer']")).getText();
        Assert.assertEquals(actualText, expectedText);
        //driver.quit();
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]")).click();
        driver.findElement(By.xpath("//a[text()=' Desktops ']")).click();
        WebElement sortByNameAtoZ = driver.findElement(By.id(("products-orderby")));
        Select select2 = new Select(sortByNameAtoZ);
        select2.selectByVisibleText("Name: A to Z");
        driver.get("https://demo.nopcommerce.com/build-your-own-computer");
        String expectedText = "Build your own computer";
        String actualText = driver.findElement(By.xpath("//h1[text()='Build your own computer']")).getText();
        Assert.assertEquals(actualText,expectedText);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement dropDown1 = driver.findElement(By.id("product_attribute_1"));
        Select select3 = new Select(dropDown1);
        select3.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        WebElement dropDown2 = driver.findElement(By.id("product_attribute_2"));
        Select select4 = new Select(dropDown2);
        select4.selectByVisibleText("8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//label[text()='400 GB [+$100.00]']")).click();
        ////label[text()='400 GB [+$100.00]']
        //  Select select5 = new Select(dropDown3);
        //  select5.selectByVisibleText("400 GB [+$100.00]");

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        WebElement dropDown4=driver.findElement(By.name("product_attribute_4"));
        Select select6 = new Select(dropDown4);
        select6.selectByVisibleText("Vista Premium [+$60.00]");

        //A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]"
        WebElement dropDown5= driver.findElement(By.xpath("//dd[@id=product_attribute_input_5]/ul/li/input"));
        Select select7 = new Select(dropDown5);
        select7.selectByVisibleText("Microsoft Office [+$50.00]");

        driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
//new
        WebElement totalCommander = driver.findElement(By.id("product_attribute_5_12"));
        totalCommander.click();

        WebElement price = driver.findElement(By.id("price-value-1"));
        Assert.assertEquals(price.getText(), "$1,475.00");

        driver.findElement(By.id("add-to-cart-button-1")).click();

        WebElement successMessage = driver.findElement(By.className("bar-notification success"));
        Assert.assertTrue(successMessage.getText().contains("The product has been added to your shopping cart"));

        driver.findElement(By.className("close")).click();

        WebElement shoppingCartLink = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        shoppingCartLink.click();

        WebElement quantity = driver.findElement(By.className("qty-input"));
        quantity.clear();
        quantity.sendKeys("2");

        driver.findElement(By.name("updatecart")).click();

        WebElement totalPrice = driver.findElement(By.className("value-summary"));
        Assert.assertEquals(totalPrice.getText(), "$2,950.00");

        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

        WebElement welcomeSignIn = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        Assert.assertTrue(welcomeSignIn.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Checkout as Guest']")).click();
    }
}
