package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openBrowser(String baseURL){
        driver = new ChromeDriver();
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println(title);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(450));
    }
    public void closeBrowser(){driver.quit();}
}
