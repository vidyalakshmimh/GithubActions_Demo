package org.sherwin.maps;

import org.openqa.selenium.By;

public class NavBarMap {


    public By navigatorIcon(){
        By navigatorIcon = By.cssSelector("a[title='Navigator']");
        return navigatorIcon;
    }
    public By navBar(){
        By navigatorIcon = By.cssSelector("div[class='x3bn x1a']");
        return navigatorIcon;
    }

    public By generalAccounting(){
        By navigatorIcon = By.cssSelector("div[title='General Accounting']");
        return navigatorIcon;
    }

    public By generalAccountingPeriodClose(){
        By navigatorIcon = By.xpath("//a[@title='Period Close']");
        return navigatorIcon;
    }

    public By generalAccountingJournals(){
        By navigatorIcon = By.xpath("//span[text()='Journals']");
        return navigatorIcon;
    }

}
