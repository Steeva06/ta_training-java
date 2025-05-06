package com.epam.training.webdriver_task3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudSearchResultsPage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator']")
    private WebElement lnkCalculator;

    public GoogleCloudSearchResultsPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudPricingCalculatorPage openLinkToCalculator() {
        waitUntilLoad(lnkCalculator).click();
        return new GoogleCloudPricingCalculatorPage(webDriver, webDriverWait);
    }

    private WebElement waitUntilLoad(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}

