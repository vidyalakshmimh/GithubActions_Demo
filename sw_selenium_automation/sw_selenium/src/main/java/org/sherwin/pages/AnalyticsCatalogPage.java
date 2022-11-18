package org.sherwin.pages;

import org.sherwin.maps.AnalyticsCatalogMap;
import org.sherwin.utilities.BaseCommands;

public class AnalyticsCatalogPage {
    AnalyticsCatalogMap analyticsCatalogMap=new AnalyticsCatalogMap();

    public void viewGenLedgerReport(){
        BaseCommands.switchToNewWindow();
        BaseCommands.click(analyticsCatalogMap.folderSharedFolder());
        BaseCommands.click(analyticsCatalogMap.sharedFolderCustom());
        BaseCommands.click(analyticsCatalogMap.sharedFolderSWCustom());
        BaseCommands.click(analyticsCatalogMap.sharedFolderFinancials());
        BaseCommands.click(analyticsCatalogMap.sharedFolderGenLedger());
        BaseCommands.click(analyticsCatalogMap.sharedFolderTrailBalance());
        BaseCommands.click(analyticsCatalogMap.sharedFolderTrialRevaluationReport());
        BaseCommands.click(analyticsCatalogMap.sharedFolderReportSchedule());

    }


}
