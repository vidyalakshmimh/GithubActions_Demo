package tests;

import org.sherwin.pages.*;
import org.sherwin.utilities.BaseCommands;
import org.sherwin.utilities.BaseTest;
import org.sherwin.utilities.ExcelDataProvider;
import org.sherwin.utilities.ReadProperty;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProcessAllocation extends BaseTest {

    private ReadProperty readProperty = new ReadProperty();
    public  final String testDataExcel=readProperty.readProperties("testDataPath");
    public final String URL = readProperty.readProperties("SWUrl");

    LoginPage loginPage=new LoginPage();
    HomePage homePage = new HomePage();
    JournalsPage journalsPage = new JournalsPage();

    GenerateAllocationsPage genAllocationsPage=new GenerateAllocationsPage();
    ScheduledProcessesPage scheduledProcessesPage=new ScheduledProcessesPage();

    ExcelDataProvider excelDataProvider = new ExcelDataProvider();

    @DataProvider(name="processAllocation")
    public  Object[][] getData() {
        String excelPath = testDataExcel+ "\\ProcessAllocation_Input.xlsx";
        Object data[][] = excelDataProvider.testData(excelPath, "Search");
        return data;
    }

    @Test(dataProvider ="processAllocation")
    public void  processAllocation(String Username, String password, String DataAcessSet, String Rule, String AccountingPeriod, String JournalCategory,String ConversionRateType) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(Username, password);
        homePage.openJournal();
        journalsPage.journals(DataAcessSet);
        journalsPage.navigateToGenAllocation();
        genAllocationsPage.fillAndSubmitGenAllBasicOptions(Rule,AccountingPeriod,JournalCategory,ConversionRateType);
        genAllocationsPage.confirmProcessAllPopUp();
        homePage.navigateToScheduledProcesses();
        scheduledProcessesPage.viewScheduledProcessPage();
        scheduledProcessesPage.viewAllGenProcessState();
        scheduledProcessesPage.viewAllGenLedgerProcessParentID();
        loginPage.logoutFromUserProfile();
    }

}
