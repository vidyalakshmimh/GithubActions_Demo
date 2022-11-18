package org.sherwin.pages;

import org.sherwin.maps.CreateJournalMaps;
import org.sherwin.utilities.BaseCommands;
import org.testng.Assert;

public class CreateJournalsPage {
    CreateJournalMaps createJournalMap = new CreateJournalMaps();
    public void sendJournalBatchData(String journalBatch, String journalBatchDescription, String accountinPeriod) throws InterruptedException {
       //Thread.sleep(2000);
        //BaseCommands.waitForPageLoad(createJournalMap.journalBatch());
        BaseCommands.sendKeys(createJournalMap.journalBatch(), journalBatch);
        BaseCommands.sendKeys(createJournalMap.journalBatchDescription(), journalBatchDescription);
        if (accountinPeriod != "") {
            BaseCommands.click(createJournalMap.accountingPeriod());
            BaseCommands.click(createJournalMap.accountingPeriodDropdown(accountinPeriod));
            Thread.sleep(2000);
            if (BaseCommands.isElementDisplayed((createJournalMap.warningOk()))) {
                BaseCommands.click(createJournalMap.warningOk());
                BaseCommands.waitForElementInvisible(createJournalMap.warningOk());
            }
        }
    }

    public void sendjournalData(String journal, String journalDesc, String ledger, String legalEntity, String category, String currency) throws InterruptedException {
        BaseCommands.sendKeys(createJournalMap.journal(), journal);
        BaseCommands.sendKeys(createJournalMap.journalDescription(), journalDesc);
        BaseCommands.click(createJournalMap.ledger());
        BaseCommands.click(createJournalMap.ledgerDropDown(ledger));
        Thread.sleep(2000);
        if (BaseCommands.isElementDisplayed((createJournalMap.warningOk()))) {
            BaseCommands.click(createJournalMap.warningOk());
            BaseCommands.waitForElementInvisible(createJournalMap.warningOk());
//            BaseCommands.waitForElementInvisible(createJournalMap.legalEntityName());
        }

        if(BaseCommands.isElementDisplayed(createJournalMap.legalEntityName()))
        {
            BaseCommands.click(createJournalMap.legalEntityName());
            BaseCommands.click(createJournalMap.legalEntityNameDropDown(legalEntity));
        }
//        Thread.sleep(2000);
        BaseCommands.click(createJournalMap.category());
        BaseCommands.clickUsingJS(createJournalMap.categoryDropDown(category));

        if (currency != "") {
            BaseCommands.click(createJournalMap.currency());
            System.out.println(currency);
            BaseCommands.click(createJournalMap.currencyValue(currency));
        }


    }

    public void sendJournalLinesData(String debitAccount, String debit, String debitDesc, String creditAccount, String creditAmmount, String creditDesc,String category) throws InterruptedException {
        //String category
        //String[] acc = BaseCommands.splitString(debitAccount);
        sendAccountDetails(debitAccount);
        BaseCommands.sendKeys(createJournalMap.debit(), debit);
        BaseCommands.sendKeys(createJournalMap.debitDesc(), debitDesc);
       // Thread.sleep(2000);
        BaseCommands.click(createJournalMap.newRow());
        //Thread.sleep(2000);
        //BaseCommands.waitForElementVisible(createJournalMap.accountIcon());
        BaseCommands.click(createJournalMap.secondLine());
       // acc = BaseCommands.splitString(creditAccount);
        sendAccountDetails(creditAccount);
        BaseCommands.sendKeys(createJournalMap.creditAmount(), creditAmmount);
        BaseCommands.sendKeys(createJournalMap.creditDesc(), creditDesc);
        BaseCommands.click(createJournalMap.category());
        BaseCommands.clickUsingJS(createJournalMap.categoryDropDown(category));
        BaseCommands.click(createJournalMap.saveButton());BaseCommands.click(createJournalMap.completeButton());
        BaseCommands.staleWait(createJournalMap.postButton());
        BaseCommands.click(createJournalMap.postButton());
        BaseCommands.click(createJournalMap.okConfirmation());
    }

