package tests;

import org.sherwin.pages.*;
import org.sherwin.utilities.BaseCommands;
import org.sherwin.utilities.BaseTest;
import org.sherwin.utilities.ExcelDataProvider;
import org.sherwin.utilities.ReadProperty;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunTrialBalanceReport extends BaseTest{
    private static ReadProperty readProperty = new ReadProperty();
    public static final String testDataExcel=readProperty.readProperties("testDataPath");
    public static final String URL = readProperty.readProperties("SWUrl");

    static LoginPage loginPage=new LoginPage();
    static HomePage homePage = new HomePage();
    ScheduledProcessesPage scheduledProcessesPage=new ScheduledProcessesPage();

    static ExcelDataProvider excelDataProvider = new ExcelDataProvider();

    @DataProvider(name="runTrailBalanceReport")
    public  Object[][] getData() {
        String excelPath = testDataExcel+ "\\RunTrialBalanceReport_Input.xlsx";
        Object data[][] = excelDataProvider.testData(excelPath, "Data");
        return data;
    }

    @Test(dataProvider ="runTrailBalanceReport")
    public void  runTrailBalanceReport(String Username, String password, String Name,String DataAccessSet,String Ledger,String LedgerCurrency,String CurrencyType, String AccountingPeriod,String AmountType, String SummarizeBy, String Format) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(Username, password);
        homePage.navigateToScheduledProcesses();
        scheduledProcessesPage.scheduleNewProcesses(Name);
        scheduledProcessesPage.fillScheduleNewProcessDetails(DataAccessSet,Ledger,LedgerCurrency,CurrencyType,AccountingPeriod,AmountType,SummarizeBy);
        scheduledProcessesPage.scheduleNewProcessedAdvanced(Format);
        scheduledProcessesPage.scheduleNewProcessSubmit();
        scheduledProcessesPage.viewTrialBalanceReportStatus();
        scheduledProcessesPage.downloadTrialBalanceReport();
        loginPage.logoutFromUserProfile();
    }
}
