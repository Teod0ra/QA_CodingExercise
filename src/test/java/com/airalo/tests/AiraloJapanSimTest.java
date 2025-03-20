package com.airalo.tests;

import com.airalo.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.testng.Assert;


public class AiraloJapanSimTest extends BaseTest {

    @Test
    public void japanSimValuesTest() {
        driver.get("https://www.airalo.com/");
        homePage.searchLocalRegions("Japan");
        japanPackages.selectNumberPackage(0);
        Assert.assertEquals(japanPackages.getSimTitle().getText(), "Moshi Moshi");
        Assert.assertEquals(japanPackages.getSimCoverageValue().getText(), "Japan");
        Assert.assertEquals(japanPackages.getSimDataCoverageValue().getText(), "1 GB");
        Assert.assertEquals(japanPackages.getSimDataValidityValue().getText(), "7 Days");
        Assert.assertEquals(japanPackages.getSimDataPriceValue().getText(), "4.50 €");

        //NOTE: The test is falling with the given information from the Word document
        //getSimValidityValue is written as 7 days - expected 7 Days
        //getSimPriceValue is written as $4.50 - expected 4.50 €

    }
}
