package com.epam.training.task1.page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement pasteText;
    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationMenu;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationTenMinutes;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement titleInput;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createButton;


    public PastebinHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        PageFactory.initElements(webDriver, this);
    }

    public PastebinHomePage openHomePage() {
        webDriver.get(HOMEPAGE_URL);
        try {
            waitForElementsToLoad(pasteText);
        } catch (TimeoutException e) {
            throw new RuntimeException("The paste text area did not become visible within the expected time.", e);
        }
        return this;
    }

    public PastebinHomePage sendKeysToTextArea(String text) {
        pasteText.sendKeys(text);
        return this;
    }

    public PastebinHomePage clickExpirationMenu() {
        pasteExpirationMenu.click();
        return this;
    }

    public PastebinHomePage chooseExpirationTenMinutesOption() {
        waitForElementsToLoad(pasteExpirationTenMinutes).click();
        return this;
    }

    public PastebinHomePage inputPasteTitle(String title) {
        titleInput.sendKeys(title);
        return this;
    }

    public void clickCreateNewPaste() {
        createButton.click();
    }


    public void closeBrowser() {
        webDriver.quit();
    }

    public String retrieveText() {
        return pasteText.getAttribute("value");
    }

    public String retrieveTitle() {
        return titleInput.getAttribute("value");
    }

    private WebElement waitForElementsToLoad(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}

