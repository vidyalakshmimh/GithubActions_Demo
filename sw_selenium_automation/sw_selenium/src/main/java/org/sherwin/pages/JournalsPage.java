package org.sherwin.pages;


import org.sherwin.maps.JournalsMap;
import org.sherwin.utilities.BaseCommands;

import static org.sherwin.utilities.BaseTest.driver;

public class JournalsPage {
    JournalsMap journalsmap = new JournalsMap();
    public void journals(String DataAcessSet){
        BaseCommands.click(journalsmap.changeId());
        BaseCommands.dropDownSelectByText(journalsmap.dataAcessSetId(),DataAcessSet);
        BaseCommands.click(journalsmap.clickOkId());
        BaseCommands.refresh();
        BaseCommands.click(journalsmap.taskIconId());
    }

    public void navigateToGenAllocation(){
        BaseCommands.click(journalsmap.genAllocations());
    }


    public void changeDataAccessSet(String SelectDataAccessSet){
        BaseCommands.click(journalsmap.changeDataAccessSet());
        BaseCommands.waitForElement(journalsmap.dataAccessSet());
        BaseCommands.dropDownSelectByText(journalsmap.dataAccessSet(),SelectDataAccessSet);
        BaseCommands.click(journalsmap.dataAccessSetOk());
    }

    public void navigateToManageJournal()
    {
        BaseCommands.refresh();
        BaseCommands.click(journalsmap.task());
        BaseCommands.click(journalsmap.manageJournal());
    }

    public void navigateToCreateJournal()
    {
        BaseCommands.refresh();
        BaseCommands.click(journalsmap.task());
        BaseCommands.click(journalsmap.createJournal());
        BaseCommands.click(journalsmap.resizePaneButton());
    }

}
