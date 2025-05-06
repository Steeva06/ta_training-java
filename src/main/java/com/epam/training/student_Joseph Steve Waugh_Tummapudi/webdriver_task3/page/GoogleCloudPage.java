package com.epam.training.webdriver_task3.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPage {
    private final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    @FindBy(xpath = "//div[@class='E65gw lDWUde']//div")
    private WebElement btnOpenSearch;
    @FindBy(xpath = "//input[@id='i4']")
    private WebElement txtSearch;
    @FindBy(xpath = "//i[@jsname='Z5wyCf']")
    private WebElement btnSearch;

    public GoogleCloudPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudPage openHomePage() {
        webDriver.get(HOMEPAGE_URL);
        try {
            waitUntilLoad(btnOpenSearch);
        } catch (TimeoutException e) {
            throw new RuntimeException("The button open search did not become visible within the expected time.", e);
        }
        return this;
    }

    public GoogleCloudPage openSearchTextArea() {
        btnOpenSearch.click();
        return this;
    }

    public GoogleCloudPage inputSearchText(String text) {
        txtSearch.sendKeys(text);
        return this;
    }

    public GoogleCloudSearchResultsPage startSearch() {
        btnSearch.click();
        return new GoogleCloudSearchResultsPage(webDriver, webDriverWait);
    }
    public void closeBrowser() {
        webDriver.quit();
        webDriver = null;
    }

    private void waitUntilLoad(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}

