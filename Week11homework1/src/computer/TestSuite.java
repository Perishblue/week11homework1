package computer;

import browsertest.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class TestSuite extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest() {
        openBrowser(baseURL);
    }

    @Test
    public void ProductArrangeInAlphaBaticalOrder() {
        driver.get("https://demo.nopcommerce.com/computers");
        driver.findElement(By.xpath("//a[text()=' Desktops ']")).click();
        driver.findElement(By.xpath("//option[text()='Name: Z to A']")).click();
    }

    @Test
    public void ProductAddedToShoppingCartSuccessFully() {
        driver.get("https://demo.nopcommerce.com/computers");
        driver.findElement(By.xpath("//a[text()=' Desktops ']")).click();
        driver.findElement(By.xpath("//option[text()='Name: A to Z']")).click();
        //driver.findElement(By.xpath("//div[contains(@class,'item-grid')]/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();
        driver.get("https://demo.nopcommerce.com/build-your-own-computer");
        driver.findElement(By.xpath("//option[text()='2.2 GHz Intel Pentium Dual-Core E2200']")).click();
        driver.findElement(By.xpath("//option[text()='8GB [+$60.00]']")).click();
        driver.findElement(By.xpath("//label[text()='400 GB [+$100.00]']")).click();
        driver.findElement(By.xpath("//label[text()='Vista Premium [+$60.00]']")).click();
        driver.findElement(By.xpath("//label[text()='Microsoft Office [+$50.00]']"));
        driver.findElement(By.xpath("//label[text()='Total Commander [+$5.00]']")).click();
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        driver.get("https://demo.nopcommerce.com/cart");
        driver.findElement(By.xpath("//div[@id='quantity-up-11222']")).click();
        //WebElement Qty =driver.findElement(By.xpath("//input[@class='qty-input']"));
        //Qty.sendKeys("2");

    }
}
