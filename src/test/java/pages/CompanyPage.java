package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CompanyPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[text()='Branches']/..")
    private WebElement branchBtn;

    public void clickBranchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(branchBtn)).click();
    }
}