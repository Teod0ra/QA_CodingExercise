package com.airalo.japan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class JapanPackages {
    WebDriver driver;
    WebDriverWait wait;

    @FindBys(
            {
                    @FindBy(xpath = "//input[@data-testid='sim-package-item']")
            }
    )
    WebElement[] packages;

    @FindBys(
            {
                    @FindBy(xpath = "button[contains(text(),'BUY NOW')]")
            }
    )
    WebElement[] buyNowButtons;


    public JapanPackages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void selectNumberPackage(int number) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        buyNowButtons[number].click();
    }
}
