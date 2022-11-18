package org.sherwin.pages;
import org.openqa.selenium.StaleElementReferenceException;
import org.sherwin.maps.EditAccountPeriodMap;
import org.sherwin.utilities.BaseCommands;
import org.testng.Assert;
import static org.sherwin.utilities.BaseTest.driver;
public class EditAccountPeriodPage
{
    private static final int maxIterate=50;
    EditAccountPeriodMap Sw_EditAccPeriod=new EditAccountPeriodMap();
    public void  openPeriod() throws InterruptedException {
        BaseCommands.click(Sw_EditAccPeriod.currentAccountingPeriod());
        BaseCommands.click(Sw_EditAccPeriod.clickOut());
        Thread.sleep(2000);
        BaseCommands.mouseHover(Sw_EditAccPeriod.clickOnOpenPeriodButton());
        BaseCommands.click(Sw_EditAccPeriod.clickOnOpenPeriodButton());
    }

    public void getSuccessfulMessage() {
        BaseCommands.click(Sw_EditAccPeriod.successMessageBanner());
        String originalFullTitle=BaseCommands.getText(Sw_EditAccPeriod.successMessageBanner());
        String varID= originalFullTitle.substring(13,21);
        String[] originalTitle=originalFullTitle.split("\\.");
        String expectedTitle="Your process " +varID+ "has been submitted";
        Assert.assertEquals(originalTitle[0], expectedTitle);
        BaseCommands.addScreenShotInReport("Process Number is:-"+varID,"Temp1");
        refreshUntilStatusChange();
        String StatusResult = BaseCommands.getAttribute(Sw_EditAccPeriod.verifyStatus());
        BaseCommands.addScreenShotInReport("Status report is:"+StatusResult,"temp2");
        BaseCommands.click(Sw_EditAccPeriod.editAccountPageDoneButton());
    }

    public void refreshUntilStatusChange(){
        String previousTextValue=BaseCommands.getText(Sw_EditAccPeriod.accountingPeriodStatus());
        for(int i=0;i<=maxIterate;i++) {
            String currentTextValue = driver.findElement(Sw_EditAccPeriod.accountingPeriodStatus()).getText();
            if (previousTextValue.equalsIgnoreCase(currentTextValue)) {
                try {
                    driver.findElement(Sw_EditAccPeriod.refreshButton()).click();
                    i++;
                    Thread.sleep(1000);
                }
                catch (StaleElementReferenceException e)
                {
                    BaseCommands.refresh();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                break;
            }
        }
    }
}