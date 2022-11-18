package tests;

import org.sherwin.pages.*;
import org.sherwin.utilities.*;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class CloudGL extends BaseTest {
    private ReadProperty readProperty = new ReadProperty();
    public final String URL = readProperty.readProperties("SWUrl");
    public final String testDataExcel = readProperty.readProperties("testDataPath");
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ExcelDataProvider excelDataProvider = new ExcelDataProvider();
    PeriodClosePage periodClosePage = new PeriodClosePage();
    ManageAccountingPeriodsPage manageAccountingPeriodsPage = new ManageAccountingPeriodsPage();
    EditAccountPeriodPage editAccountPeriodPage = new EditAccountPeriodPage();
    NavBarPage navBarPage=new NavBarPage();
    JournalsPage journalsPage = new JournalsPage();
    ManageJournalPage manageJournalPage = new ManageJournalPage();
    GenerateAllocationsPage genAllocationsPage=new GenerateAllocationsPage();
    ScheduledProcessesPage scheduledProcessesPage=new ScheduledProcessesPage();
    EditJournalPage editJournal=new EditJournalPage();
    CreateJournalsPage createJournalsPage=new CreateJournalsPage();
    Random random = new Random();
    int randomNumber=random.nextInt(200);

    //open period test Data Provider method to get data from excel
    @DataProvider(name = "openPeriodTest")
    public Object[][] openPeriodTest() {
        Map<Integer, Map<String, String>> openPeriodTestData = excelDataProvider.excelDataMap(testDataExcel+ "\\OpenPeriodTestData.xlsx", "UserData");
        return new Object[][] {{openPeriodTestData}};
    }

    //openPeriodTest Test Method
    @Test(dataProvider = "openPeriodTest")
    public void OpenPeriod(Map<Integer, Map<String, String>> openPeriodData) throws Exception {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(openPeriodData.get(1).get("Username"),openPeriodData.get(1).get("password"));
        homePage.navigateToPeriodCloseFromHomePage();
        periodClosePage.changeDataAccessInPeriodPage(openPeriodData.get(1).get("dataAccessSet"));
        periodClosePage.navigateToMenageAccountPeriod();
        manageAccountingPeriodsPage.clickOnLedgerToModify(openPeriodData.get(1).get("ledgerName"));
        editAccountPeriodPage.openPeriod();
        editAccountPeriodPage.getSuccessfulMessage();
        loginPage.logoutFromUserProfile();
    }

    //add journal entry within same JE batch Data Provider method to get data from excel
    @DataProvider(name="AddJournalEntryWithinSameJEBatch")
    public  Object[][] addJournalEntryWithinSameJEBatch() {
        Map<Integer, Map<String, String>> addJournalEntryTestData = excelDataProvider.excelDataMap(testDataExcel+ "\\AddJournalEntryWithinSameJEBatch_TestData.xlsx", "JournalDetails");
        return new Object[][] {{addJournalEntryTestData}};
    }

    //AddJournalEntryWithinSameJEBatch Test Method
    @Test(dataProvider ="AddJournalEntryWithinSameJEBatch")
    public void  addJournalEntryWithinSameJEBatch(Map<Integer, Map<String, String>> journalEntryData) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(journalEntryData.get(1).get("Username"),journalEntryData.get(1).get("password"));
        navBarPage.navigateToJournalsViaNavigator();
        journalsPage.changeDataAccessSet(journalEntryData.get(1).get("DataAccessSet"));
        journalsPage.navigateToManageJournal();
        manageJournalPage.navigateManageJournalPage(journalEntryData.get(1).get("Journal"),journalEntryData.get(1).get("AccountingPeriod"));
        editJournal.addNewJournal();
        editJournal.fillJournalDetails(journalEntryData.get(1).get("JournalAdd"),journalEntryData.get(1).get("JournalDescription"),journalEntryData.get(1).get("Ledger"),journalEntryData.get(1).get("AccountingDate"),journalEntryData.get(1).get("Category"));
        editJournal.fillJournalLineDetails(journalEntryData.get(1).get("DebitAccount"),journalEntryData.get(1).get("DebitAmount"),journalEntryData.get(1).get("DebitDescription"),journalEntryData.get(1).get("CreditAccount"),journalEntryData.get(1).get("CreditAmount"),journalEntryData.get(1).get("CreditDescription"));
        loginPage.logoutFromUserProfile();
    }

    //journal entries add attachment Data Provider method to get data from excel
    @DataProvider(name = "JournalEntries_AddAttachment")
    public Object[][] JournalEntries_AddAttachment() {
        Map<Integer, Map<String, String>> journalEntries_AddAttachmentData = excelDataProvider.excelDataMap(testDataExcel+ "\\JournalEntries_AddAttachment.xlsx", "Sheet1");
        return new Object[][] {{journalEntries_AddAttachmentData}};
    }

    //JournalEntries_AddAttachment Test Method
    @Test(dataProvider = "JournalEntries_AddAttachment")
    public void JournalEntries_AddAttachment(Map<Integer, Map<String, String>> journalEntriesData) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(journalEntriesData.get(1).get("Username"),journalEntriesData.get(1).get("password"));
        homePage.openJournal();
        journalsPage.journals(journalEntriesData.get(1).get("DataAcessSet"));
        journalsPage.navigateToManageJournal();
        manageJournalPage.manageJournal(journalEntriesData.get(1).get("JournalBatch"), journalEntriesData.get(1).get("Path"));    }

    //process journal entries manual adjustment Data Provider method to get data from excel
    @DataProvider(name = "processJournalEntries_ManualAdjustment")
    public Object[][] processJournalEntries_ManualAdjustment() {
        Map<Integer, Map<String, String>>manualAdjustmentSheet1Data = excelDataProvider.excelDataMap(testDataExcel+"\\ProcessJournalEntriesManualAdjustment.xlsx","Sheet1");
        Map<Integer, Map<String, String>> manualAdjustmentSheet2Data = excelDataProvider.excelDataMap(testDataExcel+"\\ProcessJournalEntriesManualAdjustment.xlsx","Sheet2");
        return new Object[][] {{manualAdjustmentSheet1Data,manualAdjustmentSheet2Data}};
    }

    //processJournalEntries_ManualAdjustment Test Method
    @Test(dataProvider = "processJournalEntries_ManualAdjustment")
    public void processJournalEntries_ManualAdjustmentSheet(Map<Integer, Map<String, String>> sheet1Data,Map<Integer, Map<String, String>> sheet2Data) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(sheet1Data.get(1).get("Username"),sheet1Data.get(1).get("password"));
        homePage.openJournal();
        journalsPage.journals(sheet1Data.get(1).get("DataAccessSet"));
        journalsPage.navigateToCreateJournal();
        createJournalsPage.createJournal(sheet1Data.get(1).get("JournalBatch")+"_"+randomNumber, sheet1Data.get(1).get("JournalBatchDescription"),sheet1Data.get(1).get("AccountingPeriod"),
                sheet1Data.get(1).get("Journal"),sheet1Data.get(1).get("JournalDescription"),sheet1Data.get(1).get("Ledger"),sheet1Data.get(1).get("LegalEntityName"),sheet1Data.get(1).get("AccountingDate"),sheet1Data.get(1).get("Category"),
                sheet1Data.get(1).get("LegalEntityName"), sheet1Data.get(1).get("Currency"));
        for(int i=0;i<sheet2Data.size()-1;i++){
            String account = sheet2Data.get(i+1).get("Account").toString();
            String[] accountSubDetails = account.split("\\.");
            createJournalsPage.fillJournalLines(accountSubDetails, sheet2Data.get(i+1).get("Debit Value"), sheet2Data.get(i+1).get("Credit Value"), sheet2Data.get(i+1).get("Coupa Budget"),i );
        }
        createJournalsPage.saveJournalPage();
        loginPage.logoutFromUserProfile();
    }

    //process Allocation Data Provider method to get data from excel
    @DataProvider(name="processAllocation")
    public  Object[][] getDataProcessAllocation() {
        Map<Integer, Map<String, String>> processAllocationData = excelDataProvider.excelDataMap(testDataExcel+ "\\ProcessAllocation_Input.xlsx","Search");
        return new Object[][] {{processAllocationData}};
    }

    //process Allocation Test Method
    @Test(dataProvider ="processAllocation")
    public void processAllocation(Map<Integer, Map<String, String>> data) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(data.get(1).get("Username"),data.get(1).get("password"));
        homePage.openJournal();
        journalsPage.journals(data.get(1).get("DataAccessSet"));
        journalsPage.navigateToGenAllocation();
        genAllocationsPage.fillAndSubmitGenAllBasicOptions(data.get(1).get("Rule"),data.get(1).get("AccountingPeriod"),data.get(1).get("JournalCategory"),data.get(1).get("ConversionRateType"));
        genAllocationsPage.confirmProcessAllPopUp();
        homePage.navigateToScheduledProcesses();
        scheduledProcessesPage.viewScheduledProcessPage();
        scheduledProcessesPage.viewAllGenProcessState();
        scheduledProcessesPage.viewAllGenLedgerProcessParentID();
        loginPage.logoutFromUserProfile();
    }

    //processJournalEntriesAccural Data Provider method to get data from excel
    @DataProvider(name = "processJournalEntriesAccural")
    public Object[][] processJournalEntriesAccural() {
        Map<Integer, Map<String, String>> processJournalEntriesAccuralData = excelDataProvider.excelDataMap(testDataExcel+ "\\ProcessJournalEntriesAccrual.xlsx","Headers");
        return new Object[][] {{processJournalEntriesAccuralData}};
    }

    //processJournalEntriesAccural Test Method
    @Test(dataProvider = "processJournalEntriesAccural")
    public void processJournalEntriesAccural(Map<Integer, Map<String, String>> processExcelHeaderData) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(processExcelHeaderData.get(1).get("Username"),processExcelHeaderData.get(1).get("password"));
        homePage.openJournal();
        journalsPage.journals(processExcelHeaderData.get(1).get("DataSet"));
        journalsPage.navigateToCreateJournal();
        createJournalsPage.sendJournalBatchData(processExcelHeaderData.get(1).get("JournalBatch")+"_"+randomNumber,processExcelHeaderData.get(1).get("BatchDescription"),processExcelHeaderData.get(1).get("AccountingPeriod(Optional)"));
        createJournalsPage.sendjournalData(processExcelHeaderData.get(1).get("Journal")+"_"+randomNumber,processExcelHeaderData.get(1).get("JournalDescription"),processExcelHeaderData.get(1).get("ledger"),processExcelHeaderData.get(1).get("LegalEntityName"),processExcelHeaderData.get(1).get("Category"),processExcelHeaderData.get(1).get("Currency(optional)"));
        createJournalsPage.sendJournalLinesData(processExcelHeaderData.get(1).get("DebitAccount"),processExcelHeaderData.get(1).get("DebitAmount"),processExcelHeaderData.get(1).get("DebitDescription"), processExcelHeaderData.get(1).get("CreditAccount"),  processExcelHeaderData.get(1).get("CreditAmount"), processExcelHeaderData.get(1).get("CreditDescription"),processExcelHeaderData.get(1).get("Category"));
        loginPage.logoutFromUserProfile();
    }

    //processJournalEntriesSTATCurrency Data Provider method to get data from excel
    @DataProvider(name = "processJournalEntriesSTATCurrency")
    public Object[][] processJournalEntriesSTATCurrency() {
        Map<Integer, Map<String, String>> processJournalEntriesSTATCurrencyData = excelDataProvider.excelDataMap(testDataExcel+"\\processJournalEntriesSTATCurrency.xlsx","Headers");
        return new Object[][] {{processJournalEntriesSTATCurrencyData}};
    }

    //processJournalEntriesSTATCurrency Test Method
    @Test(dataProvider = "processJournalEntriesSTATCurrency")
    public void processJournalEntriesSTATCurrency(Map<Integer, Map<String, String>> processCurrencyHeaderData) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(processCurrencyHeaderData.get(1).get("Username"),processCurrencyHeaderData.get(1).get("password"));
        homePage.openJournal();
        journalsPage.journals(processCurrencyHeaderData.get(1).get("DataAccessSet"));
        journalsPage.navigateToCreateJournal();
        createJournalsPage.sendJournalBatchData(processCurrencyHeaderData.get(1).get("journalBatch")+"_"+randomNumber, processCurrencyHeaderData.get(1).get("journalBatchDescription"), processCurrencyHeaderData.get(1).get("accountingPeriod"));
        createJournalsPage.sendjournalData(processCurrencyHeaderData.get(1).get("journal")+"_"+randomNumber, processCurrencyHeaderData.get(1).get("journalDescription"), processCurrencyHeaderData.get(1).get("ledger"), processCurrencyHeaderData.get(1).get("legalEntity"), processCurrencyHeaderData.get(1).get("category"), processCurrencyHeaderData.get(1).get("currency"));
        createJournalsPage.journalLinesRegion(processCurrencyHeaderData.get(1).get("debitAccount"), processCurrencyHeaderData.get(1).get("debit"), processCurrencyHeaderData.get(1).get("debitDescription"));
        createJournalsPage.clickPostButton();
        loginPage.logoutFromUserProfile();
    }
}