    public void sendAccountDetails(String accountDetails) throws InterruptedException {
        String[] acc= BaseCommands.splitString(accountDetails);
        BaseCommands.click(createJournalMap.accountSearchIcon());
        //BaseCommands.waitForElementVisible(createJournalMap.interCompany());
        BaseCommands.sendKeys(createJournalMap.company(), acc[0]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[0]));
        BaseCommands.sendKeys(createJournalMap.profitCenter(), acc[1]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[1]));
        BaseCommands.sendKeys(createJournalMap.location(), acc[2]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[2]));
        BaseCommands.sendKeys(createJournalMap.account(), acc[3]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[3]));
        BaseCommands.sendKeys(createJournalMap.department(), acc[4]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[4]));
        BaseCommands.sendKeys(createJournalMap.brand(), acc[5]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[5]));
        BaseCommands.sendKeys(createJournalMap.interCompany(), acc[6]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[6]));
        BaseCommands.click(createJournalMap.accountSearch());
        BaseCommands.waitForElementInvisible(createJournalMap.interCompany());
        BaseCommands.click(createJournalMap.accountOk());
        BaseCommands.waitForElementInvisible(createJournalMap.accountOk());
//       Thread.sleep(2000);
    }

//ProcessJournalEntriesSTATCurrency methods
    public void journalLinesRegion(String debitAccount, String debit, String debitDesc) throws InterruptedException {

        //String[] acc= BaseCommands.splitString(debitAccount);
        sendAccountDetails(debitAccount);
        BaseCommands.click(createJournalMap.debit());
        BaseCommands.sendKeys(createJournalMap.debit(), debit);
        BaseCommands.sendKeys(createJournalMap.debitDesc(), debitDesc);
        BaseCommands.click(createJournalMap.newRow());
       // Thread.sleep(2000);
        BaseCommands.waitForVisibilityOfElement(createJournalMap.secondLine());
        BaseCommands.click(createJournalMap.secondLine());
        BaseCommands.click(createJournalMap.deleteButton());
        BaseCommands.click(createJournalMap.deleteConfirmationButton());
    }
    public void clickPostButton() throws InterruptedException {
       // Thread.sleep(2000);
        BaseCommands.waitForElementInvisible(createJournalMap.secondLine());
        BaseCommands.click(createJournalMap.postButton());
        BaseCommands.click(createJournalMap.postConfirmationButton());
        BaseCommands.click(createJournalMap.confirmationButton());
    }

