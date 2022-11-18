package org.sherwin.maps;

import org.openqa.selenium.By;
import org.sherwin.pages.GenerateAllocationsPage;

import static org.sherwin.pages.GenerateAllocationsPage.processID;
import static org.sherwin.pages.ScheduledProcessesPage.scheduledProcessID;

public class ScheduledProcessesMap {

    public By scheduledProcessOverview(){
        By scheduledProcessOverview = By.cssSelector("div[title='Overview']");
        return scheduledProcessOverview;
    }

    public By scheduledProcessSearchResults(){
        By scheduledProcessSearchResults = By.cssSelector("div[title='Search Results']");
        return scheduledProcessSearchResults;
    }

    public By scheduledProcessRefreshButton(){
        By scheduledProcessRefreshButton = By.cssSelector("div[title='Refresh']");
        return scheduledProcessRefreshButton;
    }

    public By genAllProcessID(){
        By genAllProcessID = By.xpath("//span[text()='"+ GenerateAllocationsPage.processID +"']");
        return genAllProcessID;
    }

    public  By genAllProcessStatus(){
        By genAllProcessStatus = By.xpath("//*[contains(text(),'"+ processID +"')]//following::td[1]/span[1]");
        return genAllProcessStatus;
    }

    public By genLedgerAllocationProcessId(){
        By genLedgerAllocation= By.xpath("(//span[text()='Allocate General Ledger Balances']//following::span)[1]");
        return genLedgerAllocation;
    }

    public By genLedgerAllocationProcessStatus(){
        By genLedgerAllocation= By.xpath("(//span[text()='Allocate General Ledger Balances']//following::td[2]/span)[1]");
        return genLedgerAllocation;
    }


    public By parentIDValue(){
        By parentIDValue= By.xpath("//div[@class='af_showDetailItem']//td[text()='"+ processID +"']");
        return parentIDValue;
    }

    public By scheduledNewProcesses(){
        By scheduledNewProcesses=By.xpath("//span[text()='Schedule New Process']");
        return scheduledNewProcesses;
    }

    public By scheduledNewProcessesSearchName(){
        By scheduledNewProcessesSearchName=By.cssSelector("input[aria-label=' Name']");
        return scheduledNewProcessesSearchName;
    }
    public By scheduledNewProcessesSearchDropdown(){
        By scheduledNewProcessesSearchDropdown=By.cssSelector("a[title='Search: Name']");
        return scheduledNewProcessesSearchDropdown;
    }

    public By scheduledNewProcessesSearchButton(){
        By scheduledNewProcessesSearchButton=By.xpath("//a[text()='Search...']");
        return scheduledNewProcessesSearchButton;
    }

    public By scheduledNewProcessesSearchResultButton(){
        By scheduledNewProcessesSearchResultButton=By.xpath("//button[contains(@id,'_afrLovInternalQueryId::search')]");
        return scheduledNewProcessesSearchResultButton;
    }

    public By scheduledNewProcessesSearchResult(String Name){
        By scheduledNewProcessesSearchResult=By.xpath("//*[contains(@id,'_afrLovInternalTableId::db')]//span[text()='"+Name+"']");
        return scheduledNewProcessesSearchResult;
    }

