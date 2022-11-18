package org.sherwin.maps;

import org.openqa.selenium.By;

public class CreateJournalMaps {

    public By journalBatch(){
        By journalbatch =By.cssSelector("input[id*='showLessBatchName']");
        return journalbatch;
    }

    public By journalBatchDescription(){
        By description = By.cssSelector("textarea[id*='showLessBatchDescription']");
        return  description;
    }

    public By accountingPeriod(){
        By accountingPeriod =By.cssSelector("input[id*='showLessPeriodNameCLOV']");
        return accountingPeriod;
    }

    public By accountingPeriodDropdown(String accountingPeriod){
        By accountingPeriodDropdown = By.xpath("//td[text()='"+accountingPeriod+"']");
        return accountingPeriodDropdown;
    }

    public By journal(){
        By journal = By.cssSelector("input[id*='showLessJournalName']");
        return journal;
    }

    public By accountingDate() {
        By accountingDateId = By.cssSelector("input[id*='ap1:DefaultEffectiveDate1::content']");
        return accountingDateId;
    }

    public By journalDescription(){
        By journalDesc = By.cssSelector("textarea[id*='showLessJournalDescription']");
        return journalDesc;
    }

    public By ledger(){
        By ledger = By.cssSelector("input[id*='showLessLedgerCLOV:sis1']");
        return ledger;
    }

    public By ledgerDropDown(String ledger)
    {
        By ledgerDropDown = By.xpath("//td[text()='"+ledger+"']");
        return ledgerDropDown;
    }

    public By legalEntityName(){
        By legalEntity = By.cssSelector("input[id*='showLessLegalEntityCLOV']");
        return legalEntity;
    }

    public By category(){

        By category = By.cssSelector("input[id*='userJeCategoryNameInputSearch1']");
        return category;
    }

    public By legalEntityNameDropDown(String legalEntity)
    {
        By legalEntityName=By.xpath("//td[text()='"+legalEntity+"']");
        return legalEntityName;
    }

    public By categoryDropDown(String category){

        By dropDowncategory = By.xpath("//td[text()='"+category+"']/parent::tr");
        return dropDowncategory;
    }

    public By currency() {
        By currency = By.cssSelector("input[id*='headerCurrencyCodeCLOV1']");
        return currency;
    }
    public By currencyValue(String currency) {
        By currencyValue = By.xpath("//td[text()='"+currency+"']");
        return currencyValue;
    }

    public By warningOk(){
        By warningOk=By.cssSelector("button[id*='ok']");
        return warningOk;
    }

    public By journalCategory(){
        //  By journalCategoryId =By.cssSelector("a[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:ap1:sis3:userJeCategoryNameInputSearch1::btn']");
        By journalCategoryId =By.cssSelector("input[id*='userJeCategoryNameInputSearch1::content']");
        return journalCategoryId;
    }

    public By journalCategoryValue(String journalCategory){
        By journalCategoryValueId = By.xpath("//td[not(text())]/span[text()='"+journalCategory+"']");
        return journalCategoryValueId;
    }

    public By journalCurrency() {
        By journalCurrencyId = By.cssSelector("input[aria-label='Currency']");
        return journalCurrencyId;
    }



    public By debit(){
        By debit = By.cssSelector("input[id*='EnteredDr']");
        return debit;
    }

    public By debitDesc(){
        By debitDesc =By.xpath("(//span[@class='x1u']//input[@type='text'])[5]");
        return debitDesc;
    }

    public By newRow(){
        By  newRow = By.xpath("//table[@summary='Journal Lines']//tr[2]/td[3]");
        return newRow;
    }

    public By secondLine(){
        By secondLine = By.xpath("//tr[@_afrrk='1']//input[@aria-label='Account']");
        return secondLine;
    }

    public By creditAmount(){
        By creditAmount = By.cssSelector("input[id*='EnteredCr']");
        return creditAmount;
    }

    public By creditDesc()
    {
        By creditDesc = By.xpath("(//span[@class='x1u']//input[@type='text'])[5]");
        return creditDesc;
    }

    public By saveButton(){
        By saveButton = By.xpath("//span[text()='Save']");
        return saveButton;
    }

    public By completeButton(){
        By completeButton =By.xpath("//span[text()='Complete']");
        return completeButton;
    }

    public By postButton(){
        By postButton = By.xpath("//span[text()='Post']");
        return postButton;
    }



