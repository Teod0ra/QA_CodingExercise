import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void openWebsite() {
        driver.get("https://www.airalo.com/");

    }
}