    public By scheduledNewProcessesSearchResultOKButton(){
        By scheduledNewProcessesSearchResultOKButton=By.xpath("//button[contains(@id,'lovDialogId::ok')]");
        return scheduledNewProcessesSearchResultOKButton;
    }
    public By scheduledNewProcessesSearchResultOKConfirmButton(){
        By scheduledNewProcessesSearchResultOKConfirmButton=By.xpath("//button[contains(@id,'_FOTsr1:0:pt1:snpokbtnid')]");
        return scheduledNewProcessesSearchResultOKConfirmButton;
    }
    public By fillDataAccessSet(){
        By fillDataAccessSet=By.xpath("(//label[contains(text(),'Data Access Set')]//following::select)[1]");
        return fillDataAccessSet;
    }
    public By fillLedger(){
        By fillLedger=By.xpath("(//label[contains(text(),'Ledger')]//following::input)[1]");
        return fillLedger;
    }
    public By fillLedgerCurrency(){
        By fillLedgerCurrency=By.xpath("(//label[contains(text(),'Ledger Currency')]//following::select)[1]");
        return fillLedgerCurrency;
    }
    public By fillCurrencyType(){
        By fillCurrencyType=By.xpath("(//label[contains(text(),'Currency Type')]//following::select)[1]");
        return fillCurrencyType;
    }
    public By fillAccountingPeriod(){
        By fillAccountingPeriod=By.xpath("(//label[contains(text(),'Accounting Period')]//following::input)[1]");
        return fillAccountingPeriod;
    }
    public By fillAmountType(){
        By fillAmountType=By.xpath("(//label[contains(text(),'Amount Type')]//following::select)[1]");
        return fillAmountType;
    }
    public By fillSummarizeBy(){
        By fillSummarizeBy=By.xpath("(//label[contains(text(),'Summarize By')]//following::select)[1]");
        return fillSummarizeBy;
    }
    public By processDetailsAdvanced(){
        By processDetailsAdvanced=By.xpath("//span[text()='Advanced']");
        return processDetailsAdvanced;
    }
    public By processDetailsAdvancedOutput(){
        By processDetailsAdvancedOutput=By.xpath("(//a[text()='Output'][1])[1]");
        return processDetailsAdvancedOutput;
    }
    public By processDetailsOutputAddButton(){
        By processDetailsOutputAddButton=By.cssSelector("img[title='Add Output Document']");
        return processDetailsOutputAddButton;
    }
    public By outputFormatDropdown(){
        By outputFormatDropdown=By.xpath("//span[text()='Format']//following::select[2]");
        return outputFormatDropdown;
    }
    public By scheduleProcessSubmit(){
        By scheduleProcessSubmit=By.xpath("//span[text()='Sub']");
        return scheduleProcessSubmit;
    }
    public By scheduleProcessConfirmPopUp(){
        By scheduleProcessConfirmPopUp=By.cssSelector("div[id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:pt1:r1:0:r1:advRequestBtns:confirmationPopup:confirmSubmitDialog']");
        return scheduleProcessConfirmPopUp;
    }
    public By scheduleProcessConfirmDialogue(){
        By scheduleProcessConfirmDialogue=By.cssSelector("span[id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:pt1:r1:0:r1:advRequestBtns:confirmationPopup:pt_ol1'] label");
        return scheduleProcessConfirmDialogue;
    }
    public By scheduleProcessConfirmOKButton(){
        By scheduleProcessConfirmOKButton=By.xpath("//button[contains(@id,'advRequestBtns:confirmationPopup:confirmSubmitDialog::ok')]");
        return scheduleProcessConfirmOKButton;
    }
    public By trialBalanceReportProcessId(){
        By trialBalanceReportProcessId= By.xpath("(//*[text()='Trial Balance Report']/following::span)[1]");
        return trialBalanceReportProcessId;
    }
    public  By trialBalanceReportProcessStatus(){
        By trialBalanceReportProcessStatus = By.xpath("//*[contains(text(),'"+ scheduledProcessID +"')]//following::td[1]/span[1]");
        return trialBalanceReportProcessStatus;
    }
    public  By trialBalanceReportOutput(){
        By trialBalanceReportProcessStatus = By.xpath("//span[@class='dataLink' and text()='GLTRBAL Document1']");
        return trialBalanceReportProcessStatus;
    }
    public  By trialBalanceReportFrame(){
        By trialBalanceReportFrame = By.xpath("//iframe[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:pt1:processDetails:processDetails:r61:0:if1']");
        return trialBalanceReportFrame;
    }




}
