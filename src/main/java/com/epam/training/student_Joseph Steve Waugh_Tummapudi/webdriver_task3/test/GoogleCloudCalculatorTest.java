package com.epam.training.webdriver_task3.test;

import com.epam.training.webdriver_task3.page.GoogleCloudEstimateSummaryPage;
import com.epam.training.webdriver_task3.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.webdriver_task3.page.GoogleCloudPage;
import com.epam.training.webdriver_task3.testdata.TestConstants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GoogleCloudCalculatorTest {
    private static GoogleCloudPage googleCloudPage;
    private GoogleCloudEstimateSummaryPage gcEstimateSummaryPage;
    private String estimatedCost;
    private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;

    @BeforeAll
    public static void setUp() {
        googleCloudPage = new GoogleCloudPage(new ChromeDriver());
    }

    @AfterAll
    public static void tearDown() {
        googleCloudPage.closeBrowser();
    }

    @Test
    @Order(1)
    public void testComputeEngineCostEstimationProcess() throws InterruptedException {
        googleCloudPricingCalculatorPage = googleCloudPage
                .openHomePage()
                .openSearchTextArea()
                .inputSearchText(TestConstants.TEXT_TO_SEARCH)
                .startSearch()
                .openLinkToCalculator()
                .pressAddToEstimate()
                .pressComputerEngine()
                .specifyInstancesNumber(TestConstants.NUMBER_OF_INSTANCES)
                .openOperatingSystemMenu()
                .chooseOperatingSystem()
                .openMachineFamilyMenu()
                .chooseGeneralPurpose()
                .openSeriesMenu()
                .chooseSeriesType()
                .openMachineTypeMenu()
                .chooseMachineType()
                .addGPU()
                .openGPUModelMenu()
                .chooseGPUModel()
                .openGPUsNumberMenu()
                .chooseGPUsAmount()
                .openSSDMenu()
                .chooseSSDType()
                .openRegionMenu()
                .chooseRegion();

        validatePriceCalculated();
        estimatedCost = googleCloudPricingCalculatorPage.getEstimatedCost();
        gcEstimateSummaryPage = googleCloudPricingCalculatorPage.pressShareButton()
                .openLinkEstimateSummary();
    }

    private void validatePriceCalculated() {
        assertTrue(googleCloudPricingCalculatorPage.isPriceCalculated());
    }

    @Test
    @Order(2)
    public void testNumberOfInstancesMatchesExpected() {
        assertEquals(String.valueOf(TestConstants.NUMBER_OF_INSTANCES),
                gcEstimateSummaryPage.retrieveNumberOfInstances());
    }

    @Test
    @Order(3)
    public void testOperatingSystemMatchesExpected() {
        assertEquals(TestConstants.OPERATING_SYSTEM,
                gcEstimateSummaryPage.retrieveOperatingSystemType());
    }

    @Test
    @Order(4)
    public void testProvisioningModelMatchesExpected() {
        assertEquals(TestConstants.PROVISIONING_MODEL,
                gcEstimateSummaryPage.retrieveProvisioningModel());
    }

    @Test
    @Order(5)
    public void testSeriesMatchesExpected() {
        assertEquals(TestConstants.SERIES,
                gcEstimateSummaryPage.retrieveSeriesType());
    }

    @Test
    @Order(6)
    public void testMachineTypeMatchesExpected() {
        assertEquals(TestConstants.MACHINE_TYPE,
                gcEstimateSummaryPage.retrieveMachineType());
    }

    @Test
    @Order(7)
    public void testAddGpuMatchesExpected() {
        assertEquals(String.valueOf(TestConstants.IS_GPU_ADDED),
                gcEstimateSummaryPage.IsGPUAdded());
    }

    @Test
    @Order(8)
    public void testGpuTypeMatchesExpected() {
        assertEquals(TestConstants.GPU_TYPE,
                gcEstimateSummaryPage.retrieveGPUType());
    }

    @Test
    @Order(9)
    public void testNumberOfGpusMatchesExpected() {
        assertEquals(String.valueOf(TestConstants.NUMBER_OF_GPUS),
                gcEstimateSummaryPage.retrieveNumberOfGPUs());
    }

    @Test
    @Order(10)
    public void testLocalSsdMatchesExpected() {
        assertEquals(TestConstants.LOCAL_SSD,
                gcEstimateSummaryPage.retrieveLocalSSDType());
    }

    @Test
    @Order(11)
    public void testDatacenterLocationMatchesExpected() {
        assertEquals(TestConstants.DATACENTER_LOCATION,
                gcEstimateSummaryPage.retrieveDatacenterLocation());
    }

    @Test
    @Order(12)
    public void verifyMatchingEstimatedCosts() {
        assertEquals(estimatedCost, gcEstimateSummaryPage.retrieveEstimatedCost());
    }

}
