package org.sherwin.maps;

import org.openqa.selenium.By;

public class HomePageMap
{
    public By clickOnArrow()
    {
        By clickOnArrow = By.cssSelector("#clusters-right-nav");
        return clickOnArrow;
    }
    public By generalAccounting()
    {
        By generalAccounting=By.cssSelector("#groupNode_general_accounting");
        return generalAccounting;

    }
    public By periodClose(){
        By periodClose = By.cssSelector("#itemNode_general_accounting_period_close_0");
        return periodClose;
    }
    public By navBar(){
        By navigatorIcon = By.cssSelector("a[title='Navigator']");
        return navigatorIcon;
    }

    public By generalAccountingFromNavigator(){
        By navigatorIcon = By.cssSelector("div[title='General Accounting']");
        return navigatorIcon;
    }

    public By generalAccountingJournals(){
        By navigatorIcon = By.xpath("//span[text()='Journals']");
        return navigatorIcon;
    }
    public By tools(){
        By tools = By.cssSelector("div[title='Tools']");
        return tools;
    }

    public By scheduledProcesses(){
        By scheduledProcesses = By.xpath("//span[text()='Scheduled Processes']");
        return scheduledProcesses;
    }

    public By reportAndAnalytics(){
        By scheduledProcesses = By.xpath("//span[text()='Reports and Analytics']");
        return scheduledProcesses;
    }



}
