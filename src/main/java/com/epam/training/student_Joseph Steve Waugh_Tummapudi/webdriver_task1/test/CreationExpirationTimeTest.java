package com.epam.training.webdriver_task1.test;

import com.epam.training.webdriver_task1.page.PastebinHomePage;
import com.epam.training.webdriver_task1.testdata.TestConstants;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreationExpirationTimeTest {
    private static PastebinHomePage pastebinHomePage;

    @BeforeAll
    public static void setUp() {
        pastebinHomePage = new PastebinHomePage(new ChromeDriver());
    }

    @AfterAll
    public static void tearDown() {
        pastebinHomePage.closeBrowser();
    }

    @Test
    public void pasteCreationTest() {
        pastebinHomePage.openHomePage()
                .sendKeysToTextArea(TestConstants.TEXT)
                .clickExpirationMenu()
                .chooseExpirationTenMinutesOption()
                .inputPasteTitle(TestConstants.TITLE);

        verifyInputsAreDisplayedCorrectly();

        pastebinHomePage.clickCreateNewPaste();
    }

    private void verifyInputsAreDisplayedCorrectly() {
        assertEquals(TestConstants.TEXT, pastebinHomePage.retrieveText());
        assertEquals(TestConstants.TITLE, pastebinHomePage.retrieveTitle());
    }

}

