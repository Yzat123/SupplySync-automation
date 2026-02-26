package MastersPageTests;

import MastersPage.MastersPage;
import Utils.BaseUI;
import Utils.Driver;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateMasterTests extends BaseUI {

    //Login page
    WebDriver driver = Driver.getDriver();
    MastersPage mastersPage = new MastersPage();
    Faker  faker = new Faker();

    @Test
    public void createMasterTest(){

        driver.get("https://supplysync.us/");
        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        email.sendKeys("admin@codewise.com");
        password.sendKeys("codewise123");
        submit.click();

        waitAndClick(mastersPage.mastersTitle);

        waitAndClick(mastersPage.createMastersButton);
        clearAndSendKeys(mastersPage.mastersNameInput, faker.name().firstName());
        clearAndSendKeys(mastersPage.mastersLastNameInput, faker.name().lastName());
        String emailSaved = faker.name().firstName().toLowerCase()+"@gmail.com";
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
