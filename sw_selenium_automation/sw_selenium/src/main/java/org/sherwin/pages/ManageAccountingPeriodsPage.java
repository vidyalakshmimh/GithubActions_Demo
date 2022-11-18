package org.sherwin.pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sherwin.maps.ManageAccountPeriodMap;
import org.sherwin.utilities.BaseCommands;

import java.time.Duration;

import static org.sherwin.utilities.BaseTest.driver;

public class ManageAccountingPeriodsPage
{
    ManageAccountPeriodMap SW_ManageAccPeriod=new ManageAccountPeriodMap();

    public void clickOnLedgerToModify(String LedgerName)
    {
        BaseCommands.click(SW_ManageAccPeriod.clickOut());
        BaseCommands.scrollToCenter(SW_ManageAccPeriod.selectLedgerFromLedgerTable(LedgerName));
        BaseCommands.click(SW_ManageAccPeriod.selectLedgerFromLedgerTable(LedgerName));
    }
}
