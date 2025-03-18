import com.airalo.HomePage;
import com.airalo.japan.JapanPackages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class SeleniumTest {

    WebDriver driver;
    HomePage homePage;
    JapanPackages japanPackages;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void openWebsite() {

        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.get("https://www.airalo.com/");
        homePage.searchLocalRegions("Japan");
        japanPackages = PageFactory.initElements(driver, JapanPackages.class);
        japanPackages.selectNumberPackage(1);

    }
    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