    public By okConfirmation(){
        By okConfirmation = By.cssSelector("button[accesskey='K' ]");
        return okConfirmation;
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

    public By accountOk(){
        By accountOk = By.cssSelector("button[id*='accountSEl']");
        return accountOk;
    }

    public By accountSearch(){
        By accountSearch = By .cssSelector("button[id*='accountQRBT']");
        return accountSearch;
    }

        public By accountSearchIcon(){
            By accountSearchIcon = By.cssSelector("a[id*='accountKBIMG']");
            return accountSearchIcon;
        }

        public By debitTextBox(){
            By debitTextBox = By.xpath("//label[text()='Entered Debit']//preceding::input[1]");
            return debitTextBox;
        }

        public By creditTextBox(){
            By creditTextBox = By.xpath("//label[text()='Entered Credit']//preceding::input[1]");
            return creditTextBox;
        }

        //Account sub details

        public By companyAutoPopulateTextBox(){
            By companyAutoPopulateTextBox = By.cssSelector("input[aria-label='COMPANY']");
            return companyAutoPopulateTextBox;
        }

        public By profitCenterAutoPopulateTextBox(){
            By profitCenterAutoPopulateTextBox = By.cssSelector("input[aria-label='PROFIT CENTER']");
            return profitCenterAutoPopulateTextBox;
        }

        public By locationAutoPopulateTextBox(){
            By locationAutoPopulateTextBox = By.cssSelector("input[aria-label='LOCATION']");
            return locationAutoPopulateTextBox;
        }

        public By accountAutoPopulateTextBox(){
            By accountAutoPopulateTextBox = By.cssSelector("input[aria-label='ACCOUNT']");
            return accountAutoPopulateTextBox;
        }

        public By departmentAutoPopulateTextBox(){
            By departmentAutoPopulateTextBox = By.cssSelector("input[aria-label='DEPARTMENT']");
            return departmentAutoPopulateTextBox;
        }

        public By brandAutoPopulateTextBox(){
            By brandAutoPopulateTextBox = By.cssSelector("input[aria-label='BRAND']");
            return brandAutoPopulateTextBox;
        }

        public By interCompanyAutoPopulateTextBox(){
            By interCompanyAutoPopulateTextBox = By.cssSelector("input[aria-label='INTERCOMPANY']");
            return interCompanyAutoPopulateTextBox;
        }

        public By okButtonOfAccount(){
            By okButtonOfAccount = By.cssSelector("button[accesskey='k']");
            return okButtonOfAccount;
        }

        public By selectAutoPopulateValue(String value){
            By autoPopulateValue = By.xpath("//span[text()='"+value+"']");
            return autoPopulateValue;
        }

        public By coupaBudgeDropdown(){
            By coupaBudgeDropdown = By.cssSelector("a[title='Search: Coupa Budget']");
            return coupaBudgeDropdown;
        }

        public By searchOnDropdownList(){
            By searchOnDropdownList = By.xpath("//a[text()='Search...']");
            return searchOnDropdownList;
        }

        public By valueOfSearchAndSelectCoupaScreen(){
            By valueOfSearchAndSelectCoupaScreen = By.xpath("//input[normalize-space(@aria-label)='Value']");
            return valueOfSearchAndSelectCoupaScreen;
        }

        public By searchButtonOfSearchAndSelectCoupaScreen(){
            By searchButtonOfSearchAndSelectCoupaScreen = By.xpath("//button[text()='Search']");
            return searchButtonOfSearchAndSelectCoupaScreen;
        }

        public By selectValueOnSearchAndSelectCoupaScreen(String value){
            By selectValueOnSearchAndSelectCoupaScreen = By.xpath("//td[@align='left']/span[contains(text(),'"+value+"')]");
            return selectValueOnSearchAndSelectCoupaScreen;
        }

        public By okButtonOfCoupaBudge(){
            By okButtonOfCoupaBudge = By.xpath("//button[text()='OK' and contains(@id,'_FOpt')]");
            return okButtonOfCoupaBudge;
        }

        public By enableJournalLinesTableRow(int counter){
            By enableJournalLinesTableRow = By.xpath("//table[@summary='Journal Lines']//tr["+(counter+1)+"]/td[3]");
            return enableJournalLinesTableRow;
        }

        public By addRow(){
            By addRow = By.cssSelector("img[title='Add Row']");
            return addRow;
        }

//        public By saveButton(){
//            By saveButton = By.xpath("//span[text()='Save']");
//            return saveButton;
//        }

        public By journalLine(){
            By journalLine = By.xpath("//h1[text()='Journal Lines']");
            return journalLine;
        }

    public By deleteButton() {
        By deleteButton = By.xpath(" (//a//img[@title='Delete'])[2]");
        return deleteButton;
    }
    public By deleteConfirmationButton() {
        By deleteConfirmationButton = By.cssSelector("button[id*='yesLineDelete']");
        return deleteConfirmationButton;
    }

    public  By postConfirmationButton() {
        By postConfirmationButton = By.cssSelector("button[id*='userResponsePopupDialogButtonYes']");
        return postConfirmationButton;
    }
    public  By confirmationButton() {
        By confirmationButton = By.cssSelector("button[id*='userResponsePopupDialogButtonOk']");
        return confirmationButton;
    }


}
