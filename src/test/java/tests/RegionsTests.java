package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProjectLoginPage;
import pages.RegionsPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

import java.time.Duration;

public class RegionsTests extends BaseUI {
    RegionsPage regionsPageProject = new RegionsPage();
    ProjectLoginPage projectLoginPage = new ProjectLoginPage();

    @BeforeEach
    public void setUp() {
        projectLoginPage.login(
                ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password")
        );

    }

    @AfterEach
    public void closeDriver() {
        Driver.closeDriver();
    }


    @Test
    public void shouldOpenRegionsModule() throws InterruptedException {
        waitAndClick(regionsPageProject.regions);
        waitUntilClickable(2, regionsPageProject.regions);
        Assertions.assertTrue(regionsPageProject.createRegion.isDisplayed());
        // click after is Displayed
        regionsPageProject.regions.click();
    }


    @Test
    public void shouldOpenCreateRegionModal() {
        waitAndClick(regionsPageProject.regions);
        waitAndClick(regionsPageProject.createRegion);


    }


    @Test
    public void shouldShowRegionInputField() {
        waitAndClick(regionsPageProject.regions);
        waitAndClick(regionsPageProject.createRegion);
        Assertions.assertTrue(regionsPageProject.inputRegion.isDisplayed());

    }

    @Test
    public void shouldShowCancelButton() {
        waitAndClick(regionsPageProject.regions);
        waitAndClick(regionsPageProject.createRegion);
        Assertions.assertTrue(regionsPageProject.createBtnInCreateRegionBtn.isDisplayed());
    }

    @Test
    public void shouldShowCreateButton() {
        waitAndClick(regionsPageProject.regions);
        waitAndClick(regionsPageProject.createRegion);
        Assertions.assertTrue(regionsPageProject.cancelBtnInCreateRegionBtn.isDisplayed());
    }

    @Test
    public void shouldEditRegionSuccessfully() {

        waitAndClick(regionsPageProject.regions);
        waitAndClick(regionsPageProject.editAndDeleteBtnForRegion);
        waitAndClick(regionsPageProject.editBtn);
        clearAndSendKeys(regionsPageProject.inputRegionByEdit, "Alaska");
        waitAndClick(regionsPageProject.saveBtn);

        WebDriverWait wait =
                new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(driver -> regionsPageProject.allRegionsInList.size() > 0);

        String expectedRegion = "Alaska";
        String actualRegion = regionsPageProject.allRegionsInList.get(0).getText();

        Assertions.assertEquals(expectedRegion, actualRegion, "Region name was not updated!");
    }


    @Test
    public void shouldDeleteRegionSuccessfully() {
        waitAndClick(regionsPageProject.regions);
        waitAndClick(regionsPageProject.editAndDeleteBtnForRegion);
        waitAndClick(regionsPageProject.deleteBtn);
        waitAndClick(regionsPageProject.deleteRegionBtn);

        WebDriverWait wait =
                new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        boolean isDeleted = wait.until(driver ->
                driver.findElements(By.xpath("//div[@class='region-name' and text()='Missouri']")).isEmpty()
        );
        Assertions.assertTrue(isDeleted, "Region was not deleted from the list!");
    }


}


