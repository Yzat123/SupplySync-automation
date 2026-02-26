package tests;

import pages.MastersPage;
import pages.MastersPage;
import pages.ProjectLoginPage;
import utils.BaseUI;
import utils.Driver;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CreateMasterTests extends BaseUI {

    WebDriver driver;
    ProjectLoginPage projectLoginPage;
    MastersPage mastersPage = new MastersPage();
    Faker faker = new Faker();

    @Test
    public void createMasterTest() {

        Driver.getDriver();
        projectLoginPage.login("admin@codewise.com", "codewise123");

        waitAndClick(mastersPage.mastersTitle);

        waitAndClick(mastersPage.createMastersButton);
        clearAndSendKeys(mastersPage.mastersNameInput, faker.name().firstName());
        clearAndSendKeys(mastersPage.mastersLastNameInput, faker.name().lastName());
        String emailSaved = faker.name().firstName().toLowerCase() + "@gmail.com";
        clearAndSendKeys(mastersPage.mastersEmailInput, emailSaved);
        clearAndSendKeys(mastersPage.mastersPasswordInput, "123123");
        clearAndSendKeys(mastersPage.mastersPlaceOfResidenceInput, "CHI");
        waitAndClick(mastersPage.mastersNumberInput);
        mastersPage.mastersNumberInput.sendKeys("1231231234");
        mastersPage.selectRandomBranchFromDropdown();

        waitAndClick(mastersPage.masterSaveButton);
        waitUntilVisible(10, mastersPage.mastersEmailsTable);
        Assertions.assertTrue(mastersPage.verifyTheNewMasterIsCreated(emailSaved));
    }
}
