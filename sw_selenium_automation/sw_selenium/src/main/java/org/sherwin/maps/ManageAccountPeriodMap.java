package org.sherwin.maps;

import org.openqa.selenium.By;

public class ManageAccountPeriodMap
{
    public By selectLedgerFromLedgerTable(String ledgerName)
    {
        By selectLedgerFromLedgerTable=By.xpath("//table[@summary='Accounting Period Status Summary']//a//span[text()='"+ledgerName+"']");
        return selectLedgerFromLedgerTable;
    }
    public By clickOut()
    {
        By clickOut=By.xpath("//span[text()='All Ledgers']");
        return clickOut;
    }
}
