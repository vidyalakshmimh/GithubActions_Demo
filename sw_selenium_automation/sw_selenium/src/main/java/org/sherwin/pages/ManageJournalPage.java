package org.sherwin.pages;

import org.sherwin.maps.ManageJournalMap;
import org.sherwin.utilities.BaseCommands;

public class ManageJournalPage {
    ManageJournalMap manageJournalMap = new ManageJournalMap();
    public void manageJournal(String journalBatch, String path){
        BaseCommands.sendKeys(manageJournalMap.journalBatchId(),journalBatch);
        BaseCommands.clear(manageJournalMap.perioddateId());
        BaseCommands.click(manageJournalMap.searchButtonId());
        BaseCommands.click(manageJournalMap.journallinkId());
        BaseCommands.click(manageJournalMap.attachImgId());
        BaseCommands.dropDownSelectByValue(manageJournalMap.fileTypeId(),"2");
        BaseCommands.click(manageJournalMap.urlfieldId());
        BaseCommands.sendKeys(manageJournalMap.urlfieldId(),"file:\\\\"+path);
        BaseCommands.click(manageJournalMap.okButtonId());
        BaseCommands.refresh();
        BaseCommands.click(manageJournalMap.saveButton());
    }
    public void navigateManageJournalPage(String Journal, String accountingPeriod)
    {
        BaseCommands.waitForVisibilityOfElement(manageJournalMap.fillJournalFromData());
        BaseCommands.sendKeys(manageJournalMap.fillJournalFromData(),Journal);
        BaseCommands.waitForElement(manageJournalMap.clearAccountingPeriod());
        BaseCommands.clear(manageJournalMap.clearAccountingPeriod());
        if(!(accountingPeriod.equalsIgnoreCase("blank"))){
            BaseCommands.sendKeys(manageJournalMap.clearAccountingPeriod(),accountingPeriod);
        }
        BaseCommands.click(manageJournalMap.searchBtn());
        BaseCommands.waitForElement(manageJournalMap.searchResult(Journal));
        BaseCommands.click(manageJournalMap.searchResult(Journal));

    }
}
