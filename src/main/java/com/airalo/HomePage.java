package com.airalo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@data-testid='search-input']")
    WebElement searchInput;
    @FindBy(xpath = "//p[text()='Local']/following::li[1]")
    WebElement localCountriesSelector;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void searchLocalRegions(String text) {
        searchInput.click();
        searchInput.sendKeys(text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Local']/following::li[1]")));
        localCountriesSelector.click();
    }


}
