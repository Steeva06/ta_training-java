package com.epam.training.webdriver_task2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastePage {
    private WebDriver driver;
    private final WebDriverWait webDriverWait;
    private final String pastePageTitle;

    @FindBy(xpath = "//a[contains(@class, 'btn') and contains(@class, '-small')]")
    private WebElement syntaxHighlightingOption;
    @FindBy(xpath = "//div[@class='info-top']//h1")
    private WebElement pasteTitle;

    public PastePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        pastePageTitle = driver.getTitle();
    }

    public String getTextFromTextArea(String highlightingOption) {
        return driver.findElement(By.xpath(getXpathForTextArea(highlightingOption))).getText();
    }

    public String getPasteTitle() {
        return removeSuffixFromTitle();
    }

    public String getHighlightingOption() {
        return syntaxHighlightingOption.getText();
    }

    public PastePage waitForPageToLoad() {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(pasteTitle));
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to load the paste page within the expected time.", e);
        }
        return this;
    }

    public void closeBrowser() {
        driver.quit();
        driver = null;
    }

    
    private String removeSuffixFromTitle() {
        String suffix = " - Pastebin.com";
        return pastePageTitle.endsWith(suffix) ? pastePageTitle.substring(0, pastePageTitle.length() - suffix.length()) : pastePageTitle;
    }

    private String getXpathForTextArea(String className) {
        return String.format("//ol[@class='%s']", className);
    }

}

