import com.airalo.HomePage;
import com.airalo.japan.JapanPackages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SeleniumTest {

    WebDriver driver;
    HomePage homePage;
    JapanPackages japanPackages;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver");
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
        japanPackages = PageFactory.initElements(driver, JapanPackages.class);
    }

    @Test
    public void openWebsite() throws InterruptedException {

        driver.get("https://www.airalo.com/");
        homePage.searchLocalRegions("Japan");
        japanPackages.selectNumberPackage(0);
        Assert.assertEquals(japanPackages.getSimTitle().getText(), "Moshi Moshi");
        Assert.assertEquals(japanPackages.getSimCoverageValue().getText(), "Japan");
        Assert.assertEquals(japanPackages.getSimDataCoverageValue().getText(), "1 GB");
        Assert.assertEquals(japanPackages.getSimDataValidityValue().getText(), "7 Days");
        Assert.assertEquals(japanPackages.getSimDataPriceValue().getText(), "4.50 €");

        //NOTE: The test is falling with the given information from the word document
        //getSimValidityValue is written as 7 days - expected 7 Days
        //getSimPriceValue is written as $4.50 - expected 4.50 €


    }
    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
