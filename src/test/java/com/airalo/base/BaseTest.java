package com.airalo.base;

import com.airalo.pages.HomePage;
import com.airalo.pages.japan.JapanPackages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
     protected WebDriver driver;
     protected HomePage homePage;
     protected JapanPackages japanPackages;

    @BeforeEach
    public void setUp() {
        //NOTE: In order to be faster I am only using chrome driver
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver");
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
        japanPackages = PageFactory.initElements(driver, JapanPackages.class);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
