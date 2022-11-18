package org.sherwin.pages;

import org.sherwin.maps.ReportAnalyticsMap;
import org.sherwin.utilities.BaseCommands;

public class ReportAnalyticsPage {
    ReportAnalyticsMap reportAnalyticsMap=new ReportAnalyticsMap();
    public void browseCatalog() {
        BaseCommands.click(reportAnalyticsMap.browseCatalog());
        BaseCommands.switchToNewWindow();
    }
}
