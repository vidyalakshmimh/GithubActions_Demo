package org.sherwin.maps;

import org.openqa.selenium.By;

public class ManageJournalMap {
    public By manageJournalId() {
        By manageJournalId = By.cssSelector("a[id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTRaT:0:RAtl1']");
        return manageJournalId;
    }
    public By journalBatchId() {
        By journalBatchId = By.cssSelector("input[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:ap1:queryP:value10::content']");
        return journalBatchId;
    }
    public By perioddateId() {
        By perioddateId = By.cssSelector("input[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:ap1:queryP:value20::content']");
        return perioddateId;
    }
    public By searchButtonId() {
        By searchButtonId = By.cssSelector("button[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:ap1:queryP::search']");
        return searchButtonId;
    }
    public By journallinkId() {
        By journallinkId = By.cssSelector("a[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:ap1:AT1:_ATp:t1:0:commandLink3']");
        return journallinkId;
    }
    public By attachImgId(){
        By attachImgId = By.cssSelector("img[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:2:pt1:ap1:a1:clLAdds::icon']");
        return attachImgId;
    }
    public By fileTypeId(){
        By fileTypeId = By.cssSelector("select[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:2:pt1:ap1:a1:popApplicationsTable:_ATp:popAttachmentTable:0:popDatatypeCodeChoiceListIDNew::content']");
        return fileTypeId;
    }
    public By urlfieldId(){
        By urlfieldId = By.cssSelector("input[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:2:pt1:ap1:a1:popApplicationsTable:_ATp:popAttachmentTable:0:atapnru::content']");
        return urlfieldId;
    }
    public By okButtonId() {
        By okButtonId = By.cssSelector("button[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:2:pt1:ap1:a1:dc_cb1']");
        return okButtonId;
    }

    public By urlTextId(){
        By urlTextId = By.cssSelector("a[id='pt1:_FOr1:0:_FONSr2:0:MAnt2:2:pt1:ap1:a1:iLstAtt:1:lastAttachedURL']") ;
        return urlTextId;
    }
    public By saveButton(){
        By saveButton = By.xpath("//span[text()='Save']");
        return saveButton;
    }
    public By fillJournalFromData(){
        By fillJournalFromData = By.xpath("(//input[contains(@id,'queryP:value')])[1]");
        return fillJournalFromData;
    }

    public By clearAccountingPeriod(){
        By clearAccountingPeriod = By.xpath("(//input[contains(@id,'queryP:value')])[3]");
        return clearAccountingPeriod;
    }

    public By searchBtn(){
        By searchBtn = By.xpath("//button[text()='Search']");
        return searchBtn;
    }

    public By searchResult(String Journal){
        By searchResult =By.xpath("//table[@summary='Search Results']//a[text()='"+Journal+"']");
        return searchResult;
    }


}
