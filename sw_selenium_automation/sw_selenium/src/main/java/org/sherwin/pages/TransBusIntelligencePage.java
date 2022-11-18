package org.sherwin.pages;

import org.sherwin.maps.TransBusIntelligenceMap;
import org.sherwin.utilities.BaseCommands;

public class TransBusIntelligencePage {
    TransBusIntelligenceMap transBusIntelligenceMap=new TransBusIntelligenceMap();

    public void navigateToSWCRevaluationReport(){
        BaseCommands.click(transBusIntelligenceMap.SWCTrialBalReport());
        BaseCommands.click(transBusIntelligenceMap.SWCTrialBalReportMore());
        BaseCommands.click(transBusIntelligenceMap.SWCTrialBalReportMoreHistory());
    }
}
