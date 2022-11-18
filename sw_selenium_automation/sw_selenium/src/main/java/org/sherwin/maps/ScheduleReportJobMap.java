package org.sherwin.maps;

import org.openqa.selenium.By;

public class ScheduleReportJobMap {

    public By scheduleReportJobIframe()
    {
        By scheduleReportJobIframe= By.xpath("//*[contains(@id,'generalObjectEditor')]");
        return scheduleReportJobIframe;
    }
    public By scheduleReportGenIframe()
    {
        By scheduleReportGenIframe= By.cssSelector("iframe[title='Report Parameters']");
        return scheduleReportGenIframe;
    }
    public By scheduleReportLedgerSetDropdown(){
        By scheduleReportLedgerSetDropdown= By.xpath("//div[contains(@id,'_LEDGER_SET')]");
        return scheduleReportLedgerSetDropdown;
    }
    public By scheduleReportLedgerSet(String LedgerSet){
        By ledgerSet= By.xpath("//div[contains(text(),'"+LedgerSet+"')]");
        return ledgerSet;
    }
    public By scheduleReportLedg(){
        By ledgerSet= By.xpath("(//span[text()='Ledger Set']//following::input)[1]");
        return ledgerSet;
    }


    public By scheduleReportAccPeriodDropdown(){
        By scheduleReportAccPeriodDropdown= By.xpath("//div[contains(@id,'_PERIOD_NAME')]");
        return scheduleReportAccPeriodDropdown;
    }
    public By scheduleReportAccPeriod(String AccountingPeriod){
        By scheduleReportAccPeriod= By.xpath("//div[contains(text(),'"+AccountingPeriod+"')]");
        return scheduleReportAccPeriod;
    }
    public By scheduleReportLedgerNameDropdown(){
        By scheduleReportLedgerNameDropdown= By.xpath("//div[contains(@id,'LEDGER_NAME')]");
        return scheduleReportLedgerNameDropdown;
    }
    public By scheduleReportLedgerName(String LedgerName){
        By scheduleReportAccPeriod= By.xpath("//div[contains(text(),'"+LedgerName+"')]");
        return scheduleReportAccPeriod;
    }
    public By scheduleReportBalSegmentDropdown(){
        By scheduleReportBalSegmentDropdown= By.xpath("//div[contains(@id,'_BALANCING_SEGMENT')]");
        return scheduleReportBalSegmentDropdown;
    }
    public By scheduleReportBalancingSegment(String BalancingSegment){
        By scheduleReportAccPeriod= By.xpath("//div[contains(text(),'"+BalancingSegment+"')]");
        return scheduleReportAccPeriod;
    }
    public By scheduleReportLedgerCurrencyDropdown(){
        By scheduleReportLedgerCurrencyDropdown= By.xpath("//div[contains(@id,'_CURRENCY')]");
        return scheduleReportLedgerCurrencyDropdown;
    }
    public By scheduleReportLedgerCurrency(String LedgerCurrency){
        By scheduleReportLedgerCurrency= By.xpath("//div[(text()='"+LedgerCurrency+"')]");
        return scheduleReportLedgerCurrency;
    }
    public By scheduleReportAccLevelDropdown(){
        By scheduleReportAccLevelDropdown= By.xpath("//div[contains(@id,'_Account_Level')]");
        return scheduleReportAccLevelDropdown;
    }
    public By scheduleReportAccLevel(String AccountLevel){
        By scheduleReportAccLevel= By.xpath("//div[contains(text(),'"+AccountLevel+"')]");
        return scheduleReportAccLevel;
    }

    public By scheduleReportSubmitBtn(){
        By scheduleReportSubmitBtn= By.cssSelector("button#submitButton");
        return scheduleReportSubmitBtn;
    }

    public By scheduleReportVerifyOKBtn(){
        By scheduleReportVerifyOKBtn= By.cssSelector("button#submitDiv_button");
        return scheduleReportVerifyOKBtn;
    }
    public By scheduleReportJobName(){
        By scheduleReportJobName= By.cssSelector("input#submitDiv_submitJobName");
        return scheduleReportJobName;
    }
    public By scheduleReportVerifyParams(String LedgerSet, String LedgerName, String LedgerCurrency, String AccountingPeriod, String AccountLevel, String BalancingSegment){
        By scheduleReportVerifyParams= By.xpath("//*[contains(text(), '\"Ledger Set\":\""+LedgerSet+"\", \"Ledger Name\":\""+LedgerName+"\", \"Ledger Currency\":\""+LedgerCurrency+"\", \"Accounting Period\":\""+AccountingPeriod+"\", \"Balancing Segment\":\""+BalancingSegment+"\", \"Account Level\":\""+AccountLevel+"\"')]");
        return scheduleReportVerifyParams;
    }

    public By scheduleReportReturn(){
        By scheduleReportReturn= By.xpath("//button[text()='Return']");
        return scheduleReportReturn;
    }


}
