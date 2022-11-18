package org.sherwin.maps;
import org.openqa.selenium.By;
public class EditAccountPeriodMap
{
    public By currentAccountingPeriod()
    {
        By currentAccountingPeriod= By.xpath("(//table[@summary='Accounting Period Status']//tr)[2]");
        return currentAccountingPeriod;
    }
    public By clickOut()
    {
        By clickOut= By.xpath("//label[text()='Latest Open Period']");
        return clickOut;
    }
    public By clickOnOpenPeriodButton()
    {
        By clickOnOpenPeriodButton=By.xpath("//span[text()='Open Period']");
        return clickOnOpenPeriodButton;
    }
    public By successMessageBanner(){
        By successMessageBanner = By.xpath("//span[@class='text-normal-3 Apps3XLargeFontSize']");
        return successMessageBanner;
    }

    public By accountingPeriodStatus(){
        By accountingPeriodStatus = By.xpath("(//table[@summary='Accounting Period Status']//span[@class='x2hg'])[1]");
        return accountingPeriodStatus;
    }


    public By refreshButton()
    {
        By refreshButton=By.xpath("(//a[@role='button'])[6]");
        return refreshButton;
    }

    public By verifyStatus()
    {
        By verifyStatus=By.xpath("(//table[@summary='Accounting Period Status']//img[@alt='Open'])[2]");
        return verifyStatus;
    }
    public By editAccountPageDoneButton()
    {
        By editAccountPage_DoneButton= By.xpath("//span[text()='ne']");
        return editAccountPage_DoneButton;
    }
}

