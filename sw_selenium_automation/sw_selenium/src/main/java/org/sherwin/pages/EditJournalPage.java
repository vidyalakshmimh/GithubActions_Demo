package org.sherwin.pages;

import com.aventstack.extentreports.Status;
import org.sherwin.maps.EditJournalMap;
import org.sherwin.utilities.BaseCommands;
import org.sherwin.utilities.BaseTest;


import static org.sherwin.utilities.ListenersImplementation.test;


public class EditJournalPage extends BaseTest
{
    EditJournalMap editJournalMap=new EditJournalMap();

    public void addNewJournal() throws InterruptedException {
        BaseCommands.scrollIntoView(editJournalMap.addJournalWithPlusIcon());
        BaseCommands.click(editJournalMap.addJournalWithPlusIcon());
        Thread.sleep(3000);

    }

    public void fillJournalDetails(String JournalAdd,String JournalDescription, String Ledger,String AccountingDate, String Category){
        BaseCommands.sendKeys(editJournalMap.addJournal(),JournalAdd);
        BaseCommands.sendKeys(editJournalMap.addDescription(),JournalDescription);
        BaseCommands.click(editJournalMap.addLedger());
        BaseCommands.click(editJournalMap.selectLedger(Ledger));
        BaseCommands.click(editJournalMap.okBtnFromWarningMessage());
        BaseCommands.waitForElementInvisible(editJournalMap.okBtnFromWarningMessage());
        BaseCommands.clear(editJournalMap.addAccountingDate());
        BaseCommands.sendKeys(editJournalMap.addAccountingDate(),AccountingDate);
        BaseCommands.sendKeys(editJournalMap.addCategory(),Category);
        BaseCommands.enter(editJournalMap.addCategory());

    }

    public void fillJournalLineDetails(String DebitAccount,String DebitAmount,String DebitDescription,String CreditAccount,String CreditAmount,String CreditDescription) throws InterruptedException {
        BaseCommands.click(editJournalMap.journalLine1());
        sendAccountDetails(DebitAccount);
        BaseCommands.sendKeys(editJournalMap.debitAmount(),DebitAmount);
        BaseCommands.sendKeys(editJournalMap.debitDescription(),DebitDescription);
        BaseCommands.click(editJournalMap.journalLine2());
        BaseCommands.click(editJournalMap.fillAccountDetailsJournalLine2());
        sendAccountDetails(CreditAccount);
        BaseCommands.sendKeys(editJournalMap.creditAmount(),CreditAmount);
        BaseCommands.sendKeys(editJournalMap.creditDescription(),CreditDescription);
        BaseCommands.scrollIntoView(editJournalMap.postJournal());
        BaseCommands.click(editJournalMap.postJournal());
        BaseCommands.click(editJournalMap.yesBtn());
        BaseCommands.waitForElementInvisible(editJournalMap.yesBtn());
        BaseCommands.addScreenShotInReport("Confirmation Message is:- "+BaseCommands.getText(editJournalMap.getConformationMessage()),"temp1");
        BaseCommands.click(editJournalMap.okBtnConformation());
        BaseCommands.waitForElementInvisible(editJournalMap.okBtnConformation());
  }

    public void sendAccountDetails(String accountDetails)  {
        String[] acc = BaseCommands.splitString(accountDetails);
        BaseCommands.click(editJournalMap.accountIcon());
        BaseCommands.waitForVisibilityOfElement(editJournalMap.interCompany());
        BaseCommands.sendKeys(editJournalMap.company(), acc[0]);
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[0]));
        BaseCommands.sendKeys(editJournalMap.profitCenter(), acc[1]);
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[1]));
        BaseCommands.sendKeys(editJournalMap.location(), acc[2]);
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[2]));
        BaseCommands.sendKeys(editJournalMap.account(), acc[3]);
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[3]));
        BaseCommands.sendKeys(editJournalMap.department(), acc[4]);
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[4]));
        BaseCommands.sendKeys(editJournalMap.brand(), acc[5]);
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[5]));
        BaseCommands.sendKeys(editJournalMap.interCompany(), acc[6]);
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[6]));
        BaseCommands.click(editJournalMap.accountSearch());
        BaseCommands.waitForElementInvisible(editJournalMap.interCompany());
        BaseCommands.click(editJournalMap.accountOkBtn());
        BaseCommands.waitForElementInvisible(editJournalMap.accountOkBtn());
    }

}
