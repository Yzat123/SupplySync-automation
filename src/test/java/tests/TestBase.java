package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // путь к chromedriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://supplysync.us/login");
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
