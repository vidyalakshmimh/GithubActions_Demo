package org.sherwin.pages;

import org.sherwin.maps.LoginMap;
import org.sherwin.utilities.BaseCommands;

public class LoginPage {
    LoginMap loginmap=new LoginMap();

    public void loginToGL(String Username, String password){
        BaseCommands.sendKeys(loginmap.userId(),Username);
        BaseCommands.sendKeys(loginmap.pwd(),password);
        BaseCommands.click(loginmap.submitButton());
    }
    public void logoutFromUserProfile()
    {
        BaseCommands.click(loginmap.clickOnUserProfile());
        BaseCommands.click(loginmap.clickOnSignOut());
    }

}

