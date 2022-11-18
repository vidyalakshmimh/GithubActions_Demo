package org.sherwin.maps;

import org.openqa.selenium.By;

public class PeriodCloseMap
{

    public By verifyDataAccess()
    {
        By verifyDataAccess=By.xpath("//a [text()='Change']");
        return verifyDataAccess;
    }
    public By selectDataAccessSetFromFile()//use dropdown method
    {
        By selectDataAccessSet=By.xpath("//select[@id='pt1:_FOr1:1:_FONSr2:0:_FOTsr2:0:soc1::content']");
        return selectDataAccessSet;
    }
    public By okBtnFromDataAccessSet()
    {
        By okBtnFromDataAccessSet=By.xpath("(//button [text()='OK'])[1]");
        return okBtnFromDataAccessSet;
    }
    public By taskIconPeriodClose()
    {
        By taskIconPeriodClose=By.cssSelector("img[title='Tasks']");
        return taskIconPeriodClose;
    }
    public By linkManageAccountingPeriod()
    {
        By linkManageAccountingPeriod= By.xpath("//a[text()='Manage Accounting Periods']");
        return linkManageAccountingPeriod;
    }


}
