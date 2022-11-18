package tests;

import org.sherwin.pages.*;
import org.sherwin.utilities.BaseCommands;
import org.sherwin.utilities.BaseTest;
import org.sherwin.utilities.ExcelDataProvider;
import org.sherwin.utilities.ReadProperty;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RevaluationReport extends BaseTest {

    private ReadProperty readProperty = new ReadProperty();
    public  final String testDataExcel=readProperty.readProperties("testDataPath");
    public final String URL = readProperty.readProperties("SWUrl");

    LoginPage loginPage=new LoginPage();
    HomePage homePage = new HomePage();
    JournalsPage journalsPage = new JournalsPage();

    GenerateAllocationsPage genAllocationsPage=new GenerateAllocationsPage();
    ScheduledProcessesPage scheduledProcessesPage=new ScheduledProcessesPage();

    ExcelDataProvider excelDataProvider = new ExcelDataProvider();

    ReportAnalyticsPage reportAnalyticsPage= new ReportAnalyticsPage();
    AnalyticsCatalogPage analyticsCatalogPage=new AnalyticsCatalogPage();
    ScheduleReportJobPage scheduleReportJobPage=new ScheduleReportJobPage();
    TransBusIntelligencePage transBusIntelligencePage=new TransBusIntelligencePage();
    @DataProvider(name="revaluationReport")
    public  Object[][] getData() {
        String excelPath = testDataExcel+ "\\RevaluationReport_Input.xlsx";
        Object data[][] = excelDataProvider.testData(excelPath, "Sheet1");
        return data;
    }

    @Test(dataProvider ="revaluationReport")
    public void  processAllocation(String Username, String password,String LedgerSet,String AccountingPeriod, String LedgerName, String BalancingSegment, String LedgerCurrency, String AccountLevel) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(Username, password);
        homePage.navigateToReportAndAnalytics();
        reportAnalyticsPage.browseCatalog();
        analyticsCatalogPage.viewGenLedgerReport();
        scheduleReportJobPage.fillAndSubmitRevaluationReport (LedgerSet, AccountingPeriod, LedgerName, BalancingSegment, LedgerCurrency, AccountLevel);
        scheduleReportJobPage.confirmAlertAndReturn();
        transBusIntelligencePage.navigateToSWCRevaluationReport();
        Thread.sleep(5000);
    }
}
