package org.sherwin.pages;

import org.sherwin.maps.HomePageMap;
import org.sherwin.utilities.BaseCommands;


public class HomePage
{
    HomePageMap homePageMap=new HomePageMap();

    public void openJournal(){
        BaseCommands.click(homePageMap.navBar());
        BaseCommands.click(homePageMap.generalAccountingFromNavigator());
        BaseCommands.click(homePageMap.generalAccountingJournals());
    }

    public void navigateToPeriodCloseFromHomePage()
    {
        BaseCommands.click(homePageMap.clickOnArrow());
        BaseCommands.click(homePageMap.generalAccounting());
        BaseCommands.waitForVisibilityOfElement(homePageMap.periodClose());
        BaseCommands.click(homePageMap.periodClose());
    }
    public void navigateToScheduledProcesses(){
        BaseCommands.click(homePageMap.navBar());
        BaseCommands.click(homePageMap.tools());
        BaseCommands.click(homePageMap.scheduledProcesses());
    }

    public void navigateToReportAndAnalytics(){
        BaseCommands.click(homePageMap.navBar());
        BaseCommands.click(homePageMap.tools());
        BaseCommands.click(homePageMap.reportAndAnalytics());
    }

}
