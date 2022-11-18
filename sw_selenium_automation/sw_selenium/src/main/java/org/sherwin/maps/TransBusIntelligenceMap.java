package org.sherwin.maps;

import org.openqa.selenium.By;

public class TransBusIntelligenceMap {

    public By SWCTrialBalReport(){
        By SWCTrialBalReport= By.cssSelector("a[title='SWC Trial Balance Revaluation Report']");
        return SWCTrialBalReport;
    }

    public By SWCTrialBalReportMore(){
        By SWCTrialBalReportMore= By.xpath("//a[text()='SWC Trial Balance Revaluation Report']//following::a[2]");
        return SWCTrialBalReportMore;
    }
    public By SWCTrialBalReportMoreHistory(){
        By SWCTrialBalReportMoreHistory= By.xpath("//div[@class='ScrollablePanelContent']//div[@aria-label='History']");
        return SWCTrialBalReportMoreHistory;
    }


}
