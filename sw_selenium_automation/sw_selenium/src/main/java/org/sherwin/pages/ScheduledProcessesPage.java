package org.sherwin.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.sherwin.maps.ScheduledProcessesMap;
import org.sherwin.utilities.BaseCommands;
import org.testng.Assert;

import static org.sherwin.utilities.BaseCommands.takeScreenshot;
import static org.sherwin.utilities.BaseTest.driver;
import static org.sherwin.utilities.ListenersImplementation.test;

public class ScheduledProcessesPage {
    public static String scheduledProcessID;
    static ScheduledProcessesMap scheduledProcessesMap = new ScheduledProcessesMap();

    public static void viewScheduledProcessPage() {
        BaseCommands.findElement(scheduledProcessesMap.scheduledProcessOverview());
        BaseCommands.findElement(scheduledProcessesMap.scheduledProcessSearchResults());
        BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton());
    }

    public static void viewAllGenProcessState() throws InterruptedException {
        BaseCommands.findElement(scheduledProcessesMap.genAllProcessID());
        String status = BaseCommands.getText(scheduledProcessesMap.genAllProcessStatus());

        while (!(status.equals("Succeeded"))) {
            BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton());
            Thread.sleep(2000);
            status = BaseCommands.getText(scheduledProcessesMap.genAllProcessStatus());
            if (status.equals("Error")||status.equals("Blocked")) {
                String temp = takeScreenshot(driver);
                test.fail("Process failed to generate allocations", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
                Assert.fail();
            }
        }
        BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton());
        String ledgerBalanceStatus = BaseCommands.getText(scheduledProcessesMap.genLedgerAllocationProcessStatus());
        test.info("Allocate general ledger balance process status is " + ledgerBalanceStatus);
        test.info("Generate allocation process status is " + status);
    }

    public  static void viewAllGenLedgerProcessParentID(){
        BaseCommands.scrollToCenter(scheduledProcessesMap.genLedgerAllocationProcessId());
        String ledgerBalanceProcessID = BaseCommands.getText(scheduledProcessesMap.genLedgerAllocationProcessId());
        BaseCommands.addScreenShotInReport("Allocate general ledger balance process ID is " + ledgerBalanceProcessID,"temp");
        BaseCommands.refresh();
        BaseCommands.click(scheduledProcessesMap.genLedgerAllocationProcessId());
        BaseCommands.findElement(scheduledProcessesMap.parentIDValue());
    }

    public static void scheduleNewProcesses(String Name) {
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcesses());
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchDropdown());
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchButton());
        BaseCommands.sendKeys(scheduledProcessesMap.scheduledNewProcessesSearchName(), Name);
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchResultButton());
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchResult(Name));
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchResultOKButton());
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchResultOKConfirmButton());
    }

    public static void fillScheduleNewProcessDetails(String DataAccessSet, String Ledger, String LedgerCurrency, String CurrencyType, String AccountingPeriod, String AmountType, String SummarizeBy){
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.fillDataAccessSet(),DataAccessSet);
        BaseCommands.clear(scheduledProcessesMap.fillLedger());
        BaseCommands.sendKeys(scheduledProcessesMap.fillLedger(),Ledger);
        BaseCommands.sendKeys(scheduledProcessesMap.fillLedgerCurrency(),LedgerCurrency);
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.fillCurrencyType(),CurrencyType);
        BaseCommands.clear(scheduledProcessesMap.fillAccountingPeriod());
        BaseCommands.sendKeys(scheduledProcessesMap.fillAccountingPeriod(),AccountingPeriod);
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.fillAmountType(),AmountType);
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.fillSummarizeBy(),SummarizeBy);
    }

    public static void scheduleNewProcessedAdvanced(String Format){
        BaseCommands.click(scheduledProcessesMap.processDetailsAdvanced());
        BaseCommands.click(scheduledProcessesMap.processDetailsAdvancedOutput());
        BaseCommands.click(scheduledProcessesMap.processDetailsOutputAddButton());
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.outputFormatDropdown(),Format);
    }

    public static void scheduleNewProcessSubmit(){
        BaseCommands.click(scheduledProcessesMap.scheduleProcessSubmit());
        BaseCommands.findElement(scheduledProcessesMap.scheduleProcessConfirmPopUp());
        String ActualConfirmationMsg=BaseCommands.getText(scheduledProcessesMap.scheduleProcessConfirmDialogue());
        scheduledProcessID = ActualConfirmationMsg.substring(8, 15);
        String ExpectedConfirmationMsg= "Process " + scheduledProcessID +" was submitted.";
        BaseCommands.AssertEquals(ExpectedConfirmationMsg, ActualConfirmationMsg);
        BaseCommands.addScreenShotInReport("Submitted scheduled process ID is " +scheduledProcessID,"temp");
        BaseCommands.click(scheduledProcessesMap.scheduleProcessConfirmOKButton());
        BaseCommands.waitForElementInvisible(scheduledProcessesMap.scheduleProcessConfirmOKButton());
    }

    public static void viewTrialBalanceReportStatus() throws InterruptedException {
        while (true){
            while(BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton())){
                BaseCommands.findElement(scheduledProcessesMap.trialBalanceReportProcessId());
            }
            break;
        }
        String trialBalanceReportStatus=BaseCommands.getText(scheduledProcessesMap.trialBalanceReportProcessStatus());
        while (!(trialBalanceReportStatus.equals("Succeeded"))) {
            BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton());
            Thread.sleep(2000);
            trialBalanceReportStatus = BaseCommands.getText(scheduledProcessesMap.trialBalanceReportProcessStatus());
            if (trialBalanceReportStatus.equals("Error")||trialBalanceReportStatus.equals("Blocked")) {
                String temp = takeScreenshot(driver);
                test.fail("Process failed to generate trial balance report", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
                Assert.fail();
            }
        }
    }

    public static void downloadTrialBalanceReport() {
        BaseCommands.click(scheduledProcessesMap.trialBalanceReportProcessId());
        BaseCommands.switchToFrame(scheduledProcessesMap.trialBalanceReportFrame());
        BaseCommands.scrollToCenter(scheduledProcessesMap.trialBalanceReportOutput());
        BaseCommands.click(scheduledProcessesMap.trialBalanceReportOutput());
        BaseCommands.switchBackFromFrame();
    }
}
