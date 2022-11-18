package org.sherwin.maps;

import org.openqa.selenium.By;

public class AnalyticsCatalogMap {

    public By folderSharedFolder()
    {
        By folderSharedFolder= By.xpath("//span[@class='treeNodeDetails']//span[text()='Shared Folders']");
        return folderSharedFolder;
    }
    public By sharedFolderCustom()
    {
        By sharedFolderCustom= By.xpath("(//span[text()='Custom']//following::a)[1]");
        return sharedFolderCustom;
    }

    public By sharedFolderSWCustom()
    {
        By sharedFolderSWCustom= By.xpath("((//span[text()='SWCustom'])[last()])//following::a[1]");
        return sharedFolderSWCustom;
    }

    public By sharedFolderFinancials()
    {
        By sharedFolderFinancials= By.xpath("((//span[text()='Financials'])[last()])//following::a[1]");
        return sharedFolderFinancials;
    }

    public By sharedFolderGenLedger()
    {
        By sharedFolderGenLedger= By.xpath("(//span[text()='General Ledger'])[last()]//following::a[1]");
        return sharedFolderGenLedger;
    }
    public By sharedFolderTrailBalance()
    {
        By sharedFolderTrailBalance= By.xpath("(//span[text()='Trial Balance'])//following::a[1]");
        return sharedFolderTrailBalance;
    }
    public By sharedFolderTrialRevaluationReport()
    {
        By sharedFolderTrialRevaluationReport= By.xpath("(//span[text()='SWC Trial Balance Revaluation Report'])//following::a[2]");
        return sharedFolderTrialRevaluationReport;
    }
    public By sharedFolderReportSchedule()
    {
        By sharedFolderReportSchedule= By.xpath("//span[@class='contextMenuOptionText' and text()='Schedule']");
        return sharedFolderReportSchedule;
    }

}
