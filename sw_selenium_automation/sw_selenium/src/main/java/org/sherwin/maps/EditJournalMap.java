package org.sherwin.maps;

import org.openqa.selenium.By;

public class EditJournalMap
{
   public By addJournalWithPlusIcon()
   {
       By addJournalWithPlusIcon= By.xpath("//a[@title='Add']");
       return addJournalWithPlusIcon;
   }
    public By addJournal()
    {
        By addJournal= By.xpath("//input[contains(@id,'showLessJournalName')]");
        return addJournal;
    }
    public By addDescription()
    {
        By addDescription=By.xpath("//textarea[contains(@id,'showLessJournalDescription')]");
        return addDescription;
    }
    public By addLedger()
    {
        By addLedger=By.xpath("//input[contains(@id,'showLessLedgerCLOV')]");
        return addLedger;
    }
    public By selectLedger(String Ledger)
    {
        By selectLedger=By.xpath("//table[contains(@id,'showLessLedgerCLOV')]//td[text()='"+Ledger+"']");
        return selectLedger;
    }
    public By okBtnFromWarningMessage()
    {
        By okBtnFromWarningMessage=By.xpath("(//button[text()='OK'])[1]");
        return okBtnFromWarningMessage;
    }
    public By addAccountingDate() {
        By addAccountingDate = By.xpath("//input[contains(@id,'DefaultEffectiveDate1')]");
        return addAccountingDate;
    }
    public By addCategory() {
        By addCategory = By.xpath("//input[contains(@id,'userJeCategoryNameInputSearch1')]");
        return addCategory;
    }
    public By journalLine1() {
        By clickJournalLine1 = By.xpath("(//table[@summary='Journal Lines']//span[@class='x1a'])[1]");
        return clickJournalLine1;
    }
    public By accountIcon(){
        By accIcon=By.cssSelector("a[id*='accountKBIMG']");
        return accIcon;
    }


    public By company(){
        By company = By.xpath("//input[@aria-label='COMPANY']");
        return company;
    }

    public By profitCenter(){
        By profitCenter = By.xpath("//input[@aria-label='PROFIT CENTER']");
        return profitCenter;
    }

    public By location(){
        By location = By.xpath("//input[@aria-label='LOCATION']");
        return location;
    }

    public By account(){
        By account = By.xpath("//input[@aria-label='ACCOUNT']");
        return account;
    }

    public By department(){
        By department = By.xpath("//input[@aria-label='DEPARTMENT']");
        return department;
    }

    public By brand(){
        By brand = By.xpath("//input[@aria-label='BRAND']");
        return brand;
    }

    public By interCompany(){
        By interCompany = By.xpath("//input[@aria-label='INTERCOMPANY']");
        return interCompany;
    }
    public By accountOkBtn() {
        By accountOkBtn = By.xpath("//button[text()='O']");
        return accountOkBtn;
    }
//    public By accountOkBtn(){
//        By accountOk = By.cssSelector("button[id*='accountSEl']");
//        return accountOk;
//    }
    public By accountSearch(){
        By accountSearch = By .cssSelector("button[id*='accountQRBT']");
        return accountSearch;
    }
    public By selectAutoPopulateValue(String value){
        By autoPopulateValue = By.xpath("//span[text()='"+value+"']");
        return autoPopulateValue;
    }
    public By debitAmount() {
        By debitAmount = By.xpath("(//input[contains(@id,'jeLineAppTable')])[2]");
        return debitAmount;
    }
    public By debitDescription() {
        By debitDescription = By.xpath("(//input[contains(@id,'jeLineAppTable')])[5]");
        return debitDescription;
    }
    public By journalLine2() {
        By clickJournalLine2 = By.xpath("(//table[@summary='Journal Lines']//span[@class='x1a'])[2]");
        return clickJournalLine2;
    }
    public By fillAccountDetailsJournalLine2() {
        By fillAccountDetailsJournalLine2 = By.xpath("(//table[@summary='Journal Lines']//span[@class='x1a'])[2]//input[@type='text']");
        return fillAccountDetailsJournalLine2;
    }
    public By creditAmount() {
        By creditAmount = By.xpath("(//table[@summary='Journal Lines']//input[@class='x25'])[3]");
        return creditAmount;
    }
    public By creditDescription() {
        By creditDescription = By.xpath("(//table[@summary='Journal Lines']//input[@class='x25'])[5]");
        return creditDescription;
    }
    public By postJournal() {
        By postJournal = By.xpath("//span[text()='Post']");
        return postJournal;
    }
    public By yesBtn() {
        By yesBtn = By.xpath("//span[text()='Y']");
        return yesBtn;
    }
    public By getConformationMessage()
    {
        By getConformationMessage=By.xpath("(//td[contains(@id,'contentContainer')])[2]");
        return getConformationMessage;
    }
    public By okBtnConformation() {
        By okBtnConformation = By.xpath("//button[text()='O']");
        return okBtnConformation;
    }
}
