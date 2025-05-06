package com.epam.training.webdriver_task3.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class GoogleCloudPricingCalculatorPage {

    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    @FindBy(xpath = "//span[@class='UywwFc-vQzf8d']")
    private WebElement btnAddToEstimate;
    @FindBy(xpath = "//div[@class='d5NbRd-EScbFb-JIbuQc PtwYlf']")
    private WebElement btnComputerEngine;
    @FindBy(xpath = "//*[@id='c13']")
    private WebElement txtInstancesNumber;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[4]")
    private WebElement menuOperatingSystem;
    @FindBy(xpath = "//div[contains(@class,'VfPpkd-TkwUic VfPpkd-ksKsZd-mWPk3d-OWXEXe-AHe6Kc-XpnDCe')]//div[1]")
    private WebElement operatingSystemItem;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[5]")
    private WebElement menuMachineFamily;
    @FindBy(xpath = "//li[@data-value='general-purpose']")
    private WebElement machineFamilyItemGeneral;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[6]")
    private WebElement menuSeries;
    @FindBy(xpath = "//li[@data-708c49e2-dcf0-4d62-b457-88577bfe3081='N1']")
    private WebElement seriesType;
    @FindBy(xpath = "//div[@jsname='kgDJk']//div[@class='VfPpkd-aPP78e']")
    private WebElement menuMachineType;
    @FindBy(xpath = "//li[@data-value='n1-standard-8']")
    private WebElement machineTypeItem;
    @FindBy(xpath = "//button[@aria-label='Add GPUs']//span[@class='eBlXUe-hywKDc']")
    private WebElement btnAddGPU;
    @FindBy(xpath = "//span[contains(text(),'GPU Model')]/../../following-sibling::div")
    private WebElement menuGPUModel;
    @FindBy(xpath = "//li[@data-value='nvidia-tesla-v100']")
    private WebElement gpuItemModel;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[9]")
    private WebElement menuGPUsNumber;
    @FindBy(xpath = "//li[@data-708c49e2-dcf0-4d62-b457-88577bfe3081='1']")
    private WebElement GPUsAmount;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[10]")
    private WebElement menuLocalSSD;
    @FindBy(xpath = "(//li[@data-value='2'])[2]")
    private WebElement ssdItem;
    @FindBy(xpath = "(//div[@class='VfPpkd-aPP78e'])[11]")
    private WebElement menuRegion;
    @FindBy(xpath = "//li[@data-value='europe-west4']")
    private WebElement regionItem;
    @FindBy(xpath = "//span[@class='FOBRw-vQzf8d']")
    private WebElement btnShare;
    @FindBy(xpath = "//a[text() = 'Open estimate summary']")
    private WebElement lnkEstimateSummary;
    @FindBy(xpath = "//label[@class='gt0C8e MyvX5d D0aEmf']")
    private WebElement estimatedCost;

    public GoogleCloudPricingCalculatorPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
        waitUntilLoad(btnAddToEstimate);
    }

    public GoogleCloudPricingCalculatorPage pressAddToEstimate() {
        btnAddToEstimate.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage pressShareButton() {
        btnShare.click();
        return this;
    }

    public String getEstimatedCost() {
        return estimatedCost.getText();
    }

    public GoogleCloudEstimateSummaryPage openLinkEstimateSummary() {
        waitUntilLoad(lnkEstimateSummary).click();
        switchToNextWindow();
        return new GoogleCloudEstimateSummaryPage(webDriver, webDriverWait);
    }

    private void switchToNextWindow() {
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String currentWindowHandle = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!currentWindowHandle.equals(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public GoogleCloudPricingCalculatorPage openOperatingSystemMenu() {
        menuOperatingSystem.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseOperatingSystem() {
        waitUntilLoad(operatingSystemItem).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage openMachineFamilyMenu() {
        menuMachineFamily.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage openSeriesMenu() {
        menuSeries.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseSeriesType() {
        waitUntilLoad(seriesType).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseGeneralPurpose() {
        waitUntilLoad(machineFamilyItemGeneral).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage specifyInstancesNumber(int number) {
        waitUntilLoad(txtInstancesNumber).clear();
        txtInstancesNumber.sendKeys(String.valueOf(number));
        return this;
    }

    public GoogleCloudPricingCalculatorPage openMachineTypeMenu() {
        menuMachineType.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage addGPU() {
        waitUntilLoad(btnAddGPU).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage openGPUModelMenu() {
        waitUntilLoad(menuGPUModel).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseGPUModel() {
        waitUntilLoad(gpuItemModel).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage openGPUsNumberMenu() {
        menuGPUsNumber.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseGPUsAmount() {
        waitUntilLoad(GPUsAmount).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage openSSDMenu() {
        menuLocalSSD.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseMachineType() {
        waitUntilLoad(machineTypeItem).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseSSDType() {
        waitUntilLoad(ssdItem).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage openRegionMenu() {
        menuRegion.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage chooseRegion() {
        waitUntilLoad(regionItem).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage pressComputerEngine() {
        waitUntilLoad(btnComputerEngine).click();
        return this;
    }

    public boolean isPriceCalculated() {
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(1500))
                .ignoring(NoSuchElementException.class);

        try {
            return wait.until(new Function<>() {
                private String lastSeenPrice = "";

                public Boolean apply(WebDriver driver) {
                    String currentPrice = estimatedCost.getText();
                    boolean isPriceCalculated = currentPrice.equals(lastSeenPrice);
                    lastSeenPrice = currentPrice;
                    return isPriceCalculated;
                }
            });
        } catch (TimeoutException e) {
            return false;
        }
    }

    private WebElement waitUntilLoad(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}