//ProcessJournalEntries methods
    public void createJournal(String journalBatch, String journalBatchDescription,String AccountingPeriod,
                              String journal,String journalDescription, String Ledger, String LegalEntityName,String AccountingDate,String journalCategory,
                              String journalLegalEntityName,String Currency) throws InterruptedException {
        //BaseCommands.click(createJournal.createJournalID());
        BaseCommands.sendKeys(createJournalMap.journalBatch(),journalBatch);
        BaseCommands.click(createJournalMap.journalBatchDescription());
        BaseCommands.sendKeys(createJournalMap.journalBatchDescription(),journalBatchDescription);
        String Actual_AccountingPeriod = BaseCommands.getElementAttribute(createJournalMap.accountingPeriod(),"value");
        System.out.println("Actual_AccountingPeriod: "+Actual_AccountingPeriod);
        System.out.println("Expected_AccountingPeriod: "+AccountingPeriod);
        Assert.assertEquals(Actual_AccountingPeriod,AccountingPeriod,"Actual and expected batch accounting data aren't same. Actual is: "+Actual_AccountingPeriod+" and expected is: "+AccountingPeriod);
        BaseCommands.sendKeys(createJournalMap.journal(),journal);
        BaseCommands.sendKeys(createJournalMap.journalDescription(),journalDescription);
        String Actual_Ledger = BaseCommands.getElementAttribute(createJournalMap.ledger(),"value");
        System.out.println("Actual_Ledger: "+Actual_Ledger);
        System.out.println("Expected_Ledger: "+ Ledger);
        Assert.assertEquals(Actual_Ledger,Ledger,"Actual and expected batch accounting data aren't same. Actual is: "+Actual_Ledger+" and expected is: "+Ledger);
        //BaseCommands.sendKeys(createJournal.journalLegalEntityNameId(),LegalEntityName);
        //BaseCommands.click(createJournal.journalLegalEntityNameValueId(LegalEntityName));
        BaseCommands.scrollDown();
        String Actual_AccountingDate = BaseCommands.getElementAttribute(createJournalMap.accountingDate(),"value");
        System.out.println("Actual_AccountingPeriod: "+Actual_AccountingDate);
        System.out.println("Expected_AccountingPeriod: "+AccountingDate);
        Assert.assertEquals(Actual_AccountingPeriod,AccountingPeriod,"Actual and expected batch accounting data aren't same. Actual is: "+Actual_AccountingDate+" and expected is: "+AccountingDate);
        BaseCommands.sendKeys(createJournalMap.journalCategory(),journalCategory);
        BaseCommands.click(createJournalMap.journalCategoryValue(journalCategory));
        //BaseCommands.sendKeys(createJournal.journalLegalEntityNameId(),journalLegalEntityName);
        String Actual_Currency = BaseCommands.getElementAttribute(createJournalMap.journalCurrency(),"value");
        System.out.println("Actual_Currency: "+Actual_Currency);
        System.out.println("Expected_Currency: "+Currency);
        Assert.assertEquals(Actual_AccountingPeriod,AccountingPeriod,"Actual and expected batch accounting data aren't same. Actual is: "+Actual_AccountingDate+" and expected is: "+Currency);
        //BaseCommands.click(createJournal.journalExpandId());

    }

    public void fillJournalLines(String[] accountSubDetails, String debitValue, String creditValue, String coupaBudgeValue, int counter) throws InterruptedException {
        if (counter == 2) {
           // System.out.println(">>Adding row");
            BaseCommands.click(createJournalMap.addRow());
        }
        if (counter >= 1) {
            Thread.sleep(3000);
            if (counter == 1)
                BaseCommands.click(createJournalMap.enableJournalLinesTableRow(counter));
            else
                BaseCommands.click(createJournalMap.enableJournalLinesTableRow(counter - 1));
            Thread.sleep(3000);
        }
        BaseCommands.click(createJournalMap.accountSearchIcon());
        BaseCommands.sendKeys(createJournalMap.companyAutoPopulateTextBox(), accountSubDetails[0]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[0]));

        BaseCommands.sendKeys(createJournalMap.profitCenterAutoPopulateTextBox(), accountSubDetails[1]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[1]));

        BaseCommands.sendKeys(createJournalMap.locationAutoPopulateTextBox(), accountSubDetails[2]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[2]));

        BaseCommands.sendKeys(createJournalMap.accountAutoPopulateTextBox(), accountSubDetails[3]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[3]));

        BaseCommands.sendKeys(createJournalMap.departmentAutoPopulateTextBox(), accountSubDetails[4]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[4]));

        BaseCommands.sendKeys(createJournalMap.brandAutoPopulateTextBox(), accountSubDetails[5]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[5]));

        BaseCommands.sendKeys(createJournalMap.interCompanyAutoPopulateTextBox(), accountSubDetails[6]);
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[6]));

        BaseCommands.click(createJournalMap.okButtonOfAccount());
        int debit = Integer.parseInt(debitValue);
        if (debit != 0) {
            Thread.sleep(2000);
            BaseCommands.sendKeys(createJournalMap.debitTextBox(), debitValue);
        } else if (debit == 0){
            Thread.sleep(2000);
            BaseCommands.sendKeys(createJournalMap.creditTextBox(),creditValue);
        }

        BaseCommands.click(createJournalMap.coupaBudgeDropdown());
        BaseCommands.click(createJournalMap.searchOnDropdownList());
        BaseCommands.sendKeys(createJournalMap.valueOfSearchAndSelectCoupaScreen(),coupaBudgeValue);
        BaseCommands.click(createJournalMap.searchButtonOfSearchAndSelectCoupaScreen());
        BaseCommands.click(createJournalMap.selectValueOnSearchAndSelectCoupaScreen(coupaBudgeValue));
        BaseCommands.click(createJournalMap.okButtonOfCoupaBudge());
        BaseCommands.waitForElementInvisible(createJournalMap.okButtonOfCoupaBudge());
        //BaseCommands.click(createJournalMap.journalLine());

    }

    public void saveJournalPage() throws InterruptedException {
        BaseCommands.scrollUp();
        BaseCommands.waitForVisibilityOfElement(createJournalMap.saveButton());
        BaseCommands.click(createJournalMap.saveButton());
    }
}
