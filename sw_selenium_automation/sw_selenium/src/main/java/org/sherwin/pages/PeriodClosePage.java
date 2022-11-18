package org.sherwin.pages;

import org.sherwin.maps.PeriodCloseMap;
import org.sherwin.utilities.BaseCommands;

import static org.sherwin.utilities.BaseTest.driver;

public class PeriodClosePage
{

    PeriodCloseMap SW_periodClose=new PeriodCloseMap();

    public void changeDataAccessInPeriodPage(String selectDataAccessSet)
    {
        BaseCommands.click(SW_periodClose.verifyDataAccess());
        BaseCommands.dropDownSelectByText(SW_periodClose.selectDataAccessSetFromFile(),selectDataAccessSet);
        BaseCommands.click(SW_periodClose.okBtnFromDataAccessSet());

    }


    public void navigateToMenageAccountPeriod()
    {
        driver.navigate().refresh();
        BaseCommands.waitForVisibilityOfElement(SW_periodClose.taskIconPeriodClose());
        BaseCommands.click(SW_periodClose.taskIconPeriodClose());
        BaseCommands.click(SW_periodClose.linkManageAccountingPeriod());
    }

}
