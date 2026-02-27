package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BranchPage;
import pages.CompanyPage;
import pages.ProjectLoginPage;
import utils.BaseUI;
import utils.Driver;

public class BranchTest extends BaseUI {

    @Test
    public void validateBranchFunctionality() throws InterruptedException {

        ProjectLoginPage projectLoginPage = new ProjectLoginPage();
        projectLoginPage.login("admin@codewise.com", "codewise123");


        CompanyPage companyPage = new CompanyPage(Driver.getDriver(), wait);
        companyPage.clickBranchBtn();


        BranchPage branchPage = new BranchPage(Driver.getDriver(), wait);
        branchPage.createBranchFunctionality(
                "USA QA solutions",
                "usaqa@gmail.com",
                "2026 CodeWice driveway",
                "6574909000",
                "Dallas",
                "Texas",
                "CodeWise LLC."
        );


        Assertions.assertEquals("Branch successfully created", branchPage.getSuccessText());
        Assertions.assertEquals("https://supplysync.us/dashboard/branches?showCreate=false",
                Driver.getDriver().getCurrentUrl());
    }
}
