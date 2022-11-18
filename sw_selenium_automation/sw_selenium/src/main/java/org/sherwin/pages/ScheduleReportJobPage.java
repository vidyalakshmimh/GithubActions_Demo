package org.sherwin.pages;

import org.sherwin.maps.ScheduleReportJobMap;
import org.sherwin.utilities.BaseCommands;

public class ScheduleReportJobPage {
    static ScheduleReportJobMap scheduleReportJobMap= new ScheduleReportJobMap();

    public void fillAndSubmitRevaluationReport(String LedgerSet,String AccountingPeriod, String LedgerName, String BalancingSegment, String LedgerCurrency, String AccountLevel) throws InterruptedException {
        BaseCommands.switchToFrame(scheduleReportJobMap.scheduleReportJobIframe());
        BaseCommands.switchToFrame(scheduleReportJobMap.scheduleReportGenIframe());
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerSetDropdown());
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerSet(LedgerSet));
        BaseCommands.click(scheduleReportJobMap.scheduleReportAccPeriodDropdown());
        BaseCommands.click(scheduleReportJobMap.scheduleReportAccPeriod(AccountingPeriod));
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerNameDropdown());
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerName(LedgerName));
        Thread.sleep(2000);
        BaseCommands.click(scheduleReportJobMap.scheduleReportBalSegmentDropdown());
        BaseCommands.click(scheduleReportJobMap.scheduleReportBalancingSegment(BalancingSegment));
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerCurrencyDropdown());
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerCurrency(LedgerCurrency));
        BaseCommands.click(scheduleReportJobMap.scheduleReportAccLevelDropdown());
        BaseCommands.click(scheduleReportJobMap.scheduleReportAccLevel(AccountLevel));
        BaseCommands.switchBackFromFrame();
        BaseCommands.switchToFrame(scheduleReportJobMap.scheduleReportJobIframe());
        BaseCommands.click(scheduleReportJobMap.scheduleReportSubmitBtn());
        BaseCommands.findElement(scheduleReportJobMap.scheduleReportVerifyParams(LedgerSet, LedgerName, LedgerCurrency, AccountingPeriod, AccountLevel,BalancingSegment));
        BaseCommands.sendKeys(scheduleReportJobMap.scheduleReportJobName(),"Job123");
        BaseCommands.click(scheduleReportJobMap.scheduleReportVerifyOKBtn());
        BaseCommands.switchBackFromFrame();
    }
    public void confirmAlertAndReturn(){
        BaseCommands.waitForAlert();
        BaseCommands.switchToAlertAccept();
        BaseCommands.click(scheduleReportJobMap.scheduleReportReturn());
    }
}
