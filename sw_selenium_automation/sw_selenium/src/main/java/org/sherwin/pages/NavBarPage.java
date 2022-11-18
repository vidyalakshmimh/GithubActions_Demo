package org.sherwin.pages;

import org.sherwin.maps.NavBarMap;
import org.sherwin.utilities.BaseCommands;
import org.sherwin.utilities.BaseTest;
import org.testng.Assert;

public class NavBarPage extends BaseTest {

    NavBarMap navbarMap= new NavBarMap();
    public void navigateToJournalsViaNavigator()  {
        BaseCommands.click(navbarMap.navigatorIcon());
        BaseCommands.click(navbarMap.navBar());
        BaseCommands.scrollIntoView(navbarMap.generalAccounting());
        BaseCommands.click(navbarMap.generalAccounting());
        BaseCommands.click(navbarMap.generalAccountingJournals());
        BaseCommands.assertTitle("Oracle Fusion Cloud Applications");
    }


}
