package org.sherwin.maps;

import org.openqa.selenium.By;

public class JournalsMap {
    public By changeId() {
        By changeId = By.cssSelector("a[id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr2:0:cl1']");
        return changeId;
    }
    public By dataAcessSetId() {
        By dataAcessSetId = By.cssSelector("select[id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr2:0:soc1::content']");
        return dataAcessSetId;
    }
    public By clickOkId() {
        By clickOkId = By.cssSelector("button[id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr2:0:d1::ok']");
        return clickOkId;
    }
    public By taskIconId() {
        By taskIconId = By.cssSelector("a[id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsdi_JournalEntryPage_itemNode_FndTasksList::disAcr']>img");
        return taskIconId;
    }
    public By genAllocations(){
        By genAllocations = By.cssSelector("a[id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTRaT:0:RAtl12']");
        return genAllocations;
    }

    public By changeDataAccessSet(){
        By changeDataAccessSet = By.xpath("//a[text()='Change']");
        return changeDataAccessSet;
    }
    public By dataAccessSet(){
        By dataAccessSet = By.cssSelector("select.x2h");
        return dataAccessSet;
    }
    public By dataAccessSetOk(){
        By dataAccessSet = By.cssSelector("button[id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr2:0:d1::ok']");
        return dataAccessSet;
    }
    public By task(){
        By task = By.cssSelector("img[title='Tasks']");
        return task;
    }
    public By manageJournal(){
        By createJournal = By.xpath("//a[text()='Manage Journals']");
        return createJournal;
    }
    public By createJournal() {
        By createJournalID = By.xpath("//a[text()='Create Journal']");
        return createJournalID;
    }

    public By resizePaneButton(){
        By resizePaneButton =By.cssSelector("a[id*='UIMsplitter']");
        return resizePaneButton;
    }

}
