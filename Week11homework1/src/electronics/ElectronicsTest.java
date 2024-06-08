package electronics;

import browsertest.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ElectronicsTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";
    @Before
    public void setupTest() {
        openBrowser(baseURL);
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully(){
        Actions actions = new Actions(driver);
        WebElement electronicsMenu = driver.findElement(By.linkText("Electronics"));
        actions.moveToElement(electronicsMenu).perform();

        WebElement cellPhonesMenu = driver.findElement(By.linkText("Cell phones"));
        actions.moveToElement(cellPhonesMenu).click().perform();

        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Cell phones"));

        driver.findElement(By.className("product-viewmode-list")).click();
        driver.findElement(By.linkText("Nokia Lumia 1020")).click();

        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Nokia Lumia 1020"));
        assertEquals("$349.00", driver.findElement(By.className("price-value-20")).getText());

        WebElement quantityBox = driver.findElement(By.id("product_enteredQuantity_20"));
        quantityBox.clear();
        quantityBox.sendKeys("2");

        driver.findElement(By.id("add-to-cart-button-20")).click();
        assertTrue(driver.findElement(By.className("bar-notification")).getText().contains("The product has been added to your shopping cart"));

        driver.findElement(By.className("close")).click(); // Close the notification bar

        WebElement shoppingCartLink = driver.findElement(By.className("cart-label"));
        shoppingCartLink.click();

        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Shopping cart"));
        assertEquals("2", driver.findElement(By.className("qty-input")).getAttribute("value"));
        assertEquals("$698.00", driver.findElement(By.className("product-subtotal")).getText());

        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome, Please Sign In!"));

        driver.findElement(By.className("register-button")).click();
        assertTrue(driver.findElement(By.tagName("h1")).getText().contains(""));
    }
}
