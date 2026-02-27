package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BranchPage {

    WebDriver driver;
    WebDriverWait wait;

    public BranchPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Create Branch']")
    WebElement createBranchBtn;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@name='address']")
    WebElement addressInput;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneInput;

    @FindBy(xpath = "//input[@name='city']")
    WebElement cityInput;

    @FindBy(xpath = "//div[@id='mui-component-select-regionId']")
    WebElement selectRegionBtn;

    @FindBy(xpath = "//div[@id='mui-component-select-companyId']")
    WebElement selectCompanyBtn;

    @FindBy(xpath = "//input[@value='true']")
    WebElement radioShowToClientsTrue;

    @FindBy(xpath = "//button[text()='Create']")
    WebElement createBtn;

    @FindBy(xpath = "//*[@role='alert']")
    WebElement successText;

    /**
     * Создаёт филиал с 7 параметрами.
     */
    public void createBranchFunctionality(String name, String email, String address, String phoneNumber,
                                          String city, String regionVisibleText, String companyVisibleText) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(createBranchBtn)).click();


        wait.until(ExpectedConditions.visibilityOf(nameInput)).sendKeys(name);
        emailInput.sendKeys(email);
        addressInput.sendKeys(address);


        wait.until(ExpectedConditions.elementToBeClickable(phoneInput)).click();
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);

        cityInput.sendKeys(city);


        wait.until(ExpectedConditions.elementToBeClickable(selectRegionBtn)).click();
        WebElement regionOption = driver.findElement(
                org.openqa.selenium.By.xpath("//li[text()='" + regionVisibleText + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(regionOption)).click();


        wait.until(ExpectedConditions.elementToBeClickable(selectCompanyBtn)).click();
        WebElement companyOption = driver.findElement(
                org.openqa.selenium.By.xpath("//li[normalize-space()='" + companyVisibleText + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(companyOption)).click();


        radioShowToClientsTrue.click();


        wait.until(ExpectedConditions.elementToBeClickable(createBtn)).click();
    }

    public String getSuccessText(){
        return wait.until(ExpectedConditions.visibilityOf(successText)).getText().trim();
    }
}