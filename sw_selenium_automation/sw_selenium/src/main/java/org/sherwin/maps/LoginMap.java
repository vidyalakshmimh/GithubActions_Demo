package org.sherwin.maps;

import org.openqa.selenium.By;

public class LoginMap {
    public By userId(){
        By userId = By.cssSelector("#userid");
        return userId;
    }
    public By pwd(){
        By pwd = By.cssSelector("#password");
        return pwd;
    }
    public By submitButton(){
        By submitButton = By.cssSelector("#btnActive");
        return submitButton;
    }

    public By clickOnUserProfile()
    {
        By clickOnUserProfile= By.xpath("//a[@title='Settings and Actions']");
        return clickOnUserProfile;
    }
    public By clickOnSignOut()
    {
        By clickOnSignOut=By.xpath("//a[text()='Sign Out']");
        return clickOnSignOut;
    }


}
