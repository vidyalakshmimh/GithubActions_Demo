package org.sherwin.maps;

import org.openqa.selenium.By;

public class GenerateAllocationsMap {



    public By genAllocationsHeader(){
        By genAllocationsHeader = By.xpath("//H1[text()='Basic Options']");
        return genAllocationsHeader;
    }

    public By genAllocationsRuleSet(){
        By genAllocationsRuleSet = By.xpath("//input[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:r1:basicReqBody:dynam1:0:nameId::content']");
        return genAllocationsRuleSet;
    }

    public By genAllocationsJournalCategory(){
        By genAllocationsJournalCategory = By.xpath("//label[text()='Journal Category']//following::input[1]");
        return genAllocationsJournalCategory;
    }

    public By genAllocationsAccPeriod(){
        By genAllocationsAccPeriod = By.xpath("//label[text()='Journal Category']//following::input[1]");
        return genAllocationsAccPeriod;
    }

    public By genAllocationsConvRateType(){
        By genAllocationsConvRateType = By.xpath("//label[text()='Conversion Rate Type']//following::input[1]");
        return genAllocationsConvRateType;
    }


    public By genAllocationsPostAllocations(){
        By genAllocationsPostAllocations = By.xpath("//label[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:r1:basicReqBody:dynam1:0:sbc1::Label1']");
        return genAllocationsPostAllocations;
    }

    public By genAllocationsSubmit(){
        By genAllocationsSubmit = By.xpath("//span[text()='m']");
        return genAllocationsSubmit;
    }

    public By genAllocationsConfirm(){
        By genAllocationsConfirm = By.cssSelector("td[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:r1:requestBtns:confirmationPopup:confirmSubmitDialog::_hce']");
        return genAllocationsConfirm;
    }

    public By genAllocationsConfirmDialogue(){
        By genAllocationsConfirmDialogue = By.xpath("//span[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:r1:requestBtns:confirmationPopup:pt_ol1']/label");
        return genAllocationsConfirmDialogue;
    }

    public By genAllocationsConfirmOKButton(){
        By genAllocationsConfirmOKButton = By.cssSelector("button[id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:r1:requestBtns:confirmationPopup:confirmSubmitDialog::ok']");
        return genAllocationsConfirmOKButton;
    }

}
