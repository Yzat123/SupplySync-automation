package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class RegionsPage {

    WebDriver driver = Driver.getDriver();

    public RegionsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(., 'Create Region')]")
    public WebElement createRegion;

    @FindBy(xpath = "//input[@id='mui-2']")
    public WebElement inputRegion;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Create')]")
    public WebElement createBtnInCreateRegionBtn;

    @FindBy(xpath = "//button[@type='button' and contains(text(),'Cancel')]")
    public WebElement cancelBtnInCreateRegionBtn;

    @FindBy(xpath = "//div[@class = 'sc-cQMzAB eJBxEJ']//../button")
    public WebElement editAndDeleteBtnForRegion;

    @FindBy(xpath = "//li[text()='Edit']")
    public WebElement editBtn;

    @FindBy(xpath = "//li[text()='Delete']")
    public WebElement deleteBtn;

    @FindBy(id="mui-2")
    public WebElement inputRegionByEdit;

    @FindBy(xpath = "//button[text() = 'Save']")
    public WebElement saveBtn;

    @FindBy(xpath = "//button[text() ='Delete']")
    public WebElement deleteRegionBtn;

    @FindBy(xpath = "//button[text() ='Cancer']")
    public WebElement cancelBtn;

    @FindBy(xpath = "//span[contains(text(),'Regions')]")
    public WebElement regions;

    @FindBy(xpath = "//div[@class = 'sc-jnrVZQ jqxNun']/div")
    public List<WebElement> allRegionsInList;

    @FindBy(xpath = "//input[@placeholder='Region Name']")
    public WebElement inputRegionName;

    @FindBy(xpath = "//div[@class = 'sc-iUKqMP iwYPcx']")
    public WebElement errorMessage;


    }








