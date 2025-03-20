package com.airalo.pages.japan;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class JapanPackages {
    static Logger log = Logger.getLogger(JapanPackages.class.getName());
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Wait<WebDriver> fluentWait;

    @FindBy(xpath = "//*[@id='store-title']")
    WebElement storeTitle;

    @FindBy(xpath = "//div[@data-testid='sim-detail-operator-title']")
    WebElement simTitle;

    @FindBy(xpath = "//ul[@data-testid='sim-detail-info-list']/descendant::p[@data-testid='COVERAGE-value']")
    WebElement simCoverageValue;

    @FindBy(xpath = "//ul[@data-testid='sim-detail-info-list']/descendant::p[@data-testid='DATA-value']")
    WebElement simDataCoverageValue;

    @FindBy(xpath = "//ul[@data-testid='sim-detail-info-list']/descendant::p[@data-testid='VALIDITY-value']")
    WebElement simDataValidityValue;

    @FindBy(xpath = "//ul[@data-testid='sim-detail-info-list']/descendant::p[@data-testid='PRICE-value']")
    WebElement simDataPriceValue;

    @FindAll(
            {
                    @FindBy(xpath = "//button[contains(text(),'BUY NOW')]")
            }
    )
    List<WebElement> buyNowButtons;

    public JapanPackages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMinutes(1))
                .pollingEvery(Duration.ofMillis(300));
    }

    public void selectNumberPackage(int number){
        log.info("Selecting " + number + " package");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        js.executeScript("arguments[0].scrollIntoView(true);", storeTitle);
        fluentWait.until(ExpectedConditions.elementToBeClickable(buyNowButtons.get(number)));
        buyNowButtons.get(number).click();
    }

    public WebElement getSimTitle(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Sim title is: " + simTitle.getText());
        return simTitle;
    }
    public WebElement getSimCoverageValue(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Sim coverage value is: " + simCoverageValue.getText());
        return simCoverageValue;
    }
    public WebElement getSimDataCoverageValue(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Sim data coverage value is: " + simDataCoverageValue.getText());
        return simDataCoverageValue;
    }
   public WebElement getSimDataValidityValue(){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Sim data validity value is: " + simDataValidityValue.getText());
        return simDataValidityValue;
   }
   public WebElement getSimDataPriceValue(){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Sim data price value is: " + simDataPriceValue.getText());
        return simDataPriceValue;
   }


}
