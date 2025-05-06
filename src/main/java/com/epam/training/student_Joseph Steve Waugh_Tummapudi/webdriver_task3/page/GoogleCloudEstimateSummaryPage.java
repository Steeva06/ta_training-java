package com.epam.training.webdriver_task3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudEstimateSummaryPage {
    private final WebDriverWait webDriverWait;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[10]")
    private WebElement txtInstancesNumber;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[11]")
    private WebElement txtOperatingSystem;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[12]")
    private WebElement txtProvisioningModel;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[3]")
    private WebElement txtMachineType;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[16]")
    private WebElement txtAddGPUs;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[5]")
    private WebElement txtGPUModel;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[6]")
    private WebElement txtGPUsNumber;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[7]")
    private WebElement txtLocalSSD;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[18]")
    private WebElement txtDatacenterLocation;
    @FindBy(xpath = "(//span[@class='Kfvdz'])[19]")
    private WebElement txtCommittedUsage;
    @FindBy(xpath = "//h4[@class='n8xu5 Nh2Phe D0aEmf']")
    private WebElement estimatedCost;

    public GoogleCloudEstimateSummaryPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    public String retrieveNumberOfInstances() {
        return waitUntilLoad(txtInstancesNumber).getText();
    }

    public String retrieveOperatingSystemType() {
        return txtOperatingSystem.getText();
    }

    public String retrieveProvisioningModel() {
        return txtProvisioningModel.getText();
    }

    public String retrieveMachineType() {
        return txtMachineType.getText();
    }

    public String IsGPUAdded() {
        return txtAddGPUs.getText();
    }

    public String retrieveGPUType() {
        return txtGPUModel.getText();
    }

    public String retrieveNumberOfGPUs() {
        return txtGPUsNumber.getText();
    }
    public String retrieveEstimatedCost(){
        return estimatedCost.getText();
    }


    public String retrieveLocalSSDType() {
        return txtLocalSSD.getText();
    }

    public String retrieveDatacenterLocation() {
        return txtDatacenterLocation.getText();
    }

    public String retrieveSeriesType() {
        return getSeriesFromMachineType().toUpperCase();
    }

    private String getSeriesFromMachineType() {
        String fullType = txtMachineType.getText();

        int dashIndex = fullType.indexOf('-');

        if (dashIndex != -1) {
            return fullType.substring(0, dashIndex);
        }

        return fullType;
    }

    private WebElement waitUntilLoad(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}

