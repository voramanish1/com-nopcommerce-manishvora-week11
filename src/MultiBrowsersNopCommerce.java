import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class MultiBrowsersNopCommerce {

    static String browser = "chrome";
    static String baseurl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
    static WebDriver driver;

    public static void main(String[] args) {
//1) Setup
        if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }

        //2) Launch Url
        driver.get(baseurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //2) Launch Url
        driver.get(baseurl);

        //3) Print the title of the page
        System.out.println("Title  of the page is " + driver.getTitle());

        //4)Print the current url
        System.out.println("Current url is " + driver.getCurrentUrl());

        //5) print the page source
        System.out.println(" Page source is " + driver.getPageSource());

        //6) Find and enter email field
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("jpmorgan@llc.com");

        //7) Find and enter password field
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("webdriver123");

        //8) Close the browser
        driver.quit();
    }
}

